package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Affiliation;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.v2017.Error2017;
import com.servinglynk.hmis.warehouse.model.v2017.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2017.Project;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class AffiliationDaoImpl extends ParentDaoImpl implements AffiliationDao {
	private static final Logger logger = LoggerFactory
			.getLogger(AffiliationDaoImpl.class);
		@Override
		public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception 
		{
			Export export = domain.getExport();
			List<Affiliation> affiliations = export.getAffiliation();
			Data data =new Data();
			Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2017.Affiliation.class, getProjectGroupCode(domain));
			com.servinglynk.hmis.warehouse.model.v2017.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2017.Export) getModel(com.servinglynk.hmis.warehouse.model.v2017.Export.class,domain.getExport().getExportID(),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
			if(CollectionUtils.isNotEmpty(affiliations))
			{
				for(Affiliation affiliation :affiliations )
				{
					com.servinglynk.hmis.warehouse.model.v2017.Affiliation affiliationModel = null;
					try {
						affiliationModel = getModelObject(domain, affiliation,data,modelMap);
						affiliationModel.setResprojectid(affiliation.getResProjectID());
						Project project = (Project) getModel(Project.class,affiliation.getProjectID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
						affiliationModel.setExport(exportEntity);
						affiliationModel.setProjectid(project);
						//exportEntity.addAffiliation(affiliationModel);
						affiliationModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(affiliation.getDateCreated()));
						affiliationModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(affiliation.getDateUpdated()));
						performSaveOrUpdate(affiliationModel,domain);
					} catch(Exception e) {
						String errorMessage = "Error occured with "+affiliation.getAffiliationID() + " Execption :::"+e.getLocalizedMessage();
						if(affiliationModel != null){
							Error2017 error = new Error2017();
							error.model_id = affiliationModel.getId();
							error.bulk_upload_ui = domain.getUpload().getId();
							error.project_group_code = domain.getUpload().getProjectGroupCode();
							error.source_system_id = affiliationModel.getSourceSystemId();
							error.type = ErrorType.ERROR;
							error.error_description = errorMessage;
							error.date_created = affiliationModel.getDateCreated();
							performSave(error);
						}
						logger.error(errorMessage);
					}
				}
			}
			hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2017.Affiliation.class.getSimpleName(), domain, exportEntity);
		}

		
		public  com.servinglynk.hmis.warehouse.model.v2017.Affiliation getModelObject(ExportDomain domain, Affiliation affiliation,Data data, Map<String,HmisBaseModel> modelMap) {
			com.servinglynk.hmis.warehouse.model.v2017.Affiliation modelFromDB = null;
			// We always insert for a Full refresh and update if the record exists for Delta refresh
			if(!isFullRefresh(domain))
				modelFromDB = (com.servinglynk.hmis.warehouse.model.v2017.Affiliation) getModel(com.servinglynk.hmis.warehouse.model.v2017.Affiliation.class, affiliation.getAffiliationID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
			if(domain.isReUpload() && modelFromDB != null) 
			{
				return modelFromDB;
			}
			com.servinglynk.hmis.warehouse.model.v2017.Affiliation model = null;
			if(modelFromDB == null) {
				model = new com.servinglynk.hmis.warehouse.model.v2017.Affiliation();
				model.setId(UUID.randomUUID());
				model.setRecordToBeInserted(true);
			}else {
				org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
				model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(affiliation.getDateUpdated()));
				performMatch(domain, modelFromDB, model, data);
			}
		
			hydrateCommonFields(model, domain,affiliation.getAffiliationID(),data);
			return model;
		}

		@Override
		public void hydrateHBASE(SyncDomain syncDomain) {
			// TODO Auto-generated method stub
			
		}

		   public com.servinglynk.hmis.warehouse.model.v2017.Affiliation createAffiliation(com.servinglynk.hmis.warehouse.model.v2017.Affiliation affiliation){
		       affiliation.setId(UUID.randomUUID()); 
		       insert(affiliation);
		       return affiliation;
		   }
		   public com.servinglynk.hmis.warehouse.model.v2017.Affiliation updateAffiliation(com.servinglynk.hmis.warehouse.model.v2017.Affiliation affiliation){
		       update(affiliation);
		       return affiliation;
		   }
		   public void deleteAffiliation(com.servinglynk.hmis.warehouse.model.v2017.Affiliation affiliation){
		       delete(affiliation);
		   }
		   public com.servinglynk.hmis.warehouse.model.v2017.Affiliation getAffiliationById(UUID affiliationId){ 
			      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Affiliation.class);
			      criteria.add(Restrictions.eq("id", affiliationId));
			      List<com.servinglynk.hmis.warehouse.model.v2017.Affiliation> entities = (List<com.servinglynk.hmis.warehouse.model.v2017.Affiliation>) findByCriteria(criteria);
			      if(!entities.isEmpty()) return entities.get(0);
			      return null;
		   }
		   public List<com.servinglynk.hmis.warehouse.model.v2017.Affiliation> getAllProjectAffiliations(UUID projectId,Integer startIndex, Integer maxItems){
		       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Affiliation.class);
		       criteria.createAlias("projectid", "projectid");
		       criteria.add(Restrictions.eq("projectid.id", projectId));
		       return (List<com.servinglynk.hmis.warehouse.model.v2017.Affiliation>) findByCriteria(criteria,startIndex,maxItems);
		   }
		   public long getProjectAffiliationsCount(UUID projectId){
		       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Affiliation.class);
		       criteria.createAlias("projectid", "projectid");
		       criteria.add(Restrictions.eq("projectid.id", projectId));
		       return countRows(criteria);
		   }
}

