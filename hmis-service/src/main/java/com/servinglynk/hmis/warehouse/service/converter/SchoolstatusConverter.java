package com.servinglynk.hmis.warehouse.service.converter; 

import java.time.LocalDateTime;

import com.servinglynk.hmis.warehouse.core.model.Schoolstatus;
public class SchoolstatusConverter {

   public static com.servinglynk.hmis.warehouse.model.live.Schoolstatus modelToEntity (Schoolstatus model ,com.servinglynk.hmis.warehouse.model.live.Schoolstatus entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.live.Schoolstatus();
       entity.setId(model.getSchoolstatusId());
       entity.setInformationDate(LocalDateTime.now());
       return entity;    
   }


   public static Schoolstatus entityToModel (com.servinglynk.hmis.warehouse.model.live.Schoolstatus entity) {
       Schoolstatus model = new Schoolstatus();
       model.setSchoolstatusId(entity.getId());
       model.setInformationDate(entity.getInformationDate());
       return model;
   }


}
