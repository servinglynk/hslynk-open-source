package com.servinglynk.hmis.warehouse.dao;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EntryRHY;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYAbuseAndNeglectFamEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYAbuseAndNeglectYouthEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYActiveMilitaryParentEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYAlcoholDrugAbuseFamEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYAlcoholDrugAbuseYouthEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYAskedOrForcedToExchangeForSexEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYAskedOrForcedToExchangeForSexPastThreeMonthsEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYChildWelfareYearsEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYCoercedToContinueWorkEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYExchangeForSexEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYExchangeForSexPastThreeMonthsEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYFormerWardChildWelfareEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYFormerWardJuvenileJusticeEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYHealthIssuesFamEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYHealthIssuesYouthEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYHouseholdDynamicsEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYHousingIssuesFamEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYHousingIssuesYouthEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYIncarceratedParentEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYIncarceratedParentStatusEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYInsufficientIncomeEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYJuvenileJusticeYearsEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYMentalDisabilityFamEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYMentalDisabilityYouthEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYMentalHealthIssuesFamEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYMentalHealthIssuesYouthEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYPhysicalDisabilityFamEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYPhysicalDisabilityYouthEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYSchoolEducationalIssuesFamEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYSchoolEducationalIssuesYouthEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYSexualOrientationGenderIDFamEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYSexualOrientationGenderIdentityYouthEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYUnemploymentFamEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYUnemploymentYouthEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYWorkPlaceViolenceThreatsEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYWorkplacePromiseDifferenceEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYcountOfExchangeForSexpEnum;
import com.servinglynk.hmis.warehouse.enums.SexualorientationSexualorientationEnum;
import com.servinglynk.hmis.warehouse.model.v2015.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2015.Entryrhy;
import com.servinglynk.hmis.warehouse.model.v2015.Error2015;
import com.servinglynk.hmis.warehouse.model.v2015.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class EntryrhyDaoImpl extends ParentDaoImpl implements  EntryrhyDao{
	private static final Logger logger = LoggerFactory
			.getLogger(EntryrhyDaoImpl.class);

	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
	    com.servinglynk.hmis.warehouse.domain.Sources.Source.Export export = domain.getExport();
	    com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Entryrhy.class, getProjectGroupCode(domain));
		List<EntryRHY> entryRhy = export.getEntryRHY();
		if (entryRhy != null && entryRhy.size() > 0) {
			for (EntryRHY entryRhys : entryRhy) {
				com.servinglynk.hmis.warehouse.model.v2015.Entryrhy entryRhyModel = null;
				try {
					entryRhyModel = getModelObject(domain, entryRhys,data,modelMap);
					entryRhyModel.setAbuseAndNeglectFamilyMbr(EntryRHYAbuseAndNeglectFamEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getAbuseAndNeglectFam())));
					entryRhyModel.setAbuseAndNeglectYouth(EntryRHYAbuseAndNeglectYouthEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getAbuseAndNeglectYouth())));
					entryRhyModel.setActiveMilitaryParent(EntryRHYActiveMilitaryParentEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getActiveMilitaryParent())));
					entryRhyModel.setAlcoholDrugAbuseFamilyMbr(EntryRHYAlcoholDrugAbuseFamEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getAlcoholDrugAbuseFam())));
					entryRhyModel.setAlcoholDrugAbuseYouth(EntryRHYAlcoholDrugAbuseYouthEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getAlcoholDrugAbuseYouth())));
					entryRhyModel.setAskedOfForcedToExchangeForSex(EntryRHYAskedOrForcedToExchangeForSexEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getAskedOrForcedToExchangeForSex())));
					entryRhyModel.setAskedOfForcedToExchangeForSexPastThreeMonths(EntryRHYAskedOrForcedToExchangeForSexPastThreeMonthsEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getAskedOrForcedToExchangeForSexPastThreeMonths())));
					entryRhyModel.setCoercedToContinueWork(EntryRHYCoercedToContinueWorkEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getCoercedToContinueWork())));
					entryRhyModel.setCountOfExchangeForSex(EntryRHYcountOfExchangeForSexpEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getCountOfExchangeForSex())));
					entryRhyModel.setCountOutReachReferralApproaches(BasicDataGenerator.getIntegerValue(entryRhys.getCountOutreachReferralApproaches()));
					entryRhyModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(entryRhys.getDateCreated()));
					entryRhyModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(entryRhys.getDateUpdated()));
					entryRhyModel.setDeleted(false);
					entryRhyModel.setExchangeForSex(EntryRHYExchangeForSexEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getExchangeForSex())));
					entryRhyModel.setExchangeForSexPastThreeMonths( EntryRHYExchangeForSexPastThreeMonthsEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getExchangeForSexPastThreeMonths())));
					entryRhyModel.setFormerlyWardChildWelfrForestCare(EntryRHYFormerWardChildWelfareEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getFormerWardChildWelfare())));
					entryRhyModel.setFormerlyWardOfJuvenileJustice(EntryRHYFormerWardJuvenileJusticeEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getFormerWardJuvenileJustice())));
					entryRhyModel.setHealthIssuesFamilyMbr(EntryRHYHealthIssuesFamEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getHealthIssuesFam())));
					entryRhyModel.setHealthIssuesYouth(EntryRHYHealthIssuesYouthEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getHealthIssuesYouth())));
					entryRhyModel.setHouseHoldDynamics(EntryRHYHouseholdDynamicsEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getHouseholdDynamics())));
					entryRhyModel.setHousingIssuesFamilyMbr(EntryRHYHousingIssuesFamEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getHousingIssuesFam())));
					entryRhyModel.setHousingIssuesYouth(EntryRHYHousingIssuesYouthEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getHousingIssuesYouth())));
					entryRhyModel.setIncarceratedParent(EntryRHYIncarceratedParentEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getIncarceratedParent())));
					entryRhyModel.setIncarceratedParentStatus(EntryRHYIncarceratedParentStatusEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getIncarceratedParentStatus())));
					entryRhyModel.setInsufficientIncomeToSupportYouth(EntryRHYInsufficientIncomeEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getInsufficientIncome())));
					entryRhyModel.setLaborExploitPastThreeMonths(BasicDataGenerator.getIntegerValue(entryRhys.getLaborExploitPastThreeMonths()));
					entryRhyModel.setMentalDisabilityFamilyMbr(EntryRHYMentalDisabilityFamEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getMentalDisabilityFam())));
					entryRhyModel.setMentalDisabilityYouth(EntryRHYMentalDisabilityYouthEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getMentalDisabilityYouth())));
					entryRhyModel.setMentalHealthIssuesFamilyMbr(EntryRHYMentalHealthIssuesFamEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getMentalHealthIssuesFam())));
					entryRhyModel.setMentalHealthIssuesYouth(EntryRHYMentalHealthIssuesYouthEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getMentalHealthIssuesYouth())));
					entryRhyModel.setMonthsChildWelfrForestCare(BasicDataGenerator.getIntegerValue(entryRhys.getChildWelfareMonths()));
//				entryRhyModel.setParentId(parentId);
					entryRhyModel.setPhysicalDisabilityFamilyMbr(EntryRHYPhysicalDisabilityFamEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getPhysicalDisabilityFam())));
					entryRhyModel.setPhysicalDisabilityYouth(EntryRHYPhysicalDisabilityYouthEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getPhysicalDisabilityYouth())));
					entryRhyModel.setReferralSource(BasicDataGenerator.getIntegerValue(entryRhys.getReferralSource()));
					entryRhyModel.setSchoolEducationIssuesFamilyMbr(EntryRHYSchoolEducationalIssuesFamEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getSchoolEducationalIssuesFam())));
					entryRhyModel.setSchoolEducationIssuesYouth(EntryRHYSchoolEducationalIssuesYouthEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getSchoolEducationalIssuesYouth())));
					entryRhyModel.setSexualOrientatiionGenderIdentityFamilyMbr(EntryRHYSexualOrientationGenderIDFamEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getSexualOrientationGenderIDFam())));
					entryRhyModel.setSexualOrientatiionGenderIdentityYouth(EntryRHYSexualOrientationGenderIdentityYouthEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getSexualOrientationGenderIDFam())));
					entryRhyModel.setSexualOrientation(SexualorientationSexualorientationEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getSexualOrientation())));
					entryRhyModel.setUnemployementFamilyMbr(EntryRHYUnemploymentFamEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getUnemploymentFam())));  ;
					entryRhyModel.setUnemployementYouth(EntryRHYUnemploymentYouthEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getUnemploymentYouth())));
//				entryRhyModel.setVersion(version);
					entryRhyModel.setWorkPlacePromiseDifference(EntryRHYWorkplacePromiseDifferenceEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getWorkplacePromiseDifference())));
					entryRhyModel.setWorkPlaceViolenceThreat(EntryRHYWorkPlaceViolenceThreatsEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getWorkPlaceViolenceThreats())));
					entryRhyModel.setYearsChildWelfrForestCare(EntryRHYChildWelfareYearsEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getChildWelfareYears())));
					entryRhyModel.setYearsJuvenileJustice(EntryRHYJuvenileJusticeYearsEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getJuvenileJusticeYears())));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, entryRhys.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					entryRhyModel.setEnrollmentid(enrollmentModel);
					entryRhyModel.setExport(exportEntity);
					entryRhyModel.setSync(false);
					entryRhyModel.setDeleted(false);
					entryRhyModel.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(BasicDataGenerator.getStringValue(entryRhys.getDataCollectionStage())));
					performSaveOrUpdate(entryRhyModel);
				} catch(Exception e) {
					String errorMessage = "Exception beause of the entryRhy::"+entryRhys.getEntryRHYID() +" Exception ::"+e.getMessage();
					if(entryRhyModel != null){
						Error2015 error = new Error2015();
						error.model_id = entryRhyModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = entryRhyModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = entryRhyModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
	  }
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2015.Entryrhy.class.getSimpleName(), domain,exportEntity);
	}

	public com.servinglynk.hmis.warehouse.model.v2015.Entryrhy getModelObject(ExportDomain domain, EntryRHY entryrhy ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2015.Entryrhy modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2015.Entryrhy) getModel(com.servinglynk.hmis.warehouse.model.v2015.Entryrhy.class, entryrhy.getEntryRHYID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2015.Entryrhy();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2015.Entryrhy model = new com.servinglynk.hmis.warehouse.model.v2015.Entryrhy();
		//org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(entryrhy.getDateUpdated()));
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,entryrhy.getEntryRHYID(),data);
		return model;
	}


	
	@Override
	public void hydrateLive(com.servinglynk.hmis.warehouse.model.v2015.Entryrhy entryRhy) {
			if(entryRhy !=null) {
				com.servinglynk.hmis.warehouse.model.v2015.Entryrhy target = new com.servinglynk.hmis.warehouse.model.v2015.Entryrhy();
				BeanUtils.copyProperties(entryRhy, target, new String[] {"enrollments","veteranInfoes"});
				com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, entryRhy.getExport().getId());
				exportEntity.addEntryrhy(target);
				target.setExport(exportEntity);
				com.servinglynk.hmis.warehouse.model.v2015.Entryrhy entryRhyByDedupCliendId = getEntryrhyByDedupEntryrhyId(entryRhy.getId(),entryRhy.getProjectGroupCode());
				if(entryRhyByDedupCliendId ==null) {
					insert(target);	
				}
			}
	}
	
	private Date getDateInFormat(String dob) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
        	formatter = new SimpleDateFormat("yyyy-MM-dd");
              date = (Date)((DateFormat) formatter).parse(dob);
            
            String s = formatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
	}

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Entryrhy createEntryrhy(com.servinglynk.hmis.warehouse.model.v2015.Entryrhy entryRhy) {
		entryRhy.setId(UUID.randomUUID());
			insert(entryRhy);
		return entryRhy;
	}


	@Override
	public Entryrhy updateEntryrhy(com.servinglynk.hmis.warehouse.model.v2015.Entryrhy entryRhy) {
			update(entryRhy);
		return entryRhy;
	}


	@Override
	public void deleteEntryrhy(com.servinglynk.hmis.warehouse.model.v2015.Entryrhy entryRhy) {
			delete(entryRhy);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Entryrhy getEntryrhyById(UUID entryrhyId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Entryrhy.class);
		criteria.add(Restrictions.eq("id", entryrhyId));
		List<com.servinglynk.hmis.warehouse.model.v2015.Entryrhy> entryrhy = (List<com.servinglynk.hmis.warehouse.model.v2015.Entryrhy>) findByCriteria(criteria);
		if(entryrhy.size()>0) return entryrhy.get(0);
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Entryrhy getEntryrhyByDedupEntryrhyId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Entryrhy.class);
		if(id == null || projectGroupCode == null) return null;
		criteria.add(Restrictions.eq("dedupClientId", id));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.v2015.Entryrhy> entryrhy = (List<com.servinglynk.hmis.warehouse.model.v2015.Entryrhy>) findByCriteria(criteria);
		if(entryrhy !=null && entryrhy.size()>0) return entryrhy.get(0);
		return null;
	}
	/*public com.servinglynk.hmis.warehouse.model.stagv2015.Coc getCocByDedupCliendIdFromStaging(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.stagv2015.Coc.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		List<com.servinglynk.hmis.warehouse.model.stagv2015.Coc> coc = (List<com.servinglynk.hmis.warehouse.model.stagv2015.Coc>) findByCriteria(criteria);
		if(coc !=null && coc.size()>0) return coc.get(0);
		return null;
	}*/

	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2015.Entryrhy> getAllEntryrhy(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Entryrhy.class);	
		List<com.servinglynk.hmis.warehouse.model.v2015.Entryrhy> entryrhy = (List<com.servinglynk.hmis.warehouse.model.v2015.Entryrhy>) findByCriteria(criteria,startIndex,maxItems);
		return entryrhy;
	}
	
	
	public long getEntryrhyCount(){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Entryrhy.class);	
		return countRows(criteria);
	}

	public List<Entryrhy> getAllEnrollmentEntryrhys(UUID enrollmentId, Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Entryrhy.class);	
		criteria.createAlias("enrollmentid","enrollmentid");
		criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
		return (List<Entryrhy>) findByCriteria(criteria, startIndex, maxItems);
	}
	public long getEnrollmentEntryrhysCount(UUID enrollmentId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Entryrhy.class);	
		criteria.createAlias("enrollmentid","enrollmentid");
		criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
		return countRows(criteria);
	}


}
