package com.servinglynk.hmis.warehouse.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.config.DatabaseConfig;
import com.servinglynk.hmis.warehouse.domain.Sources;
import com.servinglynk.hmis.warehouse.domain.Sources.Source;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.ClientDobDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientEthnicityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientGenderEnum;
import com.servinglynk.hmis.warehouse.enums.ClientNameDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientRaceEnum;
import com.servinglynk.hmis.warehouse.enums.ClientSsnDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientVeteranStatusEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesDisabilitytypeEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesDocumentationonfileEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathhowconfirmedEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathsmiinformationEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesReceivingservicesEnum;
import com.servinglynk.hmis.warehouse.enums.DomesticviolenceDomesticviolencevictimEnum;
import com.servinglynk.hmis.warehouse.enums.DomesticviolenceWhenoccurredEnum;
import com.servinglynk.hmis.warehouse.enums.EmploymentEmployedEnum;
import com.servinglynk.hmis.warehouse.enums.EmploymentEmploymentTypeEnum;
import com.servinglynk.hmis.warehouse.enums.EmploymentNotEmployedReasonEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentDisablingconditionEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentHousingstatusEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentMonthshomelesspastthreeyearsEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentResidencepriorlengthofstayEnum;
import com.servinglynk.hmis.warehouse.enums.ExithousingassessmentHousingassessmentEnum;
import com.servinglynk.hmis.warehouse.enums.ExithousingassessmentSubsidyinformationEnum;
import com.servinglynk.hmis.warehouse.enums.FunderFunderEnum;
import com.servinglynk.hmis.warehouse.enums.HealthStatusHealthCategoryEnum;
import com.servinglynk.hmis.warehouse.enums.HealthStatusHealthStatusEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceInsurancefromanysourceEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceMedicaidEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceMedicareEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNocobrareasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNoemployerprovidedreasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNomedicaidreasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNomedicarereasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNoprivatepayreasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNoschipreasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNostatehealthinsreasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNovamedreasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsurancePrivatepayEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceSchipEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceStatehealthinsEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceVamedicalservicesEnum;
import com.servinglynk.hmis.warehouse.enums.HousingassessmentdispositionAssessmentdispositionEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesAlimonyEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesChildsupportEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesEarnedEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesGaEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesIncomefromanysourceEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesOthersourceEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesPensionEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesPrivatedisabilityEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesSocsecretirementEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesSsdiEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesSsiEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesTanfEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesUnemploymentEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesVadisabilitynonserviceEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesVadisabilityserviceEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesWorkerscompEnum;
import com.servinglynk.hmis.warehouse.enums.InventoryAvailabiltyEnum;
import com.servinglynk.hmis.warehouse.enums.InventoryBedtypeEnum;
import com.servinglynk.hmis.warehouse.enums.InventoryHouseholdtypeEnum;
import com.servinglynk.hmis.warehouse.enums.LastgradecompletedLastgradecompletedEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceAdapEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceHivaidsassistanceEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceNoadapreasonEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceNohivaidsassistancereasonEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsBenefitsfromanysourceEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsOthersourceEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsOthertanfEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsRentalassistanceongoingEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsRentalassistancetempEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsSnapEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsTanfchildcareEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsTanftransportationEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsWicEnum;
import com.servinglynk.hmis.warehouse.enums.PathstatusReasonnotenrolledEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectContinuumprojectEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectProjecttypeEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTargetpopulationEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTrackingmethodEnum;
import com.servinglynk.hmis.warehouse.enums.ResidentialmoveindateInpermanenthousingEnum;
import com.servinglynk.hmis.warehouse.enums.RhybcpStatusFysbYouthEnum;
import com.servinglynk.hmis.warehouse.enums.RhybcpStatusReasonNoServicesEnum;
import com.servinglynk.hmis.warehouse.enums.SchoolStatusEnum;
import com.servinglynk.hmis.warehouse.enums.SitePrincipalSiteEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoAfghanistanOefEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoDesertStormEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoDischargeStatusEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoIraqOifEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoIraqOndEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoKoreanWarEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoMilitaryBranchEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoOtherTheaterEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoVietnamWarEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoWorldWar2Enum;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.model.stagv2015.Client;
import com.servinglynk.hmis.warehouse.model.stagv2015.ClientVeteranInfo;
import com.servinglynk.hmis.warehouse.model.stagv2015.Coc;
import com.servinglynk.hmis.warehouse.model.stagv2015.Contact;
import com.servinglynk.hmis.warehouse.model.stagv2015.Dateofengagement;
import com.servinglynk.hmis.warehouse.model.stagv2015.Disabilities;
import com.servinglynk.hmis.warehouse.model.stagv2015.Domesticviolence;
import com.servinglynk.hmis.warehouse.model.stagv2015.Education;
import com.servinglynk.hmis.warehouse.model.stagv2015.Employment;
import com.servinglynk.hmis.warehouse.model.stagv2015.Enrollment;
import com.servinglynk.hmis.warehouse.model.stagv2015.EnrollmentCoc;
import com.servinglynk.hmis.warehouse.model.stagv2015.Entryrhy;
import com.servinglynk.hmis.warehouse.model.stagv2015.Entryssvf;
import com.servinglynk.hmis.warehouse.model.stagv2015.Exit;
import com.servinglynk.hmis.warehouse.model.stagv2015.Exithousingassessment;
import com.servinglynk.hmis.warehouse.model.stagv2015.Exitpath;
import com.servinglynk.hmis.warehouse.model.stagv2015.Exitrhy;
import com.servinglynk.hmis.warehouse.model.stagv2015.Funder;
import com.servinglynk.hmis.warehouse.model.stagv2015.HealthStatus;
import com.servinglynk.hmis.warehouse.model.stagv2015.Healthinsurance;
import com.servinglynk.hmis.warehouse.model.stagv2015.Housingassessmentdisposition;
import com.servinglynk.hmis.warehouse.model.stagv2015.Incomeandsources;
import com.servinglynk.hmis.warehouse.model.stagv2015.Inventory;
import com.servinglynk.hmis.warehouse.model.stagv2015.Medicalassistance;
import com.servinglynk.hmis.warehouse.model.stagv2015.Noncashbenefits;
import com.servinglynk.hmis.warehouse.model.stagv2015.Organization;
import com.servinglynk.hmis.warehouse.model.stagv2015.Pathstatus;
import com.servinglynk.hmis.warehouse.model.stagv2015.Project;
import com.servinglynk.hmis.warehouse.model.stagv2015.Residentialmoveindate;
import com.servinglynk.hmis.warehouse.model.stagv2015.RhybcpStatus;
import com.servinglynk.hmis.warehouse.model.stagv2015.ServiceFaReferral;
import com.servinglynk.hmis.warehouse.model.stagv2015.Site;
import com.servinglynk.hmis.warehouse.model.v2015.BulkUpload;
import com.servinglynk.hmis.warehouse.model.v2015.Export;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class,loader = AnnotationConfigContextLoader.class)
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager") 
public class BulkUploaderTest {
	
	@Autowired
	BulkUploaderDao dao;
	
	@Autowired
	ExportDao exportDao;
	
	@Autowired
	ParentDaoFactory factory;
	
	@Test 
	public void test() throws JAXBException
	{
		SyncDomain domain = new SyncDomain();
//		factory.getEnrollmentDao().hydrateHBASE(domain);
		BulkUpload upload = new BulkUpload();
		URL path = BulkUploaderTest.class.getResource("New_HUD_Boman.xml");
		upload.setInputpath(path.getFile());
		ProjectGroupEntity projectGrpEntity = new ProjectGroupEntity();
		BulkUpload  uploadResult =   dao.performBulkUpload(upload,projectGrpEntity);
		File file = new File(
				path.getFile());
		JAXBContext jaxbContext = JAXBContext.newInstance(Sources.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Sources sources = (Sources) jaxbUnmarshaller.unmarshal(file);
		Source source = sources.getSource();
		Export export = uploadResult.getExport();
		com.servinglynk.hmis.warehouse.model.stagv2015.Export stagingExport = (com.servinglynk.hmis.warehouse.model.stagv2015.Export)factory.getExportDao().get(com.servinglynk.hmis.warehouse.model.stagv2015.Export.class, export.getId());
		Set<Enrollment> enrollments = stagingExport.getEnrollments();
	}
	@Test
	@Transactional
	public void testOldFile()
	{
		BulkUpload upload = new BulkUpload();
	//	URL path = BulkUploaderTest.class.getResource("HUD_4_0__6.xml");
//		path.setURLStreamHandlerFactory(fac);
		//upload.setInputPath(path.getFile());
		upload.setInputpath("C:/HMIS/hmis-lynk-open-source/hmis-model/src/main/test/com/servinglynk/hmis/warehouse/dao/HUD_4_0__6.xml");
		upload.setProjectGroupCode("PG0001");
		upload.setStatus("INITIAL");
	//	HmisUser hmisUser = (HmisUser)factory.getHmisUserDao().findByUsername("superadmin@hmis.com");
	//	upload.setUser(hmisUser);
		factory.getBulkUploaderWorkerDao().insert(upload);
		//dao.performBulkUpload(upload);
	}
	/*@Test
	public void testCSVZip() throws Exception
	{
				URL path = BulkUploaderTest.class.getResource("2015.xml");
				BulkUpload bullkUpload = new BulkUpload();
				bullkUpload.setInputpath(path.getPath());
				bullkUpload.setId(3L);
				ProjectGroupEntity projectGrpEntity = new ProjectGroupEntity();
				BulkUpload upload = factory.getBulkUploaderDao().performBulkUpload(bullkUpload,projectGrpEntity);
			//	com.servinglynk.hmis.warehouse.model.stagv2015.Export exportEntity = exportDao.getExportById(upload.getExport().getId());
				//(com.servinglynk.hmis.warehouse.model.stagv2015.Export) factory.getExportDao().get(com.servinglynk.hmis.warehouse.model.stagv2015.Export.class, upload.getExport().getId());
			//	assertNotNull(exportEntity);
//				assertEquals("",exportEntity.getExportperiodtype());
	}
*/	
	
	
	@Test
	public void testPersistIntoStaging() throws Exception
	{
				URL path = BulkUploaderTest.class.getResource("2015.xml");
				BulkUpload bullkUpload = new BulkUpload();
				bullkUpload.setInputpath(path.getPath());
				bullkUpload.setId(3L);
				ProjectGroupEntity projectGrpEntity = new ProjectGroupEntity();
				BulkUpload upload = factory.getBulkUploaderDao().performBulkUpload(bullkUpload,projectGrpEntity);
	}
		@Test
		@Transactional
		public void testCSVZip() throws Exception
		{
					URL path = BulkUploaderTest.class.getResource("2015.xml");
					System.out.println("Path -- >>> "+path);
					BulkUpload bullkUpload = new BulkUpload();
					bullkUpload.setInputpath(path.getPath());
					bullkUpload.setId(3L);
					ProjectGroupEntity projectGrpEntity = new ProjectGroupEntity();
					BulkUpload upload = factory.getBulkUploaderDao().performBulkUpload(bullkUpload,projectGrpEntity);
					//com.servinglynk.hmis.warehouse.model.stagv2015.Export exportEntity = exportDao.getExportById(upload.getExport().getId());
					com.servinglynk.hmis.warehouse.model.stagv2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2015.Export) factory.getExportDao().get(com.servinglynk.hmis.warehouse.model.stagv2015.Export.class, upload.getExport().getId());
					assertNotNull(exportEntity);
					assertEquals("effective",exportEntity.getExportperiodtype());
					
					assertEquals(0,exportEntity.getAffiliations().size());
					/*Set<Affiliation> affiliations = exportEntity.getAffiliations();
					List<Affiliation> lstAffiliations = new ArrayList<Affiliation>(affiliations);
					Affiliation affiliation = lstAffiliations.get(0);
					assertEquals("", affiliation.getResprojectid());*/
					
//					assertEquals(0, exportEntity.getBedinventories().size());
					
					assertEquals(1, exportEntity.getClientVeteranInfoes().size());
					Set<ClientVeteranInfo> clientVeteranInfos = exportEntity.getClientVeteranInfoes();
					List<ClientVeteranInfo> lstClientVeteranInfo = new ArrayList<ClientVeteranInfo>(clientVeteranInfos);
					ClientVeteranInfo clientVeteranInfo = lstClientVeteranInfo.get(0);
					assertEquals(VeteranInfoAfghanistanOefEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("8"))), clientVeteranInfo.getAfghanistanOef());
					assertEquals(VeteranInfoDesertStormEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("0"))), clientVeteranInfo.getDesertStorm());
					assertEquals(VeteranInfoDischargeStatusEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("6"))), clientVeteranInfo.getDischargeStatus());
					assertEquals(VeteranInfoIraqOifEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("9"))), clientVeteranInfo.getIraqOif());
					assertEquals(VeteranInfoIraqOndEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("99"))), clientVeteranInfo.getIraqOnd());
					assertEquals(VeteranInfoKoreanWarEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), clientVeteranInfo.getKoreanWar());
					assertEquals(VeteranInfoMilitaryBranchEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("8"))), clientVeteranInfo.getMilitaryBranch());
					assertEquals(VeteranInfoOtherTheaterEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("8"))), clientVeteranInfo.getOtherTheater());
					assertEquals(VeteranInfoVietnamWarEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), clientVeteranInfo.getVietnamWar());
					assertEquals(VeteranInfoWorldWar2Enum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("0"))), clientVeteranInfo.getWorldWar2());
					assertEquals(new Integer("2002"), clientVeteranInfo.getYearEntrdService());
					assertEquals(new Integer("2004"), clientVeteranInfo.getYearSeperated());
					
					assertEquals(1,exportEntity.getClients().size());
					Set<Client> clients = exportEntity.getClients();
					for(Client client : clients) {
						assertEquals("123456789012345678901234567890ABCDEF12d4",client.getFirstName());
						assertEquals(ClientGenderEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("4"))),client.getGender());
						assertEquals("Barnaby", client.getMiddleName());
						assertEquals("Jones", client.getLastName());
						assertEquals("Sr.", client.getNameSuffix());
						assertEquals(ClientNameDataQualityEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("9"))), client.getNameDataQuality());
						assertEquals("intersex", client.getOtherGender());
						assertEquals(ClientRaceEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("8"))), client.getRace());
						assertEquals("79xx9xx8x", client.getSsn());
						assertEquals(ClientSsnDataQualityEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("2"))), client.getSsnDataQuality());
						assertEquals(ClientVeteranStatusEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("9"))), client.getVeteranStatus());
						assertEquals(ClientEthnicityEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("0"))), client.getEthnicity());
						assertEquals(ClientDobDataQualityEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), client.getDobDataQuality());
					}
					
					assertEquals(1,exportEntity.getContacts().size());
					Set<Contact> contacts = exportEntity.getContacts();
					for(Contact contact : contacts) {
						assertEquals(new Integer("2"),contact.getContactLocation());
					}
					
					assertEquals(1, exportEntity.getDateofengagements().size());
					Set<Dateofengagement> dateOfEngagements = exportEntity.getDateofengagements();
					for (Dateofengagement dateOfEngagement : dateOfEngagements) {
						assertEquals("PG0001", dateOfEngagement.getProjectGroupCode());
					}
					
					assertEquals(1, exportEntity.getDisabilitieses().size());
					Set<Disabilities> disabilities = exportEntity.getDisabilitieses();
					for (Disabilities disability : disabilities) {
						assertEquals(new Integer("2"), disability.getDisabilityresponse());
						assertEquals(DisabilitiesDisabilitytypeEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("8"))), disability.getDisabilitytype());
						assertEquals(DisabilitiesDocumentationonfileEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), disability.getDocumentationonfile());
						assertEquals(new Integer("2"),disability.getDisabilityresponse());
//						assertEquals(DisabilitiesIndefiniteandimpairsEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("9"))), disability.getIndefiniteandimpairs());
						assertEquals(DisabilitiesPathhowconfirmedEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), disability.getPathhowconfirmed());
						assertEquals(DisabilitiesPathsmiinformationEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("3"))), disability.getPathsmiinformation());
						assertEquals(DisabilitiesReceivingservicesEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("99"))), disability.getReceivingservices());
//						assertEquals(new Integer("1401"), disability.getTcellcount());
//						assertEquals(new Integer("1"), disability.getTcellcountavailable());
//						assertEquals("3", disability.getTcellcountsource());
//						assertEquals(new Integer("999999"), disability.getViralLoad());
//						assertEquals(new Integer("1"), disability.getViralLoadAvailable());
//						assertEquals("2", disability.getViralLoadSource());
						
					assertEquals(1, exportEntity.getDomesticviolences().size());
					Set<Domesticviolence> domesticViolences = exportEntity.getDomesticviolences();
					for (Domesticviolence domesticViolence : domesticViolences) {
//						assertEquals(new Integer("8"), domesticViolence.getCurrentlyFleeing());
						assertEquals(DomesticviolenceDomesticviolencevictimEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), domesticViolence.getDomesticviolencevictim());
						assertEquals(DomesticviolenceWhenoccurredEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("2"))), domesticViolence.getWhenoccurred());
					}
					
					assertEquals(0, exportEntity.getEducations().size());
					Set<Education> educations = exportEntity.getEducations();
					for (Education education : educations) {
						assertEquals(LastgradecompletedLastgradecompletedEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("3"))), education.getLastgradecompleted());
						assertEquals(SchoolStatusEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("8"))), education.getSchoolStatus());
					}
						
					assertEquals(1, exportEntity.getEmployments().size());
					Set<Employment> employments = exportEntity.getEmployments();
					for (Employment employment : employments) {
						assertEquals(EmploymentEmploymentTypeEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("2"))), employment.getEmploymentType());
						assertEquals(EmploymentEmployedEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("8"))), employment.getEmployed() );
						assertEquals(EmploymentNotEmployedReasonEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("3"))), employment.getNotEmployedReason());
					}
					
					assertEquals(2, exportEntity.getEnrollmentCocs().size());
					Set<EnrollmentCoc> enrollmentCoCs = exportEntity.getEnrollmentCocs();
					for (EnrollmentCoc enrollmentCoc : enrollmentCoCs) {
						assertEquals(null, enrollmentCoc.getClientCode());
					}
					
					assertEquals(2, exportEntity.getEnrollments().size());
					Set<Enrollment> enrollments = exportEntity.getEnrollments();
					for (Enrollment enrollment : enrollments) {
//						assertEquals("", enrollment.getDateofengagements());
//						assertEquals("2015-04-01", enrollment.getDatetostreetessh());
						assertEquals(EnrollmentDisablingconditionEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("9"))), enrollment.getDisablingcondition());
						assertEquals(null, enrollment.getEntryfromstreetessh());
						assertEquals(EnrollmentHousingstatusEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("6"))), enrollment.getHousingstatus());
						assertEquals(EnrollmentMonthshomelesspastthreeyearsEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("103"))), enrollment.getMonthshomelesspastthreeyears());
						assertEquals("some other residence text here", enrollment.getOtherresidenceprior());
//						assertEquals(EnrollmentRelationshiptohohEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("2"))), enrollment.getRelationshiptohoh());
						assertEquals(EnrollmentResidencepriorlengthofstayEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("8"))), enrollment.getResidencepriorlengthofstay());
//						assertEquals(EnrollmentTimeshomelesspastthreeyearsEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), enrollment.getTimeshomelesspastthreeyears());
					}
					
					assertEquals(1, exportEntity.getEntryrhies().size());
					Set<Entryrhy> entryRHYIES = exportEntity.getEntryrhies();
					for (Entryrhy entryRHY : entryRHYIES) {
						assertEquals(new Integer("1"), entryRHY.getAbuseAndNeglectFamilyMbr());
						assertEquals(new Integer("0"), entryRHY.getAbuseAndNeglectYouth());
						assertEquals(new Integer("1"), entryRHY.getActiveMilitaryParent());
						assertEquals(new Integer("0"), entryRHY.getAlcoholDrugAbuseFamilyMbr());
						assertEquals(new Integer("0"), entryRHY.getAlcoholDrugAbuseYouth());
						assertEquals(new Integer("1"), entryRHY.getAskedOfForcedToExchangeForSex());
						assertEquals(new Integer("8"), entryRHY.getAskedOfForcedToExchangeForSexPastThreeMonths());
						assertEquals(new Integer("0"), entryRHY.getCoercedToContinueWork());
						assertEquals(new Integer("3"), entryRHY.getCountOfExchangeForSex());
						assertEquals(new Integer("3"), entryRHY.getCountOutReachReferralApproaches());
						assertEquals(new Integer("1"), entryRHY.getExchangeForSex());
						assertEquals(new Integer("1"), entryRHY.getExchangeForSexPastThreeMonths());
						assertEquals(new Integer("1"), entryRHY.getFormerlyWardChildWelfrForestCare());
						assertEquals(new Integer("9"), entryRHY.getFormerlyWardOfJuvenileJustice());
						assertEquals(new Integer("0"), entryRHY.getHealthIssuesFamilyMbr());
						assertEquals(new Integer("1"), entryRHY.getHealthIssuesYouth());
						assertEquals(new Integer("0"), entryRHY.getHouseHoldDynamics());
						assertEquals(new Integer("1"), entryRHY.getHousingIssuesFamilyMbr());
						assertEquals(new Integer("1"), entryRHY.getIncarceratedParent());
						assertEquals(new Integer("1"), entryRHY.getIncarceratedParentStatus());
						assertEquals(new Integer("0"), entryRHY.getInsufficientIncomeToSupportYouth());
						assertEquals(new Integer("8"), entryRHY.getLaborExploitPastThreeMonths());
						assertEquals(new Integer("0"), entryRHY.getMentalDisabilityFamilyMbr());
						assertEquals(new Integer("1"), entryRHY.getMentalDisabilityYouth());
						assertEquals(new Integer("0"), entryRHY.getMentalHealthIssuesFamilyMbr());
						assertEquals(new Integer("0"), entryRHY.getMentalHealthIssuesYouth());
						assertEquals(new Integer("42"), entryRHY.getMonthsChildWelfrForestCare());
						assertEquals(new Integer("0"), entryRHY.getPhysicalDisabilityFamilyMbr());
						assertEquals(new Integer("0"), entryRHY.getPhysicalDisabilityYouth());
						assertEquals(new Integer("18"), entryRHY.getReferralSource());
						assertEquals(new Integer("0"), entryRHY.getSchoolEducationIssuesFamilyMbr());
						assertEquals(new Integer("0"), entryRHY.getSchoolEducationIssuesYouth());
						assertEquals(new Integer("0"), entryRHY.getSexualOrientatiionGenderIdentityFamilyMbr());
						assertEquals(new Integer("0"), entryRHY.getSexualOrientatiionGenderIdentityYouth());
						assertEquals(new Integer("99"), entryRHY.getSexualOrientation());
						assertEquals(new Integer("0"), entryRHY.getUnemployementFamilyMbr());
						assertEquals(new Integer("1"), entryRHY.getUnemployementYouth());
						assertEquals(new Integer("1"), entryRHY.getWorkPlacePromiseDifference());
						assertEquals(new Integer("0"), entryRHY.getWorkPlaceViolenceThreat());
						assertEquals(new Integer("2"), entryRHY.getYearsChildWelfrForestCare());
						assertEquals(new Integer("3"), entryRHY.getYearsJuvenileJustice());
					}
					
					 	assertEquals(0, exportEntity.getEntryrhsps().size());
//						Set<Entryrhsp> entryRHSPs = exportEntity.getEntryrhsps();
//						List<Entryrhsp> lstEntryRSHP = new ArrayList<>(entryRHSPs);
//						Entryrhsp entryRHSP = lstEntryRSHP.get(0);
//						assertEquals("", entryRHSP.getWorstHousingSituation());
					
					assertEquals(2, exportEntity.getCocs().size());
					
					Set<Coc> cocs = exportEntity.getCocs();
					List<Coc> lstCoc = new ArrayList<Coc>(cocs);
					Coc coc = lstCoc.get(0);
					assertEquals("MA-500", coc.getCoccode());
					
					assertEquals(1, exportEntity.getEntryssvfs().size());
					Set<Entryssvf> entrySSVFs = exportEntity.getEntryssvfs();
					List<Entryssvf> lstEntryssvf = new ArrayList<Entryssvf>(entrySSVFs);
					Entryssvf entrySSVF = lstEntryssvf.get(0);
					assertEquals(new Integer("2"), entrySSVF.getAddressDataQuality());
					assertEquals(new Integer("12"), entrySSVF.getHpScreeningScore());
					assertEquals("Yreka", entrySSVF.getLastPermanentCity());
					assertEquals("AR", entrySSVF.getLastPermanentState());
					assertEquals("13th Ave W", entrySSVF.getLastPermanentStreet());
					assertEquals("57601", entrySSVF.getLastPermanentZip());
					assertEquals(new Integer("1"), entrySSVF.getPercentami());
					assertEquals("76762T78", entrySSVF.getVamcStation());

					assertEquals(1, exportEntity.getExithousingassessments().size());
					Set<Exithousingassessment> exitHousingAssmnts = exportEntity.getExithousingassessments();
					List<Exithousingassessment> lstExitHousingAssmnt = new ArrayList<Exithousingassessment>(exitHousingAssmnts);
					Exithousingassessment exitHousingAssmnt = lstExitHousingAssmnt.get(0);
					assertEquals(ExithousingassessmentHousingassessmentEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("6"))), exitHousingAssmnt.getHousingassessment());
					assertEquals(ExithousingassessmentSubsidyinformationEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("2"))), exitHousingAssmnt.getSubsidyinformation());
				
					assertEquals(1, exportEntity.getExitpaths().size());
					Set<Exitpath> exitPaths = exportEntity.getExitpaths();
					List<Exitpath> lstExitPath = new ArrayList<Exitpath>(exitPaths);
					Exitpath exitPath = lstExitPath.get(0);
					assertEquals(new Integer("0"), exitPath.getConnectionWithSoar());
					
					assertEquals(1, exportEntity.getExitrhies().size());
					Set<Exitrhy> exitRHYs = exportEntity.getExitrhies();
					List<Exitrhy> lstExitRHY = new ArrayList<Exitrhy>(exitRHYs);
					Exitrhy exitRHY = lstExitRHY.get(0);
					assertEquals(new Integer("0"), exitRHY.getAssistanceMainStreamBenefits());
					assertEquals(new Integer("1"), exitRHY.getEarlyExitReason());
					assertEquals(new Integer("0"), exitRHY.getExitCounseling());
					assertEquals(new Integer("1"), exitRHY.getFamilyReunificationAchieved());
					assertEquals(new Integer("1"), exitRHY.getFurtherFollowupServices());
					assertEquals(new Integer("0"), exitRHY.getPermenantHousingPlacement());
					assertEquals(new Integer("0"), exitRHY.getOtherAftercarePlanOrAction());
					assertEquals(new Integer("3"), exitRHY.getProjectCompletionStatus());
					assertEquals(new Integer("9"), exitRHY.getResourcePackage());
					assertEquals(new Integer("1"), exitRHY.getScheduledFollowupContacts());
					assertEquals(new Integer("0"), exitRHY.getTempShelterPlacement());
					assertEquals(new Integer("9"), exitRHY.getWrittenAfterCarePlan());
					
					assertEquals(2, exportEntity.getExits().size());
					Set<Exit> exits = exportEntity.getExits();
					List<Exit> lstExit = new ArrayList<Exit>(exits);
					Exit exit = lstExit.get(0);
//					assertEquals(ExitDestinationEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("17"))), exit.getDestination());
//					assertEquals("Hotel Training Program", exit.getOtherdestination());
					
					assertEquals(2, exportEntity.getFunders().size());
					Set<Funder> funders = exportEntity.getFunders();
					List<Funder> lstFunder = new ArrayList<Funder>(funders);
					Funder funder = lstFunder.get(0);
					assertEquals(FunderFunderEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("16")) ), funder.getFunder());
					
					assertEquals(2, exportEntity.getHealthinsurances().size());
					Set<Healthinsurance> healthInsurances = exportEntity.getHealthinsurances();
					List<Healthinsurance> lstHealthInsurance = new ArrayList<Healthinsurance>(healthInsurances);
					Healthinsurance healthInsurance = lstHealthInsurance.get(0);
					assertEquals(new Integer("1"), healthInsurance.getCobra());
					assertEquals(new Integer("1"), healthInsurance.getEmployerprovided());
					assertEquals(HealthinsuranceInsurancefromanysourceEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("8"))), healthInsurance.getInsurancefromanysource());
					assertEquals(HealthinsuranceMedicaidEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("0"))), healthInsurance.getMedicaid());
					assertEquals(HealthinsuranceMedicareEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("0"))), healthInsurance.getMedicare());
					assertEquals(HealthinsuranceNocobrareasonEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("9"))), healthInsurance.getNocobrareason());
					assertEquals(HealthinsuranceNoemployerprovidedreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("9"))), healthInsurance.getNoemployerprovidedreason());
					assertEquals(HealthinsuranceNomedicaidreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), healthInsurance.getNomedicaidreason());
					assertEquals(HealthinsuranceNomedicarereasonEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("4"))), healthInsurance.getNomedicarereason());
					assertEquals(HealthinsuranceNoprivatepayreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("8"))), healthInsurance.getNoprivatepayreason());
					assertEquals(HealthinsuranceNoschipreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("3"))), healthInsurance.getNoschipreason());
					assertEquals(HealthinsuranceNostatehealthinsreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("4"))), healthInsurance.getNostatehealthinsreason());
					assertEquals(HealthinsuranceNovamedreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("99"))), healthInsurance.getNovamedreason());
					/*assertEquals(new Integer(""), healthInsurance.getOtherSource());
					assertEquals("", healthInsurance.getOtherSourceIdentify());*/
					assertEquals(HealthinsurancePrivatepayEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), healthInsurance.getPrivatepay());
					assertEquals(HealthinsuranceSchipEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), healthInsurance.getSchip());
					assertEquals(HealthinsuranceStatehealthinsEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("0"))), healthInsurance.getStatehealthins());
					assertEquals(HealthinsuranceVamedicalservicesEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("0"))), healthInsurance.getVamedicalservices());
					
					assertEquals(1, exportEntity.getHousingassessmentdispositions().size());
					Set<Housingassessmentdisposition> housingAssessmendtispositions = exportEntity.getHousingassessmentdispositions();
					List<Housingassessmentdisposition> lstHousingAssessmentDisposition = new ArrayList<Housingassessmentdisposition>(housingAssessmendtispositions);
					Housingassessmentdisposition housingAssessmentDisposition = lstHousingAssessmentDisposition.get(0);
					assertEquals(HousingassessmentdispositionAssessmentdispositionEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("9"))), housingAssessmentDisposition.getAssessmentdisposition());
					assertEquals("some other disposition text here", housingAssessmentDisposition.getOtherdisposition());
					
					assertEquals(1, exportEntity.getHealthStatuses().size());
					Set<HealthStatus> healthStatuses = exportEntity.getHealthStatuses();
					List<HealthStatus> lstHealthStatus = new ArrayList<HealthStatus>(healthStatuses);
					HealthStatus healthStatus = lstHealthStatus.get(0);
					assertEquals(HealthStatusHealthCategoryEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("27"))), healthStatus.getHealthCategory());
					assertEquals(HealthStatusHealthStatusEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("4"))), healthStatus.getHealthStatus());
					
					assertEquals(1, exportEntity.getIncomeandsourceses().size());
					Set<Incomeandsources> incomeandSourceses = exportEntity.getIncomeandsourceses();
					List<Incomeandsources> lstIncomeandSources = new ArrayList<Incomeandsources>(incomeandSourceses);
					Incomeandsources incomeAndSource = lstIncomeandSources.get(0);
					assertEquals(IncomeandsourcesAlimonyEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), incomeAndSource.getAlimony());
//					assertEquals(new BigDecimal(1121.759999999999990905052982270717620849609375), incomeAndSource.getAlimonyamount());
					assertEquals(IncomeandsourcesChildsupportEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), incomeAndSource.getChildsupport());
//					assertEquals(new BigDecimal(562.40), incomeAndSource.getChildsupportamount());
					assertEquals(IncomeandsourcesEarnedEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), incomeAndSource.getEarned());
//					assertEquals(new BigDecimal(13916.10), incomeAndSource.getEarnedamount());
					assertEquals(IncomeandsourcesGaEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), incomeAndSource.getGa());
//					assertEquals(new BigDecimal(15254.55), incomeAndSource.getGaamount());
					assertEquals(IncomeandsourcesIncomefromanysourceEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), incomeAndSource.getIncomefromanysource());
					assertEquals(IncomeandsourcesOthersourceEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), incomeAndSource.getOthersource());
//					assertEquals(new BigDecimal(156.47), incomeAndSource.getOthersourceamount());
					assertEquals("some other source here", incomeAndSource.getOthersourceidentify());
					assertEquals(IncomeandsourcesPensionEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), incomeAndSource.getPension());
//					assertEquals(new BigDecimal(7865.32), incomeAndSource.getPensionamount());
					assertEquals(IncomeandsourcesPrivatedisabilityEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("0"))), incomeAndSource.getPrivatedisability());
//					assertEquals(new BigDecimal(11484.77), incomeAndSource.getPrivatedisabilityamount());
					assertEquals(IncomeandsourcesSocsecretirementEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), incomeAndSource.getSocsecretirement());
//					assertEquals(new BigDecimal(4784.72), incomeAndSource.getSocsecretirementamount());
					assertEquals(IncomeandsourcesSsdiEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("0"))), incomeAndSource.getSsdi());
//					assertEquals(new BigDecimal(41016.91), incomeAndSource.getSsdiamount());
					assertEquals(IncomeandsourcesSsiEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), incomeAndSource.getSsi());
//					assertEquals(new BigDecimal(41016.91), incomeAndSource.getSsiamount());
					assertEquals(IncomeandsourcesTanfEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("0"))), incomeAndSource.getTanf());
//					assertEquals(new BigDecimal(963412872.89), incomeAndSource.getTanfamount());
//					assertEquals(new BigDecimal(1889.22), incomeAndSource.getTotalmonthlyincome());
					assertEquals(IncomeandsourcesUnemploymentEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("0"))), incomeAndSource.getUnemployment());
//					assertEquals(new BigDecimal(315.87), incomeAndSource.getUnemploymentamount());
					assertEquals(IncomeandsourcesVadisabilitynonserviceEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("0"))), incomeAndSource.getVadisabilitynonservice());
//					assertEquals(new BigDecimal(6847.91), incomeAndSource.getVadisabilitynonserviceamount());
					assertEquals(IncomeandsourcesVadisabilityserviceEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), incomeAndSource.getVadisabilityservice());
//					assertEquals(new BigDecimal(5642.48), incomeAndSource.getVadisabilityserviceamount());
					assertEquals(IncomeandsourcesWorkerscompEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), incomeAndSource.getWorkerscomp());
//					assertEquals(new BigDecimal(8951855.15), incomeAndSource.getWorkerscompamount());
					
					assertEquals(1, exportEntity.getInventories().size());
					Set<Inventory> inventotries = exportEntity.getInventories();
					List<Inventory> lstInventory = new ArrayList<Inventory>(inventotries);
					Inventory inventory = lstInventory.get(0);
					assertEquals(InventoryAvailabiltyEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("3"))), inventory.getAvailabilty());
					assertEquals(InventoryBedtypeEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("3"))), inventory.getBedtype());
					assertEquals(new Integer("0"), inventory.getChBedInventory());
					assertEquals(new Integer("539390492"), inventory.getHmisparticipatingbeds());
					assertEquals(InventoryHouseholdtypeEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), inventory.getHouseholdtype());
					assertEquals(new Integer("1595973432"), inventory.getUnitinventory());
					assertEquals(new Integer("0"), inventory.getVetBedInventory());
					assertEquals(new Integer("0"), inventory.getYouthAgeGroup());
					assertEquals(new Integer("0"), inventory.getYouthBedInventory());
					
					assertEquals(1, exportEntity.getMedicalassistances().size());
					Set<Medicalassistance> medicalAssistances = exportEntity.getMedicalassistances();
					List<Medicalassistance> lstMedicalAssistance = new ArrayList<Medicalassistance>(medicalAssistances);
					Medicalassistance medicalAssistance = lstMedicalAssistance.get(0);
					assertEquals(MedicalassistanceAdapEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("9"))), medicalAssistance.getAdap());
					assertEquals(MedicalassistanceHivaidsassistanceEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("99"))), medicalAssistance.getHivaidsassistance());
					assertEquals(MedicalassistanceNoadapreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("9"))), medicalAssistance.getNoadapreason());
					assertEquals(MedicalassistanceNohivaidsassistancereasonEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), medicalAssistance.getNohivaidsassistancereason());
					
					assertEquals(1, exportEntity.getNoncashbenefitss().size());
					Set<Noncashbenefits> nonCashBenefitss = exportEntity.getNoncashbenefitss();
					List<Noncashbenefits> lstNoncashbenefits = new ArrayList<Noncashbenefits>(nonCashBenefitss);
					Noncashbenefits nonCashBenefits = lstNoncashbenefits.get(0);
					assertEquals(NoncashbenefitsBenefitsfromanysourceEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), nonCashBenefits.getBenefitsfromanysource());
					assertEquals(NoncashbenefitsOthersourceEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("0"))), nonCashBenefits.getOthersource());
					assertEquals("some other source name", nonCashBenefits.getOthersourceidentify());
					assertEquals(NoncashbenefitsOthertanfEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("0"))), nonCashBenefits.getOthertanf());
					assertEquals(NoncashbenefitsRentalassistanceongoingEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), nonCashBenefits.getRentalassistanceongoing());
					assertEquals(NoncashbenefitsRentalassistancetempEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), nonCashBenefits.getRentalassistancetemp());
					assertEquals(NoncashbenefitsSnapEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("0"))), nonCashBenefits.getSnap());
					assertEquals(NoncashbenefitsTanfchildcareEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("0"))), nonCashBenefits.getTanfchildcare());
					assertEquals(NoncashbenefitsTanftransportationEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("0"))), nonCashBenefits.getTanftransportation());
					assertEquals(NoncashbenefitsWicEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("0"))), nonCashBenefits.getWic());
					
					assertEquals(1, exportEntity.getOrganizations().size());
					Set<Organization> organizations = exportEntity.getOrganizations();
					List<Organization> lstOrganization = new ArrayList<Organization>(organizations);
					Organization organization = lstOrganization.get(0);
					assertEquals("Helping", organization.getOrganizationcommonname());
					assertEquals("Helping People, Inc.", organization.getOrganizationname());
					
					assertEquals(1, exportEntity.getPathStatuses().size());
					Set<Pathstatus> pathStatuses = exportEntity.getPathStatuses();
					List<Pathstatus> lstPathstatus = new ArrayList<Pathstatus>(pathStatuses);
					Pathstatus pathStatus = lstPathstatus.get(0);
					assertEquals(new Long("0"), pathStatus.getClientEnrolledInPath());
					assertEquals(PathstatusReasonnotenrolledEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("2"))), pathStatus.getReasonNotEnrolled());
					
					assertEquals(2, exportEntity.getProjects().size());
					Set<Project> projects = exportEntity.getProjects();
					List<Project> lstProject = new ArrayList<Project>(projects);
					Project project = lstProject.get(0);
					assertEquals(ProjectContinuumprojectEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("0"))), project.getContinuumproject());
//					assertEquals("Residence Enablers", project.getProjectcommonname());
//					assertEquals("Residence Enablers", project.getProjectname());
					assertEquals(ProjectProjecttypeEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("9"))), project.getProjecttype());
					assertEquals(ProjectTargetpopulationEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("4"))), project.getTargetpopulation());
					assertEquals(ProjectTrackingmethodEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("0"))), project.getTrackingmethod());
					
					assertEquals(1, exportEntity.getResidentialmoveindates().size());
					Set<Residentialmoveindate> residentialMoveinDates = exportEntity.getResidentialmoveindates();
					List<Residentialmoveindate> lstResidentialmoveindate = new ArrayList<Residentialmoveindate>(residentialMoveinDates);
					Residentialmoveindate residentialMoveinDate = lstResidentialmoveindate.get(0);
					assertEquals(ResidentialmoveindateInpermanenthousingEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), residentialMoveinDate.getInpermanenthousing());
					
					assertEquals(1, exportEntity.getRhybcpStatuses().size());
					Set<RhybcpStatus> rhybcpStatuses = exportEntity.getRhybcpStatuses();
					List<RhybcpStatus> lstRhybcpStatus = new ArrayList<RhybcpStatus>(rhybcpStatuses);
					RhybcpStatus rhybcpStatus = lstRhybcpStatus.get(0);
					assertEquals(RhybcpStatusFysbYouthEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("0"))), rhybcpStatus.getFysbYouth());
					assertEquals(RhybcpStatusReasonNoServicesEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("3"))), rhybcpStatus.getReasonNoServices());

					assertEquals(1, exportEntity.getServiceFaReferrals().size());
					Set<ServiceFaReferral> serviceFaReferrals = exportEntity.getServiceFaReferrals();
					List<ServiceFaReferral> lstServiceFaReferral = new ArrayList<ServiceFaReferral>(serviceFaReferrals);
					ServiceFaReferral serviceFaReferral = lstServiceFaReferral.get(0);
//					assertEquals(new BigDecimal(1145.59), serviceFaReferral.getFaAmount());
//					assertEquals(new Integer(""), serviceFaReferral.getFunderList());
					assertEquals("some other type here", serviceFaReferral.getOtherTypeProvided());
					assertEquals(new Integer("2"), serviceFaReferral.getReferralOutcome());
//					assertEquals(new Integer(""), serviceFaReferral.getServiceCategory());
					assertEquals(new Integer("12"), serviceFaReferral.getSubTypeProvided());
					assertEquals(new Integer("200"), serviceFaReferral.getTypeProvided());
					
					assertEquals(1, exportEntity.getSites().size());
					Set<Site> sites = exportEntity.getSites();
					List<Site> lstSite = new ArrayList<Site>(sites);
					Site site = lstSite.get(0);
					assertEquals("111 Pine St.", site.getAddress());
					assertEquals("Tuscaloosa", site.getCity());
					assertEquals(new Integer("177988"), site.getGeocode());
					assertEquals(SitePrincipalSiteEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), site.getPrincipalSite());
//					assertEquals(StateEnum.lookupEnum(BasicDataGenerator.getStringValue(Byte.valueOf("1"))), site.getState());
					assertEquals("84683", site.getZip());
					
					
					}
		} 

	
	@Test
	public void testDeleted() throws Exception {
		List<BulkUpload> uploadEntities=  factory.getBulkUploaderWorkerDao().findBulkUploadByStatus("DELETED");
		if(uploadEntities!=null && uploadEntities.size() >0 ) {
			for(BulkUpload bullkUpload : uploadEntities) {
				 dao.deleteLiveByExportId(bullkUpload.getExport().getId());
			}
		}
	}
	@Test
	public void deleteExportFromStaging() {
		UUID id = UUID.fromString("f51bade9-d2a4-4743-a165-642955431aba");
		dao.deleteStagingByExportId(id);
	}
	@Test
	public void deleteExportFromLive() {
		UUID id = UUID.fromString("f51bade9-d2a4-4743-a165-642955431aba");
		dao.deleteLiveByExportId(id);
	}
	@Test
	public void undodeleteExportFromLive() {
		String s = "293bf9fd-a465-413d-9e57-101022f37d21";
	String s2 = s.replace("-", "");
	UUID id = new UUID(
	        new BigInteger(s2.substring(0, 16), 16).longValue(),
	        new BigInteger(s2.substring(16), 16).longValue());
		dao.undoDeleteLiveByExportId(id);
	}
	@Test
	public void softDeleteProjectGroup() throws Exception {
		List<BulkUpload> uploads = factory.getBulkUploaderWorkerDao().findBulkUploadByStatus("LIVE");
		for(BulkUpload upload : uploads) {
			if(upload !=null && upload.getExport() !=null) {
				dao.deleteLiveByProjectGroupCode(upload.getProjectGroupCode());		
			}
		}
		
	}
	
	@Test
	public void moveToLive() throws Exception {
		List<BulkUpload> uploads = factory.getBulkUploaderWorkerDao().findBulkUploadByStatus("STAGING");
		for(BulkUpload upload : uploads) {
			if(upload !=null && upload.getExport() !=null) {
				dao.moveFromStagingToLive(upload);		
			}
		}
		
	}
}
