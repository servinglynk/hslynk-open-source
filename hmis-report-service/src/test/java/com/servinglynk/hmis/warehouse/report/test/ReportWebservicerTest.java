package com.servinglynk.hmis.warehouse.report.test;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.servinglynk.hmis.warehouse.core.model.Parameter;
import com.servinglynk.hmis.warehouse.core.model.ReportRequest;
import com.servinglynk.hmis.warehouse.report.config.AppConfig;



@WebAppConfiguration
@SpringApplicationConfiguration(classes=AppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@IntegrationTest({"server.port=0"})
public class ReportWebservicerTest {
	
	
	
	@Value("${local.server.port}")
    private int port;
	private URL base;
	
	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
	}
	
	
	@Test
	public void test(){
		ReportRequest reportRequest = new ReportRequest();
		
		reportRequest.setSubject("EMAIL");
		
		List<Parameter> parameters = new ArrayList<Parameter>();
		
		Parameter parameter=new Parameter();
		parameter.setKey("loadDate");
		parameter.setValue("12/12/2015");
		
		parameters.add(parameter);
		
	//	reportRequest.setParameters(parameters);
		
		
		
		try {
			System.out.println("     "+reportRequest.toJSONString()  );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
