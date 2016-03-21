package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Pathstatus;
public class PathstatusConverter extends BaseConveter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Pathstatus modelToEntity (Pathstatus model ,com.servinglynk.hmis.warehouse.model.v2014.Pathstatus entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Pathstatus();
       entity.setId(model.getPathstatusId());
       entity.setClientEnrolledInPath(model.getClientenrolledinpath());
       return entity;    
   }


   public static Pathstatus entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Pathstatus entity) {
       Pathstatus model = new Pathstatus();
       model.setPathstatusId(entity.getId());
       model.setClientenrolledinpath(entity.getClientEnrolledInPath());
       copyBeanProperties(entity, model);
       return model;
   }


}
