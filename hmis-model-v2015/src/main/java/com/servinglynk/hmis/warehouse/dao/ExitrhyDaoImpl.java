package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitRHY;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.ExitRHYAssistanceMainstreamBenefitsEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYEarlyExitReasonEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYExitCounselingEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYFamilyReunificationAchievedEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYFurtherFollowUpServicesEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYOtherAftercarePlanOrActionEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYPermanentHousingPlacementEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYResourcePackageEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYScheduledFollowUpContactsEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYTemporaryShelterPlacementEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYWrittenAfterCarePlanEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectcompletionstatusProjectcompletionstatusEnum;
import com.servinglynk.hmis.warehouse.model.v2015.Exitrhy;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class ExitrhyDaoImpl extends ParentDaoImpl implements ExitrhyDao {

	@Override
	public void hydrateStaging(ExportDomain domain) {
		
	    com.servinglynk.hmis.warehouse.domain.Sources.Source.Export export = domain.getExport();
		List<ExitRHY> exitrhy = export.getExitRHY();
		hydrateBulkUploadActivityStaging(exitrhy, com.servinglynk.hmis.warehouse.model.v2015.Exitrhy.class.getSimpleName(), domain);
		if (exitrhy != null && exitrhy.size() > 0) {
			for (ExitRHY exitrhys : exitrhy) {
				com.servinglynk.hmis.warehouse.model.v2015.Exitrhy exitrhyModel = new com.servinglynk.hmis.warehouse.model.v2015.Exitrhy();
				UUID exitrhyUUID = UUID.randomUUID();
				exitrhyModel.setId(exitrhyUUID);
				exitrhyModel.setAssistanceMainStreamBenefits(ExitRHYAssistanceMainstreamBenefitsEnum.lookupEnum(BasicDataGenerator.getStringValue(exitrhys.getAssistanceMainstreamBenefits())));
				exitrhyModel.setEarlyExitReason(ExitRHYEarlyExitReasonEnum.lookupEnum(BasicDataGenerator.getStringValue(exitrhys.getEarlyExitReason())));
				exitrhyModel.setExitCounseling(ExitRHYExitCounselingEnum.lookupEnum(BasicDataGenerator.getStringValue(exitrhys.getExitCounseling())));
				/*com.servinglynk.hmis.warehouse.model.stagv2015.Export exports = (com.servinglynk.hmis.warehouse.model.stagv2015.Export) get(com.servinglynk.hmis.warehouse.model.stagv2015.Exit.class, domain.getExitMap().get(exitrhys.getExitID()));
				exitrhyModel.setExport(exports);*/
				exitrhyModel.setFamilyReunificationAchieved(ExitRHYFamilyReunificationAchievedEnum.lookupEnum(BasicDataGenerator.getStringValue(exitrhys.getFamilyReunificationAchieved())));
				exitrhyModel.setFurtherFollowupServices(ExitRHYFurtherFollowUpServicesEnum.lookupEnum(BasicDataGenerator.getStringValue(exitrhys.getFurtherFollowUpServices())));
				exitrhyModel.setOtherAftercarePlanOrAction(ExitRHYOtherAftercarePlanOrActionEnum.lookupEnum(BasicDataGenerator.getStringValue(exitrhys.getOtherAftercarePlanOrAction())));
				exitrhyModel.setPermenantHousingPlacement(ExitRHYPermanentHousingPlacementEnum.lookupEnum(BasicDataGenerator.getStringValue(exitrhys.getPermanentHousingPlacement())));
				exitrhyModel.setProjectCompletionStatus(ProjectcompletionstatusProjectcompletionstatusEnum.lookupEnum( BasicDataGenerator.getStringValue(exitrhys.getProjectCompletionStatus())));
				exitrhyModel.setResourcePackage(ExitRHYResourcePackageEnum.lookupEnum(BasicDataGenerator.getStringValue(exitrhys.getResourcePackage())));
				exitrhyModel.setScheduledFollowupContacts(ExitRHYScheduledFollowUpContactsEnum.lookupEnum(BasicDataGenerator.getStringValue(exitrhys.getScheduledFollowUpContacts())));
				exitrhyModel.setTempShelterPlacement(ExitRHYTemporaryShelterPlacementEnum.lookupEnum(BasicDataGenerator.getStringValue(exitrhys.getTemporaryShelterPlacement())));
				exitrhyModel.setWrittenAfterCarePlan(ExitRHYWrittenAfterCarePlanEnum.lookupEnum(BasicDataGenerator.getStringValue(exitrhys.getWrittenAftercarePlan())));
				
				com.servinglynk.hmis.warehouse.model.v2015.Exit exit = (com.servinglynk.hmis.warehouse.model.v2015.Exit) get(com.servinglynk.hmis.warehouse.model.v2015.Exit.class, domain.getExitMap().get(exitrhys.getExitID()));
				exitrhyModel.setExitid(exit);
				
				exitrhyModel.setDeleted(false);
				exitrhyModel.setDateCreated(LocalDateTime.now());
				exitrhyModel.setDateUpdated(LocalDateTime.now());
				/*Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(entryRhsps.getEntryRHSPID()));
				entryRhspModel.setEnrollmentid(enrollmentModel);*/
				com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, domain.getExportId());
				exportEntity.addExitrhy(exitrhyModel);
				exitrhyModel.setUserId(exportEntity.getUserId());
				exitrhyModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(exitrhys.getDateCreated()));
				exitrhyModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(exitrhys.getDateUpdated()));
				hydrateCommonFields(exitrhyModel, domain);
				exitrhyModel.setExport(exportEntity);
				exitrhyModel.setSync(false);
				insertOrUpdate(exitrhyModel);
			}
		}
	
	}


	@Override
	public void hydrateLive(com.servinglynk.hmis.warehouse.model.v2015.Export export, Long id) {
		Set<com.servinglynk.hmis.warehouse.model.v2015.Exitrhy> exitrhy = export.getExitrhies();
		hydrateBulkUploadActivity(exitrhy, com.servinglynk.hmis.warehouse.model.v2015.Exitrhy.class.getSimpleName(), export, id);
		if(exitrhy !=null && !exitrhy.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.v2015.Exitrhy exitrhys : exitrhy) {
				//com.servinglynk.hmis.warehouse.model.v2015.Exitrhy exitrhyByDedupCliendId = getExitrhyByDedupExitrhyId(exitrhys.getId(),exitrhys.getProjectGroupCode());
				//if(exitrhyByDedupCliendId ==null) {
					com.servinglynk.hmis.warehouse.model.v2015.Exitrhy target = new com.servinglynk.hmis.warehouse.model.v2015.Exitrhy();
					BeanUtils.copyProperties(exitrhys, target, new String[] {"enrollments","veteranInfoes"});
					com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, export.getId());
					exportEntity.addExitrhy(target);
					target.setExport(exportEntity);
					insertOrUpdate(target);
				}
		//	}
		}
	}
	
	@Override
	public void hydrateLive(com.servinglynk.hmis.warehouse.model.v2015.Exitrhy exitrhy) {
			if(exitrhy !=null) {
				com.servinglynk.hmis.warehouse.model.v2015.Exitrhy target = new com.servinglynk.hmis.warehouse.model.v2015.Exitrhy();
				BeanUtils.copyProperties(exitrhy, target, new String[] {"enrollments","veteranInfoes"});
				com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, exitrhy.getExport().getId());
				exportEntity.addExitrhy(target);
				target.setExport(exportEntity);
				com.servinglynk.hmis.warehouse.model.v2015.Exitrhy ExitrhyByDedupCliendId = getExitrhyByDedupExitrhyId(exitrhy.getId(),exitrhy.getProjectGroupCode());
				if(ExitrhyByDedupCliendId ==null) {
					insert(target);	
				}
			}
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
	public Exitrhy createExitrhy(Exitrhy exitrhy) {
		exitrhy.setId(UUID.randomUUID());
			insert(exitrhy);
		return exitrhy;
	}


	@Override
	public Exitrhy updateExitrhy(com.servinglynk.hmis.warehouse.model.v2015.Exitrhy exitrhy) {
			update(exitrhy);
		return exitrhy;
	}


	@Override
	public void deleteExitrhy(com.servinglynk.hmis.warehouse.model.v2015.Exitrhy exitrhy) {
			delete(exitrhy);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Exitrhy getExitrhyById(UUID ExitrhyId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Exitrhy.class);
		criteria.add(Restrictions.eq("id", ExitrhyId));
		List<com.servinglynk.hmis.warehouse.model.v2015.Exitrhy> exitrhy = (List<com.servinglynk.hmis.warehouse.model.v2015.Exitrhy>) findByCriteria(criteria);
		if(exitrhy.size()>0) return exitrhy.get(0);
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Exitrhy getExitrhyByDedupExitrhyId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Exitrhy.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.v2015.Exitrhy> exitrhy = (List<com.servinglynk.hmis.warehouse.model.v2015.Exitrhy>) findByCriteria(criteria);
		if(exitrhy !=null && exitrhy.size()>0) return exitrhy.get(0);
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
	public List<com.servinglynk.hmis.warehouse.model.v2015.Exitrhy> getAllExitrhy(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Exitrhy.class);	
		List<com.servinglynk.hmis.warehouse.model.v2015.Exitrhy> exitrhy = (List<com.servinglynk.hmis.warehouse.model.v2015.Exitrhy>) findByCriteria(criteria,startIndex,maxItems);
		return exitrhy;
	}
	
	
	public long getExitrhyCount(){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Exitrhy.class);	
		return countRows(criteria);
	}
	
	
	   public List<com.servinglynk.hmis.warehouse.model.v2015.Exitrhy> getAllExitExitrhys(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Exitrhy.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Exitrhy>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getExitExitrhysCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Exitrhy.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", enrollmentId));
	       return countRows(criteria);
	   }


}
