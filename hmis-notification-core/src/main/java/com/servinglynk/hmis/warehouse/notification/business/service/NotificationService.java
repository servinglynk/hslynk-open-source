package com.servinglynk.hmis.warehouse.notification.business.service;

import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Notification;
import com.servinglynk.hmis.warehouse.core.model.NotificationHeader;
import com.servinglynk.hmis.warehouse.core.model.Notifications;
import com.servinglynk.hmis.warehouse.core.model.Originator;
import com.servinglynk.hmis.warehouse.core.model.Parameters;
import com.servinglynk.hmis.warehouse.core.model.Recipient;
import com.servinglynk.hmis.warehouse.core.model.SearchRequest;
import com.servinglynk.hmis.warehouse.notification.business.exception.NotifcationException;
import com.servinglynk.hmis.warehouse.notification.business.exception.WorkerNotFoundException;
import com.servinglynk.hmis.warehouse.notification.business.util.NotificationUtil;
import com.servinglynk.hmis.warehouse.notification.common.Constants.NotificationMethod;
import com.servinglynk.hmis.warehouse.notification.common.Constants.NotificationOriginatorType;
import com.servinglynk.hmis.warehouse.notification.persistence.entity.NotificationParamEntity;

@Component
public class NotificationService extends NotificationUtil implements INotificationService {

	
	public void createNotificationJob(Notification notification) throws WorkerNotFoundException,NotifcationException {
		
		NotificationParamEntity nps = daoFactory.getNotificationHeaderDao().getNotificationParamByNotificationType(notification.getType());
		Recipient recipent =   null;
		if(nps!=null){
		
		NotificationHeader header = new NotificationHeader();
		Originator originator = createOriginator(nps.getSenderEmailAddress(), nps.getSenderEmailAddress(),
				nps.getSenderFriendlyName(), NotificationOriginatorType.USER.toString());

		NotificationMethod method = NotificationMethod.valueOf(notification.getMethod());
		try{
				recipent = createRecipient(notification.getRecipients().toJSONString(),
				notification.getRecipients().toJSONString(), nps.getTemplateId(),
				method.toString());
		}catch(Exception e){
				throw new NotifcationException("Unable to process recipients ");
		}
		
		Parameters data = notification.getParameters();

		header.setOriginator(originator);
		// there could be multiple recipients - if we have more subscribers for the report.
		header.setRecipient(recipent);
		header.setNotificationData(data);
		header.setPriority(notification.getPriority()!=null?notification.getPriority():0);
		header.setAttachment(notification.getAttachment());
		createWorkerLine(header);
		}else{
			throw new NotifcationException("Notification  type "+ notification.getType() +" not found ");
		}
	}
	
	
	public Notifications searchNotifications(SearchRequest searchRequest){
		Notifications dbSearchResult = new Notifications();
		//lets assume that this is coming from the DB. We will use the "start" and "limit" values to get the data from the DB. Also, we pass "sort" field to the DB query.
		// but for our sample implementation, we are not using these fields now, but then using while sending the response back.
		
		//assume that the for loop below just builds the database.
		for(int size=0;size <100; size++){
			 Notification notification  = new Notification();
			 notification.setMethod("EMAIL");
			 dbSearchResult.addNotification(notification);
		}
		
		// from 30  and looking for 10 records in one go - then start from pagination.getFrom() and lead up to pagination.getFrom()+ pagination.getMaximum();
		SortedPagination  pagination = searchRequest.getPagination();
		Notifications returnList = new Notifications();
		
		SortedPagination resultPagianation = new SortedPagination();
		resultPagianation.setFrom(pagination.getFrom());
		resultPagianation.setMaximum(pagination.getMaximum());
		resultPagianation.setTotal(dbSearchResult.getNotifications().size());
		resultPagianation.setReturned(pagination.getMaximum()); 
		
		for(int index=pagination.getFrom();index <pagination.getFrom()+ pagination.getMaximum(); index++){
			returnList.addNotification(dbSearchResult.getNotification(index));
		}
		returnList.setPagination(resultPagianation);

		return returnList;
	}

	
}
