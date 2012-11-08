package controllers;

import java.util.List;

import models.Look;
import models.UserLook;
import play.mvc.Controller;
import play.mvc.Result;
import play.Logger;
import views.html.index;

public class Application extends Controller {
  
  public static Result index() {
//	  
//	  Look look = new Look();
//	  look.setPrice(29000);
//	  look.setLookType(0);
//	  look.setYear(2012);
//	  look.setSeason(4);
//	  look.setImageUrl("http://www.naver.com");
//	  look.save();
//	  
//	  UserLook userLook = new UserLook();
//	  userLook.setLook(look);
//	  userLook.save();
//	  
//	  
//	  ArrayList<UserLook> userLookList = new ArrayList<UserLook>();
//	  userLookList.add(userLook);
//	  
//	  look.setUserLooks(userLookList);
//	  look.setId(1L);
//	  look.update();
//	  
//	  look = Look.find.byId(1L);
//	  
//	  System.out.println(look.getUserLooks().size());
//	  
	  
	  List<Look> mostShootingLookList = Look.find.where().orderBy("shotCount desc").setMaxRows(5).findList();
	  List<UserLook> mostLikedUserLookList = UserLook.find.where().orderBy("likeCount desc").setMaxRows(5).findList();
	  
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