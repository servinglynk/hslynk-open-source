package com.servinglynk.hmis.warehouse.notification.endpoint.test;

import java.net.URL;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.servinglynk.hmis.warehouse.core.model.Notification;
import com.servinglynk.hmis.warehouse.notification.config.AppConfig;

@WebAppConfiguration
@SpringApplicationConfiguration(classes=AppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@IntegrationTest({"server.port=0"})
public class NotificaionWebserviceTest {


	//@Autowired
	RestTemplate restTemplate; 
	private URL base;
	
	@Value("${local.server.port}")
    private int port;
	
	
	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
		restTemplate = new TestRestTemplate();
	}
	
/*	
	
	@Test
	public void testNotification() throws Exception{

		Notification rr = new Notification();
		ArrayList<String> recipients = new ArrayList<String>();
			recipients.add("surya.yadavalli@broadcom.com");
		
		rr.setRecipients(recipients);
		rr.setType("REPORT_NOTIFICATION");
		rr.setMethod("EMAIL");
		rr.setAttachment("D:\\text.txt");
	

		restTemplate.postForObject(this.base.toString()+"/rest/notifications",rr, Notification.class, new Object[]{}); 
		
	}
	
	@Test
	public void testCreateNotificationWithWrongType(){
		
		Notification rr = new Notification();
		ArrayList<String> recipients = new ArrayList<String>();
			recipients.add("surya.yadavalli@gmail.com");
		
		rr.setRecipients(recipients);
		rr.setType("EMAIL_NOTIFICATION");
		rr.setMethod("EMAIL");
		rr.setAttachment("D:\\text.txt");
	

		restTemplate.postForObject(this.base.toString()+"/rest/notifications",rr, Notification.class, new Object[]{}); 
		
	}
	
	@Test
	public void testCreateNotificationWithoutRecipients(){
		
		Notification rr = new Notification();
		ArrayList<String> recipients = new ArrayList<String>();
			recipients.add("surya.yadavalli@gmail.com");
		
		//rr.setRecipients(recipients);
		rr.setType("REPORT_NOTIFICATION");
		rr.setMethod("EMAIL");
		rr.setAttachment("D:\\text.txt");
	

		restTemplate.postForObject(this.base.toString()+"/rest/notifications",rr, Notification.class, new Object[]{}); 

		
	}
	
	@Test
	public void testCreateNotificationWrongMethod(){
		
		Notification rr = new Notification();
		ArrayList<String> recipients = new ArrayList<String>();
			recipients.add("surya.yadavalli@gmail.com");
		
		rr.setRecipients(recipients);
		rr.setType("REPORT_NOTIFICATION");
		rr.setMethod("MAIL");
		rr.setAttachment("D:\\text.txt");
	

		restTemplate.postForObject(this.base.toString()+"/rest/notifications",rr, Notification.class, new Object[]{}); 

		
	}
	
	
	@Test
	public void testCreateNotificationWithoutAttachement(){
		
		Notification rr = new Notification();
		ArrayList<String> recipients = new ArrayList<String>();
			recipients.add("surya.yadavalli@gmail.com");
		
		rr.setRecipients(recipients);
		rr.setType("REPORT_NOTIFICATION");
		rr.setMethod("EMAIL");
	//	rr.setAttachment("D:\\text.txt");
	

		restTemplate.postForObject(this.base.toString()+"/rest/notifications",rr, Notification.class, new Object[]{}); 
	}
	

	@Test
	public void testCreateNotificationWithAllWrongDtls(){
		
		Notification rr = new Notification();
		ArrayList<String> recipients = new ArrayList<String>();
			recipients.add("surya.yadavalli@gmail.com");
		
		//rr.setRecipients(recipients);
		rr.setType("EMAI_NOTIFICATION");
		rr.setMethod("MAIL");
		rr.setAttachment("D:\\text.txt");
	

		restTemplate.postForObject(this.base.toString()+"/rest/notifications",rr, Notification.class, new Object[]{}); 
		
	}
	
	*/
}

