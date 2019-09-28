package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.DomesticViolence;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.DomesticviolenceDomesticviolencevictimEnum;
import com.servinglynk.hmis.warehouse.enums.DomesticviolenceWhenoccurredEnum;
public class DomesticViolenceConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence modelToEntity (DomesticViolence model ,com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence();
       if(model.getDomesticViolenceId()!=null)
       entity.setId(model.getDomesticViolenceId());
       if(model.getDomesticviolencevictim()!=null)
       entity.setDomesticviolencevictim(DomesticviolenceDomesticviolencevictimEnum.lookupEnum(model.getDomesticviolencevictim().toString()));
       if(model.getWhenoccurred()!=null)
       entity.setWhenoccurred(DomesticviolenceWhenoccurredEnum.lookupEnum(model.getWhenoccurred().toString()));
       if(model.getDataCollectionStage() !=null)
    	   entity.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(model.getDataCollectionStage().toString()));
       if(model.getInformationDate()!=null)
    	   entity.setInformationDate(model.getInformationDate());
       return entity;    
   }


   public static DomesticViolence entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence entity) {
       DomesticViolence model = new DomesticViolence();
       if(entity.getId()!=null)
       model.setDomesticViolenceId(entity.getId());
       if(entity.getDomesticviolencevictim()!=null)
       model.setDomesticviolencevictim(Integer.parseInt(entity.getDomesticviolencevictim().getValue()));
       if(entity.getWhenoccurred()!=null)
       model.setWhenoccurred(Integer.parseInt(entity.getWhenoccurred().getValue()));
       if(entity.getInformationDate()!=null)
	       model.setInformationDate(entity.getInformationDate());
       if(entity.getDataCollectionStage() !=null)
    	   	model.setDataCollectionStage(Integer.parseInt(entity.getDataCollectionStage().getValue()));
      
     
       copyBeanProperties(entity, model);
       
       if(entity.getParentId() ==null) {
    	   model.addLink(new ActionLink("history","/clients/"+entity.getEnrollmentid().getClient().getId()+"/enrollments/"+entity.getEnrollmentid().getId()+"/domesticviolences/"+entity.getId()+"/history"));
       }
       
       return model;
   }


}
