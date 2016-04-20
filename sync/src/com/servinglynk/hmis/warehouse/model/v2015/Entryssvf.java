package com.servinglynk.hmis.warehouse.model.v2015;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class Entryssvf extends BaseModel {


	@Column( name = "address_data_quality")
	private Integer addressDataQuality;
	
	@Column(name = "enrollmentid")
	private Enrollment enrollmentid;
	
	@Column( name = "hp_screen_score")
	private Integer hpScreeningScore;
	
	@Column( name = "id")
	private java.util.UUID id;
	
	@Column( name = "last_permanent_city")
	private String lastPermanentCity;
	
	@Column( name = "last_permanent_state")
	private String lastPermanentState;
	
	@Column( name = "last_permanent_street")
	private String lastPermanentStreet;
	
	@Column( name = "last_permanent_zip")
	private String lastPermanentZip;
	
	@Column( name = "percentami")
	private Integer percentami;
	
	@Column( name = "vamc_staction")
	private String vamcStation;

	public Integer getAddressDataQuality() {
		return addressDataQuality;
	}

	public void setAddressDataQuality(Integer addressDataQuality) {
		this.addressDataQuality = addressDataQuality;
	}

	public Enrollment getEnrollmentid() {
		return enrollmentid;
	}

	public void setEnrollmentid(Enrollment enrollmentid) {
		this.enrollmentid = enrollmentid;
	}

	public Integer getHpScreeningScore() {
		return hpScreeningScore;
	}

	public void setHpScreeningScore(Integer hpScreeningScore) {
		this.hpScreeningScore = hpScreeningScore;
	}

	public java.util.UUID getId() {
		return id;
	}

	public void setId(java.util.UUID id) {
		this.id = id;
	}

	public String getLastPermanentCity() {
		return lastPermanentCity;
	}

	public void setLastPermanentCity(String lastPermanentCity) {
		this.lastPermanentCity = lastPermanentCity;
	}

	public String getLastPermanentState() {
		return lastPermanentState;
	}

	public void setLastPermanentState(String lastPermanentState) {
		this.lastPermanentState = lastPermanentState;
	}

	public String getLastPermanentStreet() {
		return lastPermanentStreet;
	}

	public void setLastPermanentStreet(String lastPermanentStreet) {
		this.lastPermanentStreet = lastPermanentStreet;
	}

	public String getLastPermanentZip() {
		return lastPermanentZip;
	}

	public void setLastPermanentZip(String lastPermanentZip) {
		this.lastPermanentZip = lastPermanentZip;
	}

	public Integer getPercentami() {
		return percentami;
	}

	public void setPercentami(Integer percentami) {
		this.percentami = percentami;
	}

	public String getVamcStation() {
		return vamcStation;
	}

	public void setVamcStation(String vamcStation) {
		this.vamcStation = vamcStation;
	}

	
   
}
