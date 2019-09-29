package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.Pathstatus;
import com.servinglynk.hmis.warehouse.enums.PathstatusReasonnotenrolledEnum;
public class PathstatusConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2016.Pathstatus modelToEntity (Pathstatus model ,com.servinglynk.hmis.warehouse.model.v2016.Pathstatus entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2016.Pathstatus();
       if(model.getPathstatusId()!=null)
       entity.setId(model.getPathstatusId());
       if(model.getDateOfStatus()!=null)
       entity.setDateOfStatus(model.getDateOfStatus());
       if(model.getClientEnrolledInPath()!=null)
       entity.setClientEnrolledInPath(model.getClientEnrolledInPath());
 if(model.getReasonNotEnrolled()!=null)
       entity.setReasonNotEnrolled(PathstatusReasonnotenrolledEnum.lookupEnum(model.getReasonNotEnrolled().toString()));
       return entity;
   }


   public static Pathstatus entityToModel (com.servinglynk.hmis.warehouse.model.v2016.Pathstatus entity) {
       Pathstatus model = new Pathstatus();
       model.setPathstatusId(entity.getId());
       model.setDateOfStatus(entity.getDateOfStatus());
       if(entity.getClientEnrolledInPath()!=null)
       model.setClientEnrolledInPath(entity.getClientEnrolledInPath());
if(entity.getReasonNotEnrolled()!=null)
       model.setReasonNotEnrolled(Integer.parseInt(entity.getReasonNotEnrolled().getValue()));
if(entity.getParentId() ==null && entity.getEnrollmentid()!=null && entity.getEnrollmentid().getClient()!=null) {
	   model.addLink(new ActionLink("history","/clients/"+entity.getEnrollmentid().getClient().getId()+"/enrollments/"+entity.getEnrollmentid().getId()+"/pathstatuses/"+entity.getId()+"/history"));
}
       return model;
   }


}
