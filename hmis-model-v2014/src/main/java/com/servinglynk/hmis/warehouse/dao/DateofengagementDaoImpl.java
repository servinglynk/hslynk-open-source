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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.DateOfEngagement;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Export;
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
		hydrateBulkUploadActivityStaging(dateOfEngagements, com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement.class.getSimpleName(), domain);
		int i=0;
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
		if(dateOfEngagements!=null &&!dateOfEngagements.isEmpty())
		{
			for(DateOfEngagement dateOfEngagement: dateOfEngagements)
			{
				Dateofengagement dateOfEngagementModel = new Dateofengagement();
				dateOfEngagementModel.setDateofengagement(BasicDataGenerator.getLocalDateTime(dateOfEngagement.getDateOfEngagement()));
				dateOfEngagementModel.setId(UUID.randomUUID());
				dateOfEngagementModel.setDateCreated(LocalDateTime.now());
				dateOfEngagementModel.setDateUpdated(LocalDateTime.now());
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(dateOfEngagement.getProjectEntryID()));
				dateOfEngagementModel.setEnrollmentid(enrollmentModel);
				dateOfEngagementModel.setExport(exportEntity);
				exportEntity.addDateofengagement(dateOfEngagementModel);
				dateOfEngagementModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(dateOfEngagement.getDateCreated()));
				dateOfEngagementModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(dateOfEngagement.getDateUpdated()));
				i++;
				hydrateCommonFields(dateOfEngagementModel, domain, dateOfEngagement.getDateOfEngagementID(),i);
				insert(dateOfEngagementModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export, Long id) {
		Set<Dateofengagement> dateofengagements = export.getDateofengagements();
		hydrateBulkUploadActivity(dateofengagements, com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement.class.getSimpleName(), export,id);
		if(dateofengagements != null && !dateofengagements.isEmpty()) {
			for(Dateofengagement dateofengagement : dateofengagements) {
				com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement target = new com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement();
				BeanUtils.copyProperties(dateofengagement, target,getNonCollectionFields(target));
				com.servinglynk.hmis.warehouse.model.v2014.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.v2014.Enrollment) get(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class, dateofengagement.getEnrollmentid().getId());
				target.setEnrollmentid(enrollmentModel);
				com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, export.getId());
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

	   public com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement createDateofengagement(com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement dateofengagement){
	       dateofengagement.setId(UUID.randomUUID()); 
	       insert(dateofengagement);
	       return dateofengagement;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement updateDateofengagement(com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement dateofengagement){
	       update(dateofengagement);
	       return dateofengagement;
	   }
	   public void deleteDateofengagement(com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement dateofengagement){
	       delete(dateofengagement);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement getDateofengagementById(UUID dateofengagementId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement) get(com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement.class, dateofengagementId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement> getAllEnrollmentDateofengagements(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentDateofengagementsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
