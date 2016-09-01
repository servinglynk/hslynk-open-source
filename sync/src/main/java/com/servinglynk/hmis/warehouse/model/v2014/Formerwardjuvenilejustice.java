package com.servinglynk.hmis.warehouse.model.v2014;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class Formerwardjuvenilejustice extends BaseModel {

	@Column(name = "formerwardjuvenilejustice")
	public String formerwardjuvenilejustice;
	@Column(name = "juvenilejusticemonths")
	public String juvenilejusticemonths;
	@Column(name = "juvenilejusticeyears")
	public String juvenilejusticeyears;
	@Column(name = "enrollmentid")
	public UUID enrollmentid;
	@Column(name="datacollectionstage")
	public String datacollectionstage;
	@Column(name="information_date")
	private Date information_date;
	
	/**
	 * @return the datacollectionstage
	 */
	public String getDatacollectionstage() {
		return datacollectionstage;
	}

	/**
	 * @param datacollectionstage the datacollectionstage to set
	 */
	public void setDatacollectionstage(String datacollectionstage) {
		this.datacollectionstage = datacollectionstage;
	}

	/**
	 * @return the information_date
	 */
	public Date getInformation_date() {
		return information_date;
	}

	/**
	 * @param information_date the information_date to set
	 */
	public void setInformation_date(Date information_date) {
		this.information_date = information_date;
	}

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
