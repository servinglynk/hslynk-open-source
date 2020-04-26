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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.AssessmentResults;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.v2020.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2020.Error2020;
import com.servinglynk.hmis.warehouse.model.v2020.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class AssessmentResultsDaoImpl extends ParentDaoImpl implements AssessmentResultsDao {
	private static final Logger logger = LoggerFactory
			.getLogger(AssessmentResultsDaoImpl.class);
		@Override
		public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception 
		{
			Export export = domain.getExport();
			List<AssessmentResults> assessmentQuestion = export.getAssessmentResults();
			Data data =new Data();
			Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults.class, getProjectGroupCode(domain));
			Map<String,HmisBaseModel> assessmentModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Assessment.class, getProjectGroupCode(domain));
			Map<String,HmisBaseModel> clientModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Client.class, getProjectGroupCode(domain));
			
			com.servinglynk.hmis.warehouse.model.v2020.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2020.Export) getModel(com.servinglynk.hmis.warehouse.model.v2020.Export.class,domain.getExport().getExportID(),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
			if(CollectionUtils.isNotEmpty(assessmentQuestion))
			{
				for(AssessmentResults assessmentResults :assessmentQuestion )
				{
					com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults assessmentResultsModel = null;
					try {
						assessmentResultsModel = getModelObject(domain, assessmentResults,data,modelMap);
						if(assessmentResultsModel.isIgnored()) {
							continue;
						}
						Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, assessmentResults.getEnrollmentID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
						if(assessmentResultsModel.getEnrollmentid() == null) {
							assessmentResultsModel.setEnrollmentid(enrollmentModel);
						}
						assessmentResultsModel.setExport(exportEntity);
						com.servinglynk.hmis.warehouse.model.v2020.Assessment assessment = (com.servinglynk.hmis.warehouse.model.v2020.Assessment) getModel(com.servinglynk.hmis.warehouse.model.v2020.Assessment.class, assessmentResults.getAssessmentID(),getProjectGroupCode(domain),true,assessmentModelMap, domain.getUpload().getId());
						assessmentResultsModel.setAssessment(assessment);
						
						com.servinglynk.hmis.warehouse.model.v2020.Client client = (com.servinglynk.hmis.warehouse.model.v2020.Client) getModel(com.servinglynk.hmis.warehouse.model.v2020.Client.class, assessmentResults.getPersonalID(),getProjectGroupCode(domain),true,clientModelMap, domain.getUpload().getId());
						if(client != null) {
							assessmentResultsModel.setClientId(client.getId());
							assessmentResultsModel.setDedupClientId(client.getDedupClientId());
						}else {
							 if(enrollmentModel != null){
								 assessmentResultsModel.setClientId(enrollmentModel.getClient().getId());
							 }
						}
						
						assessmentResultsModel.setAssessmentResult(assessmentResults.getAssessmentResult());
						assessmentResultsModel.setAssessmentResultType(assessmentResults.getAssessmentResultType());
						assessmentResultsModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(assessmentResults.getDateCreated()));
						assessmentResultsModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(assessmentResults.getDateUpdated()));
						performSaveOrUpdate(assessmentResultsModel,domain);
					} catch(Exception e) {
						String errorMessage = "Error occured with "+assessmentResultsModel.getSourceSystemId() + " Execption :::"+e.getLocalizedMessage();
						if(assessmentResultsModel != null){
							Error2020 error = new Error2020();
							error.model_id = assessmentResultsModel.getId();
							error.bulk_upload_ui = domain.getUpload().getId();
							error.project_group_code = domain.getUpload().getProjectGroupCode();
							error.source_system_id = assessmentResultsModel.getSourceSystemId();
							error.type = ErrorType.ERROR;
							error.error_description = errorMessage;
							error.date_created = assessmentResultsModel.getDateCreated();
							performSave(error);
						}
						logger.error(errorMessage);
					}
				}
			}
			hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults.class.getSimpleName(), domain, exportEntity);
		}

		
		public  com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults getModelObject(ExportDomain domain, AssessmentResults assessmentResults,Data data, Map<String,HmisBaseModel> modelMap) {
			com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults modelFromDB = null;
			// We always insert for a Full refresh and update if the record exists for Delta refresh
				modelFromDB = (com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults) getModel(com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults.class, assessmentResults.getAssessmentResultID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
			if(modelFromDB == null) {
				modelFromDB = new com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults();
				modelFromDB.setId(UUID.randomUUID());
				modelFromDB.setRecordToBeInserted(true); 
data.i++;
			}else {
				com.servinglynk.hmis.warehouse.model.v2020.Assessment model = new com.servinglynk.hmis.warehouse.model.v2020.Assessment();
				// org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
				model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(assessmentResults.getDateUpdated()));
				performMatch(domain, modelFromDB, model, data);
			}
			hydrateCommonFields(modelFromDB, domain,assessmentResults.getAssessmentResultID(),data);
			return modelFromDB;
			
		}

		@Override
		public void hydrateHBASE(SyncDomain syncDomain) {
			// TODO Auto-generated method stub
			
		}

		   public com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults createAssessmentResults(com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults AssessmentResults){
		       AssessmentResults.setId(UUID.randomUUID()); 
		       insert(AssessmentResults);
		       return AssessmentResults;
		   }
		   public com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults updateAssessmentResults(com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults AssessmentResults){
		       update(AssessmentResults);
		       return AssessmentResults;
		   }
		   public void deleteAssessmentResults(com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults AssessmentResults){
		       delete(AssessmentResults);
		   }
		   public com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults getAssessmentResultsById(UUID AssessmentResultsId){ 
			      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults.class);
			      criteria.add(Restrictions.eq("id", AssessmentResultsId));
			      List<com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults> entities = (List<com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults>) findByCriteria(criteria);
			      if(!entities.isEmpty()) return entities.get(0);
			      return null;
		   }
		   
		   @Override
			public List<com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults> getAllEnrollmentAssessmentResults(
					UUID enrollmentId, int startIndex, int maxItems) {
				   DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults.class);
			       criteria.createAlias("enrollmentid", "enrollmentid");
			       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
			       return (List<com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults>) findByCriteria(criteria,startIndex,maxItems);
			}
			
			@Override
			public long getEnrollmentAssessmentResultsCount(UUID enrollmentId) {
				   DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults.class);
			       criteria.createAlias("enrollmentid", "enrollmentid");
			       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
			       return countRows(criteria);
			}
}

