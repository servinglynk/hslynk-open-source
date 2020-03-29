package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.AssessmentResult;
import com.servinglynk.hmis.warehouse.core.model.AssessmentResults;
import com.servinglynk.hmis.warehouse.model.v2020.Assessment;
import com.servinglynk.hmis.warehouse.service.AssessmentResultService;
import com.servinglynk.hmis.warehouse.service.converter.AssessmentResultConverter;
import com.servinglynk.hmis.warehouse.service.exception.AssessmentResultsNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ClientNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;


public class AssessmentResultsServiceImpl extends ServiceBase implements AssessmentResultService  {

   @Transactional
   public AssessmentResult createAssessmentResult(AssessmentResult assessmentResult,String caller){
       com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults pAssessmentResult = AssessmentResultConverter.modelToEntity(assessmentResult, null);
       com.servinglynk.hmis.warehouse.model.v2020.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(assessmentResult.getEnrollmentid());
       if(pEnrollment == null) throw new EnrollmentNotFound();
       pAssessmentResult.setEnrollmentid(pEnrollment);
       
       com.servinglynk.hmis.warehouse.model.v2020.Client pClient = daoFactory.getClientDao().getClientById(assessmentResult.getClientid());
       if(pClient == null) {  throw new ClientNotFoundException(); }
       else {
    	    pAssessmentResult.setClientId(pClient.getId());
    	    pAssessmentResult.setDedupClientId(pClient.getDedupClientId());
       }
       UUID assessmentId = assessmentResult.getAssessmentId();
       if(assessmentId != null) {
    	   Assessment assessmentById = daoFactory.getAssessmentDao().getAssessmentById(assessmentResult.getAssessmentId());
    	   pAssessmentResult.setAssessment(assessmentById);
       }
       pAssessmentResult.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pAssessmentResult, caller);
       daoFactory.getAssessmentResultsDao().createAssessmentResults(pAssessmentResult);
       pAssessmentResult.setId(pAssessmentResult.getId());
       AssessmentResult entityToModel = AssessmentResultConverter.entityToModel(pAssessmentResult);
       return entityToModel;
   }


   @Transactional
   public AssessmentResult updateAssessmentResult(AssessmentResult assessmentResult,String caller){
       com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults pAssessmentResult = daoFactory.getAssessmentResultsDao().getAssessmentResultsById(assessmentResult.getAssessmentResultId());
       if(pAssessmentResult==null) throw new AssessmentResultsNotFoundException();
       
       com.servinglynk.hmis.warehouse.model.v2020.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(assessmentResult.getEnrollmentid());
       if(pEnrollment == null) throw new EnrollmentNotFound();
       pAssessmentResult.setEnrollmentid(pEnrollment);
       
       com.servinglynk.hmis.warehouse.model.v2020.Client pClient = daoFactory.getClientDao().getClientById(assessmentResult.getClientid());
       if(pClient == null) {  throw new ClientNotFoundException(); }
       else {
    	    pAssessmentResult.setClientId(pClient.getId());
    	    pAssessmentResult.setDedupClientId(pClient.getDedupClientId());
       }
       UUID assessmentId = assessmentResult.getAssessmentId();
       if(assessmentId != null) {
    	   Assessment assessmentById = daoFactory.getAssessmentDao().getAssessmentById(assessmentResult.getAssessmentId());
    	   pAssessmentResult.setAssessment(assessmentById);
       }
       
       AssessmentResultConverter.modelToEntity(assessmentResult, pAssessmentResult);
       pAssessmentResult.setEnrollmentid(pEnrollment);
       pAssessmentResult.setDateUpdated(LocalDateTime.now());
       pAssessmentResult.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getAssessmentResultsDao().updateAssessmentResults(pAssessmentResult);
       assessmentResult.setAssessmentResultId(pAssessmentResult.getId());
       return assessmentResult;
   }


   @Transactional
   public AssessmentResult deleteAssessmentResult(UUID assessmentResultId,String caller){
       com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults pAssessmentResult = daoFactory.getAssessmentResultsDao().getAssessmentResultsById(assessmentResultId);
       if(pAssessmentResult==null) throw new AssessmentResultsNotFoundException();

       daoFactory.getAssessmentResultsDao().deleteAssessmentResults(pAssessmentResult);
       return new AssessmentResult();
   }


   @Transactional
   public AssessmentResult getAssessmentResultById(UUID assessmentResultId){
       com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults pAssessmentResult = daoFactory.getAssessmentResultsDao().getAssessmentResultsById(assessmentResultId);
       if(pAssessmentResult==null) throw new AssessmentResultsNotFoundException();
       return AssessmentResultConverter.entityToModel( pAssessmentResult );
   }


   @Transactional
   public AssessmentResults getAllEnrollmentAssessmentResults(UUID enrollmentId,Integer startIndex, Integer maxItems){
       AssessmentResults assessmentResults = new AssessmentResults();
        List<com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults> entities = daoFactory.getAssessmentResultsDao().getAllEnrollmentAssessmentResults(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults entity : entities){
           assessmentResults.addAssessmentResult(AssessmentResultConverter.entityToModel(entity));
        }
        long count = daoFactory.getAssessmentResultsDao().getEnrollmentAssessmentResultsCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(assessmentResults.getAssessmentResults().size());
        pagination.setTotal((int)count);
        assessmentResults.setPagination(pagination);
        return assessmentResults;
   }


}
