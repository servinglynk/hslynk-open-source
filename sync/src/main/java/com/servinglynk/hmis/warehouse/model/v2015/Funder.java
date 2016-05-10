package com.servinglynk.hmis.warehouse.model.v2015;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class Funder extends BaseModel {
	@Column(name = "enddate")
	public Timestamp enddate;
	@Column(name = "funder")
	public String funder;
	@Column(name = "grantid")
	public String grantid;
	@Column(name = "projectid")
	public UUID projectid;
	@Column(name = "startdate")
	public Timestamp startdate;
	@Column(name = "id")
	public UUID id;
	

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * @return the enddate
	 */
	public Timestamp getEnddate() {
		return enddate;
	}

	/**
	 * @param enddate
	 *            the enddate to set
	 */
	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}

	/**
	 * @return the funder
	 */
	public String getFunder() {
		return funder;
	}

	/**
	 * @param funder
	 *            the funder to set
	 */
	public void setFunder(String funder) {
		this.funder = funder;
	}

	/**
	 * @return the grantid
	 */
	public String getGrantid() {
		return grantid;
	}

	/**
	 * @param grantid
	 *            the grantid to set
	 */
	public void setGrantid(String grantid) {
		this.grantid = grantid;
	}

	/**
	 * @return the projectid
	 */
	public UUID getProjectid() {
		return projectid;
	}

	/**
	 * @param projectid
	 *            the projectid to set
	 */
	public void setProjectid(UUID projectid) {
		this.projectid = projectid;
	}

	/**
	 * @return the startdate
	 */
	public Timestamp getStartdate() {
		return startdate;
	}

	/**
	 * @param startdate
	 *            the startdate to set
	 */
	public void setStartdate(Timestamp startdate) {
		this.startdate = startdate;
	}

}
