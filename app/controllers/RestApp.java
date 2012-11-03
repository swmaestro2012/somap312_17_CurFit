package controllers;

import models.Look;
import models.UserLook;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class RestApp extends Controller {

	public static Result getLookById(Long id) {

		Look look = Look.find.byId(id);

		return ok(Json.toJson(look));
	}

	public static Result getAllUserLooksByLookId(Long id) {

		Look look = Look.find.byId(id);
		return ok(Json.toJson(look.getUserLooks()));
	}

	public static Result getUserLookById(Long id) {

		UserLook userLook = UserLook.find.byId(id);
		return ok(Json.toJson(userLook));
	}

	public static Result saveUserLook() {

		Form<UserLook> form = new Form<UserLook>(UserLook.class)
				.bindFromRequest();
		UserLook userLook = form.get();
		userLook.save();

		return ok();
	}

	public static Result deleteUserLookById(Long id) {
		UserLook.find.ref(id).delete();
		return ok();
	}

}
