package com.servinglynk.hmis.warehouse.service.converter; 

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

import com.servinglynk.hmis.warehouse.core.model.Dateofengagement;
public class DateofengagementConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement modelToEntity (Dateofengagement model ,com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement();
       entity.setId(model.getDateofengagementId());
       entity.setDateofengagement(model.getDateofengagement().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
       return entity;    
   }


   public static Dateofengagement entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement entity) {
       Dateofengagement model = new Dateofengagement();
       model.setDateofengagementId(entity.getId());
       Instant instant = entity.getDateofengagement().atZone(ZoneId.systemDefault()).toInstant();
       model.setDateofengagement(Date.from(instant));
       return model;
   }


}
