package web.GrapeVine.modules;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Ingredient {
	
	@Id//TODO store on seperate db
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long idIngredient;
	//@Id
	@Column(unique=true)
	String name;
	@OneToOne(cascade = {CascadeType.ALL})
	Allergy allergy;
	
	@OneToOne(cascade = {CascadeType.ALL})
	Nutrition nutritionalValue;
	Blob image;
	int singleWeight;
	String detailedLink;

	public Ingredient() {
		super();

	}

	public Ingredient(Long idIngredient, String name, Allergy allergy, Nutrition nutritionalValue, Blob image,
			int singleWeight, String detailedLink) {
		super();
		this.idIngredient = idIngredient;
		this.name = name;
		this.allergy = allergy;
		this.nutritionalValue = nutritionalValue;
		this.image = image;
		this.singleWeight = singleWeight;
		this.detailedLink = detailedLink;
	}

	public Long getIdIngredient() {
		return idIngredient;
	}

	public void setIdIngredient(Long idIngredient) {
		this.idIngredient = idIngredient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Allergy getAllergy() {
		return allergy;
	}

	public void setAllergy(Allergy allergy) {
		this.allergy = allergy;
	}

	public Nutrition getNutritionalValue() {
		return nutritionalValue;
	}

	public void setNutritionalValue(Nutrition nutritionalValue) {
		this.nutritionalValue = nutritionalValue;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public int getSingleWeight() {
		return singleWeight;
	}

	public void setSingleWeight(int singleWeight) {
		this.singleWeight = singleWeight;
	}

	public String getDetailedLink() {
		return detailedLink;
	}

	public void setDetailedLink(String detailedLink) {
		this.detailedLink = detailedLink;
	}

	@Override
	public String toString() {
		return "Ingredient [idIngredient=" + idIngredient + ", name=" + name + ", allergy=" + allergy
				+ ", nutritionalValue=" + nutritionalValue + ", image=" + image + ", singleWeight=" + singleWeight
				+ ", detailedLink=" + detailedLink + "]";
	}

}
