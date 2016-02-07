package com.servinglynk.hmis.warehouse.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class Services extends BaseModel{
	@Column(name = "dateprovided")		
	public Timestamp dateprovided;
	@Column(name = "faamount")		
	public double faamount;
	@Column(name = "othertypeprovided")
	public String othertypeprovided;
	@Column(name = "enrollmentid")
	public UUID enrollmentid;
	@Column(name = "recordtype")		
	public String recordtype;
	@Column(name = "referraloutcome")
	public String referraloutcome;
	@Column(name = "subtypeprovided")
	public String subtypeprovided;
	@Column(name = "typeprovided")
	public String typeprovided;
	/**
	 * @return the dateprovided
	 */
	public Timestamp getDateprovided() {
		return dateprovided;
	}
	/**
	 * @param dateprovided the dateprovided to set
	 */
	public void setDateprovided(Timestamp dateprovided) {
		this.dateprovided = dateprovided;
	}
	/**
	 * @return the faamount
	 */
	public double getFaamount() {
		return faamount;
	}
	/**
	 * @param faamount the faamount to set
	 */
	public void setFaamount(double faamount) {
		this.faamount = faamount;
	}
	/**
	 * @return the othertypeprovided
	 */
	public String getOthertypeprovided() {
		return othertypeprovided;
	}
	/**
	 * @param othertypeprovided the othertypeprovided to set
	 */
	public void setOthertypeprovided(String othertypeprovided) {
		this.othertypeprovided = othertypeprovided;
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
	 * @return the recordtype
	 */
	public String getRecordtype() {
		return recordtype;
	}
	/**
	 * @param recordtype the recordtype to set
	 */
	public void setRecordtype(String recordtype) {
		this.recordtype = recordtype;
	}
	/**
	 * @return the referraloutcome
	 */
	public String getReferraloutcome() {
		return referraloutcome;
	}
	/**
	 * @param referraloutcome the referraloutcome to set
	 */
	public void setReferraloutcome(String referraloutcome) {
		this.referraloutcome = referraloutcome;
	}
	/**
	 * @return the subtypeprovided
	 */
	public String getSubtypeprovided() {
		return subtypeprovided;
	}
	/**
	 * @param subtypeprovided the subtypeprovided to set
	 */
	public void setSubtypeprovided(String subtypeprovided) {
		this.subtypeprovided = subtypeprovided;
	}
	/**
	 * @return the typeprovided
	 */
	public String getTypeprovided() {
		return typeprovided;
	}
	/**
	 * @param typeprovided the typeprovided to set
	 */
	public void setTypeprovided(String typeprovided) {
		this.typeprovided = typeprovided;
	}
	

}
