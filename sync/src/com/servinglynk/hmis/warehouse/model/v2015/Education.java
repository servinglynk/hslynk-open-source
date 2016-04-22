package com.servinglynk.hmis.warehouse.model.v2015;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;


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
