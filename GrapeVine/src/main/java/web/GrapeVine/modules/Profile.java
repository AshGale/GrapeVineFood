package web.GrapeVine.modules;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Profile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	String role;
	String name;
	String userName;
	String email;
	String password;//TODO add encryption and privacy
	String allergys;//TODO make object booleans
	String preferances;//TODO make object booleans
	String dislikes;//TODO make object Dynamic list or eg 5 items
	String diet;//TODO make object of set of dislikes
	String defaultLocation; //TODO on maps determine coordinates for optimisation
	
	
	
	public Profile() {
		super();
	}

	public Profile(Long id, String name, String role) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", role=" + role + "]";
	}
	
}
