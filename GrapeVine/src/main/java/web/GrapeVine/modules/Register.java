package web.GrapeVine.modules;

import javax.persistence.Column;

public class Register {
	
	String name;
	String userName;
	String email;
	String password;//TODO add encryption and privacy
	String defaultLocation; //TODO on maps determine coordinates for optimisation
	
	public Register() {
		super();
	}

	public Register(String name, String userName, String email, String password, String defaultLocation) {
		super();
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.defaultLocation = defaultLocation;
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

	public String getDefaultLocation() {
		return defaultLocation;
	}

	public void setDefaultLocation(String defaultLocation) {
		this.defaultLocation = defaultLocation;
	}
	
}
