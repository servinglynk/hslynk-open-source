/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.enums.EnrollmentContinuouslyhomelessoneyearEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentDisablingconditionEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentHousingstatusEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentMonthshomelesspastthreeyearsEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentMonthshomelessthistimeEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentRelationshiptohohEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentResidencepriorEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentResidencepriorlengthofstayEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentStatusdocumentedEnum;
import com.servinglynk.hmis.warehouse.model.live.ReleaseOfInfoEntity;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class EnrollmentDaoImpl extends ParentDaoImpl implements EnrollmentDao {
	@Autowired
	ParentDaoFactory parentDaoFactory;
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		Export export =  domain.getExport();
		List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment> enrollments = export
				.getEnrollment();
		if (enrollments != null && enrollments.size() > 0) {
			for(com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment enrollment  :  enrollments)
			{
				UUID enrollmentID = UUID.randomUUID();
				String projectEntryID = enrollment.getProjectEntryID();
				domain.getEnrollmentProjectEntryIDMap().put(projectEntryID,
						enrollmentID);
				domain.getEnrollmentProjectEntryIDMap().put(
						enrollment.getProjectID(), enrollmentID);
				domain.getEnrollmentProjectEntryIDMap().put(
						enrollment.getHouseholdID(), enrollmentID);
				domain.getEnrollmentProjectEntryIDMap().put(
						enrollment.getPersonalID(), enrollmentID);
				Enrollment enrollmentModel = new Enrollment();
				enrollmentModel.setId(enrollmentID);
				enrollmentModel
						.setContinuouslyhomelessoneyear(EnrollmentContinuouslyhomelessoneyearEnum.lookupEnum(BasicDataGenerator.getStringValue(enrollment
								.getContinuouslyHomelessOneYear())));
				enrollmentModel
						.setHousingstatus(EnrollmentHousingstatusEnum
								.lookupEnum(BasicDataGenerator
										.getStringValue(enrollment
												.getHousingStatus())));
				enrollmentModel
						.setDisablingcondition(EnrollmentDisablingconditionEnum.lookupEnum(BasicDataGenerator
								.getStringValue(enrollment
										.getDisablingCondition())));
				enrollmentModel.setYearshomeless(new Integer(
						BasicDataGenerator.getStringValue(enrollment
								.getYearsHomeless())));
				enrollmentModel
						.setResidenceprior(EnrollmentResidencepriorEnum
								.lookupEnum(BasicDataGenerator
										.getStringValue(enrollment
												.getResidencePrior())));
				enrollmentModel
						.setStatusdocumented(EnrollmentStatusdocumentedEnum.lookupEnum(BasicDataGenerator
								.getStringValue(enrollment
										.getStatusDocumented())));
				enrollmentModel
						.setResidencepriorlengthofstay(EnrollmentResidencepriorlengthofstayEnum.lookupEnum(BasicDataGenerator.getStringValue(enrollment
								.getResidencePriorLengthOfStay())));
				enrollmentModel
						.setRelationshiptohoh(EnrollmentRelationshiptohohEnum.lookupEnum(BasicDataGenerator
								.getStringValue(enrollment
										.getRelationshipToHoH())));
				enrollmentModel.setDateCreated(BasicDataGenerator
						.getLocalDate(enrollment.getDateCreated()));
				enrollmentModel.setDateUpdated(BasicDataGenerator
						.getLocalDate(enrollment.getDateUpdated()));
				enrollmentModel.setEntrydate(BasicDataGenerator
						.getLocalDate(enrollment.getEntryDate()));
				enrollmentModel
						.setMonthshomelesspastthreeyears(EnrollmentMonthshomelesspastthreeyearsEnum.lookupEnum(BasicDataGenerator.getStringValue(enrollment
								.getMonthsHomelessPastThreeYears())));
				enrollmentModel
						.setMonthshomelessthistime(EnrollmentMonthshomelessthistimeEnum.lookupEnum(BasicDataGenerator
								.getStringValue(enrollment
										.getMonthsHomelessThisTime())));
				enrollmentModel.setOtherresidenceprior(enrollment
						.getOtherResidencePrior());
				UUID clientId = domain.getClientPersonalIDMap().get(enrollment.getPersonalID());
				com.servinglynk.hmis.warehouse.model.staging.Client client = (com.servinglynk.hmis.warehouse.model.staging.Client) get(com.servinglynk.hmis.warehouse.model.staging.Client.class, clientId);
				//TODO: Need to add Unduping logic here and get a unique Client for enrollments.
				// Very important logic needs to come here via a Microservice call.
				enrollmentModel.setClient(client);
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				enrollmentModel.setExport(exportEntity);
				exportEntity.addEnrollment(enrollmentModel);
				insert(enrollmentModel);
			}
		}
	}

	@Override
	public void hydrateLive(
			com.servinglynk.hmis.warehouse.model.staging.Export export) {
		Set<Enrollment> enrollments = export.getEnrollments();
		if(enrollments != null && !enrollments.isEmpty()) {
			for(Enrollment enrollment : enrollments) {
				if(enrollment !=null) {
					com.servinglynk.hmis.warehouse.model.live.Enrollment target = new com.servinglynk.hmis.warehouse.model.live.Enrollment();
					BeanUtils.copyProperties(enrollment, target,getNonCollectionFields(target));
					parentDaoFactory.getClientDao().hydrateLive(enrollment.getClient());
					parentDaoFactory.getVeteranInfoDao().hydrateLive(enrollment.getClient());
					com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class, export.getId());
					target.setExport(exportEntity);
					insert(target);
				}
			}
		}
	}

	
	public com.servinglynk.hmis.warehouse.model.live.Enrollment getEnrollmentById(UUID enrollmentId) {
	return (com.servinglynk.hmis.warehouse.model.live.Enrollment) get(com.servinglynk.hmis.warehouse.model.live.Enrollment.class,enrollmentId);
	}

}

