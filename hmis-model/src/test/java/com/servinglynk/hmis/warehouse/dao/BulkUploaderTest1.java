package com.servinglynk.hmis.warehouse.dao;

import java.io.File;
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

import com.servinglynk.hmis.warehouse.config.DatabaseConfig;
import com.servinglynk.hmis.warehouse.dao.BulkUploaderDao;
import com.servinglynk.hmis.warehouse.dao.ParentDaoFactory;
import com.servinglynk.hmis.warehouse.dao.helper.BulkUploadHelperTest;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources;
import com.servinglynk.hmis.warehouse.domain.Sources.Source;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.staging.BulkUpload;
import com.servinglynk.hmis.warehouse.model.live.Enrollment;
import com.servinglynk.hmis.warehouse.model.live.Export;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class,loader = AnnotationConfigContextLoader.class)
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager") 
public class BulkUploaderTest1 {
	
	@Autowired
	BulkUploaderDao dao;
	
	@Autowired
	ParentDaoFactory factory;
	
	@Test
	public void test() throws JAXBException
	{
		SyncDomain domain = new SyncDomain();
//		factory.getEnrollmentDao().hydrateHBASE(domain);
		BulkUpload upload = new BulkUpload();
		URL path = BulkUploaderTest1.class.getResource("New_HUD_Boman.xml");
		upload.setInputPath(path.getFile());
		BulkUpload  uploadResult =   dao.performBulkUpload(upload);
		File file = new File(
				path.getFile());
		JAXBContext jaxbContext = JAXBContext.newInstance(Sources.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Sources sources = (Sources) jaxbUnmarshaller.unmarshal(file);
		Source source = sources.getSource();
		com.servinglynk.hmis.warehouse.model.staging.Export export = uploadResult.getExport();
		Export stagingExport = (Export)factory.getExportDao().get(com.servinglynk.hmis.warehouse.model.staging.Export.class, export.getId());
		Set<Enrollment> enrollments = stagingExport.getEnrollments();
	}
	@Test
	public void testOldFile()
	{
		BulkUpload upload = new BulkUpload();
		URL path = BulkUploaderTest1.class.getResource("outputhmis-model.xml");
		upload.setInputPath(path.getFile());
		
		dao.performBulkUpload(upload);
	}
	@Test
	public void testCSVZip() throws JAXBException
	{
		SyncDomain domain = new SyncDomain();
//		factory.getEnrollmentDao().hydrateHBASE(domain);
		BulkUpload upload = new BulkUpload();
		URL path = BulkUploadHelperTest.class.getResource("CSV_files.zip");
		upload.setInputPath(path.getFile());
		BulkUpload  uploadResult =   dao.performBulkUpload(upload);
		/*File file = new File(
				path.getFile());
		JAXBContext jaxbContext = JAXBContext.newInstance(Sources.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Sources sources = (Sources) jaxbUnmarshaller.unmarshal(file);
		Source source = sources.getSource();
		Export export = uploadResult.getExport();
		Export stagingExport = (Export)factory.getExportDao().get(com.servinglynk.hmis.warehouse.model.staging.Export.class, export.getId());
		Set<Enrollment> enrollments = stagingExport.getEnrollments(); */
	}
//	@Test
//	public void deleteExportFromStaging() {
//		UUID id = UUID.fromString("fda97ba3-e737-4812-a03a-448212606fee");
//		dao.deleteStagingByExportId(id);
//	}
//	@Test
//	public void deleteExportFromLive() {
//		UUID id = UUID.fromString("4dc6383a-c305-45f0-a876-016bf247e4a2");
//		dao.deleteLiveByExportId(id);
//	}
//	
	@Test
	public void moveToLive() throws Exception {
		ExportDomain domain = new ExportDomain();
		List<BulkUpload> uploads = factory.getBulkUploaderWorkerDao().findBulkUploadByStatus("STAGING");
		for(BulkUpload upload : uploads) {
			if(upload !=null && upload.getExport() !=null) {
				domain.setExportId(upload.getExport().getId());
				dao.moveFromStagingToLive(upload.getExport().getId());		
			}
		}
		
	}
}
