package com.servinglynk.hmis.warehouse.model.v2015;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Entryrhsp extends BaseModel {

	@Column(name = "enrollmentid")
	public UUID enrollmentid;
	@Column( name = "id")
	private java.util.UUID id;
	@Column( name = "worst_housing_situation")
	private Integer worstHousingSituation;
	
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
	public Integer getWorstHousingSituation() {
		return worstHousingSituation;
	}
	public void setWorstHousingSituation(Integer worstHousingSituation) {
		this.worstHousingSituation = worstHousingSituation;
	}
	
	
}
