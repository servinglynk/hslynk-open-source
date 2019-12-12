package com.servinglynk.hmis.warehouse.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.service.core.BaseServiceFactory;
import com.servinglynk.hmis.warehouse.client.notificationservice.NotificationServiceClient;
import com.servinglynk.hmis.warehouse.core.model.Notification;
import com.servinglynk.hmis.warehouse.core.model.Parameter;
import com.servinglynk.hmis.warehouse.core.model.FileExport;
import com.servinglynk.hmis.warehouse.core.model.FileExports;

@Component
@Service
public class FileExportWorker implements IFileExportWorker  {
	
	final static Logger logger = Logger.getLogger(FileExportWorker.class);

	@Autowired
	NotificationServiceClient notificationServiceClient;
	
	@Autowired
	protected BaseServiceFactory serviceFactory;
	
	@Transactional
	@Scheduled(initialDelay=20,fixedDelay=10000)
	public void processtWorkerLine() throws Exception{

					try{
						FileExports reportConfigs = serviceFactory.getFileExportService().getFileExportByStatusEmailSent("COMPLETED",false);
						if(reportConfigs != null) {
							List<FileExport> reportConfigs2 = reportConfigs.getFileExports();
							if(CollectionUtils.isNotEmpty(reportConfigs2)) {
								for(FileExport reportConfig :  reportConfigs2) {
									if(reportConfig != null) {
										Notification notification = new Notification();
										notification.setMethod("EMAIL");
										notification.setType("HMIS_EMAIL_NOTIFICATION");
										notification.getParameters().addParameter(new Parameter("subject", "Hslynk: Your file export request "+reportConfig.getName() +" is ready!"));
										StringBuilder builder = new StringBuilder();
										builder.append(" Dear Customer, ");
										builder.append(" <br/> ");
										builder.append(" Your file export  \""+reportConfig.getName() +"\" is ready! ");
										builder.append(" <br/> ");
										builder.append(" Login to the HsLynk's admin application to download your report. ");
										builder.append(" <br/> ");
										builder.append(" https://admin.hslynk.com/ ");
										builder.append(" <br/> ");
										builder.append(" <br/> ");
										builder.append(" Thanks ");
										builder.append(" <br/>  ");
										builder.append(" HSLynk Team ");
									//	builder.append("Dear Customer, Your Apr Report \"CHH_Permanent Housing\" is ready!\nLogin to the HsLynk's admin application to download your report.\nhttps://admin.hmislynk.com/\n Thanks \n Hslynk Team ");
										notification.getParameters().addParameter(new Parameter("message", builder.toString()));
										notification.setSender("support@hslynk.com");
										notification.getRecipients().addToRecipient(reportConfig.getCreatedBy());
										notificationServiceClient.createNotification(notification);	
										FileExport reportConfigById = serviceFactory.getFileExportService().getFileExportById(reportConfig.getId());
										reportConfigById.setEmailSent(true);
										serviceFactory.getFileExportService().updateFileExport(reportConfig.getId(), reportConfigById, reportConfig.getUsername());
									}
							   }
						   }
						}
					}catch(Exception e){
						 logger.info("Export Creation failed ::::" + e.getMessage());
						 e.printStackTrace();
					}

	}
	

}
