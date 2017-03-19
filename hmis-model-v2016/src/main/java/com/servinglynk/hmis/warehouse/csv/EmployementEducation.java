package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;
														

public class EmployementEducation {
	@MapToColumn(column=0)
	private String EmploymentEducationID;
	@MapToColumn(column=1)
	private String ProjectEntryID;
	@MapToColumn(column=2)
	private String PersonalID;
	@MapToColumn(column=3)
	private String InformationDate;
	@MapToColumn(column=4)
	private String LastGradeCompleted;
	@MapToColumn(column=5)
	private String SchoolStatus;
	@MapToColumn(column=6)
	private String Employed;
	@MapToColumn(column=7)
	private String EmploymentType;
	@MapToColumn(column=8)
	private String NotEmployedReason;
	@MapToColumn(column=9)
	private String DataCollectionStage;
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
	public String getEmploymentEducationID() {
		return EmploymentEducationID;
	}
	public void setEmploymentEducationID(String employmentEducationID) {
		EmploymentEducationID = employmentEducationID;
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
	public String getLastGradeCompleted() {
		return LastGradeCompleted;
	}
	public void setLastGradeCompleted(String lastGradeCompleted) {
		LastGradeCompleted = lastGradeCompleted;
	}
	public String getSchoolStatus() {
		return SchoolStatus;
	}
	public void setSchoolStatus(String schoolStatus) {
		SchoolStatus = schoolStatus;
	}
	public String getEmployed() {
		return Employed;
	}
	public void setEmployed(String employed) {
		Employed = employed;
	}
	public String getEmploymentType() {
		return EmploymentType;
	}
	public void setEmploymentType(String employmentType) {
		EmploymentType = employmentType;
	}
	public String getNotEmployedReason() {
		return NotEmployedReason;
	}
	public void setNotEmployedReason(String notEmployedReason) {
		NotEmployedReason = notEmployedReason;
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
