package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.Medicalassistance;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceAdapEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceHivaidsassistanceEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceNoadapreasonEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceNohivaidsassistancereasonEnum;
public class MedicalassistanceConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2017.Medicalassistance modelToEntity (Medicalassistance model ,com.servinglynk.hmis.warehouse.model.v2017.Medicalassistance entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2017.Medicalassistance();
       entity.setId(model.getMedicalassistanceId());
       if(model.getDataCollectionStage() !=null)
    	   	entity.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(model.getDataCollectionStage().toString()));

    	    if(model.getInformationDate()!=null)
    	       entity.setInformationDate(model.getInformationDate());
 if(model.getHivaidsassistance()!=null)
       entity.setHivaidsassistance(MedicalassistanceHivaidsassistanceEnum.lookupEnum(model.getHivaidsassistance().toString()));
 if(model.getNohivaidsassistancereason()!=null)
       entity.setNohivaidsassistancereason(MedicalassistanceNohivaidsassistancereasonEnum.lookupEnum(model.getNohivaidsassistancereason().toString()));
 if(model.getAdap()!=null)
       entity.setAdap(MedicalassistanceAdapEnum.lookupEnum(model.getAdap().toString()));
 if(model.getNoadapreason()!=null)
       entity.setNoadapreason(MedicalassistanceNoadapreasonEnum.lookupEnum(model.getNoadapreason().toString()));
       return entity;
   }


   public static Medicalassistance entityToModel (com.servinglynk.hmis.warehouse.model.v2017.Medicalassistance entity) {
       Medicalassistance model = new Medicalassistance();
       model.setMedicalassistanceId(entity.getId());
       if(entity.getInformationDate()!=null)
           model.setInformationDate(entity.getInformationDate());
        if(entity.getDataCollectionStage() !=null)
            model.setDataCollectionStage(Integer.parseInt(entity.getDataCollectionStage().getValue()));

if(entity.getHivaidsassistance()!=null)
       model.setHivaidsassistance(Integer.parseInt(entity.getHivaidsassistance().getValue()));
if(entity.getNohivaidsassistancereason()!=null)
       model.setNohivaidsassistancereason(Integer.parseInt(entity.getNohivaidsassistancereason().getValue()));
if(entity.getAdap()!=null)
       model.setAdap(Integer.parseInt(entity.getAdap().getValue()));
if(entity.getNoadapreason()!=null)
       model.setNoadapreason(Integer.parseInt(entity.getNoadapreason().getValue()));
       return model;
   }


}
