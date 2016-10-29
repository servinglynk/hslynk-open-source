package com.servinglynk.hmis.warehouse.model.v2016;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class Exithousingassessment extends BaseModel {

	@Column(name = "exitid")
	public UUID exitid;
	@Column(name = "housingassessment")
	public Integer housingassessment;
	@Column(name = "subsidyinformation")
	public Integer subsidyinformation;
	@Column(name = "id")
	public UUID id;
	public UUID getExitid() {
		return exitid;
	}
	public void setExitid(UUID exitid) {
		this.exitid = exitid;
	}
	public Integer getHousingassessment() {
		return housingassessment;
	}
	public void setHousingassessment(Integer housingassessment) {
		this.housingassessment = housingassessment;
	}
	public Integer getSubsidyinformation() {
		return subsidyinformation;
	}
	public void setSubsidyinformation(Integer subsidyinformation) {
		this.subsidyinformation = subsidyinformation;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}

	
}
