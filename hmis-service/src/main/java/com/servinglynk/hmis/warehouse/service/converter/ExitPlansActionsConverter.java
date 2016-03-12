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
public class ExitPlansActionsConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions modelToEntity (ExitPlansActions model ,com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions();
       entity.setAssistancemainstreambenefits(ExitplansactionsAssistancemainstreambenefitsEnum.valueOf(model.getAssistancemainstreambenefits()));
       entity.setExitcounseling(ExitplansactionsExitcounselingEnum.valueOf(model.getExitcounseling()));
       entity.setFurtherfollowupservices(ExitplansactionsFurtherfollowupservicesEnum.valueOf(model.getFurtherfollowupservices()));
       entity.setOtheraftercareplanoraction(ExitplansactionsOtheraftercareplanoractionEnum.valueOf(model.getOtheraftercareplanoraction()));
       entity.setPermanenthousingplacement(ExitplansactionsPermanenthousingplacementEnum.valueOf(model.getPermanenthousingplacement()));
       entity.setResourcepackage(ExitplansactionsResourcepackageEnum.valueOf(model.getResourcepackage()));
       entity.setScheduledfollowupcontacts(ExitplansactionsScheduledfollowupcontactsEnum.valueOf(model.getScheduledfollowupcontacts()));
       entity.setTemporaryshelterplacement(ExitplansactionsTemporaryshelterplacementEnum.valueOf(model.getTemporaryshelterplacement()));
       entity.setWrittenaftercareplan(ExitplansactionsWrittenaftercareplanEnum.valueOf(model.getWrittenaftercareplan()));
       return entity;    
   }


   public static ExitPlansActions entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions entity) {
       ExitPlansActions model = new ExitPlansActions();
       model.setExitPlansActionsId(entity.getId());
       model.setAssistancemainstreambenefits(entity.getAssistancemainstreambenefits().name());
       model.setExitcounseling(entity.getExitcounseling().name());
       model.setFurtherfollowupservices(entity.getFurtherfollowupservices().name());
       model.setOtheraftercareplanoraction(entity.getOtheraftercareplanoraction().name());
       model.setPermanenthousingplacement(entity.getPermanenthousingplacement().name());
       model.setResourcepackage(entity.getResourcepackage().name());
       model.setScheduledfollowupcontacts(entity.getScheduledfollowupcontacts().name());
       model.setTemporaryshelterplacement(entity.getTemporaryshelterplacement().name());
       model.setWrittenaftercareplan(entity.getWrittenaftercareplan().name());
       return model;
   }


}
