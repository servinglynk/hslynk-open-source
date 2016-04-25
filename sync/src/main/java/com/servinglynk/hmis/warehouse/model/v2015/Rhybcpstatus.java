package com.servinglynk.hmis.warehouse.model.v2015;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Rhybcpstatus extends BaseModel{
	@Column(name = "status_date")			
	public Date status_date;
	@Column(name = "fysb_youth")
	public Integer fysb_youth;
	@Column(name = "reason_no_services")
	public Integer reason_no_services;
	@Column(name = "enrollmentid")
	public UUID enrollmentid;
	@Column(name = "id")
	public UUID id;
	public Date getStatus_date() {
		return status_date;
	}
	public void setStatus_date(Date status_date) {
		this.status_date = status_date;
	}
	public Integer getFysb_youth() {
		return fysb_youth;
	}
	public void setFysb_youth(Integer fysb_youth) {
		this.fysb_youth = fysb_youth;
	}
	public Integer getReason_no_services() {
		return reason_no_services;
	}
	public void setReason_no_services(Integer reason_no_services) {
		this.reason_no_services = reason_no_services;
	}
	public UUID getEnrollmentid() {
		return enrollmentid;
	}
	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	

}
