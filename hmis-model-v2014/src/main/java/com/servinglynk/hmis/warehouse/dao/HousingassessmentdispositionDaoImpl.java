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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HousingAssessmentDisposition;
import com.servinglynk.hmis.warehouse.enums.HousingassessmentdispositionAssessmentdispositionEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.Exit;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class HousingassessmentdispositionDaoImpl extends ParentDaoImpl
		implements HousingassessmentdispositionDao {
	private static final Logger logger = LoggerFactory
			.getLogger(HousingassessmentdispositionDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<HousingAssessmentDisposition> housingAssessmentDispositions = domain.getExport().getHousingAssessmentDisposition();
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(Housingassessmentdisposition.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if(housingAssessmentDispositions !=null && !housingAssessmentDispositions.isEmpty()) 
		{
			for(HousingAssessmentDisposition housingAssessmentDisposition : housingAssessmentDispositions)
			{
				Housingassessmentdisposition model = null;
				try {
					model = getModelObject(domain, housingAssessmentDisposition,data,modelMap);
					model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(housingAssessmentDisposition.getDateCreated()));
					model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(housingAssessmentDisposition.getDateUpdated()));
					model.setAssessmentdisposition(HousingassessmentdispositionAssessmentdispositionEnum.lookupEnum(BasicDataGenerator.getStringValue(housingAssessmentDisposition.getAssessmentDisposition())));
					model.setOtherdisposition(housingAssessmentDisposition.getOtherDisposition());
					Exit exit = (Exit) getModel(Housingassessmentdisposition.class.getSimpleName(),Exit.class,housingAssessmentDisposition.getExitID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					model.setExitid(exit);
					model.setExport(exportEntity);
					
					performSaveOrUpdate(model);
				}catch(Exception e) {
					String errorMessage = "Exception in:"+housingAssessmentDisposition.getHousingAssessmentDispositionID()+  ":: Exception" +e.getLocalizedMessage();
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
		}
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition getModelObject(ExportDomain domain,HousingAssessmentDisposition housingAssessmentDisposition ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition) getModel(Housingassessmentdisposition.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition.class, housingAssessmentDisposition.getHousingAssessmentDispositionID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			
		}
		 com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition model = new com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition();
		  // org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		  model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(housingAssessmentDisposition.getDateUpdated()));
		  performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,housingAssessmentDisposition.getHousingAssessmentDispositionID(),data);
		
		return model;
	}
	   public com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition createHousingAssessmentDisposition(com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition housingAssessmentDisposition){
	       housingAssessmentDisposition.setId(UUID.randomUUID()); 
	       insert(housingAssessmentDisposition);
	       return housingAssessmentDisposition;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition updateHousingAssessmentDisposition(com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition housingAssessmentDisposition){
	       update(housingAssessmentDisposition);
	       return housingAssessmentDisposition;
	   }
	   public void deleteHousingAssessmentDisposition(com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition housingAssessmentDisposition){
	       delete(housingAssessmentDisposition);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition getHousingAssessmentDispositionById(UUID housingAssessmentDispositionId){ 
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition.class);
		      criteria.add(Restrictions.eq("id", housingAssessmentDispositionId));
		      List<com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition> entities = (List<com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;
	   }
	   
	   @SuppressWarnings("unchecked")
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition> getAllExitHousingAssessmentDispositions(UUID exitId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", exitId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getExitHousingAssessmentDispositionsCount(UUID exitId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", exitId));
	       return countRows(criteria);
	   }
}
