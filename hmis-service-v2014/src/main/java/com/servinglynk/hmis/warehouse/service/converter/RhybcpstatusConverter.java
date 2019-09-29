package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.Rhybcpstatus;
import com.servinglynk.hmis.warehouse.enums.RhybcpStatusFysbYouthEnum;
import com.servinglynk.hmis.warehouse.enums.RhybcpStatusReasonNoServicesEnum;
public class RhybcpstatusConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus modelToEntity (Rhybcpstatus model ,com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus();
       
       if(model.getStatusDate()!=null)
       entity.setStatusDate(model.getStatusDate());
       if(model.getFysbYouth()!=null)
    	   	entity.setFysbYouth(RhybcpStatusFysbYouthEnum.lookupEnum(model.getFysbYouth().toString()));
       if(model.getReasonNoServices()!=null)
    	   	entity.setReasonNoServices(RhybcpStatusReasonNoServicesEnum.lookupEnum(model.getReasonNoServices().toString()));
       return entity;    
   }


   public static Rhybcpstatus entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus entity) {
       Rhybcpstatus model = new Rhybcpstatus();
       if(entity.getId()!=null)
       model.setRhybcpstatusId(entity.getId());
       if(entity.getStatusDate()!=null)
       model.setStatusDate(entity.getStatusDate());
       copyBeanProperties(entity, model);
       if(entity.getParentId() ==null && entity.getEnrollmentid()!=null && entity.getEnrollmentid().getClient()!=null) {
    	   model.addLink(new ActionLink("history","/clients/"+entity.getEnrollmentid().getClient().getId()+"/enrollments/"+entity.getEnrollmentid().getId()+"/rhybcpstatuses/"+entity.getId()+"/history"));
       }
       return model;
   }


}
