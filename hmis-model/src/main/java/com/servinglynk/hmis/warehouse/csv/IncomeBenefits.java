package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;
										
public class IncomeBenefits {
	@MapToColumn(column=0)
	private String IncomeBenefitsID;
	@MapToColumn(column=1)
	private String ProjectEntryID;
	@MapToColumn(column=2)
	private String PersonalID;
	@MapToColumn(column=3)
	private String InformationDate;
	@MapToColumn(column=4)
	private String IncomeFromAnySource;
	@MapToColumn(column=5)
	private String TotalMonthlyIncome;
	@MapToColumn(column=6)
	private String Earned;
	@MapToColumn(column=7)
	private String EarnedAmount;
	@MapToColumn(column=8)
	private String Unemployment;
	@MapToColumn(column=9)
	private String UnemploymentAmount;
	@MapToColumn(column=10)
	private String SSI;
	@MapToColumn(column=11)
	private String SSIAmount;
	@MapToColumn(column=12)
	private String SSDI;
	@MapToColumn(column=13)
	private String SSDIAmount;
	@MapToColumn(column=14)
	private String VADisabilityService;
	@MapToColumn(column=15)
	private String VADisabilityServiceAmount;
	@MapToColumn(column=16)
	private String VADisabilityNonService;
	@MapToColumn(column=17)
	private String VADisabilityNonServiceAmount;
	@MapToColumn(column=18)
	private String PrivateDisability;
	@MapToColumn(column=19)
	private String PrivateDisabilityAmount;
	@MapToColumn(column=20)
	private String WorkersComp;
	@MapToColumn(column=21)
	private String WorkersCompAmount;
	@MapToColumn(column=22)
	private String TANF;
	@MapToColumn(column=23)
	private String TANFAmount;
	@MapToColumn(column=24)
	private String GA;
	@MapToColumn(column=25)
	private String GAAmount;
	@MapToColumn(column=26)
	private String SocSecRetirement;
	@MapToColumn(column=27)
	private String SocSecRetirementAmount;
	@MapToColumn(column=28)
	private String Pension;
	@MapToColumn(column=29)
	private String PensionAmount;
	@MapToColumn(column=30)
	private String ChildSupport;
	@MapToColumn(column=31)
	private String ChildSupportAmount;
	@MapToColumn(column=32)
	private String Alimony;
	@MapToColumn(column=33)
	private String AlimonyAmount;
	@MapToColumn(column=34)
	private String OtherIncomeSource;
	@MapToColumn(column=35)
	private String OtherIncomeAmount;
	@MapToColumn(column=36)
	private String OtherIncomeSourceIdentify;
	@MapToColumn(column=37)
	private String BenefitsFromAnySource;
	@MapToColumn(column=38)
	private String SNAP;
	@MapToColumn(column=39)
	private String WIC;
	@MapToColumn(column=40)
	private String TANFChildCare;
	@MapToColumn(column=41)
	private String TANFTransportation;
	@MapToColumn(column=42)
	private String OtherTANF;
	@MapToColumn(column=43)
	private String RentalAssistanceOngoing;
	@MapToColumn(column=44)
	private String RentalAssistanceTemp;
	@MapToColumn(column=45)
	private String OtherBenefitsSource;
	@MapToColumn(column=46)
	private String OtherBenefitsSourceIdentify;
	@MapToColumn(column=47)
	private String InsuranceFromAnySource;
	@MapToColumn(column=48)
	private String Medicaid;
	@MapToColumn(column=49)
	private String NoMedicaidReason;
	@MapToColumn(column=50)
	private String Medicare;
	@MapToColumn(column=51)
	private String NoMedicareReason;
	@MapToColumn(column=52)
	private String SCHIP;
	@MapToColumn(column=53)
	private String NoSCHIPReason;
	@MapToColumn(column=54)
	private String VAMedicalServices;
	@MapToColumn(column=55)
	private String NoVAMedReason;
	@MapToColumn(column=56)
	private String EmployerProvided;
	@MapToColumn(column=57)
	private String NoEmployerProvidedReason;
	@MapToColumn(column=58)
	private String COBRA;
	@MapToColumn(column=59)
	private String NoCOBRAReason;
	@MapToColumn(column=60)
	private String PrivatePay;
	@MapToColumn(column=61)
	private String NoPrivatePayReason;
	@MapToColumn(column=62)
	private String StateHealthIns;
	@MapToColumn(column=63)
	private String NoStateHealthInsReason;
	@MapToColumn(column=64)
	private String HIVAIDSAssistance;
	@MapToColumn(column=65)
	private String NoHIVAIDSAssistanceReason;
	@MapToColumn(column=66)
	private String ADAP;
	@MapToColumn(column=67)
	private String NoADAPReason;
	@MapToColumn(column=68)
	private String DataCollectionStage;
	@MapToColumn(column=69)
	private String DateCreated;
	@MapToColumn(column=70)
	private String DateUpdated;
	@MapToColumn(column=71)
	private String UserID;
	@MapToColumn(column=72)
	private String DateDeleted;
	@MapToColumn(column=73)
	private String ExportID;
}
