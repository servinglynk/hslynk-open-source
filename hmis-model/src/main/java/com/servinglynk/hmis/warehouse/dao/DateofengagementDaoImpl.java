/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.DateOfEngagement;
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
				dateOfEngagementModel.setDateofengagement(BasicDataGenerator.getLocalDate(dateOfEngagement.getDateOfEngagement()));
				dateOfEngagementModel.setId(UUID.randomUUID());
				dateOfEngagementModel.setDateCreated(BasicDataGenerator.getLocalDate(dateOfEngagement.getDateCreated()));
				dateOfEngagementModel.setDateUpdated(BasicDataGenerator.getLocalDate(dateOfEngagement.getDateUpdated()));
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
				insert(target);
			}
		}
	}

}
