package web.GrapeVine.modules;

import java.sql.Blob;

import javax.xml.bind.annotation.XmlRootElement;

//@Entity
@XmlRootElement
public class Ingredient {

	//@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	String name;
	String allergy;//TODO update object
	int singleWeight;
	String nutritionalValue;//TODO make object Json fields of vitamins or foods
	String detailedLink;
	Blob image;
	
	public Ingredient() {
		super();		
	}
	public Ingredient(Long id, String name, String allergy, int singleWeight, String nutritionalValue,
			String detailedLink, Blob image) {
		super();
		this.id = id;
		this.name = name;
		this.allergy = allergy;
		this.singleWeight = singleWeight;
		this.nutritionalValue = nutritionalValue;
		this.detailedLink = detailedLink;
		this.image = image;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAllergy() {
		return allergy;
	}
	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
	public int getSingleWeight() {
		return singleWeight;
	}
	public void setSingleWeight(int singleWeight) {
		this.singleWeight = singleWeight;
	}
	public String getNutritionalValue() {
		return nutritionalValue;
	}
	public void setNutritionalValue(String nutritionalValue) {
		this.nutritionalValue = nutritionalValue;
	}
	public String getDetailedLink() {
		return detailedLink;
	}
	public void setDetailedLink(String detailedLink) {
		this.detailedLink = detailedLink;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", allergy=" + allergy + ", singleWeight=" + singleWeight
				+ ", nutritionalValue=" + nutritionalValue + ", detailedLink=" + detailedLink + ", image=" + image
				+ "]";
	}
	
	
	
}
