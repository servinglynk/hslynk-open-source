package com.servinglynk.hmis.warehouse.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Formerwardjuvenilejustice extends BaseModel {

	@Column(name = "formerwardjuvenilejustice")
	private String formerwardjuvenilejustice;
	@Column(name = "juvenilejusticemonths")
	private String juvenilejusticemonths;
	@Column(name = "juvenilejusticeyears")
	private String juvenilejusticeyears;
	@Column(name = "enrollmentid")
	private UUID enrollmentid;

	/**
	 * @return the formerwardjuvenilejustice
	 */
	public String getFormerwardjuvenilejustice() {
		return formerwardjuvenilejustice;
	}

	/**
	 * @param formerwardjuvenilejustice
	 *            the formerwardjuvenilejustice to set
	 */
	public void setFormerwardjuvenilejustice(String formerwardjuvenilejustice) {
		this.formerwardjuvenilejustice = formerwardjuvenilejustice;
	}

	/**
	 * @return the juvenilejusticemonths
	 */
	public String getJuvenilejusticemonths() {
		return juvenilejusticemonths;
	}

	/**
	 * @param juvenilejusticemonths
	 *            the juvenilejusticemonths to set
	 */
	public void setJuvenilejusticemonths(String juvenilejusticemonths) {
		this.juvenilejusticemonths = juvenilejusticemonths;
	}

	/**
	 * @return the juvenilejusticeyears
	 */
	public String getJuvenilejusticeyears() {
		return juvenilejusticeyears;
	}

	/**
	 * @param juvenilejusticeyears
	 *            the juvenilejusticeyears to set
	 */
	public void setJuvenilejusticeyears(String juvenilejusticeyears) {
		this.juvenilejusticeyears = juvenilejusticeyears;
	}

	/**
	 * @return the enrollmentid
	 */
	public UUID getEnrollmentid() {
		return enrollmentid;
	}

	/**
	 * @param enrollmentid
	 *            the enrollmentid to set
	 */
	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}

}
