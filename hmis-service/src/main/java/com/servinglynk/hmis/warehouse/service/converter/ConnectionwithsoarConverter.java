package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Connectionwithsoar;
public class ConnectionwithsoarConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar modelToEntity (Connectionwithsoar model ,com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar();
       entity.setId(model.getConnectionwithsoarId());
       entity.setConnectionwithsoar(model.getConnectionwithsoar());
       return entity;    
   }


   public static Connectionwithsoar entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar entity) {
       Connectionwithsoar model = new Connectionwithsoar();
       model.setConnectionwithsoarId(entity.getId());
       model.setConnectionwithsoar(entity.getConnectionwithsoar());
       return model;
   }


}
