/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.servinglynk.hmis.warehouse.enums.EnrollmentTimeshomelesspastthreeyearsEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
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
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		Export export =  domain.getExport();
		List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment> enrollments = export
				.getEnrollment();
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class, getProjectGroupCode(domain));
		Map<String,HmisBaseModel> projectModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Project.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap);
	
		if (enrollments != null && enrollments.size() > 0) {
			for(com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment enrollment  :  enrollments)
			{
				try {
				Enrollment enrollmentModel = getModelObject(domain, enrollment,data,modelMap);
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
				com.servinglynk.hmis.warehouse.model.v2014.Project project = (com.servinglynk.hmis.warehouse.model.v2014.Project) getModel(com.servinglynk.hmis.warehouse.model.v2014.Project.class,enrollment.getProjectID(),getProjectGroupCode(domain),false,projectModelMap);
				enrollmentModel.setProject(project);
				enrollmentModel.setTimeshomelesspastthreeyears(EnrollmentTimeshomelesspastthreeyearsEnum.lookupEnum(BasicDataGenerator.getStringValue(enrollment.getTimesHomelessPastThreeYears())));
				if(enrollment.getPersonalID() != null ) {
					com.servinglynk.hmis.warehouse.model.v2014.Client client = (com.servinglynk.hmis.warehouse.model.v2014.Client) getModel(com.servinglynk.hmis.warehouse.model.v2014.Client.class, enrollment.getPersonalID(), getProjectGroupCode(domain),true,relatedModelMap);
					//TODO: Need to add Unduping logic here and get a unique Client for enrollments.
					// Very important logic needs to come here via a Microservice call.
					LocalDateTime entryDate = enrollmentModel.getEntrydate();
					if(client != null) {
						LocalDateTime dob = client.getDob();
						if(entryDate !=null && dob!= null) {
							LocalDateTime tempDateTime = LocalDateTime.from( dob );
							long years = tempDateTime.until( entryDate, ChronoUnit.YEARS);
							enrollmentModel.setAgeAtEntry(new Integer(String.valueOf(years)));
						}
						enrollmentModel.setClient(client);
					}
				}
				enrollmentModel.setExport(exportEntity);
				//enrollmentModel.setUser(exportEntity.getUser());
					if(exportEntity !=null)
				exportEntity.addEnrollment(enrollmentModel);
				performSaveOrUpdate(enrollmentModel);
				} catch(Exception e ){
					String msg = "Exception in Enrollment:"+enrollment.getProjectEntryID()+ "Exception ::"+e.getLocalizedMessage();
					logger.error(msg);
					throw new Exception(msg, e);
				}
			}
			hydrateBulkUploadActivityStaging(data.i,data.j, Enrollment.class.getSimpleName(), domain, exportEntity);
		}
		
	}
	
	public  com.servinglynk.hmis.warehouse.model.v2014.Enrollment getModelObject(ExportDomain domain, com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment enrollment ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Enrollment enrollmentModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			enrollmentModel = (com.servinglynk.hmis.warehouse.model.v2014.Enrollment) getModel(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class, enrollment.getProjectEntryID(), getProjectGroupCode(domain),false,modelMap);
		
		if(enrollmentModel == null) {
			enrollmentModel = new com.servinglynk.hmis.warehouse.model.v2014.Enrollment();
			enrollmentModel.setId(UUID.randomUUID());
			enrollmentModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(enrollmentModel, domain,enrollment.getProjectEntryID(),data.i+data.j);
		return enrollmentModel;
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

