package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.Medicalassistance;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceAdapEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceHivaidsassistanceEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceNoadapreasonEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceNohivaidsassistancereasonEnum;
public class MedicalassistanceConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2020.Medicalassistance modelToEntity (Medicalassistance model ,com.servinglynk.hmis.warehouse.model.v2020.Medicalassistance entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2020.Medicalassistance();
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
 entity.setSubmissionDate(model.getSubmissionDate());
       return entity;
   }


   public static Medicalassistance entityToModel (com.servinglynk.hmis.warehouse.model.v2020.Medicalassistance entity) {
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

if(entity.getSubmissionDate()!=null) model.setSubmissionDate(entity.getSubmissionDate());
		if(entity.getParentId() ==null && entity.getEnrollmentid()!=null && entity.getEnrollmentid().getClient()!=null) {
			   model.addLink(new ActionLink("history","/clients/"+entity.getEnrollmentid().getClient().getId()+"/enrollments/"+entity.getEnrollmentid().getId()+"/medicalassistances/"+entity.getId()+"/history"));
		}
       return model;
   }


}
