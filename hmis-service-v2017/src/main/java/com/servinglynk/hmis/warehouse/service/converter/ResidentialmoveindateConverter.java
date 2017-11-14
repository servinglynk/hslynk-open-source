package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.Residentialmoveindate;
public class ResidentialmoveindateConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2017.Moveindate modelToEntity (Residentialmoveindate model ,com.servinglynk.hmis.warehouse.model.v2017.Moveindate entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2017.Moveindate();
       entity.setId(model.getResidentialmoveindateId());
       entity.setMoveindate(model.getResidentialmoveindate());
       return entity;
   }


   public static Residentialmoveindate entityToModel (com.servinglynk.hmis.warehouse.model.v2017.Moveindate entity) {
       Residentialmoveindate model = new Residentialmoveindate();
       model.setResidentialmoveindateId(entity.getId());
       model.setResidentialmoveindate(entity.getMoveindate());
       return model;
   }


}
