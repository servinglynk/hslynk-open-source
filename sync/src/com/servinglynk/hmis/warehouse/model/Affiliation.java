package com.servinglynk.hmis.warehouse.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Affiliation extends BaseModel{
	@Column(name="projectid")
	private UUID projectid;
	@Column(name="resprojectid")
	private UUID resprojectid;
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
	/**
	 * @return the resprojectid
	 */
	public UUID getResprojectid() {
		return resprojectid;
	}
	/**
	 * @param resprojectid the resprojectid to set
	 */
	public void setResprojectid(UUID resprojectid) {
		this.resprojectid = resprojectid;
	}
	
}
