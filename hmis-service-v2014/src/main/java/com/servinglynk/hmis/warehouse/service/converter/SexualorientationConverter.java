package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.Sexualorientation;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.SexualorientationSexualorientationEnum;
public class SexualorientationConverter extends BaseConverter{

   public static com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation modelToEntity (Sexualorientation model ,com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation();
       if(model.getSexualorientationId()!=null)
       entity.setId(model.getSexualorientationId());
       if(model.getSexualorientation()!=null)
       entity.setSexualorientation(SexualorientationSexualorientationEnum.lookupEnum(model.getSexualorientation().toString()));
       if(model.getDataCollectionStage() !=null)
    	   entity.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(model.getDataCollectionStage().toString()));
       if(model.getInformationDate()!=null)
    	   entity.setInformationDate(model.getInformationDate());
    	
       return entity;    
   }


   public static Sexualorientation entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation entity) {
       Sexualorientation model = new Sexualorientation();
       if(entity.getId()!=null)
       model.setSexualorientationId(entity.getId());
       if(entity.getSexualorientation()!=null)
       model.setSexualorientation(Integer.parseInt(entity.getSexualorientation().getValue()));
       if(entity.getInformationDate()!=null)
  	       model.setInformationDate(entity.getInformationDate());
         if(entity.getDataCollectionStage() !=null)
      	   	model.setDataCollectionStage(Integer.parseInt(entity.getDataCollectionStage().getValue()));
      
       copyBeanProperties(entity, model);
       
       if(entity.getParentId() ==null && entity.getEnrollmentid()!=null && entity.getEnrollmentid().getClient()!=null) {
    	   model.addLink(new ActionLink("history","/clients/"+entity.getEnrollmentid().getClient().getId()+"/enrollments/"+entity.getEnrollmentid().getId()+"/sexualorientations/"+entity.getId()+"/history"));
       }
       return model;
   }


}
