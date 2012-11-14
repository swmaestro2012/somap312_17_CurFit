package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class User extends Model {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String userId;
	private String password;
	private String mail;
	private List<UserLook> userLooks;
	
	private boolean admin;

	public static Finder<Long,User> find = new Finder<Long,User>(
		    Long.class, User.class
		  ); 
	
	public User(){
		super();
	}
	
	public User(Long id, String userId, String password, String mail,
			List<UserLook> userLooks, boolean admin) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.mail = mail;
		this.userLooks = userLooks;
		this.setAdmin(admin);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<UserLook> getUserLooks() {
		return userLooks;
	}

	public void setUserLooks(List<UserLook> userLooks) {
		this.userLooks = userLooks;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
	
}
