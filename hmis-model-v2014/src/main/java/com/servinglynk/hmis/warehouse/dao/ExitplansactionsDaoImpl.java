/**
 * 
 */
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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitPlansActions;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsAssistancemainstreambenefitsEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsExitcounselingEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsFurtherfollowupservicesEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsOtheraftercareplanoractionEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsPermanenthousingplacementEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsResourcepackageEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsScheduledfollowupcontactsEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsTemporaryshelterplacementEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsWrittenaftercareplanEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.Exit;
import com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ExitplansactionsDaoImpl extends ParentDaoImpl implements
		ExitplansactionsDao {
	private static final Logger logger = LoggerFactory
			.getLogger(ExitplansactionsDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<ExitPlansActions> exitPlansActionsList = domain.getExport().getExitPlansActions();
		Data data=new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(Exitplansactions.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if(CollectionUtils.isNotEmpty(exitPlansActionsList)) {
			for(ExitPlansActions e :exitPlansActionsList) {
				processData(e, domain, data, modelMap, relatedModelMap, exportEntity);
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions.class.getSimpleName(), domain,exportEntity);
	}
	
	public void processData(ExitPlansActions exitPlansActions,ExportDomain domain,Data data,Map<String,HmisBaseModel> modelMap,Map<String,HmisBaseModel> relatedModelMap,com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity) {
		Exitplansactions model = null;
		try {
			model = getModelObject(domain, exitPlansActions,data,modelMap);
			model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(exitPlansActions.getDateCreated()));
			model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(exitPlansActions.getDateUpdated()));
			model.setAssistancemainstreambenefits(ExitplansactionsAssistancemainstreambenefitsEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getAssistanceMainstreamBenefits())));
			model.setExitcounseling(ExitplansactionsExitcounselingEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getExitCounseling())));
			model.setFurtherfollowupservices(ExitplansactionsFurtherfollowupservicesEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getFurtherFollowUpServices())));
			model.setOtheraftercareplanoraction(ExitplansactionsOtheraftercareplanoractionEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getOtherAftercarePlanOrAction())));
			model.setPermanenthousingplacement(ExitplansactionsPermanenthousingplacementEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getPermanentHousingPlacement())));
			model.setResourcepackage(ExitplansactionsResourcepackageEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getResourcePackage())));
			model.setScheduledfollowupcontacts(ExitplansactionsScheduledfollowupcontactsEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getScheduledFollowUpContacts())));
			model.setTemporaryshelterplacement(ExitplansactionsTemporaryshelterplacementEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getTemporaryShelterPlacement())));
			model.setWrittenaftercareplan(ExitplansactionsWrittenaftercareplanEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getWrittenAftercarePlan())));
			Exit exit = (Exit) getModel(Exitplansactions.class.getSimpleName(),Exit.class, exitPlansActions.getExitID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
			model.setExitid(exit);
			model.setExport(exportEntity);
			
			performSaveOrUpdate(model);
		} catch(Exception e) {
			String errorMessage = "Exception in:"+exitPlansActions.getExitPlansActionsID()+  ":: Exception" +e.getLocalizedMessage();
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
	public com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions getModelObject(ExportDomain domain, ExitPlansActions exitPlansActions ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions) getModel(Exitplansactions.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions.class, exitPlansActions.getExitPlansActionsID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			
		}
		 com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions model = new com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions();
		  // org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		  model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(exitPlansActions.getDateUpdated()));
		  performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,exitPlansActions.getExitPlansActionsID(),data);
		
		return model;
	}
	   public com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions createExitPlansActions(com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions exitPlansActions){
	       exitPlansActions.setId(UUID.randomUUID()); 
	       insert(exitPlansActions);
	       return exitPlansActions;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions updateExitPlansActions(com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions exitPlansActions){
	       update(exitPlansActions);
	       return exitPlansActions;
	   }
	   public void deleteExitPlansActions(com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions exitPlansActions){
	       delete(exitPlansActions);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions getExitPlansActionsById(UUID exitPlansActionsId){ 
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions.class);
		      criteria.add(Restrictions.eq("id", exitPlansActionsId));
		      List<com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions> entities = (List<com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;
	   }
	   
	   @SuppressWarnings("unchecked")
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions> getAllExitExitPlansActionss(UUID exitId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", exitId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getExitExitPlansActionssCount(UUID exitId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", exitId));
	       return countRows(criteria);
	   }
}
