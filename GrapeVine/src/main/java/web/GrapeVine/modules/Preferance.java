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
	@Id//TODO store on seperate db
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	Boolean vegan;
	Boolean vegetarian;
	Boolean pescatarian;
	Boolean carnivore;
	Boolean omnivore;
	//to be added at a later date
//	Boolean locavore;
//	Boolean palio;
//	Boolean fruitarian;
//	Boolean flexitarian;//this confuses filters and shouldn't be added
	
	
}


