package com.servinglynk.hmis.warehouse.model.v2014;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class Referralsource extends BaseModel {
	@Column(name = "countoutreachreferralapproaches")
	public String countoutreachreferralapproaches;
	@Column(name = "enrollmentid")
	public UUID enrollmentid;
	@Column(name = "referralsource")
	public String referralsource;
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
