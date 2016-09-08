package com.servinglynk.hmis.warehouse.dao;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.AssertTrue;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.model.v2014.Client;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;

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

import com.servinglynk.hmis.warehouse.config.DatabaseConfig;
import com.servinglynk.hmis.warehouse.model.base.BulkUpload;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class,loader = AnnotationConfigContextLoader.class)
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager") 
public class BulkUploaderTest {
	
	@Autowired
	BulkUploaderDao dao; 
	
	@Autowired
	ParentDaoFactory factory;
	
	
	@Test
	public void testOldFile()
	{
		BulkUpload upload = new BulkUpload();
	//	URL path = BulkUploaderTest.class.getResource("HUD_4_0__6.xml");
//		path.setURLStreamHandlerFactory(fac);
		//upload.setInputPath(path.getFile());
		FileAppender appender = new FileAppender();
		appender.setName("" + upload.getId());
		appender.setFile("logs/" + upload.getId() + ".log");
		appender.setImmediateFlush(true);
		appender.setAppend(true);
		appender.setLayout(new PatternLayout());
		appender.activateOptions();
		upload.setInputpath("C:/HMIS/hmis-lynk-open-source/hmis-model/src/main/test/com/servinglynk/hmis/warehouse/dao/HUD_4_0__6.xml");
		upload.setProjectGroupCode("PG0001");
		upload.setStatus("INITIAL");
	//	HmisUser hmisUser = (HmisUser)factory.getHmisUserDao().findByUsername("superadmin@hmis.com");
	//	upload.setUser(hmisUser);
		factory.getBulkUploaderWorkerDao().insert(upload);
		//dao.performBulkUpload(upload);
	}
	@Test
	public void testCSVZip() throws Exception                                         
	{
	//	URL path = BulkUploaderTest.class.getResource("HUD_4_0__6.xml");
		BulkUpload	bullkUpload = new BulkUpload();
		bullkUpload.setInputpath("C:\\Users\\sdolia\\Desktop\\HUD_4_0_1_4012_76.xml");
		//bullkUpload.setInputpath("C:\\Users\\sdolia\\Desktop\\HUDFile\\HUD_4_0_4012_47._old.xml");
		bullkUpload.setId(3L);
		FileAppender appender = new FileAppender();
		appender.setName("" + bullkUpload.getId());
		appender.setFile("logs/" + bullkUpload.getId() + ".log");
		appender.setImmediateFlush(true);
		appender.setAppend(true);
		appender.setLayout(new PatternLayout());
		appender.activateOptions();
		bullkUpload.setProjectGroupCode("PG0001");
		ProjectGroupEntity projectGrpEntity = new ProjectGroupEntity();
		projectGrpEntity.setProjectGroupCode("PG0001");
		factory.getBulkUploaderDao().performBulkUpload(bullkUpload,projectGrpEntity, appender,false);
	}
	
	@Test
	public void testxmlBigFile() throws Exception
	{
		
		BulkUpload upload = new BulkUpload();
		upload.setId(2L);
		FileAppender appender = new FileAppender();
		appender.setName("" + upload.getId());
		appender.setFile("logs/" + upload.getId() + ".log");
		appender.setImmediateFlush(true);
		appender.setAppend(true);
		appender.setLayout(new PatternLayout());
		appender.activateOptions();
		upload.setInputpath("C:\\AWS\\HUD_4_0_4012_48.xml");
		
		ProjectGroupEntity projectGrpEntity = new ProjectGroupEntity();
		projectGrpEntity.setProjectGroupCode("PG0001");
		upload.setProjectGroupCode("PG0001");
		factory.getBulkUploaderDao().performBulkUpload(upload,projectGrpEntity,appender,false);
	}
	@Test
	public void testAnotherxmlBigFile() throws Exception
	{
		BulkUpload upload = new BulkUpload();
		upload.setInputpath("C:\\Users\\sdolia\\Downloads\\HUD_4_0_1_4012_64.xml");
		upload.setId(3L);
		FileAppender appender = new FileAppender();
		appender.setName("" + upload.getId());
		appender.setFile("logs/" + upload.getId() + ".log");
		appender.setImmediateFlush(true);
		appender.setAppend(true);
		appender.setLayout(new PatternLayout());
		appender.activateOptions();
		ProjectGroupEntity projectGrpEntity = new ProjectGroupEntity();
		projectGrpEntity.setProjectGroupCode("JP0005");
		upload.setProjectGroupCode("JP0005");
		factory.getBulkUploaderDao().performBulkUpload(upload,projectGrpEntity,appender,false);
	}
	
	@Test
	public void testDeleted() throws Exception {
		List<BulkUpload> uploadEntities=  factory.getBulkUploaderWorkerDao().findBulkUploadByStatus("DELETED");
		if(uploadEntities!=null && uploadEntities.size() >0 ) {
			for(BulkUpload bullkUpload : uploadEntities) {
				 dao.deleteLiveByExportId(bullkUpload.getExportId());
			}
		}
	}
	@Test
	public void deleteExportFromLive() {
		UUID id = UUID.fromString("7a061420-2e9e-40d3-8dce-e0d2b220cdd1");
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
		List<BulkUpload> uploads = factory.getBulkUploaderWorkerDao().findBulkUploadByProjectGroupCode("MO0010");
		for(BulkUpload upload : uploads) {
			if(upload !=null && upload.getExportId() !=null) {
				dao.deleteLiveByProjectGroupCode(upload.getProjectGroupCode(),upload.getExportId());		
			}
		}
	}

	@Test
	public void insertErrorInBulkErrorTable(){
		Error2014 error2014 = new Error2014();
		error2014.model_id = UUID.randomUUID();
		error2014.bulk_upload_ui = 3L;
		error2014.project_group_code = "CODE007";
		error2014.source_system_id = UUID.randomUUID().toString();
		error2014.type = ErrorType.ERROR;
		error2014.error_description = "invalid model";
		error2014.date_created = LocalDateTime.now();
		factory.getBulkUploaderWorkerDao().insert(error2014);

		Error2014 error2014_2 = new Error2014();
		error2014_2.model_id = UUID.randomUUID();
		error2014_2.bulk_upload_ui = 4L;
		error2014_2.project_group_code = "CODE008";
		error2014_2.source_system_id = UUID.randomUUID().toString();
		error2014_2.type = ErrorType.WARN;
		error2014_2.error_description = "warning";
		error2014_2.date_created = LocalDateTime.now();

		factory.getBulkUploaderWorkerDao().insert(error2014_2);

	}
	
	@Test
	public void testValidation() {
		Client clientModel = new Client();
		clientModel.setSsn("123456789");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = (Validator) factory.getValidator();
		Set<ConstraintViolation<com.servinglynk.hmis.warehouse.model.v2014.Client>> constraintViolations = validator.validate(clientModel);
		System.out.println(constraintViolations.toString());
	}

}
