package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.AssessmentQuestion;
public class AssessmentQuestionConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions modelToEntity (AssessmentQuestion model ,com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions();
       entity.setAssessmentAnswer(model.getAssessmentAnswer());
       entity.setAssessmentQuestion(model.getAssessmentQuestion());
       entity.setAssessmentQuestionGroup(model.getAssessmentQuestionGroup());
       if(model.getAssessmentQuestionOrder()  != null)
       entity.setAssessmentQuestionOrder(model.getAssessmentQuestionOrder());
       entity.setId(model.getAssessmentQuestionId());
       return entity;
   }

   public static AssessmentQuestion entityToModel (com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions entity) {
       AssessmentQuestion model = new AssessmentQuestion();
       model.setAssessmentAnswer(entity.getAssessmentAnswer());
       model.setAssessmentQuestion(entity.getAssessmentQuestion());
       model.setAssessmentQuestionGroup(entity.getAssessmentQuestionGroup());
       if(entity.getAssessmentQuestionOrder()  != null)
    	   model.setAssessmentQuestionOrder(entity.getAssessmentQuestionOrder());
       model.setEnrollmentid(entity.getEnrollmentid().getId());
       model.setAssessmentId(entity.getAssessment().getId());
       model.setAssessmentQuestionId(entity.getId());
       return model;
   }
}
