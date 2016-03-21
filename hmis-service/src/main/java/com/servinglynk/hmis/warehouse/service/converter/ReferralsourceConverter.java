package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Referralsource;
public class ReferralsourceConverter extends BaseConveter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Referralsource modelToEntity (Referralsource model ,com.servinglynk.hmis.warehouse.model.v2014.Referralsource entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Referralsource();
       entity.setId(model.getReferralsourceId());
       entity.setCountoutreachreferralapproaches(model.getCountoutreachreferralapproaches());
       return entity;    
   }


   public static Referralsource entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Referralsource entity) {
       Referralsource model = new Referralsource();
       model.setReferralsourceId(entity.getId());
       model.setCountoutreachreferralapproaches(entity.getCountoutreachreferralapproaches());
       copyBeanProperties(entity, model);
       return model;
   }


}
