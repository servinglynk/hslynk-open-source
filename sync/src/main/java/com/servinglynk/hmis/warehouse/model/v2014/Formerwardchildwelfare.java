package com.servinglynk.hmis.warehouse.model.v2014;

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
