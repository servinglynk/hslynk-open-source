package com.servinglynk.hmis.warehouse.service.converter; 

import java.time.ZoneId;
import java.util.Date;

import com.servinglynk.hmis.warehouse.core.model.HealthStatus;
import com.servinglynk.hmis.warehouse.enums.HealthStatusHealthCategoryEnum;
import com.servinglynk.hmis.warehouse.enums.HealthStatusHealthStatusEnum;
public class HealthStatusConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.HealthStatus modelToEntity (HealthStatus model ,com.servinglynk.hmis.warehouse.model.v2014.HealthStatus entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.HealthStatus();
       entity.setId(model.getHealthStatusId());
       entity.setInformationDate(model.getInformationDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
       entity.setHealthCategory(HealthStatusHealthCategoryEnum.valueOf(model.getHealthCategory()));
       entity.setHealthStatus(HealthStatusHealthStatusEnum.valueOf(model.getHealthStatus()));
       entity.setDueDate(model.getDueDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
       return entity;    
   }


   public static HealthStatus entityToModel (com.servinglynk.hmis.warehouse.model.v2014.HealthStatus entity) {
       HealthStatus model = new HealthStatus();
       model.setHealthStatusId(entity.getId());
       model.setInformationDate(Date.from(entity.getInformationDate().atZone(ZoneId.systemDefault()).toInstant()));
       model.setHealthCategory(entity.getHealthCategory().name());
       model.setHealthStatus(entity.getHealthStatus().name());
       model.setDueDate(Date.from(entity.getDueDate().atZone(ZoneId.systemDefault()).toInstant()));
       return model;
   }


}
