package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.Dateofengagement;
public class DateofengagementConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2015.Dateofengagement modelToEntity (Dateofengagement model ,com.servinglynk.hmis.warehouse.model.v2015.Dateofengagement entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2015.Dateofengagement();
       entity.setId(model.getDateofengagementId());
       entity.setDateofengagement(model.getDateofengagement());
       return entity;    
   }


   public static Dateofengagement entityToModel (com.servinglynk.hmis.warehouse.model.v2015.Dateofengagement entity) {
       Dateofengagement model = new Dateofengagement();
       model.setDateofengagementId(entity.getId());
       model.setDateofengagement(entity.getDateofengagement());
       if(entity.getParentId() ==null && entity.getEnrollmentid()!=null && entity.getEnrollmentid().getClient()!=null) {
    	   model.addLink(new ActionLink("history","/clients/"+entity.getEnrollmentid().getClient().getId()+"/enrollments/"+entity.getEnrollmentid().getId()+"/dateofengagements/"+entity.getId()+"/history"));
       }
       return model;
   }


}
