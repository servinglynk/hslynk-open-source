package com.servinglynk.hmis.warehouse.dao;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EntryRHY;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.v2015.Entryrhy;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class EntryrhyDaoImpl extends ParentDaoImpl implements  EntryrhyDao{


	@Override
	public void hydrateStaging(ExportDomain domain) {
		
	    com.servinglynk.hmis.warehouse.domain.Sources.Source.Export export = domain.getExport();
		List<EntryRHY> entryRhy = export.getEntryRHY();
		hydrateBulkUploadActivityStaging(entryRhy, com.servinglynk.hmis.warehouse.model.v2015.Entryrhy.class.getSimpleName(), domain);
		if (entryRhy != null && entryRhy.size() > 0) {
			for (EntryRHY entryRhys : entryRhy) {
				com.servinglynk.hmis.warehouse.model.stagv2015.Entryrhy entryRhyModel = new com.servinglynk.hmis.warehouse.model.stagv2015.Entryrhy();
				UUID entryRhyUUID = UUID.randomUUID();
				entryRhyModel.setAbuseAndNeglectFamilyMbr(new Integer(entryRhys.getAbuseAndNeglectFam()).intValue());
				entryRhyModel.setAbuseAndNeglectYouth(new Integer(entryRhys.getAbuseAndNeglectYouth()).intValue());
				entryRhyModel.setActiveMilitaryParent(new Integer(entryRhys.getActiveMilitaryParent()).intValue());
				entryRhyModel.setAlcoholDrugAbuseFamilyMbr(new Integer(entryRhys.getAlcoholDrugAbuseFam()).intValue());
				entryRhyModel.setAlcoholDrugAbuseYouth(new Integer(entryRhys.getAlcoholDrugAbuseYouth()).intValue());
				entryRhyModel.setAskedOfForcedToExchangeForSex(new Integer(entryRhys.getAskedOrForcedToExchangeForSex()).intValue());
				entryRhyModel.setAskedOfForcedToExchangeForSexPastThreeMonths(new Integer(entryRhys.getAskedOrForcedToExchangeForSexPastThreeMonths()).intValue());
				entryRhyModel.setCoercedToContinueWork(new Integer(entryRhys.getCoercedToContinueWork()).intValue());
				entryRhyModel.setCountOfExchangeForSex(new Integer(entryRhys.getCountOfExchangeForSex()).intValue());
				entryRhyModel.setCountOutReachReferralApproaches(new Integer(entryRhys.getCountOutreachReferralApproaches()));
				entryRhyModel.setDateCreated(LocalDateTime.now());
				entryRhyModel.setDateUpdated(LocalDateTime.now());
				entryRhyModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(entryRhys.getDateCreated()));
				entryRhyModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(entryRhys.getDateUpdated()));
				entryRhyModel.setDeleted(false);
//				entryRhyModel.setEnrollmentid(enrollmentid);
				entryRhyModel.setExchangeForSex(new Integer(entryRhys.getExchangeForSex()).intValue());
				entryRhyModel.setExchangeForSexPastThreeMonths(new Integer(entryRhys.getExchangeForSexPastThreeMonths()).intValue());
//				entryRhyModel.setExport(export);
				entryRhyModel.setFormerlyWardChildWelfrForestCare(new Integer(entryRhys.getFormerWardChildWelfare()).intValue());
				entryRhyModel.setFormerlyWardOfJuvenileJustice(new Integer(entryRhys.getFormerWardJuvenileJustice()).intValue());
				entryRhyModel.setHealthIssuesFamilyMbr(new Integer(entryRhys.getHealthIssuesFam()).intValue());
				entryRhyModel.setHealthIssuesYouth(new Integer(entryRhys.getHealthIssuesYouth()).intValue());
				entryRhyModel.setHouseHoldDynamics(new Integer(entryRhys.getHouseholdDynamics()).intValue());
				entryRhyModel.setHousingIssuesFamilyMbr(new Integer(entryRhys.getHousingIssuesFam()).intValue());
				entryRhyModel.setHousingIssuesYouth(new Integer(entryRhys.getHousingIssuesYouth()).intValue());
				entryRhyModel.setId(entryRhyUUID);
				entryRhyModel.setIncarceratedParent(new Integer(entryRhys.getIncarceratedParent()).intValue());
				entryRhyModel.setIncarceratedParentStatus(new Integer(entryRhys.getIncarceratedParentStatus()).intValue());
				entryRhyModel.setInsufficientIncomeToSupportYouth(new Integer(entryRhys.getInsufficientIncome()).intValue());
				entryRhyModel.setLaborExploitPastThreeMonths(new Integer(entryRhys.getLaborExploitPastThreeMonths()).intValue());
				entryRhyModel.setMentalDisabilityFamilyMbr(new Integer(entryRhys.getMentalDisabilityFam()).intValue());
				entryRhyModel.setMentalDisabilityYouth(new Integer(entryRhys.getMentalDisabilityYouth()).intValue());
				entryRhyModel.setMentalHealthIssuesFamilyMbr(new Integer(entryRhys.getMentalHealthIssuesFam()).intValue());
				entryRhyModel.setMentalHealthIssuesYouth(new Integer(entryRhys.getMentalHealthIssuesYouth()).intValue());
				entryRhyModel.setMonthsChildWelfrForestCare(new Integer(entryRhys.getChildWelfareMonths()).intValue());
//				entryRhyModel.setParentId(parentId);
				entryRhyModel.setPhysicalDisabilityFamilyMbr(new Integer(entryRhys.getPhysicalDisabilityFam()).intValue());
				entryRhyModel.setPhysicalDisabilityYouth(new Integer(entryRhys.getPhysicalDisabilityYouth()));
				entryRhyModel.setProjectGroupCode(entryRhys.getProjectEntryID());
				entryRhyModel.setReferralSource(new Integer(entryRhys.getReferralSource()).intValue());
				entryRhyModel.setSchoolEducationIssuesFamilyMbr(new Integer(entryRhys.getSchoolEducationalIssuesFam()).intValue());
				entryRhyModel.setSchoolEducationIssuesYouth(new Integer(entryRhys.getSchoolEducationalIssuesYouth()).intValue());
				entryRhyModel.setSexualOrientatiionGenderIdentityFamilyMbr(new Integer(entryRhys.getSexualOrientationGenderIDFam()).intValue());
				entryRhyModel.setSexualOrientatiionGenderIdentityYouth(new Integer(entryRhys.getSexualOrientationGenderIDFam()).intValue());
				entryRhyModel.setSexualOrientation(new Integer(entryRhys.getSexualOrientation()).intValue());
				entryRhyModel.setUnemployementFamilyMbr(new Integer(entryRhys.getUnemploymentFam()).intValue());  ;
				entryRhyModel.setUnemployementYouth(new Integer(entryRhys.getUnemploymentYouth()).intValue());
				com.servinglynk.hmis.warehouse.model.stagv2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2015.Export) get(com.servinglynk.hmis.warehouse.model.stagv2015.Export.class, domain.getExportId());
				exportEntity.addEntryrhy(entryRhyModel);
				entryRhyModel.setUserId(exportEntity.getUserId());
//				entryRhyModel.setVersion(version);
				entryRhyModel.setWorkPlacePromiseDifference(new Integer(entryRhys.getWorkplacePromiseDifference()).intValue());
				entryRhyModel.setWorkPlaceViolenceThreat(new Integer(entryRhys.getWorkPlaceViolenceThreats()).intValue());
				entryRhyModel.setYearsChildWelfrForestCare(new Integer(entryRhys.getChildWelfareYears()).intValue());
				entryRhyModel.setYearsJuvenileJustice(new Integer(entryRhys.getJuvenileJusticeYears()).intValue());
				
				/*Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(entryRhys.getProjectEntryID()));
				entryRhyModel.setEnrollmentid(enrollmentModel);*/
				
				hydrateCommonFields(entryRhyModel, domain);
				entryRhyModel.setExport(exportEntity);
				entryRhyModel.setSync(false);
				entryRhyModel.setDeleted(false);
				insertOrUpdate(entryRhyModel);
				
			}
	}
	
	}



	@Override
	public void hydrateLive(com.servinglynk.hmis.warehouse.model.stagv2015.Export export) {
		Set<com.servinglynk.hmis.warehouse.model.stagv2015.Entryrhy> entryRhy = export.getEntryrhies();
		if(entryRhy !=null && !entryRhy.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.stagv2015.Entryrhy entryRhys : entryRhy) {
				//com.servinglynk.hmis.warehouse.model.v2015.Entryrhy entryrhyByDedupCliendId = getEntryrhyByDedupEntryrhyId(entryRhys.getId(),entryRhys.getProjectGroupCode());
			//	if(entryrhyByDedupCliendId ==null) {
					com.servinglynk.hmis.warehouse.model.v2015.Entryrhy target = new com.servinglynk.hmis.warehouse.model.v2015.Entryrhy();
					BeanUtils.copyProperties(entryRhys, target, new String[] {"enrollments","veteranInfoes"});
					com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, export.getId());
					exportEntity.addEntryrhy(target);
					target.setExport(exportEntity);
					insertOrUpdate(target);
		//		}
			}
		}
	}
	
	@Override
	public void hydrateLive(com.servinglynk.hmis.warehouse.model.stagv2015.Entryrhy entryRhy) {
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
	protected void performSave(Iface coc, Object entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected List performGet(Iface coc, Object entity) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}
	public long getEnrollmentEntryrhysCount(UUID enrollmentId) {
		// TODO Auto-generated method stub
		return 0;
	}


}
