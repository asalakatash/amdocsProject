package com.example.amdocs.domain;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "deffect_instance")
public class Deffect_instance implements Serializable {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	
	private long id;
	private Application app;
	private Deffects deff;
	private fileLog file;
	
	
	@Id
    @ManyToOne
    @JoinColumn(name = "deff_id")
	public Deffects getDeff() {
		return deff;
	}
	public void setDeff(Deffects deff) {
		this.deff = deff;
	}
	
	@Id
    @ManyToOne
    @JoinColumn(name = "app_id")
	public Application getApp() {
		return app;
	}

	public void setApp(Application app) {
		this.app = app;
	}

	
	@Id
    @ManyToOne
    @JoinColumn(name = "file_id")
	public fileLog getFile() {
		return file;
	}

	public void setFile(fileLog file) {
		this.file = file;
	}
	
	
}
