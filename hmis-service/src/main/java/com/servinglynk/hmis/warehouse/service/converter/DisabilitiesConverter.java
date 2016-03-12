package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Disabilities;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesDisabilitytypeEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesDocumentationonfileEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesIndefiniteandimpairsEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathhowconfirmedEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathsmiinformationEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesReceivingservicesEnum;
public class DisabilitiesConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Disabilities modelToEntity (Disabilities model ,com.servinglynk.hmis.warehouse.model.v2014.Disabilities entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Disabilities();
       entity.setId(model.getDisabilitiesId());
       entity.setDisabilityresponse(model.getDisabilityresponse());
       entity.setDisabilitytype(DisabilitiesDisabilitytypeEnum.valueOf(model.getDisabilitytype()));
       entity.setDocumentationonfile(DisabilitiesDocumentationonfileEnum.valueOf(model.getDocumentationonfile()));
       entity.setIndefiniteandimpairs(DisabilitiesIndefiniteandimpairsEnum.valueOf(model.getIndefiniteandimpairs()));
       entity.setPathhowconfirmed(DisabilitiesPathhowconfirmedEnum.valueOf(model.getPathhowconfirmed()));
       entity.setReceivingservices(DisabilitiesReceivingservicesEnum.valueOf(model.getReceivingservices()));
       entity.setPathsmiinformation(DisabilitiesPathsmiinformationEnum.valueOf(model.getPathsmiinformation()));
       return entity;    
   }


   public static Disabilities entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Disabilities entity) {
       Disabilities model = new Disabilities();
       model.setDisabilitiesId(entity.getId());
       model.setDisabilityresponse(entity.getDisabilityresponse());
       model.setDisabilitytype(entity.getDisabilitytype().name());
       model.setDocumentationonfile(entity.getDocumentationonfile().name());
       model.setIndefiniteandimpairs(entity.getIndefiniteandimpairs().name());
       model.setPathhowconfirmed(entity.getPathhowconfirmed().name());
       model.setReceivingservices(entity.getReceivingservices().name());
       model.setPathsmiinformation(entity.getPathsmiinformation().name());
       return model;
   }


}
