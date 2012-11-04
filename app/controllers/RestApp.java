package controllers;

import java.util.List;

import models.Look;
import models.UserLook;

import org.json.JSONException;
import org.json.JSONObject;

import play.Logger;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class RestApp extends Controller {

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
		return ok(Json.toJson(userLook));
	}

	public static Result saveUserLook() throws JSONException {

		Form<UserLook> form = new Form<UserLook>(UserLook.class)
				.bindFromRequest();
		try{
			UserLook userLook = form.get();
			userLook.save();
		}catch(IllegalStateException e){
			Logger.error("[code: -1] Parameter error.");
			jsonObject = new JSONObject();
			jsonObject.put("code", -1);
			jsonObject.put("msg", "Parameter error.");
			return ok(jsonObject.toString()).as("application/json");
		}
		
		jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg", "ok");
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

}
