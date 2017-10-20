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
	public void testXMLUpload() throws JAXBException, IOException {
		URL path = BulkUploadHelperTest.class.getResource("2017.xml");
//		System.out.println(path);
		com.servinglynk.hmis.warehouse.model.base.BulkUpload upload = new com.servinglynk.hmis.warehouse.model.base.BulkUpload();
		//upload.setInputPath("C:\\HMIS\\hmis-lynk-open-source\\hmis-model\\src\\main\\test\\com\\servinglynk\\hmis\\warehouse\\dao\\HUD_4_0__6.xml");
		upload.setProjectGroupCode("PG0001");
		upload.setInputpath("/Users/sdolia/github/hmis-lynk-open-source/hmis-model-v2017/src/test/java/com/servinglynk/hmis/warehouse/dao/helper/2017.xml");
		com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity projectGrp = new com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity();
		projectGrp.setSkipuseridentifers(true);
		sources = helper.getSourcesFromFiles(upload,projectGrp,false);
		assertNotNull(sources);
	}
}
