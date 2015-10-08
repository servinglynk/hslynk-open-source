package com.servinglynk.hmis.warehouse.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Funder extends BaseModel {
	@Column(name = "enddate")
	private Date enddate;
	@Column(name = "funder")
	private String funder;
	@Column(name = "grantid")
	private UUID grantid;
	@Column(name = "projectid")
	private UUID projectid;
	@Column(name = "startdate")
	private Date startdate;

	/**
	 * @return the enddate
	 */
	public Date getEnddate() {
		return enddate;
	}

	/**
	 * @param enddate
	 *            the enddate to set
	 */
	public void setEnddate(Date enddate) {
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
	public UUID getGrantid() {
		return grantid;
	}

	/**
	 * @param grantid
	 *            the grantid to set
	 */
	public void setGrantid(UUID grantid) {
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
	public Date getStartdate() {
		return startdate;
	}

	/**
	 * @param startdate
	 *            the startdate to set
	 */
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

}
