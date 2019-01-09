package com.example.amdocs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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
	  private Severity deffectSeverity;
	  private long solId;
	  
	  Deffects(){}

	public Deffects(long id, String errorCode, Severity deffectSeverity, long solId) {
		super();
		this.id = id;
		this.errorCode = errorCode;
		this.deffectSeverity = deffectSeverity;
		this.solId = solId;
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

	public Severity getDeffectSeverity() {
		return deffectSeverity;
	}

	public void setDeffectSeverity(Severity deffectSeverity) {
		this.deffectSeverity = deffectSeverity;
	}

	public long getSolId() {
		return solId;
	}

	public void setSolId(long solId) {
		this.solId = solId;
	}
	  
	
}
