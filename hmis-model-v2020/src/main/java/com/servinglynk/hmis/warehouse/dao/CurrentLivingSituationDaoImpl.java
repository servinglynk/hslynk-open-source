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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.CurrentLivingSituation;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.LivingSituationEnum;
import com.servinglynk.hmis.warehouse.enums.NoYesEnum;
import com.servinglynk.hmis.warehouse.model.v2020.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2020.Error2020;
import com.servinglynk.hmis.warehouse.model.v2020.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class CurrentLivingSituationDaoImpl extends ParentDaoImpl implements CurrentLivingSituationDao {
	private static final Logger logger = LoggerFactory
			.getLogger(CurrentLivingSituationDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<CurrentLivingSituation> CurrentLivingSituationList  = domain.getExport().getCurrentLivingSituation();
		com.servinglynk.hmis.warehouse.model.v2020.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2020.Export) getModel(com.servinglynk.hmis.warehouse.model.v2020.Export.class,domain.getExport().getExportID(),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation.class, getProjectGroupCode(domain));
		if(CollectionUtils.isNotEmpty(CurrentLivingSituationList))
		{
			for(CurrentLivingSituation currentLivingSituation : CurrentLivingSituationList)
			{
				com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation currentLivingSituationModel = null;
				try {
					currentLivingSituationModel = getModelObject(domain, currentLivingSituation, data, modelMap);
					 if(currentLivingSituationModel.isIgnored()) {
							continue;
					 }
					currentLivingSituationModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(currentLivingSituation.getDateCreated()));
					currentLivingSituationModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(currentLivingSituation.getDateUpdated()));
					currentLivingSituationModel.setLivingSituation(LivingSituationEnum.lookupEnum(currentLivingSituation.getCurrentLivingSituation()));
					currentLivingSituationModel.setVerifiedBy(currentLivingSituation.getVerifiedBy());
					currentLivingSituationModel.setLeaseOwn60Day(NoYesEnum.lookupEnum(currentLivingSituation.getLeaseOwn60Day()));
					currentLivingSituationModel.setLeavesituation14days(NoYesEnum.lookupEnum(currentLivingSituation.getLeaveSituation14Days()));
					currentLivingSituationModel.setLocationdetails(currentLivingSituation.getLocationDetails());
					currentLivingSituationModel.setMovedtwoormore(NoYesEnum.lookupEnum(currentLivingSituation.getMovedTwoOrMore()));
					currentLivingSituationModel.setResourcestoobtain(NoYesEnum.lookupEnum(currentLivingSituation.getResourcesToObtain()));
					currentLivingSituationModel.setSubsequentresidence(NoYesEnum.lookupEnum(currentLivingSituation.getSubsequentResidence()));
					
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, currentLivingSituation.getEnrollmentID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					currentLivingSituationModel.setEnrollmentid(enrollmentModel);
					currentLivingSituationModel.setExport(exportEntity);
					
					performSaveOrUpdate(currentLivingSituationModel,domain);
				}catch(Exception e) {
					String errorMessage = "Exception beause of the CurrentLivingSituation::"+currentLivingSituation.getCurrentLivingSitID() +" Exception ::"+e.getMessage();
					if(currentLivingSituationModel != null){
						Error2020 error = new Error2020();
						error.model_id = currentLivingSituationModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = currentLivingSituationModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = currentLivingSituationModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
			hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation.class.getSimpleName(), domain,exportEntity);
		}
	}
	public com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation getModelObject(ExportDomain domain, CurrentLivingSituation currentLivingSituation ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation) getModel(com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation.class, currentLivingSituation.getCurrentLivingSitID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(domain.isReUpload()) {
			if(modelFromDB != null) {
				return modelFromDB;
			}
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true); 
data.i++;
			return modelFromDB;
		}
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true); 
data.i++;
		} else {
			com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation model = new com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation();
			// org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
			model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(currentLivingSituation.getDateUpdated()));
			performMatch(domain, modelFromDB, model, data);
		}
		hydrateCommonFields(modelFromDB, domain,currentLivingSituation.getCurrentLivingSitID(),data);
		return modelFromDB;
	}
	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}
	   public com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation createCurrentLivingSituation(com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation CurrentLivingSituation){
	       CurrentLivingSituation.setId(UUID.randomUUID());
	       insert(CurrentLivingSituation);
	       return CurrentLivingSituation;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation updateCurrentLivingSituation(com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation CurrentLivingSituation){
	       update(CurrentLivingSituation);
	       return CurrentLivingSituation;
	   }
	   public void deleteCurrentLivingSituation(com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation CurrentLivingSituation){
	       delete(CurrentLivingSituation);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation getCurrentLivingSituationById(UUID CurrentLivingSituationId){
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation.class);
		      criteria.add(Restrictions.eq("id", CurrentLivingSituationId));
		      List<com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation> entities = (List<com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation> getAllEnrollmentCurrentLivingSituations(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentCurrentLivingSituationsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
