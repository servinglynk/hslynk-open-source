package com.servinglynk.hmis.warehouse.model;

import java.util.UUID;

import javax.persistence.Column;

public class Domesticviolence extends BaseModel {
	@Column(name="domesticviolencevictim")
	private String domesticviolencevictim;
	@Column(name="enrollmentid")		
	private UUID enrollmentid;
	@Column(name="whenoccurred")
	private String whenoccurred;
	/**
	 * @return the domesticviolencevictim
	 */
	public String getDomesticviolencevictim() {
		return domesticviolencevictim;
	}
	/**
	 * @param domesticviolencevictim the domesticviolencevictim to set
	 */
	public void setDomesticviolencevictim(String domesticviolencevictim) {
		this.domesticviolencevictim = domesticviolencevictim;
	}
	/**
	 * @return the enrollmentid
	 */
	public UUID getEnrollmentid() {
		return enrollmentid;
	}
	/**
	 * @param enrollmentid the enrollmentid to set
	 */
	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}
	/**
	 * @return the whenoccurred
	 */
	public String getWhenoccurred() {
		return whenoccurred;
	}
	/**
	 * @param whenoccurred the whenoccurred to set
	 */
	public void setWhenoccurred(String whenoccurred) {
		this.whenoccurred = whenoccurred;
	}
	
}
