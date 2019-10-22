package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;
/**
 * ServicesID	ProjectEntryID	PersonalID	DateProvided	RecordType	
 * TypeProvided	OtherTypeProvided	SubTypeProvided	FAAmount	
 * ReferralOutcome	DateCreated	DateUpdated	UserID	DateDeleted	ExportID
 * @author sdolia
 *
 */
public class AssessmentResults {
	@MapToColumn(column=0)
	private String AssessmentResultID;
	@MapToColumn(column=1)
	private String AssessmentID;
	@MapToColumn(column=2)
	private String EnrollmentID;
	@MapToColumn(column=3)
	private String PersonalID;
	@MapToColumn(column=4)
	private String AssessmentResultType;
	@MapToColumn(column=5)
	private String AssessmentResult;
	@MapToColumn(column=6)
	private String DateCreated;
	@MapToColumn(column=7)
	private String DateUpdated;
	@MapToColumn(column=8)
	private String UserID;
	@MapToColumn(column=9)
	private String DateDeleted;
	@MapToColumn(column=10)
	private String ExportID;
	
	/**
	 * @return the assessmentResultID
	 */
	public String getAssessmentResultID() {
		return AssessmentResultID;
	}
	/**
	 * @param assessmentResultID the assessmentResultID to set
	 */
	public void setAssessmentResultID(String assessmentResultID) {
		AssessmentResultID = assessmentResultID;
	}
	/**
	 * @return the assessmentResultType
	 */
	public String getAssessmentResultType() {
		return AssessmentResultType;
	}
	/**
	 * @param assessmentResultType the assessmentResultType to set
	 */
	public void setAssessmentResultType(String assessmentResultType) {
		AssessmentResultType = assessmentResultType;
	}
	/**
	 * @return the assessmentResult
	 */
	public String getAssessmentResult() {
		return AssessmentResult;
	}
	/**
	 * @param assessmentResult the assessmentResult to set
	 */
	public void setAssessmentResult(String assessmentResult) {
		AssessmentResult = assessmentResult;
	}
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
	 * @return the enrollmentID
	 */
	public String getEnrollmentID() {
		return EnrollmentID;
	}
	/**
	 * @param enrollmentID the enrollmentID to set
	 */
	public void setEnrollmentID(String enrollmentID) {
		EnrollmentID = enrollmentID;
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
