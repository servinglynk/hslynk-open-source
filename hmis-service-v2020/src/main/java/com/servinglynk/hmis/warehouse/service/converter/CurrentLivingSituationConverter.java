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
       model.setLeavesituation14days(entity.getLeavesituation14days().getValue());
       model.setLivingSituation(entity.getLivingSituation().getValue());
       model.setLocationdetails(entity.getLocationdetails());
       model.setMovedtwoormore(entity.getMovedtwoormore().getValue());
       model.setResourcestoobtain(entity.getResourcestoobtain().getValue());
       model.setSubsequentresidence(entity.getSubsequentresidence().getValue());
       if(entity.getEnrollmentid() != null)
    	   model.setEnrollmentid(entity.getEnrollmentid().getId());
       
       return model;
   }


}
