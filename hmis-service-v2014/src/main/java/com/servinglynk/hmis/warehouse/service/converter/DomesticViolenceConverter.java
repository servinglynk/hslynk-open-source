package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.DomesticViolence;
import com.servinglynk.hmis.warehouse.enums.DomesticviolenceDomesticviolencevictimEnum;
import com.servinglynk.hmis.warehouse.enums.DomesticviolenceWhenoccurredEnum;
public class DomesticViolenceConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence modelToEntity (DomesticViolence model ,com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence();
       if(model.getDomesticViolenceId()!=null)
       entity.setId(model.getDomesticViolenceId());
       if(model.getDomesticviolencevictim()!=null)
       entity.setDomesticviolencevictim(DomesticviolenceDomesticviolencevictimEnum.lookupEnum(model.getDomesticviolencevictim().toString()));
       if(model.getWhenoccurred()!=null)
       entity.setWhenoccurred(DomesticviolenceWhenoccurredEnum.lookupEnum(model.getWhenoccurred().toString()));
       return entity;    
   }


   public static DomesticViolence entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence entity) {
       DomesticViolence model = new DomesticViolence();
       if(entity.getId()!=null)
       model.setDomesticViolenceId(entity.getId());
       if(entity.getDomesticviolencevictim()!=null)
       model.setDomesticviolencevictim(Integer.parseInt(entity.getDomesticviolencevictim().getValue()));
       if(entity.getWhenoccurred()!=null)
       model.setWhenoccurred(Integer.parseInt(entity.getWhenoccurred().getValue()));
       copyBeanProperties(entity, model);
       return model;
   }


}
