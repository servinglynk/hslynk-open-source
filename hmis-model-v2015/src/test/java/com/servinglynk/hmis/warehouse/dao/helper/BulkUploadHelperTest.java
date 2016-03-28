package com.servinglynk.hmis.warehouse.dao.helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.servinglynk.hmis.warehouse.domain.Sources;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Disabilities;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.DomesticViolence;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Employment;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EnrollmentCoC;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Funder;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HealthInsurance;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.IncomeAndSources;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.NonCashBenefits;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Organization;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Project;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Site;
public class BulkUploadHelperTest {

	public BulkUploadHelper helper = new BulkUploadHelper();
	private Sources sources;
	
	@Before
	public void setUp() {
		
	}
	


	@Test
	public void testXMLUpload() {
		URL path = BulkUploadHelperTest.class.getResource("2015.xml");
//		System.out.println(path);
		com.servinglynk.hmis.warehouse.model.v2015.BulkUpload upload = new com.servinglynk.hmis.warehouse.model.v2015.BulkUpload();
		//upload.setInputPath("C:\\HMIS\\hmis-lynk-open-source\\hmis-model\\src\\main\\test\\com\\servinglynk\\hmis\\warehouse\\dao\\HUD_4_0__6.xml");
		upload.setProjectGroupCode("PG0001");
		upload.setInputpath(path.getPath());
		com.servinglynk.hmis.warehouse.model.v2015.ProjectGroupEntity projectGrp = new com.servinglynk.hmis.warehouse.model.v2015.ProjectGroupEntity();
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
		assertEquals(enrollmentCoC.getClientCoC(),"BZ-123");
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
		 assertEquals(healthInsurance.getProjectEntryID(), "w5641");
		 assertEquals(healthInsurance.getSCHIP(),1);
		 assertEquals(healthInsurance.getStateHealthIns(),0);
		 assertEquals(healthInsurance.getUserID(),"NdLgvXYr7g");
		 assertEquals(healthInsurance.getVAMedicalServices(),0);
		 
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
		 
		 /*List<Services> service = sources.getSource().getExport().getServices();
		 assertNotNull(service);
		 assertEquals(service.size(),1);
		 Services services = service.get(0);
		 assertEquals(services.getFAAmount(), 1145.5899658203125, 0.0002);
		 assertEquals(services.getOtherTypeProvided(), "some other type here");
		 assertEquals(services.getProjectEntryID(), "w5641");
		 assertEquals(services.getRecordType(),java.lang.Byte.parseByte(helper.getByte("200"),5));
		 assertEquals(services.getReferralOutcome(), helper.getByte(""));
		 assertEquals(services.getServicesID(), "service_2");
		 assertEquals(services.getSubTypeProvided(), helper.getByte(""));
		 assertEquals(services.getTypeProvided(), helper.getByte("99"));
		 assertEquals(services.getUserID(), "service_2_user");
		*/
		 
		 
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
		 assertEquals(incomeAndSources.getOtherAmount(),156.47000122070312,0.0002);
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
		 assertEquals(project.getResidentialAffiliation(), 0);
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
