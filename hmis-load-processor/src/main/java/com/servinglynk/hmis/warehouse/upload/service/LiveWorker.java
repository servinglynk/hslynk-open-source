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
import com.servinglynk.hmis.warehouse.model.staging.BulkUpload;
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
					factory.getBulkUploaderDao().moveFromStagingToLive(bulkUpload.getExport().getId());
					com.servinglynk.hmis.warehouse.model.live.BulkUpload target  = new com.servinglynk.hmis.warehouse.model.live.BulkUpload();
					BeanUtils.copyProperties(bulkUpload, target,getNonCollectionFields(target));
					target.setStatus(UploadStatus.LIVE.getStatus());
					 com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) factory.getExportDao().get(com.servinglynk.hmis.warehouse.model.live.Export.class, bulkUpload.getExport().getId());
					target.setExport(exportEntity);
					factory.getBulkUploaderWorkerDao().insertOrUpdate(target); 
				}
			logger.info("Sandeep Testing");
			}
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