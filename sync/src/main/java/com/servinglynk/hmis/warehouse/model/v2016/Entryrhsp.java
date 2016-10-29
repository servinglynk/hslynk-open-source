package com.servinglynk.hmis.warehouse.model.v2016;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class Entryrhsp extends BaseModel {

	@Column(name = "enrollmentid")
	public UUID enrollmentid;
	@Column( name = "id")
	private java.util.UUID id;
	@Column( name = "worst_housing_situation")
	private Integer worst_housing_situation;
	
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
	public Integer getWorst_housing_situation() {
		return worst_housing_situation;
	}
	public void setWorst_housing_situation(Integer worst_housing_situation) {
		this.worst_housing_situation = worst_housing_situation;
	}
		
	
}
