package com.servinglynk.hmis.warehouse.model.v2016;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class Exit extends BaseModel {

	@Column(name = "destination")
	public Integer destination;
	@Column(name = "exitdate")
	public Timestamp exitdate;
	@Column(name = "otherdestination")
	public String otherdestination;
	@Column(name = "enrollmentid")
	public UUID enrollmentid;
	@Column(name = "id")
	public UUID id;
	public Integer getDestination() {
		return destination;
	}
	public void setDestination(Integer destination) {
		this.destination = destination;
	}
	public Timestamp getExitdate() {
		return exitdate;
	}
	public void setExitdate(Timestamp exitdate) {
		this.exitdate = exitdate;
	}
	public String getOtherdestination() {
		return otherdestination;
	}
	public void setOtherdestination(String otherdestination) {
		this.otherdestination = otherdestination;
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
