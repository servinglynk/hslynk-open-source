package com.servinglynk.hmis.warehouse.upload.service;

import java.util.List;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.dao.ParentDaoFactory;
import com.servinglynk.hmis.warehouse.enums.UploadStatus;
import com.servinglynk.hmis.warehouse.model.base.BulkUpload;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.upload.business.exception.BulkUploadException;
@Component
public class ExitChild1Processor {
	@Autowired
	Environment env;

	@Autowired
	private ParentDaoFactory factory;
	final static Logger logger = Logger.getLogger(ExitChild1Processor.class);
	
	@Transactional
	public void processExitChildren1() throws BulkUploadException{
		try {
			List<BulkUpload> uploadEntities =  factory.getBulkUploaderWorkerDao().findBulkUploadByStatusAndYear(UploadStatus.CORE.getStatus(),new Long(2015));
			if(uploadEntities!=null && uploadEntities.size() >0 ) {
				for(BulkUpload upload : uploadEntities) {
					FileAppender appender = new FileAppender();
					appender.setName("" + upload.getId());
					appender.setFile("logs/" + upload.getId() + "-processExitChildren1.log");
					appender.setImmediateFlush(true);
					appender.setAppend(true);
					appender.setLayout(new PatternLayout());
					appender.activateOptions();
					upload.setStatus(UploadStatus.INPROGRESS.getStatus());
					factory.getBulkUploaderWorkerDao().insertOrUpdate(upload);
					logger.info("======== processExitChildren1 processing ======");
					ProjectGroupEntity projectGroupEntity = factory.getProjectGroupDao().getProjectGroupByGroupCode(upload.getProjectGroupCode());
					factory.getBulkUploaderDao().processExitChildrenPart1(upload,projectGroupEntity,appender,true);
				}
			}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
