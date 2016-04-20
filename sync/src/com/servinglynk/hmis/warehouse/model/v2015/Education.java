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
	private Integer schoolStatus;

	
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

	public Integer getSchoolStatus() {
		return schoolStatus;
	}

	public void setSchoolStatus(Integer schoolStatus) {
		this.schoolStatus = schoolStatus;
	}
	
	
	
}
