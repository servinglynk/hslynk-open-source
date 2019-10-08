package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Assessment;
import com.servinglynk.hmis.warehouse.core.model.Assessments;
import com.servinglynk.hmis.warehouse.service.AssessmentService;
import com.servinglynk.hmis.warehouse.service.converter.AssessmentConverter;
import com.servinglynk.hmis.warehouse.service.exception.AssessmentNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;


public class AssessmentServiceImpl extends ServiceBase implements AssessmentService  {

   @Transactional
   public Assessment createAssessment(Assessment assessment,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2020.Assessment pAssessment = AssessmentConverter.modelToEntity(assessment, null);
       com.servinglynk.hmis.warehouse.model.v2020.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       pAssessment.setEnrollmentid(pEnrollment);
       pAssessment.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pAssessment, caller);
       daoFactory.getAssessmentDao().createAssessment(pAssessment);
       pAssessment.setId(pAssessment.getId());
       Assessment entityToModel = AssessmentConverter.entityToModel(pAssessment);
       return entityToModel;
   }


   @Transactional
   public Assessment updateAssessment(Assessment assessment,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2020.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       com.servinglynk.hmis.warehouse.model.v2020.Assessment pAssessment = daoFactory.getAssessmentDao().getAssessmentById(assessment.getAssessmentId());
       if(pAssessment==null) throw new AssessmentNotFoundException();

       AssessmentConverter.modelToEntity(assessment, pAssessment);
       pAssessment.setEnrollmentid(pEnrollment);
       pAssessment.setDateUpdated(LocalDateTime.now());
       pAssessment.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getAssessmentDao().updateAssessment(pAssessment);
       assessment.setAssessmentId(pAssessment.getId());
       return assessment;
   }


   @Transactional
   public Assessment deleteAssessment(UUID AssessmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2020.Assessment pAssessment = daoFactory.getAssessmentDao().getAssessmentById(AssessmentId);
       if(pAssessment==null) throw new AssessmentNotFoundException();

       daoFactory.getAssessmentDao().deleteAssessment(pAssessment);
       return new Assessment();
   }


   @Transactional
   public Assessment getAssessmentById(UUID AssessmentId){
       com.servinglynk.hmis.warehouse.model.v2020.Assessment pAssessment = daoFactory.getAssessmentDao().getAssessmentById(AssessmentId);
       if(pAssessment==null) throw new AssessmentNotFoundException();
       return AssessmentConverter.entityToModel( pAssessment );
   }


   @Transactional
   public Assessments getAllEnrollmentAssessments(UUID enrollmentId,Integer startIndex, Integer maxItems){
       Assessments assessments = new Assessments();
        List<com.servinglynk.hmis.warehouse.model.v2020.Assessment> entities = daoFactory.getAssessmentDao().getAllEnrollmentAssessments(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2020.Assessment entity : entities){
           assessments.addAssessment(AssessmentConverter.entityToModel(entity));
        }
        long count = daoFactory.getAssessmentDao().getEnrollmentAssessmentsCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(assessments.getAssessments().size());
        pagination.setTotal((int)count);
        assessments.setPagination(pagination);
        return assessments;
   }


}
