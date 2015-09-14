package com.servinglynk.hmis.warehouse.sync.service;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.servinglynk.hmis.warehouse.config.DatabaseConfig;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.model.live.BulkUpload;
import com.servinglynk.hmis.warehouse.sync.config.SpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class,loader = AnnotationConfigContextLoader.class)
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager") 
public class SyncServiceTest {
	
	@Autowired
	ISyncService service;
	
	@Test
	public void test()
	{
		service.createSyncInit();
	}
	
}
