package com.servinglynk.hmis.warehouse.dao.helper;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.net.URL;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;

import com.servinglynk.hmis.warehouse.domain.Sources;
public class BulkUploadHelperTest {

	public BulkUploadHelper2020 helper = new BulkUploadHelper2020();
	private Sources sources;
	
	@Before
	public void setUp() {
		
	}
	


	@Test
	public void testXMLUpload() throws Exception {
		com.servinglynk.hmis.warehouse.model.base.BulkUpload upload = new com.servinglynk.hmis.warehouse.model.base.BulkUpload();
		upload.setInputpath("/Users/sdolia/github/hmis-lynk-open-source/hmis-model-v2020/src/main/resources/HUD_HMIS_Instance.xml");
		upload.setProjectGroupCode("PG0001");
		com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity projectGrp = new com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity();
		projectGrp.setSkipuseridentifers(true);
		sources = helper.getSourcesFromFiles(upload,projectGrp,false);
		assertNotNull(sources);
	}

	@Test
	public void testCsvZip() {
		//URL path = BulkUploadHelperTest.class.getResource("2020.xml");
//		System.out.println(path);
		com.servinglynk.hmis.warehouse.model.base.BulkUpload upload = new com.servinglynk.hmis.warehouse.model.base.BulkUpload();
		//upload.setInputPath("C:\\HMIS\\hmis-lynk-open-source\\hmis-model\\src\\main\\test\\com\\servinglynk\\hmis\\warehouse\\dao\\HUD_4_0__6.xml");
		upload.setProjectGroupCode("PG0001");
		upload.setInputpath("/Users/sdolia/Documents/GitHub/fy2020/Archive.zip");
		com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity projectGrp = new com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity();
		try {
			sources = helper.getSourcesFromFiles(upload,projectGrp,false);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		assertNotNull(sources);
	}
	
}
