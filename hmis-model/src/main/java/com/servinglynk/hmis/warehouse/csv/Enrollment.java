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
				
	
}
