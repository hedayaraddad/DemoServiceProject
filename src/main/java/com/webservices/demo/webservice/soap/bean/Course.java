package com.webservices.demo.webservice.soap.bean;

public class Course {
	private int id ; 
	private String name ; 
	private String description ;
	
	
	
	public Course(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return String.format("Course [id=%s, name=%s, description=%s]", id, name, description);
	} 
	
	
	
	
	
	
	
}
