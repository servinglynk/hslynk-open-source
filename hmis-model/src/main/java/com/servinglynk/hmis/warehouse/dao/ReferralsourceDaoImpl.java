/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ReferralSource;
import com.servinglynk.hmis.warehouse.enums.ReferralsourceReferralsourceEnum;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Referralsource;
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
		ReferralSource referralSource = domain.getExport().getReferralSource();
		if(referralSource !=null)
		{
			Referralsource referralsourceModel = new Referralsource();
			UUID id = UUID.randomUUID();
			referralsourceModel.setId(id);
			referralsourceModel.setDateCreated(BasicDataGenerator.getLocalDate(referralSource.getDateCreated()));
			referralsourceModel.setDateUpdated(BasicDataGenerator.getLocalDate(referralSource.getDateUpdated()));
			referralsourceModel.setReferralsource(ReferralsourceReferralsourceEnum.lookupEnum(BasicDataGenerator.getStringValue(referralSource.getReferralSource())));
			referralsourceModel.setCountoutreachreferralapproaches(BasicDataGenerator.getIntegerValue(referralSource.getCountOutreachReferralApproaches()));
			
			Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(referralSource.getProjectEntryID()));
			referralsourceModel.setEnrollmentid(enrollmentModel);
			com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
			referralsourceModel.setExport(exportEntity);
			exportEntity.addReferralsource(referralsourceModel);
			insertOrUpdate(referralsourceModel);
		}
	}

	@Override
	public void hydrateLive(Export export) {
		Set<Referralsource> referralsources = export.getReferralsources();
		if(referralsources != null && !referralsources.isEmpty()) {
			for(Referralsource referralsource : referralsources) {
				if(referralsource != null) {
					com.servinglynk.hmis.warehouse.model.live.Referralsource target = new com.servinglynk.hmis.warehouse.model.live.Referralsource();
					BeanUtils.copyProperties(referralsource, target,getNonCollectionFields(target));
					insert(target);
				}
			}
		}
	}

}
