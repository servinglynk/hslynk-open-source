package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.Projectcoc;
public class ProjectcocConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Projectcoc modelToEntity (Projectcoc model ,com.servinglynk.hmis.warehouse.model.v2014.Projectcoc entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Projectcoc();
       if(model.getCoccode()!=null)
       entity.setCoccode(model.getCoccode());
       return entity;    
   }


   public static Projectcoc entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Projectcoc entity) {
       Projectcoc model = new Projectcoc();
       if(entity.getId()!=null)
       model.setProjectcocId(entity.getId());
       if(entity.getCoccode()!=null)
       model.setCoccode(entity.getCoccode());
       copyBeanProperties(entity, model);
       if(entity.getParentId() ==null) {
    	   model.addLink(new ActionLink("history","/projects/"+entity.getProjectid().getId()+"/projectcocs/"+entity.getId()+"/history"));
       }
       return model;
   }


}
