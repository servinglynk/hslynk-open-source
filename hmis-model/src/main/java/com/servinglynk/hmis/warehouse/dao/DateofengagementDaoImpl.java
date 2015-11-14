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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.DateOfEngagement;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.staging.Dateofengagement;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class DateofengagementDaoImpl extends ParentDaoImpl implements
		DateofengagementDao {
	public void hydrateStaging(ExportDomain domain) 
	{
		List<DateOfEngagement> dateOfEngagements = domain.getExport().getDateOfEngagement();
		if(dateOfEngagements!=null &&!dateOfEngagements.isEmpty())
		{
			for(DateOfEngagement dateOfEngagement: dateOfEngagements)
			{
				Dateofengagement dateOfEngagementModel = new Dateofengagement();
				dateOfEngagementModel.setDateofengagement(BasicDataGenerator.getLocalDateTime(dateOfEngagement.getDateOfEngagement()));
				dateOfEngagementModel.setId(UUID.randomUUID());
				dateOfEngagementModel.setDateCreated(BasicDataGenerator.getLocalDateTime(dateOfEngagement.getDateCreated()));
				dateOfEngagementModel.setDateUpdated(BasicDataGenerator.getLocalDateTime(dateOfEngagement.getDateUpdated()));
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(dateOfEngagement.getProjectEntryID()));
				dateOfEngagementModel.setEnrollmentid(enrollmentModel);
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				dateOfEngagementModel.setExport(exportEntity);
				exportEntity.addDateofengagement(dateOfEngagementModel);
				insertOrUpdate(dateOfEngagementModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export) {
		Set<Dateofengagement> dateofengagements = export.getDateofengagements();
		if(dateofengagements != null && !dateofengagements.isEmpty()) {
			for(Dateofengagement dateofengagement : dateofengagements) {
				com.servinglynk.hmis.warehouse.model.live.Dateofengagement target = new com.servinglynk.hmis.warehouse.model.live.Dateofengagement();
				BeanUtils.copyProperties(dateofengagement, target,getNonCollectionFields(target));
				com.servinglynk.hmis.warehouse.model.live.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.live.Enrollment) get(com.servinglynk.hmis.warehouse.model.live.Enrollment.class, dateofengagement.getEnrollmentid().getId());
				target.setEnrollmentid(enrollmentModel);
				com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class, export.getId());
				target.setExport(exportEntity);
				exportEntity.addDateofengagement(target);
				target.setDateCreated(LocalDateTime.now());
				target.setDateUpdated(LocalDateTime.now());
				insertOrUpdate(target);
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

	   public com.servinglynk.hmis.warehouse.model.live.Dateofengagement createDateofengagement(com.servinglynk.hmis.warehouse.model.live.Dateofengagement dateofengagement){
	       dateofengagement.setId(UUID.randomUUID()); 
	       insert(dateofengagement);
	       return dateofengagement;
	   }
	   public com.servinglynk.hmis.warehouse.model.live.Dateofengagement updateDateofengagement(com.servinglynk.hmis.warehouse.model.live.Dateofengagement dateofengagement){
	       update(dateofengagement);
	       return dateofengagement;
	   }
	   public void deleteDateofengagement(com.servinglynk.hmis.warehouse.model.live.Dateofengagement dateofengagement){
	       delete(dateofengagement);
	   }
	   public com.servinglynk.hmis.warehouse.model.live.Dateofengagement getDateofengagementById(UUID dateofengagementId){ 
	       return (com.servinglynk.hmis.warehouse.model.live.Dateofengagement) get(com.servinglynk.hmis.warehouse.model.live.Dateofengagement.class, dateofengagementId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.live.Dateofengagement> getAllEnrollmentDateofengagements(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.live.Dateofengagement.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.live.Dateofengagement>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentDateofengagementsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.live.Dateofengagement.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
