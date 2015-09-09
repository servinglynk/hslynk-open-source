package com.servinglynk.hmis.warehouse.notification.business.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.core.model.Notification;
import com.servinglynk.hmis.warehouse.core.model.NotificationHeader;
import com.servinglynk.hmis.warehouse.core.model.Originator;
import com.servinglynk.hmis.warehouse.core.model.Parameters;
import com.servinglynk.hmis.warehouse.core.model.Recipient;
import com.servinglynk.hmis.warehouse.notification.business.util.NotificationEnum;
import com.servinglynk.hmis.warehouse.notification.business.util.NotificationParams;
import com.servinglynk.hmis.warehouse.notification.business.util.NotificationUtil;
import com.servinglynk.hmis.warehouse.notification.common.Constants.NotificationMethod;
import com.servinglynk.hmis.warehouse.notification.common.Constants.NotificationOriginatorType;

@Component
public class NotificationService extends NotificationUtil implements INotificationService {

	
	public void createNotificationJob(Notification notification) {
		
		NotificationEnum type = NotificationEnum.valueOf(notification.getType());
		//To do - surya 03/26 -throw exception if wrong value is passed.
		NotificationParams nps = notificationParams.get(type.toString());

		NotificationHeader header = new NotificationHeader();
		Originator originator = createOriginator(nps.getSenderEmailAddress(), nps.getSenderEmailAddress(),
				nps.getSenderFriendlyName(), NotificationOriginatorType.USER.toString());

		NotificationMethod method = NotificationMethod.valueOf(notification.getMethod());
				
		ArrayList<Recipient> recipents = new ArrayList<Recipient>();
		for(String recipient : notification.getRecipients()){
				Recipient recipent = createRecipient(recipient,
						recipient, nps.getTemplateId(),
						method.toString());
				recipents.add(recipent);
		}
		
		Parameters data = new Parameters();

		header.setOriginator(originator);
		// there could be multiple recipients - if we have more subscribers for the report.
		header.setRecipients(recipents);
		header.setNotificationData(data);
		header.setAttachment(notification.getAttachment());
		createWorkerLine(header);
		
	}

	
}
