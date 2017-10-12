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
public class ExitWorkerChildren implements IExitWorkerChildren  {
	
	final static Logger logger = Logger.getLogger(ExitWorkerChildren.class);

	@Autowired
	Environment env;

	@Autowired
	private ParentDaoFactory factory;
	
	@Transactional
	@Scheduled(initialDelay=20,fixedDelay=10000)
	public void processWorkerLine() {
		try {
			List<BulkUpload> uploadEntities=  factory.getBulkUploaderWorkerDao().findBulkUploadByStatusAndYear(UploadStatus.C_EXIT.getStatus(),new Long(2017));
			if(uploadEntities!=null && uploadEntities.size() >0 ) {
				for(BulkUpload upload : uploadEntities) {
					FileAppender appender = new FileAppender();
					appender.setName("" + upload.getId());
					appender.setFile("logs/exit-children-" + upload.getId() + ".log");
					appender.setImmediateFlush(true);
					appender.setAppend(true);
					appender.setLayout(new PatternLayout());
					appender.activateOptions();
					logger.addAppender(appender);
					/** Perform full refresh base on Project group */
					upload.setStatus(UploadStatus.INPROGRESS.getStatus());
					factory.getBulkUploaderWorkerDao().insertOrUpdate(upload);
					ProjectGroupEntity projectGroupEntity = factory.getProjectGroupDao().getProjectGroupByGroupCode(upload.getProjectGroupCode());
					factory.getBulkUploaderDao().processExitChildren(upload,projectGroupEntity, appender, true);
 					logger.removeAppender(appender);
				}
			}
			logger.info("======== Exit Bulk Uploader processed ======");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	protected String[] getNonCollectionFields(Object obj) {
		Field[] declaredFields = obj.getClass().getDeclaredFields();
		//System.out.println(declaredFields[0].getName() + " type of the field "+declaredFields[0].getGenericType() );
		String[] fieldsArray = new String[100];
		
		int i=0;
		for(Field field : declaredFields) {
			Type genericType = field.getGenericType();
			if(genericType != null ){
				String fieldName = field.getName();
				if(fieldName !=null && genericType.getTypeName().contains("Set")){
						fieldsArray[++i]= field.getName();	
				}
				if("serialVersionUID".equals(fieldName) || "SAVED_HASHES".equals(fieldName) || "hashCode".equals(fieldName)) {
					fieldsArray[++i]= field.getName();	
				}
				
			}
		}
		return fieldsArray;
	}

}
