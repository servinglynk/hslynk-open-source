package com.servinglynk.hmis.warehouse.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
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

import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.live.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.live.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.model.live.Sync;
import com.servinglynk.hmis.warehouse.model.staging.HmisBaseStagingModel;
import com.servinglynk.hmis.warehouse.model.staging.HmisUser;


public abstract class ParentDaoImpl<T extends Object> extends QueryExecutorImpl {
	
	public void hydrateCommonFields(HmisBaseModel baseModel,HmisUser user) {
		ProjectGroupEntity projectGroupEntity = user.getProjectGroupEntity();
		baseModel.setProjectGroupCode( projectGroupEntity !=null ? projectGroupEntity.getProjectGroupCode(): "default");
	}
	public void hydrateCommonFields(HmisBaseStagingModel baseModel,HmisUser user) {
		ProjectGroupEntity projectGroupEntity = user.getProjectGroupEntity();
		baseModel.setProjectGroupCode( projectGroupEntity !=null ? projectGroupEntity.getProjectGroupCode(): "default");
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
