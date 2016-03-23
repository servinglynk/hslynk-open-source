package com.servinglynk.hmis.warehouse.service.converter; 

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
public class ExitPlansActionsConverter extends BaseConveter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions modelToEntity (ExitPlansActions model ,com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions();
       entity.setAssistancemainstreambenefits(ExitplansactionsAssistancemainstreambenefitsEnum.lookupEnum(model.getAssistancemainstreambenefits().toString()));
       entity.setExitcounseling(ExitplansactionsExitcounselingEnum.lookupEnum(model.getExitcounseling().toString()));
       entity.setFurtherfollowupservices(ExitplansactionsFurtherfollowupservicesEnum.lookupEnum(model.getFurtherfollowupservices().toString()));
       entity.setOtheraftercareplanoraction(ExitplansactionsOtheraftercareplanoractionEnum.lookupEnum(model.getOtheraftercareplanoraction().toString()));
       entity.setPermanenthousingplacement(ExitplansactionsPermanenthousingplacementEnum.lookupEnum(model.getPermanenthousingplacement().toString()));
       entity.setResourcepackage(ExitplansactionsResourcepackageEnum.lookupEnum(model.getResourcepackage().toString()));
       entity.setScheduledfollowupcontacts(ExitplansactionsScheduledfollowupcontactsEnum.lookupEnum(model.getScheduledfollowupcontacts().toString()));
       entity.setTemporaryshelterplacement(ExitplansactionsTemporaryshelterplacementEnum.lookupEnum(model.getTemporaryshelterplacement().toString()));
       entity.setWrittenaftercareplan(ExitplansactionsWrittenaftercareplanEnum.lookupEnum(model.getWrittenaftercareplan().toString()));
       return entity;    
   }


   public static ExitPlansActions entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions entity) {
       ExitPlansActions model = new ExitPlansActions();
       model.setExitPlansActionsId(entity.getId());
       model.setAssistancemainstreambenefits(Integer.parseInt(entity.getAssistancemainstreambenefits().getValue()));
       model.setExitcounseling(Integer.parseInt(entity.getExitcounseling().getValue()));
       model.setFurtherfollowupservices(Integer.parseInt(entity.getFurtherfollowupservices().getValue()));
       model.setOtheraftercareplanoraction(Integer.parseInt(entity.getOtheraftercareplanoraction().getValue()));
       model.setPermanenthousingplacement(Integer.parseInt(entity.getPermanenthousingplacement().getValue()));
       model.setResourcepackage(Integer.parseInt(entity.getResourcepackage().getValue()));
       model.setScheduledfollowupcontacts(Integer.parseInt(entity.getScheduledfollowupcontacts().getValue()));
       model.setTemporaryshelterplacement(Integer.parseInt(entity.getTemporaryshelterplacement().getValue()));
       model.setWrittenaftercareplan(Integer.parseInt(entity.getWrittenaftercareplan().getValue()));
       copyBeanProperties(entity, model);
       return model;
   }


}
