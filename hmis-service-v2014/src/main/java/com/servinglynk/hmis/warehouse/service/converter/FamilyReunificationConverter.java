package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.FamilyReunification;
import com.servinglynk.hmis.warehouse.enums.FamilyreunificationFamilyreunificationachievedEnum;
public class FamilyReunificationConverter extends BaseConverter {

	 public static com.servinglynk.hmis.warehouse.model.v2014.Familyreunification modelToEntity (FamilyReunification model ,com.servinglynk.hmis.warehouse.model.v2014.Familyreunification entity) {
	       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Familyreunification();
	       if(model.getFamilyReunificationId()!=null)
	       entity.setId(model.getFamilyReunificationId());
	       if(model.getFamilyreunificationachieved()!=null)
	       entity.setFamilyreunificationachieved(FamilyreunificationFamilyreunificationachievedEnum.lookupEnum(model.getFamilyreunificationachieved().toString()));
	       return entity;    
	   }


	   public static FamilyReunification entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Familyreunification entity) {
	       FamilyReunification model = new FamilyReunification();
	       if(entity.getId()!=null)
	       model.setFamilyReunificationId(entity.getId());
	       if(entity.getFamilyreunificationachieved()!=null)
	       model.setFamilyreunificationachieved(Integer.parseInt(entity.getFamilyreunificationachieved().getValue()));
	       copyBeanProperties(entity, model);
	       
	       if(entity.getParentId() ==null && entity.getExitid()!=null && entity.getExitid().getEnrollmentid()!=null && entity.getExitid().getEnrollmentid().getClient()!=null) {
	    	   model.addLink(new ActionLink("history","/clients/"+entity.getExitid().getEnrollmentid().getClient().getId()+"/enrollments/"+entity.getExitid().getEnrollmentid().getId()+"/exits/"+entity.getExitid().getId()+"/familyreunifications/"+entity.getId()+"/history"));
	       }
	       
	       return model;
	   }

}
