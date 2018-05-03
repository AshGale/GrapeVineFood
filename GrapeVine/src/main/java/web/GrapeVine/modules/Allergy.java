package web.GrapeVine.modules;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@XmlRootElement
public class Allergy {

	//https://en.wikipedia.org/wiki/List_of_allergens
	@Id//TODO store on seperate db
	//@JsonProperty("idAllergy")
	@GeneratedValue(strategy=GenerationType.AUTO)
	long idAllergy;
	Boolean nut = false;
	//@JsonProperty("seafood")//workaround for name change
	Boolean seafood = false;
	Boolean shellfish = false;
	Boolean soy = false;
	Boolean milk = false;
	Boolean wheat = false;
	Boolean gluten = false;
	Boolean eggs = false;
	Boolean fruit = false;
	Boolean garlic = false;
	Boolean hotPeppers = false;
	Boolean oats = false;
	Boolean meat = false;//not a preference
	Boolean rice = false;
	Boolean sesame = false;
	Boolean sulfites = false;
	Boolean tartrazine = false;
	
	public Allergy() {
		super();
	}

	public Allergy(long idAllergy, Boolean nut, Boolean seafood, Boolean shellfish, Boolean soy, Boolean milk,
			Boolean wheat, Boolean gluten, Boolean eggs, Boolean fruit, Boolean garlic, Boolean hotPeppers,
			Boolean oats, Boolean meat, Boolean rice, Boolean sesame, Boolean sulfites, Boolean tartrazine) {
		super();
		this.idAllergy = idAllergy;
		this.nut = nut;
		this.seafood = seafood;
		this.shellfish = shellfish;
		this.soy = soy;
		this.milk = milk;
		this.wheat = wheat;
		this.gluten = gluten;
		this.eggs = eggs;
		this.fruit = fruit;
		this.garlic = garlic;
		this.hotPeppers = hotPeppers;
		this.oats = oats;
		this.meat = meat;
		this.rice = rice;
		this.sesame = sesame;
		this.sulfites = sulfites;
		this.tartrazine = tartrazine;
	}

	public long getIdAllergy() {
		return idAllergy;
	}

	public void setIdAllergy(long idAllergy) {
		this.idAllergy = idAllergy;
	}

	public Boolean getNut() {
		return nut;
	}

	public void setNut(Boolean nut) {
		this.nut = nut;
	}

	public Boolean getSeafood() {
		return seafood;
	}

	public void setSeafood(Boolean seafood) {
		this.seafood = seafood;
	}

	public Boolean getShellfish() {
		return shellfish;
	}

	public void setShellfish(Boolean shellfish) {
		this.shellfish = shellfish;
	}

	public Boolean getSoy() {
		return soy;
	}

	public void setSoy(Boolean soy) {
		this.soy = soy;
	}

	public Boolean getMilk() {
		return milk;
	}

	public void setMilk(Boolean milk) {
		this.milk = milk;
	}

	public Boolean getWheat() {
		return wheat;
	}

	public void setWheat(Boolean wheat) {
		this.wheat = wheat;
	}

	public Boolean getGluten() {
		return gluten;
	}

	public void setGluten(Boolean gluten) {
		this.gluten = gluten;
	}

	public Boolean getEggs() {
		return eggs;
	}

	public void setEggs(Boolean eggs) {
		this.eggs = eggs;
	}

	public Boolean getFruit() {
		return fruit;
	}

	public void setFruit(Boolean fruit) {
		this.fruit = fruit;
	}

	public Boolean getGarlic() {
		return garlic;
	}

	public void setGarlic(Boolean garlic) {
		this.garlic = garlic;
	}

	public Boolean getHotPeppers() {
		return hotPeppers;
	}

	public void setHotPeppers(Boolean hotPeppers) {
		this.hotPeppers = hotPeppers;
	}

	public Boolean getOats() {
		return oats;
	}

	public void setOats(Boolean oats) {
		this.oats = oats;
	}

	public Boolean getMeat() {
		return meat;
	}

	public void setMeat(Boolean meat) {
		this.meat = meat;
	}

	public Boolean getRice() {
		return rice;
	}

	public void setRice(Boolean rice) {
		this.rice = rice;
	}

	public Boolean getSesame() {
		return sesame;
	}

	public void setSesame(Boolean sesame) {
		this.sesame = sesame;
	}

	public Boolean getSulfites() {
		return sulfites;
	}

	public void setSulfites(Boolean sulfites) {
		this.sulfites = sulfites;
	}

	public Boolean getTartrazine() {
		return tartrazine;
	}

	public void setTartrazine(Boolean tartrazine) {
		this.tartrazine = tartrazine;
	}

	@Override
	public String toString() {
		return "Allergy [idAllergy=" + idAllergy + ", nut=" + nut + ", seafood=" + seafood + ", shellfish=" + shellfish
				+ ", soy=" + soy + ", milk=" + milk + ", wheat=" + wheat + ", gluten=" + gluten + ", eggs=" + eggs
				+ ", fruit=" + fruit + ", garlic=" + garlic + ", hotPeppers=" + hotPeppers + ", oats=" + oats
				+ ", meat=" + meat + ", rice=" + rice + ", sesame=" + sesame + ", sulfites=" + sulfites
				+ ", tartrazine=" + tartrazine + "]";
	}
	
}

