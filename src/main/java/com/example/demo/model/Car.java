package com.example.demo.model;

public class Car {
	
	private long id;
	private String vinNumber;
	private String make;
	private String model;
	private String color;
	private long owner;
	
	public long getId() {
		return id;
	}
	public String getVinNumber() {
		return vinNumber;
	}
	public String getMake() {
		return make;
	}
	public String getModel() {
		return model;
	}
	public String getColor() {
		return color;
	}
	public long getOwner() {
		return owner;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setOwner(long owner) {
		this.owner = owner;
	}
	
	

}
