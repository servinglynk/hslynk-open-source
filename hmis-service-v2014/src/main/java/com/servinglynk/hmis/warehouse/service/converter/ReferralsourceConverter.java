package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Referralsource;
public class ReferralsourceConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Referralsource modelToEntity (Referralsource model ,com.servinglynk.hmis.warehouse.model.v2014.Referralsource entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Referralsource();
       if(model.getReferralsourceId()!=null)
       entity.setId(model.getReferralsourceId());
       if(model.getCountoutreachreferralapproaches()!=null)
       entity.setCountoutreachreferralapproaches(model.getCountoutreachreferralapproaches());
       return entity;    
   }


   public static Referralsource entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Referralsource entity) {
       Referralsource model = new Referralsource();
       if(entity.getId()!=null)
       model.setReferralsourceId(entity.getId());
       if(entity.getCountoutreachreferralapproaches()!=null)
       model.setCountoutreachreferralapproaches(entity.getCountoutreachreferralapproaches());
       copyBeanProperties(entity, model);
       return model;
   }


}
