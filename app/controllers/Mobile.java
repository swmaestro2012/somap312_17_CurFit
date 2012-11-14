package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;
public class Mobile extends Controller {
	public static Result index() {
		return ok(mobileIndex.render());
	}
	public static Result otherUserLook() {
		return ok(mobileOtherLook.render());
	}
	public static Result coupon() {
		return ok(mobileCoupon.render());
	}
}
