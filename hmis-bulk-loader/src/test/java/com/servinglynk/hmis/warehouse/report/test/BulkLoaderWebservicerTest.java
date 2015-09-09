package com.servinglynk.hmis.warehouse.report.test;

import java.net.URL;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.servinglynk.hmis.warehouse.upload.config.AppConfig;



@WebAppConfiguration
@SpringApplicationConfiguration(classes=AppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@IntegrationTest({"server.port=0"})
public abstract class BulkLoaderWebservicerTest {
	
	
	
	@Value("${local.server.port}")
    private int port;
	private URL base;
	
	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
	}
	
	

}
