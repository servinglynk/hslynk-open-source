/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Employment;
import com.servinglynk.hmis.warehouse.enums.EmploymentEmployedEnum;
import com.servinglynk.hmis.warehouse.enums.EmploymentEmploymentTypeEnum;
import com.servinglynk.hmis.warehouse.enums.EmploymentNotEmployedReasonEnum;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class EmploymentDaoImpl extends ParentDaoImpl implements EmploymentDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<Employment> employmentList  = domain.getExport().getEmployment();
		if(employmentList!=null && !employmentList.isEmpty())
		{
			for(Employment employment : employmentList)
			{
				com.servinglynk.hmis.warehouse.model.staging.Employment employmentModel = new com.servinglynk.hmis.warehouse.model.staging.Employment();
				employmentModel.setId(UUID.randomUUID());
				employmentModel.setDateCreated(BasicDataGenerator.getLocalDate(employment.getDateCreated()));
				employmentModel.setDateUpdated(BasicDataGenerator.getLocalDate(employment.getDateUpdated()));
				employmentModel.setEmployed(EmploymentEmployedEnum.lookupEnum(BasicDataGenerator.getStringValue(employment.getEmployed())));
				employmentModel.setEmploymentType(EmploymentEmploymentTypeEnum.lookupEnum(BasicDataGenerator.getStringValue(employment.getEmploymentType())));;
				employmentModel.setNotEmployedReason(EmploymentNotEmployedReasonEnum.lookupEnum(BasicDataGenerator.getStringValue(employment.getNotEmployedReason())));
				employmentModel.setInformationDate(BasicDataGenerator.getLocalDate(employment.getInformationDate()));
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(employment.getProjectEntryID()));
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				employmentModel.setExport(exportEntity);
				employmentModel.setEnrollmentid(enrollmentModel);
				exportEntity.addEmployment(employmentModel);
				insertOrUpdate(employmentModel);				
			}
		}
	}

	@Override
	public void hydrateLive(Export export) {
		Set<com.servinglynk.hmis.warehouse.model.staging.Employment> employments = export.getEmployments();
		if(employments != null && !employments.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.staging.Employment employment : employments) {
				com.servinglynk.hmis.warehouse.model.live.Employment target = new com.servinglynk.hmis.warehouse.model.live.Employment();
				BeanUtils.copyProperties(employment, target,getNonCollectionFields(target));
				insert(target);
			}
		}
	}
}
