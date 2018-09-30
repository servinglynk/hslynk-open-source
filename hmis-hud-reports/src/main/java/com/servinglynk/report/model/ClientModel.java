package com.servinglynk.report.model;

import java.sql.Date;

public class ClientModel extends BaseModel{
	public ClientModel() {
		
	}
	public ClientModel(String personalID, String dedup_client_id,
			String name_data_quality, String name_data_quality_desc,
			String ssn_data_quality, String ssn_data_quality_desc, Date dob,
			String dob_data_quality, String dob_data_quality_desc,
			String gender, String gender_desc, String other_gender,
			String ethnicity, String ethnicity_desc, String race,
			String race_desc, String veteran_status,
			String client_source_system_id, int age) {
		super();
		PersonalID = personalID;
		this.dedup_client_id = dedup_client_id;
		this.name_data_quality = name_data_quality;
		this.name_data_quality_desc = name_data_quality_desc;
		this.ssn_data_quality = ssn_data_quality;
		this.ssn_data_quality_desc = ssn_data_quality_desc;
		this.dob = dob;
		this.dob_data_quality = dob_data_quality;
		this.dob_data_quality_desc = dob_data_quality_desc;
		this.gender = gender;
		this.gender_desc = gender_desc;
		this.other_gender = other_gender;
		this.ethnicity = ethnicity;
		this.ethnicity_desc = ethnicity_desc;
		this.race = race;
		this.race_desc = race_desc;
		this.veteran_status = veteran_status;
		this.client_source_system_id = client_source_system_id;
		this.age = age;
	}
	private int age =0;
	private String PersonalID;
	private String dedup_client_id;
	private String name_data_quality;
	private String name_data_quality_desc; 
	private String ssn_data_quality;
	private String ssn_data_quality_desc;
	private Date dob;  
	private String dob_data_quality;
	private String dob_data_quality_desc;
	private String gender;
	private String gender_desc;
	private String other_gender;
	private String ethnicity;
	private String ethnicity_desc;
	private String race;
	private String race_desc;
	private String veteran_status;
	private String client_source_system_id;
	/**
	 * @return the personalID
	 */
	public String getPersonalID() {
		return PersonalID;
	}
	/**
	 * @param personalID the personalID to set
	 */
	public void setPersonalID(String personalID) {
		PersonalID = personalID;
	}
	/**
	 * @return the dedup_client_id
	 */
	public String getDedup_client_id() {
		return dedup_client_id;
	}
	/**
	 * @param dedup_client_id the dedup_client_id to set
	 */
	public void setDedup_client_id(String dedup_client_id) {
		this.dedup_client_id = dedup_client_id;
	}
	/**
	 * @return the name_data_quality
	 */
	public String getName_data_quality() {
		return name_data_quality;
	}
	/**
	 * @param name_data_quality the name_data_quality to set
	 */
	public void setName_data_quality(String name_data_quality) {
		this.name_data_quality = name_data_quality;
	}
	/**
	 * @return the name_data_quality_desc
	 */
	public String getName_data_quality_desc() {
		return name_data_quality_desc;
	}
	/**
	 * @param name_data_quality_desc the name_data_quality_desc to set
	 */
	public void setName_data_quality_desc(String name_data_quality_desc) {
		this.name_data_quality_desc = name_data_quality_desc;
	}
	/**
	 * @return the ssn_data_quality
	 */
	public String getSsn_data_quality() {
		return ssn_data_quality;
	}
	/**
	 * @param ssn_data_quality the ssn_data_quality to set
	 */
	public void setSsn_data_quality(String ssn_data_quality) {
		this.ssn_data_quality = ssn_data_quality;
	}
	/**
	 * @return the ssn_data_quality_desc
	 */
	public String getSsn_data_quality_desc() {
		return ssn_data_quality_desc;
	}
	/**
	 * @param ssn_data_quality_desc the ssn_data_quality_desc to set
	 */
	public void setSsn_data_quality_desc(String ssn_data_quality_desc) {
		this.ssn_data_quality_desc = ssn_data_quality_desc;
	}
	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	/**
	 * @return the dob
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setAge(int dob) {
		this.age = dob;
	}
	/**
	 * @return the dob_data_quality
	 */
	public String getDob_data_quality() {
		return dob_data_quality;
	}
	/**
	 * @param dob_data_quality the dob_data_quality to set
	 */
	public void setDob_data_quality(String dob_data_quality) {
		this.dob_data_quality = dob_data_quality;
	}
	/**
	 * @return the dob_data_quality_desc
	 */
	public String getDob_data_quality_desc() {
		return dob_data_quality_desc;
	}
	/**
	 * @param dob_data_quality_desc the dob_data_quality_desc to set
	 */
	public void setDob_data_quality_desc(String dob_data_quality_desc) {
		this.dob_data_quality_desc = dob_data_quality_desc;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the gender_desc
	 */
	public String getGender_desc() {
		return gender_desc;
	}
	/**
	 * @param gender_desc the gender_desc to set
	 */
	public void setGender_desc(String gender_desc) {
		this.gender_desc = gender_desc;
	}
	/**
	 * @return the other_gender
	 */
	public String getOther_gender() {
		return other_gender;
	}
	/**
	 * @param other_gender the other_gender to set
	 */
	public void setOther_gender(String other_gender) {
		this.other_gender = other_gender;
	}
	/**
	 * @return the ethnicity
	 */
	public String getEthnicity() {
		return ethnicity;
	}
	/**
	 * @param ethnicity the ethnicity to set
	 */
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	/**
	 * @return the ethnicity_desc
	 */
	public String getEthnicity_desc() {
		return ethnicity_desc;
	}
	/**
	 * @param ethnicity_desc the ethnicity_desc to set
	 */
	public void setEthnicity_desc(String ethnicity_desc) {
		this.ethnicity_desc = ethnicity_desc;
	}
	/**
	 * @return the race
	 */
	public String getRace() {
		return race;
	}
	/**
	 * @param race the race to set
	 */
	public void setRace(String race) {
		this.race = race;
	}
	/**
	 * @return the race_desc
	 */
	public String getRace_desc() {
		return race_desc;
	}
	/**
	 * @param race_desc the race_desc to set
	 */
	public void setRace_desc(String race_desc) {
		this.race_desc = race_desc;
	}
	/**
	 * @return the veteran_status
	 */
	public String getVeteran_status() {
		return veteran_status;
	}
	/**
	 * @param veteran_status the veteran_status to set
	 */
	public void setVeteran_status(String veteran_status) {
		this.veteran_status = veteran_status;
	}
	/**
	 * @return the client_source_system_id
	 */
	public String getClient_source_system_id() {
		return client_source_system_id;
	}
	/**
	 * @param client_source_system_id the client_source_system_id to set
	 */
	public void setClient_source_system_id(String client_source_system_id) {
		this.client_source_system_id = client_source_system_id;
	}
	
}
