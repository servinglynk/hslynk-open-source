package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.HousingAssessmentDisposition;
import com.servinglynk.hmis.warehouse.enums.HousingassessmentdispositionAssessmentdispositionEnum;
public class HousingAssessmentDispositionConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition modelToEntity (HousingAssessmentDisposition model ,com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition();
       if(model.getHousingAssessmentDispositionId()!=null)
       entity.setId(model.getHousingAssessmentDispositionId());
       if(model.getAssessmentdisposition()!=null)
       entity.setAssessmentdisposition(HousingassessmentdispositionAssessmentdispositionEnum.lookupEnum(model.getAssessmentdisposition().toString()));
       if(model.getOtherdisposition()!=null)
       entity.setOtherdisposition(model.getOtherdisposition());
       return entity;    
   }


   public static HousingAssessmentDisposition entityToModel (com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition entity) {
       HousingAssessmentDisposition model = new HousingAssessmentDisposition();
       if(entity.getId()!=null)
       model.setHousingAssessmentDispositionId(entity.getId());
       if(entity.getAssessmentdisposition()!=null)
       model.setAssessmentdisposition(Integer.parseInt(entity.getAssessmentdisposition().getValue()));
       if(entity.getOtherdisposition()!=null)
       model.setOtherdisposition(entity.getOtherdisposition());
       copyBeanProperties(entity, model);
       if(entity.getParentId() ==null && entity.getExitid()!=null && entity.getExitid().getEnrollmentid()!=null && entity.getExitid().getEnrollmentid().getClient()!=null) {
    	   model.addLink(new ActionLink("history","/clients/"+entity.getExitid().getEnrollmentid().getClient().getId()+"/enrollments/"+entity.getExitid().getEnrollmentid().getId()+"/exits/"+entity.getExitid().getId()+"/housingassessmentdispositions/"+entity.getId()+"/history"));
       }
       return model;
   }


}
