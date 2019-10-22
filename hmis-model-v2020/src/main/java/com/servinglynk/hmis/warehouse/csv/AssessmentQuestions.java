package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;
/**
 * ServicesID	ProjectEntryID	PersonalID	DateProvided	RecordType	
 * TypeProvided	OtherTypeProvided	SubTypeProvided	FAAmount	
 * ReferralOutcome	DateCreated	DateUpdated	UserID	DateDeleted	ExportID
 * @author sdolia
 *
 */
public class AssessmentQuestions {
	@MapToColumn(column=0)
	private String AssessmentQuestionID;
	@MapToColumn(column=1)
	private String AssessmentID;
	@MapToColumn(column=2)
	private String EnrollmentID;
	@MapToColumn(column=3)
	private String PersonalID;
	@MapToColumn(column=4)
	private String AssessmentQuestionGroup;
	@MapToColumn(column=5)
	private String AssessmentQuestionOrder;
	@MapToColumn(column=6)
	private String AssessmentQuestion;
	@MapToColumn(column=7)
	private String AssessmentAnswer;
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
	 * @return the assessmentQuestionID
	 */
	public String getAssessmentQuestionID() {
		return AssessmentQuestionID;
	}
	/**
	 * @param assessmentQuestionID the assessmentQuestionID to set
	 */
	public void setAssessmentQuestionID(String assessmentQuestionID) {
		AssessmentQuestionID = assessmentQuestionID;
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
	/**
	 * @return the assessmentQuestionGroup
	 */
	public String getAssessmentQuestionGroup() {
		return AssessmentQuestionGroup;
	}
	/**
	 * @param assessmentQuestionGroup the assessmentQuestionGroup to set
	 */
	public void setAssessmentQuestionGroup(String assessmentQuestionGroup) {
		AssessmentQuestionGroup = assessmentQuestionGroup;
	}
	/**
	 * @return the assessmentQuestionOrder
	 */
	public String getAssessmentQuestionOrder() {
		return AssessmentQuestionOrder;
	}
	/**
	 * @param assessmentQuestionOrder the assessmentQuestionOrder to set
	 */
	public void setAssessmentQuestionOrder(String assessmentQuestionOrder) {
		AssessmentQuestionOrder = assessmentQuestionOrder;
	}
	/**
	 * @return the assessmentQuestion
	 */
	public String getAssessmentQuestion() {
		return AssessmentQuestion;
	}
	/**
	 * @param assessmentQuestion the assessmentQuestion to set
	 */
	public void setAssessmentQuestion(String assessmentQuestion) {
		AssessmentQuestion = assessmentQuestion;
	}
	/**
	 * @return the assessmentAnswer
	 */
	public String getAssessmentAnswer() {
		return AssessmentAnswer;
	}
	/**
	 * @param assessmentAnswer the assessmentAnswer to set
	 */
	public void setAssessmentAnswer(String assessmentAnswer) {
		AssessmentAnswer = assessmentAnswer;
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
