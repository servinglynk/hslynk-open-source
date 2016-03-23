package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Percentami;
public class PercentamiConverter extends BaseConveter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Percentami modelToEntity (Percentami model ,com.servinglynk.hmis.warehouse.model.v2014.Percentami entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Percentami();
       entity.setId(model.getPercentamiId());
       entity.setPercentage(model.getPercentage());
       return entity;    
   }


   public static Percentami entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Percentami entity) {
       Percentami model = new Percentami();
       model.setPercentamiId(entity.getId());
       model.setPercentage(entity.getPercentage());
       copyBeanProperties(entity, model);
       return model;
   }


}
