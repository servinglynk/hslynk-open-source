package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.Connectionwithsoar;
import com.servinglynk.hmis.warehouse.enums.ConnectionWithSoarEnum;
public class ConnectionwithsoarConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2020.ConnectionWithSoar modelToEntity (Connectionwithsoar model ,com.servinglynk.hmis.warehouse.model.v2020.ConnectionWithSoar entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2020.ConnectionWithSoar();
       if(model.getConnectionwithsoarId()!=null)
       entity.setId(model.getConnectionwithsoarId());
       if(model.getConnectionwithsoar()!=null)
       entity.setConnectionwithsoar(ConnectionWithSoarEnum.lookupEnum(model.getConnectionwithsoar()+""));
       return entity;    
   }


   public static Connectionwithsoar entityToModel (com.servinglynk.hmis.warehouse.model.v2020.ConnectionWithSoar entity) {
       Connectionwithsoar model = new Connectionwithsoar();
       if(entity.getId()!=null)
       model.setConnectionwithsoarId(entity.getId());
       if(entity.getConnectionwithsoar()!=null)
    	   model.setConnectionwithsoar(Integer.parseInt(entity.getConnectionwithsoar().getValue()));
       copyBeanProperties(entity, model);
       if(entity.getParentId() ==null && entity.getEnrollmentid()!=null && entity.getEnrollmentid().getClient()!=null) {
    	   model.addLink(new ActionLink("history","/clients/"+entity.getEnrollmentid().getClient().getId()+"/enrollments/"+entity.getEnrollmentid().getId()+"/connectionwithsoars/"+entity.getId()+"/history"));
       }
       return model;
   }


}
