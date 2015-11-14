package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Medicalassistance;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceAdapEnum;
public class MedicalassistanceConverter {

   public static com.servinglynk.hmis.warehouse.model.live.Medicalassistance modelToEntity (Medicalassistance model ,com.servinglynk.hmis.warehouse.model.live.Medicalassistance entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.live.Medicalassistance();
       entity.setId(model.getMedicalassistanceId());
       entity.setAdap(MedicalassistanceAdapEnum.valueOf(model.getAdap()));
       return entity;    
   }


   public static Medicalassistance entityToModel (com.servinglynk.hmis.warehouse.model.live.Medicalassistance entity) {
       Medicalassistance model = new Medicalassistance();
       model.setMedicalassistanceId(entity.getId());
       model.setAdap(entity.getAdap().name());
       return model;
   }


}
