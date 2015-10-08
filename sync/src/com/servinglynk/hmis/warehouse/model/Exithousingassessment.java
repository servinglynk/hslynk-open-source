package com.servinglynk.hmis.warehouse.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Exithousingassessment extends BaseModel {

	@Column(name = "exitid")
	private UUID exitid;
	@Column(name = "housingassessment")
	private String housingassessment;
	@Column(name = "subsidyinformation")
	private String subsidyinformation;

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
