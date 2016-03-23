package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Schoolstatus;
public class SchoolstatusConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus modelToEntity (Schoolstatus model ,com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus();
       if(model.getSchoolstatusId()!=null)
       entity.setId(model.getSchoolstatusId());
       if(model.getInformationDate()!=null)
       entity.setInformationDate(model.getInformationDate());
       return entity;    
   }


   public static Schoolstatus entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus entity) {
       Schoolstatus model = new Schoolstatus();
       if(entity.getId()!=null)
       model.setSchoolstatusId(entity.getId());
       if(entity.getInformationDate()!=null)
       model.setInformationDate(entity.getInformationDate());
       copyBeanProperties(entity, model);
       return model;
   }


}
