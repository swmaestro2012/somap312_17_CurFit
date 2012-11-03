package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

import play.db.ebean.Model;

@Entity
public class UserLook extends Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Look look;

	private int size;
	private int likeCount;
	private String imageUrl;
	
	public static Finder<Long,UserLook> find = new Finder<Long,UserLook>(
		    Long.class, UserLook.class
		  ); 
	
	public UserLook(){
		super();
	}

	public UserLook(Long id, Look look, int size, int likeCount, String imageUrl) {
		super();
		this.id = id;
		this.look = look;
		this.size = size;
		this.likeCount = likeCount;
		this.imageUrl = imageUrl;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	

}
