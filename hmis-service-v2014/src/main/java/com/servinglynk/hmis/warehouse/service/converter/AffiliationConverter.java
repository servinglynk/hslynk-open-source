package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Affiliation;
public class AffiliationConverter extends BaseConveter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Affiliation modelToEntity (Affiliation model ,com.servinglynk.hmis.warehouse.model.v2014.Affiliation entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Affiliation();
       entity.setId(model.getAffiliationId());
       entity.setResprojectid(model.getResprojectid());
       return entity;    
   }


   public static Affiliation entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Affiliation entity) {
       Affiliation model = new Affiliation();
       model.setAffiliationId(entity.getId());
       model.setResprojectid(entity.getResprojectid());
       copyBeanProperties(entity, model);
       return model;
   }


}
