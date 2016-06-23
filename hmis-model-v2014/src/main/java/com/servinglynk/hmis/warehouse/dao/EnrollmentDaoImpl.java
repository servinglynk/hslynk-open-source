/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.hadoop.hbase.thrift2.generated.TColumnValue;
import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.apache.hadoop.hbase.thrift2.generated.TIOError;
import org.apache.hadoop.hbase.thrift2.generated.TPut;
import org.apache.thrift.TException;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.EnrollmentContinuouslyhomelessoneyearEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentDisablingconditionEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentHousingstatusEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentMonthshomelesspastthreeyearsEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentMonthshomelessthistimeEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentRelationshiptohohEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentResidencepriorEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentResidencepriorlengthofstayEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentStatusdocumentedEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentTimeshomelesspastthreeyearsEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
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
	public void hydrateStaging(ExportDomain domain) {
		Export export =  domain.getExport();
		List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment> enrollments = export
				.getEnrollment();
		hydrateBulkUploadActivityStaging(enrollments, com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class.getSimpleName(), domain);
		if (enrollments != null && enrollments.size() > 0) {
			int i=0;
			com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
			for(com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment enrollment  :  enrollments)
			{
				i++;
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
				enrollmentModel.setDateCreatedFromSource(BasicDataGenerator
						.getLocalDateTime(enrollment.getDateCreated()));
				enrollmentModel.setDateUpdatedFromSource(BasicDataGenerator
						.getLocalDateTime(enrollment.getDateUpdated()));
				enrollmentModel.setEntrydate(BasicDataGenerator
						.getLocalDateTime(enrollment.getEntryDate()));
				
				enrollmentModel
						.setMonthshomelesspastthreeyears(EnrollmentMonthshomelesspastthreeyearsEnum.lookupEnum(BasicDataGenerator.getStringValue(enrollment
								.getMonthsHomelessPastThreeYears())));
				enrollmentModel
						.setMonthshomelessthistime(EnrollmentMonthshomelessthistimeEnum.lookupEnum(BasicDataGenerator
								.getStringValue(enrollment
										.getMonthsHomelessThisTime())));
				enrollmentModel.setOtherresidenceprior(enrollment
						.getOtherResidencePrior());
				com.servinglynk.hmis.warehouse.model.v2014.Project project = (com.servinglynk.hmis.warehouse.model.v2014.Project) get(com.servinglynk.hmis.warehouse.model.v2014.Project.class,domain.getAffiliationProjectMap().get(enrollment.getProjectID()));
				enrollmentModel.setProject(project);
				enrollmentModel.setTimeshomelesspastthreeyears(EnrollmentTimeshomelesspastthreeyearsEnum.lookupEnum(BasicDataGenerator.getStringValue(enrollment.getTimesHomelessPastThreeYears())));
				UUID clientId = domain.getClientPersonalIDMap().get(enrollment.getPersonalID());
				if(clientId !=null) {
					com.servinglynk.hmis.warehouse.model.v2014.Client client = (com.servinglynk.hmis.warehouse.model.v2014.Client) get(com.servinglynk.hmis.warehouse.model.v2014.Client.class, clientId);
					//TODO: Need to add Unduping logic here and get a unique Client for enrollments.
					// Very important logic needs to come here via a Microservice call.
					LocalDateTime entryDate = enrollmentModel.getEntrydate();
					LocalDateTime dob = client.getDob();
					if(entryDate !=null && dob!=null) {
						LocalDateTime tempDateTime = LocalDateTime.from( dob );
						long years = tempDateTime.until( entryDate, ChronoUnit.YEARS);
						enrollmentModel.setAgeAtEntry(new Integer(String.valueOf(years)));
					}
					
					enrollmentModel.setClient(client);
				}else{
					logger.warn("A match was not found with the PersonID:{}",enrollment.getPersonalID());
				}
				enrollmentModel.setExport(exportEntity);

				enrollmentModel.setDateCreated(LocalDateTime.now());
				enrollmentModel.setDateUpdated(LocalDateTime.now());
				//enrollmentModel.setUser(exportEntity.getUser());
				exportEntity.addEnrollment(enrollmentModel);
				hydrateCommonFields(enrollmentModel, domain, enrollment.getProjectEntryID(),i);
			}
		}
		
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Enrollment getEnrollmentById(UUID enrollmentId) {
	return (com.servinglynk.hmis.warehouse.model.v2014.Enrollment) get(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class,enrollmentId);
	}

	@Override
	public com.servinglynk.hmis.warehouse.model.v2014.Enrollment createEnrollment(
			com.servinglynk.hmis.warehouse.model.v2014.Enrollment enrollment) {
			enrollment.setId(UUID.randomUUID());
			insert(enrollment);
		return enrollment;
	}

	@Override
	public com.servinglynk.hmis.warehouse.model.v2014.Enrollment updateEnrollment(
			com.servinglynk.hmis.warehouse.model.v2014.Enrollment enrollment) {
			update(enrollment);
		return enrollment;
	}

	@Override
	public void deleteEnrollment(
			com.servinglynk.hmis.warehouse.model.v2014.Enrollment enrollment) {
		delete(enrollment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2014.Enrollment getEnrollmentByClientIdAndEnrollmentId(
			UUID enrollmentId,UUID clientId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class);
		criteria.createAlias("client","client");
		criteria.add(Restrictions.eq("client.id",clientId));
		criteria.add(Restrictions.eq("id",enrollmentId));

		List<com.servinglynk.hmis.warehouse.model.v2014.Enrollment> enrollments = (List<com.servinglynk.hmis.warehouse.model.v2014.Enrollment>) findByCriteria(criteria);
		if(enrollments.size()>0) return enrollments.get(0); 
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2014.Enrollment> getEnrollmentsByClientId(UUID clientId,Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class);
		criteria.createAlias("client","client");
		criteria.add(Restrictions.eq("client.id",clientId));

		return (List<com.servinglynk.hmis.warehouse.model.v2014.Enrollment>) findByCriteria(criteria,startIndex,maxItems);
	}
	
	public long getEnrollmentCount(UUID clientId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class);
		criteria.createAlias("client","client");
		criteria.add(Restrictions.eq("client.id",clientId));
		return countRows(criteria);
	}
}

