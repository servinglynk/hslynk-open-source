package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;
/**
 * ServicesID	ProjectEntryID	PersonalID	DateProvided	RecordType	
 * TypeProvided	OtherTypeProvided	SubTypeProvided	FAAmount	
 * ReferralOutcome	DateCreated	DateUpdated	UserID	DateDeleted	ExportID
 * @author sdolia
 *
 */
public class Services extends BaseCSV {
	@MapToColumn(column=0)
	private String ServicesID;
	@MapToColumn(column=1)
	private String ProjectEntryID;
	@MapToColumn(column=2)
	private String PersonalID;
	@MapToColumn(column=3)
	private String DateProvided;
	@MapToColumn(column=4)
	private String RecordType;
	@MapToColumn(column=5)
	private String TypeProvided;
	@MapToColumn(column=6)
	private String OtherTypeProvided;
	@MapToColumn(column=7)
	private String SubTypeProvided;
	@MapToColumn(column=8)
	private String FAAmount;
	@MapToColumn(column=9)
	private String ReferralOutcome;
	@MapToColumn(column=10)
	private String DateCreated;
	@MapToColumn(column=11)
	private String DateUpdated;
	@MapToColumn(column=12)
	private String UserID;
	@MapToColumn(column=13)
	private String DateDeleted;
	@MapToColumn(column=14)
	private String ExportID;
	public String getServicesID() {
		return ServicesID;
	}
	public void setServicesID(String servicesID) {
		ServicesID = servicesID;
	}
	public String getProjectEntryID() {
		return ProjectEntryID;
	}
	public void setProjectEntryID(String projectEntryID) {
		ProjectEntryID = projectEntryID;
	}
	public String getPersonalID() {
		return PersonalID;
	}
	public void setPersonalID(String personalID) {
		PersonalID = personalID;
	}
	public String getDateProvided() {
		return DateProvided;
	}
	public void setDateProvided(String dateProvided) {
		DateProvided = dateProvided;
	}
	public String getRecordType() {
		return RecordType;
	}
	public void setRecordType(String recordType) {
		RecordType = recordType;
	}
	public String getTypeProvided() {
		return TypeProvided;
	}
	public void setTypeProvided(String typeProvided) {
		TypeProvided = typeProvided;
	}
	public String getOtherTypeProvided() {
		return OtherTypeProvided;
	}
	public void setOtherTypeProvided(String otherTypeProvided) {
		OtherTypeProvided = otherTypeProvided;
	}
	public String getSubTypeProvided() {
		return SubTypeProvided;
	}
	public void setSubTypeProvided(String subTypeProvided) {
		SubTypeProvided = subTypeProvided;
	}
	public String getFAAmount() {
		return FAAmount;
	}
	public void setFAAmount(String fAAmount) {
		FAAmount = fAAmount;
	}
	public String getReferralOutcome() {
		return ReferralOutcome;
	}
	public void setReferralOutcome(String referralOutcome) {
		ReferralOutcome = referralOutcome;
	}
	public String getDateCreated() {
		return DateCreated;
	}
	public void setDateCreated(String dateCreated) {
		DateCreated = dateCreated;
	}
	public String getDateUpdated() {
		return DateUpdated;
	}
	public void setDateUpdated(String dateUpdated) {
		DateUpdated = dateUpdated;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getDateDeleted() {
		return DateDeleted;
	}
	public void setDateDeleted(String dateDeleted) {
		DateDeleted = dateDeleted;
	}
	public String getExportID() {
		return ExportID;
	}
	public void setExportID(String exportID) {
		ExportID = exportID;
	}
	
}
