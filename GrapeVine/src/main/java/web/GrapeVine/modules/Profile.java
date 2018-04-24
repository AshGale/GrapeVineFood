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
	//Eating Habits
	String allergys;//TODO make object booleans
	String preferances;//TODO make object booleans
	String dislikes;//TODO make object Dynamic list or eg 5 items
	String diet;//TODO make object of set of dislikes
	String defaultLocation; //TODO on maps determine coordinates for optimisation
	
	public Profile() {
		super();
	}

	public Profile(Long id, String role, String name, String userName, String email, String password, String allergys,
			String preferances, String dislikes, String diet, String defaultLocation) {
		super();
		this.id = id;
		this.role = role;
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.allergys = allergys;
		this.preferances = preferances;
		this.dislikes = dislikes;
		this.diet = diet;
		this.defaultLocation = defaultLocation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAllergys() {
		return allergys;
	}

	public void setAllergys(String allergys) {
		this.allergys = allergys;
	}

	public String getPreferances() {
		return preferances;
	}

	public void setPreferances(String preferances) {
		this.preferances = preferances;
	}

	public String getDislikes() {
		return dislikes;
	}

	public void setDislikes(String dislikes) {
		this.dislikes = dislikes;
	}

	public String getDiet() {
		return diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	public String getDefaultLocation() {
		return defaultLocation;
	}

	public void setDefaultLocation(String defaultLocation) {
		this.defaultLocation = defaultLocation;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", role=" + role + ", name=" + name + ", userName=" + userName + ", email=" + email
				+ ", password=" + password + ", allergys=" + allergys + ", preferances=" + preferances + ", dislikes="
				+ dislikes + ", diet=" + diet + ", defaultLocation=" + defaultLocation + "]";
	}
	

	
}
