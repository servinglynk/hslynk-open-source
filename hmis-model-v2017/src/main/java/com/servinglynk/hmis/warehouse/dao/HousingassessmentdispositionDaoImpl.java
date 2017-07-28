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
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.HousingassessmentdispositionAssessmentdispositionEnum;
import com.servinglynk.hmis.warehouse.model.v2017.Error2016;
import com.servinglynk.hmis.warehouse.model.v2017.Exit;
import com.servinglynk.hmis.warehouse.model.v2017.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2017.Housingassessmentdisposition;
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
		com.servinglynk.hmis.warehouse.model.v2017.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2017.Export) getModel(com.servinglynk.hmis.warehouse.model.v2017.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2017.Housingassessmentdisposition.class, getProjectGroupCode(domain));
		List<HousingAssessmentDisposition> housingAssessmentDispositions = domain.getExport().getHousingAssessmentDisposition();
		if(housingAssessmentDispositions !=null && !housingAssessmentDispositions.isEmpty())
		{
			for(HousingAssessmentDisposition housingAssessmentDisposition : housingAssessmentDispositions)
			{
				Housingassessmentdisposition housingassessmentdispositionModel = null;
				try {
					housingassessmentdispositionModel = getModelObject(domain, housingAssessmentDisposition,data,modelMap);
					housingassessmentdispositionModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(housingAssessmentDisposition.getDateCreated()));
					housingassessmentdispositionModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(housingAssessmentDisposition.getDateUpdated()));
					housingassessmentdispositionModel.setAssessmentdisposition(HousingassessmentdispositionAssessmentdispositionEnum.lookupEnum(BasicDataGenerator.getStringValue(housingAssessmentDisposition.getAssessmentDisposition())));
					housingassessmentdispositionModel.setOtherdisposition(housingAssessmentDisposition.getOtherDisposition());
					Exit exit = (Exit) getModel(Exit.class,housingAssessmentDisposition.getExitID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					housingassessmentdispositionModel.setExitid(exit);
					housingassessmentdispositionModel.setExport(exportEntity);
					performSaveOrUpdate(housingassessmentdispositionModel);
				}catch(Exception e){
					String errorMessage = "Exception beause of the housingAssessmentDisposition::"+housingAssessmentDisposition.getHousingAssessmentDispositionID() +" Exception ::"+e.getMessage();
					if(housingassessmentdispositionModel != null){
						Error2016 error = new Error2016();
						error.model_id = housingassessmentdispositionModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = housingassessmentdispositionModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = housingassessmentdispositionModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2017.Housingassessmentdisposition.class.getSimpleName(), domain,exportEntity);
	}

	public com.servinglynk.hmis.warehouse.model.v2017.Housingassessmentdisposition getModelObject(ExportDomain domain, HousingAssessmentDisposition housingassessmentdisposition ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2017.Housingassessmentdisposition modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2017.Housingassessmentdisposition) getModel(com.servinglynk.hmis.warehouse.model.v2017.Housingassessmentdisposition.class, housingassessmentdisposition.getHousingAssessmentDispositionID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2017.Housingassessmentdisposition();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2017.Housingassessmentdisposition model = new com.servinglynk.hmis.warehouse.model.v2017.Housingassessmentdisposition();
		// org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(housingassessmentdisposition.getDateUpdated()));
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,housingassessmentdisposition.getHousingAssessmentDispositionID(),data);
		return model;
	}
	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}
	   public com.servinglynk.hmis.warehouse.model.v2017.Housingassessmentdisposition createHousingAssessmentDisposition(com.servinglynk.hmis.warehouse.model.v2017.Housingassessmentdisposition housingAssessmentDisposition){
	       housingAssessmentDisposition.setId(UUID.randomUUID());
	       insert(housingAssessmentDisposition);
	       return housingAssessmentDisposition;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2017.Housingassessmentdisposition updateHousingAssessmentDisposition(com.servinglynk.hmis.warehouse.model.v2017.Housingassessmentdisposition housingAssessmentDisposition){
	       update(housingAssessmentDisposition);
	       return housingAssessmentDisposition;
	   }
	   public void deleteHousingAssessmentDisposition(com.servinglynk.hmis.warehouse.model.v2017.Housingassessmentdisposition housingAssessmentDisposition){
	       delete(housingAssessmentDisposition);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2017.Housingassessmentdisposition getHousingAssessmentDispositionById(UUID housingAssessmentDispositionId){
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Housingassessmentdisposition.class);
		      criteria.add(Restrictions.eq("id", housingAssessmentDispositionId));
		      List<com.servinglynk.hmis.warehouse.model.v2017.Housingassessmentdisposition> entities = (List<com.servinglynk.hmis.warehouse.model.v2017.Housingassessmentdisposition>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;
	   }

	   @SuppressWarnings("unchecked")
	   public List<com.servinglynk.hmis.warehouse.model.v2017.Housingassessmentdisposition> getAllExitHousingAssessmentDispositions(UUID exitId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Housingassessmentdisposition.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", exitId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2017.Housingassessmentdisposition>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getExitHousingAssessmentDispositionsCount(UUID exitId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Housingassessmentdisposition.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", exitId));
	       return countRows(criteria);
	   }
}
