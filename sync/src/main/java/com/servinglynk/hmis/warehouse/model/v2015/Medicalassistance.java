package com.servinglynk.hmis.warehouse.model.v2015;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class Medicalassistance extends BaseModel {

	@Column(name = "adap")			
	public Integer  adap;
	@Column(name = "hivaidsassistance")
	public Integer  hivaidsassistance;
	@Column(name = "noadapreason")
	public Integer  noadapreason;
	@Column(name = "nohivaidsassistancereason")
	public Integer  nohivaidsassistancereason;
	@Column(name = "enrollmentid")
	public UUID  enrollmentid;
	@Column(name = "id")
	public UUID  id;
	public Integer getAdap() {
		return adap;
	}
	public void setAdap(Integer adap) {
		this.adap = adap;
	}
	public Integer getHivaidsassistance() {
		return hivaidsassistance;
	}
	public void setHivaidsassistance(Integer hivaidsassistance) {
		this.hivaidsassistance = hivaidsassistance;
	}
	public Integer getNoadapreason() {
		return noadapreason;
	}
	public void setNoadapreason(Integer noadapreason) {
		this.noadapreason = noadapreason;
	}
	public Integer getNohivaidsassistancereason() {
		return nohivaidsassistancereason;
	}
	public void setNohivaidsassistancereason(Integer nohivaidsassistancereason) {
		this.nohivaidsassistancereason = nohivaidsassistancereason;
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
