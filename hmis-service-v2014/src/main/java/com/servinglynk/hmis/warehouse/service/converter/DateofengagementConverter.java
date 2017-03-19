package com.servinglynk.hmis.warehouse.service.converter; 

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

import com.servinglynk.hmis.warehouse.core.model.Dateofengagement;
public class DateofengagementConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement modelToEntity (Dateofengagement model ,com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement();
       if(model.getDateofengagementId()!=null)
       entity.setId(model.getDateofengagementId());
       if(model.getDateofengagement()!=null)
       entity.setDateofengagement(model.getDateofengagement().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
       return entity;    
   }


   public static Dateofengagement entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement entity) {
       Dateofengagement model = new Dateofengagement();
       if(entity.getId()!=null)
       model.setDateofengagementId(entity.getId());  
       if(entity.getDateofengagement()!=null){
       Instant instant = entity.getDateofengagement().atZone(ZoneId.systemDefault()).toInstant();
       model.setDateofengagement(Date.from(instant));
       }
       copyBeanProperties(entity, model);
       return model;
   }


}
