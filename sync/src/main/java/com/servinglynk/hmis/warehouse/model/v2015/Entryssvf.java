package com.servinglynk.hmis.warehouse.model.v2015;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;


@Entity
public class Entryssvf extends BaseModel {


	@Column( name = "address_data_quality")
	private Integer address_data_quality;
	
	@Column(name = "enrollmentid")
	private Enrollment enrollmentid;
	
	@Column( name = "hp_screen_score")
	private Integer hp_screen_score;
	
	@Column( name = "id")
	private java.util.UUID id;
	
	@Column( name = "last_permanent_city")
	private String last_permanent_city;
	
	@Column( name = "last_permanent_state")
	private String last_permanent_state;
	
	@Column( name = "last_permanent_street")
	private String last_permanent_street;
	
	@Column( name = "last_permanent_zip")
	private String last_permanent_zip;
	
	@Column( name = "percentami")
	private Integer percentami;
	
	@Column( name = "vamc_staction")
	private String vamc_staction;

	public Integer getAddress_data_quality() {
		return address_data_quality;
	}

	public void setAddress_data_quality(Integer address_data_quality) {
		this.address_data_quality = address_data_quality;
	}

	public Enrollment getEnrollmentid() {
		return enrollmentid;
	}

	public void setEnrollmentid(Enrollment enrollmentid) {
		this.enrollmentid = enrollmentid;
	}

	public Integer getHp_screen_score() {
		return hp_screen_score;
	}

	public void setHp_screen_score(Integer hp_screen_score) {
		this.hp_screen_score = hp_screen_score;
	}

	public java.util.UUID getId() {
		return id;
	}

	public void setId(java.util.UUID id) {
		this.id = id;
	}

	public String getLast_permanent_city() {
		return last_permanent_city;
	}

	public void setLast_permanent_city(String last_permanent_city) {
		this.last_permanent_city = last_permanent_city;
	}

	public String getLast_permanent_state() {
		return last_permanent_state;
	}

	public void setLast_permanent_state(String last_permanent_state) {
		this.last_permanent_state = last_permanent_state;
	}

	public String getLast_permanent_street() {
		return last_permanent_street;
	}

	public void setLast_permanent_street(String last_permanent_street) {
		this.last_permanent_street = last_permanent_street;
	}

	public String getLast_permanent_zip() {
		return last_permanent_zip;
	}

	public void setLast_permanent_zip(String last_permanent_zip) {
		this.last_permanent_zip = last_permanent_zip;
	}

	public Integer getPercentami() {
		return percentami;
	}

	public void setPercentami(Integer percentami) {
		this.percentami = percentami;
	}

	public String getVamc_staction() {
		return vamc_staction;
	}

	public void setVamc_staction(String vamc_staction) {
		this.vamc_staction = vamc_staction;
	}

	
}
