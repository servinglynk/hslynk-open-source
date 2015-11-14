package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.WorstHousingSituation;
import com.servinglynk.hmis.warehouse.enums.WorsthousingsituationWorsthousingsituationEnum;
public class WorstHousingSituationConverter {

   public static com.servinglynk.hmis.warehouse.model.live.Worsthousingsituation modelToEntity (WorstHousingSituation model ,com.servinglynk.hmis.warehouse.model.live.Worsthousingsituation entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.live.Worsthousingsituation();
       entity.setId(model.getWorstHousingSituationId());
       entity.setWorsthousingsituation(WorsthousingsituationWorsthousingsituationEnum.valueOf(model.getWorsthousingsituation()));
       return entity;    
   }


   public static WorstHousingSituation entityToModel (com.servinglynk.hmis.warehouse.model.live.Worsthousingsituation entity) {
       WorstHousingSituation model = new WorstHousingSituation();
       model.setWorstHousingSituationId(entity.getId());
       model.setWorsthousingsituation(entity.getWorsthousingsituation().name());
       return model;
   }


}
