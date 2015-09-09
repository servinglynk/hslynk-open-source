package com.servinglynk.hmis.warehouse.notification.carrier;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class TestEmail {
	

	 
		static Properties mailServerProperties;
		static Session getMailSession;
		static MimeMessage generateMailMessage;
	 
		public static void main(String args[]) throws AddressException, MessagingException {
			generateAndSendEmail();
			System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
		}
	 
		public static void generateAndSendEmail() throws AddressException, MessagingException {
	 
	//Step1		
			System.out.println("\n 1st ===> setup Mail Server Properties..");
			mailServerProperties = System.getProperties();
			mailServerProperties.put("mail.smtp.host", "smtphost.broadcom.com");
			mailServerProperties.put("mail.smtp.port", "25");
			mailServerProperties.put("mail.smtp.auth", "true");
			mailServerProperties.put("mail.smtp.starttls.enable", "true");
			System.out.println("Mail Server Properties have been setup successfully..");
	 
	//Step2		
			System.out.println("\n\n 2nd ===> get Mail Session..");
			getMailSession = Session.getDefaultInstance(mailServerProperties, null);
			generateMailMessage = new MimeMessage(getMailSession);
			generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("surya.yadavalli@broadcom.com"));
			generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("danielku@broadcom.com"));
			generateMailMessage.setSubject("Test..");
			String emailBody = "Test email by Broadcom domain. " + "<br><br> Regards, <br>Surya Yadavalli";
			generateMailMessage.setContent(emailBody, "text/html");
			System.out.println("Mail Session has been created successfully..");
	 
	//Step3		
			System.out.println("\n\n 3rd ===> Get Session and Send mail");
			Transport transport = getMailSession.getTransport("smtp");
			
			// Enter your correct gmail UserID and Password (XXXApp Shah@gmail.com)
			transport.connect("smtphost.broadcom.com", "suryay", "satyaX0109");
			transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
			transport.close();
		}
	}


