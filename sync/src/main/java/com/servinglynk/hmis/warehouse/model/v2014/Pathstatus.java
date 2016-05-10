package com.servinglynk.hmis.warehouse.model.v2014;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class Pathstatus extends BaseModel {
	@Column(name = "date_of_status")
	public Date date_of_status;
	@Column(name = "client_enrolled_in_path")
	public String client_enrolled_in_path;
	@Column(name = "reason_not_enrolled")	
	public String reason_not_enrolled;
	@Column(name = "enrollmentid")
	public UUID enrollmentid;
	/**
	 * @return the date_of_status
	 */
	public Date getDate_of_status() {
		return date_of_status;
	}
	/**
	 * @param date_of_status the date_of_status to set
	 */
	public void setDate_of_status(Date date_of_status) {
		this.date_of_status = date_of_status;
	}
	/**
	 * @return the client_enrolled_in_path
	 */
	public String getClient_enrolled_in_path() {
		return client_enrolled_in_path;
	}
	/**
	 * @param client_enrolled_in_path the client_enrolled_in_path to set
	 */
	public void setClient_enrolled_in_path(String client_enrolled_in_path) {
		this.client_enrolled_in_path = client_enrolled_in_path;
	}
	/**
	 * @return the reason_not_enrolled
	 */
	public String getReason_not_enrolled() {
		return reason_not_enrolled;
	}
	/**
	 * @param reason_not_enrolled the reason_not_enrolled to set
	 */
	public void setReason_not_enrolled(String reason_not_enrolled) {
		this.reason_not_enrolled = reason_not_enrolled;
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
