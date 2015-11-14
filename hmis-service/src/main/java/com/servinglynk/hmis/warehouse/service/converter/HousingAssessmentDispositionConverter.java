package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.HousingAssessmentDisposition;
import com.servinglynk.hmis.warehouse.enums.HousingassessmentdispositionAssessmentdispositionEnum;
public class HousingAssessmentDispositionConverter {

   public static com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition modelToEntity (HousingAssessmentDisposition model ,com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition();
       entity.setId(model.getHousingAssessmentDispositionId());
       entity.setAssessmentdisposition(HousingassessmentdispositionAssessmentdispositionEnum.valueOf(model.getAssessmentdisposition()));
       entity.setOtherdisposition(model.getOtherdisposition());
       return entity;    
   }


   public static HousingAssessmentDisposition entityToModel (com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition entity) {
       HousingAssessmentDisposition model = new HousingAssessmentDisposition();
       model.setHousingAssessmentDispositionId(entity.getId());
       model.setAssessmentdisposition(entity.getAssessmentdisposition().name());
       model.setOtherdisposition(entity.getOtherdisposition());
       return model;
   }


}
