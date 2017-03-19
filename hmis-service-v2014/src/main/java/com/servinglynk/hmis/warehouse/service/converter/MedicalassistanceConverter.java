package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Medicalassistance;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceAdapEnum;
public class MedicalassistanceConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance modelToEntity (Medicalassistance model ,com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance();
       if(model.getMedicalassistanceId()!=null)
       entity.setId(model.getMedicalassistanceId());
       if(model.getAdap()!=null)
       entity.setAdap(MedicalassistanceAdapEnum.lookupEnum(model.getAdap().toString()));
       if(model.getDataCollectionStage() !=null)
    	   entity.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(model.getDataCollectionStage().toString()));
       if(model.getInformationDate()!=null)
    	   entity.setInformationDate(model.getInformationDate());
       return entity;    
   }


   public static Medicalassistance entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance entity) {
       Medicalassistance model = new Medicalassistance();
       if(entity.getId()!=null)
       model.setMedicalassistanceId(entity.getId());
       if(entity.getAdap()!=null)
       model.setAdap(Integer.parseInt(entity.getAdap().getValue()));
       if(entity.getInformationDate()!=null)
  	       model.setInformationDate(entity.getInformationDate());
         if(entity.getDataCollectionStage() !=null)
      	   	model.setDataCollectionStage(Integer.parseInt(entity.getDataCollectionStage().getValue()));
    
       copyBeanProperties(entity, model);
       return model;
   }


}
