package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.AssessmentQuestion;
import com.servinglynk.hmis.warehouse.core.model.AssessmentQuestions;
import com.servinglynk.hmis.warehouse.model.v2020.Assessment;
import com.servinglynk.hmis.warehouse.service.AssessmentQuestionService;
import com.servinglynk.hmis.warehouse.service.converter.AssessmentQuestionConverter;
import com.servinglynk.hmis.warehouse.service.exception.AssessmentQuestionsNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ClientNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;


public class AssessmentQuestionsServiceImpl extends ServiceBase implements AssessmentQuestionService  {

   @Transactional
   public AssessmentQuestion createAssessmentQuestion(AssessmentQuestion assessmentQuestion,String caller){
       com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions pAssessmentQuestion = AssessmentQuestionConverter.modelToEntity(assessmentQuestion, null);

       com.servinglynk.hmis.warehouse.model.v2020.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(assessmentQuestion.getEnrollmentid());
       if(pEnrollment == null) throw new EnrollmentNotFound();
       pAssessmentQuestion.setEnrollmentid(pEnrollment);
       
       com.servinglynk.hmis.warehouse.model.v2020.Client pClient = daoFactory.getClientDao().getClientById(assessmentQuestion.getClientid());
       if(pClient == null) {  throw new ClientNotFoundException(); }
       else {
    	   pAssessmentQuestion.setClientId(pClient.getId());
    	   pAssessmentQuestion.setDedupClientId(pClient.getDedupClientId());
       }
       UUID assessmentId = assessmentQuestion.getAssessmentId();
       if(assessmentId != null) {
    	   Assessment assessmentById = daoFactory.getAssessmentDao().getAssessmentById(assessmentQuestion.getAssessmentId());
    	   pAssessmentQuestion.setAssessment(assessmentById);
       }
       
       pAssessmentQuestion.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pAssessmentQuestion, caller);
       daoFactory.getAssessmentQuestionsDao().createAssessmentQuestions(pAssessmentQuestion);
       pAssessmentQuestion.setId(pAssessmentQuestion.getId());
       AssessmentQuestion entityToModel = AssessmentQuestionConverter.entityToModel(pAssessmentQuestion);
       return entityToModel;
   }


   @Transactional
   public AssessmentQuestion updateAssessmentQuestion(AssessmentQuestion assessmentQuestion,String caller){
       com.servinglynk.hmis.warehouse.model.v2020.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(assessmentQuestion.getEnrollmentid());
       if(pEnrollment == null) throw new EnrollmentNotFound();
       com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions pAssessmentQuestion = daoFactory.getAssessmentQuestionsDao().getAssessmentQuestionsById(assessmentQuestion.getAssessmentQuestionId());
       if(pAssessmentQuestion==null) throw new AssessmentQuestionsNotFoundException();

       AssessmentQuestionConverter.modelToEntity(assessmentQuestion, pAssessmentQuestion);
       pAssessmentQuestion.setEnrollmentid(pEnrollment);
      
       com.servinglynk.hmis.warehouse.model.v2020.Client pClient = daoFactory.getClientDao().getClientById(assessmentQuestion.getClientid());
       if(pClient == null) {  throw new ClientNotFoundException(); }
       else {
    	   pAssessmentQuestion.setClientId(pClient.getId());
    	   pAssessmentQuestion.setDedupClientId(pClient.getDedupClientId());
       }
       UUID assessmentId = assessmentQuestion.getAssessmentId();
       if(assessmentId != null) {
    	   Assessment assessmentById = daoFactory.getAssessmentDao().getAssessmentById(assessmentQuestion.getAssessmentId());
    	   pAssessmentQuestion.setAssessment(assessmentById);
       }
       pAssessmentQuestion.setDateUpdated(LocalDateTime.now());
       pAssessmentQuestion.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getAssessmentQuestionsDao().updateAssessmentQuestions(pAssessmentQuestion);
       assessmentQuestion.setAssessmentQuestionId(pAssessmentQuestion.getId());
       return assessmentQuestion;
   }


   @Transactional
   public AssessmentQuestion deleteAssessmentQuestion(UUID AssessmentQuestionId,String caller){
       com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions pAssessmentQuestion = daoFactory.getAssessmentQuestionsDao().getAssessmentQuestionsById(AssessmentQuestionId);
       if(pAssessmentQuestion==null) throw new AssessmentQuestionsNotFoundException();

       daoFactory.getAssessmentQuestionsDao().deleteAssessmentQuestions(pAssessmentQuestion);
       return new AssessmentQuestion();
   }


   @Transactional
   public AssessmentQuestion getAssessmentQuestionById(UUID AssessmentQuestionId){
       com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions pAssessmentQuestion = daoFactory.getAssessmentQuestionsDao().getAssessmentQuestionsById(AssessmentQuestionId);
       if(pAssessmentQuestion==null) throw new AssessmentQuestionsNotFoundException();
       return AssessmentQuestionConverter.entityToModel( pAssessmentQuestion );
   }


   @Transactional
   public AssessmentQuestions getAllEnrollmentAssessmentQuestions(UUID enrollmentId,Integer startIndex, Integer maxItems){
       AssessmentQuestions assessmentQuestions = new AssessmentQuestions();
        List<com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions> entities = daoFactory.getAssessmentQuestionsDao().getAllEnrollmentAssessmentQuestions(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions entity : entities){
           assessmentQuestions.addAssessment(AssessmentQuestionConverter.entityToModel(entity));
        }
        long count = daoFactory.getAssessmentQuestionsDao().getEnrollmentAssessmentQuestionsCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(assessmentQuestions.getassessmentQuestions().size());
        pagination.setTotal((int)count);
        assessmentQuestions.setPagination(pagination);
        return assessmentQuestions;
   }


}
