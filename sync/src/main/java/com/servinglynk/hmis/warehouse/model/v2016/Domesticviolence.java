package com.servinglynk.hmis.warehouse.model.v2016;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;
@Entity
public class Domesticviolence extends BaseModel {
	@Column(name="domesticviolencevictim")
	public String domesticviolencevictim;
	@Column(name="id")		
	public UUID id;
	@Column(name="enrollmentid")		
	public UUID enrollmentid;
	@Column(name="whenoccurred")
	public String whenoccurred;
	@Column(name="currently_fleeing")
	public Integer currently_fleeing;
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
	public String getDomesticviolencevictim() {
		return domesticviolencevictim;
	}
	public void setDomesticviolencevictim(String domesticviolencevictim) {
		this.domesticviolencevictim = domesticviolencevictim;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getEnrollmentid() {
		return enrollmentid;
	}
	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}
	public String getWhenoccurred() {
		return whenoccurred;
	}
	public void setWhenoccurred(String whenoccurred) {
		this.whenoccurred = whenoccurred;
	}
	public Integer getCurrently_fleeing() {
		return currently_fleeing;
	}
	public void setCurrently_fleeing(Integer currently_fleeing) {
		this.currently_fleeing = currently_fleeing;
	}
	
	
}
