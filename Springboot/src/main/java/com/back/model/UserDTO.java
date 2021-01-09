package com.back.model;


import java.util.Date;

public class UserDTO {
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private int age;
	private Date birthDay;
	private String role;
	private boolean activate;
	private boolean isSuperior;
	private String department;
	private String token;

	public UserDTO() {
	}

	public UserDTO(long id, String firstName, String lastName, String email, String username, String password, int age, Date birthDay, String role, boolean activate, boolean isSuperior, String department) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.age = age;
		this.birthDay = birthDay;
		this.role = role;
		this.activate = activate;
		this.isSuperior = isSuperior;
		this.department = department;
	}

	public UserDTO(long id, String firstName, String lastName, String email, String username, String password, int age, Date birthDay, String role, boolean activate, boolean isSuperior, String department, String token) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.age = age;
		this.birthDay = birthDay;
		this.role = role;
		this.activate = activate;
		this.isSuperior = isSuperior;
		this.department = department;
		this.token = token;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isActivate() {
		return activate;
	}

	public void setActivate(boolean activate) {
		this.activate = activate;
	}

	public boolean isSuperior() {
		return isSuperior;
	}

	public void setSuperior(boolean superior) {
		isSuperior = superior;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}