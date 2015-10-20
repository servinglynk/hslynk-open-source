package com.servinglynk.hmis.warehouse.notification.business.util;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.core.model.NotificationHeader;
import com.servinglynk.hmis.warehouse.core.model.Originator;
import com.servinglynk.hmis.warehouse.core.model.Recipient;
import com.servinglynk.hmis.warehouse.core.model.Template;
import com.servinglynk.hmis.warehouse.core.model.WorkerLine;
import com.servinglynk.hmis.warehouse.notification.business.service.core.ParentService;
import com.servinglynk.hmis.warehouse.notification.business.service.core.ParentServiceFactory;
import com.servinglynk.hmis.warehouse.notification.carrier.Workers;


public abstract class NotificationUtil  extends ParentService  implements INotificationUtil {
	
	@Autowired
    protected HashMap<String,NotificationParams> notificationParams;
	

 
	 public HashMap<String,NotificationParams> getNotificationParams() {
		return notificationParams;
	}

	public void setNotificationParams(HashMap<String,NotificationParams> notificationParams) {
		this.notificationParams = notificationParams;
	}

	public ParentServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public void setServiceFactory(ParentServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}

	@Autowired
	 ParentServiceFactory serviceFactory;
	 

	
	protected Originator createOriginator(String receiverEmail, String senderEmail, String senderFriendlyName,String not) {
		Originator originator = new Originator();
		originator.setId(receiverEmail);
		originator.setType(not.toString());
		originator.setSender(senderEmail);
		originator.setSenderFriendly(senderFriendlyName);
		return originator;
	}

	protected Template createTemplate(String templateId) {
		Template template = new Template();
		template.setExternalId(templateId);
		return template;
	}

	protected Recipient createRecipient(String username, String deliverTo, String templateId,String nm) {
		Recipient recipient = new Recipient();
		recipient.setUsername(username);		
		recipient.setDeliveryMethod(nm);
		recipient.setDeliverTo(deliverTo);
		recipient.setTemplateId(templateId);
		return recipient;
	}
	
	protected  void createWorkerLine(NotificationHeader nh){
		WorkerLine wl = new WorkerLine();
		wl.setWorkerHeaderId(Workers.NOTIFICATION_WORKER.toString());
		wl.setInput(nh.toString());
		serviceFactory.getWorkerService().createWorkerLine(wl);
	}
}
