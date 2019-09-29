package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.EnrollmentCoc;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
public class EnrollmentCocConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc modelToEntity (EnrollmentCoc model ,com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc();
       	  entity.setId(model.getEnrollmentCocId());
          entity.setCocCode(model.getCocCode());
          if(model.getInformationDate()!=null)
       	   entity.setInformationDate(model.getInformationDate());
          if(model.getDataCollectionStage() !=null)
       	   entity.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(model.getDataCollectionStage().toString()));
       
       return entity;    
   }


   public static EnrollmentCoc entityToModel (com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc entity) {
       EnrollmentCoc model = new EnrollmentCoc();
       model.setEnrollmentCocId(entity.getId());
       model.setCocCode(entity.getCocCode());
       model.setEnrollmentId(entity.getEnrollmentid() !=null ? entity.getEnrollmentid().getId() : null);
       model.setProjectCocId(entity.getProjectCoc() !=null? entity.getProjectCoc().getId() : null);
       model.setDateCreated(entity.getDateCreated());
       model.setDateUpdated(entity.getDateUpdated());
       if(entity.getInformationDate()!=null)
    	   model.setInformationDate(entity.getInformationDate());
       if(entity.getDataCollectionStage() !=null)
    	   model.setDataCollectionStage(Integer.parseInt(entity.getDataCollectionStage().getValue()));

       if(entity.getParentId() ==null && entity.getEnrollmentid()!=null && entity.getEnrollmentid().getClient()!=null) {
    	   model.addLink(new ActionLink("history","/clients/"+entity.getEnrollmentid().getClient().getId()+"/enrollments/"+entity.getEnrollmentid().getId()+"/enrollmentcocs/"+entity.getId()+"/history"));
       }
       return model;
   }


}
