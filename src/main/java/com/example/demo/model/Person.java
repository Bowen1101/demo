package com.example.demo.model;

public class Person {
	//properties
	private long id;
	private String fullName;
	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private String address;
	private int zipCode;
	//getters
	public long getId() {
		return id;
	}
	public String getFullName() {
		return fullName;
	} 
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getAge() {
		return age;
	}
	public String getEmail() {
		return email;
	}
	public String getAddress() {
		return address;
	}
	public int getZipCode() {
		return zipCode;
	}
	//setters
	public void setId(long id) {
		this.id = id;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	@Override
	public String toString() {
		return fullName + ", " + age + ", " +  email + ", " + address + ", " +  zipCode + ";";
	}
}
