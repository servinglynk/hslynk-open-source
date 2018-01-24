/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
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
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
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
		Export export = domain.getExport();
		List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment> enrollments = export
				.getEnrollment();
		Data data = new Data();
		Map<String, HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class, getProjectGroupCode(domain));
		Map<String, HmisBaseModel> projectModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Project.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(Enrollment.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class, String.valueOf(domain.getExport().getExportID()), getProjectGroupCode(domain), false, exportModelMap, domain.getUpload().getId());

		if (CollectionUtils.isNotEmpty(enrollments)) {
			for(com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment enrollment : enrollments) {
				processData(enrollment, domain, data,modelMap,relatedModelMap,projectModelMap,exportEntity);
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, Enrollment.class.getSimpleName(), domain, exportEntity);
	}
		public void processData(com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment enrollment,ExportDomain domain,Data data,Map<String,HmisBaseModel> modelMap,Map<String,HmisBaseModel> relatedModelMap,Map<String,HmisBaseModel> projectModelMap, com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity) {
			Enrollment model = null;
			try {
			model = getModelObject(domain, enrollment, data, modelMap);
			model
					.setContinuouslyhomelessoneyear(EnrollmentContinuouslyhomelessoneyearEnum.lookupEnum(BasicDataGenerator.getStringValue(enrollment
							.getContinuouslyHomelessOneYear())));
			model.setHouseholdid(enrollment.getHouseholdID());
			model
					.setHousingstatus(EnrollmentHousingstatusEnum
							.lookupEnum(BasicDataGenerator
									.getStringValue(enrollment
											.getHousingStatus())));
			model
					.setDisablingcondition(EnrollmentDisablingconditionEnum.lookupEnum(BasicDataGenerator
							.getStringValue(enrollment
									.getDisablingCondition())));
			model.setYearshomeless(new Integer(
					BasicDataGenerator.getStringValue(enrollment
							.getYearsHomeless())));
			model
					.setResidenceprior(EnrollmentResidencepriorEnum
							.lookupEnum(BasicDataGenerator
									.getStringValue(enrollment
											.getResidencePrior())));
			model
					.setStatusdocumented(EnrollmentStatusdocumentedEnum.lookupEnum(BasicDataGenerator
							.getStringValue(enrollment
									.getStatusDocumented())));
			model
					.setResidencepriorlengthofstay(EnrollmentResidencepriorlengthofstayEnum.lookupEnum(BasicDataGenerator.getStringValue(enrollment
							.getResidencePriorLengthOfStay())));
			model
					.setRelationshiptohoh(EnrollmentRelationshiptohohEnum.lookupEnum(BasicDataGenerator
							.getStringValue(enrollment
									.getRelationshipToHoH())));
			model.setDateCreatedFromSource(BasicDataGenerator
					.getLocalDateTime(enrollment.getDateCreated()));
			model.setDateUpdatedFromSource(BasicDataGenerator
					.getLocalDateTime(enrollment.getDateUpdated()));
			model.setEntrydate(BasicDataGenerator
					.getLocalDateTime(enrollment.getEntryDate()));

			model
					.setMonthshomelesspastthreeyears(EnrollmentMonthshomelesspastthreeyearsEnum.lookupEnum(BasicDataGenerator.getStringValue(enrollment
							.getMonthsHomelessPastThreeYears())));
			model
					.setMonthshomelessthistime(EnrollmentMonthshomelessthistimeEnum.lookupEnum(BasicDataGenerator
							.getStringValue(enrollment
									.getMonthsHomelessThisTime())));
			model.setOtherresidenceprior(enrollment
					.getOtherResidencePrior());
			com.servinglynk.hmis.warehouse.model.v2014.Project project = (com.servinglynk.hmis.warehouse.model.v2014.Project) getModel(Enrollment.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Project.class, enrollment.getProjectID(), getProjectGroupCode(domain), true, projectModelMap, domain.getUpload().getId());
			model.setProject(project);
			model.setTimeshomelesspastthreeyears(EnrollmentTimeshomelesspastthreeyearsEnum.lookupEnum(BasicDataGenerator.getStringValue(enrollment.getTimesHomelessPastThreeYears())));
			if (enrollment.getPersonalID() != null) {
				com.servinglynk.hmis.warehouse.model.v2014.Client client = (com.servinglynk.hmis.warehouse.model.v2014.Client) getModel(Enrollment.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Client.class, enrollment.getPersonalID(), getProjectGroupCode(domain), true, relatedModelMap, domain.getUpload().getId());
				//TODO: Need to add Unduping logic here and get a unique Client for enrollments.
				// Very important logic needs to come here via a Microservice call.
				LocalDateTime entryDate = model.getEntrydate();
				if (client != null) {
					LocalDateTime dob = client.getDob();
					if (entryDate != null && dob != null) {
						LocalDateTime tempDateTime = LocalDateTime.from(dob);
						long years = tempDateTime.until(entryDate, ChronoUnit.YEARS);
						model.setAgeAtEntry(new Integer(String.valueOf(years)));
					}
					model.setClient(client);
				}
			}
			model.setExport(exportEntity);
			performSaveOrUpdate(model);
		} catch (Exception e) {
			String errorMessage = "Exception in Enrollment:" + enrollment.getProjectEntryID() + "Exception ::" + e.getLocalizedMessage();
			if (model != null) {
				Error2014 error = new Error2014();
				error.model_id = model.getId();
				error.bulk_upload_ui = domain.getUpload().getId();
				error.project_group_code = domain.getUpload().getProjectGroupCode();
				error.source_system_id = model.getSourceSystemId();
				error.type = ErrorType.ERROR;
				error.error_description = errorMessage;
				error.date_created = model.getDateCreated();
				performSave(error);
			}
			logger.error(errorMessage);
		}
	}
	
	public  com.servinglynk.hmis.warehouse.model.v2014.Enrollment getModelObject(ExportDomain domain, com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment enrollment ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Enrollment modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
	    modelFromDB = (com.servinglynk.hmis.warehouse.model.v2014.Enrollment) getModel(Enrollment.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class, enrollment.getProjectEntryID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		com.servinglynk.hmis.warehouse.model.v2014.Enrollment model = new com.servinglynk.hmis.warehouse.model.v2014.Enrollment();
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2014.Enrollment();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}else {
			  org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
			  model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(enrollment.getDateUpdated()));
			  performMatch(domain, modelFromDB, model, data);
		}

		hydrateCommonFields(model, domain,enrollment.getProjectEntryID(),data);
		
		return model;
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Enrollment getEnrollmentById(UUID enrollmentId) {
	      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class);
	      criteria.add(Restrictions.eq("id", enrollmentId));
	      List<com.servinglynk.hmis.warehouse.model.v2014.Enrollment> entities = (List<com.servinglynk.hmis.warehouse.model.v2014.Enrollment>) findByCriteria(criteria);
	      if(!entities.isEmpty()) return entities.get(0);
	      return null;
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
	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2014.Enrollment> getEnrollmentsByProjectGroupCode(String projectGroupCode,Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class);
		criteria.add(Restrictions.eq("projectGroupCode",projectGroupCode));
		return (List<com.servinglynk.hmis.warehouse.model.v2014.Enrollment>) findByCriteria(criteria,startIndex,maxItems);
	}
	@Override
	public long getEnrollmentCountByProjectGroupCode(String projectGroupCode) {
		Criteria criteria = getCurrentSession().createCriteria(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class);
		criteria.add(Restrictions.eq("projectGroupCode",projectGroupCode));
		criteria.setProjection(Projections.rowCount());
		long count=(Long) criteria.uniqueResult();
		return count;
	}
	
	@Override
	public com.servinglynk.hmis.warehouse.model.v2014.Enrollment getEnrollmentByProjectGroupCodeAndSourceSystem(String projectGroupCode,String sourceSystemId,String exportId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class);
		criteria.add(Restrictions.eq("projectGroupCode",projectGroupCode));
		criteria.add(Restrictions.eq("sourceSystemId",sourceSystemId));
		if(StringUtils.isNotEmpty(exportId)) {
			criteria.createAlias("export","export");
			criteria.add(Restrictions.eq("export.id",exportId));
		}
		criteria.add(Restrictions.eq("deleted",false));
		criteria.add(Restrictions.isNull("parentId"));
		criteria.addOrder( Order.desc("dateCreated") );
		@SuppressWarnings("unchecked")
		List<com.servinglynk.hmis.warehouse.model.v2014.Enrollment> models = (List<com.servinglynk.hmis.warehouse.model.v2014.Enrollment>) findByCriteria(criteria) ;
		if(CollectionUtils.isNotEmpty(models)) {
			return models.get(0);
		}
		return null;
	}
}

