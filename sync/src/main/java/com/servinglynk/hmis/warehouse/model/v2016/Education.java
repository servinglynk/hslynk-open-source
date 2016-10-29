package com.servinglynk.hmis.warehouse.model.v2016;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;


@Entity
public class Education extends BaseModel {

	@Column(name = "enrollmentid")
	private UUID enrollmentid;
	
	@Column( name = "id")
	private UUID id;
	
	@Column( name = "lastgradecompleted")
	private Integer lastgradecompleted;
	
	@Column( name = "school_status")
	private Integer school_status;
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

	public UUID getEnrollmentid() {
		return enrollmentid;
	}

	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}

	public java.util.UUID getId() {
		return id;
	}

	public void setId(java.util.UUID id) {
		this.id = id;
	}

	public Integer getLastgradecompleted() {
		return lastgradecompleted;
	}

	public void setLastgradecompleted(Integer lastgradecompleted) {
		this.lastgradecompleted = lastgradecompleted;
	}

	public Integer getSchool_status() {
		return school_status;
	}

	public void setSchool_status(Integer school_status) {
		this.school_status = school_status;
	}

	
	
	
	
}
