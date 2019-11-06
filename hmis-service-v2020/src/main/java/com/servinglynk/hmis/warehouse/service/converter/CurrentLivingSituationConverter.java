package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.CurrentLivingSituation;
import com.servinglynk.hmis.warehouse.enums.LivingSituationEnum;
import com.servinglynk.hmis.warehouse.enums.NoYesEnum;
public class CurrentLivingSituationConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation modelToEntity (CurrentLivingSituation model ,com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation();
       entity.setId(model.getCurrentLivingSituationId());
       entity.setLeavesituation14days(NoYesEnum.lookupEnum(model.getLeavesituation14days()));
       entity.setLivingSituation(LivingSituationEnum.lookupEnum(model.getLivingSituation()));
       entity.setLocationdetails(model.getLocationdetails());
       entity.setMovedtwoormore(NoYesEnum.lookupEnum(model.getMovedtwoormore()));
       entity.setResourcestoobtain(NoYesEnum.lookupEnum(model.getResourcestoobtain()));
       entity.setSubsequentresidence(NoYesEnum.lookupEnum(model.getSubsequentresidence()));
       
       return entity;
   }


   public static CurrentLivingSituation entityToModel (com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation entity) {
       CurrentLivingSituation model = new CurrentLivingSituation();
       model.setCurrentLivingSituationId(entity.getId());
       NoYesEnum leavesituation14days = entity.getLeavesituation14days();
       if(leavesituation14days !=null)
    	   model.setLeavesituation14days(leavesituation14days.getValue());
       LivingSituationEnum livingSituation = entity.getLivingSituation();
       if(livingSituation !=null)
    	   model.setLivingSituation(livingSituation.getValue());
       model.setLocationdetails(entity.getLocationdetails());
       NoYesEnum movedtwoormore = entity.getMovedtwoormore();
       if(movedtwoormore !=null)
    	   model.setMovedtwoormore(movedtwoormore.getValue());
       NoYesEnum resourcestoobtain = entity.getResourcestoobtain();
       if(resourcestoobtain !=null)
    	   model.setResourcestoobtain(resourcestoobtain.getValue());
       NoYesEnum subsequentresidence = entity.getSubsequentresidence();
       if(subsequentresidence !=null)
    	   model.setSubsequentresidence(subsequentresidence.getValue());
       if(entity.getEnrollmentid() != null)
    	   model.setEnrollmentid(entity.getEnrollmentid().getId());
       
       return model;
   }


}
