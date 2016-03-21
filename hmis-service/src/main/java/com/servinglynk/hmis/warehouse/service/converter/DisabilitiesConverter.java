package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Disabilities;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesDisabilitytypeEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesDocumentationonfileEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesIndefiniteandimpairsEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathhowconfirmedEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathsmiinformationEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesReceivingservicesEnum;
public class DisabilitiesConverter extends BaseConveter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Disabilities modelToEntity (Disabilities model ,com.servinglynk.hmis.warehouse.model.v2014.Disabilities entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Disabilities();
       entity.setId(model.getDisabilitiesId());
       entity.setDisabilityresponse(model.getDisabilityresponse());
       if(model.getDisabilitytype()!=null)
       entity.setDisabilitytype(DisabilitiesDisabilitytypeEnum.lookupEnum(model.getDisabilitytype().toString()));
       entity.setDocumentationonfile(DisabilitiesDocumentationonfileEnum.lookupEnum(model.getDocumentationonfile().toString()));
       entity.setIndefiniteandimpairs(DisabilitiesIndefiniteandimpairsEnum.lookupEnum(model.getIndefiniteandimpairs().toString()));
       entity.setPathhowconfirmed(DisabilitiesPathhowconfirmedEnum.lookupEnum(model.getPathhowconfirmed().toString()));
       entity.setReceivingservices(DisabilitiesReceivingservicesEnum.lookupEnum(model.getReceivingservices().toString()));
       entity.setPathsmiinformation(DisabilitiesPathsmiinformationEnum.lookupEnum(model.getPathsmiinformation().toString()));
       return entity;    
   }


   public static Disabilities entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Disabilities entity) {
       Disabilities model = new Disabilities();
       model.setDisabilitiesId(entity.getId());
       model.setDisabilityresponse(entity.getDisabilityresponse());
       if(entity.getDisabilitytype()!=null)
       model.setDisabilitytype(Integer.parseInt(entity.getDisabilitytype().getValue()));
       model.setDocumentationonfile(Integer.parseInt(entity.getDocumentationonfile().getValue()));
       model.setIndefiniteandimpairs(Integer.parseInt(entity.getIndefiniteandimpairs().getValue()));
       model.setPathhowconfirmed(Integer.parseInt(entity.getPathhowconfirmed().getValue()));
       model.setReceivingservices(Integer.parseInt(entity.getReceivingservices().getValue()));
       model.setPathsmiinformation(Integer.parseInt(entity.getPathsmiinformation().getValue()));
       copyBeanProperties(entity, model);
       return model;
   }


}
