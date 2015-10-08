package com.servinglynk.hmis.warehouse.util;

import java.net.URL;

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
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.staging.BulkUpload;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class,loader = AnnotationConfigContextLoader.class)
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager") 
public class RunSync {
	
	@Autowired
	BulkUploaderDao dao;
	
	@Autowired
	ParentDaoFactory factory;
	
	public static void main(String args[]){
		SyncDomain domain = new SyncDomain();
//		factory.getEnrollmentDao().hydrateHBASE(domain);
		BulkUpload upload = new BulkUpload();
		//URL path = BulkUploadHelperTest.class.getResource("CSV_files.zip");
	//	upload.setInputPath(path.getFile());
		RunSync sync = new RunSync();
		sync.runBulkUpload(upload);
	}
	
	public void runBulkUpload(BulkUpload upload) 
	{
		BulkUpload  uploadResult =   dao.performBulkUpload(upload);
	}
}

