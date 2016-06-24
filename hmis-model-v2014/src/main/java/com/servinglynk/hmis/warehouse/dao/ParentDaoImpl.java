package com.servinglynk.hmis.warehouse.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.hadoop.hbase.thrift2.generated.THBaseService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.base.dao.QueryExecutorImpl;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.model.v2014.BulkUploadActivity;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;


public abstract class ParentDaoImpl<T extends Object> extends QueryExecutorImpl {
	
	public void hydrateBulkUploadActivity(Set sets,String className, com.servinglynk.hmis.warehouse.model.v2014.Export export,Long id ) {
	       com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, export.getId());
			BulkUploadActivity activity = new BulkUploadActivity();
			
			activity.setBulkUploadId(id);
			activity.setDateCreated(LocalDateTime.now());
			activity.setDateUpdated(LocalDateTime.now());
			activity.setTableName(className);
			activity.setDeleted(false);
		//	activity.setUser(user);
			activity.setProjectGroupCode(export.getProjectGroupCode());
			activity.setExport(exportEntity);
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
		
	public void hydrateCommonFields(HmisBaseModel baseModel,com.servinglynk.hmis.warehouse.model.base.HmisUser user) {
		ProjectGroupEntity projectGroupEntity = user.getProjectGroupEntity();
		baseModel.setProjectGroupCode( projectGroupEntity !=null ? projectGroupEntity.getProjectGroupCode(): "PG0001");
//		BulkUploadActivity activity = new BulkUploadActivity();
//	//	activity.setBulkUpload(domain.getUpload());
//		activity.setDateCreated(LocalDateTime.now());
//		activity.setDateUpdated(LocalDateTime.now());
//		activity.setTableName(baseModel.getClass().getSimpleName());
//		activity.setDeleted(false);
//	//	activity.setUser(user);
//		activity.setProjectGroupCode(projectGroupEntity.getProjectGroupCode());
//		//activity.setExport(domain.getExport());
//		activity.setRecordsProcessed(1L);
//		activity.setDescription("Saving "+baseModel.getClass().getSimpleName() +" to staging" );
//		insertOrUpdate(activity);
		
	}
	public void hydrateCommonFields(HmisBaseModel baseModel,ExportDomain domain, String sourceId,int i) {
		String projectGroupCode = domain.getUpload().getProjectGroupCode();
		baseModel.setProjectGroupCode( projectGroupCode !=null ? projectGroupCode : "PG0001");
		baseModel.setActive(false);
		baseModel.setSourceSystemId(sourceId !=null ? sourceId.trim(): null);
		// Lets write a logic to update if a recored with that source system Id already exists.
		peromSaveOrUpdate(baseModel);
//		  if(i % batchSize() == 0 && i > 0) {
//              getCurrentSession().flush();
//              getCurrentSession().clear();
//          }
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
	
	protected void peromSaveOrUpdate(HmisBaseModel model) {
		DetachedCriteria criteria = DetachedCriteria.forClass(model.getClass());
		//criteria.createAlias("export","export");
		//criteria.add(Restrictions.eq("export.id",clientId));
		criteria.add(Restrictions.eq("sourceSystemId",model.getSourceSystemId()));
		criteria.add(Restrictions.eq("projectGroupCode",model.getProjectGroupCode()));
		List<HmisBaseModel> models = (List<HmisBaseModel>) findByCriteria(criteria);
		if(CollectionUtils.isNotEmpty(models)) {
			HmisBaseModel existingModel = models.get(0);
			String[] excludedArgs = getNonCollectionFields(existingModel);
			BeanUtils.copyProperties(model, existingModel,append(excludedArgs,"id"));
			update(existingModel);
		}else{
			insert(model);
		}
		
	}
	
	private <String> String[] append(String[] arr, String element) {
	    final int N = arr.length;
	    arr = Arrays.copyOf(arr, N + 1);
	    arr[N] = element;
	    return arr;
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
	
	 protected int batchSize() {
	        return Integer.valueOf(100);
	    }
}
