package com.servinglynk.hmis.warehouse.upload.service;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.dao.ParentDaoFactory;
import com.servinglynk.hmis.warehouse.enums.UploadStatus;
import com.servinglynk.hmis.warehouse.model.base.BulkUpload;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;


@Component
public class ClientWorkerChildren implements IClientWorkerChildren  {
	
	final static Logger logger = Logger.getLogger(ClientWorkerChildren.class);

	@Autowired
	Environment env;

	@Autowired
	private ParentDaoFactory factory;
	
	@Transactional
	@Scheduled(initialDelay=20,fixedDelay=10000)
	public void processWorkerLine() {
		try {
			List<BulkUpload> uploadEntities=  factory.getBulkUploaderWorkerDao().findBulkUploadByStatusAndYear(UploadStatus.C_CLIENT.getStatus(),new Long(2017));
			if(uploadEntities!=null && uploadEntities.size() >0 ) {
				for(BulkUpload upload : uploadEntities) {
					FileAppender appender = new FileAppender();
					appender.setName("" + upload.getId());
					appender.setFile("logs/client-children-" + upload.getId() + ".log");
					appender.setImmediateFlush(true);
					appender.setAppend(true);
					appender.setLayout(new PatternLayout());
					appender.activateOptions();
					logger.addAppender(appender);
					/** Perform full refresh base on Project group */
					upload.setStatus(UploadStatus.INPROGRESS.getStatus());
					factory.getBulkUploaderWorkerDao().insertOrUpdate(upload);
					ProjectGroupEntity projectGroupEntity = factory.getProjectGroupDao().getProjectGroupByGroupCode(upload.getProjectGroupCode());
					factory.getBulkUploaderDao().processClientChildren(upload,projectGroupEntity, appender, true);
 					logger.removeAppender(appender);
				}
			}
			logger.info("======== Exit Bulk Uploader processed ======");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
