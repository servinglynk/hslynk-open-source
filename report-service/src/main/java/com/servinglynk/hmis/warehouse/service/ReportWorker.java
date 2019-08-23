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
import com.servinglynk.hmis.warehouse.core.model.ReportConfig;
import com.servinglynk.hmis.warehouse.core.model.ReportConfigs;

@Component
@Service
public class ReportWorker implements IReportWorker  {
	
	final static Logger logger = Logger.getLogger(ReportWorker.class);

	@Autowired
	NotificationServiceClient notificationServiceClient;
	
	@Autowired
	protected BaseServiceFactory serviceFactory;
	
	@Transactional
	@Scheduled(initialDelay=20,fixedDelay=10000)
	public void processReportWorkerLine() throws Exception{

					try{
						ReportConfigs reportConfigs = serviceFactory.getReportConfigService().getReportConfigByStatusEmailSent("COMPLETED",false);
						if(reportConfigs != null) {
							List<ReportConfig> reportConfigs2 = reportConfigs.getReportConfigs();
							if(CollectionUtils.isNotEmpty(reportConfigs2)) {
								for(ReportConfig reportConfig :  reportConfigs2) {
									if(reportConfig != null) {
										Notification notification = new Notification();
										notification.setMethod("EMAIL");
										notification.setType("HMIS_EMAIL_NOTIFICATION");
										notification.getParameters().addParameter(new Parameter("subject", "Hslynk: Your Apr Report"+reportConfig.getName() +" is ready!"));
										StringBuilder builder = new StringBuilder();
//										builder.append(" Dear Customer, Your Apr Report \""+reportConfig.getName() +"\" is ready! ");
//										builder.append("\n");
//										builder.append(" Login to the HsLynk's admin application to download your report. ");
//										builder.append("\n");
//										builder.append(" Thanks ");
//										builder.append("\n");
//										builder.append(" Hslynk Team ");
										builder.append("Dear Customer, Your Apr Report \"CHH_Permanent Housing\" is ready!\nLogin to the HsLynk's admin application to download your report.\nhttps://admin.hmislynk.com/\n Thanks \n Hslynk Team ");
										notification.getParameters().addParameter(new Parameter("message", builder.toString()));
										notification.setSender("support@hmislynk.com");
										notification.getRecipients().addToRecipient("sandeep.dolia@gmail.com");
										notificationServiceClient.createNotification(notification);	
										ReportConfig reportConfigById = serviceFactory.getReportConfigService().getReportConfigById(reportConfig.getId());
										reportConfigById.setEmailSent(true);
										serviceFactory.getReportConfigService().updateReportConfig(reportConfig.getId(), reportConfigById, reportConfig.getUsername());
									}
							   }
						   }
						}
					}catch(Exception e){
						 logger.info("Report Creation failed ::::" + e.getMessage());
						 e.printStackTrace();
					}

	}
	

}
