package controllers;

import models.Look;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Spao extends Controller{
	
	public static Result index(){
		Look look = Look.find.byId(new Long(9));
		return ok(spao.render(look.getUserLooks()));
	}
}