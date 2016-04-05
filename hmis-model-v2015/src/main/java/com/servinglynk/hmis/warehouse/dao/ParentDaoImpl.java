package com.servinglynk.hmis.warehouse.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService;

import com.servinglynk.hmis.warehouse.base.dao.QueryExecutorImpl;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.model.stagv2015.HmisBaseStagingModel;
import com.servinglynk.hmis.warehouse.model.v2015.BulkUploadActivity;
import com.servinglynk.hmis.warehouse.model.v2015.Export;
import com.servinglynk.hmis.warehouse.model.v2015.HmisBaseModel;


public abstract class ParentDaoImpl<T extends Object> extends QueryExecutorImpl {
	
	public void hydrateCommonFields(HmisBaseModel baseModel) {
		ProjectGroupEntity projectGroupEntity = new ProjectGroupEntity();
	}
	public void hydrateBulkUploadActivity(Set sets,String className, com.servinglynk.hmis.warehouse.model.stagv2015.Export export ) {
       com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, export.getId());
		BulkUploadActivity activity = new BulkUploadActivity();
	//	activity.setBulkUploadId(exportEntity.getBulkUploads().iterator().next().getId());
		activity.setDateCreated(LocalDateTime.now());
		activity.setDateUpdated(LocalDateTime.now());
		activity.setTableName(className);
		activity.setDeleted(false);
	//	activity.setUser(user);
		activity.setProjectGroupCode(export.getProjectGroupCode());
	//	activity.setExport(exportEntity);
		activity.setRecordsProcessed(new Long(sets !=null ? sets.size(): 0L));
		activity.setDescription("Saving "+className +" to Live" );
		insertOrUpdate(activity); 		
	}
	
	public void hydrateBulkUploadActivityStaging(List lists,String className,ExportDomain domain ) {
		BulkUploadActivity activity = new BulkUploadActivity();
		activity.setBulkUploadId(domain.getUpload().getId());
		activity.setDateCreated(LocalDateTime.now());
		activity.setDateUpdated(LocalDateTime.now());
		activity.setTableName(className);
		activity.setDeleted(false);
	//	activity.setUser(user);
		activity.setProjectGroupCode(domain.getUpload().getProjectGroupCode());
		//activity.setExport(export);
		activity.setRecordsProcessed(new Long(lists !=null ? lists.size(): 0L));
		activity.setDescription("Saving "+className +" to staging" );
		insertOrUpdate(activity); 		
	}
	public void hydrateCommonFields(HmisBaseStagingModel baseModel,ExportDomain domain) {
		String projectGroupCode = domain.getUpload().getProjectGroupCode();
		baseModel.setProjectGroupCode( projectGroupCode !=null ? projectGroupCode : "PG0001");
	/*	BulkUploadActivity activity = new BulkUploadActivity();
		activity.setBulkUpload(domain.getUpload());
		activity.setDateCreated(LocalDateTime.now());
		activity.setDateUpdated(LocalDateTime.now());
		activity.setTableName(baseModel.getClass().getSimpleName());
		activity.setDeleted(false);
		//activity.setUser(domain.getUpload().getUser());
		activity.setProjectGroupCode(projectGroupCode);
		//activity.setExport(domain.getExport());
		activity.setRecordsProcessed(1L);
		activity.setDescription("Saving "+baseModel.getClass().getSimpleName() +" to staging" );
		insertOrUpdate(activity);*/
		
	}
	protected abstract void performSave(THBaseService.Iface client, Object entity);
	protected abstract List<T> performGet(THBaseService.Iface client, Object entity);
	
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
	protected String[] getNonCollectionFieldsForObject(Object obj) {
		Field[] declaredFields = obj.getClass().getDeclaredFields();
		//System.out.println(declaredFields[0].getName() + " type of the field "+declaredFields[0].getGenericType() );
		String[] fieldsArray = new String[100];
		
		int i=0;
		for(Field field : declaredFields) {
			Type genericType = field.getGenericType();
			if(genericType != null ){
				String fieldName = field.getName();
				if(fieldName !=null && !genericType.getTypeName().contains("Set")){
						fieldsArray[++i]= field.getName();	
				}
				if(!"serialVersionUID".equals(fieldName) && !"SAVED_HASHES".equals(fieldName) && !"hashCode".equals(fieldName)) {
					fieldsArray[++i]= field.getName();	
				}
				
			}
		}
		return fieldsArray;
	}
}
