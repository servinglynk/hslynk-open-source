package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.AssessmentResult;
public class AssessmentResultConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults modelToEntity (AssessmentResult model ,com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults();
       entity.setAssessmentResult(model.getAssessmentResult());
       entity.setAssessmentResultType(model.getAssessmentResultType());
       entity.setId(model.getAssessmentResultId());
       return entity;
   }


   public static AssessmentResult entityToModel (com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults entity) {
       AssessmentResult model = new AssessmentResult();
       model.setAssessmentResult(entity.getAssessmentResult());
       model.setAssessmentResultType(entity.getAssessmentResultType());
       model.setAssessmentResultId(entity.getId());
       model.setAssessmentId(entity.getAssessment().getId());
       model.setEnrollmentid(entity.getEnrollmentid().getId());
       return model;
   }


}
