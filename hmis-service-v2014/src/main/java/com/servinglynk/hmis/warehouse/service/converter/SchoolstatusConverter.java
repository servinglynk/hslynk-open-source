package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.Schoolstatus;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
public class SchoolstatusConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus modelToEntity (Schoolstatus model ,com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus();
       if(model.getSchoolstatusId()!=null)
       entity.setId(model.getSchoolstatusId());
       if(model.getInformationDate()!=null)
       entity.setInformationDate(model.getInformationDate());
       if(model.getDataCollectionStage() !=null)
    	   entity.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(model.getDataCollectionStage().toString()));

       return entity;    
   }


   public static Schoolstatus entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus entity) {
       Schoolstatus model = new Schoolstatus();
       if(entity.getId()!=null)
       model.setSchoolstatusId(entity.getId());
       if(entity.getInformationDate()!=null)
	       model.setInformationDate(entity.getInformationDate());
       if(entity.getDataCollectionStage() !=null)
    	   	model.setDataCollectionStage(Integer.parseInt(entity.getDataCollectionStage().getValue()));
      
     
       copyBeanProperties(entity, model);
       
       if(entity.getParentId() ==null && entity.getEnrollmentid()!=null && entity.getEnrollmentid().getClient()!=null) {
    	   model.addLink(new ActionLink("history","/clients/"+entity.getEnrollmentid().getClient().getId()+"/enrollments/"+entity.getEnrollmentid().getId()+"/schoolstatuses/"+entity.getId()+"/history"));
       }
       return model;
   }


}
