package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Exitpath;
public class ExitpathConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2015.Exitpath modelToEntity (Exitpath model ,com.servinglynk.hmis.warehouse.model.v2015.Exitpath entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2015.Exitpath();
       entity.setId(model.getExitpathId());
       entity.setConnectionWithSoar(model.getConnectionWithSoar());
       return entity;    
   }


   public static Exitpath entityToModel (com.servinglynk.hmis.warehouse.model.v2015.Exitpath entity) {
       Exitpath model = new Exitpath();
       model.setExitpathId(entity.getId());
       model.setConnectionWithSoar(entity.getConnectionWithSoar());
       return model;
   }


}
