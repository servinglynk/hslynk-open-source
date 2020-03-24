package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.Assessment;
import com.servinglynk.hmis.warehouse.enums.AssessmentLevelEnum;
import com.servinglynk.hmis.warehouse.enums.AssessmentTypeEnum;
import com.servinglynk.hmis.warehouse.enums.PrioritizationStatusEnum;
public class AssessmentConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2020.Assessment modelToEntity (Assessment model ,com.servinglynk.hmis.warehouse.model.v2020.Assessment entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2020.Assessment();
       entity.setAssessmentDate(model.getAssessmentDate());
       if(model.getAssessmentLevel() != null)
    	   entity.setAssessmentLevel(AssessmentLevelEnum.lookupEnum(model.getAssessmentLevel()));
       if(model.getAssessmentLocation() != null) 
    	   entity.setAssessmentLocation(model.getAssessmentLocation());
       if(model.getAssessmentType() != null)
    	   entity.setAssessmentType(AssessmentTypeEnum.lookupEnum(model.getAssessmentType()));
       if(model.getPrioritizationStatus() != null)
    	   entity.setPrioritizationStatus(PrioritizationStatusEnum.lookupEnum(model.getPrioritizationStatus()));
       entity.setId(model.getAssessmentId());
       if(model.getDedupClientId() != null)
    	   entity.setDedupClientId(model.getDedupClientId());
       return entity;
   }


   public static Assessment entityToModel (com.servinglynk.hmis.warehouse.model.v2020.Assessment entity) {
       Assessment model = new Assessment();
       entity.setAssessmentDate(model.getAssessmentDate());
       if(entity.getAssessmentLevel() != null)
    	   model.setAssessmentLevel(entity.getAssessmentLevel().getValue());
       if(entity.getAssessmentLocation() != null) 
    	   model.setAssessmentLocation(model.getAssessmentLocation());
       if(entity.getAssessmentType() != null)
    	   model.setAssessmentType(entity.getAssessmentType().getValue());
       if(entity.getPrioritizationStatus() != null)
    	   model.setPrioritizationStatus(entity.getPrioritizationStatus().getValue());
       model.setAssessmentId(entity.getId());
       if(entity.getDedupClientId() != null)
    	   model.setDedupClientId(model.getDedupClientId());
     
       model.setEnrollmentid(entity.getEnrollmentid().getId());
       return model;
   }


}
