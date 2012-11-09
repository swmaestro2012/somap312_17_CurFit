package controllers;

import java.util.ArrayList;

import models.Look;
import models.UserLook;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;
import views.html.helper.select;

public class Looks extends Controller {
	public static Result selectLooks() {
		return ok(selection.render("Select Models", "Han Jin-Soo"));
	}
	
	public static Result lookDetails(Long id){
		Look look = Look.find.byId(id);
		if (look != null){
			return ok(lookDetails.render("Details Model", "Han Jin-Soo", look ));
		}
		else {
			return notFound();
		}
	}
}
