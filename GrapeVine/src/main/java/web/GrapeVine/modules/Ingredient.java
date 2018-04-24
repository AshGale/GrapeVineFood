package web.GrapeVine.modules;

import javax.xml.bind.annotation.XmlRootElement;

//@Entity
@XmlRootElement
public class Ingredient {

	//@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	String name;
	int grams;
	
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
	public int getGrams() {
		return grams;
	}
	public void setGrams(int grams) {
		this.grams = grams;
	}
	
	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", grams=" + grams + "]";
	}	
	
}
