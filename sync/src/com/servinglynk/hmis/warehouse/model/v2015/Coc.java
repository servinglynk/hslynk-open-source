package com.servinglynk.hmis.warehouse.model.v2015;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Coc extends BaseModel{
	@Column(name="coccode")
	private String coccode;
	@Column(name="projectid")
	private String projectid;
	public String getCoccode() {
		return coccode;
	}
	public void setCoccode(String coccode) {
		this.coccode = coccode;
	}
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	
}
