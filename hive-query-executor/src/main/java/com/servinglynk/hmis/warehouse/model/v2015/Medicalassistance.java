package com.servinglynk.hmis.warehouse.model.v2015;

import java.sql.Date;
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
	@Column(name="datacollectionstage")
	public String datacollectionstage;
	@Column(name="information_date")
	private Date information_date;
	
	/**
	 * @return the datacollectionstage
	 */
	public String getDatacollectionstage() {
		return datacollectionstage;
	}
	/**
	 * @param datacollectionstage the datacollectionstage to set
	 */
	public void setDatacollectionstage(String datacollectionstage) {
		this.datacollectionstage = datacollectionstage;
	}
	/**
	 * @return the information_date
	 */
	public Date getInformation_date() {
		return information_date;
	}
	/**
	 * @param information_date the information_date to set
	 */
	public void setInformation_date(Date information_date) {
		this.information_date = information_date;
	}
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
