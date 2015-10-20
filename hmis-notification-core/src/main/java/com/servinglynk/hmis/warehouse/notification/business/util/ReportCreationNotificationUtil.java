package com.servinglynk.hmis.warehouse.notification.business.util;

import java.util.ArrayList;

import com.servinglynk.hmis.warehouse.core.model.Notification;
import com.servinglynk.hmis.warehouse.core.model.NotificationHeader;
import com.servinglynk.hmis.warehouse.core.model.Originator;
import com.servinglynk.hmis.warehouse.core.model.Parameters;
import com.servinglynk.hmis.warehouse.core.model.Recipient;
import com.servinglynk.hmis.warehouse.notification.common.Constants.NotificationMethod;
import com.servinglynk.hmis.warehouse.notification.common.Constants.NotificationOriginatorType;


public class ReportCreationNotificationUtil extends NotificationUtil {


	public void sendnotification(Notification notification) throws Exception{
		
		NotificationEnum type = NotificationEnum.valueOf(notification.getType());
		//To Do - throw exception if wrong value is passed.
		NotificationParams nps = notificationParams.get(type.toString());

		NotificationHeader header = new NotificationHeader();
		Originator originator = createOriginator(nps.getSenderEmailAddress(), nps.getSenderEmailAddress(),
				nps.getSenderFriendlyName(), NotificationOriginatorType.USER.toString());

		NotificationMethod method = NotificationMethod.valueOf(notification.getMethod());
		
		Recipient recipent = createRecipient(notification.getRecipients().toJSONString(),
				notification.getRecipients().toJSONString(), nps.getTemplateId(),
				method.toString());

				

		Parameters data = new Parameters();
		/*
		NotificationData data = new NotificationData();
		data.addDataElement("reportName", reportName);
		*/
		
		header.setOriginator(originator);
		// there could be multiple recipients - if we have more subscribers for the report.
		header.setRecipient(recipent);
		header.setNotificationData(data);
		header.setAttachment(notification.getAttachment());

		createWorkerLine(header);
	}


	
}
