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
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HealthStatus;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.HealthStatusHealthCategoryEnum;
import com.servinglynk.hmis.warehouse.enums.HealthStatusHealthStatusEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Export;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class HealthStatusDaoImpl extends ParentDaoImpl implements
		HealthStatusDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<HealthStatus> healthStatuses = domain.getExport().getHealthStatus();
		hydrateBulkUploadActivityStaging(healthStatuses, com.servinglynk.hmis.warehouse.model.v2014.HealthStatus.class.getSimpleName(), domain);
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
		if(healthStatuses !=null &&  !healthStatuses.isEmpty())
		{
			int i=0;
			for(HealthStatus healthStatus : healthStatuses )
			{
				com.servinglynk.hmis.warehouse.model.v2014.HealthStatus healthStatusModel = new com.servinglynk.hmis.warehouse.model.v2014.HealthStatus();
				healthStatusModel.setId(UUID.randomUUID());
				healthStatusModel.setDueDate(BasicDataGenerator.getLocalDateTime(healthStatus.getDueDate()));
				healthStatusModel.setHealthCategory(HealthStatusHealthCategoryEnum.lookupEnum(BasicDataGenerator.getStringValue(healthStatus.getHealthCategory())));
				healthStatusModel.setHealthStatus(HealthStatusHealthStatusEnum.lookupEnum(BasicDataGenerator.getStringValue(healthStatus.getHealthStatus())));
				healthStatusModel.setInformationDate(BasicDataGenerator.getLocalDateTime(healthStatus.getInformationDate()));
				healthStatusModel.setDateCreated(LocalDateTime.now());
				healthStatusModel.setDateUpdated(LocalDateTime.now());
				healthStatusModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(healthStatus.getDateCreated()));
				healthStatusModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(healthStatus.getDateUpdated()));
				if(healthStatus.getProjectEntryID()!=null && !"".equals(healthStatus.getProjectEntryID())) {
					UUID uuid = domain.getEnrollmentProjectEntryIDMap().get(healthStatus.getProjectEntryID());
					if(uuid !=null) {
						Enrollment enrollmentModel = (Enrollment) get(Enrollment.class,uuid );
						healthStatusModel.setEnrollmentid(enrollmentModel);
					}
					
				}
				healthStatusModel.setExport(exportEntity);
				exportEntity.addHealthStatus(healthStatusModel);
				i++;
				hydrateCommonFields(healthStatusModel, domain, healthStatus.getHealthStatusID(),i);
				insert(healthStatusModel);
			}
      	  }
		}

	@Override
	public void hydrateLive(Export export, Long id) {
		Set<com.servinglynk.hmis.warehouse.model.v2014.HealthStatus> healthStatuses = export.getHealthStatuses();
		hydrateBulkUploadActivity(healthStatuses, com.servinglynk.hmis.warehouse.model.v2014.HealthStatus.class.getSimpleName(), export,id);
		if(healthStatuses !=null && !healthStatuses.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.v2014.HealthStatus healthStatus : healthStatuses) {
				if(healthStatus !=null) {
					com.servinglynk.hmis.warehouse.model.v2014.HealthStatus target = new com.servinglynk.hmis.warehouse.model.v2014.HealthStatus();
					BeanUtils.copyProperties(healthStatus, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2014.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.v2014.Enrollment) get(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class, healthStatus.getEnrollmentid().getId());
					target.setEnrollmentid(enrollmentModel);
					com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addHealthStatus(target);
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
	protected void performSave(Iface client, Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected List performGet(Iface client, Object entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	   public com.servinglynk.hmis.warehouse.model.v2014.HealthStatus createHealthStatus(com.servinglynk.hmis.warehouse.model.v2014.HealthStatus HealthStatus){
	       HealthStatus.setId(UUID.randomUUID()); 
	       insert(HealthStatus);
	       return HealthStatus;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.HealthStatus updateHealthStatus(com.servinglynk.hmis.warehouse.model.v2014.HealthStatus HealthStatus){
	       update(HealthStatus);
	       return HealthStatus;
	   }
	   public void deleteHealthStatus(com.servinglynk.hmis.warehouse.model.v2014.HealthStatus HealthStatus){
	       delete(HealthStatus);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.HealthStatus getHealthStatusById(UUID HealthStatusId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.HealthStatus) get(com.servinglynk.hmis.warehouse.model.v2014.HealthStatus.class, HealthStatusId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.HealthStatus> getAllEnrollmentHealthStatuses(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.HealthStatus.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.HealthStatus>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentHealthStatusesCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.HealthStatus.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
