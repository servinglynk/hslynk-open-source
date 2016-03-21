package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.DomesticViolence;
import com.servinglynk.hmis.warehouse.enums.DomesticviolenceDomesticviolencevictimEnum;
import com.servinglynk.hmis.warehouse.enums.DomesticviolenceWhenoccurredEnum;
public class DomesticViolenceConverter extends BaseConveter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence modelToEntity (DomesticViolence model ,com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence();
       entity.setId(model.getDomesticViolenceId());
       entity.setDomesticviolencevictim(DomesticviolenceDomesticviolencevictimEnum.lookupEnum(model.getDomesticviolencevictim().toString()));
       entity.setWhenoccurred(DomesticviolenceWhenoccurredEnum.lookupEnum(model.getWhenoccurred().toString()));
       return entity;    
   }


   public static DomesticViolence entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence entity) {
       DomesticViolence model = new DomesticViolence();
       model.setDomesticViolenceId(entity.getId());
       model.setDomesticviolencevictim(Integer.parseInt(entity.getDomesticviolencevictim().getValue()));
       model.setWhenoccurred(Integer.parseInt(entity.getWhenoccurred().getValue()));
       copyBeanProperties(entity, model);
       return model;
   }


}
