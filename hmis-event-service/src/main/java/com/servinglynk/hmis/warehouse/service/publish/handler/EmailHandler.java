package com.servinglynk.hmis.warehouse.service.publish.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servinglynk.hmis.entity.SubscriptionEntity;
import com.servinglynk.hmis.warehouse.client.notificationservice.INotificationServiceClient;
import com.servinglynk.hmis.warehouse.client.notificationservice.NotificationServiceClient;
import com.servinglynk.hmis.warehouse.core.model.Notification;
import com.servinglynk.hmis.warehouse.core.model.Parameter;
import com.servinglynk.hmis.warehouse.core.model.Recipients;

@Service("emailHandler")
public class EmailHandler implements EventPublisher {
	
	@Autowired INotificationServiceClient notificationServiceClient;

	@Override
	public void publish(SubscriptionEntity entity) {
		System.out.println("inside email handelr");
		
		Notification notification = new Notification();
		notification.setMethod("EMAIL");
		notification.setType("HMIS_EMAIL_NOTIFICATION");
		notification.getParameters().addParameter(new Parameter("message", "enrollment information is updated. "+entity.getCriteriaUrl()+"get updated information"));
		notification.getParameters().addParameter(new Parameter("subject", "Subscription Update"));
		Recipients recipients = new Recipients();
		recipients.addToRecipient(entity.getChannelEndpoint());
//		notification.getRecipients().getToRecipients().add(entity.getChannelEndpoint());
		notification.setRecipients(recipients);
		notificationServiceClient.createNotification(notification);
		
	}

}
