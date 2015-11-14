package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Percentami;
public class PercentamiConverter {

   public static com.servinglynk.hmis.warehouse.model.live.Percentami modelToEntity (Percentami model ,com.servinglynk.hmis.warehouse.model.live.Percentami entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.live.Percentami();
       entity.setId(model.getPercentamiId());
       entity.setPercentage(model.getPercentage());
       return entity;    
   }


   public static Percentami entityToModel (com.servinglynk.hmis.warehouse.model.live.Percentami entity) {
       Percentami model = new Percentami();
       model.setPercentamiId(entity.getId());
       model.setPercentage(entity.getPercentage());
       return model;
   }


}
