package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.WorstHousingSituation;
import com.servinglynk.hmis.warehouse.enums.WorsthousingsituationWorsthousingsituationEnum;
public class WorstHousingSituationConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation modelToEntity (WorstHousingSituation model ,com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation();
       if(model.getWorstHousingSituationId()!=null)
       entity.setId(model.getWorstHousingSituationId());
       if(model.getWorsthousingsituation()!=null)
       entity.setWorsthousingsituation(WorsthousingsituationWorsthousingsituationEnum.lookupEnum(model.getWorsthousingsituation().toString()));
       return entity;    
   }


   public static WorstHousingSituation entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation entity) {
       WorstHousingSituation model = new WorstHousingSituation();
       if(entity.getId()!=null)
       model.setWorstHousingSituationId(entity.getId());
       if(entity.getWorsthousingsituation()!=null)
       model.setWorsthousingsituation(Integer.parseInt(entity.getWorsthousingsituation().getValue()));
       copyBeanProperties(entity, model);
       if(entity.getParentId() ==null && entity.getEnrollmentid()!=null && entity.getEnrollmentid().getClient()!=null) {
    	   model.addLink(new ActionLink("history","/clients/"+entity.getEnrollmentid().getClient().getId()+"/enrollments/"+entity.getEnrollmentid().getId()+"/worsthousingsituations/"+entity.getId()+"/history"));
       }
       return model;
   }


}
