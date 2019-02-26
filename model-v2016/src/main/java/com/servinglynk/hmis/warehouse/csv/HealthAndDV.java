package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;
										
																

public class HealthAndDV {
	@MapToColumn(column=0)
	private String HealthAndDVID;
	@MapToColumn(column=1)
	private String ProjectEntryID;
	@MapToColumn(column=2)
	private String PersonalID;
	@MapToColumn(column=3)
	private String InformationDate;
	@MapToColumn(column=4)
	private String DomesticViolenceVictim;
	@MapToColumn(column=5)
	private String WhenOccurred;
	@MapToColumn(column=6)
	private String CurrentlyFleeing;
	@MapToColumn(column=7)
	private String GeneralHealthStatus;
	@MapToColumn(column=8)
	private String DentalHealthStatus;
	@MapToColumn(column=9)
	private String MentalHealthStatus;
	@MapToColumn(column=10)
	private String PregnancyStatus;
	@MapToColumn(column=11)
	private String DueDate;
	@MapToColumn(column=12)
	private String DataCollectionStage;
	@MapToColumn(column=13)
	private String DateCreated;
	@MapToColumn(column=14)
	private String DateUpdated;
	@MapToColumn(column=15)
	private String UserID;
	@MapToColumn(column=16)
	private String DateDeleted;
	@MapToColumn(column=17)
	private String ExportID;
	public String getHealthAndDVID() {
		return HealthAndDVID;
	}
	public void setHealthAndDVID(String healthAndDVID) {
		HealthAndDVID = healthAndDVID;
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
	public String getInformationDate() {
		return InformationDate;
	}
	public void setInformationDate(String informationDate) {
		InformationDate = informationDate;
	}
	public String getDomesticViolenceVictim() {
		return DomesticViolenceVictim;
	}
	public void setDomesticViolenceVictim(String domesticViolenceVictim) {
		DomesticViolenceVictim = domesticViolenceVictim;
	}
	public String getWhenOccurred() {
		return WhenOccurred;
	}
	public void setWhenOccurred(String whenOccurred) {
		WhenOccurred = whenOccurred;
	}
	public String getCurrentlyFleeing() {
		return CurrentlyFleeing;
	}
	public void setCurrentlyFleeing(String currentlyFleeing) {
		CurrentlyFleeing = currentlyFleeing;
	}
	public String getGeneralHealthStatus() {
		return GeneralHealthStatus;
	}
	public void setGeneralHealthStatus(String generalHealthStatus) {
		GeneralHealthStatus = generalHealthStatus;
	}
	public String getDentalHealthStatus() {
		return DentalHealthStatus;
	}
	public void setDentalHealthStatus(String dentalHealthStatus) {
		DentalHealthStatus = dentalHealthStatus;
	}
	public String getMentalHealthStatus() {
		return MentalHealthStatus;
	}
	public void setMentalHealthStatus(String mentalHealthStatus) {
		MentalHealthStatus = mentalHealthStatus;
	}
	public String getPregnancyStatus() {
		return PregnancyStatus;
	}
	public void setPregnancyStatus(String pregnancyStatus) {
		PregnancyStatus = pregnancyStatus;
	}
	public String getDueDate() {
		return DueDate;
	}
	public void setDueDate(String dueDate) {
		DueDate = dueDate;
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
