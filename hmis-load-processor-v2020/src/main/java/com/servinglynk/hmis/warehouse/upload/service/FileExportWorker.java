package com.servinglynk.hmis.warehouse.upload.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.dao.ParentDaoFactory;
import com.servinglynk.hmis.warehouse.model.base.FileExportEntity;


@Component
public class FileExportWorker implements IClientDedupWorker  {
	
	final static Logger logger = Logger.getLogger(FileExportWorker.class);

	@Autowired
	Environment env;

	@Autowired
	private ParentDaoFactory factory;
	
	
	@Transactional
	@Scheduled(initialDelay=20,fixedDelay=10000)
	public void processWorkerLine() {
		try {
		List<FileExportEntity> fileExportByStatusEmailSent = factory.getFileExportDao().getFileExportByStatusEmailSent("INITIAL", false);
		if(CollectionUtils.isNotEmpty(fileExportByStatusEmailSent)) {
			for(FileExportEntity fileExportEntity : fileExportByStatusEmailSent) {
				FileAppender appender = new FileAppender();
				appender.setName("" + fileExportEntity.getId());
				appender.setFile("logs/file-export-" + fileExportEntity.getId() + ".log");
				appender.setImmediateFlush(true);
				appender.setAppend(true);
				appender.setLayout(new PatternLayout());
				appender.activateOptions();
				logger.addAppender(appender);
				factory.getBulkUploaderDao().performFileExport(fileExportEntity, appender, true);
				logger.removeAppender(appender);
			}
		}
			logger.info("======== File Export processed ======");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
