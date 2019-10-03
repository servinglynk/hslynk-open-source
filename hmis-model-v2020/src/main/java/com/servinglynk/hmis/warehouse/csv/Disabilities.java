package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;

public class Disabilities {
	@MapToColumn(column=0)
	private String DisabilitiesID;
	@MapToColumn(column=1)
	private String EnrollmentID;
	@MapToColumn(column=2)
	private String PersonalID;
	@MapToColumn(column=3)
	private String InformationDate;
	@MapToColumn(column=4)
	private String DisabilityType;
	@MapToColumn(column=5)
	private String DisabilityResponse;
	@MapToColumn(column=6)
	private String IndefiniteAndImpairs;
	@MapToColumn(column=7)
	private String TCellCountAvailable;
	@MapToColumn(column=8)
	private String TCellCount;
	@MapToColumn(column=9)
	private String TCellSource;
	@MapToColumn(column=10)
	private String ViralLoadAvailable;
	@MapToColumn(column=11)
	private String ViralLoad;
	@MapToColumn(column=12)
	private String ViralLoadSource;
	@MapToColumn(column=13)
	private String DataCollectionStage;
	@MapToColumn(column=14)
	private String DateCreated;
	@MapToColumn(column=15)
	private String DateUpdated;
	@MapToColumn(column=16)
	private String UserID;
	@MapToColumn(column=17)
	private String DateDeleted;
	@MapToColumn(column=18)
	private String ExportID;
	public String getDisabilitiesID() {
		return DisabilitiesID;
	}
	public void setDisabilitiesID(String disabilitiesID) {
		DisabilitiesID = disabilitiesID;
	}
	public String getEnrollmentID() {
		return EnrollmentID;
	}
	public void setEnrollmentID(String projectEntryID) {
		EnrollmentID = projectEntryID;
	}
	public String getPersonalID() {
		return PersonalID;
	}
	public void setPersonalID(String personalID) {
		PersonalID = personalID;
	}
	public String getInformationDate() {
		return InformationDate;
	}
	public void setInformationDate(String informationDate) {
		InformationDate = informationDate;
	}
	public String getDisabilityType() {
		return DisabilityType;
	}
	public void setDisabilityType(String disabilityType) {
		DisabilityType = disabilityType;
	}
	public String getDisabilityResponse() {
		return DisabilityResponse;
	}
	public void setDisabilityResponse(String disabilityResponse) {
		DisabilityResponse = disabilityResponse;
	}
	public String getIndefiniteAndImpairs() {
		return IndefiniteAndImpairs;
	}
	public void setIndefiniteAndImpairs(String indefiniteAndImpairs) {
		IndefiniteAndImpairs = indefiniteAndImpairs;
	}
	public String getTCellCountAvailable() {
		return TCellCountAvailable;
	}
	public void setTCellCountAvailable(String tCellCountAvailable) {
		TCellCountAvailable = tCellCountAvailable;
	}
	public String getTCellCount() {
		return TCellCount;
	}
	public void setTCellCount(String tCellCount) {
		TCellCount = tCellCount;
	}
	public String getTCellSource() {
		return TCellSource;
	}
	public void setTCellSource(String tCellSource) {
		TCellSource = tCellSource;
	}
	public String getViralLoadAvailable() {
		return ViralLoadAvailable;
	}
	public void setViralLoadAvailable(String viralLoadAvailable) {
		ViralLoadAvailable = viralLoadAvailable;
	}
	public String getViralLoad() {
		return ViralLoad;
	}
	public void setViralLoad(String viralLoad) {
		ViralLoad = viralLoad;
	}
	public String getViralLoadSource() {
		return ViralLoadSource;
	}
	public void setViralLoadSource(String viralLoadSource) {
		ViralLoadSource = viralLoadSource;
	}
	public String getDataCollectionStage() {
		return DataCollectionStage;
	}
	public void setDataCollectionStage(String dataCollectionStage) {
		DataCollectionStage = dataCollectionStage;
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
