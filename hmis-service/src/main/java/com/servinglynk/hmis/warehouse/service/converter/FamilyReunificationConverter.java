package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.FamilyReunification;
import com.servinglynk.hmis.warehouse.enums.FamilyreunificationFamilyreunificationachievedEnum;
public class FamilyReunificationConverter {

	 public static com.servinglynk.hmis.warehouse.model.live.Familyreunification modelToEntity (FamilyReunification model ,com.servinglynk.hmis.warehouse.model.live.Familyreunification entity) {
	       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.live.Familyreunification();
	       entity.setId(model.getFamilyReunificationId());
	       entity.setFamilyreunificationachieved(FamilyreunificationFamilyreunificationachievedEnum.valueOf(model.getFamilyreunificationachieved()));
	       return entity;    
	   }


	   public static FamilyReunification entityToModel (com.servinglynk.hmis.warehouse.model.live.Familyreunification entity) {
	       FamilyReunification model = new FamilyReunification();
	       model.setFamilyReunificationId(entity.getId());
	       model.setFamilyreunificationachieved(entity.getFamilyreunificationachieved().name());
	       return model;
	   }

}
