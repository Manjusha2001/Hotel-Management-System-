package com.tajhotel.dao;

public class Customer {
	private int id;
	private String name;
	private int age;
	private String city;
	private String status;
	
	public Customer() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city=city;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status=status;
	}
	@Override
	public String toString() {
		return "Customer[id="+ id +",name="+ name +",age ="+ age +",city="+ city +",status="+status+"]";
	}
	

}
