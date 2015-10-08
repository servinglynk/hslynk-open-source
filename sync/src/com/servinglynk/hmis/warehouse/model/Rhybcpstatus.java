package com.servinglynk.hmis.warehouse.model;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Rhybcpstatus extends BaseModel{
	@Column(name = "status_date")			
	private Date status_date;
	@Column(name = "fysb_youth")
	private String fysb_youth;
	@Column(name = "reason_no_services")
	private String reason_no_services;
	@Column(name = "enrollmentid")
	private UUID enrollmentid;
	/**
	 * @return the status_date
	 */
	public Date getStatus_date() {
		return status_date;
	}
	/**
	 * @param status_date the status_date to set
	 */
	public void setStatus_date(Date status_date) {
		this.status_date = status_date;
	}
	/**
	 * @return the fysb_youth
	 */
	public String getFysb_youth() {
		return fysb_youth;
	}
	/**
	 * @param fysb_youth the fysb_youth to set
	 */
	public void setFysb_youth(String fysb_youth) {
		this.fysb_youth = fysb_youth;
	}
	/**
	 * @return the reason_no_services
	 */
	public String getReason_no_services() {
		return reason_no_services;
	}
	/**
	 * @param reason_no_services the reason_no_services to set
	 */
	public void setReason_no_services(String reason_no_services) {
		this.reason_no_services = reason_no_services;
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
