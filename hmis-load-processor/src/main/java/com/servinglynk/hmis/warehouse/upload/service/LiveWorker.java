package com.servinglynk.hmis.warehouse.upload.service;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.dao.ParentDaoFactory;
import com.servinglynk.hmis.warehouse.model.live.BulkUpload;
import com.servinglynk.hmis.warehouse.upload.business.exception.ReportCreationException;
import com.servinglynk.hmis.warehouse.upload.business.service.core.ParentService;
import com.servinglynk.hmis.warehouse.upload.business.util.UploadStatus;


@Component
@Service
public class LiveWorker  extends ParentService implements ILiveWorker  {
	
	final static Logger logger = Logger.getLogger(BulkUploadWorker.class);

	@Autowired
	Environment env;

	@Autowired
	private ParentDaoFactory factory;
	
	@Transactional
	@Scheduled(initialDelay=20,fixedDelay=10000)
	public void processWorkerLine() throws ReportCreationException{
		try {
			
			List<BulkUpload> stagingUploadEntities=  factory.getBulkUploaderWorkerDao().findBulkUploadByStatus(UploadStatus.STAGING.getStatus());
			if(stagingUploadEntities!=null && stagingUploadEntities.size() >0 ) {
				for(BulkUpload bulkUpload : stagingUploadEntities) {
					daoFactory.getBulkUploaderDao().deleteLiveByProjectGroupCode(bulkUpload.getProjectGroupCode());
					factory.getBulkUploaderDao().moveFromStagingToLive(bulkUpload);
				}
			logger.info("Bulk Uploader completed Live processing==============");
			}
		} catch (Exception e) {
			logger.error("Error while processing Live Batch Job"+e.getMessage());
		}
	
	}
	protected String[] getNonCollectionFields(Object obj) {
		Field[] declaredFields = obj.getClass().getDeclaredFields();
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