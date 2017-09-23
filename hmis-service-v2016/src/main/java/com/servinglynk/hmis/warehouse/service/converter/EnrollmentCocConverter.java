package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.EnrollmentCoc;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
public class EnrollmentCocConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2016.EnrollmentCoc modelToEntity (EnrollmentCoc model ,com.servinglynk.hmis.warehouse.model.v2016.EnrollmentCoc entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2016.EnrollmentCoc();
       entity.setId(model.getEnrollmentCocId());
       if(model.getDataCollectionStage() !=null)
   	   	entity.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(model.getDataCollectionStage().toString()));
   	   if(model.getInformationDate()!=null)
   	      entity.setInformationDate(model.getInformationDate());
          entity.setClientCode(model.getClientCode());
       return entity;
   }


   public static EnrollmentCoc entityToModel (com.servinglynk.hmis.warehouse.model.v2016.EnrollmentCoc entity) {
       EnrollmentCoc model = new EnrollmentCoc();
       model.setEnrollmentCocId(entity.getId());
       model.setInformationDate(entity.getInformationDate());
       if(entity.getDataCollectionStage() !=null)
    	   model.setDataCollectionStage(Integer.parseInt(entity.getDataCollectionStage().getValue()));
         model.setClientCode(entity.getClientCode());


       return model;
   }


}
