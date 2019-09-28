package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
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
          entity.setClientCode(model.getCocCode());
       return entity;
   }


   public static EnrollmentCoc entityToModel (com.servinglynk.hmis.warehouse.model.v2016.EnrollmentCoc entity) {
       EnrollmentCoc model = new EnrollmentCoc();
       model.setEnrollmentCocId(entity.getId());
       model.setInformationDate(entity.getInformationDate());
       if(entity.getDataCollectionStage() !=null)
    	   model.setDataCollectionStage(Integer.parseInt(entity.getDataCollectionStage().getValue()));
         model.setCocCode(entity.getClientCode());
         if(entity.getParentId() ==null && entity.getEnrollmentid()!=null && entity.getEnrollmentid().getClient()!=null) {
      	   model.addLink(new ActionLink("history","/clients/"+entity.getEnrollmentid().getClient().getId()+"/enrollments/"+entity.getEnrollmentid().getId()+"/enrollmentcocs/"+entity.getId()+"/history"));
         }

       return model;
   }


}
