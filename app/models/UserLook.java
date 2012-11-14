package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class UserLook extends Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Look look;

	@Required
	private int size;
	private int likeCount;
	private String imageFileName;
	private String imageHash;
	private Date date;
	private boolean imageToS3;
	private Long matchLookId;
	
	public static Finder<Long,UserLook> find = new Finder<Long,UserLook>(
		    Long.class, UserLook.class
		  ); 
	
	public UserLook(){
		super();
	}

	public UserLook(Long id, Look look, int size, int likeCount,
			String imageFileName, String imageHash, Date date,
			boolean imageToS3, Long matchLookId) {
		super();
		this.id = id;
		this.look = look;
		this.size = size;
		this.likeCount = likeCount;
		this.imageFileName = imageFileName;
		this.imageHash = imageHash;
		this.date = date;
		this.imageToS3 = imageToS3;
		this.matchLookId = matchLookId;
	}



	public String getImageHash(){
		return imageHash;
	}
	
	public void setImageHash(String imageHash){
		this.imageHash = imageHash;
	}
	
	public Date getDate(){
		return date;
	}
	
	public void setDate(Date date){
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public Look getLook() {
		return look;
	}

	public void setLook(Look look) {
		this.look = look;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public Long getMatchLookId() {
		return matchLookId;
	}

	public void setMatchUserLookId(Long matchLookId) {
		this.matchLookId = matchLookId;
	}

	public boolean isImageToS3() {
		return imageToS3;
	}

	public void setImageToS3(boolean imageToS3) {
		this.imageToS3 = imageToS3;
	}
	
	

}
