package com.back.model;


import java.util.Date;

public class UserForRegistrationDTO {
	private long id;
	private String firstName;
	private String lastName;
	private String role;
	private String afmDepartment;
	private String department;

	public UserForRegistrationDTO() {
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAfmDepartment() {
		return afmDepartment;
	}

	public void setAfmDepartment(String afmDepartment) {
		this.afmDepartment = afmDepartment;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}