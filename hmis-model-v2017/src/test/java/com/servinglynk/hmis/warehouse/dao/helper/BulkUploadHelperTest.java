package com.servinglynk.hmis.warehouse.dao.helper;

import static org.junit.Assert.assertNotNull;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
		URL path = BulkUploadHelperTest.class.getResource("2017.xml");
//		System.out.println(path);
		com.servinglynk.hmis.warehouse.model.base.BulkUpload upload = new com.servinglynk.hmis.warehouse.model.base.BulkUpload();
		//upload.setInputPath("C:\\HMIS\\hmis-lynk-open-source\\hmis-model\\src\\main\\test\\com\\servinglynk\\hmis\\warehouse\\dao\\HUD_4_0__6.xml");
		upload.setProjectGroupCode("PG0001");
	//	upload.setInputpath("/Users/sdolia/Downloads/cta_live_hudcsv61_14922_6663059050002344965.zip");
		com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity projectGrp = new com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity();
		projectGrp.setSkipuseridentifers(true);
		sources = helper.getSourcesFromFiles(upload,projectGrp,false);
		assertNotNull(sources);
	}

	@Test
	public void testCsvZip() {
		//URL path = BulkUploadHelperTest.class.getResource("2017.xml");
		List<String> files = new ArrayList<>();
		files.add("CA0464/2017/archive-etoclient350-2018-Jul-02-153538-167.zip");
		files.add("CA0464/2016/archive-etoclient350-2018-Jul-30-151720-176.zip");
		files.add("CA0464/2015/archive-etoclient350-2018-Jul-30-151952-177.zip");
		files.add("CA0464/2014/archive-etoclient350-2018-Jul-30-152053-178.zip");
		files.add("CA0464/2013/archive-etoclient350-2018-Aug-02-171247-179.zip");
		files.add("CA0797/2017/archive-etoclient350-2018-Jul-02-165436-170.zip");
		files.add("CA0797/2016/archive-etoclient350-2018-Aug-13-141704-183.zip");
		files.add("CA0797/2015/archive-etoclient350-2018-Aug-13-141729-184.zip");
		files.add("CA0797/2014/archive-etoclient350-2018-Aug-13-141816-185.zip");
		files.add("CA0797/2013/archive-etoclient350-2018-Aug-13-141843-186.zip");
		files.add("CA1051/2017/archive-etoclient350-2018-Jul-02-165531-171.zip");
		files.add("CA1051/2016/archive-etoclient350-2018-Aug-13-165418-187.zip");
		files.add("CA1051/2015/archive-etoclient350-2018-Aug-13-165458-188.zip");
		files.add("CA1051/2014/archive-etoclient350-2018-Aug-13-165534-189.zip");
		files.add("CA1051/2013/archive-etoclient350-2018-Aug-13-165559-190.zip");
		files.add("CA1216/2017/archive-etoclient350-2018-Jul-02-165054-168.zip");
		files.add("CA1216/2016/archive-etoclient350-2018-Aug-13-181127-191.zip");
		files.add("CA1216/2015/archive-etoclient350-2018-Aug-13-181152-192.zip");
		files.add("CA1216/2014/archive-etoclient350-2018-Aug-13-181209-193.zip");
		files.add("CA1217/2017/archive-etoclient350-2018-Jul-02-165617-172.zip");
		files.add("CA1217/2016/archive-etoclient350-2018-Aug-13-195432-194.zip");
		files.add("CA1217/2015/archive-etoclient350-2018-Aug-13-195500-195.zip");
		files.add("CA1217/2014/archive-etoclient350-2018-Aug-13-195526-196.zip");
		files.add("CA1224/2017/archive-etoclient350-2018-Jul-02-165159-169.zip");
		
		for( String file : files) {
			com.servinglynk.hmis.warehouse.model.base.BulkUpload upload = new com.servinglynk.hmis.warehouse.model.base.BulkUpload();
			//upload.setInputPath("C:\\HMIS\\hmis-lynk-open-source\\hmis-model\\src\\main\\test\\com\\servinglynk\\hmis\\warehouse\\dao\\HUD_4_0__6.xml");
			upload.setProjectGroupCode("PG0001");
			upload.setInputpath("/Users/sdolia/github/HSLynk-Deployment/01-Project-Initiation/hmis-data/CoC/"+file);
			com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity projectGrp = new com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity();
			projectGrp.setSkipuseridentifers(true);
			try {
				sources = helper.getSourcesFromFiles(upload,projectGrp,false);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	
		
		assertNotNull(sources);
	}
	
}
