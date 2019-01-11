package com.example.amdocs.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class fileLog {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private long num;
	  private String name, date;
	    private Set<Deffect_instance> deffectInstance;

	    
	  public fileLog(){}

	public fileLog(String name, String date) {
		super();
		this.name = name;
		this.date = date;
	}
	@OneToMany(mappedBy = "filelog")
	public Set<Deffect_instance> getDeffectInstance() {
		return deffectInstance;
	}

	public void setDeffectInstance(Set<Deffect_instance> deffectInstance) {
		this.deffectInstance = deffectInstance;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	  
	  
	  
}
