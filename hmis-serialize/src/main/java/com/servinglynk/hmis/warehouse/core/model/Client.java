package com.servinglynk.hmis.warehouse.core.model;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("client")
public class Client extends ClientModel {
	
	private UUID clientId;	
	private String firstName;
	private String middleName;
	private String lastName;
	private String nameSuffix;
	private String nameDataQuality;
	private String ssn;
	private String ssnDataQuality;
	private Date dob;
	private String dobDataQuality;
	private String amIndAKNative;
	private String asian;
	private String blackAfAmerican;
	private String nativeHIOtherPacific;
	private String white;
	private String race;
	private String ethnicity;
	private String gender;
	private String otherGender;
	private String veteranStatus;
	public UUID getClientId() {
		return clientId;
	}
	public void setClientId(UUID clientId) {
		this.clientId = clientId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNameSuffix() {
		return nameSuffix;
	}
	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}
	public String getNameDataQuality() {
		return nameDataQuality;
	}
	public void setNameDataQuality(String nameDataQuality) {
		this.nameDataQuality = nameDataQuality;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getSsnDataQuality() {
		return ssnDataQuality;
	}
	public void setSsnDataQuality(String ssnDataQuality) {
		this.ssnDataQuality = ssnDataQuality;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getDobDataQuality() {
		return dobDataQuality;
	}
	public void setDobDataQuality(String dobDataQuality) {
		this.dobDataQuality = dobDataQuality;
	}
	public String getAmIndAKNative() {
		return amIndAKNative;
	}
	public void setAmIndAKNative(String amIndAKNative) {
		this.amIndAKNative = amIndAKNative;
	}
	public String getAsian() {
		return asian;
	}
	public void setAsian(String asian) {
		this.asian = asian;
	}
	public String getBlackAfAmerican() {
		return blackAfAmerican;
	}
	public void setBlackAfAmerican(String blackAfAmerican) {
		this.blackAfAmerican = blackAfAmerican;
	}
	public String getNativeHIOtherPacific() {
		return nativeHIOtherPacific;
	}
	public void setNativeHIOtherPacific(String nativeHIOtherPacific) {
		this.nativeHIOtherPacific = nativeHIOtherPacific;
	}
	public String getWhite() {
		return white;
	}
	public void setWhite(String white) {
		this.white = white;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOtherGender() {
		return otherGender;
	}
	public void setOtherGender(String otherGender) {
		this.otherGender = otherGender;
	}
	public String getVeteranStatus() {
		return veteranStatus;
	}
	public void setVeteranStatus(String veteranStatus) {
		this.veteranStatus = veteranStatus;
	}	
}