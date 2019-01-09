package com.example.amdocs.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Deffect_instance {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	
	private long id;
	private long AppId,DefId,FileId;
	
	public Deffect_instance() {
		// TODO Auto-generated constructor stub
	}

	public Deffect_instance(long id, long appId, long defId, long fileId) {
		super();
		this.id = id;
		AppId = appId;
		DefId = defId;
		FileId = fileId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAppId() {
		return AppId;
	}

	public void setAppId(long appId) {
		AppId = appId;
	}

	public long getDefId() {
		return DefId;
	}

	public void setDefId(long defId) {
		DefId = defId;
	}

	public long getFileId() {
		return FileId;
	}

	public void setFileId(long fileId) {
		FileId = fileId;
	}
	
	
	
}
