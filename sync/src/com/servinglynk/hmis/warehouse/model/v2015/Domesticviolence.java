package com.servinglynk.hmis.warehouse.model.v2015;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class Domesticviolence extends BaseModel {
	@Column(name="domesticviolencevictim")
	public String domesticviolencevictim;
	@Column(name="id")		
	public UUID id;
	@Column(name="enrollmentid")		
	public UUID enrollmentid;
	@Column(name="whenoccurred")
	public String whenoccurred;
	@Column(name="currently_fleeing")
	public Integer currentlyFleeing;
	public String getDomesticviolencevictim() {
		return domesticviolencevictim;
	}
	public void setDomesticviolencevictim(String domesticviolencevictim) {
		this.domesticviolencevictim = domesticviolencevictim;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getEnrollmentid() {
		return enrollmentid;
	}
	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}
	public String getWhenoccurred() {
		return whenoccurred;
	}
	public void setWhenoccurred(String whenoccurred) {
		this.whenoccurred = whenoccurred;
	}
	public Integer getCurrentlyFleeing() {
		return currentlyFleeing;
	}
	public void setCurrentlyFleeing(Integer currentlyFleeing) {
		this.currentlyFleeing = currentlyFleeing;
	}
	
	
}
