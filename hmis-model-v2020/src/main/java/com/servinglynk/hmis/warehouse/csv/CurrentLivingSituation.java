package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;
/**
 * ServicesID	ProjectEntryID	PersonalID	DateProvided	RecordType	
 * TypeProvided	OtherTypeProvided	SubTypeProvided	FAAmount	
 * ReferralOutcome	DateCreated	DateUpdated	UserID	DateDeleted	ExportID
 * @author sdolia
 *
 */
public class CurrentLivingSituation {
	@MapToColumn(column=0)
	private String CurrentLivingSitID;
	@MapToColumn(column=1)
	private String ProjectEntryID;
	@MapToColumn(column=2)
	private String PersonalID;
	@MapToColumn(column=3)
	private String InformationDate;
	@MapToColumn(column=4)
	private String CurrentLivingSituation;
	@MapToColumn(column=5)
	private String VerifiedBy;
	@MapToColumn(column=6)
	private String LeaveSituation14Days;
	@MapToColumn(column=7)
	private String SubsequentResidence;
	@MapToColumn(column=8)
	private String ResourcesToObtain;
	@MapToColumn(column=9)
	private String LeaseOwn60Day;
	@MapToColumn(column=10)
	private String MovedTwoOrMore;
	@MapToColumn(column=11)
	private String LocationDetails;
	@MapToColumn(column=12)
	private String DateCreated;
	@MapToColumn(column=13)
	private String DateUpdated;
	@MapToColumn(column=14)
	private String UserID;
	@MapToColumn(column=15)
	private String DateDeleted;
	@MapToColumn(column=16)
	private String ExportID;
	
	/**
	 * @return the currentLivingSitID
	 */
	public String getCurrentLivingSitID() {
		return CurrentLivingSitID;
	}
	/**
	 * @param currentLivingSitID the currentLivingSitID to set
	 */
	public void setCurrentLivingSitID(String currentLivingSitID) {
		CurrentLivingSitID = currentLivingSitID;
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
	 * @return the informationDate
	 */
	public String getInformationDate() {
		return InformationDate;
	}
	/**
	 * @param informationDate the informationDate to set
	 */
	public void setInformationDate(String informationDate) {
		InformationDate = informationDate;
	}
	/**
	 * @return the currentLivingSituation
	 */
	public String getCurrentLivingSituation() {
		return CurrentLivingSituation;
	}
	/**
	 * @param currentLivingSituation the currentLivingSituation to set
	 */
	public void setCurrentLivingSituation(String currentLivingSituation) {
		CurrentLivingSituation = currentLivingSituation;
	}
	/**
	 * @return the verifiedBy
	 */
	public String getVerifiedBy() {
		return VerifiedBy;
	}
	/**
	 * @param verifiedBy the verifiedBy to set
	 */
	public void setVerifiedBy(String verifiedBy) {
		VerifiedBy = verifiedBy;
	}
	/**
	 * @return the leaveSituation14Days
	 */
	public String getLeaveSituation14Days() {
		return LeaveSituation14Days;
	}
	/**
	 * @param leaveSituation14Days the leaveSituation14Days to set
	 */
	public void setLeaveSituation14Days(String leaveSituation14Days) {
		LeaveSituation14Days = leaveSituation14Days;
	}
	/**
	 * @return the subsequentResidence
	 */
	public String getSubsequentResidence() {
		return SubsequentResidence;
	}
	/**
	 * @param subsequentResidence the subsequentResidence to set
	 */
	public void setSubsequentResidence(String subsequentResidence) {
		SubsequentResidence = subsequentResidence;
	}
	/**
	 * @return the resourcesToObtain
	 */
	public String getResourcesToObtain() {
		return ResourcesToObtain;
	}
	/**
	 * @param resourcesToObtain the resourcesToObtain to set
	 */
	public void setResourcesToObtain(String resourcesToObtain) {
		ResourcesToObtain = resourcesToObtain;
	}
	/**
	 * @return the leaseOwn60Day
	 */
	public String getLeaseOwn60Day() {
		return LeaseOwn60Day;
	}
	/**
	 * @param leaseOwn60Day the leaseOwn60Day to set
	 */
	public void setLeaseOwn60Day(String leaseOwn60Day) {
		LeaseOwn60Day = leaseOwn60Day;
	}
	/**
	 * @return the movedTwoOrMore
	 */
	public String getMovedTwoOrMore() {
		return MovedTwoOrMore;
	}
	/**
	 * @param movedTwoOrMore the movedTwoOrMore to set
	 */
	public void setMovedTwoOrMore(String movedTwoOrMore) {
		MovedTwoOrMore = movedTwoOrMore;
	}
	/**
	 * @return the locationDetails
	 */
	public String getLocationDetails() {
		return LocationDetails;
	}
	/**
	 * @param locationDetails the locationDetails to set
	 */
	public void setLocationDetails(String locationDetails) {
		LocationDetails = locationDetails;
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
