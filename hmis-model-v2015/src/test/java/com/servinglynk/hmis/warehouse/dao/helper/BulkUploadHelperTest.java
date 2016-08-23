package com.servinglynk.hmis.warehouse.dao.helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;

import com.servinglynk.hmis.warehouse.domain.Sources;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ClientVeteranInfo;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Contact;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.DateOfEngagement;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Disabilities;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.DomesticViolence;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Education;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Employment;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EnrollmentCoC;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EntryRHSP;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EntryRHY;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EntrySSVF;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Exit;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitHousingAssessment;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitPATH;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitRHY;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Funder;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HealthInsurance;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HealthStatus;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HousingAssessmentDisposition;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.IncomeAndSources;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.MedicalAssistance;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.NonCashBenefits;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Organization;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.PATHStatus;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Project;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.RHYBCPStatus;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ResidentialMoveInDate;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Services;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Site;
public class BulkUploadHelperTest {

	public BulkUploadHelper helper = new BulkUploadHelper();
	private Sources sources;
	
	@Before
	public void setUp() {
		
	}
	


	@Test
	public void testXMLUpload() throws JAXBException, IOException {
	//	URL path = BulkUploadHelperTest.class.getResource("2015.xml");
//		System.out.println(path);
		com.servinglynk.hmis.warehouse.model.base.BulkUpload upload = new com.servinglynk.hmis.warehouse.model.base.BulkUpload();
		//upload.setInputPath("C:\\HMIS\\hmis-lynk-open-source\\hmis-model\\src\\main\\test\\com\\servinglynk\\hmis\\warehouse\\dao\\HUD_4_0__6.xml");
		upload.setProjectGroupCode("PG0001");
		upload.setInputpath("C:\\Users\\sdolia\\Desktop\\HUDFile\\HUD_4_0_4012_63.xml");
		com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity projectGrp = new com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity();
		projectGrp.setSkipuseridentifers(true);
		sources = helper.getSourcesFromFiles(upload,projectGrp);
		assertNotNull(sources);
		
		List<Client> clients = sources.getSource().getExport().getClient();
		assertNotNull(clients);
		assertEquals(clients.size(), 1);
		
		Client client = clients.get(0);
		assertEquals(client.getPersonalID(), "A1a1");
		/*assertEquals(client.getFirstName(),"Indy");
		assertEquals(client.getLastName(), "Entonly");*/
		assertEquals(client.getNameDataQuality(), 9);
//		assertEquals(client.getSSN(), "111223333");
		assertEquals(client.getSSNDataQuality(), 2);
//		assertEquals(client.getDOB(),helper.getXMLGregorianCalendar("1968-01-05"));
		assertEquals(client.getDOBDataQuality(), 1);
		/*assertEquals(client.getDOB(), helper.getXMLGregorianCalendar("1981-01-01"));
		assertEquals(client.getDOBDataQuality(), helper.getByte("1"));*/
		assertEquals(client.getGender(),4);
        assertEquals(client.getEthnicity(), 0);
        assertEquals(client.getRace(), 8);
        assertEquals(client.getVeteranStatus(),9);
        
        List<Enrollment> enroll = sources.getSource().getExport().getEnrollment();
		assertNotNull(enroll);
		assertEquals(enroll.size(),2);
		
		Enrollment enrollment = enroll.get(0);
		assertEquals(enrollment.getProjectEntryID(), "w5641");
		assertEquals(enrollment.getPersonalID(), "A1a1");
		assertEquals(enrollment.getProjectID(), "222D");
//		assertEquals(enrollment.getEntryDate(),helper.getXMLGregorianCalendar("2014-01-31"));
		assertEquals(enrollment.getHouseholdID(), "a34563w");
		assertEquals(enrollment.getRelationshipToHoH(), helper.getByte("1"));
		assertEquals(enrollment.getResidencePrior(),helper.getByte("17"));
		assertEquals(enrollment.getResidencePriorLengthOfStay(),helper.getByte("8"));
		assertEquals(enrollment.getHousingStatus(),helper.getByte("6"));
        
		List<Disabilities> disabilities = sources.getSource().getExport().getDisabilities();
		assertNotNull(disabilities);
		assertEquals(disabilities.size(), 1);
		Disabilities disability = disabilities.get(0);
		assertEquals(disability.getProjectEntryID(),"w5641");
		assertEquals(disability.getDisabilityType(),8);
		assertEquals(disability.getDisabilityResponse(),2);
		assertEquals(disability.getIndefiniteAndImpairsIndependence(),9);
		assertEquals(disability.getDocumentationOnFile(),1);
		assertEquals(disability.getReceivingServices(),99);
		
		List<Employment> empEducation = sources.getSource().getExport().getEmployment();
		assertNotNull(empEducation);
		assertEquals(empEducation.size(),1);
		Employment employment = empEducation.get(0);
		assertEquals(employment.getEmployed(), 8);
		assertEquals(employment.getEmploymentID(),"344r445y");
		assertEquals(employment.getEmploymentType(),2);
		assertEquals(employment.getNotEmployedReason(), 3);
		assertEquals(employment.getProjectEntryID(),"w5641");
		assertEquals(employment.getUserID(), "sXKqL");
		empEducation.size();
		
		List<EnrollmentCoC> enrollCoc = sources.getSource().getExport().getEnrollmentCoC();
		assertNotNull(enrollCoc);
		assertEquals(enrollCoc.size(), 2);
		EnrollmentCoC enrollmentCoC = enrollCoc.get(0);
		assertEquals(enrollmentCoC.getEnrollmentCoCID(),56332);
		//assertEquals(enrollmentCoC.getClientCoC(),"BZ-123");
		assertEquals(enrollmentCoC.getProjectEntryID(), "w5641");
		assertEquals(enrollmentCoC.getUserID(), "DU5m");
		enrollCoc.size();
		
		 List<HealthInsurance> healthIns= sources.getSource().getExport().getHealthInsurance();
		 assertNotNull(healthIns);
		 assertEquals(healthIns.size(), 2);
		 HealthInsurance healthInsurance = healthIns.get(0);
		 assertEquals(healthInsurance.getEmployerProvided(), 1);
		 assertEquals(healthInsurance.getHealthInsuranceID(),"sw1ws2");
		 assertEquals(healthInsurance.getInsuranceFromAnySource(),8);
		 assertEquals(healthInsurance.getMedicaid(),0);
		 assertEquals(healthInsurance.getMedicare(), 0);
		 assertEquals(healthInsurance.getNoCOBRAReason(), 9);
		 assertEquals(healthInsurance.getNoEmployerProvidedReason(),9);
		 assertEquals(healthInsurance.getNoMedicaidReason(), 1);
		 assertEquals(healthInsurance.getNoMedicareReason(),4);
		 assertEquals(healthInsurance.getNoPrivatePayReason(), 8);
		 assertEquals(healthInsurance.getNoSCHIPReason(), 3);
		 assertEquals(healthInsurance.getNoStateHealthInsReason(), 4);
		 assertEquals(healthInsurance.getNoVAMedReason(), 99);
		 assertEquals(healthInsurance.getPrivatePay(), 1);
//		 assertEquals(healthInsurance.getProjectEntryID(), "w5641");
		 assertEquals(healthInsurance.getSCHIP(),1);
		 assertEquals(healthInsurance.getStateHealthIns(),0);
		 assertEquals(healthInsurance.getUserID(),"NdLgvXYr7g");
		 assertEquals(healthInsurance.getVAMedicalServices(),0);
		 /*
		  * Newly Newly Added Starts*/		 
		 //assertEquals(healthInsurance.getOtherSource(), 5);
		// assertEquals(healthInsurance.getOtherSourceIdentify(), "4");
		 /*
		  * Newly Newly Added Ends*/
		 List<DomesticViolence> domesticVio = sources.getSource().getExport().getDomesticViolence();
		 assertNotNull(domesticVio);
		 assertEquals(domesticVio.size(),1);
		 DomesticViolence domesticViolence = domesticVio.get(0);
		 assertEquals(domesticViolence.getDomesticViolenceID(),"87865g");
		 assertEquals(domesticViolence.getDomesticViolenceVictim(), helper.getByte("1"));
//		 assertEquals(domesticViolence.getInformationDate(),helper.getXMLGregorianCalendar("2014-03-16"));
		 assertEquals(domesticViolence.getProjectEntryID(),"w5641");
		 assertEquals(domesticViolence.getUserID(),"fPKfm5Rtfi0m3OhjeFL_pozaSRUUA");
		 assertEquals(domesticViolence.getWhenOccurred(), helper.getByte("2"));
		 
//		 List<Services> service = sources.getSource().getExport().getServices();
//		 assertNotNull(service);
//		 assertEquals(service.size(),1);
//		 Services services = service.get(0);
//		 assertEquals(services.getFAAmount(), 1145.5899658203125, 0.0002);
//		 assertEquals(services.getOtherTypeProvided(), "some other type here");
//		 assertEquals(services.getProjectEntryID(), "w5641");
//		 assertEquals(services.getRecordType(),java.lang.Byte.parseByte(helper.getByte("200"),5));
//		 assertEquals(services.getReferralOutcome(), helper.getByte(""));
//		 assertEquals(services.getServicesID(), "service_2");
//		 assertEquals(services.getSubTypeProvided(), helper.getByte(""));
//		 assertEquals(services.getTypeProvided(), helper.getByte("99"));
//		 assertEquals(services.getUserID(), "service_2_user");
//		
		 
		 /*
		  * Newly Added Starts
		  * */
		 List<Inventory> invent = sources.getSource().getExport().getInventory();
		 assertNotNull(invent);
		 assertEquals(invent.size(),1);
		 Inventory inventory = invent.get(0);
		 assertEquals(inventory.getAvailability(), 3);
//		 assertEquals(inventory.getBedInventory(), "4f2bd2");
		 assertEquals(inventory.getBedInventory().getBedInventory(), 130);
		 assertEquals(inventory.getBedInventory().getCHBedInventory(), 17);
		 assertEquals(inventory.getCoCCode(), "BZ-123");
		 assertEquals(inventory.getHMISParticipatingBeds(), 539390492);
		 assertEquals(inventory.getHouseholdType(), 1);
		 assertEquals(inventory.getInventoryID(), "56563a");
//		 assertEquals(inventory.getInventoryStartDate(), helper.getXMLGregorianCalendar("2014-10-31"));
//		 assertEquals(inventory.getInventoryEndDate(), helper.getXMLGregorianCalendar("2015-05-12"));
		 assertEquals(inventory.getUserID(), "billj");
		 assertEquals(inventory.getBedInventory().getVetBedInventory(), 14);
		 assertEquals(inventory.getBedInventory().getYouthAgeGroup(), 1);
		 assertEquals(inventory.getBedInventory().getYouthBedInventory(), 16);
		 assertEquals(inventory.getUnitInventory(), 1595973432);
		 
		 List<Exit> ext = sources.getSource().getExport().getExit();
		 assertNotNull(ext);
		 assertEquals(ext.size(), 2);
		 Exit exit = ext.get(0);
		 assertEquals(exit.getDestination(), 17);
		 assertEquals(exit.getExitID(), "C2x");
		 assertEquals(exit.getOtherDestination(), "Hotel Training Program");
		 assertEquals(exit.getUserID(), "GO");
		 
		 List<ExitPATH> extPath = sources.getSource().getExport().getExitPATH();
		 assertNotNull(extPath);
		 assertEquals(extPath.size(), 1);
		 ExitPATH exitPath = extPath.get(0);
		 assertEquals(exitPath.getConnectionWithSOAR(), 0);
		 assertEquals(exitPath.getExitID(), "C2x");
		 assertEquals(exitPath.getExitPATHID(), "676rt");
		 assertEquals(exitPath.getUserID(), "y9SC3Udh_t0aJCX");
		 
		 List<ExitHousingAssessment> extHousingAssessment = sources.getSource().getExport().getExitHousingAssessment();
		 assertNotNull(extHousingAssessment);
		 assertEquals(extHousingAssessment.size(), 1);
		 ExitHousingAssessment exitHousingAssessment = extHousingAssessment.get(0);
		 assertEquals(exitHousingAssessment.getExitHousingAssessmentID(), 326);
		 assertEquals(exitHousingAssessment.getExitID(), "C2x");
		 assertEquals(exitHousingAssessment.getHousingAssessment(), helper.getByte("6"));
		 assertEquals(exitHousingAssessment.getSubsidyInformation(), helper.getByte("2") );
		 assertEquals(exitHousingAssessment.getUserID(), "l_Xj");
		 
		 List<ExitRHY> extRHY = sources.getSource().getExport().getExitRHY();
		 assertNotNull(extRHY);
		 assertEquals(extRHY.size(), 1);
		 ExitRHY exitRHY = extRHY.get(0);
		 assertEquals(exitRHY.getAssistanceMainstreamBenefits(), helper.getByte("0"));
		 assertEquals(exitRHY.getEarlyExitReason(), helper.getByte("1"));
		 assertEquals(exitRHY.getExitCounseling(), helper.getByte("0"));
		 assertEquals(exitRHY.getExitID(), "C2x");
		 assertEquals(exitRHY.getExitRHYID(), "342r");
		 assertEquals(exitRHY.getFamilyReunificationAchieved(), helper.getByte("1"));
		 assertEquals(exitRHY.getFurtherFollowUpServices(), helper.getByte("1"));
		 assertEquals(exitRHY.getOtherAftercarePlanOrAction(), helper.getByte("0"));
		 assertEquals(exitRHY.getPermanentHousingPlacement(), helper.getByte("0"));
		 assertEquals(exitRHY.getProjectCompletionStatus(), helper.getByte("3"));
		 assertEquals(exitRHY.getResourcePackage(), helper.getByte("9"));
		 assertEquals(exitRHY.getScheduledFollowUpContacts(), helper.getByte("1"));
		 assertEquals(exitRHY.getTemporaryShelterPlacement(), helper.getByte("0"));
		 assertEquals(exitRHY.getUserID(), "Zu6Nb5-");
		 assertEquals(exitRHY.getWrittenAftercarePlan(), helper.getByte("9"));
		 
		 
		 List<ClientVeteranInfo> clntVeteranInfo = sources.getSource().getExport().getClientVeteranInfo();
		 assertNotNull(clntVeteranInfo);
		 assertEquals(clntVeteranInfo.size(), 1);
		 ClientVeteranInfo clientVeteranInfo = clntVeteranInfo.get(0);
		 assertEquals(clientVeteranInfo.getAfghanistanOEF(), helper.getByte("8"));
		 assertEquals(clientVeteranInfo.getClientVeteranInfoID(), "7878665s");
		 assertEquals(clientVeteranInfo.getDesertStorm(), helper.getByte("0"));
		 assertEquals(clientVeteranInfo.getDischargeStatus(), helper.getByte("6"));
		 assertEquals(clientVeteranInfo.getIraqOIF(), helper.getByte("9"));
		 assertEquals(clientVeteranInfo.getIraqOND(), helper.getByte("99"));
		 assertEquals(clientVeteranInfo.getKoreanWar(), helper.getByte("99"));
		 assertEquals(clientVeteranInfo.getMilitaryBranch(), helper.getByte("8"));
		 assertEquals(clientVeteranInfo.getOtherTheater(), helper.getByte("8"));
		 assertEquals(clientVeteranInfo.getPersonalID(), "A1a1");
		 assertEquals(clientVeteranInfo.getUserID(), "dZPlRM");
		 assertEquals(clientVeteranInfo.getVietnamWar(), helper.getByte("1"));
		 assertEquals(clientVeteranInfo.getWorldWarII(), helper.getByte("0"));
		 assertEquals(clientVeteranInfo.getYearEnteredService(), 2002);
		 assertEquals(clientVeteranInfo.getYearSeparated(), 2004);
		 
		 List<HousingAssessmentDisposition> housingAsmntDisposition = sources.getSource().getExport().getHousingAssessmentDisposition();
		 assertNotNull(housingAsmntDisposition);
		 assertEquals(housingAsmntDisposition.size(), 1);
		 HousingAssessmentDisposition housingAssessmentDisposition = housingAsmntDisposition.get(0);
		 assertEquals(housingAssessmentDisposition.getAssessmentDisposition(), helper.getByte("9"));
		 assertEquals(housingAssessmentDisposition.getExitID(), "C2x");
		 assertEquals(housingAssessmentDisposition.getHousingAssessmentDispositionID(), "456q");
		 assertEquals(housingAssessmentDisposition.getOtherDisposition(), "some other disposition text here");
		 assertEquals(housingAssessmentDisposition.getUserID(), "BtcDoTPF4UC-8ybtUm-woIM");
		 
		 List<MedicalAssistance> mclAssistance = sources.getSource().getExport().getMedicalAssistance();
		 assertNotNull(mclAssistance);
		 assertEquals(mclAssistance.size(), 1);
		 MedicalAssistance medicalAssistance = mclAssistance.get(0);
		 assertEquals(medicalAssistance.getADAP(), helper.getByte("9"));
		 assertEquals(medicalAssistance.getHIVAIDSAssistance(), helper.getByte("99"));
		 assertEquals(medicalAssistance.getMedicalAssistanceID(), "y7665");
		 assertEquals(medicalAssistance.getNoADAPReason(), helper.getByte("9"));
		 assertEquals(medicalAssistance.getNoHIVAIDSAssistanceReason(), helper.getByte("1"));
//		 assertEquals(medicalAssistance.getProjectEntryID(), "");
		 assertEquals(medicalAssistance.getUserID(), "ptravis");
		 
		 List<HealthStatus> hthStatus = sources.getSource().getExport().getHealthStatus();
		 assertNotNull(hthStatus);
		 assertEquals(hthStatus.size(), 1);
		 HealthStatus healthStatus = hthStatus.get(0);
		 assertEquals(healthStatus.getHealthCategory(), helper.getByte("27"));
		 assertEquals(healthStatus.getHealthStatus(), helper.getByte("4"));
		 assertEquals(healthStatus.getHealthStatusID(), "y676755");
//		 assertEquals(healthStatus.getProjectEntryID(), "");
		 assertEquals(healthStatus.getUserID(), "e79Gzul_HbyrI9JY");
		 
		 List<Contact> cnct = sources.getSource().getExport().getContact();
		 assertNotNull(cnct);
		 assertEquals(cnct.size(), 1);
		 Contact contact = cnct.get(0);
		 assertEquals(contact.getContactID(), "98yuywwyy776ww");
		 assertEquals(contact.getContactLocation(), helper.getByte("2"));
//		 assertEquals(contact.getProjectEntryID(), "");
		 assertEquals(contact.getUserID(), "IFmMP");
		 
		 List<EntryRHY> entyRHY = sources.getSource().getExport().getEntryRHY();
		 assertNotNull(entyRHY);
		 assertEquals(entyRHY.size(), 1);
		 EntryRHY entryRHY = entyRHY.get(0);
		 assertEquals(entryRHY.getAbuseAndNeglectFam(), helper.getByte("1"));
		 assertEquals(entryRHY.getAbuseAndNeglectYouth(), helper.getByte("0"));
		 assertEquals(entryRHY.getActiveMilitaryParent(), helper.getByte("1"));
		 assertEquals(entryRHY.getAlcoholDrugAbuseFam(), helper.getByte(""));
		 assertEquals(entryRHY.getAlcoholDrugAbuseYouth(), helper.getByte(""));
		 assertEquals(entryRHY.getAskedOrForcedToExchangeForSex(), helper.getByte("1"));
		 assertEquals(entryRHY.getAskedOrForcedToExchangeForSexPastThreeMonths(), helper.getByte("8"));
		 assertEquals(entryRHY.getChildWelfareMonths(), helper.getByte("42"));
		 assertEquals(entryRHY.getChildWelfareYears(), helper.getByte("2"));
		 assertEquals(entryRHY.getCoercedToContinueWork(), helper.getByte(""));
		 assertEquals(entryRHY.getCountOfExchangeForSex(), helper.getByte("3"));
		 assertEquals(entryRHY.getCountOutreachReferralApproaches(), helper.getByte("3"));
//		 assertEquals(entryRHY.getDataCollectionStage(), helper.getByte(""));
		 assertEquals(entryRHY.getEntryRHYID(), "y76754");
		 assertEquals(entryRHY.getExchangeForSex(), helper.getByte("1"));
		 assertEquals(entryRHY.getExchangeForSexPastThreeMonths(), helper.getByte("1"));
		 assertEquals(entryRHY.getFormerWardChildWelfare(), helper.getByte("1"));
		 assertEquals(entryRHY.getFormerWardJuvenileJustice(), helper.getByte("9"));
		 assertEquals(entryRHY.getHealthIssuesFam(), helper.getByte(""));
		 assertEquals(entryRHY.getHealthIssuesYouth(), helper.getByte("1"));
		 assertEquals(entryRHY.getHouseholdDynamics(), helper.getByte(""));
		 assertEquals(entryRHY.getHousingIssuesFam(), helper.getByte("1"));
		 assertEquals(entryRHY.getHousingIssuesYouth(), helper.getByte("1"));
		 assertEquals(entryRHY.getIncarceratedParent(), helper.getByte("1"));
		 assertEquals(entryRHY.getIncarceratedParentStatus(), helper.getByte("1"));
		 assertEquals(entryRHY.getInsufficientIncome(), helper.getByte(""));
		 assertEquals(entryRHY.getJuvenileJusticeMonths(), helper.getByte("2"));
		 assertEquals(entryRHY.getJuvenileJusticeYears(), helper.getByte("3"));
		 assertEquals(entryRHY.getLaborExploitPastThreeMonths(), helper.getByte("8"));
		 assertEquals(entryRHY.getMentalDisabilityFam(), helper.getByte(""));
		 assertEquals(entryRHY.getMentalDisabilityYouth(), helper.getByte("1"));
		 assertEquals(entryRHY.getMentalHealthIssuesFam(), helper.getByte(""));
		 assertEquals(entryRHY.getMentalHealthIssuesYouth(), helper.getByte(""));
		 assertEquals(entryRHY.getPhysicalDisabilityFam(), helper.getByte(""));
		 assertEquals(entryRHY.getPhysicalDisabilityYouth(), helper.getByte(""));
//		 assertEquals(entryRHY.getProjectEntryID(), helper.getByte(""));
		 assertEquals(entryRHY.getReferralSource(), helper.getByte("18"));
		 assertEquals(entryRHY.getSchoolEducationalIssuesFam(), helper.getByte(""));
		 assertEquals(entryRHY.getSchoolEducationalIssuesYouth(), helper.getByte(""));
		 assertEquals(entryRHY.getSexualOrientation(), helper.getByte("99"));
		 assertEquals(entryRHY.getSexualOrientationGenderIdentityYouth(), helper.getByte("1"));
		 assertEquals(entryRHY.getSexualOrientationGenderIDFam(), helper.getByte(""));
		 assertEquals(entryRHY.getUnemploymentFam(), helper.getByte(""));
		 assertEquals(entryRHY.getUnemploymentYouth(), helper.getByte("1"));
		 assertEquals(entryRHY.getUserID(), "DG4IfIQuAFF6I.yl7");
		 assertEquals(entryRHY.getWorkplacePromiseDifference(), helper.getByte("1"));
		 assertEquals(entryRHY.getWorkPlaceViolenceThreats(), helper.getByte(""));
		 
		 List<EntrySSVF> entySSVF = sources.getSource().getExport().getEntrySSVF();
		 assertNotNull(entySSVF);
		 assertEquals(entySSVF.size(), 1);
		 EntrySSVF entrySSVF = entySSVF.get(0);
		 assertEquals(entrySSVF.getAddressDataQuality(), helper.getByte("2"));
		 assertEquals(entrySSVF.getEntrySSVFID(), "787ughj55");
		 assertEquals(entrySSVF.getHPScreeningScore(), helper.getByte("12"));
		 assertEquals(entrySSVF.getLastPermanentCity(), "Yreka");
		 assertEquals(entrySSVF.getLastPermanentState(), "AR");
		 assertEquals(entrySSVF.getLastPermanentStreet(), "13th Ave W");
		 assertEquals(entrySSVF.getLastPermanentZIP(), 57601);
		 assertEquals(entrySSVF.getPercentAMI(), helper.getByte("1"));
		 assertEquals(entrySSVF.getUserID(), Short.valueOf("7653"));
		 assertEquals(entrySSVF.getVAMCStation(), "76762T78");
		 
		 List<RHYBCPStatus> RHYBCPSts = sources.getSource().getExport().getRHYBCPStatus();
		 assertNotNull(RHYBCPSts);
		 assertEquals(RHYBCPSts.size(), 1);
		 RHYBCPStatus rhybcpStatus = RHYBCPSts.get(0);
		 assertEquals(rhybcpStatus.getFYSBYouth(), helper.getByte("0"));
		 assertEquals(rhybcpStatus.getReasonNoServices(),helper.getByte("3"));
		 assertEquals(rhybcpStatus.getRHYBCPStatusID(), "erffedyte1");
		 assertEquals(rhybcpStatus.getUserID(), "ryu");
//		 assertEquals(rhybcpStatus.getStatusDate(), helper.getXMLGregorianCalendar("2014-09-20"));
		 
		 
		 List<PATHStatus> PATHSts = sources.getSource().getExport().getPATHStatus();
		 assertNotNull(PATHSts);
		 assertEquals(PATHSts.size(), 1);
		 PATHStatus pathStatus = PATHSts.get(0);
		 assertEquals(pathStatus.getClientEnrolledInPATH(), helper.getByte("0"));
		 assertEquals(pathStatus.getPathStatusID(), 453332);
//		 assertEquals(pathStatus.getProjectEntryID(), "w5641");
		 assertEquals(pathStatus.getReasonNotEnrolled(), helper.getByte("2"));
		 assertEquals(pathStatus.getUserID(), "bmerriweather");
		 
		 List<Services> services = sources.getSource().getExport().getServices();
		 assertNotNull(services);
		 assertEquals(services.size(), 1);
		 Services service = services.get(0);
//		 assertEquals(serviceFAReferral.getFaAmount(), Float.parseFloat("1145.59"));
		 assertEquals(service.getFAAmount(),   1145.59, 0.0002);
		// assertEquals(serviceFAReferral.getFunderList(), 2);
		 assertEquals(service.getOtherTypeProvided(), "some other type here");
		 assertEquals(service.getProjectEntryID(), "w5641");
		 assertEquals(service.getReferralOutcome(), helper.getByte("2"));
	//	 assertEquals(serviceFAReferral.getServiceCategory(), 20);
	//	 assertEquals(serviceFAReferral.getServiceFaReferralID(), "44gg");
		 assertEquals(service.getSubTypeProvided(), helper.getByte("12"));
		 assertEquals(service.getTypeProvided(), 200);
		// assertEquals(serviceFAReferral.getUserID(), "CoaTbskfRfTvBSHN8_eRmMF4.4O-A");
		 
		 List<ResidentialMoveInDate> residentMoveInDate = sources.getSource().getExport().getResidentialMoveInDate();
		 assertNotNull(residentMoveInDate);
		 assertEquals(residentMoveInDate.size(), 1);
		 ResidentialMoveInDate residentialMoveInDate = residentMoveInDate.get(0);
		 assertEquals(residentialMoveInDate.getInPermanentHousing(),helper.getByte("1"));
//		 assertEquals(residentialMoveInDate.getProjectEntryID(),"");
//		 assertEquals(residentialMoveInDate.getResidentialMoveInDate(),helper.getXMLGregorianCalendar("2016-05-19Z"));
		 assertEquals(residentialMoveInDate.getResidentialMoveInDateID(),"z44332");
		 assertEquals(residentialMoveInDate.getUserID(),"AUfZ2");
		 
		 List<DateOfEngagement> dateOfEngmnt = sources.getSource().getExport().getDateOfEngagement();
		 assertNotNull(dateOfEngmnt);
		 assertEquals(dateOfEngmnt.size(), 1);
		 DateOfEngagement dateOfEngagement = dateOfEngmnt.get(0);
		 assertEquals(dateOfEngagement.getDateOfEngagementID(),"4321s");
		 assertEquals(dateOfEngagement.getProjectEntryID(),"w5641");
		 assertEquals(dateOfEngagement.getUserID(),"IFmMP");
		 
//		 List<EntryRHSP> etyRHSP = sources.getSource().getExport().getEntryRHSP();
//		 assertNotNull(etyRHSP);
//		 assertEquals(etyRHSP.size(), 1);
//		 EntryRHSP entryRHSP = etyRHSP.get(0);
//		 assertEquals(entryRHSP.getEntryRHSPID(),"785ughj55");
//		 assertEquals(entryRHSP.getUserID(),"76553");
//		 assertEquals(entryRHSP.getWorstHousingSituation(),"1");
//		 
		 List<Education> edutn = sources.getSource().getExport().getEducation();
		 assertNotNull(edutn);
		 assertEquals(edutn.size(), 1);
		 Education education = edutn.get(0);
		 assertEquals(education.getEducationID(),"56t54");
//		 assertEquals(education.getInformationDate(),"");
		 assertEquals(education.getLastGradeCompleted(),helper.getByte("3"));
		 assertEquals(education.getProjectEntryID(),"w5641");
		 assertEquals(education.getSchoolStatus(),helper.getByte("8"));
		 assertEquals(education.getUserID(),"user7");
		 
		 /*
		  * Newly Added Ends
		  * */
		 
		 List<IncomeAndSources> incomeSource = sources.getSource().getExport().getIncomeAndSources();
		 assertNotNull(incomeSource);
		 assertEquals(incomeSource.size(), 1);
		 IncomeAndSources incomeAndSources = incomeSource.get(0);
		 assertEquals(incomeAndSources.getAlimony(), 1);
		 assertEquals(incomeAndSources.getAlimonyAmount(), 1121.760009765625, 0.0002);
		 assertEquals(incomeAndSources.getChildSupport(), 1);
		 assertEquals(incomeAndSources.getChildSupportAmount(), 562.4000244140625, 0.0002);
		 assertEquals(incomeAndSources.getEarned(),1);
		 assertEquals(incomeAndSources.getEarnedAmount(),13916.099609375, 0.0002);
		 assertEquals(incomeAndSources.getGA(), 1);
		 assertEquals(incomeAndSources.getGAAmount(),15254.5498046875, 0.0002);
		 assertEquals(incomeAndSources.getIncomeAndSourcesID(), "32dd");
		 assertEquals(incomeAndSources.getIncomeFromAnySource(), 1);
		 assertEquals(incomeAndSources.getOtherSource(), 1);
		// assertEquals(incomeAndSources.getOtherAmount(),1556.47000122070312,0.0002);
		 assertEquals(incomeAndSources.getOtherSourceIdentify(), "some other source here");
		 assertEquals(incomeAndSources.getPension(), 1);
		 assertEquals(incomeAndSources.getPensionAmount(),7865.31982421875, 0.0002);
		 assertEquals(incomeAndSources.getPrivateDisability(), 0);
		 assertEquals(incomeAndSources.getPrivateDisabilityAmount(), 11484.76953125, 0.0002);
		 assertEquals(incomeAndSources.getProjectEntryID(),"w5641");
		 assertEquals(incomeAndSources.getSocSecRetirement(),1);
		 assertEquals(incomeAndSources.getSocSecRetirementAmount(),4784.72021484375, 0.0002);
		 assertEquals(incomeAndSources.getSSDI(), 0);
		 assertEquals(incomeAndSources.getSSDIAmount(),41016.91015625, 0.0002);
		 assertEquals(incomeAndSources.getSSI(),1);
		 assertEquals(incomeAndSources.getSSIAmount(),2885.090087890625, 0.0002);
		 assertEquals(incomeAndSources.getTANF(),0);
		 assertEquals(incomeAndSources.getTANFAmount(),9.63412864E8, 0.0002);
		 assertEquals(incomeAndSources.getTotalMonthlyIncome(),1889.219970703125, 0.0002);
		 assertEquals(incomeAndSources.getUnemployment(), 0);
		 assertEquals(incomeAndSources.getUnemploymentAmount(),315.8699951171875, 0.0002);
		 assertEquals(incomeAndSources.getUserID(),"DN2J6hP2SNfgBs30u8dgkh8cVjY4jApG");
		 assertEquals(incomeAndSources.getVADisabilityNonService(), 0);
		 assertEquals(incomeAndSources.getVADisabilityNonServiceAmount(), 6847.91015625, 0.0002);
		 assertEquals(incomeAndSources.getVADisabilityService(), 1);
		 assertEquals(incomeAndSources.getVADisabilityServiceAmount(), 5642.47998046875, 0.0002);
		 assertEquals(incomeAndSources.getWorkersComp(), 1);
		 assertEquals(incomeAndSources.getWorkersCompAmount(), 8951855.0, 0.0002);
		 
		 List<NonCashBenefits> ncBenefits = sources.getSource().getExport().getNonCashBenefits();
		 assertNotNull(ncBenefits);
		 assertEquals(ncBenefits.size(),1);
		 NonCashBenefits nonCashBenefits = ncBenefits.get(0);
		 assertEquals(nonCashBenefits.getBenefitsFromAnySource(), helper.getByte("1"));
		 assertEquals(nonCashBenefits.getNonCashBenefitsID(),"766ww");
		 assertEquals(nonCashBenefits.getOtherSource(), helper.getByte("0"));
		 assertEquals(nonCashBenefits.getOtherSourceIdentify(), "some other source name");
		 assertEquals(nonCashBenefits.getOtherTANF(), helper.getByte("0"));
		 assertEquals(nonCashBenefits.getProjectEntryID(), "w5641");
		 assertEquals(nonCashBenefits.getRentalAssistanceOngoing(), helper.getByte("1"));
		 assertEquals(nonCashBenefits.getRentalAssistanceTemp(), helper.getByte("1"));
		 assertEquals(nonCashBenefits.getSNAP(), helper.getByte("0"));
		 assertEquals(nonCashBenefits.getTANFChildCare(),helper.getByte("0"));
		 assertEquals(nonCashBenefits.getTANFTransportation(), helper.getByte("0"));
		 assertEquals(nonCashBenefits.getUserID(), "ptravis");
		 assertEquals(nonCashBenefits.getWIC(),helper.getByte("0"));
		 
		 List<Organization> org = sources.getSource().getExport().getOrganization();
		 assertNotNull(org);
         assertEquals(org.size(),1);
		 Organization organization = org.get(0);
		 assertEquals(organization.getOrganizationCommonName(), "Helping");
		 assertEquals(organization.getOrganizationID(), 34);
		 assertEquals(organization.getOrganizationName(),"Helping People, Inc.");
		 assertEquals(organization.getUserID(),"ptravis");
		 
		 List<Project> prjt = sources.getSource().getExport().getProject();
		 assertNotNull(prjt);
		 assertEquals(prjt.size(), 2);
		 Project project = prjt.get(0);
		 assertEquals(project.getContinuumProject(), 0);
		 assertEquals(project.getOrganizationID(), 34);
		 assertEquals(project.getProjectName(), "Residence Enablers");
		 assertEquals(project.getProjectType(), 9);
		 assertEquals(project.getProjectCommonName(), "Residence Enablers");
//		 assertEquals(project.getResidentialAffiliation(), 0); //-- field Not required as per the image file. --
		 assertEquals(project.getTargetPopulation(), 4);
		 assertEquals(project.getTrackingMethod(), 0);
		 assertEquals(project.getUserID(), "j2ZsRLAPv");
			
		 List<Funder> fund = sources.getSource().getExport().getFunder();
		 assertNotNull(fund);
		 assertEquals(fund.size(), 2);
		 Funder funder = fund.get(0);
		 assertEquals(funder.getFunder(),16);
		 assertEquals(funder.getFunderID(),"76g");
		 assertEquals(funder.getGrantID(), "S_w9P0npP");
		 assertEquals(funder.getProjectID(), "222D");
//		 assertEquals(funder.getStartDate(), helper.getXMLGregorianCalendar("2008-08-15"));
		 assertEquals(funder.getUserID(), "m2Pym5-77tSVuI-IjerY");
			
		 List<Site> ste =sources.getSource().getExport().getSite();
		 assertNotNull(ste);
		 assertEquals(ste.size(), 1);
		 Site site = ste.get(0);
		 assertEquals(site.getAddress(), "111 Pine St.");
		 assertEquals(site.getCity(), "Tuscaloosa");
		 assertEquals(site.getGeocode(), 177988);
		 assertEquals(site.getPrincipalSite(), 1);
		 assertEquals(site.getSiteID(), 4526);
		 assertEquals(site.getState(), "OK");
		 assertEquals(site.getUserID(),"ck");
		 assertEquals(site.getZIP(), 84683);
		
	}
}
