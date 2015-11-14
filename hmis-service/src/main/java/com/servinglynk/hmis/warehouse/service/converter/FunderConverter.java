package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Funder;
import com.servinglynk.hmis.warehouse.enums.FunderFunderEnum;
public class FunderConverter {

   public static com.servinglynk.hmis.warehouse.model.live.Funder modelToEntity (Funder model ,com.servinglynk.hmis.warehouse.model.live.Funder entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.live.Funder();
       entity.setId(model.getFunderId());
       entity.setEnddate(model.getEnddate());
       entity.setFunder(FunderFunderEnum.valueOf(model.getFunder()));
       entity.setGrantid(model.getGrantid());
       entity.setStartdate(model.getStartdate());
       return entity;    
   }


   public static Funder entityToModel (com.servinglynk.hmis.warehouse.model.live.Funder entity) {
       Funder model = new Funder();
       model.setFunderId(entity.getId());
       model.setEnddate(entity.getEnddate());
       model.setFunder(entity.getFunder().name());
       model.setGrantid(entity.getGrantid());
       model.setStartdate(entity.getStartdate());
       return model;
   }


}
