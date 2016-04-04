/**
 *
 */
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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitHousingAssessment;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.ExithousingassessmentHousingassessmentEnum;
import com.servinglynk.hmis.warehouse.enums.ExithousingassessmentSubsidyinformationEnum;
import com.servinglynk.hmis.warehouse.model.stagv2015.Exit;
import com.servinglynk.hmis.warehouse.model.stagv2015.Exithousingassessment;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ExithousingassessmentDaoImpl extends ParentDaoImpl implements
		ExithousingassessmentDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<ExitHousingAssessment> exitHousingAssessments = domain.getExport().getExitHousingAssessment();
		hydrateBulkUploadActivityStaging(exitHousingAssessments, com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment.class.getSimpleName(), domain);
		if(exitHousingAssessments !=null && !exitHousingAssessments.isEmpty())
		{
				for(ExitHousingAssessment exitHousingAssessment : exitHousingAssessments)
				{
					Exithousingassessment exithousingassessmentModel = new Exithousingassessment();
					exithousingassessmentModel.setId(UUID.randomUUID());
					exithousingassessmentModel.setDateCreated(LocalDateTime.now());
					exithousingassessmentModel.setDateUpdated(LocalDateTime.now());
					exithousingassessmentModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(exitHousingAssessment.getDateCreated()));
					exithousingassessmentModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(exitHousingAssessment.getDateUpdated()));
					exithousingassessmentModel.setHousingassessment(ExithousingassessmentHousingassessmentEnum.lookupEnum(BasicDataGenerator.getStringValue(exitHousingAssessment.getHousingAssessment())));
					exithousingassessmentModel.setSubsidyinformation(ExithousingassessmentSubsidyinformationEnum.lookupEnum(BasicDataGenerator.getStringValue(exitHousingAssessment.getSubsidyInformation())));
					Exit exit = (Exit) get(Exit.class, domain.getExitMap().get(exitHousingAssessment.getExitID()));
					exithousingassessmentModel.setExitid(exit);
					com.servinglynk.hmis.warehouse.model.stagv2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2015.Export) get(com.servinglynk.hmis.warehouse.model.stagv2015.Export.class, domain.getExportId());
					exithousingassessmentModel.setExport(exportEntity);
					exportEntity.addExithousingassessment(exithousingassessmentModel);
					exithousingassessmentModel.setProjectGroupCode(exitHousingAssessment.getExitID());
					hydrateCommonFields(exithousingassessmentModel, domain);
					insertOrUpdate(exithousingassessmentModel);
				}
		}
	}

	@Override
	public void hydrateLive(
			com.servinglynk.hmis.warehouse.model.stagv2015.Export export) {
		Set<Exithousingassessment> exithousingassessments = export.getExithousingassessments();
		if(exithousingassessments !=null && !exithousingassessments.isEmpty()) {
			for(Exithousingassessment exithousingassessment : exithousingassessments) {
				if(exithousingassessment !=null) {
					com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment target = new com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment();
					BeanUtils.copyProperties(exithousingassessment, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2015.Exit exitModel = (com.servinglynk.hmis.warehouse.model.v2015.Exit) get(com.servinglynk.hmis.warehouse.model.v2015.Exit.class, exithousingassessment.getExitid().getId());
					target.setExitid(exitModel);
					com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addExithousingassessment(target);
					target.setDateCreated(LocalDateTime.now());
					target.setDateUpdated(LocalDateTime.now());
					insertOrUpdate(target);
				}
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
	public com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment createExithousingassessment(com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment exithousingassessment) {
		exithousingassessment.setId(UUID.randomUUID());
			insert(exithousingassessment);
		return exithousingassessment;
	}


	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment updateExithousingassessment(com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment exithousingassessment) {
			update(exithousingassessment);
		return exithousingassessment;
	}


	@Override
	public void deleteExithousingassessment(com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment exithousingassessment) {
			delete(exithousingassessment);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment getExithousingassessmentById(UUID exithousingassessmentId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Entryssvf.class);
		criteria.add(Restrictions.eq("id", exithousingassessmentId));
		List<com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment> exithousingassessment = (List<com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment>) findByCriteria(criteria);
		if(exithousingassessment.size()>0) return exithousingassessment.get(0);
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment getExithousingassessmentByDedupExithousingassessmentId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment> exithousingassessment = (List<com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment>) findByCriteria(criteria);
		if(exithousingassessment !=null && exithousingassessment.size()>0) return exithousingassessment.get(0);
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
	public List<com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment> getAllExithousingassessment(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment.class);	
		List<com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment> exithousingassessment = (List<com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment>) findByCriteria(criteria,startIndex,maxItems);
		return exithousingassessment;
	}
	
	
	public long getExithousingassessmentCount(){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment.class);	
		return countRows(criteria);
	}

	@Override
	public void hydrateLive(Exithousingassessment exithousingassessment) {
		// TODO Auto-generated method stub
		
	}
	
	   public List<com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment> getAllExitExithousingassessments(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getExitExithousingassessmentsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
