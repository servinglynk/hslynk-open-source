package com.servinglynk.hmis.warehouse.model.v2015;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Client extends BaseModel {
	@Column(name="dedup_client_id")
	public UUID dedup_client_id;
	@Column(name="first_name")
	public String first_name;
	@Column(name="middle_name")
	public String middle_name;
	@Column(name="last_name")
	public String last_name;
	@Column(name="name_suffix")
	public String name_suffix;
	@Column(name="name_data_quality")
	public String name_data_quality;
	@Column(name="ssn")		
	public String ssn;
	@Column(name="ssn_data_quality")
	public String ssn_data_quality;
	@Column(name="dob")		
	public String dob;
	@Column(name="dob_data_quality")
	public String dob_data_quality;
	@Column(name="gender")	
	public String gender;
	@Column(name="other_gender")
	public String other_gender;
	@Column(name="ethnicity")
	public String ethnicity;
	@Column(name="race")	
	public String race;
	@Column(name="veteran_status")
	public String veteran_status;

	public UUID getDedup_client_id() {
		return dedup_client_id;
	}
	public void setDedup_client_id(UUID dedup_client_id) {
		this.dedup_client_id = dedup_client_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getName_suffix() {
		return name_suffix;
	}
	public void setName_suffix(String name_suffix) {
		this.name_suffix = name_suffix;
	}
	public String getName_data_quality() {
		return name_data_quality;
	}
	public void setName_data_quality(String name_data_quality) {
		this.name_data_quality = name_data_quality;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getSsn_data_quality() {
		return ssn_data_quality;
	}
	public void setSsn_data_quality(String ssn_data_quality) {
		this.ssn_data_quality = ssn_data_quality;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDob_data_quality() {
		return dob_data_quality;
	}
	public void setDob_data_quality(String dob_data_quality) {
		this.dob_data_quality = dob_data_quality;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOther_gender() {
		return other_gender;
	}
	public void setOther_gender(String other_gender) {
		this.other_gender = other_gender;
	}
	public String getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getVeteran_status() {
		return veteran_status;
	}
	public void setVeteran_status(String veteran_status) {
		this.veteran_status = veteran_status;
	}
}
