package com.example.amdocs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class fileLog {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private long num;
	  private String name, date;
	  
	  public fileLog(){}

	public fileLog(String name, String date) {
		super();
		this.name = name;
		this.date = date;
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
