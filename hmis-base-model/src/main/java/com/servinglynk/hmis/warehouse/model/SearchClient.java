package com.servinglynk.hmis.warehouse.model;

import java.time.LocalDateTime;

import com.servinglynk.hmis.warehouse.enums.ClientDobDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientEthnicityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientGenderEnum;
import com.servinglynk.hmis.warehouse.enums.ClientNameDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientRaceEnum;
import com.servinglynk.hmis.warehouse.enums.ClientSsnDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientVeteranStatusEnum;

public class SearchClient {
	private java.util.UUID rDedupClientId;
	private ClientDobDataQualityEnum rDobDataQuality;
	private ClientEthnicityEnum rEthnicity;
	private String rFirstName;
	private ClientGenderEnum rGender;
	private java.util.UUID rId;
	private String rLastName;
	private String rMiddleName;
	private ClientNameDataQualityEnum rNameDataQuality;
	private String rNameSuffix;
	private String rOtherGender;
	private ClientRaceEnum rRace;
	private String rSsn;
	private ClientSsnDataQualityEnum rSsnDataQuality;
	private ClientVeteranStatusEnum rVeteranStatus;
	private LocalDateTime rDob;
	private String rSourceSystemId;
	private String rSchemaYear;
	private String rPhoneNumber;
	private String rEmailAddress;
	private String rProjectGroupCode;
	public java.util.UUID getrDedupClientId() {
		return rDedupClientId;
	}
	public void setrDedupClientId(java.util.UUID rDedupClientId) {
		this.rDedupClientId = rDedupClientId;
	}
	public ClientDobDataQualityEnum getrDobDataQuality() {
		return rDobDataQuality;
	}
	public void setrDobDataQuality(ClientDobDataQualityEnum rDobDataQuality) {
		this.rDobDataQuality = rDobDataQuality;
	}
	public ClientEthnicityEnum getrEthnicity() {
		return rEthnicity;
	}
	public void setrEthnicity(ClientEthnicityEnum rEthnicity) {
		this.rEthnicity = rEthnicity;
	}
	public String getrFirstName() {
		return rFirstName;
	}
	public void setrFirstName(String rFirstName) {
		this.rFirstName = rFirstName;
	}
	public ClientGenderEnum getrGender() {
		return rGender;
	}
	public void setrGender(ClientGenderEnum rGender) {
		this.rGender = rGender;
	}
	public java.util.UUID getrId() {
		return rId;
	}
	public void setrId(java.util.UUID rId) {
		this.rId = rId;
	}
	public String getrLastName() {
		return rLastName;
	}
	public void setrLastName(String rLastName) {
		this.rLastName = rLastName;
	}
	public String getrMiddleName() {
		return rMiddleName;
	}
	public void setrMiddleName(String rMiddleName) {
		this.rMiddleName = rMiddleName;
	}
	public ClientNameDataQualityEnum getrNameDataQuality() {
		return rNameDataQuality;
	}
	public void setrNameDataQuality(ClientNameDataQualityEnum rNameDataQuality) {
		this.rNameDataQuality = rNameDataQuality;
	}
	public String getrNameSuffix() {
		return rNameSuffix;
	}
	public void setrNameSuffix(String rNameSuffix) {
		this.rNameSuffix = rNameSuffix;
	}
	public String getrOtherGender() {
		return rOtherGender;
	}
	public void setrOtherGender(String rOtherGender) {
		this.rOtherGender = rOtherGender;
	}
	public ClientRaceEnum getrRace() {
		return rRace;
	}
	public void setrRace(ClientRaceEnum rRace) {
		this.rRace = rRace;
	}
	public String getrSsn() {
		return rSsn;
	}
	public void setrSsn(String rSsn) {
		this.rSsn = rSsn;
	}
	public ClientSsnDataQualityEnum getrSsnDataQuality() {
		return rSsnDataQuality;
	}
	public void setrSsnDataQuality(ClientSsnDataQualityEnum rSsnDataQuality) {
		this.rSsnDataQuality = rSsnDataQuality;
	}
	public ClientVeteranStatusEnum getrVeteranStatus() {
		return rVeteranStatus;
	}
	public void setrVeteranStatus(ClientVeteranStatusEnum rVeteranStatus) {
		this.rVeteranStatus = rVeteranStatus;
	}
	public LocalDateTime getrDob() {
		return rDob;
	}
	public void setrDob(LocalDateTime rDob) {
		this.rDob = rDob;
	}
	public String getrSourceSystemId() {
		return rSourceSystemId;
	}
	public void setrSourceSystemId(String rSourceSystemId) {
		this.rSourceSystemId = rSourceSystemId;
	}
	public String getrSchemaYear() {
		return rSchemaYear;
	}
	public void setrSchemaYear(String rSchemaYear) {
		this.rSchemaYear = rSchemaYear;
	}
	public String getrPhoneNumber() {
		return rPhoneNumber;
	}
	public void setrPhoneNumber(String rPhoneNumber) {
		this.rPhoneNumber = rPhoneNumber;
	}
	public String getrEmailAddress() {
		return rEmailAddress;
	}
	public void setrEmailAddress(String rEmailAddress) {
		this.rEmailAddress = rEmailAddress;
	}
	public String getrProjectGroupCode() {
		return rProjectGroupCode;
	}
	public void setrProjectGroupCode(String rProjectGroupCode) {
		this.rProjectGroupCode = rProjectGroupCode;
	}
}