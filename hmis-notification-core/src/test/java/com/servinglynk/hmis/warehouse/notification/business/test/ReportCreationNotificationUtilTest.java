package com.servinglynk.hmis.warehouse.notification.business.test;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.servinglynk.hmis.warehouse.core.model.Notification;
import com.servinglynk.hmis.warehouse.notification.business.service.NotificationWorker;
import com.servinglynk.hmis.warehouse.notification.business.service.core.ParentServiceFactory;
import com.servinglynk.hmis.warehouse.notification.business.util.ReportCreationNotificationUtil;
import com.servinglynk.hmis.warehouse.notification.config.SpringConfig;

@ContextConfiguration(classes=SpringConfig.class, loader=AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class ReportCreationNotificationUtilTest {
	

	@Autowired
	ParentServiceFactory serviceFactory;
	
	@Autowired
	ReportCreationNotificationUtil reportCreationNotificationUtil;
	
	@Autowired
	NotificationWorker notificationWorker;
	
	@Before
	public void init() {
		
	}

	@Test
	public void testNotificationWorker() throws Exception {
		System.out.println(reportCreationNotificationUtil.getNotificationParams());
	}
	
/*	
	
	@Test
	public void testSendNotification()  {
		try{
		Notification rr = new Notification();
		ArrayList<String> recipients = new ArrayList<String>();
			recipients.add("surya.yadavalli@gmail.com");
		
		rr.setRecipients(recipients);
		rr.setType("REPORT_NOTIFICATION");
		rr.setMethod("EMAIL");
		rr.setAttachment("D:\\text.txt");
		
		
		reportCreationNotificationUtil.sendnotification(rr);
		notificationWorker.processWorkerLine();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testProcessNotifications(){
		try {
			notificationWorker.processWorkerLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testCreateNotification() throws Exception {
		Notification notification = new Notification();
		ArrayList<String> recipients = new ArrayList<String>();
		recipients.add("surya.yadavalli@gmail.com");
	
		notification.setRecipients(recipients);
		notification.setType("REPORT_NOTIFICATION");
		notification.setMethod("EMAIL");
		notification.setAttachment("D:\\text.txt");
		
		reportCreationNotificationUtil.sendnotification(notification);
	}
	
	

	@Test	
	public void testCreateNotificationWithWrongType() throws IllegalArgumentException {

		Notification notification = new Notification();
		ArrayList<String> recipients = new ArrayList<String>();
		recipients.add("surya.yadavalli@gmail.com");
	
		notification.setRecipients(recipients);
		notification.setType("EMAIL_NOTIFICATION");
		notification.setMethod("EMAIL");
		notification.setAttachment("D:\\text.txt");
		
		reportCreationNotificationUtil.sendnotification(notification);
		
		
	}
	
	
	@Test
	public void testCreateNotificationWithoutRecipients() throws NullPointerException {
		
		
		Notification notification = new Notification();
		ArrayList<String> recipients = new ArrayList<String>();
		recipients.add("surya.yadavalli@gmail.com");
	
//		notification.setRecipients(recipients);
		notification.setType("REPORT_NOTIFICATION");
		notification.setMethod("EMAIL");
		notification.setAttachment("D:\\text.txt");
		
		reportCreationNotificationUtil.sendnotification(notification);
	}
	
	@Test
	public void testCreateNotitifcaionNoToAddandWrongType()  throws IllegalArgumentException
	{
		Notification notification = new Notification();
		ArrayList<String> recipients = new ArrayList<String>();
		recipients.add("surya.yadavalli@gmail.com");
	
	//	notification.setRecipients(recipients);
		notification.setType("EMAIL_NOTIFICATION");
		notification.setMethod("EMAIL");
		notification.setAttachment("D:\\text.txt");
		
		reportCreationNotificationUtil.sendnotification(notification);
		
		
	}
	
	

	@Test	
	public void testProcessNotificationWithWrongType() throws IllegalArgumentException {

		Notification notification = new Notification();
		ArrayList<String> recipients = new ArrayList<String>();
		recipients.add("surya.yadavalli@gmail.com");
	
		notification.setRecipients(recipients);
		notification.setType("EMAIL_NOTIFICATION");
		notification.setMethod("EMAIL");
		notification.setAttachment("D:\\text.txt");
		
		reportCreationNotificationUtil.sendnotification(notification);
		try {
			notificationWorker.processWorkerLine();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void testProcessNotificationWithoutRecipients() throws NullPointerException {
		
		
		Notification notification = new Notification();
		ArrayList<String> recipients = new ArrayList<String>();
		recipients.add("surya.yadavalli@gmail.com");
	
//		notification.setRecipients(recipients);
		notification.setType("REPORT_NOTIFICATION");
		notification.setMethod("EMAIL");
		notification.setAttachment("D:\\text.txt");
		
		reportCreationNotificationUtil.sendnotification(notification);
		try {
			notificationWorker.processWorkerLine();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testProcessNotitifcaionNoToAddandWrongType()  throws IllegalArgumentException
	{
		Notification notification = new Notification();
		ArrayList<String> recipients = new ArrayList<String>();
		recipients.add("surya.yadavalli@gmail.com");
	
	//	notification.setRecipients(recipients);
		notification.setType("EMAIL_NOTIFICATION");
		notification.setMethod("EMAIL");
		notification.setAttachment("D:\\text.txt");
		
		reportCreationNotificationUtil.sendnotification(notification);
		try {
			notificationWorker.processWorkerLine();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	@Test
	public void testCreateNotificationWithWrongMethod(){
		
		Notification notification = new Notification();
		ArrayList<String> recipients = new ArrayList<String>();
		recipients.add("surya.yadavalli@gmail.com");
	
		notification.setRecipients(recipients);
		notification.setType("REPORT_NOTIFICATION");
		notification.setMethod("MAIL");
		notification.setAttachment("D:\\text.txt");
		
		reportCreationNotificationUtil.sendnotification(notification);
		
	}
	
	
	@Test
	public void testProcessNotificationWithWrongMethod()
	{
		try{
			
			Notification notification = new Notification();
			ArrayList<String> recipients = new ArrayList<String>();
			recipients.add("surya.yadavalli@gmail.com");
		
			notification.setRecipients(recipients);
			notification.setType("REPORT_NOTIFICATION");
			notification.setMethod("MAIL");
			notification.setAttachment("D:\\text.txt");
			
			reportCreationNotificationUtil.sendnotification(notification);
			notificationWorker.processWorkerLine();
			
		}catch(Exception e){
		}
		
	}
	


	@Test
	public void testCreateNotificationWithoutAttachement(){
		
		Notification notification = new Notification();
		ArrayList<String> recipients = new ArrayList<String>();
		recipients.add("surya.yadavalli@gmail.com");
	
		notification.setRecipients(recipients);
		notification.setType("REPORT_NOTIFICATION");
		notification.setMethod("EMAIL");
		//notification.setAttachment("D:\\text.txt");
		
		reportCreationNotificationUtil.sendnotification(notification);
		
	}
	
	
	@Test
	public void testProcessNotificationWithoutAttachement()
	{
		try{
			
			Notification notification = new Notification();
			ArrayList<String> recipients = new ArrayList<String>();
			recipients.add("surya.yadavalli@gmail.com");
		
			notification.setRecipients(recipients);
			notification.setType("REPORT_NOTIFICATION");
			notification.setMethod("EMAIL");
			//notification.setAttachment("D:\\text.txt");
			
			reportCreationNotificationUtil.sendnotification(notification);
			notificationWorker.processWorkerLine();
			
		}catch(Exception e){
		}
		
	}
	
	*/

}
