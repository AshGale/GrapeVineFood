package web.GrapeVine.modules;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Preferance {
	
	//https://simpleorder.com/restaurants-101/different-eating-styles/
	//rendered as radio buttons on front end
	@Id//TODO store on separate db
	@GeneratedValue(strategy=GenerationType.AUTO)
	long idPreferance;
	Boolean omnivore = true;
	Boolean vegan = false;
	Boolean vegetarian = false;
	Boolean pescatarian = false;
	Boolean carnivore = false;
	
	//to be added at a later date
//	Boolean kosher;
//	Boolean locavore;
//	Boolean palio;
//	Boolean fruitarian;
//	Boolean flexitarian;//this confuses filters and shouldn't be added
	
	public Preferance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Preferance(long idPreferance, Boolean omnivore, Boolean vegan, Boolean vegetarian, Boolean pescatarian,
			Boolean carnivore) {
		super();
		this.idPreferance = idPreferance;
		this.omnivore = omnivore;
		this.vegan = vegan;
		this.vegetarian = vegetarian;
		this.pescatarian = pescatarian;
		this.carnivore = carnivore;
	}

	public long getIdPreferance() {
		return idPreferance;
	}

	public void setIdPreferance(long idPreferance) {
		this.idPreferance = idPreferance;
	}

	public Boolean getOmnivore() {
		return omnivore;
	}

	public void setOmnivore(Boolean omnivore) {
		this.omnivore = omnivore;
	}

	public Boolean getVegan() {
		return vegan;
	}

	public void setVegan(Boolean vegan) {
		this.vegan = vegan;
	}

	public Boolean getVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(Boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	public Boolean getPescatarian() {
		return pescatarian;
	}

	public void setPescatarian(Boolean pescatarian) {
		this.pescatarian = pescatarian;
	}

	public Boolean getCarnivore() {
		return carnivore;
	}

	public void setCarnivore(Boolean carnivore) {
		this.carnivore = carnivore;
	}

	@Override
	public String toString() {
		return "Preferance [idPreferance=" + idPreferance + ", omnivore=" + omnivore + ", vegan=" + vegan
				+ ", vegetarian=" + vegetarian + ", pescatarian=" + pescatarian + ", carnivore=" + carnivore + "]";
	}
	
}


