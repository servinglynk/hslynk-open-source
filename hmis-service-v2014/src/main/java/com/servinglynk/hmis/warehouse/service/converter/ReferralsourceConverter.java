package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Referralsource;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
public class ReferralsourceConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Referralsource modelToEntity (Referralsource model ,com.servinglynk.hmis.warehouse.model.v2014.Referralsource entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Referralsource();
       if(model.getReferralsourceId()!=null)
       entity.setId(model.getReferralsourceId());
       if(model.getCountoutreachreferralapproaches()!=null)
       entity.setCountoutreachreferralapproaches(model.getCountoutreachreferralapproaches());
       if(model.getDataCollectionStage() !=null)
    	   entity.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(model.getDataCollectionStage().toString()));
       if(model.getInformationDate()!=null)
    	   entity.setInformationDate(model.getInformationDate());
       return entity;    
   }


   public static Referralsource entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Referralsource entity) {
       Referralsource model = new Referralsource();
       if(entity.getId()!=null)
       model.setReferralsourceId(entity.getId());
       if(entity.getCountoutreachreferralapproaches()!=null)
       model.setCountoutreachreferralapproaches(entity.getCountoutreachreferralapproaches());
       if(entity.getInformationDate()!=null)
  	       model.setInformationDate(entity.getInformationDate());
         if(entity.getDataCollectionStage() !=null)
      	   	model.setDataCollectionStage(Integer.parseInt(entity.getDataCollectionStage().getValue()));
     
       copyBeanProperties(entity, model);
       return model;
   }


}
