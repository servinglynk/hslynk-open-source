package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Exitpath;
import com.servinglynk.hmis.warehouse.enums.ExitPathConnectionWithSOAREnum;
public class ExitpathConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2015.Exitpath modelToEntity (Exitpath model ,com.servinglynk.hmis.warehouse.model.v2015.Exitpath entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2015.Exitpath();
       entity.setId(model.getExitpathId());
       if(model.getConnectionWithSoar()!=null)
       entity.setConnectionWithSoar(ExitPathConnectionWithSOAREnum.lookupEnum(model.getConnectionWithSoar()+""));
       return entity;    
   }


   public static Exitpath entityToModel (com.servinglynk.hmis.warehouse.model.v2015.Exitpath entity) {
       Exitpath model = new Exitpath();
       model.setExitpathId(entity.getId());
       if(entity.getConnectionWithSoar()!=null)
       model.setConnectionWithSoar(Integer.parseInt(entity.getConnectionWithSoar().getValue()));
       return model;
   }


}
