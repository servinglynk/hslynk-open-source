/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.common.security.AuditUtil;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.EnrollmentDisablingconditionEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentMonthshomelesspastthreeyearsEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentRelationshiptohohEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentTimeshomelesspastthreeyearsEnum;
import com.servinglynk.hmis.warehouse.enums.LengthOfStayEnum;
import com.servinglynk.hmis.warehouse.enums.LivingSituationEnum;
import com.servinglynk.hmis.warehouse.enums.NoYesEnum;
import com.servinglynk.hmis.warehouse.model.base.ClientMetaDataEntity;
import com.servinglynk.hmis.warehouse.model.v2020.Error2020;
import com.servinglynk.hmis.warehouse.model.v2020.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2020.Project;
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
		com.servinglynk.hmis.warehouse.model.v2020.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2020.Export) getModel(com.servinglynk.hmis.warehouse.model.v2020.Export.class,domain.getExport().getExportID(),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment> enrollments = export
				.getEnrollment();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Enrollment.class, getProjectGroupCode(domain));
		Map<String,HmisBaseModel> projectModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Project.class, getProjectGroupCode(domain));
		if (CollectionUtils.isNotEmpty(enrollments)) {
			for(com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment enrollment  :  enrollments)
			{
				com.servinglynk.hmis.warehouse.model.v2020.Enrollment enrollmentModel = null;
				try {
					enrollmentModel = getModelObject(domain, enrollment,data,modelMap);
//				enrollmentModel
//						.setContinuouslyhomelessoneyear(EnrollmentContinuouslyhomelessoneyearEnum.lookupEnum((enrollment
//								.getContinuouslyHomelessOneYear())));
//					enrollmentModel.setHousingstatus(EnrollmentHousingstatusEnum.lookupEnum((enrollment.getHousingStatus())));
					enrollmentModel.setDisablingcondition(EnrollmentDisablingconditionEnum.lookupEnum(enrollment.getDisablingCondition()));
					enrollmentModel.setRelationshiptohoh(EnrollmentRelationshiptohohEnum.lookupEnum((enrollment.getRelationshipToHoH())));
					enrollmentModel.setLivingSituation(LivingSituationEnum.lookupEnum(enrollment.getLivingSituation()));
					enrollmentModel.setLengthOfStay(LengthOfStayEnum.lookupEnum(enrollment.getLengthOfStay()));
					enrollmentModel.setDateCreatedFromSource(BasicDataGenerator
							.getLocalDateTime(enrollment.getDateCreated()));
					enrollmentModel.setDateUpdatedFromSource(BasicDataGenerator
							.getLocalDateTime(enrollment.getDateUpdated()));
					enrollmentModel.setEntrydate(BasicDataGenerator
							.getLocalDateTime(enrollment.getEntryDate()));
					enrollmentModel
					.setMonthshomelesspastthreeyears(EnrollmentMonthshomelesspastthreeyearsEnum.lookupEnum(enrollment
							.getMonthsHomelessPastThreeYears()));
					enrollmentModel.setHouseholdid(enrollment.getHouseholdID());
					enrollmentModel.setDatetostreetessh(BasicDataGenerator
							.getLocalDateTime(enrollment.getDateToStreetESSH()));
//				enrollmentModel
//						.setMonthshomelessthistime(EnrollmentMonthshomelessthistimeEnum.lookupEnum(BasicDataGenerator
//								.getStringValue(enrollment
//										.getMonthsHomelessThisTime())));
//					enrollmentModel.setOtherresidenceprior(enrollment
//							.getOtherResidencePrior());
					enrollmentModel.setLosunderthreshold(NoYesEnum.lookupEnum(enrollment.getLosUnderThreshold()));
					enrollmentModel.setPreviousStreetESSH(NoYesEnum.lookupEnum(enrollment.getPreviousStreetESSH()));
					com.servinglynk.hmis.warehouse.model.v2020.Project project = (Project) getModel(com.servinglynk.hmis.warehouse.model.v2020.Project.class,enrollment.getProjectID(),getProjectGroupCode(domain),true,projectModelMap, domain.getUpload().getId());
					enrollmentModel.setProject(project);
					enrollmentModel.setTimeshomelesspastthreeyears(EnrollmentTimeshomelesspastthreeyearsEnum.lookupEnum(enrollment.getTimesHomelessPastThreeYears()));
					com.servinglynk.hmis.warehouse.model.v2020.Client client = (com.servinglynk.hmis.warehouse.model.v2020.Client) getModel(com.servinglynk.hmis.warehouse.model.v2020.Client.class, enrollment.getPersonalID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					//TODO: Need to add Unduping logic here and get a unique Client for enrollments.
					// Very important logic needs to come here via a Microservice call.
					enrollmentModel.setClient(client);
					enrollmentModel.setExport(exportEntity);
					performSaveOrUpdate(enrollmentModel, domain);
//					if(!enrollmentModel.isIgnored()) createClientMedataInfo(enrollmentModel);
				} catch(Exception e) {
					String errorMessage = "Exception beause of the enrollment::"+enrollment.getEnrollmentID() +" Exception ::"+e.getMessage();
					if(enrollmentModel != null){
						Error2020 error = new Error2020();
						error.model_id = enrollmentModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = enrollmentModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = enrollmentModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2020.Enrollment.class.getSimpleName(), domain,exportEntity);
	}

	public com.servinglynk.hmis.warehouse.model.v2020.Enrollment getModelObject(ExportDomain domain, com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment enrollment ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2020.Enrollment modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2020.Enrollment) getModel(com.servinglynk.hmis.warehouse.model.v2020.Enrollment.class, enrollment.getEnrollmentID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2020.Enrollment();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2020.Enrollment model = new com.servinglynk.hmis.warehouse.model.v2020.Enrollment();
		// org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(enrollment.getDateUpdated()));
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(modelFromDB, domain,enrollment.getEnrollmentID(),data);
		return modelFromDB;
	}
	public com.servinglynk.hmis.warehouse.model.v2020.Enrollment getEnrollmentById(UUID enrollmentId) {
	      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Enrollment.class);
	      criteria.add(Restrictions.eq("id", enrollmentId));
	      List<com.servinglynk.hmis.warehouse.model.v2020.Enrollment> entities = (List<com.servinglynk.hmis.warehouse.model.v2020.Enrollment>) findByCriteria(criteria);
	      if(!entities.isEmpty()) return entities.get(0);
	      return null;
	}




	@Override
	public com.servinglynk.hmis.warehouse.model.v2020.Enrollment createEnrollment(
			com.servinglynk.hmis.warehouse.model.v2020.Enrollment enrollment) {
			enrollment.setId(UUID.randomUUID());
			insert(enrollment);
			createClientMedataInfo(enrollment);
		return enrollment;
	}

	@Override
	public com.servinglynk.hmis.warehouse.model.v2020.Enrollment updateEnrollment(
			com.servinglynk.hmis.warehouse.model.v2020.Enrollment enrollment) {
			update(enrollment);
		return enrollment;
	}

	@Override
	public void deleteEnrollment(
			com.servinglynk.hmis.warehouse.model.v2020.Enrollment enrollment) {
		delete(enrollment);
		deleteClientMedataInfo(enrollment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2020.Enrollment getEnrollmentByClientIdAndEnrollmentId(
			UUID enrollmentId,UUID clientId) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Enrollment.class);
		criteria.createAlias("client","client");
		criteria.add(Restrictions.eq("client.id",clientId));
		criteria.add(Restrictions.eq("id",enrollmentId));
		
		List<com.servinglynk.hmis.warehouse.model.v2020.Enrollment> enrollments = (List<com.servinglynk.hmis.warehouse.model.v2020.Enrollment>) findByCriteria(criteria);
		if(enrollments.size()>0) return enrollments.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2020.Enrollment> getEnrollmentsByClientId(UUID clientId,Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Enrollment.class);
		criteria.createAlias("client","client");
		criteria.add(Restrictions.eq("client.id",clientId));

		return (List<com.servinglynk.hmis.warehouse.model.v2020.Enrollment>) findByCriteria(criteria,startIndex,maxItems);
	}

	public long getEnrollmentCount(UUID clientId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Enrollment.class);
		criteria.createAlias("client","client");
		criteria.add(Restrictions.eq("client.id",clientId));
		return countRows(criteria);
	}

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}
	
	public void createClientMedataInfo(com.servinglynk.hmis.warehouse.model.v2020.Enrollment enrollment) {
		ClientMetaDataEntity metaDataEntity = new ClientMetaDataEntity();
		metaDataEntity.setId(UUID.randomUUID());
		metaDataEntity.setClientId(enrollment.getClient().getId());
		metaDataEntity.setClientDedupId(enrollment.getClient().getDedupClientId());
		metaDataEntity.setDate(LocalDateTime.now());
		metaDataEntity.setDateCreated(LocalDateTime.now());
		metaDataEntity.setDateUpdated(LocalDateTime.now());
		metaDataEntity.setDeleted(false);
		metaDataEntity.setMetaDataIdentifier(enrollment.getId());
		metaDataEntity.setType("enrollments");
		metaDataEntity.setProjectGroupCode(enrollment.getProjectGroupCode());
		metaDataEntity.setUserId(enrollment.getUserId());
		metaDataEntity.setAdditionalInfo("{\"enrollmentId\":\""+enrollment.getId()+"\",\"schemaYear\":\"2020\",\"clientId\":\""+enrollment.getClient().getId()+"\"}");
		parentDaoFactory.getClientMetaDataDao().createClientMetaData(metaDataEntity);
	}
	
	public void deleteClientMedataInfo(com.servinglynk.hmis.warehouse.model.v2020.Enrollment enrollment) {
		ClientMetaDataEntity metaDataEntity = parentDaoFactory.getClientMetaDataDao().findByIdentifier(enrollment.getId());
		metaDataEntity.setDateUpdated(LocalDateTime.now());
		metaDataEntity.setDeleted(true);
		parentDaoFactory.getClientMetaDataDao().updateClientMetaData(metaDataEntity);
	}
}

