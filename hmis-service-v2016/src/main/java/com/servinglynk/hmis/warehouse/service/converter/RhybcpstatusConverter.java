package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.Rhybcpstatus;
import com.servinglynk.hmis.warehouse.enums.RhybcpStatusFysbYouthEnum;
import com.servinglynk.hmis.warehouse.enums.RhybcpStatusReasonNoServicesEnum;
public class RhybcpstatusConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2016.RhybcpStatus modelToEntity (Rhybcpstatus model ,com.servinglynk.hmis.warehouse.model.v2016.RhybcpStatus entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2016.RhybcpStatus();
       entity.setId(model.getRhybcpstatusId());
       entity.setStatusDate(model.getStatusDate());
 if(model.getFysbYouth()!=null)
       entity.setFysbYouth(RhybcpStatusFysbYouthEnum.lookupEnum(model.getFysbYouth().toString()));
 if(model.getReasonNoServices()!=null)
       entity.setReasonNoServices(RhybcpStatusReasonNoServicesEnum.lookupEnum(model.getReasonNoServices().toString()));
       return entity;
   }


   public static Rhybcpstatus entityToModel (com.servinglynk.hmis.warehouse.model.v2016.RhybcpStatus entity) {
       Rhybcpstatus model = new Rhybcpstatus();
       model.setRhybcpstatusId(entity.getId());
       model.setStatusDate(entity.getStatusDate());
if(entity.getFysbYouth()!=null)
       model.setFysbYouth(Integer.parseInt(entity.getFysbYouth().getValue()));
if(entity.getReasonNoServices()!=null)
       model.setReasonNoServices(Integer.parseInt(entity.getReasonNoServices().getValue()));
if(entity.getParentId() ==null && entity.getEnrollmentid()!=null && entity.getEnrollmentid().getClient()!=null) {
	   model.addLink(new ActionLink("history","/clients/"+entity.getEnrollmentid().getClient().getId()+"/enrollments/"+entity.getEnrollmentid().getId()+"/rhybcpstatuses/"+entity.getId()+"/history"));
}
       return model;
   }


}
