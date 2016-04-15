package com.servinglynk.hmis.warehouse.dao.helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.servinglynk.hmis.warehouse.domain.Sources;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Disabilities;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.DomesticViolence;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Employment;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EnrollmentCoC;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Exit;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Funder;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HealthInsurance;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.IncomeAndSources;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.NonCashBenefits;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Organization;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.PercentAMI;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Project;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ProjectCoC;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Services;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Site;
import com.servinglynk.hmis.warehouse.model.base.BulkUpload;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;
public class BulkUploadHelperTest1 {

	public BulkUploadHelper helper = new BulkUploadHelper();
	private Sources sources;
	
	@Before
	public void setUp() {
		
	}
	


	@Test
	public void testCVSUpload() {
		URL path = BulkUploadHelper.class.getResource("CSV_files.zip");
		BulkUpload upload = new BulkUpload();
		upload.setInputpath(path.getPath());
		ProjectGroupEntity projectGrp = new ProjectGroupEntity();
		projectGrp.setSkipuseridentifers(true);
		sources = helper.getSourcesFromFiles(upload,projectGrp);
		assertNotNull(sources);
		
		List<Client> clients = sources.getSource().getExport().getClient();
		assertNotNull(clients);
		assertEquals(clients.size(), 16);
		Client client = clients.get(0);
		/*PersonalID	FirstName	MiddleName	LastName	NameSuffix	NameDataQuality	SSN	SSNDataQuality	DOB	DOBDataQuality	AmIndAKNative	Asian	BlackAfAmerican	NativeHIOtherPacific	White	RaceNone	Ethnicity	Gender	OtherGender	VeteranStatus	YearEnteredService	YearSeparated	WorldWarII	KoreanWar	VietnamWar	DesertStorm	AfghanistanOEF	IraqOIF	IraqOND	OtherTheater	MilitaryBranch	DischargeStatus	DateCreated	DateUpdated	UserID	DateDeleted	ExportID
					135	Ignatz	Ignateous	Icecream								1	654585241	1	1/1/1981	1	0	0	1	0	0		0	1		0			99	99	99	99	99	99	99	99	99	99	6/25/2015 11:28	6/25/2015 0:00	McComas, Mark		7E4D12A248584E92B0E2235B363AB0A6
*/
		assertEquals(client.getFirstName(), "Ignatz");
		assertEquals(client.getMiddleName(), "Ignateous");
		assertEquals(client.getLastName(), "Icecream");
		assertEquals(client.getNameDataQuality(), helper.getByte("1"));
		assertEquals(client.getSSN(), "654585241");
		assertEquals(client.getSSNDataQuality(), helper.getByte("1"));
		assertEquals(client.getDOB(), helper.getXMLGregorianCalendar("1981-01-01"));
		assertEquals(client.getDOBDataQuality(), helper.getByte("1"));
		assertEquals(client.getGender(), 1);
//		clients.size();
//		equals(((List<Client>) client).size());
		
		
		/*DisabilitiesID	ProjectEntryID	PersonalID	InformationDate	DisabilityType	DisabilityResponse	IndefiniteAndImpairs	DocumentationOnFile	ReceivingServices	PATHHowConfirmed	PATHSMIInformation	TCellCountAvailable	TCellCount	TCellSource	ViralLoadAvailable	ViralLoad	ViralLoadSource	DataCollectionStage	DateCreated	DateUpdated	UserID	DateDeleted	ExportID
		2010p	116	135	5/13/2014	5	0	99	99	99									1	6/25/2015 0:00	6/25/2015 0:00	mmccomas		7E4D12A248584E92B0E2235B363AB0A6
		*/
		List<Disabilities> disabilities = sources.getSource().getExport().getDisabilities();
		assertNotNull(disabilities);
		assertEquals(disabilities.size(), 114);
		Disabilities disability = disabilities.get(0);
		assertEquals(disability.getProjectEntryID(),"116");
		assertEquals(disability.getDisabilityType(),5);
		assertEquals(disability.getDisabilityResponse(),0);
		assertEquals(disability.getIndefiniteAndImpairs(),99);
		assertEquals(disability.getDocumentationOnFile(),99);
		assertEquals(disability.getReceivingServices(),99);
		assertEquals(disability.getPATHHowConfirmed(),0);
		assertEquals(disability.getPATHSMIInformation(),0);
		assertEquals(disability.getUserID(),"mmccomas");
//		assertEquals(disabilities.size(),114);
		
		/*EmploymentEducationID	ProjectEntryID	PersonalID	InformationDate	LastGradeCompleted	SchoolStatus	Employed	EmploymentType	NotEmployedReason	DataCollectionStage	DateCreated	DateUpdated	UserID	DateDeleted	ExportID
		2006	116	135	5/13/2014	99	99	1	2		1	6/25/2015 0:00	6/25/2015 0:00	mmccomas		7E4D12A248584E92B0E2235B363AB0A6
*/
		
		List<Employment> empEducation = sources.getSource().getExport().getEmployment();
		assertNotNull(empEducation);
		assertEquals(empEducation.size(),20);
		Employment employment = empEducation.get(0);
		assertEquals(employment.getEmployed(), 1);
		assertEquals(employment.getEmploymentID(),"2006");
		assertEquals(employment.getEmploymentType(),2);
		assertEquals(employment.getNotEmployedReason(), 0);
		assertEquals(employment.getProjectEntryID(),"116");
		assertEquals(employment.getUserID(), "mmccomas");
		empEducation.size();
		
		/*ProjectEntryID	PersonalID	ProjectID	EntryDate	HouseholdID	RelationshipToHoH	ResidencePrior	OtherResidencePrior	ResidencePriorLengthOfStay	DisablingCondition	EntryFromStreetESSH	DateToStreetESSH	TimesHomelessPastThreeYears	MonthsHomelessPastThreeYears	HousingStatus	DateOfEngagement	InPermanentHousing	ResidentialMoveInDate	DateOFPATHStatus	ClientEnrolledInPATH	ReasonNotEnrolled	WorstHousingSituation	PercentAMI	LastPermanentStreet	LastPermanentCity	LastPermanentState	LastPermanentZIP	AddressDataQuality	DateOfBCPStatus	FYSBYouth	ReasonNoServices	SexualOrientation	FormerWardChildWelfare	ChildWelfareYears	ChildWelfareMonths	FormerWardJuvenileJustice	JuvenileJusticeYears	JuvenileJusticeMonths	HouseholdDynamics	SexualOrientationGenderIDYouth	SexualOrientationGenderIDFam	HousingIssuesYouth	HousingIssuesFam	SchoolEducationalIssuesYouth	SchoolEducationalIssuesFam	UnemploymentYouth	UnemploymentFam	MentalHealthIssuesYouth	MentalHealthIssuesFam	HealthIssuesYouth	HealthIssuesFam	PhysicalDisabilityYouth	PhysicalDisabilityFam	MentalDisabilityYouth	MentalDisabilityFam	AbuseAndNeglectYouth	AbuseAndNeglectFam	AlcoholDrugAbuseYouth	AlcoholDrugAbuseFam	InsufficientIncome	ActiveMilitaryParent	IncarceratedParent	IncarceratedParentStatus	ReferralSource	CountOutreachReferralApproaches	ExchangeForSex	ExchangeForSexPastThreeMonths	CountOfExchangeForSex	AskedOrForcedToExchangeForSex	AskedOrForcedToExchangeForSexPastThreeMonths	WorkPlaceViolenceThreats	WorkPlacePromiseDifference	CoercedToContinueWork	LaborExploitPastThreeMonths	HPScreeningScore	VAMCStation	DateCreated	DateUpdated	UserID	DateDeleted	ExportID
		116	135	240	5/13/2014	135	1	4		3	1	1	6/1/2013	1	111	99					99		99						99		99		99	99			99			0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0		99		99					99	99					6/25/2015 11:28	6/25/2015 0:00	McComas, Mark		7E4D12A248584E92B0E2235B363AB0A6
*/
		List<Enrollment> enroll = sources.getSource().getExport().getEnrollment();
		assertNotNull(enroll);
		assertEquals(enroll.size(),16);
		Enrollment enrollment = enroll.get(0);
		assertEquals(enrollment.getContinuouslyHomelessOneYear(), 0);
		assertEquals(enrollment.getHouseholdID(), "135");
		assertEquals(enrollment.getHousingStatus(), 99);
		assertEquals(enrollment.getMonthsHomelessPastThreeYears(),111);
		assertEquals(enrollment.getMonthsHomelessThisTime(),0);
		assertEquals(enrollment.getOtherResidencePrior(), "");
		assertEquals(enrollment.getPersonalID(),"135");
		assertEquals(enrollment.getRelationshipToHoH(), 1);
		assertEquals(enrollment.getResidencePrior(), 4);
		assertEquals(enrollment.getResidencePriorLengthOfStay(), 3);
		assertEquals(enrollment.getStatusDocumented(), 0);
		assertEquals(enrollment.getTimesHomelessPastThreeYears(), 1);
		assertEquals(enrollment.getUserID(), "2015-06-25 00:00:00");
		assertEquals(enrollment.getYearsHomeless(),0);
		enroll.size();
		
		List<EnrollmentCoC> enrollCoc = sources.getSource().getExport().getEnrollmentCoC();
		assertNotNull(enrollCoc);
		assertEquals(enrollCoc.size(), 13);
		EnrollmentCoC enrollmentCoC = enrollCoc.get(0);
		assertEquals(enrollmentCoC.getEnrollmentCoCID(),2006);
		assertEquals(enrollmentCoC.getProjectCoCID(),240);
		assertEquals(enrollmentCoC.getProjectEntryID(), "116");
		assertEquals(enrollmentCoC.getUserID(), "mmccomas");
		enrollCoc.size();
		
		List<Exit> ext = sources.getSource().getExport().getExit();
		assertNotNull(ext);
		assertEquals(ext.size(),3);
		Exit exit = ext.get(0);
		assertEquals(exit.getDestination(), 10);
		assertEquals(exit.getExitID(), "2475");
		assertEquals(exit.getOtherDestination(), "");
		assertEquals(exit.getProjectEntryID(), "117");
		assertEquals(exit.getUserID(),"mmccomas");
		ext.size();

		Export exp = sources.getSource().getExport();
		assertNotNull(exp);
		assertEquals(exp.getExportID(), 0);
		assertEquals(exp.getExportDirective(),"2");
		assertEquals(exp.getExportPeriodType(),"3");
		
		
		List<Funder> fund = sources.getSource().getExport().getFunder();
		assertNotNull(fund);
		assertEquals(fund.size(), 0);
//		Funder funder = fund.get(0);
//		assertEquals(funder.getFunder(),0);
		
		 List<HealthInsurance> healthIns= sources.getSource().getExport().getHealthInsurance();
		 assertNotNull(healthIns);
		 assertEquals(healthIns.size(), 20);
		 HealthInsurance healthInsurance = healthIns.get(0);
		 assertEquals(healthInsurance.getEmployerProvided(), 0);
		 assertEquals(healthInsurance.getHealthInsuranceID(),null);
		 assertEquals(healthInsurance.getInsuranceFromAnySource(),1);
		 assertEquals(healthInsurance.getMedicaid(),1);
		 assertEquals(healthInsurance.getMedicare(), 0);
		 assertEquals(healthInsurance.getNoCOBRAReason(), 99);
		 assertEquals(healthInsurance.getNoEmployerProvidedReason(),99);
		 assertEquals(healthInsurance.getNoMedicaidReason(), 99);
		 assertEquals(healthInsurance.getNoMedicareReason(),99);
		 assertEquals(healthInsurance.getNoPrivatePayReason(), 99);
		 assertEquals(healthInsurance.getNoSCHIPReason(), 99);
		 assertEquals(healthInsurance.getNoStateHealthInsReason(), 0);
		 assertEquals(healthInsurance.getNoVAMedReason(), 99);
		 assertEquals(healthInsurance.getPrivatePay(), 0);
		 assertEquals(healthInsurance.getProjectEntryID(), "116");
		 assertEquals(healthInsurance.getSCHIP(),0);
		 assertEquals(healthInsurance.getStateHealthIns(),99);
		 assertEquals(healthInsurance.getUserID(),"mmccomas");
		 assertEquals(healthInsurance.getVAMedicalServices(),0);
		 
		List<IncomeAndSources> incomeSource = sources.getSource().getExport().getIncomeAndSources();
		assertNotNull(incomeSource);
		assertEquals(incomeSource.size(), 20);
		IncomeAndSources incomeAndSources = incomeSource.get(0);
		assertEquals(incomeAndSources.getAlimony(), 0);
		assertEquals(incomeAndSources.getAlimonyAmount(), 0.0, 0.0002);
		assertEquals(incomeAndSources.getChildSupport(), 0);
		assertEquals(incomeAndSources.getChildSupportAmount(),  0.0, 0.0002);
		assertEquals(incomeAndSources.getEarned(),1);
		assertEquals(incomeAndSources.getEarnedAmount(), 600.0, 0.0002);
		assertEquals(incomeAndSources.getGA(), 0);
		assertEquals(incomeAndSources.getGAAmount(), 0.0, 0.0002);
		assertEquals(incomeAndSources.getIncomeAndSourcesID(), "2008");
		assertEquals(incomeAndSources.getIncomeFromAnySource(), 1);
		assertEquals(incomeAndSources.getOtherSource(), 0);
		assertEquals(incomeAndSources.getOtherSourceAmount(), 0.0, 0.0002);
		assertEquals(incomeAndSources.getOtherSourceIdentify(), "");
		assertEquals(incomeAndSources.getPension(), 0);
		assertEquals(incomeAndSources.getPensionAmount(), 0.0, 0.0002);
		assertEquals(incomeAndSources.getPrivateDisability(), 0);
		assertEquals(incomeAndSources.getPrivateDisabilityAmount(),0.0,0.0002);
		assertEquals(incomeAndSources.getProjectEntryID(),"116");
		assertEquals(incomeAndSources.getSocSecRetirement(),0);
		assertEquals(incomeAndSources.getSocSecRetirementAmount(), 0.0, 0.0002);
		assertEquals(incomeAndSources.getSSDI(), 0);
		assertEquals(incomeAndSources.getSSDIAmount(), 0.0, 0.0002);
		assertEquals(incomeAndSources.getSSI(),0);
		assertEquals(incomeAndSources.getSSIAmount(), 0.0, 0.0002);
		assertEquals(incomeAndSources.getTANF(),0);
		assertEquals(incomeAndSources.getTANFAmount(), 0.0, 0.0002 );
		assertEquals(incomeAndSources.getTotalMonthlyIncome(), 600.0, 0.0002);
		assertEquals(incomeAndSources.getUnemployment(), 0);
		assertEquals(incomeAndSources.getUnemploymentAmount(),0.0,0.0002);
		assertEquals(incomeAndSources.getUserID(),"mmccomas");
		assertEquals(incomeAndSources.getVADisabilityNonService(), 0);
		assertEquals(incomeAndSources.getVADisabilityNonServiceAmount(), 0.0, 0.0002);
		assertEquals(incomeAndSources.getVADisabilityService(), 0);
		assertEquals(incomeAndSources.getVADisabilityServiceAmount(), 0.0, 0.0002);
		assertEquals(incomeAndSources.getWorkersComp(), 0);
		assertEquals(incomeAndSources.getWorkersCompAmount(), 0.0, 0.0002);
		
		List<Inventory> inventory = sources.getSource().getExport().getInventory();
		assertNotNull(inventory);
		assertEquals(inventory.size(),0);
//		Inventory invent = inventory.get(0);
//		assertEquals(invent.getAvailabilty(), 0);
		
		List<Organization> org = sources.getSource().getExport().getOrganization();
		assertNotNull(org);
		assertEquals(org.size(),1);
		Organization organization = org.get(0);
		assertEquals(organization.getOrganizationCommonName(), "All Practical Reporting");
		assertEquals(organization.getOrganizationID(), 0);
		assertEquals(organization.getOrganizationName(),"All Practical Reporting, Inc. ");
		assertEquals(organization.getUserID(),"844");
		
		List<Project> prjt = sources.getSource().getExport().getProject();
		assertNotNull(prjt);
		assertEquals(prjt.size(), 1);
		Project project = prjt.get(0);
		assertEquals(project.getContinuumProject(), 1);
		assertEquals(project.getOrganizationID(), 0);
		assertEquals(project.getProjectName(), "APR - Services Only");
		assertEquals(project.getProjectType(), 6);
		assertEquals(project.getProjectCommonName(), "APR - Services Only");
		assertEquals(project.getResidentialAffiliation(), 0);
		assertEquals(project.getTargetPopulation(), 0);
		assertEquals(project.getTrackingMethod(), 0);
		assertEquals(project.getUserID(), "mhawthorne");
		
		List<ProjectCoC> prjtCoC = sources.getSource().getExport().getProjectCoC();
		assertNotNull(prjtCoC);
		assertEquals(prjtCoC.size(), 1);
		ProjectCoC projectCoC = prjtCoC.get(0);
		assertEquals(projectCoC.getCoCCode(), "OH-500");
		assertEquals(projectCoC.getProjectCoCID(), 1996);
		assertEquals(projectCoC.getProjectID(), "240");
		assertEquals(projectCoC.getUserID(), "mhawthorne");
		
		List<Services> service = sources.getSource().getExport().getServices();
		assertNotNull(service);
		assertEquals(service.size(),0);
		
		List<Site> ste =sources.getSource().getExport().getSite();
		assertNotNull(ste);
		assertEquals(ste.size(), 1);
		Site site = ste.get(0);
		assertEquals(site.getAddress(), "217 West 12th St");
		assertEquals(site.getCity(), "Cincinnati");
		assertEquals(site.getGeocode(), 391062);
		assertEquals(site.getPrincipalSite(), 1);
		assertEquals(site.getSiteID(), 1996);
		assertEquals(site.getState(), "OH");
		assertEquals(site.getUserID(),"mhawthorne");
		assertEquals(site.getZIP(), 45202);
		
	
	}
	
	@Test
	public void testXMLUpload() {
		URL path = BulkUploadHelperTest1.class.getResource("HUD_4_0__6.xml");
//		System.out.println(path);
		BulkUpload upload = new BulkUpload();
		upload.setInputpath("C:\\HMIS\\hmis-lynk-open-source\\hmis-model\\src\\main\\test\\com\\servinglynk\\hmis\\warehouse\\dao\\HUD_4_0__6.xml");
		upload.setProjectGroupCode("PG0001");
		ProjectGroupEntity projectGrp = new ProjectGroupEntity();
		projectGrp.setSkipuseridentifers(true);
		sources = helper.getSourcesFromFiles(upload,projectGrp);
		assertNotNull(sources);
		
		List<Client> clients = sources.getSource().getExport().getClient();
		assertNotNull(clients);
		assertEquals(clients.size(), 10);
		
		Client client = clients.get(0);
		assertEquals(client.getPersonalID(), "client_3");
		/*assertEquals(client.getFirstName(),"Indy");
		assertEquals(client.getLastName(), "Entonly");*/
		assertEquals(client.getNameDataQuality(), 99);
//		assertEquals(client.getSSN(), "111223333");
		assertEquals(client.getSSNDataQuality(), 1);
//		assertEquals(client.getDOB(),helper.getXMLGregorianCalendar("1968-01-05"));
		assertEquals(client.getDOBDataQuality(), 99);
		/*assertEquals(client.getDOB(), helper.getXMLGregorianCalendar("1981-01-01"));
		assertEquals(client.getDOBDataQuality(), helper.getByte("1"));*/
		assertEquals(client.getGender(),1);
        assertEquals(client.getEthnicity(), 0);
        assertEquals(client.getRace(), 1);
        assertEquals(client.getVeteranStatus(),99);
        
        List<Enrollment> enroll = sources.getSource().getExport().getEnrollment();
		assertNotNull(enroll);
		assertEquals(enroll.size(),10);
		
		Enrollment enrollment = enroll.get(0);
		assertEquals(enrollment.getProjectEntryID(), "ee_1");
		assertEquals(enrollment.getPersonalID(), "client_3");
		assertEquals(enrollment.getProjectID(), "p_0");
//		assertEquals(enrollment.getEntryDate(),helper.getXMLGregorianCalendar("2014-01-31"));
		assertEquals(enrollment.getHouseholdID(), "single_ee_1");
		assertEquals(enrollment.getRelationshipToHoH(), helper.getByte("1"));
		assertEquals(enrollment.getResidencePrior(),helper.getByte("12"));
		assertEquals(enrollment.getResidencePriorLengthOfStay(),helper.getByte("4"));
		assertEquals(enrollment.getHousingStatus(),helper.getByte("2"));
        
		List<Disabilities> disabilities = sources.getSource().getExport().getDisabilities();
		assertNotNull(disabilities);
		assertEquals(disabilities.size(), 2);
		Disabilities disability = disabilities.get(0);
		assertEquals(disability.getProjectEntryID(),"ee_1");
		assertEquals(disability.getDisabilityType(),7);
		assertEquals(disability.getDisabilityResponse(),1);
		assertEquals(disability.getIndefiniteAndImpairs(),99);
		assertEquals(disability.getDocumentationOnFile(),99);
		assertEquals(disability.getReceivingServices(),1);
		
		List<Employment> empEducation = sources.getSource().getExport().getEmployment();
		assertNotNull(empEducation);
		assertEquals(empEducation.size(),2);
		Employment employment = empEducation.get(0);
		assertEquals(employment.getEmployed(), 0);
		assertEquals(employment.getEmploymentID(),"ee_1_employ");
		assertEquals(employment.getEmploymentType(),0);
		assertEquals(employment.getNotEmployedReason(), 0);
		assertEquals(employment.getProjectEntryID(),"ee_1");
		assertEquals(employment.getUserID(), "p_0_user");
		empEducation.size();
		
		List<EnrollmentCoC> enrollCoc = sources.getSource().getExport().getEnrollmentCoC();
		assertNotNull(enrollCoc);
		assertEquals(enrollCoc.size(), 10);
		EnrollmentCoC enrollmentCoC = enrollCoc.get(0);
		assertEquals(enrollmentCoC.getEnrollmentCoCID(),0);
		assertEquals(enrollmentCoC.getProjectCoCID(),0);
		assertEquals(enrollmentCoC.getProjectEntryID(), "ee_1");
		assertEquals(enrollmentCoC.getUserID(), "p_0_user");
		enrollCoc.size();
		
		 List<HealthInsurance> healthIns= sources.getSource().getExport().getHealthInsurance();
		 assertNotNull(healthIns);
		 assertEquals(healthIns.size(), 10);
		 HealthInsurance healthInsurance = healthIns.get(0);
		 assertEquals(healthInsurance.getEmployerProvided(), 0);
		 assertEquals(healthInsurance.getHealthInsuranceID(),"ee_1_hi");
		 assertEquals(healthInsurance.getInsuranceFromAnySource(),0);
		 assertEquals(healthInsurance.getMedicaid(),0);
		 assertEquals(healthInsurance.getMedicare(), 0);
		 assertEquals(healthInsurance.getNoCOBRAReason(), 0);
		 assertEquals(healthInsurance.getNoEmployerProvidedReason(),0);
		 assertEquals(healthInsurance.getNoMedicaidReason(), 0);
		 assertEquals(healthInsurance.getNoMedicareReason(),0);
		 assertEquals(healthInsurance.getNoPrivatePayReason(), 0);
		 assertEquals(healthInsurance.getNoSCHIPReason(), 0);
		 assertEquals(healthInsurance.getNoStateHealthInsReason(), 0);
		 assertEquals(healthInsurance.getNoVAMedReason(), 0);
		 assertEquals(healthInsurance.getPrivatePay(), 0);
		 assertEquals(healthInsurance.getProjectEntryID(), "ee_1");
		 assertEquals(healthInsurance.getSCHIP(),0);
		 assertEquals(healthInsurance.getStateHealthIns(),0);
		 assertEquals(healthInsurance.getUserID(),"p_0_user");
		 assertEquals(healthInsurance.getVAMedicalServices(),0);
		 
		 List<DomesticViolence> domesticVio = sources.getSource().getExport().getDomesticViolence();
		 assertNotNull(domesticVio);
		 assertEquals(domesticVio.size(),3);
		 DomesticViolence domesticViolence = domesticVio.get(0);
		 assertEquals(domesticViolence.getDomesticViolenceID(),"ee_2_dv");
		 assertEquals(domesticViolence.getDomesticViolenceVictim(), helper.getByte("1"));
//		 assertEquals(domesticViolence.getInformationDate(),helper.getXMLGregorianCalendar("2014-03-16"));
		 assertEquals(domesticViolence.getProjectEntryID(),"ee_2");
		 assertEquals(domesticViolence.getUserID(),"p_0_user");
		 assertEquals(domesticViolence.getWhenOccurred(), helper.getByte("1"));
		 
		 List<Services> service = sources.getSource().getExport().getServices();
		 assertNotNull(service);
		 assertEquals(service.size(),6);
		 Services services = service.get(0);
		 assertEquals(services.getFAAmount(), 0.0, 0.0002);
		 assertEquals(services.getOtherTypeProvided(), "AIRS code: BH-3700.3200");
		 assertEquals(services.getProjectEntryID(), "ee_2");
		 assertEquals(services.getRecordType(), helper.getByte("14"));
		 assertEquals(services.getReferralOutcome(), helper.getByte(""));
		 assertEquals(services.getServicesID(), "service_2");
		 assertEquals(services.getSubTypeProvided(), helper.getByte(""));
		 assertEquals(services.getTypeProvided(), helper.getByte("99"));
		 assertEquals(services.getUserID(), "service_2_user");
		
		 
		 
		 List<IncomeAndSources> incomeSource = sources.getSource().getExport().getIncomeAndSources();
		 assertNotNull(incomeSource);
		 assertEquals(incomeSource.size(), 4);
		 IncomeAndSources incomeAndSources = incomeSource.get(0);
		 assertEquals(incomeAndSources.getAlimony(), 0);
		 assertEquals(incomeAndSources.getAlimonyAmount(), 0.0, 0.0002);
		 assertEquals(incomeAndSources.getChildSupport(), 0);
		 assertEquals(incomeAndSources.getChildSupportAmount(), 0.0, 0.0002);
		 assertEquals(incomeAndSources.getEarned(),0);
		 assertEquals(incomeAndSources.getEarnedAmount(),0.0, 0.0002);
		 assertEquals(incomeAndSources.getGA(), 0);
		 assertEquals(incomeAndSources.getGAAmount(),0.0, 0.0002);
		 assertEquals(incomeAndSources.getIncomeAndSourcesID(), "ee_7_inc");
		 assertEquals(incomeAndSources.getIncomeFromAnySource(), 0);
		 assertEquals(incomeAndSources.getOtherSource(), 0);
		 assertEquals(incomeAndSources.getOtherSourceAmount(),0.0, 0.0002);
		 assertEquals(incomeAndSources.getOtherSourceIdentify(), "");
		 assertEquals(incomeAndSources.getPension(), 0);
		 assertEquals(incomeAndSources.getPensionAmount(),0.0, 0.0002);
		 assertEquals(incomeAndSources.getPrivateDisability(), 0);
		 assertEquals(incomeAndSources.getPrivateDisabilityAmount(), 0.0, 0.0002);
		 assertEquals(incomeAndSources.getProjectEntryID(),"ee_7");
		 assertEquals(incomeAndSources.getSocSecRetirement(),0);
		 assertEquals(incomeAndSources.getSocSecRetirementAmount(),0.0, 0.0002);
		 assertEquals(incomeAndSources.getSSDI(), 0);
		 assertEquals(incomeAndSources.getSSDIAmount(),0.0, 0.0002);
		 assertEquals(incomeAndSources.getSSI(),0);
		 assertEquals(incomeAndSources.getSSIAmount(),0.0, 0.0002);
		 assertEquals(incomeAndSources.getTANF(),0);
		 assertEquals(incomeAndSources.getTANFAmount(),0.0, 0.0002);
		 assertEquals(incomeAndSources.getTotalMonthlyIncome(),0.0, 0.0002);
		 assertEquals(incomeAndSources.getUnemployment(), 0);
		 assertEquals(incomeAndSources.getUnemploymentAmount(),0.0, 0.0002);
		 assertEquals(incomeAndSources.getUserID(),"p_0_user");
		 assertEquals(incomeAndSources.getVADisabilityNonService(), 0);
		 assertEquals(incomeAndSources.getVADisabilityNonServiceAmount(), 0.0, 0.0002);
		 assertEquals(incomeAndSources.getVADisabilityService(), 0);
		 assertEquals(incomeAndSources.getVADisabilityServiceAmount(), 0.0, 0.0002);
		 assertEquals(incomeAndSources.getWorkersComp(), 0);
		 assertEquals(incomeAndSources.getWorkersCompAmount(), 0.0, 0.0002);
		 
		 List<NonCashBenefits> ncBenefits = sources.getSource().getExport().getNonCashBenefits();
		 assertNotNull(ncBenefits);
		 assertEquals(ncBenefits.size(),5);
		 NonCashBenefits nonCashBenefits = ncBenefits.get(0);
		 assertEquals(nonCashBenefits.getBenefitsFromAnySource(), helper.getByte("1"));
		 assertEquals(nonCashBenefits.getNonCashBenefitsID(),"ee_7_ncb");
		 assertEquals(nonCashBenefits.getOtherSource(), helper.getByte("0"));
		 assertEquals(nonCashBenefits.getOtherSourceIdentify(), "");
		 assertEquals(nonCashBenefits.getOtherTANF(), helper.getByte("0"));
		 assertEquals(nonCashBenefits.getProjectEntryID(), "ee_7");
		 assertEquals(nonCashBenefits.getRentalAssistanceOngoing(), helper.getByte("0"));
		 assertEquals(nonCashBenefits.getRentalAssistanceTemp(), helper.getByte("0"));
		 assertEquals(nonCashBenefits.getSNAP(), helper.getByte("0"));
		 assertEquals(nonCashBenefits.getTANFChildCare(),helper.getByte("0"));
		 assertEquals(nonCashBenefits.getTANFTransportation(), helper.getByte("0"));
		 assertEquals(nonCashBenefits.getUserID(), "p_0_user");
		 assertEquals(nonCashBenefits.getWIC(),helper.getByte("0"));
		 
		 List<PercentAMI> prcntAMI = sources.getSource().getExport().getPercentAMI();
		 assertNotNull(prcntAMI);
		 assertEquals(prcntAMI.size(), 4);
		 PercentAMI percentAMI = prcntAMI.get(0);
		 assertEquals(percentAMI.getPercentAMI(), helper.getByte("1"));
		 assertEquals(percentAMI.getPercentAMIID(), null);
		 assertEquals(percentAMI.getProjectEntryID(), "ee_7");
		 assertEquals(percentAMI.getUserID(), "p_0_user");
		 
		 List<Organization> org = sources.getSource().getExport().getOrganization();
		 assertNotNull(org);
         assertEquals(org.size(),1);
		 Organization organization = org.get(0);
		 assertEquals(organization.getOrganizationCommonName(), "");
		 assertEquals(organization.getOrganizationID(), 0);
		 assertEquals(organization.getOrganizationName(),"Bowman Systems, LLC");
		 assertEquals(organization.getUserID(),"p_0_user");
		 
		 List<Project> prjt = sources.getSource().getExport().getProject();
		 assertNotNull(prjt);
		 assertEquals(prjt.size(), 1);
		 Project project = prjt.get(0);
		 assertEquals(project.getContinuumProject(), 1);
		 assertEquals(project.getOrganizationID(), 0);
		 assertEquals(project.getProjectName(), "Bowman Systems, LLC");
		 assertEquals(project.getProjectType(), 7);
		 assertEquals(project.getProjectCommonName(), "");
		 assertEquals(project.getResidentialAffiliation(), 0);
		 assertEquals(project.getTargetPopulation(), 0);
		 assertEquals(project.getTrackingMethod(), 0);
		 assertEquals(project.getUserID(), "p_0_user");
			
		 List<ProjectCoC> prjtCoC = sources.getSource().getExport().getProjectCoC();
		 assertNotNull(prjtCoC);
		 assertEquals(prjtCoC.size(), 1);
		 ProjectCoC projectCoC = prjtCoC.get(0);
		 assertEquals(projectCoC.getCoCCode(), "la-123");
		 assertEquals(projectCoC.getProjectCoCID(), 0);
		 assertEquals(projectCoC.getProjectID(), "p_0");
		 assertEquals(projectCoC.getUserID(), "p_0_user");
			
		 List<Funder> fund = sources.getSource().getExport().getFunder();
		 assertNotNull(fund);
		 assertEquals(fund.size(), 1);
		 Funder funder = fund.get(0);
		 assertEquals(funder.getFunder(),34);
		 assertEquals(funder.getFunderID(),"p_0");
		 assertEquals(funder.getGrantID(), "p_0");
		 assertEquals(funder.getProjectID(), "p_0");
//		 assertEquals(funder.getStartDate(), helper.getXMLGregorianCalendar("2008-08-15"));
		 assertEquals(funder.getUserID(), "p_0_user");
			
		 List<Site> ste =sources.getSource().getExport().getSite();
		 assertNotNull(ste);
		 assertEquals(ste.size(), 1);
		 Site site = ste.get(0);
		 assertEquals(site.getAddress(), null);
		 assertEquals(site.getCity(), null);
		 assertEquals(site.getGeocode(), 0);
		 assertEquals(site.getPrincipalSite(), 1);
		 assertEquals(site.getSiteID(), 0);
		 assertEquals(site.getState(), null);
		 assertEquals(site.getUserID(),"p_0_user");
		 assertEquals(site.getZIP(), 0);
		
	}
}
