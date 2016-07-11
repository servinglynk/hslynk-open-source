/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.EnrollmentDisablingconditionEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentHousingstatusEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentMonthshomelesspastthreeyearsEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentRelationshiptohohEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentResidencepriorEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentResidencepriorlengthofstayEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentTimeshomelesspastthreeyearsEnum;
import com.servinglynk.hmis.warehouse.model.v2015.Project;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class EnrollmentDaoImpl extends ParentDaoImpl implements EnrollmentDao {
	private static final Logger logger = LoggerFactory
			.getLogger(EnrollmentDaoImpl.class);
	@Autowired
	ParentDaoFactory parentDaoFactory;
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) throws Exception {
		Export export =  domain.getExport();
		com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,domain.getExport().getExportID(),getProjectGroupCode(domain),false);
		Data data =new Data();
		List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment> enrollments = export
				.getEnrollment();
		if (enrollments != null && enrollments.size() > 0) {
			for(com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment enrollment  :  enrollments)
			{
				try {
					com.servinglynk.hmis.warehouse.model.v2015.Enrollment enrollmentModel = getModelObject(domain, enrollment, data);
//				enrollmentModel
//						.setContinuouslyhomelessoneyear(EnrollmentContinuouslyhomelessoneyearEnum.lookupEnum(BasicDataGenerator.getStringValue(enrollment
//								.getContinuouslyHomelessOneYear())));
					enrollmentModel
					.setHousingstatus(EnrollmentHousingstatusEnum
							.lookupEnum(BasicDataGenerator
									.getStringValue(enrollment
											.getHousingStatus())));
					enrollmentModel
					.setDisablingcondition(EnrollmentDisablingconditionEnum.lookupEnum(BasicDataGenerator
							.getStringValue(enrollment
									.getDisablingCondition())));
//				enrollmentModel.setYearshomeless(new Integer(
//						BasicDataGenerator.getStringValue(enrollment
//								.getYearsHomeless())));
					enrollmentModel
					.setResidenceprior(EnrollmentResidencepriorEnum
							.lookupEnum(BasicDataGenerator
									.getStringValue(enrollment
											.getResidencePrior())));
//				enrollmentModel
//						.setStatusdocumented(EnrollmentStatusdocumentedEnum.lookupEnum(BasicDataGenerator
//								.getStringValue(enrollment
//										.getStatusDocumented())));
					enrollmentModel
					.setResidencepriorlengthofstay(EnrollmentResidencepriorlengthofstayEnum.lookupEnum(BasicDataGenerator.getStringValue(enrollment
							.getResidencePriorLengthOfStay())));
					enrollmentModel
					.setRelationshiptohoh(EnrollmentRelationshiptohohEnum.lookupEnum(BasicDataGenerator
							.getStringValue(enrollment
									.getRelationshipToHoH())));
					enrollmentModel.setDateCreatedFromSource(BasicDataGenerator
							.getLocalDateTime(enrollment.getDateCreated()));
					enrollmentModel.setDateUpdatedFromSource(BasicDataGenerator
							.getLocalDateTime(enrollment.getDateUpdated()));
					enrollmentModel.setEntrydate(BasicDataGenerator
							.getLocalDateTime(enrollment.getEntryDate()));
					enrollmentModel
					.setMonthshomelesspastthreeyears(EnrollmentMonthshomelesspastthreeyearsEnum.lookupEnum(BasicDataGenerator.getStringValue(enrollment
							.getMonthsHomelessPastThreeYears())));
//				enrollmentModel
//						.setMonthshomelessthistime(EnrollmentMonthshomelessthistimeEnum.lookupEnum(BasicDataGenerator
//								.getStringValue(enrollment
//										.getMonthsHomelessThisTime())));
					enrollmentModel.setOtherresidenceprior(enrollment
							.getOtherResidencePrior());
					com.servinglynk.hmis.warehouse.model.v2015.Project project = (Project) getModel(com.servinglynk.hmis.warehouse.model.v2015.Project.class,enrollment.getProjectID(),getProjectGroupCode(domain),true);
					enrollmentModel.setProject(project);
					enrollmentModel.setTimeshomelesspastthreeyears(EnrollmentTimeshomelesspastthreeyearsEnum.lookupEnum(BasicDataGenerator.getStringValue(enrollment.getTimesHomelessPastThreeYears())));
					com.servinglynk.hmis.warehouse.model.v2015.Client client = (com.servinglynk.hmis.warehouse.model.v2015.Client) getModel(com.servinglynk.hmis.warehouse.model.v2015.Client.class, enrollment.getPersonalID(),getProjectGroupCode(domain),true);
					//TODO: Need to add Unduping logic here and get a unique Client for enrollments.
					// Very important logic needs to come here via a Microservice call.
					enrollmentModel.setClient(client);
					enrollmentModel.setExport(exportEntity);
					
					enrollmentModel.setUserId(exportEntity.getUserId());
					if(exportEntity !=null)
						exportEntity.addEnrollment(enrollmentModel);
					performSaveOrUpdate(enrollmentModel);
				} catch(Exception e) {
					logger.error("Exception beause of the enrollment::"+enrollment.getProjectEntryID() +" Exception ::"+e.getMessage());
					 throw new Exception(e);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2015.Enrollment.class.getSimpleName(), domain,exportEntity);
	}

	public com.servinglynk.hmis.warehouse.model.v2015.Enrollment getModelObject(ExportDomain domain, com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment enrollment ,Data data) {
		com.servinglynk.hmis.warehouse.model.v2015.Enrollment enrollmentModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			enrollmentModel = (com.servinglynk.hmis.warehouse.model.v2015.Enrollment) getModel(com.servinglynk.hmis.warehouse.model.v2015.Enrollment.class, enrollment.getProjectEntryID(), getProjectGroupCode(domain),false);
		
		if(enrollmentModel == null) {
			enrollmentModel = new com.servinglynk.hmis.warehouse.model.v2015.Enrollment();
			enrollmentModel.setId(UUID.randomUUID());
			enrollmentModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(enrollmentModel, domain,enrollment.getProjectEntryID(),data.i+data.j);
		return enrollmentModel;
	}
	public com.servinglynk.hmis.warehouse.model.v2015.Enrollment getEnrollmentById(UUID enrollmentId) {
	return (com.servinglynk.hmis.warehouse.model.v2015.Enrollment) get(com.servinglynk.hmis.warehouse.model.v2015.Enrollment.class,enrollmentId);
	}




	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Enrollment createEnrollment(
			com.servinglynk.hmis.warehouse.model.v2015.Enrollment enrollment) {
			enrollment.setId(UUID.randomUUID());
			insert(enrollment);
		return enrollment;
	}

	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Enrollment updateEnrollment(
			com.servinglynk.hmis.warehouse.model.v2015.Enrollment enrollment) {
			update(enrollment);
		return enrollment;
	}

	@Override
	public void deleteEnrollment(
			com.servinglynk.hmis.warehouse.model.v2015.Enrollment enrollment) {
		delete(enrollment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Enrollment getEnrollmentByClientIdAndEnrollmentId(
			UUID enrollmentId,UUID clientId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Enrollment.class);
		criteria.createAlias("client","client");
		criteria.add(Restrictions.eq("client.id",clientId));
		criteria.add(Restrictions.eq("id",enrollmentId));

		List<com.servinglynk.hmis.warehouse.model.v2015.Enrollment> enrollments = (List<com.servinglynk.hmis.warehouse.model.v2015.Enrollment>) findByCriteria(criteria);
		if(enrollments.size()>0) return enrollments.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2015.Enrollment> getEnrollmentsByClientId(UUID clientId,Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Enrollment.class);
		criteria.createAlias("client","client");
		criteria.add(Restrictions.eq("client.id",clientId));

		return (List<com.servinglynk.hmis.warehouse.model.v2015.Enrollment>) findByCriteria(criteria,startIndex,maxItems);
	}

	public long getEnrollmentCount(UUID clientId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Enrollment.class);
		criteria.createAlias("client","client");
		criteria.add(Restrictions.eq("client.id",clientId));
		return countRows(criteria);
	}

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}
}

