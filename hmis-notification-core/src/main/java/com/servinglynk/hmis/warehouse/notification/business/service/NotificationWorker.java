package com.servinglynk.hmis.warehouse.notification.business.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.servinglynk.hmis.warehouse.core.model.NotificationHeader;
import com.servinglynk.hmis.warehouse.core.model.Recipient;
import com.servinglynk.hmis.warehouse.core.model.WorkerLine;
import com.servinglynk.hmis.warehouse.notification.business.converter.NotificationConverter;
import com.servinglynk.hmis.warehouse.notification.business.converter.WorkerLineConverter;
import com.servinglynk.hmis.warehouse.notification.business.service.core.ParentService;
import com.servinglynk.hmis.warehouse.notification.carrier.Workers;
import com.servinglynk.hmis.warehouse.notification.common.Constants;
import com.servinglynk.hmis.warehouse.notification.common.CoreUtil;
import com.servinglynk.hmis.warehouse.notification.common.Constants.NotificationStatus;
import com.servinglynk.hmis.warehouse.notification.framework.NotificationEngine;
import com.servinglynk.hmis.warehouse.notification.framework.NotificationWork;
import com.servinglynk.hmis.warehouse.notification.persistence.entity.HMISNotificationEntity;
import com.servinglynk.hmis.warehouse.notification.persistence.entity.NotificationHeaderEntity;
import com.servinglynk.hmis.warehouse.notification.persistence.entity.NotificationLineEntity;
import com.servinglynk.hmis.warehouse.notification.persistence.entity.TemplateHeaderEntity;
import com.servinglynk.hmis.warehouse.notification.persistence.entity.WorkerLineEntity;

@Component
@Service
public class NotificationWorker  extends ParentService implements INotificationWorker  {
	
	@Autowired
	NotificationEngine notificationEngine;
   
	
	public NotificationEngine getNotificationEngine() {
		return notificationEngine;
	}

	@Scheduled(initialDelay=20,fixedDelay=10000)
	public void processWorkerLine() throws Exception{
		
		List<WorkerLineEntity> workerLineEntities=  daoFactory.getWorkerLineDao().findUnprocessedByExternalId(Workers.NOTIFICATION_WORKER.getWorker());
		Iterator<WorkerLineEntity> wleIterator = workerLineEntities.iterator();
		
		while(wleIterator.hasNext()){
			WorkerLineEntity wle = wleIterator.next();
			  WorkerLine workerLine = WorkerLineConverter.convertEntityToModel(wle);
			  //When you create a worker line request, you create a request that has the Input matches with Notification header
			  NotificationHeader headerModel = CoreUtil.convertJSONtoJava(workerLine.getInput(), NotificationHeader.class);
			  
			  // This is header entity for all recipients
			  NotificationHeaderEntity notifcationHeaderEntity = NotificationConverter.convertModelToEntity(headerModel, new NotificationHeaderEntity());
			  
			  notifcationHeaderEntity.setStatus(NotificationStatus.INIT.toString());
			  notifcationHeaderEntity.setInsertAt(new Date());
			  	daoFactory.getNotificationHeaderDao().create(notifcationHeaderEntity);
				
			//	ArrayList<NotificationWork> workList = new ArrayList<NotificationWork>();
				// This is individual recipient 
			  		Recipient recipient = headerModel.getRecipient();
					NotificationLineEntity notificationLineEntity= NotificationConverter.toNotificationLineEntity(recipient);
					notificationLineEntity.setNotificationHeaderEntity(notifcationHeaderEntity);
					notificationLineEntity.setCarrierAttempts(0);
					notificationLineEntity.setAttempts(0);
					notificationLineEntity.setExternalId(CoreUtil.createUniqueID(false));
					notificationLineEntity.setStatusMessage(CoreUtil.emptyString());
					
					// If we have any templates set here.
					TemplateHeaderEntity thEntity = daoFactory.getTemplateLineDao().findTemplateHeader(recipient.getTemplateId()); //REPORT_NOTIFICATION_TEMPLATE
					if(thEntity!=null)  notificationLineEntity.setTemplate(thEntity); //this is exactly where its setting the value to 1
					
					notificationLineEntity.setStatus(NotificationStatus.INIT);
					notificationLineEntity.setInsertAt(new Date());
					daoFactory.getNotificationLineDao().create(notificationLineEntity);
	
					NotificationWork worker = new NotificationWork();
					worker.setNotificationLineEntity(notificationLineEntity);
					worker.setSender(notifcationHeaderEntity.getSender());
					//notification data should be set here to Notification work.
					worker.setSenderFriendly(headerModel.getOriginator().getSenderFriendly());
					worker.setNotificationData(headerModel.getNotificationData());
					worker.setAttachment(headerModel.getAttachment());
					worker.setPriority(headerModel.getPriority());
					//to-do - move it to Thread pool executor
					try{
						System.out.println("worker line id "+wle.getId());
						if(wle.getNotificationId()!=null) {
							HMISNotificationEntity entity = daoFactory.getHmIhmisNotificationDao().getHmisNotification(wle.getNotificationId());
							if(entity!=null) daoFactory.getHmIhmisNotificationDao().updateNotificationStatus(entity, Constants.JOB_PROCESSING, "");
						}
						notificationEngine.processNotificationWork(worker);
						wle.setStatus(Constants.JOB_SUCCEEDED);
						wle.setUpdateAt(new Date());
						daoFactory.getWorkerLineDao().update(wle);
						if(wle.getNotificationId()!=null) {
							HMISNotificationEntity entity = daoFactory.getHmIhmisNotificationDao().getHmisNotification(wle.getNotificationId());
							if(entity!=null) {
								entity.setDeliveredAt(new Date());
								daoFactory.getHmIhmisNotificationDao().updateNotificationStatus(entity, Constants.JOB_DELIVERED, "");
							}
						}
					}catch (Exception e) {
						wle.setStatus(Constants.JOB_FAILED);
						wle.setUpdateAt(new Date());
						wle.setLineOutput(e.getMessage());
						wle.setCurrRetry(wle.getCurrRetry()+1);
						daoFactory.getWorkerLineDao().update(wle);
						if(wle.getNotificationId()!=null) {
							HMISNotificationEntity entity = daoFactory.getHmIhmisNotificationDao().getHmisNotification(wle.getNotificationId());
							if(entity!=null) daoFactory.getHmIhmisNotificationDao().updateNotificationStatus(entity, Constants.JOB_FAILED, e.getMessage());
						}
					}

			
		}
	}
	

}
