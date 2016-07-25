package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.base.util.ErrorWarn;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.base.dao.QueryExecutorImpl;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.model.v2014.BulkUploadActivity;
import com.servinglynk.hmis.warehouse.model.v2014.Export;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;


public abstract class ParentDaoImpl<T extends Object> extends QueryExecutorImpl {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ParentDaoImpl.class);
	
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
	protected HmisBaseModel getModel(Class className,String sourceId,String projectGroupCode,boolean showWarning, Map<String, HmisBaseModel> modelMap, Long uploadId) {
		if (StringUtils.isBlank(sourceId)) {
			return null;
		}
		Boolean found = true;
		if (modelMap != null && modelMap.size() > 0) {
			HmisBaseModel model = modelMap.get(sourceId);
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
				String warnMessage = className + " : A match was not found in the database for SourceSystemId: " + sourceId ;

				Error2014 error = new Error2014();
				error.model_id = null;
				error.bulk_upload_ui = uploadId;
				error.project_group_code = projectGroupCode;
				error.source_system_id = sourceId;
				error.type = ErrorType.WARN;
				error.error_description = warnMessage;
				error.date_created = LocalDateTime.now();
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
	protected void performSaveOrUpdate(HmisBaseModel model) {
		model.setDateUpdated(LocalDateTime.now());
		if(!model.isInserted()) {
			getCurrentSession().update(model);
		}else{
			model.setDateCreated(LocalDateTime.now());
			insert(model);
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
