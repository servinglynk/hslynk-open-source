package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.Affiliation;
public class AffiliationConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2015.Affiliation modelToEntity (Affiliation model ,com.servinglynk.hmis.warehouse.model.v2015.Affiliation entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2015.Affiliation();
       if(model.getAffiliationId()!=null)
       entity.setId(model.getAffiliationId());
       if(model.getResprojectid()!=null)
       entity.setResprojectid(model.getResprojectid());
       return entity;    
   }


   public static Affiliation entityToModel (com.servinglynk.hmis.warehouse.model.v2015.Affiliation entity) {
       Affiliation model = new Affiliation();
       if(entity.getId()!=null)
       model.setAffiliationId(entity.getId());
       if(entity.getResprojectid()!=null)
       model.setResprojectid(entity.getResprojectid());
       copyBeanProperties(entity, model);
       if(entity.getProjectid()!=null)
    	   model.addLink(new ActionLink("history","/projects/"+entity.getProjectid().getId()+"/affiliations/"+entity.getId()+"/history"));
       return model;
   }


}
