package controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


import models.Look;
import models.UserLook;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;
import views.html.*;
import views.html.helper.select;

public class Looks extends Controller {
	public static Result selectLooks() {
		if(session("userId") != null)
			return redirect("/dashboard/login");
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		return ok(selection.render("Select Models", "Han Jin-Soo", currentYear));
	}
	public static Result lookDetails(Long id){
		if(session("userId") != null)
			return redirect("/dashboard/login");
		Look look = Look.find.byId(id);
		if (look != null){
			return ok(lookDetails.render("Details Model", "Han Jin-Soo", look, look.getUserLooks() ));
		}
		else {
			return notFound();
		}
	}
	public static Result uploadLooks(){
		return ok(uploadLooks.render("Upload Model", "Han Jin-Soo"));
	}
	
	
	public static Result upload(){
		  MultipartFormData body = request().body().asMultipartFormData();
		  FilePart picture = body.getFile("picture");
		  if (picture != null) {
		    String fileName = picture.getFilename();
		    String contentType = picture.getContentType(); 
		    File file = picture.getFile();
		    return ok("File uploaded");
		  } else {
		    flash("error", "Missing file");
		    return redirect(routes.Application.index());    
		  }
	}
}
