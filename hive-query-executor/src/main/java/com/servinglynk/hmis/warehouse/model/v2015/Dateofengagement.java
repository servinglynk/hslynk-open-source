package com.servinglynk.hmis.warehouse.model.v2015;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;
@Entity
public class Dateofengagement extends BaseModel{
	@Column(name="dateofengagement")
	public String dateofengagement;
	@Column(name="enrollmentid")
	public UUID enrollmentid;
	@Column(name="id")
	public UUID id;
	public String getDateofengagement() {
		return dateofengagement;
	}
	public void setDateofengagement(String dateofengagement) {
		this.dateofengagement = dateofengagement;
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
