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

import com.example.amdocs.domain.Application;


enum Severity 
{ 
    CRITICAL, WARNING, ERROR; 
}  

@Entity
public class Deffects {

	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private long id;
	  private String errorCode;
	  private String deffectSeverity;
	  private String solId;
	  private Set<Deffect_instance> deffectInstance;

	  
	  @ManyToMany(mappedBy = "Deffects") 
	  private Set<Application> applications;
	  
	  Deffects(){}

	public Deffects(String errorCode, String deffectSeverity, String solId) {
		super();
		this.errorCode = errorCode;
		this.deffectSeverity = deffectSeverity;
		this.solId = solId;
	}

	@OneToMany(mappedBy = "deffects")
	public Set<Deffect_instance> getDeffectInstance() {
		return deffectInstance;
	}

	public void setDeffectInstance(Set<Deffect_instance> deffectInstance) {
		this.deffectInstance = deffectInstance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getDeffectSeverity() {
		return deffectSeverity;
	}

	public void setDeffectSeverity(String deffectSeverity) {
		this.deffectSeverity = deffectSeverity;
	}

	public String getSolId() {
		return solId;
	}

	public void setSolId(String solId) {
		this.solId = solId;
	}
	  
	
}
