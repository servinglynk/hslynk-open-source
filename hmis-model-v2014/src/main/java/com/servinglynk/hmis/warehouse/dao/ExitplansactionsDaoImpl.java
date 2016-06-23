/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

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
import com.servinglynk.hmis.warehouse.model.v2014.Exit;
import com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ExitplansactionsDaoImpl extends ParentDaoImpl implements
		ExitplansactionsDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<ExitPlansActions> exitPlansActionsList = domain.getExport().getExitPlansActions();
		hydrateBulkUploadActivityStaging(exitPlansActionsList, com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions.class.getSimpleName(), domain);
		int i=0;
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
		if(exitPlansActionsList !=null && !exitPlansActionsList.isEmpty()) 
		{
			for(ExitPlansActions exitPlansActions : exitPlansActionsList)
			{
				Exitplansactions exitplansactionsModel = new Exitplansactions();
				exitplansactionsModel.setId(UUID.randomUUID());
				exitplansactionsModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(exitPlansActions.getDateCreated()));
				exitplansactionsModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(exitPlansActions.getDateUpdated()));

				exitplansactionsModel.setDateCreated(LocalDateTime.now());
				exitplansactionsModel.setDateUpdated(LocalDateTime.now());
				exitplansactionsModel.setAssistancemainstreambenefits(ExitplansactionsAssistancemainstreambenefitsEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getAssistanceMainstreamBenefits())));
				exitplansactionsModel.setExitcounseling(ExitplansactionsExitcounselingEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getExitCounseling())));
				exitplansactionsModel.setFurtherfollowupservices(ExitplansactionsFurtherfollowupservicesEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getFurtherFollowUpServices())));
				exitplansactionsModel.setOtheraftercareplanoraction(ExitplansactionsOtheraftercareplanoractionEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getOtherAftercarePlanOrAction())));
				exitplansactionsModel.setPermanenthousingplacement(ExitplansactionsPermanenthousingplacementEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getPermanentHousingPlacement())));
				exitplansactionsModel.setResourcepackage(ExitplansactionsResourcepackageEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getResourcePackage())));
				exitplansactionsModel.setScheduledfollowupcontacts(ExitplansactionsScheduledfollowupcontactsEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getScheduledFollowUpContacts())));
				exitplansactionsModel.setTemporaryshelterplacement(ExitplansactionsTemporaryshelterplacementEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getTemporaryShelterPlacement())));
				exitplansactionsModel.setWrittenaftercareplan(ExitplansactionsWrittenaftercareplanEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getWrittenAftercarePlan())));
				Exit exit = (Exit) get(Exit.class, domain.getExitMap().get(exitPlansActions.getExitID()));
				exitplansactionsModel.setExitid(exit);
				exitplansactionsModel.setExport(exportEntity);
				exportEntity.addExitplansactions(exitplansactionsModel);
				i++;
				hydrateCommonFields(exitplansactionsModel, domain,exitPlansActions.getExitPlansActionsID(),i);
			}
		}
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
