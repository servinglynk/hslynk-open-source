package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Funder;
import com.servinglynk.hmis.warehouse.enums.FunderFunderEnum;
public class FunderConverter extends BaseConveter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Funder modelToEntity (Funder model ,com.servinglynk.hmis.warehouse.model.v2014.Funder entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Funder();
       entity.setId(model.getFunderId());
       entity.setEnddate(model.getEnddate());
       entity.setFunder(FunderFunderEnum.lookupEnum(model.getFunder().toString()));
       entity.setGrantid(model.getGrantid());
       entity.setStartdate(model.getStartdate());
       return entity;    
   }


   public static Funder entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Funder entity) {
       Funder model = new Funder();
       model.setFunderId(entity.getId());
       model.setEnddate(entity.getEnddate());
       model.setFunder(Integer.parseInt(entity.getFunder().getValue()));
       model.setGrantid(entity.getGrantid());
       model.setStartdate(entity.getStartdate());
       copyBeanProperties(entity, model);
       return model;
   }


}
