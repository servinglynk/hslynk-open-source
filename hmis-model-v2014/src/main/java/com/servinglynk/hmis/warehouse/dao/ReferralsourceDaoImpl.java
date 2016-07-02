/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ReferralSource;
import com.servinglynk.hmis.warehouse.enums.ReferralsourceReferralsourceEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Referralsource;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ReferralsourceDaoImpl extends ParentDaoImpl implements
		ReferralsourceDao {
	private static final Logger logger = LoggerFactory
			.getLogger(ReferralsourceDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<ReferralSource> referralSources = domain.getExport().getReferralSource();
		hydrateBulkUploadActivityStaging(referralSources, com.servinglynk.hmis.warehouse.model.v2014.Referralsource.class.getSimpleName(), domain);
		int i=0;
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
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
				if(StringUtils.isNotBlank(referralSource.getProjectEntryID())) {
					UUID uuid = domain.getEnrollmentProjectEntryIDMap().get(referralSource.getProjectEntryID());
					if(uuid != null) {
						Enrollment enrollmentModel = (Enrollment) get(Enrollment.class,uuid);
						referralsourceModel.setEnrollmentid(enrollmentModel);
					}else {
						logger.warn("ReferralSource : A match was not found for Project EntryID:{}",referralSource.getProjectEntryID());
					}
				}
				referralsourceModel.setExport(exportEntity);
				exportEntity.addReferralsource(referralsourceModel);
				i++;
				hydrateCommonFields(referralsourceModel, domain, referralSource.getReferralSourceID(),i);
			}
		}
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
