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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Education;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.LastgradecompletedLastgradecompletedEnum;
import com.servinglynk.hmis.warehouse.enums.SchoolStatusEnum;
import com.servinglynk.hmis.warehouse.model.v2015.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2015.Export;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class EducationDaoImpl extends ParentDaoImpl implements EducationDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<Education> educationList  = domain.getExport().getEducation();
		hydrateBulkUploadActivityStaging(educationList, com.servinglynk.hmis.warehouse.model.v2015.Education.class.getSimpleName(), domain);
		if(educationList!=null && !educationList.isEmpty())
		{
			for(Education education : educationList)
			{
				com.servinglynk.hmis.warehouse.model.v2015.Education educationModel = new com.servinglynk.hmis.warehouse.model.v2015.Education();
				educationModel.setId(UUID.randomUUID());
				educationModel.setDateCreated(LocalDateTime.now());
				educationModel.setDateUpdated(LocalDateTime.now());
				educationModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(education.getDateCreated()));
				educationModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(education.getDateUpdated()));
				educationModel
				.setLastgradecompleted(LastgradecompletedLastgradecompletedEnum
						.lookupEnum(BasicDataGenerator
								.getStringValue(education
										.getLastGradeCompleted())));
				educationModel.setSchoolStatus(
						SchoolStatusEnum
						.lookupEnum(BasicDataGenerator
								.getStringValue(education.getSchoolStatus())));
				if(education.getProjectEntryID() !=null && !"".equals(education.getProjectEntryID())) {
					UUID uuid = domain.getEnrollmentProjectEntryIDMap().get((education.getProjectEntryID()));
					if(uuid !=null) {
						Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, uuid);
						educationModel.setEnrollmentid(enrollmentModel);
					}
				}
				com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, domain.getExportId());
				educationModel.setExport(exportEntity);
				hydrateCommonFields(educationModel, domain);
				exportEntity.addEducation(educationModel);
				insertOrUpdate(educationModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export,Long id) {
		Set<com.servinglynk.hmis.warehouse.model.v2015.Education> educations = export.getEducations();
		hydrateBulkUploadActivity(educations, com.servinglynk.hmis.warehouse.model.v2015.Education.class.getSimpleName(), export, id);
		if(educations != null && !educations.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.v2015.Education education : educations) {
				com.servinglynk.hmis.warehouse.model.v2015.Employment target = new com.servinglynk.hmis.warehouse.model.v2015.Employment();
				BeanUtils.copyProperties(education, target,getNonCollectionFields(target));
				com.servinglynk.hmis.warehouse.model.v2015.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.v2015.Enrollment) get(com.servinglynk.hmis.warehouse.model.v2015.Enrollment.class, education.getEnrollmentid().getId());
				target.setEnrollmentid(enrollmentModel);
				com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, export.getId());
				target.setExport(exportEntity);
				exportEntity.addEmployment(target);
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
	   public com.servinglynk.hmis.warehouse.model.v2015.Employment createEmployment(com.servinglynk.hmis.warehouse.model.v2015.Employment employment){
	       employment.setId(UUID.randomUUID());
	       insert(employment);
	       return employment;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Employment updateEmployment(com.servinglynk.hmis.warehouse.model.v2015.Employment employment){
	       update(employment);
	       return employment;
	   }
	   public void deleteEmployment(com.servinglynk.hmis.warehouse.model.v2015.Employment employment){
	       delete(employment);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Employment getEmploymentById(UUID employmentId){
	       return (com.servinglynk.hmis.warehouse.model.v2015.Employment) get(com.servinglynk.hmis.warehouse.model.v2015.Employment.class, employmentId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2015.Employment> getAllEnrollmentEmployments(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Employment.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Employment>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentEmploymentsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Employment.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
