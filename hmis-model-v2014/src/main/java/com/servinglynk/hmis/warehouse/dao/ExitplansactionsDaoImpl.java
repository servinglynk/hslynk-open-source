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
		if(exitPlansActionsList !=null && !exitPlansActionsList.isEmpty()) 
		{
			for(ExitPlansActions exitPlansActions : exitPlansActionsList)
			{
				Exitplansactions exitplansactionsModel = null;
				try {
					exitplansactionsModel = getModelObject(domain, exitPlansActions,data,modelMap);
					exitplansactionsModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(exitPlansActions.getDateCreated()));
					exitplansactionsModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(exitPlansActions.getDateUpdated()));
					exitplansactionsModel.setAssistancemainstreambenefits(ExitplansactionsAssistancemainstreambenefitsEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getAssistanceMainstreamBenefits())));
					exitplansactionsModel.setExitcounseling(ExitplansactionsExitcounselingEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getExitCounseling())));
					exitplansactionsModel.setFurtherfollowupservices(ExitplansactionsFurtherfollowupservicesEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getFurtherFollowUpServices())));
					exitplansactionsModel.setOtheraftercareplanoraction(ExitplansactionsOtheraftercareplanoractionEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getOtherAftercarePlanOrAction())));
					exitplansactionsModel.setPermanenthousingplacement(ExitplansactionsPermanenthousingplacementEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getPermanentHousingPlacement())));
					exitplansactionsModel.setResourcepackage(ExitplansactionsResourcepackageEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getResourcePackage())));
					exitplansactionsModel.setScheduledfollowupcontacts(ExitplansactionsScheduledfollowupcontactsEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getScheduledFollowUpContacts())));
					exitplansactionsModel.setTemporaryshelterplacement(ExitplansactionsTemporaryshelterplacementEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getTemporaryShelterPlacement())));
					exitplansactionsModel.setWrittenaftercareplan(ExitplansactionsWrittenaftercareplanEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getWrittenAftercarePlan())));
					Exit exit = (Exit) getModel(Exitplansactions.class.getSimpleName(),Exit.class, exitPlansActions.getExitID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					exitplansactionsModel.setExitid(exit);
					exitplansactionsModel.setExport(exportEntity);
					performSaveOrUpdate(exitplansactionsModel);
				} catch(Exception e) {
					String errorMessage = "Exception in:"+exitPlansActions.getExitPlansActionsID()+  ":: Exception" +e.getLocalizedMessage();
					if (exitplansactionsModel != null) {
						Error2014 error = new Error2014();
						error.model_id = exitplansactionsModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = exitplansactionsModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = exitplansactionsModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions.class.getSimpleName(), domain,exportEntity);
	}
	public com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions getModelObject(ExportDomain domain, ExitPlansActions exitPlansActions ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions exitplansactionsModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			exitplansactionsModel = (com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions) getModel(Exitplansactions.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions.class, exitPlansActions.getExitPlansActionsID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(exitplansactionsModel == null) {
			exitplansactionsModel = new com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions();
			exitplansactionsModel.setId(UUID.randomUUID());
			exitplansactionsModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(exitplansactionsModel, domain,exitPlansActions.getExitPlansActionsID(),data.i+data.j);
		return exitplansactionsModel;
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
	       return (com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions) get(com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions.class, exitPlansActionsId);
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
