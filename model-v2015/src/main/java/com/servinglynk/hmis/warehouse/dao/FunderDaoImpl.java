/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Funder;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.FunderFunderEnum;
import com.servinglynk.hmis.warehouse.model.v2015.Error2015;
import com.servinglynk.hmis.warehouse.model.v2015.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2015.Project;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class FunderDaoImpl extends ParentDaoImpl implements FunderDao {
	private static final Logger logger = LoggerFactory
			.getLogger(FunderDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<Funder> funders = domain.getExport().getFunder();
	    com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Funder.class, getProjectGroupCode(domain));
		if(funders!=null && funders.size() > 0)
		{
			for(Funder funder : funders)
			{
				com.servinglynk.hmis.warehouse.model.v2015.Funder funderModel = null;
				try {
					funderModel = getModelObject(domain, funder,data,modelMap);
					funderModel.setFunder(FunderFunderEnum.lookupEnum(BasicDataGenerator.getStringValue(funder.getFunder())));
					//funderModel.setGrantid(funder.getGrantID());
					funderModel.setStartdate(BasicDataGenerator.getLocalDateTime(funder.getStartDate()));
					funderModel.setEnddate(BasicDataGenerator.getLocalDateTime(funder.getEndDate()));
					funderModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(funder.getDateCreated()));
					funderModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(funder.getDateUpdated()));
					Project project = (Project) getModel(Project.class,funder.getProjectID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					funderModel.setProjectid(project);
					funderModel.setExport(exportEntity);
					performSaveOrUpdate(funderModel);
				} catch(Exception e) {
					String errorMessage = "Exception beause of the funder::"+funder.getFunderID() +" Exception ::"+e.getMessage();
					if(funderModel != null){
						Error2015 error = new Error2015();
						error.model_id = funderModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = funderModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = funderModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2015.Funder.class.getSimpleName(), domain,exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2015.Funder getModelObject(ExportDomain domain, Funder funder ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2015.Funder modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2015.Funder) getModel(com.servinglynk.hmis.warehouse.model.v2015.Funder.class, funder.getFunderID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2015.Funder();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2015.Funder model = new com.servinglynk.hmis.warehouse.model.v2015.Funder();
		//org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(funder.getDateUpdated()));
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,funder.getFunderID(),data);
		return model;
	}

	public void hydrateHBASE(SyncDomain domain) {
		/**
		 * Get the Last Synced record from the Sync table.
		 * Then fetch data between last sync date time and between the time Sync Began.
		 */
	}

	   public com.servinglynk.hmis.warehouse.model.v2015.Funder createFunder(com.servinglynk.hmis.warehouse.model.v2015.Funder funder){
	       funder.setId(UUID.randomUUID());
	       insert(funder);
	       return funder;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Funder updateFunder(com.servinglynk.hmis.warehouse.model.v2015.Funder funder){
	       update(funder);
	       return funder;
	   }
	   public void deleteFunder(com.servinglynk.hmis.warehouse.model.v2015.Funder funder){
	       delete(funder);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Funder getFunderById(UUID funderId){
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Funder.class);
		      criteria.add(Restrictions.eq("id", funderId));
		      List<com.servinglynk.hmis.warehouse.model.v2015.Funder> entities = (List<com.servinglynk.hmis.warehouse.model.v2015.Funder>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2015.Funder> getAllProjectFunders(UUID projectId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Funder.class);
	       criteria.createAlias("projectid", "projectid");
	       criteria.add(Restrictions.eq("projectid.id", projectId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Funder>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getProjectFundersCount(UUID projectId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Funder.class);
	       criteria.createAlias("projectid", "projectid");
	       criteria.add(Restrictions.eq("projectid.id", projectId));
	       return countRows(criteria);
	   }

}
