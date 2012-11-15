package controllers;

import models.UserLook;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;


public class Mobile extends Controller {
	
	private static String LOCAL_IMAGE_PATH = System.getProperty("user.dir") + "/public/lookImages/";
	private static String AMAZON_S3_PATH = "https://s3-ap-northeast-1.amazonaws.com/swmaestro/";
	
	public static Result index() {
		return ok(mobileIndex.render(""));
	}
	public static Result otherUserLook() {
		return ok(mobileOtherLook.render());
	}
	public static Result coupon() {
		return ok(mobileCoupon.render());
	}
	
	public static Result myLook(String hash){
		
		String imageUrl;
		
		UserLook userLook = UserLook.find.where().ilike("imageHash", hash).findUnique();
		userLook.getId();
		
		if(userLook.isImageToS3()){
			imageUrl = AMAZON_S3_PATH + userLook.getImageHash();
		}else{
			imageUrl = LOCAL_IMAGE_PATH + userLook.getImageHash();
		}
		
		return ok(mobileIndex.render(imageUrl));
	}
	public static Result facebook() {
		String imgUrl = request().body().asFormUrlEncoded().get("facebook-uplaod")[0];
		Logger.info(imgUrl);
		return ok(mobileFacebook.render(imgUrl));
	}
}
