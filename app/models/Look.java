package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

import play.db.ebean.Model;

@Entity
public class Look extends Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private int shotCount;
	private int year;
	private int season;
	private int lookType;
	private int price;
	private String barcode;
	private String imageFileName;
	private String description;

	@OneToMany(cascade = CascadeType.ALL)
	private List<UserLook> userLooks;

	public static Finder<Long, Look> find = new Finder<Long, Look>(Long.class,
			Look.class);

	public Look() {
		super();
	}

	public Look(Long id, String name, int shotCount, int year, int season,
			int lookType, int price, String barcode, String imageFileName,
			String description, List<UserLook> userLooks) {
		super();
		this.id = id;
		this.name = name;
		this.shotCount = shotCount;
		this.year = year;
		this.season = season;
		this.lookType = lookType;
		this.price = price;
		this.barcode = barcode;
		this.imageFileName = imageFileName;
		this.description = description;
		this.userLooks = userLooks;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getShotCount() {
		return shotCount;
	}

	public void setShotCount(int shotCount) {
		this.shotCount = shotCount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public int getLookType() {
		return lookType;
	}

	public void setLookType(int lookType) {
		this.lookType = lookType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	@JsonIgnore
	public List<UserLook> getUserLooks() {
		return userLooks;
	}

	public void setUserLooks(List<UserLook> userLooks) {
		this.userLooks = userLooks;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

}
