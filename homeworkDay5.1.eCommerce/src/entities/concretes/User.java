package entities.concretes;

import entities.abstracts.Entity;

public class User implements Entity{

	private int id;
	private String firstname;
	private String lastName;
	private String email;
	private String password;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String firstname, String lastName, String email, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String name) {
		this.lastName = name;
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
	
}
