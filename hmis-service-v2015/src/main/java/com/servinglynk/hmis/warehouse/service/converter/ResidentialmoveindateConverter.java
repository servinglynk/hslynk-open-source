package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.Residentialmoveindate;
import com.servinglynk.hmis.warehouse.enums.ResidentialmoveindateInpermanenthousingEnum;
public class ResidentialmoveindateConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2015.Residentialmoveindate modelToEntity (Residentialmoveindate model ,com.servinglynk.hmis.warehouse.model.v2015.Residentialmoveindate entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2015.Residentialmoveindate();
       entity.setId(model.getResidentialmoveindateId());
 if(model.getInpermanenthousing()!=null)
       entity.setInpermanenthousing(ResidentialmoveindateInpermanenthousingEnum.lookupEnum(model.getInpermanenthousing().toString()));
       entity.setResidentialmoveindate(model.getResidentialmoveindate());
       return entity;    
   }


   public static Residentialmoveindate entityToModel (com.servinglynk.hmis.warehouse.model.v2015.Residentialmoveindate entity) {
       Residentialmoveindate model = new Residentialmoveindate();
       model.setResidentialmoveindateId(entity.getId());
if(entity.getInpermanenthousing()!=null)
       model.setInpermanenthousing(Integer.parseInt(entity.getInpermanenthousing().getValue()));
       model.setResidentialmoveindate(entity.getResidentialmoveindate());
       if(entity.getParentId() ==null && entity.getEnrollmentid()!=null && entity.getEnrollmentid().getClient()!=null) {
    	   model.addLink(new ActionLink("history","/clients/"+entity.getEnrollmentid().getClient().getId()+"/enrollments/"+entity.getEnrollmentid().getId()+"/residentialmoveins/"+entity.getId()+"/history"));
       }
       return model;
   }


}
