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
	long id;
	int weight;//should relate to 100g
	int energy;//kcal
	int energyJ;//kj
	int protein;//grams
	int carbohydrate;//grams
	int sugar;//grams
	int fiber;//grams
	int fat;//grams
	int saturatedFat;//grams
	int cholesterol;//mGrams
	int calcium;//mGrams
	int iron;//mGrams
	int soldium;//mGrams
	//to be added at a later date
//	int potassium;//mGrams
//	int magnesium;//mGrams
//	int thiamin;//mGrams
//	int riboflavin;//mGrams
//	int niacin;//NE
//	int folate;//DFE
//	int lycopene;//mcg
//	int vitaminA;//RAE
//	int vitaminB12;//mcg	
//	int vitaminC;//mg	
//	int vitaminD;//mcg
//	int vitaminE;//mg
	
}
