package controllers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Formatter;

import models.Look;
import models.UserLook;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Http.RequestBody;
import play.mvc.Result;
import so.tree.imageQueue.ImageSender;
import views.html.lookDetails;
import views.html.selection;
import views.html.uploadLooks;

public class Looks extends Controller {
	
	private static String LOCAL_IMAGE_PATH = System.getProperty("user.dir") + "/public/lookImages/";
	private static String AMAZON_S3_PATH = "https://s3-ap-northeast-1.amazonaws.com/swmaestro/";
	
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
	public static Result uploadLook(){
		return ok(uploadLooks.render("Upload Model", "Han Jin-Soo"));
	}
	
	
	public static Result newLook(){
		
		
		Form<Look> form = new Form<Look>(Look.class)
				.bindFromRequest();
		
		try{
			Look look = form.get();
			RequestBody request = request().body();
			File file = request.asMultipartFormData().getFiles().get(0).getFile();
			look.setImageFileName(calculateHash(MessageDigest.getInstance("MD5"), file));
			
			FileChannel inChannel = new FileInputStream(file).getChannel();
			FileChannel outChannel = new FileOutputStream(new File(LOCAL_IMAGE_PATH + "/" + look.getImageFileName())).getChannel();
			
			ByteBuffer buf = ByteBuffer.allocate(1024);
			
			while(true){
				if(inChannel.read(buf) == -1){
					break;
				}else{
					buf.flip();
					outChannel.write(buf);
					buf.clear();
				}
			}
			
			
			ImageSender imageSender = new ImageSender("localhost", look.getImageFileName(), "Look");
			imageSender.send();
			look.setImageToS3(false);
			look.save();
			
		}catch(IllegalStateException e){
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e){
			
		}
		return ok();
	}
	

	public static Result imageToS3(String fileName){
		Look look = Look.find.where().ilike("imageFileName", fileName).findUnique();
		look.setImageToS3(true);
		look.save();

		File file = new File(LOCAL_IMAGE_PATH + look.getImageFileName());
		file.delete();
		
		return ok();
	}
	


	public static String calculateHash(MessageDigest algorithm, File file) throws Exception
    {
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        DigestInputStream dis = new DigestInputStream(bis, algorithm);
 
        // read the file and update the hash calculation
        while(dis.read() != -1) 
            ;
 
        // get the hash value as byte array
        byte[] hash = algorithm.digest();
 
        return byteArray2Hex(hash);
    }
 
    private static String byteArray2Hex(byte[] hash)
    {
        Formatter formatter = new Formatter();
        for(byte b : hash)
        {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

}
