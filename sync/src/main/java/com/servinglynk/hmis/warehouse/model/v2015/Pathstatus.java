package com.servinglynk.hmis.warehouse.model.v2015;

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
	public Integer client_enrolled_in_path;
	@Column(name = "reason_not_enrolled")	
	public Integer reason_not_enrolled;
	@Column(name = "enrollmentid")
	public UUID enrollmentid;
	@Column(name = "id")
	public UUID id;
	public Date getDate_of_status() {
		return date_of_status;
	}
	public void setDate_of_status(Date date_of_status) {
		this.date_of_status = date_of_status;
	}
	public Integer getClient_enrolled_in_path() {
		return client_enrolled_in_path;
	}
	public void setClient_enrolled_in_path(Integer client_enrolled_in_path) {
		this.client_enrolled_in_path = client_enrolled_in_path;
	}
	public Integer getReason_not_enrolled() {
		return reason_not_enrolled;
	}
	public void setReason_not_enrolled(Integer reason_not_enrolled) {
		this.reason_not_enrolled = reason_not_enrolled;
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
