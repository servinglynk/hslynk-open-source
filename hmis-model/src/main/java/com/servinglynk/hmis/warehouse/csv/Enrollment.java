package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;

																


public class Enrollment {
	@MapToColumn(column=0)
	private String ProjectEntryID;
	@MapToColumn(column=1)
	private String PersonalID;
	@MapToColumn(column=2)
	private String ProjectID;
	@MapToColumn(column=3)
	private String EntryDate;
	@MapToColumn(column=4)
	private String HouseholdID;
	@MapToColumn(column=5)
	private String RelationshipToHoH;
	@MapToColumn(column=6)
	private String ResidencePrior;
	@MapToColumn(column=7)
	private String OtherResidencePrior;
	@MapToColumn(column=8)
	private String ResidencePriorLengthOfStay;
	@MapToColumn(column=9)
	private String DisablingCondition;
	@MapToColumn(column=10)
	private String EntryFromStreetESSH;
	@MapToColumn(column=11)
	private String DateToStreetESSH;
	@MapToColumn(column=12)
	private String TimesHomelessPastThreeYears;
	@MapToColumn(column=13)
	private String MonthsHomelessPastThreeYears;
	@MapToColumn(column=14)
	private String HousingStatus;
	@MapToColumn(column=15)
	private String DateOfEngagement;
	@MapToColumn(column=16)
	private String InPermanentHousing;
	@MapToColumn(column=17)
	private String ResidentialMoveInDate;
	@MapToColumn(column=18)
	private String DateOFPATHStatus;
	@MapToColumn(column=19)
	private String ClientEnrolledInPATH;
	@MapToColumn(column=20)
	private String ReasonNotEnrolled;
	@MapToColumn(column=21)
	private String WorstHousingSituation;
	@MapToColumn(column=22)
	private String PercentAMI;
	@MapToColumn(column=23)
	private String LastPermanentStreet;
	@MapToColumn(column=24)
	private String LastPermanentCity;
	@MapToColumn(column=25)
	private String LastPermanentState;
	@MapToColumn(column=26)
	private String LastPermanentZIP;
	@MapToColumn(column=27)
	private String AddressDataQuality;
	@MapToColumn(column=28)
	private String DateOfBCPStatus;
	@MapToColumn(column=29)
	private String FYSBYouth;
	@MapToColumn(column=30)
	private String ReasonNoServices;
	@MapToColumn(column=31)
	private String SexualOrientation;
	@MapToColumn(column=32)
	private String FormerWardChildWelfare;
	@MapToColumn(column=33)
	private String ChildWelfareYears;
	@MapToColumn(column=34)
	private String ChildWelfareMonths;
	@MapToColumn(column=35)
	private String JuvenileJusticeYears;
	@MapToColumn(column=36)
	private String JuvenileJusticeMonths;
	@MapToColumn(column=37)
	private String HouseholdDynamics;
	@MapToColumn(column=38)
	private String SexualOrientationGenderIDYouth;
	@MapToColumn(column=39)
	private String SexualOrientationGenderIDFam;
	@MapToColumn(column=40)
	private String HousingIssuesYouth;
	@MapToColumn(column=41)
	private String HousingIssuesFam;
	@MapToColumn(column=42)
	private String SchoolEducationalIssuesYouth;
	@MapToColumn(column=43)
	private String SchoolEducationalIssuesFam;
	@MapToColumn(column=44)
	private String UnemploymentYouth;
	@MapToColumn(column=45)
	private String UnemploymentFam;
	@MapToColumn(column=46)
	private String MentalHealthIssuesYouth;
	@MapToColumn(column=47)
	private String MentalHealthIssuesFam;
	@MapToColumn(column=48)
	private String HealthIssuesYouth;
	@MapToColumn(column=49)
	private String HealthIssuesFam;
	@MapToColumn(column=50)
	private String PhysicalDisabilityYouth;
	@MapToColumn(column=51)
	private String PhysicalDisabilityFam;
	@MapToColumn(column=52)
	private String MentalDisabilityYouth;
	@MapToColumn(column=53)
	private String MentalDisabilityFam;
	@MapToColumn(column=54)
	private String AbuseAndNeglectYouth;
	@MapToColumn(column=55)
	private String AbuseAndNeglectFam;
	@MapToColumn(column=56)
	private String AlcoholDrugAbuseYouth;
	@MapToColumn(column=57)
	private String AlcoholDrugAbuseFam;
	@MapToColumn(column=58)
	private String InsufficientIncome;
	@MapToColumn(column=59)
	private String ActiveMilitaryParent;
	@MapToColumn(column=60)
	private String IncarceratedParent;
	@MapToColumn(column=61)
	private String IncarceratedParentStatus;
	@MapToColumn(column=62)
	private String ReferralSource;
	@MapToColumn(column=63)
	private String CountOutreachReferralApproaches;
	@MapToColumn(column=64)
	private String ExchangeForSex;
	@MapToColumn(column=65)
	private String ExchangeForSexPastThreeMonths;
	@MapToColumn(column=66)
	private String CountOfExchangeForSex;
	@MapToColumn(column=67)
	private String AskedOrForcedToExchangeForSex;
	@MapToColumn(column=68)
	private String AskedOrForcedToExchangeForSexPastThreeMonths;
	@MapToColumn(column=69)
	private String WorkPlaceViolenceThreats;
	@MapToColumn(column=70)
	private String WorkPlacePromiseDifference;
	@MapToColumn(column=71)
	private String CoercedToContinueWork;
	@MapToColumn(column=72)
	private String LaborExploitPastThreeMonths;
	@MapToColumn(column=73)
	private String HPScreeningScore;
	@MapToColumn(column=74)
	private String VAMCStation;
	@MapToColumn(column=75)
	private String DateCreated;
	@MapToColumn(column=76)
	private String DateUpdated;
	@MapToColumn(column=77)
	private String UserID;
	@MapToColumn(column=78)
	private String DateDeleted;
	@MapToColumn(column=79)
	private String ExportID;
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
	public String getProjectID() {
		return ProjectID;
	}
	public void setProjectID(String projectID) {
		ProjectID = projectID;
	}
	public String getEntryDate() {
		return EntryDate;
	}
	public void setEntryDate(String entryDate) {
		EntryDate = entryDate;
	}
	public String getHouseholdID() {
		return HouseholdID;
	}
	public void setHouseholdID(String householdID) {
		HouseholdID = householdID;
	}
	public String getRelationshipToHoH() {
		return RelationshipToHoH;
	}
	public void setRelationshipToHoH(String relationshipToHoH) {
		RelationshipToHoH = relationshipToHoH;
	}
	public String getResidencePrior() {
		return ResidencePrior;
	}
	public void setResidencePrior(String residencePrior) {
		ResidencePrior = residencePrior;
	}
	public String getOtherResidencePrior() {
		return OtherResidencePrior;
	}
	public void setOtherResidencePrior(String otherResidencePrior) {
		OtherResidencePrior = otherResidencePrior;
	}
	public String getResidencePriorLengthOfStay() {
		return ResidencePriorLengthOfStay;
	}
	public void setResidencePriorLengthOfStay(String residencePriorLengthOfStay) {
		ResidencePriorLengthOfStay = residencePriorLengthOfStay;
	}
	public String getDisablingCondition() {
		return DisablingCondition;
	}
	public void setDisablingCondition(String disablingCondition) {
		DisablingCondition = disablingCondition;
	}
	public String getEntryFromStreetESSH() {
		return EntryFromStreetESSH;
	}
	public void setEntryFromStreetESSH(String entryFromStreetESSH) {
		EntryFromStreetESSH = entryFromStreetESSH;
	}
	public String getDateToStreetESSH() {
		return DateToStreetESSH;
	}
	public void setDateToStreetESSH(String dateToStreetESSH) {
		DateToStreetESSH = dateToStreetESSH;
	}
	public String getTimesHomelessPastThreeYears() {
		return TimesHomelessPastThreeYears;
	}
	public void setTimesHomelessPastThreeYears(String timesHomelessPastThreeYears) {
		TimesHomelessPastThreeYears = timesHomelessPastThreeYears;
	}
	public String getMonthsHomelessPastThreeYears() {
		return MonthsHomelessPastThreeYears;
	}
	public void setMonthsHomelessPastThreeYears(String monthsHomelessPastThreeYears) {
		MonthsHomelessPastThreeYears = monthsHomelessPastThreeYears;
	}
	public String getHousingStatus() {
		return HousingStatus;
	}
	public void setHousingStatus(String housingStatus) {
		HousingStatus = housingStatus;
	}
	public String getDateOfEngagement() {
		return DateOfEngagement;
	}
	public void setDateOfEngagement(String dateOfEngagement) {
		DateOfEngagement = dateOfEngagement;
	}
	public String getInPermanentHousing() {
		return InPermanentHousing;
	}
	public void setInPermanentHousing(String inPermanentHousing) {
		InPermanentHousing = inPermanentHousing;
	}
	public String getResidentialMoveInDate() {
		return ResidentialMoveInDate;
	}
	public void setResidentialMoveInDate(String residentialMoveInDate) {
		ResidentialMoveInDate = residentialMoveInDate;
	}
	public String getDateOFPATHStatus() {
		return DateOFPATHStatus;
	}
	public void setDateOFPATHStatus(String dateOFPATHStatus) {
		DateOFPATHStatus = dateOFPATHStatus;
	}
	public String getClientEnrolledInPATH() {
		return ClientEnrolledInPATH;
	}
	public void setClientEnrolledInPATH(String clientEnrolledInPATH) {
		ClientEnrolledInPATH = clientEnrolledInPATH;
	}
	public String getReasonNotEnrolled() {
		return ReasonNotEnrolled;
	}
	public void setReasonNotEnrolled(String reasonNotEnrolled) {
		ReasonNotEnrolled = reasonNotEnrolled;
	}
	public String getWorstHousingSituation() {
		return WorstHousingSituation;
	}
	public void setWorstHousingSituation(String worstHousingSituation) {
		WorstHousingSituation = worstHousingSituation;
	}
	public String getPercentAMI() {
		return PercentAMI;
	}
	public void setPercentAMI(String percentAMI) {
		PercentAMI = percentAMI;
	}
	public String getLastPermanentStreet() {
		return LastPermanentStreet;
	}
	public void setLastPermanentStreet(String lastPermanentStreet) {
		LastPermanentStreet = lastPermanentStreet;
	}
	public String getLastPermanentCity() {
		return LastPermanentCity;
	}
	public void setLastPermanentCity(String lastPermanentCity) {
		LastPermanentCity = lastPermanentCity;
	}
	public String getLastPermanentState() {
		return LastPermanentState;
	}
	public void setLastPermanentState(String lastPermanentState) {
		LastPermanentState = lastPermanentState;
	}
	public String getLastPermanentZIP() {
		return LastPermanentZIP;
	}
	public void setLastPermanentZIP(String lastPermanentZIP) {
		LastPermanentZIP = lastPermanentZIP;
	}
	public String getAddressDataQuality() {
		return AddressDataQuality;
	}
	public void setAddressDataQuality(String addressDataQuality) {
		AddressDataQuality = addressDataQuality;
	}
	public String getDateOfBCPStatus() {
		return DateOfBCPStatus;
	}
	public void setDateOfBCPStatus(String dateOfBCPStatus) {
		DateOfBCPStatus = dateOfBCPStatus;
	}
	public String getFYSBYouth() {
		return FYSBYouth;
	}
	public void setFYSBYouth(String fYSBYouth) {
		FYSBYouth = fYSBYouth;
	}
	public String getReasonNoServices() {
		return ReasonNoServices;
	}
	public void setReasonNoServices(String reasonNoServices) {
		ReasonNoServices = reasonNoServices;
	}
	public String getSexualOrientation() {
		return SexualOrientation;
	}
	public void setSexualOrientation(String sexualOrientation) {
		SexualOrientation = sexualOrientation;
	}
	public String getFormerWardChildWelfare() {
		return FormerWardChildWelfare;
	}
	public void setFormerWardChildWelfare(String formerWardChildWelfare) {
		FormerWardChildWelfare = formerWardChildWelfare;
	}
	public String getChildWelfareYears() {
		return ChildWelfareYears;
	}
	public void setChildWelfareYears(String childWelfareYears) {
		ChildWelfareYears = childWelfareYears;
	}
	public String getChildWelfareMonths() {
		return ChildWelfareMonths;
	}
	public void setChildWelfareMonths(String childWelfareMonths) {
		ChildWelfareMonths = childWelfareMonths;
	}
	public String getJuvenileJusticeYears() {
		return JuvenileJusticeYears;
	}
	public void setJuvenileJusticeYears(String juvenileJusticeYears) {
		JuvenileJusticeYears = juvenileJusticeYears;
	}
	public String getJuvenileJusticeMonths() {
		return JuvenileJusticeMonths;
	}
	public void setJuvenileJusticeMonths(String juvenileJusticeMonths) {
		JuvenileJusticeMonths = juvenileJusticeMonths;
	}
	public String getHouseholdDynamics() {
		return HouseholdDynamics;
	}
	public void setHouseholdDynamics(String householdDynamics) {
		HouseholdDynamics = householdDynamics;
	}
	public String getSexualOrientationGenderIDYouth() {
		return SexualOrientationGenderIDYouth;
	}
	public void setSexualOrientationGenderIDYouth(
			String sexualOrientationGenderIDYouth) {
		SexualOrientationGenderIDYouth = sexualOrientationGenderIDYouth;
	}
	public String getSexualOrientationGenderIDFam() {
		return SexualOrientationGenderIDFam;
	}
	public void setSexualOrientationGenderIDFam(String sexualOrientationGenderIDFam) {
		SexualOrientationGenderIDFam = sexualOrientationGenderIDFam;
	}
	public String getHousingIssuesYouth() {
		return HousingIssuesYouth;
	}
	public void setHousingIssuesYouth(String housingIssuesYouth) {
		HousingIssuesYouth = housingIssuesYouth;
	}
	public String getHousingIssuesFam() {
		return HousingIssuesFam;
	}
	public void setHousingIssuesFam(String housingIssuesFam) {
		HousingIssuesFam = housingIssuesFam;
	}
	public String getSchoolEducationalIssuesYouth() {
		return SchoolEducationalIssuesYouth;
	}
	public void setSchoolEducationalIssuesYouth(String schoolEducationalIssuesYouth) {
		SchoolEducationalIssuesYouth = schoolEducationalIssuesYouth;
	}
	public String getSchoolEducationalIssuesFam() {
		return SchoolEducationalIssuesFam;
	}
	public void setSchoolEducationalIssuesFam(String schoolEducationalIssuesFam) {
		SchoolEducationalIssuesFam = schoolEducationalIssuesFam;
	}
	public String getUnemploymentYouth() {
		return UnemploymentYouth;
	}
	public void setUnemploymentYouth(String unemploymentYouth) {
		UnemploymentYouth = unemploymentYouth;
	}
	public String getUnemploymentFam() {
		return UnemploymentFam;
	}
	public void setUnemploymentFam(String unemploymentFam) {
		UnemploymentFam = unemploymentFam;
	}
	public String getMentalHealthIssuesYouth() {
		return MentalHealthIssuesYouth;
	}
	public void setMentalHealthIssuesYouth(String mentalHealthIssuesYouth) {
		MentalHealthIssuesYouth = mentalHealthIssuesYouth;
	}
	public String getMentalHealthIssuesFam() {
		return MentalHealthIssuesFam;
	}
	public void setMentalHealthIssuesFam(String mentalHealthIssuesFam) {
		MentalHealthIssuesFam = mentalHealthIssuesFam;
	}
	public String getHealthIssuesYouth() {
		return HealthIssuesYouth;
	}
	public void setHealthIssuesYouth(String healthIssuesYouth) {
		HealthIssuesYouth = healthIssuesYouth;
	}
	public String getHealthIssuesFam() {
		return HealthIssuesFam;
	}
	public void setHealthIssuesFam(String healthIssuesFam) {
		HealthIssuesFam = healthIssuesFam;
	}
	public String getPhysicalDisabilityYouth() {
		return PhysicalDisabilityYouth;
	}
	public void setPhysicalDisabilityYouth(String physicalDisabilityYouth) {
		PhysicalDisabilityYouth = physicalDisabilityYouth;
	}
	public String getPhysicalDisabilityFam() {
		return PhysicalDisabilityFam;
	}
	public void setPhysicalDisabilityFam(String physicalDisabilityFam) {
		PhysicalDisabilityFam = physicalDisabilityFam;
	}
	public String getMentalDisabilityYouth() {
		return MentalDisabilityYouth;
	}
	public void setMentalDisabilityYouth(String mentalDisabilityYouth) {
		MentalDisabilityYouth = mentalDisabilityYouth;
	}
	public String getMentalDisabilityFam() {
		return MentalDisabilityFam;
	}
	public void setMentalDisabilityFam(String mentalDisabilityFam) {
		MentalDisabilityFam = mentalDisabilityFam;
	}
	public String getAbuseAndNeglectYouth() {
		return AbuseAndNeglectYouth;
	}
	public void setAbuseAndNeglectYouth(String abuseAndNeglectYouth) {
		AbuseAndNeglectYouth = abuseAndNeglectYouth;
	}
	public String getAbuseAndNeglectFam() {
		return AbuseAndNeglectFam;
	}
	public void setAbuseAndNeglectFam(String abuseAndNeglectFam) {
		AbuseAndNeglectFam = abuseAndNeglectFam;
	}
	public String getAlcoholDrugAbuseYouth() {
		return AlcoholDrugAbuseYouth;
	}
	public void setAlcoholDrugAbuseYouth(String alcoholDrugAbuseYouth) {
		AlcoholDrugAbuseYouth = alcoholDrugAbuseYouth;
	}
	public String getAlcoholDrugAbuseFam() {
		return AlcoholDrugAbuseFam;
	}
	public void setAlcoholDrugAbuseFam(String alcoholDrugAbuseFam) {
		AlcoholDrugAbuseFam = alcoholDrugAbuseFam;
	}
	public String getInsufficientIncome() {
		return InsufficientIncome;
	}
	public void setInsufficientIncome(String insufficientIncome) {
		InsufficientIncome = insufficientIncome;
	}
	public String getActiveMilitaryParent() {
		return ActiveMilitaryParent;
	}
	public void setActiveMilitaryParent(String activeMilitaryParent) {
		ActiveMilitaryParent = activeMilitaryParent;
	}
	public String getIncarceratedParent() {
		return IncarceratedParent;
	}
	public void setIncarceratedParent(String incarceratedParent) {
		IncarceratedParent = incarceratedParent;
	}
	public String getIncarceratedParentStatus() {
		return IncarceratedParentStatus;
	}
	public void setIncarceratedParentStatus(String incarceratedParentStatus) {
		IncarceratedParentStatus = incarceratedParentStatus;
	}
	public String getReferralSource() {
		return ReferralSource;
	}
	public void setReferralSource(String referralSource) {
		ReferralSource = referralSource;
	}
	public String getCountOutreachReferralApproaches() {
		return CountOutreachReferralApproaches;
	}
	public void setCountOutreachReferralApproaches(
			String countOutreachReferralApproaches) {
		CountOutreachReferralApproaches = countOutreachReferralApproaches;
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
	public void setExchangeForSexPastThreeMonths(
			String exchangeForSexPastThreeMonths) {
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
	public void setAskedOrForcedToExchangeForSex(
			String askedOrForcedToExchangeForSex) {
		AskedOrForcedToExchangeForSex = askedOrForcedToExchangeForSex;
	}
	public String getAskedOrForcedToExchangeForSexPastThreeMonths() {
		return AskedOrForcedToExchangeForSexPastThreeMonths;
	}
	public void setAskedOrForcedToExchangeForSexPastThreeMonths(
			String askedOrForcedToExchangeForSexPastThreeMonths) {
		AskedOrForcedToExchangeForSexPastThreeMonths = askedOrForcedToExchangeForSexPastThreeMonths;
	}
	public String getWorkPlaceViolenceThreats() {
		return WorkPlaceViolenceThreats;
	}
	public void setWorkPlaceViolenceThreats(String workPlaceViolenceThreats) {
		WorkPlaceViolenceThreats = workPlaceViolenceThreats;
	}
	public String getWorkPlacePromiseDifference() {
		return WorkPlacePromiseDifference;
	}
	public void setWorkPlacePromiseDifference(String workPlacePromiseDifference) {
		WorkPlacePromiseDifference = workPlacePromiseDifference;
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
	public String getHPScreeningScore() {
		return HPScreeningScore;
	}
	public void setHPScreeningScore(String hPScreeningScore) {
		HPScreeningScore = hPScreeningScore;
	}
	public String getVAMCStation() {
		return VAMCStation;
	}
	public void setVAMCStation(String vAMCStation) {
		VAMCStation = vAMCStation;
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
