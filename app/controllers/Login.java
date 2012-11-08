package controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import models.User;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.login;


public class Login extends Controller {
	
	public static Result blank() {
		if(session("userId") != null)
			return redirect("/login");
		return ok(login.render(""));
	}
	
	public static Result login() throws NoSuchAlgorithmException {

		String userId = request().body().asFormUrlEncoded().get("userId")[0];
		String password = encSHA1(request().body().asFormUrlEncoded().get("password")[0]);
		
		List<User> userList = User.find.where().ilike("userId", userId).findList();
		
		if(userList.size() == 0)
			return ok(login.render("Can't find user."));
		
		User user = userList.get(0);
		
		if(!user.getPassword().equals(password)){
			return ok(login.render("Incorrect password!"));
		}
		else
			session("userId", userId);
		
		if(user.getIsAdmin() == 1)
			return redirect("/dashboard/");
		
		return redirect("/");
	}
	
	public static String encSHA1(String input) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
		StringBuffer sb = new StringBuffer();
		String hex;
		for (byte b : messageDigest.digest(input.getBytes())){
			hex = Integer.toHexString(b & 0xff);
			if (hex.length() < 2)
				sb.append("0");
		sb.append(hex);
		}
		return sb.toString();

	}
}
