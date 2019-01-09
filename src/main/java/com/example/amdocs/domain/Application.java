package com.example.amdocs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


enum TYPE 
{ 
    CORE, CASTUM; 
} 

@Entity
public class Application {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private String type;
	
	public Application() {
		// TODO Auto-generated constructor stub
	}

	public Application(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
