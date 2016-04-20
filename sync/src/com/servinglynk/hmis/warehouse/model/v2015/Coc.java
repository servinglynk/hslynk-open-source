package com.servinglynk.hmis.warehouse.model.v2015;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Coc extends BaseModel{
	@Column(name="coccode")
	private String coccode;
	@Column(name="projectid")
	private UUID projectid;
	@Column(name="id")
	private UUID id;
	public String getCoccode() {
		return coccode;
	}
	public void setCoccode(String coccode) {
		this.coccode = coccode;
	}
	public UUID getProjectid() {
		return projectid;
	}
	public void setProjectid(UUID projectid) {
		this.projectid = projectid;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	
	
}
