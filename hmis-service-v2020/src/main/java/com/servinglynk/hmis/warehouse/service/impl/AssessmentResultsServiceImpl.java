package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.AssessmentResult;
import com.servinglynk.hmis.warehouse.core.model.AssessmentResults;
import com.servinglynk.hmis.warehouse.service.AssessmentResultService;
import com.servinglynk.hmis.warehouse.service.converter.AssessmentResultConverter;
import com.servinglynk.hmis.warehouse.service.exception.AssessmentResultsNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;


public class AssessmentResultsServiceImpl extends ServiceBase implements AssessmentResultService  {

   @Transactional
   public AssessmentResult createAssessmentResult(AssessmentResult assessmentResult,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults pAssessmentResult = AssessmentResultConverter.modelToEntity(assessmentResult, null);
       com.servinglynk.hmis.warehouse.model.v2020.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       pAssessmentResult.setEnrollmentid(pEnrollment);
       pAssessmentResult.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pAssessmentResult, caller);
       daoFactory.getAssessmentResultsDao().createAssessmentResults(pAssessmentResult);
       pAssessmentResult.setId(pAssessmentResult.getId());
       AssessmentResult entityToModel = AssessmentResultConverter.entityToModel(pAssessmentResult);
       return entityToModel;
   }


   @Transactional
   public AssessmentResult updateAssessmentResult(AssessmentResult AssessmentResult,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2020.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults pAssessmentResult = daoFactory.getAssessmentResultsDao().getAssessmentResultsById(AssessmentResult.getAssessmentResultId());
       if(pAssessmentResult==null) throw new AssessmentResultsNotFoundException();

       AssessmentResultConverter.modelToEntity(AssessmentResult, pAssessmentResult);
       pAssessmentResult.setEnrollmentid(pEnrollment);
       pAssessmentResult.setDateUpdated(LocalDateTime.now());
       pAssessmentResult.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getAssessmentResultsDao().updateAssessmentResults(pAssessmentResult);
       AssessmentResult.setAssessmentResultId(pAssessmentResult.getId());
       return AssessmentResult;
   }


   @Transactional
   public AssessmentResult deleteAssessmentResult(UUID AssessmentResultId,String caller){
       com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults pAssessmentResult = daoFactory.getAssessmentResultsDao().getAssessmentResultsById(AssessmentResultId);
       if(pAssessmentResult==null) throw new AssessmentResultsNotFoundException();

       daoFactory.getAssessmentResultsDao().deleteAssessmentResults(pAssessmentResult);
       return new AssessmentResult();
   }


   @Transactional
   public AssessmentResult getAssessmentResultById(UUID AssessmentResultId){
       com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults pAssessmentResult = daoFactory.getAssessmentResultsDao().getAssessmentResultsById(AssessmentResultId);
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
