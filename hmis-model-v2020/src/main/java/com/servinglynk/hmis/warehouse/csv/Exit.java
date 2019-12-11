package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;
														
public class Exit extends BaseCSV {

	@MapToColumn(column=0)
	private String ExitID;
	@MapToColumn(column=1)
	private String EnrollmentID;
	@MapToColumn(column=2)
	private String PersonalID;
	@MapToColumn(column=3)
	private String ExitDate;
	@MapToColumn(column=4)
	private String Destination;
	@MapToColumn(column=5)
	private String OtherDestination;
	@MapToColumn(column=6)
	private String HousingAssessment;
	@MapToColumn(column=7)
	private String SubsidyInformation;
	@MapToColumn(column=8)
	private String ProjectCompletionStatus;
	@MapToColumn(column=9)
	private String EarlyExitReason;
	@MapToColumn(column=10)
	private String ExchangeForSex;
	@MapToColumn(column=11)
	private String ExchangeForSexPastThreeMonths;
	@MapToColumn(column=12)
	private String CountOfExchangeForSex;
	@MapToColumn(column=13)
	private String AskedOrForcedToExchangeForSex;
	@MapToColumn(column=14)
	private String AskedOrForcedToExchangeForSexPastThreeMonths;
	@MapToColumn(column=15)
	private String WorkplaceViolenceThreats;
	@MapToColumn(column=16)
	private String WorkplacePromiseDifference;
	@MapToColumn(column=17)
	private String CoercedToContinueWork;
	@MapToColumn(column=18)
	private String LaborExploitPastThreeMonths;
	@MapToColumn(column=19)
	private String CounselingReceived;
	@MapToColumn(column=20)
	private String IndividualCounseling;
	@MapToColumn(column=21)
	private String FamilyCounseling;
	@MapToColumn(column=22)
	private String GroupCounseling;
	@MapToColumn(column=23)
	private String SessionCountAtExit;
	@MapToColumn(column=24)
	private String PostExitCounselingPlan;
	@MapToColumn(column=25)
	private String SessionsInPlan;
	@MapToColumn(column=26)
	private String DestinationSafeClient;
	@MapToColumn(column=27)
	private String DestinationSafeWorker;
	@MapToColumn(column=28)
	private String PosAdultConnections;
	@MapToColumn(column=29)
	private String PosPeerConnections;
	@MapToColumn(column=30)
	private String PosCommunityConnections;
	@MapToColumn(column=31)
	private String AftercareDate;
	@MapToColumn(column=32)
	private String AftercareProvided;
	@MapToColumn(column=33)
	private String EmailSocialMedia;
	@MapToColumn(column=34)
	private String Telephone;
	@MapToColumn(column=35)
	private String InPersonIndividual;
	@MapToColumn(column=36)
	private String InPersonGroup;
	@MapToColumn(column=37)
	private String CMExitReason;
	@MapToColumn(column=38)
	private String DateCreated;
	@MapToColumn(column=39)
	private String DateUpdated;
	@MapToColumn(column=40)
	private String UserID;
	@MapToColumn(column=41)
	private String DateDeleted;
	@MapToColumn(column=42)
	private String ExportID;
	
	
	public String getExitID() {
		return ExitID;
	}
	public void setExitID(String exitID) {
		ExitID = exitID;
	}
	public String getEnrollmentID() {
		return EnrollmentID;
	}
	public void setEnrollmentID(String enrollmentID) {
		EnrollmentID = enrollmentID;
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
	public String getExchangeForSex() {
		return ExchangeForSex;
	}
	public void setExchangeForSex(String exchangeForSex) {
		ExchangeForSex = exchangeForSex;
	}
	public String getExchangeForSexPastThreeMonths() {
		return ExchangeForSexPastThreeMonths;
	}
	public void setExchangeForSexPastThreeMonths(String exchangeForSexPastThreeMonths) {
		ExchangeForSexPastThreeMonths = exchangeForSexPastThreeMonths;
	}
	public String getCountOfExchangeForSex() {
		return CountOfExchangeForSex;
	}
	public void setCountOfExchangeForSex(String countOfExchangeForSex) {
		CountOfExchangeForSex = countOfExchangeForSex;
	}
	public String getAskedOrForcedToExchangeForSex() {
		return AskedOrForcedToExchangeForSex;
	}
	public void setAskedOrForcedToExchangeForSex(String askedOrForcedToExchangeForSex) {
		AskedOrForcedToExchangeForSex = askedOrForcedToExchangeForSex;
	}
	public String getAskedOrForcedToExchangeForSexPastThreeMonths() {
		return AskedOrForcedToExchangeForSexPastThreeMonths;
	}
	public void setAskedOrForcedToExchangeForSexPastThreeMonths(String askedOrForcedToExchangeForSexPastThreeMonths) {
		AskedOrForcedToExchangeForSexPastThreeMonths = askedOrForcedToExchangeForSexPastThreeMonths;
	}
	public String getWorkplaceViolenceThreats() {
		return WorkplaceViolenceThreats;
	}
	public void setWorkplaceViolenceThreats(String workplaceViolenceThreats) {
		WorkplaceViolenceThreats = workplaceViolenceThreats;
	}
	public String getWorkplacePromiseDifference() {
		return WorkplacePromiseDifference;
	}
	public void setWorkplacePromiseDifference(String workplacePromiseDifference) {
		WorkplacePromiseDifference = workplacePromiseDifference;
	}
	public String getCoercedToContinueWork() {
		return CoercedToContinueWork;
	}
	public void setCoercedToContinueWork(String coercedToContinueWork) {
		CoercedToContinueWork = coercedToContinueWork;
	}
	public String getLaborExploitPastThreeMonths() {
		return LaborExploitPastThreeMonths;
	}
	public void setLaborExploitPastThreeMonths(String laborExploitPastThreeMonths) {
		LaborExploitPastThreeMonths = laborExploitPastThreeMonths;
	}
	public String getCounselingReceived() {
		return CounselingReceived;
	}
	public void setCounselingReceived(String counselingReceived) {
		CounselingReceived = counselingReceived;
	}
	public String getIndividualCounseling() {
		return IndividualCounseling;
	}
	public void setIndividualCounseling(String individualCounseling) {
		IndividualCounseling = individualCounseling;
	}
	public String getFamilyCounseling() {
		return FamilyCounseling;
	}
	public void setFamilyCounseling(String familyCounseling) {
		FamilyCounseling = familyCounseling;
	}
	public String getGroupCounseling() {
		return GroupCounseling;
	}
	public void setGroupCounseling(String groupCounseling) {
		GroupCounseling = groupCounseling;
	}
	public String getSessionCountAtExit() {
		return SessionCountAtExit;
	}
	public void setSessionCountAtExit(String sessionCountAtExit) {
		SessionCountAtExit = sessionCountAtExit;
	}
	public String getPostExitCounselingPlan() {
		return PostExitCounselingPlan;
	}
	public void setPostExitCounselingPlan(String postExitCounselingPlan) {
		PostExitCounselingPlan = postExitCounselingPlan;
	}
	public String getSessionsInPlan() {
		return SessionsInPlan;
	}
	public void setSessionsInPlan(String sessionsInPlan) {
		SessionsInPlan = sessionsInPlan;
	}
	public String getDestinationSafeClient() {
		return DestinationSafeClient;
	}
	public void setDestinationSafeClient(String destinationSafeClient) {
		DestinationSafeClient = destinationSafeClient;
	}
	public String getDestinationSafeWorker() {
		return DestinationSafeWorker;
	}
	public void setDestinationSafeWorker(String destinationSafeWorker) {
		DestinationSafeWorker = destinationSafeWorker;
	}
	public String getPosAdultConnections() {
		return PosAdultConnections;
	}
	public void setPosAdultConnections(String posAdultConnections) {
		PosAdultConnections = posAdultConnections;
	}
	public String getPosPeerConnections() {
		return PosPeerConnections;
	}
	public void setPosPeerConnections(String posPeerConnections) {
		PosPeerConnections = posPeerConnections;
	}
	public String getPosCommunityConnections() {
		return PosCommunityConnections;
	}
	public void setPosCommunityConnections(String posCommunityConnections) {
		PosCommunityConnections = posCommunityConnections;
	}
	public String getAftercareDate() {
		return AftercareDate;
	}
	public void setAftercareDate(String aftercareDate) {
		AftercareDate = aftercareDate;
	}
	public String getAftercareProvided() {
		return AftercareProvided;
	}
	public void setAftercareProvided(String aftercareProvided) {
		AftercareProvided = aftercareProvided;
	}
	public String getEmailSocialMedia() {
		return EmailSocialMedia;
	}
	public void setEmailSocialMedia(String emailSocialMedia) {
		EmailSocialMedia = emailSocialMedia;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public String getInPersonIndividual() {
		return InPersonIndividual;
	}
	public void setInPersonIndividual(String inPersonIndividual) {
		InPersonIndividual = inPersonIndividual;
	}
	public String getInPersonGroup() {
		return InPersonGroup;
	}
	public void setInPersonGroup(String inPersonGroup) {
		InPersonGroup = inPersonGroup;
	}
	public String getCMExitReason() {
		return CMExitReason;
	}
	public void setCMExitReason(String cMExitReason) {
		CMExitReason = cMExitReason;
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
