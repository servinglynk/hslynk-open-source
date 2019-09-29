package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.ExitPlansActions;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsAssistancemainstreambenefitsEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsExitcounselingEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsFurtherfollowupservicesEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsOtheraftercareplanoractionEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsPermanenthousingplacementEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsResourcepackageEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsScheduledfollowupcontactsEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsTemporaryshelterplacementEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsWrittenaftercareplanEnum;
public class ExitPlansActionsConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions modelToEntity (ExitPlansActions model ,com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions();
       if(model.getAssistancemainstreambenefits()!=null)
       entity.setAssistancemainstreambenefits(ExitplansactionsAssistancemainstreambenefitsEnum.lookupEnum(model.getAssistancemainstreambenefits().toString()));
       if(model.getExitcounseling()!=null)
       entity.setExitcounseling(ExitplansactionsExitcounselingEnum.lookupEnum(model.getExitcounseling().toString()));
       if(model.getFurtherfollowupservices()!=null)
       entity.setFurtherfollowupservices(ExitplansactionsFurtherfollowupservicesEnum.lookupEnum(model.getFurtherfollowupservices().toString()));
       if(model.getOtheraftercareplanoraction()!=null)
       entity.setOtheraftercareplanoraction(ExitplansactionsOtheraftercareplanoractionEnum.lookupEnum(model.getOtheraftercareplanoraction().toString()));
       if(model.getPermanenthousingplacement()!=null)
       entity.setPermanenthousingplacement(ExitplansactionsPermanenthousingplacementEnum.lookupEnum(model.getPermanenthousingplacement().toString()));
       if(model.getResourcepackage()!=null)
       entity.setResourcepackage(ExitplansactionsResourcepackageEnum.lookupEnum(model.getResourcepackage().toString()));
       if(model.getScheduledfollowupcontacts()!=null)
       entity.setScheduledfollowupcontacts(ExitplansactionsScheduledfollowupcontactsEnum.lookupEnum(model.getScheduledfollowupcontacts().toString()));
       if(model.getTemporaryshelterplacement()!=null)
       entity.setTemporaryshelterplacement(ExitplansactionsTemporaryshelterplacementEnum.lookupEnum(model.getTemporaryshelterplacement().toString()));
       if(model.getWrittenaftercareplan()!=null)
       entity.setWrittenaftercareplan(ExitplansactionsWrittenaftercareplanEnum.lookupEnum(model.getWrittenaftercareplan().toString()));
       return entity;    
   }


   public static ExitPlansActions entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions entity) {
       ExitPlansActions model = new ExitPlansActions();
       if(entity.getId()!=null)
       model.setExitPlansActionsId(entity.getId());
       if(entity.getAssistancemainstreambenefits()!=null)
       model.setAssistancemainstreambenefits(Integer.parseInt(entity.getAssistancemainstreambenefits().getValue()));
       if(entity.getExitcounseling()!=null)
       model.setExitcounseling(Integer.parseInt(entity.getExitcounseling().getValue()));
       if(entity.getFurtherfollowupservices()!=null)
       model.setFurtherfollowupservices(Integer.parseInt(entity.getFurtherfollowupservices().getValue()));
       if(entity.getOtheraftercareplanoraction()!=null)
       model.setOtheraftercareplanoraction(Integer.parseInt(entity.getOtheraftercareplanoraction().getValue()));
       if(entity.getPermanenthousingplacement()!=null)
       model.setPermanenthousingplacement(Integer.parseInt(entity.getPermanenthousingplacement().getValue()));
       if(entity.getResourcepackage()!=null)
       model.setResourcepackage(Integer.parseInt(entity.getResourcepackage().getValue()));
       if(entity.getScheduledfollowupcontacts()!=null)
       model.setScheduledfollowupcontacts(Integer.parseInt(entity.getScheduledfollowupcontacts().getValue()));
       if(entity.getTemporaryshelterplacement()!=null)
       model.setTemporaryshelterplacement(Integer.parseInt(entity.getTemporaryshelterplacement().getValue()));
       if(entity.getWrittenaftercareplan()!=null)
       model.setWrittenaftercareplan(Integer.parseInt(entity.getWrittenaftercareplan().getValue()));
       copyBeanProperties(entity, model);
       if(entity.getParentId() ==null && entity.getExitid()!=null && entity.getExitid().getEnrollmentid()!=null && entity.getExitid().getEnrollmentid().getClient()!=null) {
    	   model.addLink(new ActionLink("history","/clients/"+entity.getExitid().getEnrollmentid().getClient().getId()+"/enrollments/"+entity.getExitid().getEnrollmentid().getId()+"/exits/"+entity.getExitid().getId()+"/exitplansactions/"+entity.getId()+"/history"));    	   
       }

       return model;
   }


}
