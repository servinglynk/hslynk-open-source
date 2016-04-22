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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ReferralSource;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.ReferralsourceReferralsourceEnum;
import com.servinglynk.hmis.warehouse.model.stagv2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.stagv2014.Export;
import com.servinglynk.hmis.warehouse.model.stagv2014.Referralsource;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ReferralsourceDaoImpl extends ParentDaoImpl implements
		ReferralsourceDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<ReferralSource> referralSources = domain.getExport().getReferralSource();
		hydrateBulkUploadActivityStaging(referralSources, com.servinglynk.hmis.warehouse.model.v2014.Referralsource.class.getSimpleName(), domain);
		int i=0;
		com.servinglynk.hmis.warehouse.model.stagv2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2014.Export) get(com.servinglynk.hmis.warehouse.model.stagv2014.Export.class, domain.getExportId());
		if(referralSources !=null && !referralSources.isEmpty())
		{
			for(ReferralSource referralSource : referralSources) {
				Referralsource referralsourceModel = new Referralsource();
				UUID id = UUID.randomUUID();
				referralsourceModel.setId(id);
				referralsourceModel.setDateCreated(LocalDateTime.now());
				referralsourceModel.setDateUpdated(LocalDateTime.now());
				referralsourceModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(referralSource.getDateCreated()));
				referralsourceModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(referralSource.getDateUpdated()));
				referralsourceModel.setReferralsource(ReferralsourceReferralsourceEnum.lookupEnum(BasicDataGenerator.getStringValue(referralSource.getReferralSource())));
				referralsourceModel.setCountoutreachreferralapproaches(BasicDataGenerator.getIntegerValue(referralSource.getCountOutreachReferralApproaches()));
				
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(referralSource.getProjectEntryID()));
				referralsourceModel.setEnrollmentid(enrollmentModel);
				referralsourceModel.setExport(exportEntity);
				exportEntity.addReferralsource(referralsourceModel);
				i++;
				hydrateCommonFields(referralsourceModel, domain, referralSource.getReferralSourceID(),i);
				insert(referralsourceModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export, Long id) {
		Set<Referralsource> referralsources = export.getReferralsources();
		hydrateBulkUploadActivity(referralsources, com.servinglynk.hmis.warehouse.model.v2014.Referralsource.class.getSimpleName(), export,id);
			for(Referralsource referralsource : referralsources) {
				if(referralsource != null) {
					com.servinglynk.hmis.warehouse.model.v2014.Referralsource target = new com.servinglynk.hmis.warehouse.model.v2014.Referralsource();
					BeanUtils.copyProperties(referralsource, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2014.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.v2014.Enrollment) get(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class, referralsource.getEnrollmentid().getId());
					target.setEnrollmentid(enrollmentModel);
					com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addReferralsource(target);
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
	
	public com.servinglynk.hmis.warehouse.model.v2014.Referralsource createReferralsource(com.servinglynk.hmis.warehouse.model.v2014.Referralsource referralsource){
	       referralsource.setId(UUID.randomUUID()); 
	       insert(referralsource);
	       return referralsource;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Referralsource updateReferralsource(com.servinglynk.hmis.warehouse.model.v2014.Referralsource referralsource){
	       update(referralsource);
	       return referralsource;
	   }
	   public void deleteReferralsource(com.servinglynk.hmis.warehouse.model.v2014.Referralsource referralsource){
	       delete(referralsource);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Referralsource getReferralsourceById(UUID referralsourceId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Referralsource) get(com.servinglynk.hmis.warehouse.model.v2014.Referralsource.class, referralsourceId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Referralsource> getAllEnrollmentReferralsources(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Referralsource.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Referralsource>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentReferralsourcesCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Referralsource.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
