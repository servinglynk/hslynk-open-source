package com.servinglynk.hmis.warehouse.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService;
import org.apache.hadoop.hbase.thrift2.generated.TIOError;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.live.BulkUploadActivity;
import com.servinglynk.hmis.warehouse.model.live.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.live.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.model.live.Sync;
import com.servinglynk.hmis.warehouse.model.staging.HmisBaseStagingModel;
import com.servinglynk.hmis.warehouse.model.staging.HmisUser;


public abstract class ParentDaoImpl<T extends Object> extends QueryExecutorImpl {
	
	public void hydrateCommonFields(HmisBaseModel baseModel,com.servinglynk.hmis.warehouse.model.live.HmisUser user) {
		ProjectGroupEntity projectGroupEntity = user.getProjectGroupEntity();
		baseModel.setProjectGroupCode( projectGroupEntity !=null ? projectGroupEntity.getProjectGroupCode(): "PG0001");
		BulkUploadActivity activity = new BulkUploadActivity();
	//	activity.setBulkUpload(domain.getUpload());
		activity.setDateCreated(LocalDateTime.now());
		activity.setDateUpdated(LocalDateTime.now());
		activity.setTableName(baseModel.getClass().getSimpleName());
		activity.setDeleted(false);
		activity.setUser(user);
		activity.setProjectGroupCode(projectGroupEntity.getProjectGroupCode());
		//activity.setExport(domain.getExport());
		activity.setRecordsProcessed(1L);
		activity.setDescription("Saving "+baseModel.getClass().getSimpleName() +" to staging" );
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
		activity.setUser(domain.getUpload().getUser());
		activity.setProjectGroupCode(projectGroupCode);
		//activity.setExport(domain.getExport());
		activity.setRecordsProcessed(1L);
		activity.setDescription("Saving "+baseModel.getClass().getSimpleName() +" to staging" );
		insertOrUpdate(activity);
		*/
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
