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
	
	public static Result lookDetails(){
		return ok(lookDetails.render("Details Model", "Han Jin-Soo", "http://pds15.egloos.com/pds/200909/07/72/d0030472_4aa4949eaede3.jpg"));
	}
}
