package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.Funder;
import com.servinglynk.hmis.warehouse.enums.FunderFunderEnum;
public class FunderConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2017.Funder modelToEntity (Funder model ,com.servinglynk.hmis.warehouse.model.v2017.Funder entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2017.Funder();
       if(model.getFunderId()!=null)
       entity.setId(model.getFunderId());
       if(model.getEnddate()!=null)
       entity.setEnddate(model.getEnddate());
       if(model.getFunder()!=null)
       entity.setFunder(FunderFunderEnum.lookupEnum(model.getFunder().toString()));
       if(model.getGrantid()!=null)
       entity.setGrantid(model.getGrantid());
       if(model.getStartdate()!=null)
       entity.setStartdate(model.getStartdate());
       return entity;
   }


   public static Funder entityToModel (com.servinglynk.hmis.warehouse.model.v2017.Funder entity) {
       Funder model = new Funder();
       if(entity.getId()!=null)
       model.setFunderId(entity.getId());
       if(entity.getEnddate()!=null)
       model.setEnddate(entity.getEnddate());
       if(entity.getFunder()!=null)
       model.setFunder(Integer.parseInt(entity.getFunder().getValue()));
       if(entity.getGrantid()!=null)
       model.setGrantid(entity.getGrantid());
       if(entity.getStartdate()!=null)
       model.setStartdate(entity.getStartdate());
       copyBeanProperties(entity, model);
       return model;
   }


}
