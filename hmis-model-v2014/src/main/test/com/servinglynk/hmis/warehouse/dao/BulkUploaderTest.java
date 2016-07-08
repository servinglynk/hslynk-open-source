package com.servinglynk.hmis.warehouse.dao;

import java.math.BigInteger;
import java.net.URL;
import java.util.List;
import java.util.UUID;

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
	public void testCSVZip() throws Exception
	{
	//	URL path = BulkUploaderTest.class.getResource("HUD_4_0__6.xml");
		BulkUpload	bullkUpload = new BulkUpload();
		bullkUpload.setInputpath("C:\\Users\\sdolia\\Desktop\\HUDFile\\CSV1.zip");
		bullkUpload.setId(3L);
		bullkUpload.setProjectGroupCode("PG0001");
		ProjectGroupEntity projectGrpEntity = new ProjectGroupEntity();
		projectGrpEntity.setProjectGroupCode("PG0001");
		factory.getBulkUploaderDao().performBulkUpload(bullkUpload,projectGrpEntity);
	}
	
	@Test
	public void testxmlBigFile() throws Exception
	{
		BulkUpload bullkUpload = new BulkUpload();
		bullkUpload.setInputpath("C:\\AWS\\HUD_4_0_4012_48.xml");
		bullkUpload.setId(2L);
		ProjectGroupEntity projectGrpEntity = new ProjectGroupEntity();
		projectGrpEntity.setProjectGroupCode("PG0001");
		bullkUpload.setProjectGroupCode("PG0001");
		factory.getBulkUploaderDao().performBulkUpload(bullkUpload,projectGrpEntity);
	}
	@Test
	public void testAnotherxmlBigFile() throws Exception
	{
		BulkUpload bullkUpload = new BulkUpload();
		bullkUpload.setInputpath("C:\\Users\\sdolia\\Desktop\\HUDFile\\HUD_4.0.xml");
		bullkUpload.setId(5L);
		ProjectGroupEntity projectGrpEntity = new ProjectGroupEntity();
		projectGrpEntity.setProjectGroupCode("JP0005");
		bullkUpload.setProjectGroupCode("JP0005");
		factory.getBulkUploaderDao().performBulkUpload(bullkUpload,projectGrpEntity);
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
		List<BulkUpload> uploads = factory.getBulkUploaderWorkerDao().findBulkUploadByStatus("LIVE");
		for(BulkUpload upload : uploads) {
			if(upload !=null && upload.getExportId() !=null) {
				dao.deleteLiveByProjectGroupCode(upload.getProjectGroupCode(),upload.getExportId());		
			}
		}
		
	}
}
