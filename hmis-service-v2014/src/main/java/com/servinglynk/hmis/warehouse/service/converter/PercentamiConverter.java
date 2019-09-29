package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.Percentami;
public class PercentamiConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Percentami modelToEntity (Percentami model ,com.servinglynk.hmis.warehouse.model.v2014.Percentami entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Percentami();
       if(model.getPercentamiId()!=null)
       entity.setId(model.getPercentamiId());
       if(model.getPercentage()!=null)
       entity.setPercentage(model.getPercentage());
       return entity;    
   }


   public static Percentami entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Percentami entity) {
       Percentami model = new Percentami();
       if(entity.getId()!=null)
       model.setPercentamiId(entity.getId());
       if(entity.getPercentage()!=null)
       model.setPercentage(entity.getPercentage());
       copyBeanProperties(entity, model);

       if(entity.getParentId() ==null && entity.getEnrollmentid()!=null && entity.getEnrollmentid().getClient()!=null) {
    	   model.addLink(new ActionLink("history","/clients/"+entity.getEnrollmentid().getClient().getId()+"/enrollments/"+entity.getEnrollmentid().getId()+"/percentamis/"+entity.getId()+"/history"));
       }
       return model;
   }


}
