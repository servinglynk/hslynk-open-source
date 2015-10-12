/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ReferralSource;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
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
			referralsourceModel.setDateCreated(BasicDataGenerator.getLocalDateTime(referralSource.getDateCreated()));
			referralsourceModel.setDateUpdated(BasicDataGenerator.getLocalDateTime(referralSource.getDateUpdated()));
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
					com.servinglynk.hmis.warehouse.model.live.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.live.Enrollment) get(com.servinglynk.hmis.warehouse.model.live.Enrollment.class, referralsource.getEnrollmentid().getId());
					target.setEnrollmentid(enrollmentModel);
					com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addReferralsource(target);
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

}
