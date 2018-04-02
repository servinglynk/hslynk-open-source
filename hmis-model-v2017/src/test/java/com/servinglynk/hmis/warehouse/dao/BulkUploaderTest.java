package com.servinglynk.hmis.warehouse.dao;

import java.io.File;
import java.math.BigInteger;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.dao.BaseDaoFactory;
import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.config.DatabaseConfig;
import com.servinglynk.hmis.warehouse.config.StandAloneDBPoolConfig;
import com.servinglynk.hmis.warehouse.dao.helper.BulkUploadHelperTest;
import com.servinglynk.hmis.warehouse.domain.Sources;
import com.servinglynk.hmis.warehouse.domain.Sources.Source;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.base.BulkUpload;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.model.v2017.Error2017;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseConfig.class,StandAloneDBPoolConfig.class},loader = AnnotationConfigContextLoader.class)
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager") 
public class BulkUploaderTest {
	
	@Autowired
	BulkUploaderDao dao;
	
	@Autowired
	ExportDao exportDao;
	
	@Autowired
	ParentDaoFactory factory;
	
	@Autowired
	BaseDaoFactory baseFactory;
	@Test 
	public void test() throws JAXBException
	{
		SyncDomain domain = new SyncDomain();
//		factory.getEnrollmentDao().hydrateHBASE(domain);
		BulkUpload upload = new BulkUpload();
		URL path = BulkUploaderTest.class.getResource("New_HUD_Boman.xml");
		upload.setInputpath(path.getFile());
		ProjectGroupEntity projectGrpEntity = new ProjectGroupEntity();
		BulkUpload  uploadResult =   dao.performBulkUpload(upload,projectGrpEntity,null,false);
		File file = new File(
				path.getFile());
		JAXBContext jaxbContext = JAXBContext.newInstance(Sources.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Sources sources = (Sources) jaxbUnmarshaller.unmarshal(file);
		Source source = sources.getSource();
//		Export export = uploadResult.getExport();
//		com.servinglynk.hmis.warehouse.model.stagv2015.Export stagingExport = (com.servinglynk.hmis.warehouse.model.stagv2015.Export)factory.getExportDao().get(com.servinglynk.hmis.warehouse.model.stagv2015.Export.class, export.getId());
//		Set<Enrollment> enrollments = stagingExport.getEnrollments();
	}
	@Test
	@Transactional
	public void testOldFile()
	{
		BulkUpload upload = new BulkUpload();
	//	URL path = BulkUploaderTest.class.getResource("HUD_4_0__6.xml");
//		path.setURLStreamHandlerFactory(fac);
		//upload.setInputPath(path.getFile());
		upload.setInputpath("C:\\Users\\sdolia\\Downloads\\sr-ctrl1-CA0004.zip");
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
				URL path = BulkUploaderTest.class.getResource("2017.xml");
				BulkUpload upload = new BulkUpload();
				upload.setInputpath("/Users/sdolia/Downloads/Archive.zip");
				upload.setId(3L);
				FileAppender appender = new FileAppender();
				appender.setName("" + upload.getId());
				appender.setFile("logs/" + upload.getId() + ".log");
				appender.setImmediateFlush(true);
				appender.setAppend(true);
				appender.setLayout(new PatternLayout());
				appender.activateOptions();
				//upload.setInputpath("C:\\Users\\sdolia\\Desktop\\HUDFile\\CSV\\CSV.zip");
		//		URL path = BulkUploadHelperTest.class.getResource("2016.xml");
		//		upload.setInputpath(path.getPath());
				upload.setProjectGroupCode("SR0012");
				upload.setId(390L);
				ProjectGroupEntity projectGrpEntity = new ProjectGroupEntity();
				BulkUpload bulkUpload = factory.getBulkUploaderDao().performBulkUpload(upload,projectGrpEntity,appender,false);
	}
		@Test
		public void testCSVZip() throws Exception
		{
			URL path = BulkUploadHelperTest.class.getResource("2017.xml");
			
			System.out.println("Path -- >>> "+path);
			BulkUpload bullkUpload = new BulkUpload();
			bullkUpload.setInputpath(path.getPath());
			bullkUpload.setProjectGroupCode("PG0001");
			FileAppender appender = new FileAppender();
			appender.setName("" + bullkUpload.getId());
			appender.setFile("logs/" + bullkUpload.getId() + ".log");
			appender.setImmediateFlush(true);
			appender.setAppend(true);
			appender.setLayout(new PatternLayout());
			appender.activateOptions();
			bullkUpload.setId(1L);
			ProjectGroupEntity projectGrpEntity = new ProjectGroupEntity();
			bullkUpload.setProjectGroupCode("PG0001");
			BulkUpload upload = factory.getBulkUploaderDao().performBulkUpload(bullkUpload,projectGrpEntity,appender,false);
			//com.servinglynk.hmis.warehouse.model.stagv2015.Export exportEntity = exportDao.getExportById(upload.getExport().getId());
				
					
		} 

	/* Sandeep TODO: Need to move this test to the base model.
	@Test
	public void testDeleted() throws Exception {
		List<BulkUpload> uploadEntities=  factory.getBulkUploaderWorkerDao().findBulkUploadByStatus("DELETED");
		if(uploadEntities!=null && uploadEntities.size() >0 ) {
			for(BulkUpload bullkUpload : uploadEntities) {
				 dao.deleteLiveByExportId(bullkUpload.getExportId());
			}
		}
	}
	*/
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
			if(upload !=null && upload.getExportId() !=null) {
				dao.deleteLiveByProjectGroupCode(upload.getProjectGroupCode(),upload.getExportId());		
			}
		}
		
	}

	@Test
	public void insertErrorInBulkErrorTable(){
		Error2017 error2015 = new Error2017();
		error2015.model_id = UUID.randomUUID();
		error2015.bulk_upload_ui = 3L;
		error2015.project_group_code = "CODE009";
		error2015.source_system_id = UUID.randomUUID().toString();
		error2015.type = ErrorType.ERROR;
		error2015.error_description = "invalid model";
		error2015.date_created = LocalDateTime.now();
		factory.getBulkUploaderWorkerDao().insert(error2015);

		Error2017 error2015_2 = new Error2017();
		error2015_2.model_id = UUID.randomUUID();
		error2015_2.bulk_upload_ui = 4L;
		error2015_2.project_group_code = "CODE001";
		error2015_2.source_system_id = UUID.randomUUID().toString();
		error2015_2.type = ErrorType.WARN;
		error2015_2.error_description = "warning";
		error2015_2.date_created = LocalDateTime.now();

		factory.getBulkUploaderWorkerDao().insert(error2015_2);

	}
}
