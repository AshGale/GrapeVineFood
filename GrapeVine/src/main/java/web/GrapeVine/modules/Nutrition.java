package web.GrapeVine.modules;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Nutrition {

	//https://www.diabete.qc.ca/en/understand.../all.../nutrient-value-of-some-common-foods
	@Id//TODO store on seperate db
	@GeneratedValue(strategy=GenerationType.AUTO)
	long idNutrition;
	float weight = 0;//should relate to 100g
	float energy = 0;//kcal
	float energyJ = 0;//kj
	float protein = 0;//grams
	float carbohydrate = 0;//grams
	float sugar = 0;//grams
	float fiber = 0;//grams
	float fat = 0;//grams
	float saturatedFat = 0;//grams
	float cholesterol = 0;//mGrams
	float calcium = 0;//mGrams
	float iron = 0;//mGrams
	float sodium = 0;//mGrams
	//to be added at a later date
//	float potassium;//mGrams
//	float magnesium;//mGrams
//	float thiamin;//mGrams
//	float riboflavin;//mGrams
//	float niacin;//NE
//	float folate;//DFE
//	float lycopene;//mcg
//	float vitaminA;//RAE
//	float vitaminB12;//mcg	
//	float vitaminC;//mg	
//	float vitaminD;//mcg
//	float vitaminE;//mg

	public Nutrition() {
		super();

	}
	public Nutrition(long idNutrition, float weight, float energy, float energyJ, float protein, float carbohydrate,
			float sugar, float fiber, float fat, float saturatedFat, float cholesterol, float calcium, float iron,
			float sodium) {
		super();
		this.idNutrition = idNutrition;
		this.weight = weight;
		this.energy = energy;
		this.energyJ = energyJ;
		this.protein = protein;
		this.carbohydrate = carbohydrate;
		this.sugar = sugar;
		this.fiber = fiber;
		this.fat = fat;
		this.saturatedFat = saturatedFat;
		this.cholesterol = cholesterol;
		this.calcium = calcium;
		this.iron = iron;
		this.sodium = sodium;
	}
	public long getIdNutrition() {
		return idNutrition;
	}
	public void setIdNutrition(long idNutrition) {
		this.idNutrition = idNutrition;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getEnergy() {
		return energy;
	}
	public void setEnergy(float energy) {
		this.energy = energy;
	}
	public float getEnergyJ() {
		return energyJ;
	}
	public void setEnergyJ(float energyJ) {
		this.energyJ = energyJ;
	}
	public float getProtein() {
		return protein;
	}
	public void setProtein(float protein) {
		this.protein = protein;
	}
	public float getCarbohydrate() {
		return carbohydrate;
	}
	public void setCarbohydrate(float carbohydrate) {
		this.carbohydrate = carbohydrate;
	}
	public float getSugar() {
		return sugar;
	}
	public void setSugar(float sugar) {
		this.sugar = sugar;
	}
	public float getFiber() {
		return fiber;
	}
	public void setFiber(float fiber) {
		this.fiber = fiber;
	}
	public float getFat() {
		return fat;
	}
	public void setFat(float fat) {
		this.fat = fat;
	}
	public float getSaturatedFat() {
		return saturatedFat;
	}
	public void setSaturatedFat(float saturatedFat) {
		this.saturatedFat = saturatedFat;
	}
	public float getCholesterol() {
		return cholesterol;
	}
	public void setCholesterol(float cholesterol) {
		this.cholesterol = cholesterol;
	}
	public float getCalcium() {
		return calcium;
	}
	public void setCalcium(float calcium) {
		this.calcium = calcium;
	}
	public float getIron() {
		return iron;
	}
	public void setIron(float iron) {
		this.iron = iron;
	}
	public float getSodium() {
		return sodium;
	}
	public void setSodium(float sodium) {
		this.sodium = sodium;
	}
	@Override
	public String toString() {
		return "Nutrition [idNutrition=" + idNutrition + ", weight=" + weight + ", energy=" + energy + ", energyJ="
				+ energyJ + ", protein=" + protein + ", carbohydrate=" + carbohydrate + ", sugar=" + sugar + ", fiber="
				+ fiber + ", fat=" + fat + ", saturatedFat=" + saturatedFat + ", cholesterol=" + cholesterol
				+ ", calcium=" + calcium + ", iron=" + iron + ", sodium=" + sodium + "]";
	}

}
