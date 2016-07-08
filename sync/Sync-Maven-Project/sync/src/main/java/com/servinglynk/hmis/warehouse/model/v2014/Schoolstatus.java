package com.servinglynk.hmis.warehouse.model.v2014;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Schoolstatus extends BaseModel{
	@Column(name = "information_date")
	public Timestamp information_date;
	@Column(name = "school_status")
	public String school_status;
	@Column(name = "enrollmentid")
	public UUID enrollmentid;
	/**
	 * @return the information_date
	 */
	public Timestamp getInformation_date() {
		return information_date;
	}
	/**
	 * @param information_date the information_date to set
	 */
	public void setInformation_date(Timestamp information_date) {
		this.information_date = information_date;
	}
	/**
	 * @return the school_status
	 */
	public String getSchool_status() {
		return school_status;
	}
	/**
	 * @param school_status the school_status to set
	 */
	public void setSchool_status(String school_status) {
		this.school_status = school_status;
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
	
	
}
