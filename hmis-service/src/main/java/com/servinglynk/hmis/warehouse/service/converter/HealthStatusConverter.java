package com.servinglynk.hmis.warehouse.service.converter; 

import java.time.ZoneId;
import java.util.Date;

import com.servinglynk.hmis.warehouse.core.model.HealthStatus;
import com.servinglynk.hmis.warehouse.enums.HealthStatusHealthCategoryEnum;
import com.servinglynk.hmis.warehouse.enums.HealthStatusHealthStatusEnum;
public class HealthStatusConverter extends BaseConveter {

   public static com.servinglynk.hmis.warehouse.model.v2014.HealthStatus modelToEntity (HealthStatus model ,com.servinglynk.hmis.warehouse.model.v2014.HealthStatus entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.HealthStatus();
       entity.setId(model.getHealthStatusId());
       entity.setInformationDate(model.getInformationDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
       entity.setHealthCategory(HealthStatusHealthCategoryEnum.lookupEnum(model.getHealthCategory().toString()));
       entity.setHealthStatus(HealthStatusHealthStatusEnum.lookupEnum(model.getHealthStatus().toString()));
       entity.setDueDate(model.getDueDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
       return entity;    
   }


   public static HealthStatus entityToModel (com.servinglynk.hmis.warehouse.model.v2014.HealthStatus entity) {
       HealthStatus model = new HealthStatus();
       model.setHealthStatusId(entity.getId());
       model.setInformationDate(Date.from(entity.getInformationDate().atZone(ZoneId.systemDefault()).toInstant()));
       model.setHealthCategory(Integer.parseInt(entity.getHealthCategory().getValue()));
       model.setHealthStatus(Integer.parseInt(entity.getHealthStatus().getValue()));
       model.setDueDate(Date.from(entity.getDueDate().atZone(ZoneId.systemDefault()).toInstant()));
       copyBeanProperties(entity, model);
       return model;
   }


}
