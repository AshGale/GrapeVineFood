package web.GrapeVine.modules;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Allerys {

	//https://en.wikipedia.org/wiki/List_of_allergens
	@Id//TODO store on seperate db
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	Boolean nut;
	Boolean seaFood;
	Boolean shellfish;
	Boolean soy;
	Boolean milk;
	Boolean wheat;
	Boolean gluten;
	Boolean eggs;
	Boolean fruit;
	Boolean garlic;
	Boolean hotPeppers;
	Boolean oats;
	Boolean meat;//not not a preference
	Boolean rice;
	Boolean sesame;
	Boolean sulfites;
	Boolean tartrazine;
	
	public Allerys() {
		super();
	}
	
	public Allerys(Boolean nut, Boolean seaFood, Boolean shellfish, Boolean soy, Boolean milk, Boolean wheat,
			Boolean gluten, Boolean eggs, Boolean fruit, Boolean garlic, Boolean hotPeppers, Boolean oats, Boolean meat,
			Boolean rice, Boolean sesame, Boolean sulfites, Boolean tartrazine) {
		super();
		this.nut = nut;
		this.seaFood = seaFood;
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

	public Boolean getNut() {
		return nut;
	}
	public void setNut(Boolean nut) {
		this.nut = nut;
	}
	public Boolean getSeaFood() {
		return seaFood;
	}
	public void setSeaFood(Boolean seaFood) {
		this.seaFood = seaFood;
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
	
}

