package com.servinglynk.hmis.warehouse.core.model;

import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("client")
public class Client extends ClientModel {
	
	private UUID clientId;	
	private UUID dedupClientId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String nameSuffix;
	private Integer nameDataQuality;
	@Pattern(regexp="(^\\\\s+$|^[x0-9]{3}-[x0-9]{2}-[x0-9]{4}$|^$)",message="Invalid SSN. Valid format is XXX-XX-XXXX")
	private String ssn;
	private Integer ssnDataQuality;
	private Date dob;
	private Integer dobDataQuality;
	private String amIndAKNative;
	private String asian;
	private String blackAfAmerican;
	private String nativeHIOtherPacific;
	private String white;
	private Integer race;
	private Integer ethnicity;
	private Integer gender;
	private String otherGender;
	private String veteranStatus;
	private String sourceSystemId;
	private String phoneNumber;
	private String emailAddress;
	
	public UUID getClientId() {
		return clientId;
	}
	public void setClientId(UUID clientId) {
		this.clientId = clientId;
	}
	public UUID getDedupClientId() {
		return dedupClientId;
	}
	public void setDedupClientId(UUID dedupClientId) {
		this.dedupClientId = dedupClientId;
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
	public Integer getNameDataQuality() {
		return nameDataQuality;
	}
	public void setNameDataQuality(Integer nameDataQuality) {
		this.nameDataQuality = nameDataQuality;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public Integer getSsnDataQuality() {
		return ssnDataQuality;
	}
	public void setSsnDataQuality(Integer ssnDataQuality) {
		this.ssnDataQuality = ssnDataQuality;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Integer getDobDataQuality() {
		return dobDataQuality;
	}
	public void setDobDataQuality(Integer dobDataQuality) {
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
	public Integer getRace() {
		return race;
	}
	public void setRace(Integer race) {
		this.race = race;
	}
	public Integer getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(Integer ethnicity) {
		this.ethnicity = ethnicity;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
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
	public String getSourceSystemId() {
		return sourceSystemId;
	}
	public void setSourceSystemId(String sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}	
}