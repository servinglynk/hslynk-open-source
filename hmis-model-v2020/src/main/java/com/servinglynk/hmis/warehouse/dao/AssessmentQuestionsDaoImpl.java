package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.AssessmentQuestions;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.v2020.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2020.Error2020;
import com.servinglynk.hmis.warehouse.model.v2020.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class AssessmentQuestionsDaoImpl extends ParentDaoImpl implements AssessmentQuestionsDao {
	private static final Logger logger = LoggerFactory
			.getLogger(AssessmentQuestionsDaoImpl.class);
		@Override
		public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception 
		{
			Export export = domain.getExport();
			List<AssessmentQuestions> assessmentQuestion = export.getAssessmentQuestions();
			Data data =new Data();
			Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions.class, getProjectGroupCode(domain));
			Map<String,HmisBaseModel> assessmentModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Assessment.class, getProjectGroupCode(domain));
			
			com.servinglynk.hmis.warehouse.model.v2020.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2020.Export) getModel(com.servinglynk.hmis.warehouse.model.v2020.Export.class,domain.getExport().getExportID(),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
			if(CollectionUtils.isNotEmpty(assessmentQuestion))
			{
				for(AssessmentQuestions assessmentQuestions :assessmentQuestion )
				{
					com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions assessmentQuestionsModel = null;
					try {
						assessmentQuestionsModel = getModelObject(domain, assessmentQuestions,data,modelMap);
						Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, assessmentQuestions.getEnrollmentID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
						assessmentQuestionsModel.setEnrollmentid(enrollmentModel);
						
						com.servinglynk.hmis.warehouse.model.v2020.Assessment assessment = (com.servinglynk.hmis.warehouse.model.v2020.Assessment) getModel(com.servinglynk.hmis.warehouse.model.v2020.Assessment.class, assessmentQuestions.getAssessmentID(),getProjectGroupCode(domain),true,assessmentModelMap, domain.getUpload().getId());
						assessmentQuestionsModel.setAssessment(assessment);
						assessmentQuestionsModel.setExport(exportEntity);
					
						assessmentQuestionsModel.setAssessmentQuestion(assessmentQuestions.getAssessmentQuestion());
						assessmentQuestionsModel.setAssessmentAnswer(assessmentQuestions.getAssessmentAnswer());
						assessmentQuestionsModel.setAssessmentQuestionGroup(assessmentQuestions.getAssessmentQuestionGroup());
						String assessmentQuestionOrder = assessmentQuestions.getAssessmentQuestionOrder();
						if(StringUtils.isNotEmpty(assessmentQuestionOrder)) {
							try {
								assessmentQuestionsModel.setAssessmentQuestionOrder(Integer.parseInt(assessmentQuestionOrder));
							}catch(NumberFormatException e) {
								//eat the exception.
							}
						}
						assessmentQuestionsModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(assessmentQuestions.getDateCreated()));
						assessmentQuestionsModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(assessmentQuestions.getDateUpdated()));
						performSaveOrUpdate(assessmentQuestionsModel,domain);
					} catch(Exception e) {
						String errorMessage = "Error occured with "+assessmentQuestions.getAssessmentQuestionID()+ " Execption :::"+e.getLocalizedMessage();
						if(assessmentQuestionsModel != null){
							Error2020 error = new Error2020();
							error.model_id = assessmentQuestionsModel.getId();
							error.bulk_upload_ui = domain.getUpload().getId();
							error.project_group_code = domain.getUpload().getProjectGroupCode();
							error.source_system_id = assessmentQuestionsModel.getSourceSystemId();
							error.type = ErrorType.ERROR;
							error.error_description = errorMessage;
							error.date_created = assessmentQuestionsModel.getDateCreated();
							performSave(error);
						}
						logger.error(errorMessage);
					}
				}
			}
			hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions.class.getSimpleName(), domain, exportEntity);
		}

		
		public  com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions getModelObject(ExportDomain domain, AssessmentQuestions assessmentQuestions,Data data, Map<String,HmisBaseModel> modelMap) {
			com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions modelFromDB = null;
			// We always insert for a Full refresh and update if the record exists for Delta refresh
			if(!isFullRefresh(domain))
				modelFromDB = (com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions) getModel(com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions.class, assessmentQuestions.getAssessmentQuestionID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
			if(domain.isReUpload()) {
				if(modelFromDB != null) {
					return modelFromDB;
				}
				modelFromDB = new com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions();
				modelFromDB.setId(UUID.randomUUID());
				modelFromDB.setRecordToBeInserted(true);
				return modelFromDB;
			}
			com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions model = null;
			if(modelFromDB == null) {
				model = new com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions();
				model.setId(UUID.randomUUID());
				model.setRecordToBeInserted(true);
			}else {
				org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
				model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(assessmentQuestions.getDateUpdated()));
				performMatch(domain, modelFromDB, model, data);
			}
		
			hydrateCommonFields(model, domain,assessmentQuestions.getAssessmentQuestionID(),data);
			return model;
		}

		@Override
		public void hydrateHBASE(SyncDomain syncDomain) {
			// TODO Auto-generated method stub
			
		}

		   public com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions createAssessmentQuestions(com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions assessmentQuestions){
		       assessmentQuestions.setId(UUID.randomUUID()); 
		       insert(assessmentQuestions);
		       return assessmentQuestions;
		   }
		   public com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions updateAssessmentQuestions(com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions assessmentQuestions){
		       update(assessmentQuestions);
		       return assessmentQuestions;
		   }
		   public void deleteAssessmentQuestions(com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions assessmentQuestions){
		       delete(assessmentQuestions);
		   }
		   public com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions getAssessmentQuestionsById(UUID assessmentQuestionsId){ 
			      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions.class);
			      criteria.add(Restrictions.eq("id", assessmentQuestionsId));
			      List<com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions> entities = (List<com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions>) findByCriteria(criteria);
			      if(!entities.isEmpty()) return entities.get(0);
			      return null;
		   }
		   
			@Override
			public List<com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions> getAllEnrollmentAssessmentQuestions(
					UUID enrollmentId, int startIndex, int maxItems) {
				   DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions.class);
			       criteria.createAlias("enrollmentid", "enrollmentid");
			       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
			       return (List<com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions>) findByCriteria(criteria,startIndex,maxItems);
			}
			
			@Override
			public long getEnrollmentAssessmentQuestionsCount(UUID enrollmentId) {
				   DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions.class);
			       criteria.createAlias("enrollmentid", "enrollmentid");
			       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
			       return countRows(criteria);
			}
}

