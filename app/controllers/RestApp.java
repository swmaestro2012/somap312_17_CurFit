package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Calendar;
import java.util.List;

import models.Look;
import models.UserLook;

import org.json.JSONException;
import org.json.JSONObject;

import play.Logger;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http.RequestBody;
import play.mvc.Result;
import so.tree.imageQueue.ImageSender;

public class RestApp extends Controller {
	
	private static String LOCAL_IMAGE_PATH = System.getProperty("user.dir") + "/public/lookImages/";
	private static String AMAZON_S3_PATH = "https://s3-ap-northeast-1.amazonaws.com/swmaestro/";
	static JSONObject jsonObject;

	public static Result getLooks(String year, String season, String lookType) throws JSONException {
		List<Look> looks;
		if(year == null && season == null && lookType == null){
			looks = Look.find.all();
		}else if(year != null && season == null && lookType == null){
			looks = Look.find.where().ilike("year", year).findList();
		}else if(year == null && season != null && lookType == null){
			looks = Look.find.where().ilike("season", season).findList();
		}else if(year == null && season == null && lookType != null){
			looks = Look.find.where().ilike("lookType", lookType).findList();
		}else if(year != null && season != null && lookType == null){
			looks = Look.find.where().ilike("year", year).ilike("season", season).findList();
		}else if(year != null && season == null && lookType != null){
			looks = Look.find.where().ilike("year", year).ilike("lookType", lookType).findList();
		}else if(year == null && season != null && lookType != null){
			looks = Look.find.where().ilike("season", season).ilike("lookType", lookType).findList();
		}else{
			looks = Look.find.where().ilike("year", year).ilike("season", season).ilike("lookType", lookType).findList();
		}
		if (looks.size() == 0) {
			jsonObject = new JSONObject();
			jsonObject.put("code", 2);
			jsonObject.put("msg", "Looks are empty.");
			return ok(jsonObject.toString()).as("application/json");
		}
		
		
		return ok(Json.toJson(looks)).as("application/json");
	}

	public static Result getLookById(Long id) throws JSONException {

		Look look = Look.find.byId(id);
		if (look == null) {
			Logger.error("[code: -3] Can't find look.");
			jsonObject = new JSONObject();
			jsonObject.put("code", -3);
			jsonObject.put("msg", "Can't find look.");
			return ok(jsonObject.toString()).as("application/json");
		}
		return ok(Json.toJson(look)).as("application/json");
	}

	public static Result getAllUserLooksByLookId(Long id) throws JSONException {

		Look look = Look.find.byId(id);
		if (look == null) {
			Logger.error("[code: -3] Can't find look.");
			jsonObject = new JSONObject();
			jsonObject.put("code", -3);
			jsonObject.put("msg", "Can't find look.");
			return ok(jsonObject.toString()).as("application/json");
		}
		if (look.getUserLooks().size() == 0) {
			jsonObject = new JSONObject();
			jsonObject.put("code", 2);
			jsonObject.put("msg", "UserLooks are empty.");
			return ok(jsonObject.toString()).as("application/json");
		}
		return ok(Json.toJson(look.getUserLooks())).as("application/json");
	}

	public static Result getUserLookById(Long id) throws JSONException {

		UserLook userLook = UserLook.find.byId(id);
		if (userLook == null) {
			Logger.error("[code: -4] Can't find UserLook.");
			jsonObject = new JSONObject();
			jsonObject.put("code", -4);
			jsonObject.put("msg", "Can't find UserLook.");
			return ok(jsonObject.toString()).as("application/json");
		}

		if(userLook.getImageFileName().substring(0, 3).equals("S3_")){
			userLook.setImageFileName(AMAZON_S3_PATH + userLook.getImageFileName().substring(3));
		}else{
			userLook.setImageFileName(LOCAL_IMAGE_PATH + userLook.getImageFileName());
		}
		
		return ok(Json.toJson(userLook));
	}

	public static Result saveUserLook() throws JSONException {

		Form<UserLook> form = new Form<UserLook>(UserLook.class)
				.bindFromRequest();

		jsonObject = new JSONObject();
		
		try{
			Long lookId = Long.parseLong(request().body().asMultipartFormData().asFormUrlEncoded().get("lookId")[0]);
			Look look = Look.find.byId(lookId);
			if (look == null) {
				Logger.error("[code: -3] Can't find look.");
				jsonObject = new JSONObject();
				jsonObject.put("code", -3);
				jsonObject.put("msg", "Can't find look.");	
				return ok(jsonObject.toString()).as("application/json");
				
			}
			
			UserLook userLook = form.get();
			userLook.setLook(look);
			userLook.setDate(Calendar.getInstance().getTime());
			
			
			RequestBody request = request().body();
			String fileName = request.asMultipartFormData().getFiles().get(0).getFilename();
			File file = request.asMultipartFormData().getFiles().get(0).getFile();
			

			jsonObject = new JSONObject();

			FileChannel inChannel = new FileInputStream(file).getChannel();
			FileChannel outChannel = new FileOutputStream(new File(LOCAL_IMAGE_PATH + "/" + fileName)).getChannel();
			
			ByteBuffer buf = ByteBuffer.allocate(1024);
			
			while(true){
				if(inChannel.read(buf) == -1){
					break;
				}else{
					buf.flip();
					outChannel.write(buf);
					buf.clear();
				}
			}
			
			userLook.setImageFileName(fileName);
			userLook.save();

			ImageSender imageSender = new ImageSender("localhost", fileName);
			imageSender.send();
			
			jsonObject.put("code", 0);
			jsonObject.put("msg", "ok");
		
		}catch(NullPointerException e){
			e.printStackTrace();
			Logger.error("[code: -1] Parameter error.");
			jsonObject.put("code", -1);
			jsonObject.put("msg", "Parameter error.");
		
		}catch(IllegalStateException e){
			e.printStackTrace();
			Logger.error("[code: -2] Parameter error.");
			jsonObject.put("code", -1);
			jsonObject.put("msg", "Parameter error.");
		
		}catch (IOException e) {
			e.printStackTrace();
			Logger.error("[code: -3] File upload error.");
			jsonObject.put("code", -4);
			jsonObject.put("msg", "File upload error");
		
		}catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			Logger.error("[code: -4] File upload error.");
			jsonObject.put("code", -4);
			jsonObject.put("msg", "File upload error");
		
		}catch (NumberFormatException e){
			e.printStackTrace();
			Logger.error("[code: -5] Wrong input.");
			jsonObject.put("code", -1);
			jsonObject.put("msg", "Wrong input.");
		
		}
		
		
		
		return ok(jsonObject.toString()).as("application/json");
	}

	public static Result deleteUserLookById(Long id) throws JSONException {
		
		try{
			UserLook.find.byId(id).delete();
		}catch(NullPointerException e){
			Logger.error("[code: -4] Can't find UserLook.");
			jsonObject = new JSONObject();
			jsonObject.put("code", -4);
			jsonObject.put("msg", "Can't find UserLook.");
			return ok(jsonObject.toString()).as("application/json");
		}

		jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg", "ok");
		return ok(jsonObject.toString()).as("application/json");
	}
	
	public static Result imageToS3(String fileName){
		UserLook userLook = UserLook.find.where().ilike("imageFileName", fileName).findUnique();
		File file = new File(LOCAL_IMAGE_PATH + userLook.getImageFileName());
		file.delete();
		userLook.setImageFileName("S3_" + userLook.getImageFileName());
		userLook.save();
		
		return ok();
	}
	
}
