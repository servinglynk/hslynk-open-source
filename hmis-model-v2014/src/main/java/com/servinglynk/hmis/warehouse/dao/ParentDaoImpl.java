package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.dao.QueryExecutorImpl;
import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.base.util.ErrorWarn;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.model.base.HmisUser;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.model.v2014.BulkUploadActivity;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.Export;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;


public abstract class ParentDaoImpl<T extends Object> extends QueryExecutorImpl {
	private static final Logger logger = Logger.getLogger(ParentDaoImpl.class);
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private Validator validator = (Validator) factory.getValidator();
	@Autowired
	ParentDaoFactory parentDaoFactory;
		/***
		 * Populates the Bulk_upload_activity table with essential statistics for the bulk upload process.
		 * @param i
		 * @param u
		 * @param className
		 * @param domain
		 * @param export
		 */
		public void hydrateBulkUploadActivityStaging(Long i, Long u,String className,ExportDomain domain,Export export ) {
			BulkUploadActivity activity = new BulkUploadActivity();
			activity.setBulkUploadId(domain.getUpload().getId());
			activity.setDateCreated(LocalDateTime.now());
			activity.setDateUpdated(LocalDateTime.now());
			activity.setTableName(className);
			activity.setDeleted(false);
			activity.setProjectGroupCode(domain.getUpload().getProjectGroupCode());
			activity.setExport(export);
			activity.setRecordsProcessed(i+u);
			activity.setInserted(i);
			activity.setUpdated(u);
			activity.setDescription("Saving "+className +" to staging" );
			insertOrUpdate(activity); 		
			getCurrentSession().flush();
	        getCurrentSession().clear();
	        Long totalProcessed = i+u;
	        logger.info("Processed"+totalProcessed+" in "+ className+" table with "+i+" inserts and "+i+" updates");
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
	    public void hydrateCommonFields(HmisBaseModel baseModel,ExportDomain domain, String sourceId,Long i) {
			String projectGroupCode = domain.getUpload().getProjectGroupCode();
			baseModel.setProjectGroupCode( projectGroupCode !=null ? projectGroupCode : "PG0001");
			baseModel.setActive(false);
			baseModel.setSync(false);
			HmisUser user = domain.getUpload().getUser();
			if(user != null)
				baseModel.setUserId(user.getId());
			baseModel.setSourceSystemId(sourceId !=null ? sourceId.trim(): null);
			// Lets write a logic to update if a recored with that source system Id already exists.
		  if(i % batchSize() == 0 && i > 0) {
			    getCurrentSession().flush();
	            getCurrentSession().clear();
          }
	    }
	/***
	 * Get a Model object with Source system ID and project group.
	 * @param className
	 * @param sourceId
	 * @param projectGroupCode
	 * @return
	 */
	protected HmisBaseModel getModel(String tableName,Class className,String sourceId,String projectGroupCode,boolean showWarning, Map<String, HmisBaseModel> modelMap, Long uploadId) {
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
				String warnMessage =" A match was not found in "+className.getSimpleName()+" with SourceSystemId: " + sourceId ;
				Error2014 error = new Error2014();
				error.table_name = tableName;
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
			criteria.add(Restrictions.isNull("parentId"));
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
	@Transactional
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
						 resultsMap.put(model.getSourceSystemId().trim(), model);
				 }
			}
		}
		return resultsMap;
	}
	/***
	 * Perform a Save or Update depending on the pojo.
	 * @param model
	 */
	protected void performSaveOrUpdate(HmisBaseModel model) {
//		Set<ConstraintViolation<HmisBaseModel>> constraintViolations = validator.validate(model);
//		if(constraintViolations.isEmpty()) {
//			
//		}
		if(model.isIgnored()) {
			logger.info("Igonring this record because is already exists:::"+model.toString());
			return;
		}
		model.setDateUpdated(LocalDateTime.now());
		if(!model.isInserted()) {
			getCurrentSession().update(model);
		}else{
			model.setDateCreated(LocalDateTime.now());
			insert(model);
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
			Error2014 error = new Error2014();
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
	        return Integer.valueOf(500);
	    }
	 
		@SuppressWarnings("unused")
		@Override
		public void softDeleteByProjectGroupCode(String className,String projectGroupCode,UUID exportId) {
			DetachedCriteria criteria = null;
			try {
				criteria = DetachedCriteria.forClass(Class.forName(className));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
			criteria.add(Restrictions.eq("deleted", false));
		//	criteria.createAlias("export", "exp").add(Restrictions.eq("exp.id", exportId));
			List<Object> objects = criteria.getExecutableCriteria(getCurrentSession()).list();
			if(objects !=null) {
				for(Object entity : objects) {
					 if(entity instanceof HmisBaseModel) {
						 delete(entity);
					 }
				}
			}
		}
}
