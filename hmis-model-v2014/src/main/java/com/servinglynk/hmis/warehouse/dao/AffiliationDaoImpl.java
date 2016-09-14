package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Affiliation;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2014.Project;
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
			Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Affiliation.class, getProjectGroupCode(domain));
			com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Affiliation.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
			if(affiliations!=null && !affiliations.isEmpty())
			{
				for(Affiliation affiliation :affiliations )
				{
					com.servinglynk.hmis.warehouse.model.v2014.Affiliation model = null;
					try {
						model = getModelObject(domain, affiliation,data,modelMap);
						Project project = (Project) getModel(com.servinglynk.hmis.warehouse.model.v2014.Affiliation.class.getSimpleName(),Project.class, affiliation.getProjectID(), model.getProjectGroupCode(),true,relatedModelMap, domain.getUpload().getId());
						model.setProjectid(project);
						model.setExport(exportEntity);
						model.setResprojectid(affiliation.getResProjectID());
						performSaveOrUpdate(model);
					}catch(Exception e) {
						String errorMessage = "Error occured with "+affiliation.getAffiliationID() + " Execption :::"+e.getLocalizedMessage();
						if (model != null) {
							Error2014 error = new Error2014();
							error.model_id = model.getId();
							error.bulk_upload_ui = domain.getUpload().getId();
							error.project_group_code = domain.getUpload().getProjectGroupCode();
							error.source_system_id = model.getSourceSystemId();
							error.type = ErrorType.ERROR;
							error.error_description = errorMessage;
							error.date_created = model.getDateCreated();
							performSave(error);
						}
						logger.error(errorMessage);
					}
				}
				hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2014.Affiliation.class.getSimpleName(), domain, exportEntity);
			}
		}
			
		public  com.servinglynk.hmis.warehouse.model.v2014.Affiliation getModelObject(ExportDomain domain, Affiliation affiliation,Data data, Map<String,HmisBaseModel> modelMap) {
			com.servinglynk.hmis.warehouse.model.v2014.Affiliation model = null;
			// We always insert for a Full refresh and update if the record exists for Delta refresh
			if(!isFullRefresh(domain))
				model = (com.servinglynk.hmis.warehouse.model.v2014.Affiliation) getModel(com.servinglynk.hmis.warehouse.model.v2014.Affiliation.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Affiliation.class, affiliation.getAffiliationID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
			
			if(model == null) {
				model = new com.servinglynk.hmis.warehouse.model.v2014.Affiliation();
				model.setId(UUID.randomUUID());
				model.setRecordToBeInserted(true);
				++data.i;
			}
			model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(affiliation.getDateUpdated()));
			model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(affiliation.getDateCreated()));
			hydrateCommonFields(model, domain,affiliation.getAffiliationID(),data,modelMap);
			return model;
		}
		
		   public com.servinglynk.hmis.warehouse.model.v2014.Affiliation createAffiliation(com.servinglynk.hmis.warehouse.model.v2014.Affiliation affiliation){
		       affiliation.setId(UUID.randomUUID()); 
		       insert(affiliation);
		       return affiliation;
		   }
		   public com.servinglynk.hmis.warehouse.model.v2014.Affiliation updateAffiliation(com.servinglynk.hmis.warehouse.model.v2014.Affiliation affiliation){
		       update(affiliation);
		       return affiliation;
		   }
		   public void deleteAffiliation(com.servinglynk.hmis.warehouse.model.v2014.Affiliation affiliation){
		       delete(affiliation);
		   }
		   public com.servinglynk.hmis.warehouse.model.v2014.Affiliation getAffiliationById(UUID affiliationId){ 
		       return (com.servinglynk.hmis.warehouse.model.v2014.Affiliation) get(com.servinglynk.hmis.warehouse.model.v2014.Affiliation.class, affiliationId);
		   }
		   public List<com.servinglynk.hmis.warehouse.model.v2014.Affiliation> getAllProjectAffiliations(UUID projectId,Integer startIndex, Integer maxItems){
		       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Affiliation.class);
		       criteria.createAlias("projectid", "projectid");
		       criteria.add(Restrictions.eq("projectid.id", projectId));
		       return (List<com.servinglynk.hmis.warehouse.model.v2014.Affiliation>) findByCriteria(criteria,startIndex,maxItems);
		   }
		   public long getProjectAffiliationsCount(UUID projectId){
		       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Affiliation.class);
		       criteria.createAlias("projectid", "projectid");
		       criteria.add(Restrictions.eq("projectid.id", projectId));
		       return countRows(criteria);
		   }
		
}

