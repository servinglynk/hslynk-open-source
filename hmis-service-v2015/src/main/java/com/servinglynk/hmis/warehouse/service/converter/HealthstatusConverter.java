package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Healthstatus;
import com.servinglynk.hmis.warehouse.enums.HealthStatusHealthCategoryEnum;
import com.servinglynk.hmis.warehouse.enums.HealthStatusHealthStatusEnum;
public class HealthstatusConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2015.HealthStatus modelToEntity (Healthstatus model ,com.servinglynk.hmis.warehouse.model.v2015.HealthStatus entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2015.HealthStatus();
       entity.setId(model.getHealthstatusId());
       entity.setInformationDate(model.getInformationDate());
 if(model.getHealthCategory()!=null)
       entity.setHealthCategory(HealthStatusHealthCategoryEnum.lookupEnum(model.getHealthCategory().toString()));
 if(model.getHealthStatus()!=null)
       entity.setHealthStatus(HealthStatusHealthStatusEnum.lookupEnum(model.getHealthStatus().toString()));
       entity.setDueDate(model.getDueDate());
       return entity;    
   }


   public static Healthstatus entityToModel (com.servinglynk.hmis.warehouse.model.v2015.HealthStatus entity) {
       Healthstatus model = new Healthstatus();
       model.setHealthstatusId(entity.getId());
       model.setInformationDate(entity.getInformationDate());
if(entity.getHealthCategory()!=null)
       model.setHealthCategory(Integer.parseInt(entity.getHealthCategory().getValue()));
if(entity.getHealthStatus()!=null)
       model.setHealthStatus(Integer.parseInt(entity.getHealthStatus().getValue()));
       model.setDueDate(entity.getDueDate());
       return model;
   }


}
