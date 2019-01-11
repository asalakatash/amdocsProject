package com.example.amdocs.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.example.amdocs.domain.Deffects;


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
    private Set<Deffect_instance> deffectInstance;

    
	public Application() {
		// TODO Auto-generated constructor stub
	}
	@OneToMany(mappedBy = "application")
	public Set<Deffect_instance> getDeffectInstance() {
		return deffectInstance;
	}

	public void setDeffectInstance(Set<Deffect_instance> deffectInstance) {
		this.deffectInstance = deffectInstance;
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
