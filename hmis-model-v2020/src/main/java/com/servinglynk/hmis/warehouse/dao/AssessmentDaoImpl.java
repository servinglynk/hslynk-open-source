package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Assessment;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.AssessmentLevelEnum;
import com.servinglynk.hmis.warehouse.enums.AssessmentTypeEnum;
import com.servinglynk.hmis.warehouse.enums.PrioritizationStatusEnum;
import com.servinglynk.hmis.warehouse.model.v2020.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2020.Error2020;
import com.servinglynk.hmis.warehouse.model.v2020.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class AssessmentDaoImpl extends ParentDaoImpl implements AssessmentDao {
	private static final Logger logger = LoggerFactory
			.getLogger(AssessmentDaoImpl.class);
		@Override
		public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception 
		{
			Export export = domain.getExport();
			List<Assessment> Assessments = export.getAssessment();
			Data data =new Data();
			Map<String,HmisBaseModel> clientModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Client.class, getProjectGroupCode(domain));
			Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Assessment.class, getProjectGroupCode(domain));
			com.servinglynk.hmis.warehouse.model.v2020.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2020.Export) getModel(com.servinglynk.hmis.warehouse.model.v2020.Export.class,domain.getExport().getExportID(),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
			if(CollectionUtils.isNotEmpty(Assessments))
			{
				for(Assessment assessment :Assessments )
				{
					com.servinglynk.hmis.warehouse.model.v2020.Assessment assessmentModel = null;
					try {
						assessmentModel = getModelObject(domain, assessment,data,modelMap);
						if(assessmentModel.isIgnored()) {
							continue;
						}
						assessmentModel.setAssessmentDate(BasicDataGenerator.getLocalDateTime(assessment.getAssessmentDate()));
						assessmentModel.setAssessmentLevel(AssessmentLevelEnum.lookupEnum(assessment.getAssessmentLevel()));
						assessmentModel.setAssessmentLocation(assessment.getAssessmentLocation());
						assessmentModel.setAssessmentType(AssessmentTypeEnum.lookupEnum(assessment.getAssessmentType()));
						
						Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, assessment.getEnrollmentID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
						assessmentModel.setEnrollmentid(enrollmentModel);
						com.servinglynk.hmis.warehouse.model.v2020.Client client = (com.servinglynk.hmis.warehouse.model.v2020.Client) getModel(com.servinglynk.hmis.warehouse.model.v2020.Client.class, assessment.getPersonalID(),getProjectGroupCode(domain),true,clientModelMap, domain.getUpload().getId());
						if(client != null) {
							assessmentModel.setClientId(client.getId());
							assessmentModel.setDedupClientId(client.getDedupClientId());
						}else {
							 if(enrollmentModel != null){
								 assessmentModel.setClientId(enrollmentModel.getClient().getId());
							 }
						}
						assessmentModel.setPrioritizationStatus(PrioritizationStatusEnum.lookupEnum(assessment.getPrioritizationStatus()));
						assessmentModel.setExport(exportEntity);
						assessmentModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(assessment.getDateCreated()));
						assessmentModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(assessment.getDateUpdated()));
						performSaveOrUpdate(assessmentModel,domain);
					} catch(Exception e) {
						String errorMessage = "Error occured with "+assessment.getAssessmentID() + " Execption :::"+e.getLocalizedMessage();
						if(assessmentModel != null){
							Error2020 error = new Error2020();
							error.model_id = assessmentModel.getId();
							error.bulk_upload_ui = domain.getUpload().getId();
							error.project_group_code = domain.getUpload().getProjectGroupCode();
							error.source_system_id = assessmentModel.getSourceSystemId();
							error.type = ErrorType.ERROR;
							error.error_description = errorMessage;
							error.date_created = assessmentModel.getDateCreated();
							performSave(error);
						}
						logger.error(errorMessage);
					}
				}
			}
			hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2020.Assessment.class.getSimpleName(), domain, exportEntity);
		}
		
		public  com.servinglynk.hmis.warehouse.model.v2020.Assessment getModelObject(ExportDomain domain, Assessment assessment,Data data, Map<String,HmisBaseModel> modelMap) {
			
			com.servinglynk.hmis.warehouse.model.v2020.Assessment modelFromDB = null;
			// We always insert for a Full refresh and update if the record exists for Delta refresh
				modelFromDB = (com.servinglynk.hmis.warehouse.model.v2020.Assessment) getModel(com.servinglynk.hmis.warehouse.model.v2020.Assessment.class, assessment.getAssessmentID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
			if(modelFromDB == null) {
				modelFromDB = new com.servinglynk.hmis.warehouse.model.v2020.Assessment();
				modelFromDB.setId(UUID.randomUUID());
				modelFromDB.setRecordToBeInserted(true); 
data.i++;
			}else {
				com.servinglynk.hmis.warehouse.model.v2020.Assessment model = new com.servinglynk.hmis.warehouse.model.v2020.Assessment();
				// org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
				model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(assessment.getDateUpdated()));
				performMatch(domain, modelFromDB, model, data);
			}
			hydrateCommonFields(modelFromDB, domain,assessment.getAssessmentID(),data);
			return modelFromDB;
			
		}

		@Override
		public void hydrateHBASE(SyncDomain syncDomain) {
			// TODO Auto-generated method stub
			
		}

		   public com.servinglynk.hmis.warehouse.model.v2020.Assessment createAssessment(com.servinglynk.hmis.warehouse.model.v2020.Assessment assessment){
		       assessment.setId(UUID.randomUUID()); 
		       insert(assessment);
		       return assessment;
		   }
		   public com.servinglynk.hmis.warehouse.model.v2020.Assessment updateAssessment(com.servinglynk.hmis.warehouse.model.v2020.Assessment Assessment){
		       update(Assessment);
		       return Assessment;
		   }
		   public void deleteAssessment(com.servinglynk.hmis.warehouse.model.v2020.Assessment assessment){
		       delete(assessment);
		   }
		   public com.servinglynk.hmis.warehouse.model.v2020.Assessment getAssessmentById(UUID assessmentId){ 
			      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Assessment.class);
			      criteria.add(Restrictions.eq("id", assessmentId));
			      List<com.servinglynk.hmis.warehouse.model.v2020.Assessment> entities = (List<com.servinglynk.hmis.warehouse.model.v2020.Assessment>) findByCriteria(criteria);
			      if(!entities.isEmpty()) return entities.get(0);
			      return null;
		   }

		@Override
		public List<com.servinglynk.hmis.warehouse.model.v2020.Assessment> getAllEnrollmentAssessments(
				UUID enrollmentId, int startIndex, int maxItems) {
			   DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Assessment.class);
		       criteria.createAlias("enrollmentid", "enrollmentid");
		       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
		       return (List<com.servinglynk.hmis.warehouse.model.v2020.Assessment>) findByCriteria(criteria,startIndex,maxItems);
		}
		
		@Override
		public long getEnrollmentAssessmentsCount(UUID enrollmentId) {
			   DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Assessment.class);
		       criteria.createAlias("enrollmentid", "enrollmentid");
		       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
		       return countRows(criteria);
		}
}


