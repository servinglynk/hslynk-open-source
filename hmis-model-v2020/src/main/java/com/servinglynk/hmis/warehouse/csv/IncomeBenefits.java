package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;
/***
IncomeBenefitsID	EnrollmentID	PersonalID	InformationDate	IncomeFromAnySource	
TotalMonthlyIncome	Earned	EarnedAmount	Unemployment	UnemploymentAmount	SSI	SSIAmount	
SSDI	SSDIAmount	VADisabilityService	VADisabilityServiceAmount	VADisabilityNonService	VADisabilityNonServiceAmount	
PrivateDisability	PrivateDisabilityAmount	WorkersComp	WorkersCompAmount	TANF	TANFAmount	GA	GAAmount	
SocSecRetirement	SocSecRetirementAmount	Pension	PensionAmount	ChildSupport	ChildSupportAmount	Alimony	AlimonyAmount	
OtherIncomeSource	OtherIncomeAmount	OtherIncomeSourceIdentify	BenefitsFromAnySource	SNAP	WIC	TANFChildCare	
TANFTransportation	OtherTANF	OtherBenefitsSource	OtherBenefitsSourceIdentify	InsuranceFromAnySource	Medicaid	NoMedicaidReason	
Medicare	NoMedicareReason	SCHIP	NoSCHIPReason	VAMedicalServices	NoVAMedReason	EmployerProvided	
NoEmployerProvidedReason	COBRA	NoCOBRAReason	PrivatePay	NoPrivatePayReason	StateHealthIns	NoStateHealthInsReason	
IndianHealthServices	NoIndianHealthServicesReason	OtherInsurance	OtherInsuranceIdentify	HIVAIDSAssistance	
NoHIVAIDSAssistanceReason	ADAP	NoADAPReason	ConnectionWithSOAR	DataCollectionStage	DateCreated	DateUpdated	UserID	
DateDeleted	ExportID			
		
 * @author sdolia
 *
 */
public class IncomeBenefits extends BaseCSV {
	@MapToColumn(column=0)
	private String IncomeBenefitsID;
	@MapToColumn(column=1)
	private String EnrollmentID;
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
	private String OtherBenefitsSource;
	@MapToColumn(column=44)
	private String OtherBenefitsSourceIdentify;
	@MapToColumn(column=45)
	private String InsuranceFromAnySource;
	@MapToColumn(column=46)
	private String Medicaid;
	@MapToColumn(column=47)
	private String NoMedicaidReason;
	@MapToColumn(column=48)
	private String Medicare;
	@MapToColumn(column=49)
	private String NoMedicareReason;
	@MapToColumn(column=50)
	private String SCHIP;
	@MapToColumn(column=51)
	private String NoSCHIPReason;
	@MapToColumn(column=52)
	private String VAMedicalServices;
	@MapToColumn(column=53)
	private String NoVAMedReason;
	@MapToColumn(column=54)
	private String EmployerProvided;
	@MapToColumn(column=55)
	private String NoEmployerProvidedReason;
	@MapToColumn(column=56)
	private String COBRA;
	@MapToColumn(column=57)
	private String NoCOBRAReason;
	@MapToColumn(column=58)
	private String PrivatePay;
	@MapToColumn(column=59)
	private String NoPrivatePayReason;
	@MapToColumn(column=60)
	private String StateHealthIns	;
	@MapToColumn(column=61)
	private String NoStateHealthInsReason;
	@MapToColumn(column=62)
	private String IndianHealthServices;
	@MapToColumn(column=63)
	private String NoIndianHealthServicesReason;
	@MapToColumn(column=64)
	private String OtherInsurance;
	@MapToColumn(column=65)
	private String OtherInsuranceIdentify;
	@MapToColumn(column=66)
	private String HIVAIDSAssistance;
	@MapToColumn(column=67)
	private String NoHIVAIDSAssistanceReason;
	@MapToColumn(column=68)
	private String ADAP;
	@MapToColumn(column=69)
	private String NoADAPReason;
	@MapToColumn(column=70)
	private String ConnectionWithSOAR;
	@MapToColumn(column=71)
	private String DataCollectionStage;
	@MapToColumn(column=72)
	private String DateCreated;
	@MapToColumn(column=73)
	private String DateUpdated;
	@MapToColumn(column=74)
	private String UserID;
	@MapToColumn(column=75)
	private String DateDeleted;
	@MapToColumn(column=76)
	private String ExportID;
	public String getIncomeBenefitsID() {
		return IncomeBenefitsID;
	}
	public void setIncomeBenefitsID(String incomeBenefitsID) {
		IncomeBenefitsID = incomeBenefitsID;
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
	public String getInformationDate() {
		return InformationDate;
	}
	public void setInformationDate(String informationDate) {
		InformationDate = informationDate;
	}
	public String getIncomeFromAnySource() {
		return IncomeFromAnySource;
	}
	public void setIncomeFromAnySource(String incomeFromAnySource) {
		IncomeFromAnySource = incomeFromAnySource;
	}
	public String getTotalMonthlyIncome() {
		return TotalMonthlyIncome;
	}
	public void setTotalMonthlyIncome(String totalMonthlyIncome) {
		TotalMonthlyIncome = totalMonthlyIncome;
	}
	public String getEarned() {
		return Earned;
	}
	public void setEarned(String earned) {
		Earned = earned;
	}
	public String getEarnedAmount() {
		return EarnedAmount;
	}
	public void setEarnedAmount(String earnedAmount) {
		EarnedAmount = earnedAmount;
	}
	public String getUnemployment() {
		return Unemployment;
	}
	public void setUnemployment(String unemployment) {
		Unemployment = unemployment;
	}
	public String getUnemploymentAmount() {
		return UnemploymentAmount;
	}
	public void setUnemploymentAmount(String unemploymentAmount) {
		UnemploymentAmount = unemploymentAmount;
	}
	public String getSSI() {
		return SSI;
	}
	public void setSSI(String sSI) {
		SSI = sSI;
	}
	public String getSSIAmount() {
		return SSIAmount;
	}
	public void setSSIAmount(String sSIAmount) {
		SSIAmount = sSIAmount;
	}
	public String getSSDI() {
		return SSDI;
	}
	public void setSSDI(String sSDI) {
		SSDI = sSDI;
	}
	public String getSSDIAmount() {
		return SSDIAmount;
	}
	public void setSSDIAmount(String sSDIAmount) {
		SSDIAmount = sSDIAmount;
	}
	public String getVADisabilityService() {
		return VADisabilityService;
	}
	public void setVADisabilityService(String vADisabilityService) {
		VADisabilityService = vADisabilityService;
	}
	public String getVADisabilityServiceAmount() {
		return VADisabilityServiceAmount;
	}
	public void setVADisabilityServiceAmount(String vADisabilityServiceAmount) {
		VADisabilityServiceAmount = vADisabilityServiceAmount;
	}
	public String getVADisabilityNonService() {
		return VADisabilityNonService;
	}
	public void setVADisabilityNonService(String vADisabilityNonService) {
		VADisabilityNonService = vADisabilityNonService;
	}
	public String getVADisabilityNonServiceAmount() {
		return VADisabilityNonServiceAmount;
	}
	public void setVADisabilityNonServiceAmount(String vADisabilityNonServiceAmount) {
		VADisabilityNonServiceAmount = vADisabilityNonServiceAmount;
	}
	public String getPrivateDisability() {
		return PrivateDisability;
	}
	public void setPrivateDisability(String privateDisability) {
		PrivateDisability = privateDisability;
	}
	public String getPrivateDisabilityAmount() {
		return PrivateDisabilityAmount;
	}
	public void setPrivateDisabilityAmount(String privateDisabilityAmount) {
		PrivateDisabilityAmount = privateDisabilityAmount;
	}
	public String getWorkersComp() {
		return WorkersComp;
	}
	public void setWorkersComp(String workersComp) {
		WorkersComp = workersComp;
	}
	public String getWorkersCompAmount() {
		return WorkersCompAmount;
	}
	public void setWorkersCompAmount(String workersCompAmount) {
		WorkersCompAmount = workersCompAmount;
	}
	public String getTANF() {
		return TANF;
	}
	public void setTANF(String tANF) {
		TANF = tANF;
	}
	public String getTANFAmount() {
		return TANFAmount;
	}
	public void setTANFAmount(String tANFAmount) {
		TANFAmount = tANFAmount;
	}
	public String getGA() {
		return GA;
	}
	public void setGA(String gA) {
		GA = gA;
	}
	public String getGAAmount() {
		return GAAmount;
	}
	public void setGAAmount(String gAAmount) {
		GAAmount = gAAmount;
	}
	public String getSocSecRetirement() {
		return SocSecRetirement;
	}
	public void setSocSecRetirement(String socSecRetirement) {
		SocSecRetirement = socSecRetirement;
	}
	public String getSocSecRetirementAmount() {
		return SocSecRetirementAmount;
	}
	public void setSocSecRetirementAmount(String socSecRetirementAmount) {
		SocSecRetirementAmount = socSecRetirementAmount;
	}
	public String getPension() {
		return Pension;
	}
	public void setPension(String pension) {
		Pension = pension;
	}
	public String getPensionAmount() {
		return PensionAmount;
	}
	public void setPensionAmount(String pensionAmount) {
		PensionAmount = pensionAmount;
	}
	public String getChildSupport() {
		return ChildSupport;
	}
	public void setChildSupport(String childSupport) {
		ChildSupport = childSupport;
	}
	public String getChildSupportAmount() {
		return ChildSupportAmount;
	}
	public void setChildSupportAmount(String childSupportAmount) {
		ChildSupportAmount = childSupportAmount;
	}
	public String getAlimony() {
		return Alimony;
	}
	public void setAlimony(String alimony) {
		Alimony = alimony;
	}
	public String getAlimonyAmount() {
		return AlimonyAmount;
	}
	public void setAlimonyAmount(String alimonyAmount) {
		AlimonyAmount = alimonyAmount;
	}
	public String getOtherIncomeSource() {
		return OtherIncomeSource;
	}
	public void setOtherIncomeSource(String otherIncomeSource) {
		OtherIncomeSource = otherIncomeSource;
	}
	public String getOtherIncomeAmount() {
		return OtherIncomeAmount;
	}
	public void setOtherIncomeAmount(String otherIncomeAmount) {
		OtherIncomeAmount = otherIncomeAmount;
	}
	public String getOtherIncomeSourceIdentify() {
		return OtherIncomeSourceIdentify;
	}
	public void setOtherIncomeSourceIdentify(String otherIncomeSourceIdentify) {
		OtherIncomeSourceIdentify = otherIncomeSourceIdentify;
	}
	public String getBenefitsFromAnySource() {
		return BenefitsFromAnySource;
	}
	public void setBenefitsFromAnySource(String benefitsFromAnySource) {
		BenefitsFromAnySource = benefitsFromAnySource;
	}
	public String getSNAP() {
		return SNAP;
	}
	public void setSNAP(String sNAP) {
		SNAP = sNAP;
	}
	public String getWIC() {
		return WIC;
	}
	public void setWIC(String wIC) {
		WIC = wIC;
	}
	public String getTANFChildCare() {
		return TANFChildCare;
	}
	public void setTANFChildCare(String tANFChildCare) {
		TANFChildCare = tANFChildCare;
	}
	public String getTANFTransportation() {
		return TANFTransportation;
	}
	public void setTANFTransportation(String tANFTransportation) {
		TANFTransportation = tANFTransportation;
	}
	public String getOtherTANF() {
		return OtherTANF;
	}
	public void setOtherTANF(String otherTANF) {
		OtherTANF = otherTANF;
	}
	public String getOtherBenefitsSource() {
		return OtherBenefitsSource;
	}
	public void setOtherBenefitsSource(String otherBenefitsSource) {
		OtherBenefitsSource = otherBenefitsSource;
	}
	public String getOtherBenefitsSourceIdentify() {
		return OtherBenefitsSourceIdentify;
	}
	public void setOtherBenefitsSourceIdentify(String otherBenefitsSourceIdentify) {
		OtherBenefitsSourceIdentify = otherBenefitsSourceIdentify;
	}
	public String getInsuranceFromAnySource() {
		return InsuranceFromAnySource;
	}
	public void setInsuranceFromAnySource(String insuranceFromAnySource) {
		InsuranceFromAnySource = insuranceFromAnySource;
	}
	public String getMedicaid() {
		return Medicaid;
	}
	public void setMedicaid(String medicaid) {
		Medicaid = medicaid;
	}
	public String getNoMedicaidReason() {
		return NoMedicaidReason;
	}
	public void setNoMedicaidReason(String noMedicaidReason) {
		NoMedicaidReason = noMedicaidReason;
	}
	public String getMedicare() {
		return Medicare;
	}
	public void setMedicare(String medicare) {
		Medicare = medicare;
	}
	public String getNoMedicareReason() {
		return NoMedicareReason;
	}
	public void setNoMedicareReason(String noMedicareReason) {
		NoMedicareReason = noMedicareReason;
	}
	public String getSCHIP() {
		return SCHIP;
	}
	public void setSCHIP(String sCHIP) {
		SCHIP = sCHIP;
	}
	public String getNoSCHIPReason() {
		return NoSCHIPReason;
	}
	public void setNoSCHIPReason(String noSCHIPReason) {
		NoSCHIPReason = noSCHIPReason;
	}
	public String getVAMedicalServices() {
		return VAMedicalServices;
	}
	public void setVAMedicalServices(String vAMedicalServices) {
		VAMedicalServices = vAMedicalServices;
	}
	public String getNoVAMedReason() {
		return NoVAMedReason;
	}
	public void setNoVAMedReason(String noVAMedReason) {
		NoVAMedReason = noVAMedReason;
	}
	public String getEmployerProvided() {
		return EmployerProvided;
	}
	public void setEmployerProvided(String employerProvided) {
		EmployerProvided = employerProvided;
	}
	public String getNoEmployerProvidedReason() {
		return NoEmployerProvidedReason;
	}
	public void setNoEmployerProvidedReason(String noEmployerProvidedReason) {
		NoEmployerProvidedReason = noEmployerProvidedReason;
	}
	public String getCOBRA() {
		return COBRA;
	}
	public void setCOBRA(String cOBRA) {
		COBRA = cOBRA;
	}
	public String getNoCOBRAReason() {
		return NoCOBRAReason;
	}
	public void setNoCOBRAReason(String noCOBRAReason) {
		NoCOBRAReason = noCOBRAReason;
	}
	public String getPrivatePay() {
		return PrivatePay;
	}
	public void setPrivatePay(String privatePay) {
		PrivatePay = privatePay;
	}
	public String getNoPrivatePayReason() {
		return NoPrivatePayReason;
	}
	public void setNoPrivatePayReason(String noPrivatePayReason) {
		NoPrivatePayReason = noPrivatePayReason;
	}
	public String getStateHealthIns() {
		return StateHealthIns;
	}
	public void setStateHealthIns(String stateHealthIns) {
		StateHealthIns = stateHealthIns;
	}
	public String getNoStateHealthInsReason() {
		return NoStateHealthInsReason;
	}
	public void setNoStateHealthInsReason(String noStateHealthInsReason) {
		NoStateHealthInsReason = noStateHealthInsReason;
	}
	public String getIndianHealthServices() {
		return IndianHealthServices;
	}
	public void setIndianHealthServices(String indianHealthServices) {
		IndianHealthServices = indianHealthServices;
	}
	public String getNoIndianHealthServicesReason() {
		return NoIndianHealthServicesReason;
	}
	public void setNoIndianHealthServicesReason(String noIndianHealthServicesReason) {
		NoIndianHealthServicesReason = noIndianHealthServicesReason;
	}
	public String getOtherInsurance() {
		return OtherInsurance;
	}
	public void setOtherInsurance(String otherInsurance) {
		OtherInsurance = otherInsurance;
	}
	public String getOtherInsuranceIdentify() {
		return OtherInsuranceIdentify;
	}
	public void setOtherInsuranceIdentify(String otherInsuranceIdentify) {
		OtherInsuranceIdentify = otherInsuranceIdentify;
	}
	public String getHIVAIDSAssistance() {
		return HIVAIDSAssistance;
	}
	public void setHIVAIDSAssistance(String hIVAIDSAssistance) {
		HIVAIDSAssistance = hIVAIDSAssistance;
	}
	public String getNoHIVAIDSAssistanceReason() {
		return NoHIVAIDSAssistanceReason;
	}
	public void setNoHIVAIDSAssistanceReason(String noHIVAIDSAssistanceReason) {
		NoHIVAIDSAssistanceReason = noHIVAIDSAssistanceReason;
	}
	public String getADAP() {
		return ADAP;
	}
	public void setADAP(String aDAP) {
		ADAP = aDAP;
	}
	public String getNoADAPReason() {
		return NoADAPReason;
	}
	public void setNoADAPReason(String noADAPReason) {
		NoADAPReason = noADAPReason;
	}
	public String getConnectionWithSOAR() {
		return ConnectionWithSOAR;
	}
	public void setConnectionWithSOAR(String connectionWithSOAR) {
		ConnectionWithSOAR = connectionWithSOAR;
	}
	public String getDataCollectionStage() {
		return DataCollectionStage;
	}
	public void setDataCollectionStage(String dataCollectionStage) {
		DataCollectionStage = dataCollectionStage;
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
