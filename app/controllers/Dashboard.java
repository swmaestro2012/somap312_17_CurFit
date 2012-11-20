package controllers;

import java.util.List;

import models.Look;
import models.UserLook;
import play.mvc.Controller;
import play.mvc.Result;
import play.Logger;
import views.html.index;

public class Dashboard extends Controller {
  
  public static Result index() {
		if(session("userId") != null)
			return redirect("/dashboard/login");
	  
	  List<Look> mostShootingLookList = Look.find.setMaxRows(5).orderBy("shotCount desc").findList();
	  List<UserLook> mostLikedUserLookList = UserLook.find.setMaxRows(5).orderBy("likeCount desc").findList();
	  
	  Integer shotTotal = 0;	  
	  for (Look elem : mostShootingLookList){
		  shotTotal += elem.getShotCount();
	  }	  
	
	  Logger.info(shotTotal.toString());
	  
	  return ok(index.render("Welcome to Fashion Dashboard.", "Han Jin-Soo", mostShootingLookList, mostLikedUserLookList, shotTotal));
  }
  
  
  public static Result addLook(){
	  Look look = new Look();
	  look.save();
	  return ok();
  }
  
  private Integer getMostLiked(List<UserLook> user){
	  Integer count = 0;
	  
	  for (UserLook elem : user){
		  count += elem.getLikeCount();
	  }
	  
	  return count;
  }
}