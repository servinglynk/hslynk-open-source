package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.EnrollmentCoc;
public class EnrollmentCocConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc modelToEntity (EnrollmentCoc model ,com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc();
       	  entity.setId(model.getEnrollmentCocId());
          entity.setCocCode(model.getCocCode());
       return entity;    
   }


   public static EnrollmentCoc entityToModel (com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc entity) {
       EnrollmentCoc model = new EnrollmentCoc();
       model.setEnrollmentCocId(entity.getId());
       model.setCocCode(entity.getCocCode());
       model.setDateCreated(entity.getDateCreated());
       model.setDateUpdated(entity.getDateUpdated());
       return model;
   }


}
