package entities.concretes;

import entities.abstracts.Entity;

public class Customer implements Entity {
	private int Id;
	private String firstName;
	private String lastName;
	private int DateOfBirthday;
	private String NationalityId;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, String firstName, String lastName, int dateOfBirthday, String nationalityId) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		DateOfBirthday = dateOfBirthday;
		NationalityId = nationalityId;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getDateOfBirthday() {
		return DateOfBirthday;
	}

	public void setDateOfBirthday(int dateOfBirthday) {
		DateOfBirthday = dateOfBirthday;
	}

	public String getNationalityId() {
		return NationalityId;
	}

	public void setNationalityId(String nationalityId) {
		NationalityId = nationalityId;
	}
}
