package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Schoolstatus;
public class SchoolstatusConverter extends BaseConveter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus modelToEntity (Schoolstatus model ,com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus();
       entity.setId(model.getSchoolstatusId());
       entity.setInformationDate(model.getInformationDate());
       return entity;    
   }


   public static Schoolstatus entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus entity) {
       Schoolstatus model = new Schoolstatus();
       model.setSchoolstatusId(entity.getId());
       model.setInformationDate(entity.getInformationDate());
       copyBeanProperties(entity, model);
       return model;
   }


}
