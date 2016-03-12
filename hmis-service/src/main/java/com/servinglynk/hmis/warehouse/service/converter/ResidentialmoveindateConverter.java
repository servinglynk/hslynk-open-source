package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Residentialmoveindate;
import com.servinglynk.hmis.warehouse.enums.ResidentialmoveindateInpermanenthousingEnum;
public class ResidentialmoveindateConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate modelToEntity (Residentialmoveindate model ,com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate();
       entity.setId(model.getResidentialmoveindateId());
       entity.setInpermanenthousing(ResidentialmoveindateInpermanenthousingEnum.valueOf(model.getInpermanenthousing()));
       return entity;    
   }


   public static Residentialmoveindate entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate entity) {
       Residentialmoveindate model = new Residentialmoveindate();
       model.setResidentialmoveindateId(entity.getId());
       model.setInpermanenthousing(entity.getInpermanenthousing().name());
       return model;
   }


}
