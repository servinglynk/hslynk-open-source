package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Disabilities;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesDisabilitytypeEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesDocumentationonfileEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesIndefiniteandimpairsEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathhowconfirmedEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathsmiinformationEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesReceivingservicesEnum;
public class DisabilitiesConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Disabilities modelToEntity (Disabilities model ,com.servinglynk.hmis.warehouse.model.v2014.Disabilities entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Disabilities();
       if(model.getDisabilitiesId()!=null)
       entity.setId(model.getDisabilitiesId());
       if(model.getDisabilityresponse()!=null)
       entity.setDisabilityresponse(model.getDisabilityresponse());
       if(model.getDisabilitytype()!=null)
       entity.setDisabilitytype(DisabilitiesDisabilitytypeEnum.lookupEnum(model.getDisabilitytype().toString()));
       if(model.getDocumentationonfile()!=null)
       entity.setDocumentationonfile(DisabilitiesDocumentationonfileEnum.lookupEnum(model.getDocumentationonfile().toString()));
       if(model.getIndefiniteandimpairs()!=null)
       entity.setIndefiniteandimpairs(DisabilitiesIndefiniteandimpairsEnum.lookupEnum(model.getIndefiniteandimpairs().toString()));
       if(model.getPathhowconfirmed()!=null)
       entity.setPathhowconfirmed(DisabilitiesPathhowconfirmedEnum.lookupEnum(model.getPathhowconfirmed().toString()));
       if(model.getReceivingservices()!=null)
       entity.setReceivingservices(DisabilitiesReceivingservicesEnum.lookupEnum(model.getReceivingservices().toString()));
       if(model.getPathsmiinformation()!=null)
       entity.setPathsmiinformation(DisabilitiesPathsmiinformationEnum.lookupEnum(model.getPathsmiinformation().toString()));
       return entity;    
   }


   public static Disabilities entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Disabilities entity) {
       Disabilities model = new Disabilities();
       if(entity.getId()!=null)
       model.setDisabilitiesId(entity.getId());
       if(entity.getDisabilityresponse()!=null)
       model.setDisabilityresponse(entity.getDisabilityresponse());
       if(entity.getDisabilitytype()!=null)
       model.setDisabilitytype(Integer.parseInt(entity.getDisabilitytype().getValue()));
       if(entity.getDocumentationonfile()!=null)
       model.setDocumentationonfile(Integer.parseInt(entity.getDocumentationonfile().getValue()));
       if(entity.getIndefiniteandimpairs()!=null)
       model.setIndefiniteandimpairs(Integer.parseInt(entity.getIndefiniteandimpairs().getValue()));
       if(entity.getPathhowconfirmed()!=null)
       model.setPathhowconfirmed(Integer.parseInt(entity.getPathhowconfirmed().getValue()));
       if(entity.getReceivingservices()!=null)
       model.setReceivingservices(Integer.parseInt(entity.getReceivingservices().getValue()));
       if(entity.getPathsmiinformation()!=null)
       model.setPathsmiinformation(Integer.parseInt(entity.getPathsmiinformation().getValue()));       
       copyBeanProperties(entity, model);
       return model;
   }


}
