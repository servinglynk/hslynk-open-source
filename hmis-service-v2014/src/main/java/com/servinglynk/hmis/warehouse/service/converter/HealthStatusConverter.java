package com.servinglynk.hmis.warehouse.service.converter; 

import java.time.ZoneId;
import java.util.Date;

import com.servinglynk.hmis.warehouse.core.model.HealthStatus;
import com.servinglynk.hmis.warehouse.enums.HealthStatusHealthCategoryEnum;
import com.servinglynk.hmis.warehouse.enums.HealthStatusHealthStatusEnum;
public class HealthStatusConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.HealthStatus modelToEntity (HealthStatus model ,com.servinglynk.hmis.warehouse.model.v2014.HealthStatus entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.HealthStatus();
       if(model.getHealthStatusId()!=null)
       entity.setId(model.getHealthStatusId());
       if(model.getInformationDate()!=null)
       entity.setInformationDate(model.getInformationDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
       if(model.getHealthCategory()!=null)
       entity.setHealthCategory(HealthStatusHealthCategoryEnum.lookupEnum(model.getHealthCategory().toString()));
       if(model.getHealthStatus()!=null)
       entity.setHealthStatus(HealthStatusHealthStatusEnum.lookupEnum(model.getHealthStatus().toString()));
       if(model.getDueDate()!=null)
       entity.setDueDate(model.getDueDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
       return entity;    
   }


   public static HealthStatus entityToModel (com.servinglynk.hmis.warehouse.model.v2014.HealthStatus entity) {
       HealthStatus model = new HealthStatus();
       if(entity.getId()!=null)
       model.setHealthStatusId(entity.getId());
       if(entity.getInformationDate()!=null)
       model.setInformationDate(Date.from(entity.getInformationDate().atZone(ZoneId.systemDefault()).toInstant()));
       if(entity.getHealthCategory()!=null)
       model.setHealthCategory(Integer.parseInt(entity.getHealthCategory().getValue()));
       if(entity.getHealthStatus()!=null)
       model.setHealthStatus(Integer.parseInt(entity.getHealthStatus().getValue()));
       if(entity.getDueDate()!=null)
       model.setDueDate(Date.from(entity.getDueDate().atZone(ZoneId.systemDefault()).toInstant()));
       copyBeanProperties(entity, model);
       return model;
   }


}
