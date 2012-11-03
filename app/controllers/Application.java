package controllers;

import java.util.ArrayList;

import models.Look;
import models.UserLook;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {
  
  public static Result index() {
	  
	  Look look = new Look();
	  look.save();
	  UserLook userLook = new UserLook();
	  userLook.setLook(look);
	  userLook.save();
	  
	  
	  ArrayList<UserLook> userLookList = new ArrayList<UserLook>();
	  userLookList.add(userLook);
	  
	  look.setUserLooks(userLookList);
	  look.setId(1L);
	  look.update();
	  
	  look = Look.find.byId(1L);
	  
	  System.out.println(look.getUserLooks().size());
	  
    return ok(index.render("Your new application is ready."));
  }
  
  
  public static Result addLook(){
	  Look look = new Look();
	  look.save();
	  return ok();
  }
  
  
}