package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.WorstHousingSituation;
import com.servinglynk.hmis.warehouse.enums.WorsthousingsituationWorsthousingsituationEnum;
public class WorstHousingSituationConverter extends BaseConveter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation modelToEntity (WorstHousingSituation model ,com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation();
       entity.setId(model.getWorstHousingSituationId());
       entity.setWorsthousingsituation(WorsthousingsituationWorsthousingsituationEnum.lookupEnum(model.getWorsthousingsituation().toString()));
       return entity;    
   }


   public static WorstHousingSituation entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation entity) {
       WorstHousingSituation model = new WorstHousingSituation();
       model.setWorstHousingSituationId(entity.getId());
       model.setWorsthousingsituation(Integer.parseInt(entity.getWorsthousingsituation().getValue()));
       copyBeanProperties(entity, model);
       return model;
   }


}
