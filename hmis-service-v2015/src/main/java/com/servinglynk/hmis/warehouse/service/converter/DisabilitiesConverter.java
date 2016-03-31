package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Disabilities;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesDisabilitytypeEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesDocumentationonfileEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesIndefiniteandimpairsEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathhowconfirmedEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathsmiinformationEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesReceivingservicesEnum;
public class DisabilitiesConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2015.Disabilities modelToEntity (Disabilities model ,com.servinglynk.hmis.warehouse.model.v2015.Disabilities entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2015.Disabilities();
       entity.setId(model.getDisabilitiesId());
       entity.setInformationDate(model.getInformationDate());
 if(model.getDisabilitytype()!=null)
       entity.setDisabilitytype(DisabilitiesDisabilitytypeEnum.lookupEnum(model.getDisabilitytype().toString()));
       entity.setDisabilityresponse(model.getDisabilityresponse());
 if(model.getIndefiniteandimpairs()!=null)
       entity.setIndefiniteandimpairs(DisabilitiesIndefiniteandimpairsEnum.lookupEnum(model.getIndefiniteandimpairs().toString()));
 if(model.getDocumentationonfile()!=null)
       entity.setDocumentationonfile(DisabilitiesDocumentationonfileEnum.lookupEnum(model.getDocumentationonfile().toString()));
 if(model.getReceivingservices()!=null)
       entity.setReceivingservices(DisabilitiesReceivingservicesEnum.lookupEnum(model.getReceivingservices().toString()));
 if(model.getPathhowconfirmed()!=null)
       entity.setPathhowconfirmed(DisabilitiesPathhowconfirmedEnum.lookupEnum(model.getPathhowconfirmed().toString()));
 if(model.getPathsmiinformation()!=null)
       entity.setPathsmiinformation(DisabilitiesPathsmiinformationEnum.lookupEnum(model.getPathsmiinformation().toString()));
       entity.setTcellcountavailable(model.getTcellcountavailable());
       entity.setTcellcount(model.getTcellcount());
       entity.setTcellcountsource(model.getTcellcountsource());
       entity.setViralLoadAvailable(model.getViralLoadAvailable());
       entity.setViralLoad(model.getViralLoad());
       entity.setViralLoadSource(model.getViralLoadSource());
       return entity;    
   }


   public static Disabilities entityToModel (com.servinglynk.hmis.warehouse.model.v2015.Disabilities entity) {
       Disabilities model = new Disabilities();
       model.setDisabilitiesId(entity.getId());
       model.setInformationDate(entity.getInformationDate());
if(entity.getDisabilitytype()!=null)
       model.setDisabilitytype(Integer.parseInt(entity.getDisabilitytype().getValue()));
       model.setDisabilityresponse(entity.getDisabilityresponse());
if(entity.getIndefiniteandimpairs()!=null)
       model.setIndefiniteandimpairs(Integer.parseInt(entity.getIndefiniteandimpairs().getValue()));
if(entity.getDocumentationonfile()!=null)
       model.setDocumentationonfile(Integer.parseInt(entity.getDocumentationonfile().getValue()));
if(entity.getReceivingservices()!=null)
       model.setReceivingservices(Integer.parseInt(entity.getReceivingservices().getValue()));
if(entity.getPathhowconfirmed()!=null)
       model.setPathhowconfirmed(Integer.parseInt(entity.getPathhowconfirmed().getValue()));
if(entity.getPathsmiinformation()!=null)
       model.setPathsmiinformation(Integer.parseInt(entity.getPathsmiinformation().getValue()));
       model.setTcellcountavailable(entity.getTcellcountavailable());
       model.setTcellcount(entity.getTcellcount());
       model.setTcellcountsource(entity.getTcellcountsource());
       model.setViralLoadAvailable(entity.getViralLoadAvailable());
       model.setViralLoad(entity.getViralLoad());
       model.setViralLoadSource(entity.getViralLoadSource());
       return model;
   }


}
