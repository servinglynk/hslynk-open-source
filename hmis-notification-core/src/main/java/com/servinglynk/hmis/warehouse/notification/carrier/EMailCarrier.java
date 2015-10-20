package com.servinglynk.hmis.warehouse.notification.carrier;

import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import com.servinglynk.hmis.warehouse.core.model.Recipients;
import com.servinglynk.hmis.warehouse.notification.business.exception.CarrierSendFailureException;
import com.servinglynk.hmis.warehouse.notification.common.CoreUtil;


public class EMailCarrier  extends JavaMailSenderImpl implements ICarrier{
	
	
	
	public void send(final CarrierNotification carrierNotification) throws CarrierSendFailureException{
		 MimeMessagePreparator preparator = new MimeMessagePreparator() {
	            public void prepare(MimeMessage mimeMessage) throws Exception {
	               MimeMessageHelper message = new MimeMessageHelper(mimeMessage,true);
	               
	               Recipients recipients = CoreUtil.convertJSONtoJava(carrierNotification.getRecipient(),Recipients.class); 
	               // convert recipients JSON string to recipient ibject 
	               recipients.getToRecipients().toArray();
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
	        	this.send(preparator);
	        }catch(Exception e ){
	        		
	        		throw new CarrierSendFailureException("Unable to send notification :"+ e.getMessage());
	        }
	}
}
