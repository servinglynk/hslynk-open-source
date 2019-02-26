package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Pathstatus;
public class PathstatusConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Pathstatus modelToEntity (Pathstatus model ,com.servinglynk.hmis.warehouse.model.v2014.Pathstatus entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Pathstatus();
       if(model.getPathstatusId()!=null)
       entity.setId(model.getPathstatusId());
       if(model.getClientenrolledinpath()!=null)
       entity.setClientEnrolledInPath(model.getClientenrolledinpath());
       return entity;    
   }


   public static Pathstatus entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Pathstatus entity) {
       Pathstatus model = new Pathstatus();
       if(entity.getId()!=null)
       model.setPathstatusId(entity.getId());
       if(entity.getClientEnrolledInPath()!=null)
       model.setClientenrolledinpath(entity.getClientEnrolledInPath());
       copyBeanProperties(entity, model);
       return model;
   }


}
