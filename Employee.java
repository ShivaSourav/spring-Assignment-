package com.SpringExample1mainexample.demo.module;

import org.springframework.stereotype.Component;


public class Employee {
	
	private int id;
	private String name;
	private String location;
	
	
	 
	
	private Department dept; 
	
	
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
