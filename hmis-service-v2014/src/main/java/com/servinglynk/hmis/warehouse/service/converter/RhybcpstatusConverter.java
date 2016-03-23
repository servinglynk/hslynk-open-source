package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Rhybcpstatus;
public class RhybcpstatusConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus modelToEntity (Rhybcpstatus model ,com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus();
       if(model.getRhybcpstatusId()!=null)
       entity.setId(model.getRhybcpstatusId());
       if(model.getStatusDate()!=null)
       entity.setStatusDate(model.getStatusDate());
       return entity;    
   }


   public static Rhybcpstatus entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus entity) {
       Rhybcpstatus model = new Rhybcpstatus();
       if(entity.getId()!=null)
       model.setRhybcpstatusId(entity.getId());
       if(entity.getStatusDate()!=null)
       model.setStatusDate(entity.getStatusDate());
       copyBeanProperties(entity, model);
       return model;
   }


}
