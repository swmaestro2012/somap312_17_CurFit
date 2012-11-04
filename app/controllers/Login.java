package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import models.*;
import views.*;
import views.html.index;
import views.html.login;


public class Login extends Controller {
	
	public static Result blank() {
		return ok(login.render());
	}
	
}
