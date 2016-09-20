package com.servinglynk.hmis.warehouse.model.v2014;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class Exithousingassessment extends BaseModel {

	@Column(name = "exitid")
	public UUID exitid;
	@Column(name = "housingassessment")
	public String housingassessment;
	@Column(name = "subsidyinformation")
	public String subsidyinformation;

	/**
	 * @return the exitid
	 */
	public UUID getExitid() {
		return exitid;
	}

	/**
	 * @param exitid
	 *            the exitid to set
	 */
	public void setExitid(UUID exitid) {
		this.exitid = exitid;
	}

	/**
	 * @return the housingassessment
	 */
	public String getHousingassessment() {
		return housingassessment;
	}

	/**
	 * @param housingassessment
	 *            the housingassessment to set
	 */
	public void setHousingassessment(String housingassessment) {
		this.housingassessment = housingassessment;
	}

	/**
	 * @return the subsidyinformation
	 */
	public String getSubsidyinformation() {
		return subsidyinformation;
	}

	/**
	 * @param subsidyinformation
	 *            the subsidyinformation to set
	 */
	public void setSubsidyinformation(String subsidyinformation) {
		this.subsidyinformation = subsidyinformation;
	}

}
