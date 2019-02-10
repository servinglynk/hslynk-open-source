package com.servinglynk.hmis.warehouse.dao.helper;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.net.URL;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;

import com.servinglynk.hmis.warehouse.domain.Sources;
public class BulkUploadHelperTest {

	public BulkUploadHelper2017 helper = new BulkUploadHelper2017();
	private Sources sources;
	
	@Before
	public void setUp() {
		
	}
	


	@Test
	public void testXMLUpload() throws Exception {
		URL path = BulkUploadHelperTest.class.getResource("HUD_HMIS_Instance.xml");
//		System.out.println(path);
		com.servinglynk.hmis.warehouse.model.base.BulkUpload upload = new com.servinglynk.hmis.warehouse.model.base.BulkUpload();
		//upload.setInputPath("C:\\HMIS\\hmis-lynk-open-source\\hmis-model\\src\\main\\test\\com\\servinglynk\\hmis\\warehouse\\dao\\HUD_4_0__6.xml");
		upload.setProjectGroupCode("PG0001");
		upload.setInputpath(path.getPath());
		com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity projectGrp = new com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity();
		projectGrp.setSkipuseridentifers(true);
		sources = helper.getSourcesFromFiles(upload,projectGrp,false);
		assertNotNull(sources);
	}

	@Test
	public void testCsvZip() {
		//URL path = BulkUploadHelperTest.class.getResource("2017.xml");
//		System.out.println(path);
		com.servinglynk.hmis.warehouse.model.base.BulkUpload upload = new com.servinglynk.hmis.warehouse.model.base.BulkUpload();
		//upload.setInputPath("C:\\HMIS\\hmis-lynk-open-source\\hmis-model\\src\\main\\test\\com\\servinglynk\\hmis\\warehouse\\dao\\HUD_4_0__6.xml");
		upload.setProjectGroupCode("PG0001");
		upload.setInputpath("/Users/sdolia/github/HSLynk-Deployment/01-Project-Initiation/hmis-data/CoC/CA0797/2017/archive-etoclient350-2018-Jul-02-165436-170.zip");
		com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity projectGrp = new com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity();
		projectGrp.setSkipuseridentifers(true);
		try {
			sources = helper.getSourcesFromFiles(upload,projectGrp,false);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		assertNotNull(sources);
	}
	
}
