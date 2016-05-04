package com.servinglynk.hmis.warehouse.report.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.client.model.Notification;
import com.servinglynk.hmis.warehouse.client.model.Recipients;
import com.servinglynk.hmis.warehouse.client.notificationservice.NotificationServiceClient;
import com.servinglynk.hmis.warehouse.client.reportservice.ReportServiceClient;
import com.servinglynk.hmis.warehouse.core.model.ReportHeader;
import com.servinglynk.hmis.warehouse.core.model.ReportRequest;
import com.servinglynk.hmis.warehouse.core.model.ReportResult;
import com.servinglynk.hmis.warehouse.core.model.WorkerLine;
import com.servinglynk.hmis.warehouse.report.business.converter.ReportConverter;
import com.servinglynk.hmis.warehouse.report.business.converter.WorkerLineConverter;
import com.servinglynk.hmis.warehouse.report.business.exception.ReportCreationException;
import com.servinglynk.hmis.warehouse.report.business.service.core.ParentService;
import com.servinglynk.hmis.warehouse.report.business.util.CoreUtil;
import com.servinglynk.hmis.warehouse.report.business.util.ReportType;
import com.servinglynk.hmis.warehouse.report.business.util.Workers;
import com.servinglynk.hmis.warehouse.report.common.Constants;
import com.servinglynk.hmis.warehouse.report.config.ReportConfig;
import com.servinglynk.hmis.warehouse.report.persistence.entity.ReportHeaderEntity;
import com.servinglynk.hmis.warehouse.report.persistence.entity.ReportLineEntity;
import com.servinglynk.hmis.warehouse.report.persistence.entity.ReportRecipientEntity;
import com.servinglynk.hmis.warehouse.report.persistence.entity.WorkerLineEntity;
import com.servinglynk.hmis.warehouse.report.request.handler.ReportRequestHandlerFactory;

@Component
@Service
public class ReportWorker  extends ParentService implements IReportWorker  {
	
	final static Logger logger = Logger.getLogger(ReportWorker.class);

	public ReportRequestHandlerFactory getReportRequestHandlerFactory() {
		return reportRequestHandlerFactory;
	}
	

	@Autowired
	ReportRequestHandlerFactory reportRequestHandlerFactory;
	
	@Autowired
	NotificationServiceClient notificationServiceClient;
	
	@Autowired
	ReportServiceClient reportServiceClient;
	
	@Autowired
	ReportConfig reportConfig;
	
	@Transactional
	@Scheduled(initialDelay=20,fixedDelay=10000)
	public void processReportWorkerLine() throws ReportCreationException{
		
		List<WorkerLineEntity> workerLineEntities=  daoFactory.getWorkerLineDao().findUnprocessedByExternalId(Workers.REPORT_WORKER.getWorker());
		Iterator<WorkerLineEntity> wleIterator = workerLineEntities.iterator();
		
		
		while(wleIterator.hasNext()){
			ReportResult reportResult   = null;
			try{
			WorkerLineEntity wle = wleIterator.next();
			  WorkerLine workerLine = WorkerLineConverter.convertEntityToModel(wle);
			  
			  	wle.setStatus(Constants.JOB_PROCESSING);
				 wle.setUpdateAt(new Date());
				 wle.setCurrRetry(wle.getCurrRetry()+1);
				 daoFactory.getWorkerLineDao().update(wle);
			  
			  //When you create a worker line request, you create a request that has the Input matches with NotificationVO header
			  ReportRequest reportRequest = CoreUtil.convertJSONtoJava(workerLine.getInput(), ReportRequest.class);
			  
			  	String subject = reportRequest.getSubject();
				ReportType reportType = ReportType.valueOf(subject);
				
				ReportHeaderEntity reportHeaderEntity =daoFactory.getReportLineDao().findReportHeader(reportType.getReportType().toString());
				ReportHeader reportHeader = ReportConverter.convertEntityToModel(reportHeaderEntity);
				
					ReportLineEntity reportLineEntity= new ReportLineEntity();
					reportLineEntity.setReportHeaderEntity(reportHeaderEntity);
					reportLineEntity.setRequestTime(new Date());
					reportLineEntity.setStatus(Constants.JOB_CREATED);
					reportLineEntity.setInsertAt(new Date());
				
					reportLineEntity.setExternalId(CoreUtil.createUniqueID(false));
					daoFactory.getReportLineDao().insert(reportLineEntity);
					
					try{
						reportResult  =	reportRequestHandlerFactory.getReportRequestHandler(reportType).createReport(reportRequest, reportHeader);
						reportResult.setReportType(reportType.getReportType());
						 wle.setStatus(Constants.JOB_SUCCEEDED);
						
						 reportLineEntity.setCompletedTime(new Date());
						 reportLineEntity.setReportLocation(reportResult.getReportName());
						 reportLineEntity.setStatus(Constants.JOB_SUCCEEDED);
						 
						 
						 Notification notification = new Notification();
						 notification.setMethod("EMAIL");
						 notification.setType(reportType.getReportType());
						 notification.setAttachment(reportResult.getReportName());
						 
						 Recipients recipients = new Recipients();
						 
						 for(ReportRecipientEntity recipientEntity : reportHeaderEntity.getReportReceipients()){
							 recipients.getToRecipients().add(recipientEntity.getRecipentEmail());
						 }
						 notification.setRecipients(recipients);
						 
						 notificationServiceClient.createNotification(notification);
						 
					}catch(Exception e){
						 logger.info("Report Creation failed ::::" + e.getMessage());
						 e.printStackTrace();
						 wle.setStatus(Constants.JOB_FAILED);
						 reportLineEntity.setCompletedTime(new Date());
						 reportLineEntity.setStatus(Constants.JOB_FAILED);
						 reportLineEntity.setStatusMessage(e.getMessage());
						
						
					}finally{
						 wle.setUpdateAt(new Date());
						 wle.setCurrRetry(wle.getCurrRetry()+1);
						 reportLineEntity.setUpdateAt(new Date());
						 daoFactory.getWorkerLineDao().update(wle);
						 daoFactory.getWorkerLineDao().update(reportLineEntity);
					}

			}catch(Exception e){
				e.printStackTrace();
				throw new ReportCreationException("Excpetion in Report Worker "+e.getMessage());
			}
		}
	}
	

}
