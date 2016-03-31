package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.EnrollmentCoc;
public class EnrollmentCocConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2015.EnrollmentCoc modelToEntity (EnrollmentCoc model ,com.servinglynk.hmis.warehouse.model.v2015.EnrollmentCoc entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2015.EnrollmentCoc();
       entity.setId(model.getEnrollmentCocId());
       entity.setInformationDate(model.getInformationDate());
       entity.setClientCode(model.getClientCode());
       return entity;    
   }


   public static EnrollmentCoc entityToModel (com.servinglynk.hmis.warehouse.model.v2015.EnrollmentCoc entity) {
       EnrollmentCoc model = new EnrollmentCoc();
       model.setEnrollmentCocId(entity.getId());
       model.setInformationDate(entity.getInformationDate());
       model.setClientCode(entity.getClientCode());
       return model;
   }


}
