package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Coupon extends Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userlookHash;
	private boolean used;

	public Coupon(Long id, String userlookHash, boolean used) {
		super();
		this.id = id;
		this.userlookHash = userlookHash;
		this.used = used;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserlookHash() {
		return userlookHash;
	}

	public void setUserlookHash(String userlookHash) {
		this.userlookHash = userlookHash;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

}
