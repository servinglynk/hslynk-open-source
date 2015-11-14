package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.DomesticViolence;
import com.servinglynk.hmis.warehouse.enums.DomesticviolenceDomesticviolencevictimEnum;
import com.servinglynk.hmis.warehouse.enums.DomesticviolenceWhenoccurredEnum;
public class DomesticViolenceConverter {

   public static com.servinglynk.hmis.warehouse.model.live.Domesticviolence modelToEntity (DomesticViolence model ,com.servinglynk.hmis.warehouse.model.live.Domesticviolence entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.live.Domesticviolence();
       entity.setId(model.getDomesticViolenceId());
       entity.setDomesticviolencevictim(DomesticviolenceDomesticviolencevictimEnum.valueOf(model.getDomesticviolencevictim()));
       entity.setWhenoccurred(DomesticviolenceWhenoccurredEnum.valueOf(model.getWhenoccurred()));
       return entity;    
   }


   public static DomesticViolence entityToModel (com.servinglynk.hmis.warehouse.model.live.Domesticviolence entity) {
       DomesticViolence model = new DomesticViolence();
       model.setDomesticViolenceId(entity.getId());
       model.setDomesticviolencevictim(entity.getDomesticviolencevictim().name());
       model.setWhenoccurred(entity.getWhenoccurred().name());
       return model;
   }


}
