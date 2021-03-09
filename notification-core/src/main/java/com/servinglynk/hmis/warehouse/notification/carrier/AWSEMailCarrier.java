package com.servinglynk.hmis.warehouse.notification.carrier;

import java.util.Collections;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.servinglynk.hmis.warehouse.core.model.Recipients;
import com.servinglynk.hmis.warehouse.notification.business.exception.CarrierSendFailureException;
import com.servinglynk.hmis.warehouse.notification.common.CoreUtil;


public class AWSEMailCarrier implements ICarrier{
	
	@Autowired private AmazonSimpleEmailService client;

	public void send(final CarrierNotification carrierNotification) throws  CarrierSendFailureException {
		try {
        Recipients recipients = CoreUtil.convertJSONtoJava(carrierNotification.getRecipient(),Recipients.class); 
        // convert recipients JSON string to recipient ibject 
      //  recipients.getToRecipients().toArray();
        recipients.getBccRecipients().removeAll(Collections.singletonList(""));
        recipients.getBccRecipients().removeAll(Collections.singletonList(" "));
        recipients.getBccRecipients().removeAll(Collections.singletonList(null));
		
        recipients.getCcRecipients().removeAll(Collections.singletonList(""));
        recipients.getCcRecipients().removeAll(Collections.singletonList(" "));
        recipients.getCcRecipients().removeAll(Collections.singletonList(null));
		
        recipients.getToRecipients().removeAll(Collections.singletonList(""));
        recipients.getToRecipients().removeAll(Collections.singletonList(" "));
        recipients.getToRecipients().removeAll(Collections.singletonList(null));
        
        Destination destination = new Destination();
        
        if(!recipients.getToRecipients().isEmpty())
        	destination.setToAddresses(recipients.getToRecipients());  
        
        if(!recipients.getBccRecipients().isEmpty())
        	destination.setBccAddresses(recipients.getBccRecipients());  
        
        if(!recipients.getCcRecipients().isEmpty())
        	destination.setCcAddresses(recipients.getCcRecipients());


		
	      SendEmailRequest request = new SendEmailRequest()
	              .withDestination(
	            		  destination)
	              .withMessage(new Message()
	                  .withBody(new Body()
	                      .withHtml(new Content()
	                          .withCharset("UTF-8").withData(carrierNotification.getContent())))
	                  .withSubject(new Content()
	                      .withCharset("UTF-8").withData(carrierNotification.getSubject())))
	              .withSource(carrierNotification.getSender());
	          client.sendEmail(request);
		}catch(Exception e ){
    		
    		throw new CarrierSendFailureException("Unable to send notification :"+ e.getMessage());
    }
	}
	
	
	public void sendOld(final CarrierNotification carrierNotification) throws CarrierSendFailureException{
		 MimeMessagePreparator preparator = new MimeMessagePreparator() {
	            public void prepare(MimeMessage mimeMessage) throws Exception {
	               MimeMessageHelper message = new MimeMessageHelper(mimeMessage,true);
	               
	               Recipients recipients = CoreUtil.convertJSONtoJava(carrierNotification.getRecipient(),Recipients.class); 
	               // convert recipients JSON string to recipient ibject 
	             //  recipients.getToRecipients().toArray();
	               recipients.getBccRecipients().removeAll(Collections.singletonList(""));
	               recipients.getBccRecipients().removeAll(Collections.singletonList(" "));
	               recipients.getBccRecipients().removeAll(Collections.singletonList(null));
	    		
	               recipients.getCcRecipients().removeAll(Collections.singletonList(""));
	               recipients.getCcRecipients().removeAll(Collections.singletonList(" "));
	               recipients.getCcRecipients().removeAll(Collections.singletonList(null));
	    		
	               recipients.getToRecipients().removeAll(Collections.singletonList(""));
	               recipients.getToRecipients().removeAll(Collections.singletonList(" "));
	               recipients.getToRecipients().removeAll(Collections.singletonList(null));
	               
	               if(!recipients.getToRecipients().isEmpty())
	            	message.setTo(recipients.getToRecipients().toArray(new String[recipients.getToRecipients().size()]));  
	               
	               if(!recipients.getBccRecipients().isEmpty())
	               message.setBcc((String[])recipients.getBccRecipients().toArray(new String[recipients.getBccRecipients().size()]));  
	               
	               if(!recipients.getCcRecipients().isEmpty())
	               message.setCc((String[])recipients.getCcRecipients().toArray(new String[recipients.getCcRecipients().size()]));
	               
	               message.setFrom(carrierNotification.getSender());
	               message.setSubject(carrierNotification.getSubject());
	               message.setText(carrierNotification.getContent(), true);
	              message.setPriority(carrierNotification.getPriority());
			            if(carrierNotification.getAttachment() !=null){
			       		FileSystemResource attachment = new FileSystemResource(carrierNotification.getAttachment());
			       		message.addAttachment(attachment.getFilename(), attachment);
			            }
	            }
	         };
	        try{
	        //	this.send(preparator);
	        }catch(Exception e ){
	        		
	        		throw new CarrierSendFailureException("Unable to send notification :"+ e.getMessage());
	        }
	}
}
