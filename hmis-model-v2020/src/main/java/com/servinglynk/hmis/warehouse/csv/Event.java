package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;
/**
 * ServicesID	ProjectEntryID	PersonalID	DateProvided	RecordType	
 * TypeProvided	OtherTypeProvided	SubTypeProvided	FAAmount	
 * ReferralOutcome	DateCreated	DateUpdated	UserID	DateDeleted	ExportID
 * @author sdolia
 *
 */
public class Event extends BaseCSV {
	@MapToColumn(column=0)
	private String EventID;
	@MapToColumn(column=1)
	private String EnrollmentID;
	@MapToColumn(column=2)
	private String PersonalID;
	@MapToColumn(column=3)
	private String EventDate;
	@MapToColumn(column=4)
	private String Event;
	@MapToColumn(column=5)
	private String ProbSolDivRRResult;
	@MapToColumn(column=6)
	private String ReferralCaseManageAfter;
	@MapToColumn(column=7)
	private String LocationCrisisOrPHHousing;
	@MapToColumn(column=8)
	private String ReferralResult;
	@MapToColumn(column=9)
	private String ResultDate;
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
	
	/**
	 * @return the eventID
	 */
	public String getEventID() {
		return EventID;
	}
	/**
	 * @param eventID the eventID to set
	 */
	public void setEventID(String eventID) {
		EventID = eventID;
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
	 * @return the eventDate
	 */
	public String getEventDate() {
		return EventDate;
	}
	/**
	 * @param eventDate the eventDate to set
	 */
	public void setEventDate(String eventDate) {
		EventDate = eventDate;
	}
	/**
	 * @return the event
	 */
	public String getEvent() {
		return Event;
	}
	/**
	 * @param event the event to set
	 */
	public void setEvent(String event) {
		Event = event;
	}
	/**
	 * @return the probSolDivRRResult
	 */
	public String getProbSolDivRRResult() {
		return ProbSolDivRRResult;
	}
	/**
	 * @param probSolDivRRResult the probSolDivRRResult to set
	 */
	public void setProbSolDivRRResult(String probSolDivRRResult) {
		ProbSolDivRRResult = probSolDivRRResult;
	}
	/**
	 * @return the referralCaseManageAfter
	 */
	public String getReferralCaseManageAfter() {
		return ReferralCaseManageAfter;
	}
	/**
	 * @param referralCaseManageAfter the referralCaseManageAfter to set
	 */
	public void setReferralCaseManageAfter(String referralCaseManageAfter) {
		ReferralCaseManageAfter = referralCaseManageAfter;
	}
	/**
	 * @return the locationCrisisOrPHHousing
	 */
	public String getLocationCrisisOrPHHousing() {
		return LocationCrisisOrPHHousing;
	}
	/**
	 * @param locationCrisisOrPHHousing the locationCrisisOrPHHousing to set
	 */
	public void setLocationCrisisOrPHHousing(String locationCrisisOrPHHousing) {
		LocationCrisisOrPHHousing = locationCrisisOrPHHousing;
	}
	/**
	 * @return the referralResult
	 */
	public String getReferralResult() {
		return ReferralResult;
	}
	/**
	 * @param referralResult the referralResult to set
	 */
	public void setReferralResult(String referralResult) {
		ReferralResult = referralResult;
	}
	/**
	 * @return the resultDate
	 */
	public String getResultDate() {
		return ResultDate;
	}
	/**
	 * @param resultDate the resultDate to set
	 */
	public void setResultDate(String resultDate) {
		ResultDate = resultDate;
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
