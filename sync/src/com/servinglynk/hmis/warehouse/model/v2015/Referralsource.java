package com.servinglynk.hmis.warehouse.model.v2015;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Referralsource extends BaseModel {
	@Column(name = "countoutreachreferralapproaches")
	public String countoutreachreferralapproaches;
	@Column(name = "enrollmentid")
	public UUID enrollmentid;
	@Column(name = "referralsource")
	public String referralsource;
	/**
	 * @return the countoutreachreferralapproaches
	 */
	public String getCountoutreachreferralapproaches() {
		return countoutreachreferralapproaches;
	}
	/**
	 * @param countoutreachreferralapproaches the countoutreachreferralapproaches to set
	 */
	public void setCountoutreachreferralapproaches(
			String countoutreachreferralapproaches) {
		this.countoutreachreferralapproaches = countoutreachreferralapproaches;
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
	 * @return the referralsource
	 */
	public String getReferralsource() {
		return referralsource;
	}
	/**
	 * @param referralsource the referralsource to set
	 */
	public void setReferralsource(String referralsource) {
		this.referralsource = referralsource;
	}
	
}
