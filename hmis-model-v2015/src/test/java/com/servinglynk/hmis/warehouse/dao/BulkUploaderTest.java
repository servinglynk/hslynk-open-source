package com.servinglynk.hmis.warehouse.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.math.BigInteger;
import java.net.URL;
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
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.model.stagv2015.Client;
import com.servinglynk.hmis.warehouse.model.stagv2015.Enrollment;
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
	@Test
	@Transactional
	public void testCSVZip() throws Exception
	{
				URL path = BulkUploaderTest.class.getResource("2015.xml");
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
