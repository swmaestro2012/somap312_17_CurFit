package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Coupon extends Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userLookHash;
	private int price;
	private Date expireDate;
	private boolean used;

	public static Finder<Long, Coupon> find = new Finder<Long, Coupon>(
			Long.class, Coupon.class);

	public Coupon() {
		super();
	}

	public Coupon(Long id, String userLookHash, int price, Date expireDate,
			boolean used) {
		super();
		this.id = id;
		this.userLookHash = userLookHash;
		this.price = price;
		this.expireDate = expireDate;
		this.used = used;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserlookHash() {
		return userLookHash;
	}

	public void setUserlookHash(String userLookHash) {
		this.userLookHash = userLookHash;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

}
