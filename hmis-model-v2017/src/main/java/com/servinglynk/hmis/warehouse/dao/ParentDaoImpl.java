package com.servinglynk.hmis.warehouse.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.base.dao.QueryExecutorImpl;
import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.base.util.ErrorWarn;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.model.base.HmisUser;
import com.servinglynk.hmis.warehouse.model.v2017.BulkUploadActivity;
import com.servinglynk.hmis.warehouse.model.v2017.Error2017;
import com.servinglynk.hmis.warehouse.model.v2017.Export;
import com.servinglynk.hmis.warehouse.model.v2017.HmisBaseModel;


public abstract class ParentDaoImpl<T extends Object> extends QueryExecutorImpl {
	private static final Logger logger = Logger.getLogger(ParentDaoImpl.class);
	/***
	 * Populates the Bulk_upload_activity table with essential statistics for the bulk upload process.
	 * @param i
	 * @param u
	 * @param className
	 * @param domain
	 * @param export
	 */
	public void hydrateBulkUploadActivityStaging(Long i, Long j , Long ignore,String className,ExportDomain domain,Export export ) {
		if(!domain.isReUpload()) {
			BulkUploadActivity activity = new BulkUploadActivity();
			activity.setBulkUploadId(domain.getUpload().getId());
			activity.setDateCreated(LocalDateTime.now());
			activity.setDateUpdated(LocalDateTime.now());
			activity.setTableName(className);
			activity.setDeleted(false);
			activity.setProjectGroupCode(domain.getUpload().getProjectGroupCode());
			activity.setExport(export);
			activity.setRecordsProcessed(i+j+ignore);
			activity.setInserted(i);
			activity.setUpdated(j);
			activity.setDescription("Saving "+className +" to staging" );
			insertOrUpdate(activity); 		
			getCurrentSession().flush();
	        getCurrentSession().clear();
	        Long totalProcessed = i+j+ignore;
	        logger.info("Processed"+totalProcessed+" in "+ className+" table with "+i+" inserts and "+j+" updates and "+ignore+ " are ignored");
		}
	}
		/***
		 * Gets the project group code for a Bulk Upload
		 * @param domain
		 * @return
		 */
		protected String getProjectGroupCode(ExportDomain domain) {
			String projectGroupCode = domain.getUpload().getProjectGroupCode();
			return projectGroupCode !=null ? projectGroupCode : "PG0001";
		}
		/**
		 * Determines if a Full refresh needs to be done or Delta refresh.
		 * @param domain
		 * @return
		 */
		public boolean isFullRefresh(ExportDomain domain) {
			String exportDirective = domain.getExport().getExportDirective();
			if(StringUtils.isNotBlank(exportDirective) &&  exportDirective.contains("Full")) {
				return true;
			}
			return false;
		}
		/**
		 * Hydrates all the common fields related to a data model.
		 * @param baseModel
		 * @param domain
		 * @param sourceId
		 * @param i
		 */
	    public void hydrateCommonFields(HmisBaseModel baseModel,ExportDomain domain, String sourceId,Data data) {
			String projectGroupCode = domain.getUpload().getProjectGroupCode();
			baseModel.setProjectGroupCode( projectGroupCode !=null ? projectGroupCode : "PG0001");
			baseModel.setActive(false);
			baseModel.setSync(false);
			HmisUser user = domain.getUpload().getUser();
			if(user != null)
				baseModel.setUserId(user.getId());
			baseModel.setSourceSystemId(sourceId !=null ? sourceId.trim(): null);
			// Lets write a logic to update if a recored with that source system Id already exists.
		  if(data.i % batchSize() == 0 && data.i > 0) {
			    getCurrentSession().flush();
	            getCurrentSession().clear();
          }
	    }
	    protected void performMatch(ExportDomain domain, HmisBaseModel modelFromDB, HmisBaseModel model, Data data) {
			if(!isFullRefresh(domain) && modelFromDB!=null && !modelFromDB.isRecordToBoInserted()){
				if(modelFromDB != null) {
					modelMatch(modelFromDB, model);
				}	
				if(!model.isIgnored()) {
					if(!model.isRecordToBoInserted()) {
						data.j++;
					}
					if(model.isRecordToBoInserted()) {
						data.i++;
					}
				}
				if(model.isIgnored()) {
					data.ignore++;
				}
			}else {
				data.i++;
				model.setRecordToBeInserted(true);
				UUID id =UUID.randomUUID();
				try {
					org.apache.commons.beanutils.BeanUtils.copyProperty(model, "id",id);
				} catch (IllegalAccessException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	    protected void modelMatch(com.servinglynk.hmis.warehouse.model.v2017.HmisBaseModel modelFromDB,com.servinglynk.hmis.warehouse.model.v2017.HmisBaseModel model) {
	    	if(model.getDateUpdatedFromSource() ==null || modelFromDB.getDateUpdatedFromSource() == null) {
				model.setIgnored(true);
				return;
			}
			if( model.getDateUpdatedFromSource().compareTo(modelFromDB.getDateUpdatedFromSource()) == 0) {
					model.setIgnored(true);	
				}else if( model.getDateUpdatedFromSource().compareTo(modelFromDB.getDateUpdatedFromSource()) > 0) {
					model.setRecordToBeInserted(false); //record already inserted , We need to update this.
					populateModelId(modelFromDB, model);
				}else if( model.getDateUpdatedFromSource().compareTo(modelFromDB.getDateUpdatedFromSource()) < 0) {
						 // model = record in the file. modelFromDB = record in DB.
						// record to be inserted is older than the record already in DB then we need to update parentID of recordFromDB with ID of model. 
					// record to be inserted is older than the record already in DB then we need to update parentID of recordFromDB with ID of model. 
					try {
						UUID id =UUID.randomUUID();
						org.apache.commons.beanutils.BeanUtils.copyProperty(modelFromDB, "parentId",id);
						getCurrentSession().evict(modelFromDB);
						getCurrentSession().update(modelFromDB);
						getCurrentSession().flush();
				        getCurrentSession().clear();
				        org.apache.commons.beanutils.BeanUtils.copyProperty(model, "id",id);
					    model.setRecordToBeInserted(true);
						model.setDeleted(true);
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		}
	    
	    private void populateModelId(com.servinglynk.hmis.warehouse.model.v2017.HmisBaseModel modelFromDB,com.servinglynk.hmis.warehouse.model.v2017.HmisBaseModel model) {
	    	try {
				Method methodId = modelFromDB.getClass().getDeclaredMethod("getId");
		        org.apache.commons.beanutils.BeanUtils.copyProperty(model, "id",UUID.fromString(methodId.invoke(modelFromDB).toString()));
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	/***
	 * Get a Model object with Source system ID and project group.
	 * @param className
	 * @param sourceId
	 * @param projectGroupCode
	 * @return
	 */
	protected HmisBaseModel getModel(Class className,String sourceId,String projectGroupCode,boolean showWarning, Map<String, HmisBaseModel> modelMap, Long uploadId) {
		if (StringUtils.isBlank(sourceId)) {
			return null;
		}
		Boolean found = true;
		if (modelMap != null && modelMap.size() > 0) {
			HmisBaseModel model = modelMap.get(sourceId.trim());
			if (model == null) {
				found = false;
			} else {
				return model;
			}
		} else {
			found = false;
		}

		if (!found) {
			if (showWarning) {
				String warnMessage =" A match was not found in "+className+" with SourceSystemId: " + sourceId ;
				Error2017 error = new Error2017();
				error.table_name = className.getSimpleName();
				error.model_id = null;
				error.bulk_upload_ui = uploadId;
				error.project_group_code = projectGroupCode;
				error.source_system_id = sourceId;
				error.type = ErrorType.WARN;
				error.error_description = warnMessage;
				error.date_created = LocalDateTime.now();
				performSave(error);
				logger.warn(warnMessage);
			}
		}
		return null;
	}
	/***
	 * Get Models by source system id and project group code.
	 * @param className
	 * @param sourceId
	 * @param projectGroupCode
	 * @return
	 */
	protected List<HmisBaseModel> getModels(Class className,String sourceId,String projectGroupCode) {
		if(sourceId !=null && projectGroupCode !=null) {
			Criteria criteria = getCurrentSession().createCriteria(className);
			criteria.add(Restrictions.eq("sourceSystemId",sourceId.trim()));
			criteria.add(Restrictions.eq("projectGroupCode",projectGroupCode.trim()));
			criteria.add(Restrictions.eq("deleted",false));
			criteria.addOrder( Order.desc("dateCreated") );
			@SuppressWarnings("unchecked")
			List<HmisBaseModel> models = (List<HmisBaseModel>) criteria.list() ;
			if(CollectionUtils.isNotEmpty(models)) {
				return models;
			}
			return null;
		}
		return null;
	}
	/***
	 * Get Models by source system id and project group code.
	 * @param className
	 * @param projectGroupCode
	 * @return
	 */
	protected Map<String,HmisBaseModel> getModelMap(Class className ,String projectGroupCode) {
		Map<String,HmisBaseModel> resultsMap = new HashMap<String, HmisBaseModel>();
		if(projectGroupCode !=null) {
			Criteria criteria = getCurrentSession().createCriteria(className);
			criteria.add(Restrictions.eq("projectGroupCode",projectGroupCode.trim()));
			criteria.add(Restrictions.eq("deleted",false));
			criteria.add(Restrictions.isNull("parentId"));
			criteria.addOrder( Order.desc("dateCreated") );
			@SuppressWarnings("unchecked")
			List<HmisBaseModel> models = (List<HmisBaseModel>) criteria.list() ;
			if(CollectionUtils.isNotEmpty(models)) {
				 for(HmisBaseModel model : models ){
					 if(StringUtils.isNotBlank(model.getSourceSystemId()))
						 resultsMap.put(model.getSourceSystemId(), model);
				 }
			}
		}
		return resultsMap;
	}
	/***
	 * Perform a Save or Update depending on the pojo.
	 * @param model
	 */
	protected void performSaveOrUpdate(HmisBaseModel model,ExportDomain domain) {
		if(domain.isReUpload()) {
			getCurrentSession().saveOrUpdate(model);
			model.setDateUpdated(LocalDateTime.now());
		}
		else {
			if(model.isIgnored()) {
				logger.info("Ignoring this record because is already exists:::"+model.toString());
				return;
			}
			model.setDateUpdated(LocalDateTime.now());
			if(!model.isRecordToBoInserted()) {
				update(model);
			}else{
				model.setDateCreated(LocalDateTime.now());
				insert(model);
			}
		}
	}

	protected void performSave(HmisBaseModel model, ExportDomain domain, String tableName, UUID id, String errorMessage, Appender appender) {
		if(appender != null){
			logger.addAppender(appender);
		}
		
		try {
			getCurrentSession().flush();
		    getCurrentSession().clear();
			logger.warn(errorMessage);
			Error2017 error = new Error2017();
			error.table_name = tableName;
			error.model_id = id;
			error.bulk_upload_ui = domain.getUpload().getId();
			error.project_group_code = domain.getUpload().getProjectGroupCode();
			error.source_system_id = model.getSourceSystemId();
			error.type = ErrorType.ERROR;
			error.error_description = errorMessage;
			error.date_created = model.getDateCreated();
			performSave(error);
		}catch(Exception e){
			logger.warn(e.getCause());
			// Want to eat exception here
		}
		
		if(appender != null){
			logger.removeAppender(appender);
		}
	}

	protected void performSave(ErrorWarn errorWarn){
		insert(errorWarn);
	}

	/***
	 * Gets the batch size.
	 * @return
	 */
	 protected int batchSize() {
	        return Integer.valueOf(100);
	    }
}
