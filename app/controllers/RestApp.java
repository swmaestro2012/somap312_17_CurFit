package controllers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Formatter;
import java.util.List;

import models.Coupon;
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
	
	public static Result getLookByBarcode(String barcode) throws JSONException {

		Look look = Look.find.where().ilike("barcode", barcode).findUnique();
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

		if(userLook.isImageToS3()){
			userLook.setImageFileName(AMAZON_S3_PATH + userLook.getImageFileName());
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
			File file = request.asMultipartFormData().getFiles().get(0).getFile();
			
			try {
				userLook.setImageHash(calculateHash(MessageDigest.getInstance("MD5"), file));
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			jsonObject = new JSONObject();

			FileChannel inChannel = new FileInputStream(file).getChannel();
			FileChannel outChannel = new FileOutputStream(new File(LOCAL_IMAGE_PATH + "/" + userLook.getImageHash() + ".png")).getChannel();
			
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
			
			Coupon coupon = new Coupon();
			coupon.setPrice(3000);
			coupon.setUsed(false);
			coupon.setUserlookHash(userLook.getImageHash());
			coupon.save();

			userLook.setImageFileName(userLook.getImageHash() + ".png");
			userLook.save();
			
			
			
			
			ImageSender imageSender = new ImageSender("localhost", userLook.getImageFileName());
			imageSender.send();
			
			jsonObject.put("code", 0);
			jsonObject.put("hash", userLook.getImageHash());
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
		userLook.setImageToS3(true);
		userLook.save();

		File file = new File(LOCAL_IMAGE_PATH + userLook.getImageFileName());
		file.delete();
		
		return ok();
	}
	
	public static Result useCoupon() throws JSONException{
		
		String hash = request().body().asFormUrlEncoded().get("hash")[0];
		Coupon coupon = Coupon.find.where().ilike("userLookHash", hash).findUnique();
		
		coupon.setUsed(true);
		coupon.save();
		
		jsonObject.put("code", 0);
		jsonObject.put("msg", "ok");
		return ok(jsonObject.toString()).as("application/json");
	}
	
	public static String calculateHash(MessageDigest algorithm, File file) throws Exception
    {
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        DigestInputStream dis = new DigestInputStream(bis, algorithm);
 
        // read the file and update the hash calculation
        while(dis.read() != -1) 
            ;
 
        // get the hash value as byte array
        byte[] hash = algorithm.digest();
 
        return byteArray2Hex(hash);
    }
 
    private static String byteArray2Hex(byte[] hash)
    {
        Formatter formatter = new Formatter();
        for(byte b : hash)
        {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }
}
