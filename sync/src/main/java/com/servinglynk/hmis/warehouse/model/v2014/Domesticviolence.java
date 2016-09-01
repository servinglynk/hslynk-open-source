package com.servinglynk.hmis.warehouse.model.v2014;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;
@Entity
public class Domesticviolence extends BaseModel {
	@Column(name="domesticviolencevictim")
	public String domesticviolencevictim;
	@Column(name="enrollmentid")		
	public UUID enrollmentid;
	@Column(name="whenoccurred")
	public String whenoccurred;
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
