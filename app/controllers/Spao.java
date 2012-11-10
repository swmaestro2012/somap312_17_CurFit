package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Spao extends Controller{
	public static Result index(){		
		return ok(spao.render());
	}
}