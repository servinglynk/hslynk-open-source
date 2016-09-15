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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.YouthCriticalIssues;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesAbuseandneglectfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesAbuseandneglectyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesActivemilitaryparentEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesAlcoholdrugabusefamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesAlcoholdrugabuseyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHealthissuesfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHealthissuesyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHouseholddynamicsEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHousingissuesfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHousingissuesyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesIncarceratedparentEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesIncarceratedparentstatusEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesInsufficientincomeEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesMentaldisabilityfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesMentaldisabilityyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesMentalhealthissuesfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesMentalhealthissuesyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesPhysicaldisabilityfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesPhysicaldisabilityyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesSchooleducationalissuesfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesSchooleducationalissuesyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesSexualorientationgenderidfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesSexualorientationgenderidyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesUnemploymentfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesUnemploymentyouthEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class YouthcriticalissuesDaoImpl extends ParentDaoImpl implements
		YouthcriticalissuesDao {
	private static final Logger logger = LoggerFactory
			.getLogger(YouthcriticalissuesDaoImpl.class);


	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<YouthCriticalIssues> youthCriticalIssuesList = domain.getExport().getYouthCriticalIssues();
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(Youthcriticalissues.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if(youthCriticalIssuesList !=null && !youthCriticalIssuesList.isEmpty())
		{
			for(YouthCriticalIssues youthCriticalIssues : youthCriticalIssuesList)
			{
				Youthcriticalissues model = null;
				try {
					model = getModelObject(domain, youthCriticalIssues,data,modelMap);
					model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(youthCriticalIssues.getDateCreated()));
					model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(youthCriticalIssues.getDateUpdated()));
					model.setAbuseandneglectfam(YouthcriticalissuesAbuseandneglectfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getAbuseAndNeglectFam())));
					model.setAbuseandneglectyouth(YouthcriticalissuesAbuseandneglectyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getAbuseAndNeglectYouth())));
					model.setActivemilitaryparent(YouthcriticalissuesActivemilitaryparentEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getActiveMilitaryParent())));
					model.setAlcoholdrugabusefam(YouthcriticalissuesAlcoholdrugabusefamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getAlcoholDrugAbuseFam())));
					model.setAlcoholdrugabuseyouth(YouthcriticalissuesAlcoholdrugabuseyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getAlcoholDrugAbuseYouth())));
					model.setHealthissuesfam(YouthcriticalissuesHealthissuesfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getHealthIssuesFam())));
					model.setHealthissuesyouth(YouthcriticalissuesHealthissuesyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getHealthIssuesYouth())));
					model.setHouseholddynamics(YouthcriticalissuesHouseholddynamicsEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getHouseholdDynamics())));
					model.setHousingissuesfam(YouthcriticalissuesHousingissuesfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getHousingIssuesFam())));
					model.setHousingissuesyouth(YouthcriticalissuesHousingissuesyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getHousingIssuesYouth())));
					model.setIncarceratedparent(YouthcriticalissuesIncarceratedparentEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getIncarceratedParent())));
					model.setIncarceratedparentstatus(YouthcriticalissuesIncarceratedparentstatusEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getIncarceratedParentStatus())));
					model.setInsufficientincome(YouthcriticalissuesInsufficientincomeEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getInsufficientIncome())));
					model.setMentaldisabilityfam(YouthcriticalissuesMentaldisabilityfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getMentalDisabilityFam())));
					model.setMentaldisabilityyouth(YouthcriticalissuesMentaldisabilityyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getMentalDisabilityYouth())));
					model.setMentalhealthissuesfam(YouthcriticalissuesMentalhealthissuesfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getMentalHealthIssuesFam())));
					model.setMentalhealthissuesyouth(YouthcriticalissuesMentalhealthissuesyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getMentalHealthIssuesYouth())));
					model.setPhysicaldisabilityfam(YouthcriticalissuesPhysicaldisabilityfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getPhysicalDisabilityFam())));
					model.setPhysicaldisabilityyouth(YouthcriticalissuesPhysicaldisabilityyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getPhysicalDisabilityYouth())));
					model.setSchooleducationalissuesfam(YouthcriticalissuesSchooleducationalissuesfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getSchoolEducationalIssuesFam())));
					model.setSchooleducationalissuesyouth(YouthcriticalissuesSchooleducationalissuesyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getSchoolEducationalIssuesYouth())));
					model.setSexualorientationgenderidfam(YouthcriticalissuesSexualorientationgenderidfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getSexualOrientationGenderIDFam())));
					model.setSexualorientationgenderidyouth(YouthcriticalissuesSexualorientationgenderidyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getSexualOrientationGenderIDYouth())));
					model.setUnemploymentfam(YouthcriticalissuesUnemploymentfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getUnemploymentFam())));
					model.setUnemploymentyouth(YouthcriticalissuesUnemploymentyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getUnemploymentYouth())));
					model.setExport(exportEntity);
					Enrollment enrollmentModel = (Enrollment) getModel(Youthcriticalissues.class.getSimpleName(),Enrollment.class,youthCriticalIssues.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					model.setEnrollmentid(enrollmentModel);
					model.setInformationDate(BasicDataGenerator.getLocalDateTime(youthCriticalIssues.getInformationDate()));
					model.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getDataCollectionStage())));
					
					performSaveOrUpdate(model);
				}catch(Exception e) {
					String errorMessage = "Exception in youthCriticalIssues:"+youthCriticalIssues.getProjectEntryID()+  ":: Exception" +e.getLocalizedMessage();
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
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues.class.getSimpleName(), domain,exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues getModelObject(ExportDomain domain, YouthCriticalIssues youthcriticalissues ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues) getModel(Youthcriticalissues.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues.class, youthcriticalissues.getYouthCriticalIssuesID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues model = new com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues();
		  org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		  model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(youthcriticalissues.getDateUpdated()));
		  performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,youthcriticalissues.getYouthCriticalIssuesID(),data);
		return model;
	}
	   public com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues createYouthCriticalIssues(com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues youthCriticalIssues){
	       youthCriticalIssues.setId(UUID.randomUUID()); 
	       insert(youthCriticalIssues);
	       return youthCriticalIssues;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues updateYouthCriticalIssues(com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues youthCriticalIssues){
	       update(youthCriticalIssues);
	       return youthCriticalIssues;
	   }
	   public void deleteYouthCriticalIssues(com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues youthCriticalIssues){
	       delete(youthCriticalIssues);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues getYouthCriticalIssuesById(UUID youthCriticalIssuesId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues) get(com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues.class, youthCriticalIssuesId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues> getAllEnrollmentYouthCriticalIssuess(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentYouthCriticalIssuessCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
