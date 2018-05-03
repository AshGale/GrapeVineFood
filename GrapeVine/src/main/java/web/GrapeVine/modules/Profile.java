package web.GrapeVine.modules;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Profile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long idProfile;
	String role;
	String name;
	String userName;
	String email;
	String password;//TODO add encryption and privacy
	//Eating Habits
	@OneToOne(cascade = {CascadeType.ALL})	
	Allergy allergys;
	@OneToOne(cascade = {CascadeType.ALL})
	Preferance preferances;
	String dislikes;//TODO make object Dynamic list or eg 5 items
	String diet;//TODO make object of set of dislikes
	String defaultLocation; //TODO on maps determine coordinates for optimisation
	
	public Profile() {
		super();

	}

	public Profile(Long idProfile, String role, String name, String userName, String email, String password,
			Allergy allergys, Preferance preferances, String dislikes, String diet, String defaultLocation) {
		super();
		this.idProfile = idProfile;
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

	public Long getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(Long idProfile) {
		this.idProfile = idProfile;
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

	public Allergy getAllergys() {
		return allergys;
	}

	public void setAllergys(Allergy allergys) {
		this.allergys = allergys;
	}

	public Preferance getPreferances() {
		return preferances;
	}

	public void setPreferances(Preferance preferances) {
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
		return "Profile [idProfile=" + idProfile + ", role=" + role + ", name=" + name + ", userName=" + userName
				+ ", email=" + email + ", password=" + password + ", allergys=" + allergys + ", preferances="
				+ preferances + ", dislikes=" + dislikes + ", diet=" + diet + ", defaultLocation=" + defaultLocation
				+ "]";
	}

}
