package com.servinglynk.hmis.warehouse.model.v2015;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class Affiliation extends BaseModel{
	@Column(name="projectid")
	private UUID projectid;
	@Column(name="resprojectid")
	private String resprojectid;
	@Column(name="id")
	private UUID id;
	public UUID getProjectid() {
		return projectid;
	}
	public void setProjectid(UUID projectid) {
		this.projectid = projectid;
	}
	public String getResprojectid() {
		return resprojectid;
	}
	public void setResprojectid(String resprojectid) {
		this.resprojectid = resprojectid;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	
	
	
}
