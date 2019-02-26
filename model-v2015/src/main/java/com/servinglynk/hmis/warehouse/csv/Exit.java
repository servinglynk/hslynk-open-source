package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;
														
public class Exit {
	@MapToColumn(column=0)
	private String ExitID;
	@MapToColumn(column=1)
	private String ProjectEntryID;
	@MapToColumn(column=2)
	private String PersonalID;
	@MapToColumn(column=3)
	private String ExitDate;
	@MapToColumn(column=4)
	private String Destination;
	@MapToColumn(column=5)
	private String OtherDestination;
	@MapToColumn(column=6)
	private String AssessmentDisposition;
	@MapToColumn(column=7)
	private String OtherDisposition;
	@MapToColumn(column=8)
	private String HousingAssessment;
	@MapToColumn(column=9)
	private String SubsidyInformation;
	@MapToColumn(column=10)
	private String ConnectionWithSOAR;
	@MapToColumn(column=11)
	private String WrittenAftercarePlan;
	@MapToColumn(column=12)
	private String AssistanceMainstreamBenefits;
	@MapToColumn(column=13)
	private String PermanentHousingPlacement;
	@MapToColumn(column=14)
	private String TemporaryShelterPlacement;
	@MapToColumn(column=15)
	private String ExitCounseling;
	@MapToColumn(column=16)
	private String FurtherFollowUpServices;
	@MapToColumn(column=17)
	private String ScheduledFollowupContacts;
	@MapToColumn(column=18)
	private String ResourcePackage;
	@MapToColumn(column=19)
	private String OtherAftercarePlanOrAction;
	@MapToColumn(column=20)
	private String ProjectCompletionStatus;
	@MapToColumn(column=21)
	private String EarlyExitReason;
	@MapToColumn(column=22)
	private String FamilyReunificationAchieved;
	@MapToColumn(column=23)
	private String DateCreated;
	@MapToColumn(column=24)
	private String DateUpdated;
	@MapToColumn(column=25)
	private String UserID;
	@MapToColumn(column=26)
	private String DateDeleted;
	@MapToColumn(column=27)
	private String ExportID;
	public String getExitID() {
		return ExitID;
	}
	public void setExitID(String exitID) {
		ExitID = exitID;
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
	public String getExitDate() {
		return ExitDate;
	}
	public void setExitDate(String exitDate) {
		ExitDate = exitDate;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	public String getOtherDestination() {
		return OtherDestination;
	}
	public void setOtherDestination(String otherDestination) {
		OtherDestination = otherDestination;
	}
	public String getAssessmentDisposition() {
		return AssessmentDisposition;
	}
	public void setAssessmentDisposition(String assessmentDisposition) {
		AssessmentDisposition = assessmentDisposition;
	}
	public String getOtherDisposition() {
		return OtherDisposition;
	}
	public void setOtherDisposition(String otherDisposition) {
		OtherDisposition = otherDisposition;
	}
	public String getHousingAssessment() {
		return HousingAssessment;
	}
	public void setHousingAssessment(String housingAssessment) {
		HousingAssessment = housingAssessment;
	}
	public String getSubsidyInformation() {
		return SubsidyInformation;
	}
	public void setSubsidyInformation(String subsidyInformation) {
		SubsidyInformation = subsidyInformation;
	}
	public String getConnectionWithSOAR() {
		return ConnectionWithSOAR;
	}
	public void setConnectionWithSOAR(String connectionWithSOAR) {
		ConnectionWithSOAR = connectionWithSOAR;
	}
	public String getWrittenAftercarePlan() {
		return WrittenAftercarePlan;
	}
	public void setWrittenAftercarePlan(String writtenAftercarePlan) {
		WrittenAftercarePlan = writtenAftercarePlan;
	}
	public String getAssistanceMainstreamBenefits() {
		return AssistanceMainstreamBenefits;
	}
	public void setAssistanceMainstreamBenefits(String assistanceMainstreamBenefits) {
		AssistanceMainstreamBenefits = assistanceMainstreamBenefits;
	}
	public String getPermanentHousingPlacement() {
		return PermanentHousingPlacement;
	}
	public void setPermanentHousingPlacement(String permanentHousingPlacement) {
		PermanentHousingPlacement = permanentHousingPlacement;
	}
	public String getTemporaryShelterPlacement() {
		return TemporaryShelterPlacement;
	}
	public void setTemporaryShelterPlacement(String temporaryShelterPlacement) {
		TemporaryShelterPlacement = temporaryShelterPlacement;
	}
	public String getExitCounseling() {
		return ExitCounseling;
	}
	public void setExitCounseling(String exitCounseling) {
		ExitCounseling = exitCounseling;
	}
	public String getFurtherFollowUpServices() {
		return FurtherFollowUpServices;
	}
	public void setFurtherFollowUpServices(String furtherFollowUpServices) {
		FurtherFollowUpServices = furtherFollowUpServices;
	}
	public String getScheduledFollowupContacts() {
		return ScheduledFollowupContacts;
	}
	public void setScheduledFollowupContacts(String scheduledFollowupContacts) {
		ScheduledFollowupContacts = scheduledFollowupContacts;
	}
	public String getResourcePackage() {
		return ResourcePackage;
	}
	public void setResourcePackage(String resourcePackage) {
		ResourcePackage = resourcePackage;
	}
	public String getOtherAftercarePlanOrAction() {
		return OtherAftercarePlanOrAction;
	}
	public void setOtherAftercarePlanOrAction(String otherAftercarePlanOrAction) {
		OtherAftercarePlanOrAction = otherAftercarePlanOrAction;
	}
	public String getProjectCompletionStatus() {
		return ProjectCompletionStatus;
	}
	public void setProjectCompletionStatus(String projectCompletionStatus) {
		ProjectCompletionStatus = projectCompletionStatus;
	}
	public String getEarlyExitReason() {
		return EarlyExitReason;
	}
	public void setEarlyExitReason(String earlyExitReason) {
		EarlyExitReason = earlyExitReason;
	}
	public String getFamilyReunificationAchieved() {
		return FamilyReunificationAchieved;
	}
	public void setFamilyReunificationAchieved(String familyReunificationAchieved) {
		FamilyReunificationAchieved = familyReunificationAchieved;
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
