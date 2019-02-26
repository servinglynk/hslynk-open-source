package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;

																


public class Enrollment {
	@MapToColumn(column=0)
	private String EnrollmentID;
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
	private String LivingSituation;
	@MapToColumn(column=7)
	private String LengthOfStay;
	@MapToColumn(column=8)
	private String LOSUnderThreshold;
	@MapToColumn(column=9)
	private String PreviousStreetESSH;
	@MapToColumn(column=10)
	private String DateToStreetESSH;
	@MapToColumn(column=11)
	private String TimesHomelessPastThreeYears;
	@MapToColumn(column=12)
	private String MonthsHomelessPastThreeYears;
	@MapToColumn(column=13)
	private String DisablingCondition;
	@MapToColumn(column=14)
	private String DateOfEngagement;
	@MapToColumn(column=15)
	private String MoveInDate;
	@MapToColumn(column=16)
	private String DateOfPATHStatus;
	@MapToColumn(column=17)
	private String ClientEnrolledInPATH;
	@MapToColumn(column=18)
	private String ReasonNotEnrolled;
	@MapToColumn(column=19)
	private String WorstHousingSituation;
	@MapToColumn(column=20)
	private String PercentAMI;
	@MapToColumn(column=21)
	private String LastPermanentStreet;
	@MapToColumn(column=22)
	private String LastPermanentCity;
	@MapToColumn(column=23)
	private String LastPermanentState;
	@MapToColumn(column=24)
	private String LastPermanentZIP;
	@MapToColumn(column=25)
	private String AddressDataQuality;
	@MapToColumn(column=26)
	private String DateOfBCPStatus;
	@MapToColumn(column=27)
	private String EligibleForRHY;
	@MapToColumn(column=28)
	private String ReasonNoServices;
	@MapToColumn(column=29)
	private String RunawayYouth;
	@MapToColumn(column=30)
	private String SexualOrientation;
	@MapToColumn(column=31)
	private String FormerWardChildWelfare;
	@MapToColumn(column=32)
	private String ChildWelfareYears;
	@MapToColumn(column=33)
	private String ChildWelfareMonths;
	@MapToColumn(column=34)
	private String FormerWardJuvenileJustice;
	@MapToColumn(column=35)
	private String JuvenileJusticeYears;
	@MapToColumn(column=36)
	private String JuvenileJusticeMonths;
	@MapToColumn(column=37)
	private String UnemploymentFam;
	@MapToColumn(column=38)
	private String MentalHealthIssuesFam;
	@MapToColumn(column=39)
	private String PhysicalDisabilityFam;
	@MapToColumn(column=40)
	private String AlcoholDrugAbuseFam;
	@MapToColumn(column=41)
	private String InsufficientIncome;
	@MapToColumn(column=42)
	private String IncarceratedParent;
	@MapToColumn(column=43)
	private String ReferralSource;
	@MapToColumn(column=44)
	private String CountOutreachReferralApproaches;
	@MapToColumn(column=45)
	private String UrgentReferral;
	@MapToColumn(column=46)
	private String TimeToHousingLoss;
	@MapToColumn(column=47)
	private String ZeroIncome;
	@MapToColumn(column=48)
	private String AnnualPercentAMI;
	@MapToColumn(column=49)
	private String FinancialChange;
	@MapToColumn(column=50)
	private String HouseholdChange;
	@MapToColumn(column=51)
	private String EvictionHistory;
	@MapToColumn(column=52)
	private String SubsidyAtRisk;
	@MapToColumn(column=53)
	private String LiteralHomelessHistory;
	@MapToColumn(column=54)
	private String DisabledHoH;
	@MapToColumn(column=55)
	private String CriminalRecord;
	@MapToColumn(column=56)
	private String SexOffender;
	@MapToColumn(column=57)
	private String DependentUnder6;
	@MapToColumn(column=58)
	private String SingleParent;
	@MapToColumn(column=59)
	private String HH5Plus;
	@MapToColumn(column=60)
	private String IraqAfghanistan;
	@MapToColumn(column=61)
	private String FemVet;	
	@MapToColumn(column=62)
	private String HPScreeningScore;
	@MapToColumn(column=63)
	private String ThresholdScore;
	@MapToColumn(column=64)
	private String VAMCStation;
	@MapToColumn(column=65)
	private String DateCreated;
	@MapToColumn(column=66)
	private String DateUpdated;
	@MapToColumn(column=67)
	private String UserID;
	@MapToColumn(column=68)
	private String DateDeleted;
	@MapToColumn(column=69)
	private String ExportID;
	
	public String getEnrollmentID() {
		return EnrollmentID;
	}
	public void setEnrollmentID(String EnrollmentID) {
		this.EnrollmentID = EnrollmentID;
	}
	public String getPersonalID() {
		return PersonalID;
	}
	public void setPersonalID(String personalID) {
		this.PersonalID = personalID;
	}
	public String getProjectID() {
		return ProjectID;
	}
	public void setProjectID(String projectID) {
		this.ProjectID = projectID;
	}
	public String getEntryDate() {
		return EntryDate;
	}
	public void setEntryDate(String entryDate) {
		this.EntryDate = entryDate;
	}
	public String getHouseholdID() {
		return HouseholdID;
	}
	public void setHouseholdID(String householdID) {
		this.HouseholdID = householdID;
	}
	public String getRelationshipToHoH() {
		return RelationshipToHoH;
	}
	public void setRelationshipToHoH(String relationshipToHoH) {
		this.RelationshipToHoH = relationshipToHoH;
	}
	public String getLengthOfStay() {
		return LengthOfStay;
	}
	public void setLengthOfStay(String LengthOfStay) {
		this.LengthOfStay = LengthOfStay;
	}
	public String getLivingSituation() {
		return LivingSituation;
	}
	public void setLivingSituation(String livingSituation) {
		LivingSituation = livingSituation;
	}
	public String getLOSUnderThreshold() {
		return LOSUnderThreshold;
	}
	public void setLOSUnderThreshold(String lOSUnderThreshold) {
		LOSUnderThreshold = lOSUnderThreshold;
	}
	public String getPreviousStreetESSH() {
		return PreviousStreetESSH;
	}
	public void setPreviousStreetESSH(String previousStreetESSH) {
		PreviousStreetESSH = previousStreetESSH;
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
	public String getDisablingCondition() {
		return DisablingCondition;
	}
	public void setDisablingCondition(String disablingCondition) {
		DisablingCondition = disablingCondition;
	}
	public String getDateOfEngagement() {
		return DateOfEngagement;
	}
	public void setDateOfEngagement(String dateOfEngagement) {
		DateOfEngagement = dateOfEngagement;
	}
	public String getMoveInDate() {
		return MoveInDate;
	}
	public void setMoveInDate(String moveInDate) {
		MoveInDate = moveInDate;
	}
	public String getDateOfPATHStatus() {
		return DateOfPATHStatus;
	}
	public void setDateOfPATHStatus(String dateOfPATHStatus) {
		DateOfPATHStatus = dateOfPATHStatus;
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
	public String getEligibleForRHY() {
		return EligibleForRHY;
	}
	public void setEligibleForRHY(String eligibleForRHY) {
		EligibleForRHY = eligibleForRHY;
	}
	public String getReasonNoServices() {
		return ReasonNoServices;
	}
	public void setReasonNoServices(String reasonNoServices) {
		ReasonNoServices = reasonNoServices;
	}
	public String getRunawayYouth() {
		return RunawayYouth;
	}
	public void setRunawayYouth(String runawayYouth) {
		RunawayYouth = runawayYouth;
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
	public String getFormerWardJuvenileJustice() {
		return FormerWardJuvenileJustice;
	}
	public void setFormerWardJuvenileJustice(String formerWardJuvenileJustice) {
		FormerWardJuvenileJustice = formerWardJuvenileJustice;
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
	public String getUnemploymentFam() {
		return UnemploymentFam;
	}
	public void setUnemploymentFam(String unemploymentFam) {
		UnemploymentFam = unemploymentFam;
	}
	public String getMentalHealthIssuesFam() {
		return MentalHealthIssuesFam;
	}
	public void setMentalHealthIssuesFam(String mentalHealthIssuesFam) {
		MentalHealthIssuesFam = mentalHealthIssuesFam;
	}
	public String getPhysicalDisabilityFam() {
		return PhysicalDisabilityFam;
	}
	public void setPhysicalDisabilityFam(String physicalDisabilityFam) {
		PhysicalDisabilityFam = physicalDisabilityFam;
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
	public String getIncarceratedParent() {
		return IncarceratedParent;
	}
	public void setIncarceratedParent(String incarceratedParent) {
		IncarceratedParent = incarceratedParent;
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
	public void setCountOutreachReferralApproaches(String countOutreachReferralApproaches) {
		CountOutreachReferralApproaches = countOutreachReferralApproaches;
	}
	public String getUrgentReferral() {
		return UrgentReferral;
	}
	public void setUrgentReferral(String urgentReferral) {
		UrgentReferral = urgentReferral;
	}
	public String getTimeToHousingLoss() {
		return TimeToHousingLoss;
	}
	public void setTimeToHousingLoss(String timeToHousingLoss) {
		TimeToHousingLoss = timeToHousingLoss;
	}
	public String getZeroIncome() {
		return ZeroIncome;
	}
	public void setZeroIncome(String zeroIncome) {
		ZeroIncome = zeroIncome;
	}
	public String getAnnualPercentAMI() {
		return AnnualPercentAMI;
	}
	public void setAnnualPercentAMI(String annualPercentAMI) {
		AnnualPercentAMI = annualPercentAMI;
	}
	public String getFinancialChange() {
		return FinancialChange;
	}
	public void setFinancialChange(String financialChange) {
		FinancialChange = financialChange;
	}
	public String getHouseholdChange() {
		return HouseholdChange;
	}
	public void setHouseholdChange(String householdChange) {
		HouseholdChange = householdChange;
	}
	public String getEvictionHistory() {
		return EvictionHistory;
	}
	public void setEvictionHistory(String evictionHistory) {
		EvictionHistory = evictionHistory;
	}
	public String getSubsidyAtRisk() {
		return SubsidyAtRisk;
	}
	public void setSubsidyAtRisk(String subsidyAtRisk) {
		SubsidyAtRisk = subsidyAtRisk;
	}
	public String getLiteralHomelessHistory() {
		return LiteralHomelessHistory;
	}
	public void setLiteralHomelessHistory(String literalHomelessHistory) {
		LiteralHomelessHistory = literalHomelessHistory;
	}
	public String getDisabledHoH() {
		return DisabledHoH;
	}
	public void setDisabledHoH(String disabledHoH) {
		DisabledHoH = disabledHoH;
	}
	public String getCriminalRecord() {
		return CriminalRecord;
	}
	public void setCriminalRecord(String criminalRecord) {
		CriminalRecord = criminalRecord;
	}
	public String getSexOffender() {
		return SexOffender;
	}
	public void setSexOffender(String sexOffender) {
		SexOffender = sexOffender;
	}
	public String getDependentUnder6() {
		return DependentUnder6;
	}
	public void setDependentUnder6(String dependentUnder6) {
		DependentUnder6 = dependentUnder6;
	}
	public String getSingleParent() {
		return SingleParent;
	}
	public void setSingleParent(String singleParent) {
		SingleParent = singleParent;
	}
	public String getHH5Plus() {
		return HH5Plus;
	}
	public void setHH5Plus(String hH5Plus) {
		HH5Plus = hH5Plus;
	}
	public String getIraqAfghanistan() {
		return IraqAfghanistan;
	}
	public void setIraqAfghanistan(String iraqAfghanistan) {
		IraqAfghanistan = iraqAfghanistan;
	}
	public String getFemVet() {
		return FemVet;
	}
	public void setFemVet(String femVet) {
		FemVet = femVet;
	}
	public String getHPScreeningScore() {
		return HPScreeningScore;
	}
	public void setHPScreeningScore(String hPScreeningScore) {
		HPScreeningScore = hPScreeningScore;
	}
	public String getThresholdScore() {
		return ThresholdScore;
	}
	public void setThresholdScore(String thresholdScore) {
		ThresholdScore = thresholdScore;
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
