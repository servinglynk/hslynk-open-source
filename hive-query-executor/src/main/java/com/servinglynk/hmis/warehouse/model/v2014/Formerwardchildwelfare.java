package com.servinglynk.hmis.warehouse.model.v2014;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class Formerwardchildwelfare extends BaseModel {

	@Column(name = "childwelfaremonths")
	public String childwelfaremonths;
	@Column(name = "childwelfareyears")
	public String childwelfareyears;
	@Column(name = "formerwardchildwelfare")
	public String formerwardchildwelfare;
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
	 * @return the childwelfaremonths
	 */
	public String getChildwelfaremonths() {
		return childwelfaremonths;
	}

	/**
	 * @param childwelfaremonths
	 *            the childwelfaremonths to set
	 */
	public void setChildwelfaremonths(String childwelfaremonths) {
		this.childwelfaremonths = childwelfaremonths;
	}

	/**
	 * @return the childwelfareyears
	 */
	public String getChildwelfareyears() {
		return childwelfareyears;
	}

	/**
	 * @param childwelfareyears
	 *            the childwelfareyears to set
	 */
	public void setChildwelfareyears(String childwelfareyears) {
		this.childwelfareyears = childwelfareyears;
	}

	/**
	 * @return the formerwardchildwelfare
	 */
	public String getFormerwardchildwelfare() {
		return formerwardchildwelfare;
	}

	/**
	 * @param formerwardchildwelfare
	 *            the formerwardchildwelfare to set
	 */
	public void setFormerwardchildwelfare(String formerwardchildwelfare) {
		this.formerwardchildwelfare = formerwardchildwelfare;
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
