package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;
/**
 * ServicesID	ProjectEntryID	PersonalID	DateProvided	RecordType	
 * TypeProvided	OtherTypeProvided	SubTypeProvided	FAAmount	
 * ReferralOutcome	DateCreated	DateUpdated	UserID	DateDeleted	ExportID
 * @author sdolia
 *
 */
public class Assessment extends BaseCSV {
	@MapToColumn(column=0)
	private String AssessmentID;
	@MapToColumn(column=1)
	private String ProjectEntryID;
	@MapToColumn(column=2)
	private String PersonalID;
	@MapToColumn(column=3)
	private String AssessmentDate;
	@MapToColumn(column=4)
	private String AssessmentLocation;
	@MapToColumn(column=5)
	private String AssessmentType;
	@MapToColumn(column=6)
	private String AssessmentLevel;
	@MapToColumn(column=7)
	private String PrioritizationStatus;
	@MapToColumn(column=8)
	private String DateCreated;
	@MapToColumn(column=9)
	private String DateUpdated;
	@MapToColumn(column=10)
	private String UserID;
	@MapToColumn(column=11)
	private String DateDeleted;
	@MapToColumn(column=12)
	private String ExportID;
	
	/**
	 * @return the assessmentID
	 */
	public String getAssessmentID() {
		return AssessmentID;
	}
	/**
	 * @param assessmentID the assessmentID to set
	 */
	public void setAssessmentID(String assessmentID) {
		AssessmentID = assessmentID;
	}
	/**
	 * @return the projectEntryID
	 */
	public String getProjectEntryID() {
		return ProjectEntryID;
	}
	/**
	 * @param projectEntryID the projectEntryID to set
	 */
	public void setProjectEntryID(String projectEntryID) {
		ProjectEntryID = projectEntryID;
	}
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
	 * @return the assessmentDate
	 */
	public String getAssessmentDate() {
		return AssessmentDate;
	}
	/**
	 * @param assessmentDate the assessmentDate to set
	 */
	public void setAssessmentDate(String assessmentDate) {
		AssessmentDate = assessmentDate;
	}
	/**
	 * @return the assessmentLocation
	 */
	public String getAssessmentLocation() {
		return AssessmentLocation;
	}
	/**
	 * @param assessmentLocation the assessmentLocation to set
	 */
	public void setAssessmentLocation(String assessmentLocation) {
		AssessmentLocation = assessmentLocation;
	}
	/**
	 * @return the assessmentType
	 */
	public String getAssessmentType() {
		return AssessmentType;
	}
	/**
	 * @param assessmentType the assessmentType to set
	 */
	public void setAssessmentType(String assessmentType) {
		AssessmentType = assessmentType;
	}
	/**
	 * @return the assessmentLevel
	 */
	public String getAssessmentLevel() {
		return AssessmentLevel;
	}
	/**
	 * @param assessmentLevel the assessmentLevel to set
	 */
	public void setAssessmentLevel(String assessmentLevel) {
		AssessmentLevel = assessmentLevel;
	}
	/**
	 * @return the prioritizationStatus
	 */
	public String getPrioritizationStatus() {
		return PrioritizationStatus;
	}
	/**
	 * @param prioritizationStatus the prioritizationStatus to set
	 */
	public void setPrioritizationStatus(String prioritizationStatus) {
		PrioritizationStatus = prioritizationStatus;
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
