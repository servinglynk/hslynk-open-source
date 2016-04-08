package com.servinglynk.hmis.warehouse.model.v2015;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Projectcoc extends BaseModel{
	@Column(name = "coccode")	
	public String coccode;
	@Column(name = "projectid")
	public UUID projectid;
	/**
	 * @return the coccode
	 */
	public String getCoccode() {
		return coccode;
	}
	/**
	 * @param coccode the coccode to set
	 */
	public void setCoccode(String coccode) {
		this.coccode = coccode;
	}
	/**
	 * @return the projectid
	 */
	public UUID getProjectid() {
		return projectid;
	}
	/**
	 * @param projectid the projectid to set
	 */
	public void setProjectid(UUID projectid) {
		this.projectid = projectid;
	}
	

}
