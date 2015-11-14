package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Pathstatus;
public class PathstatusConverter {

   public static com.servinglynk.hmis.warehouse.model.live.Pathstatus modelToEntity (Pathstatus model ,com.servinglynk.hmis.warehouse.model.live.Pathstatus entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.live.Pathstatus();
       entity.setId(model.getPathstatusId());
       entity.setClientEnrolledInPath(model.getClientenrolledinpath());
       return entity;    
   }


   public static Pathstatus entityToModel (com.servinglynk.hmis.warehouse.model.live.Pathstatus entity) {
       Pathstatus model = new Pathstatus();
       model.setPathstatusId(entity.getId());
       model.setClientenrolledinpath(entity.getClientEnrolledInPath());
       return model;
   }


}
