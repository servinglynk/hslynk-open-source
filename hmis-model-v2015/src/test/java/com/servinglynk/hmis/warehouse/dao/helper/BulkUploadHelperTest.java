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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Services;
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
		upload.setInputPath(path.getPath());
		com.servinglynk.hmis.warehouse.model.v2015.ProjectGroupEntity projectGrp = new com.servinglynk.hmis.warehouse.model.v2015.ProjectGroupEntity();
		projectGrp.setSkipuseridentifers(true);
		sources = helper.getSourcesFromFiles(upload,projectGrp);
		assertNotNull(sources);
		
		List<Client> clients = sources.getSource().getExport().getClient();
		assertNotNull(clients);
		assertEquals(clients.size(), 1);
		
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
		assertEquals(disability.getIndefiniteAndImpairsIndependence(),99);
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
		assertEquals(enrollmentCoC.getCoCCode(),0);
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
