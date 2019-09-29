package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.Disabilities;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
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
       if(model.getInformationDate()!=null)
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
 if(model.getTcellcountavailable()!=null)
 	   entity.setTcellcountavailable(model.getTcellcountavailable());
 if(model.getTcellcount()!=null)
 	   entity.setTcellcount(model.getTcellcount());
 if(model.getTcellcountsource()!=null)
       entity.setTcellcountsource(model.getTcellcountsource());
 if(model.getViralLoadAvailable()!=null)
       entity.setViralLoadAvailable(model.getViralLoadAvailable());
 if(model.getViralLoad()!=null)
       entity.setViralLoad(model.getViralLoad());
 if(model.getInformationDate() !=null)
	  entity.setInformationDate(model.getInformationDate());
 if(model.getDataCollectionStage() !=null)
	  entity.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(model.getDataCollectionStage().toString()));
 if(model.getViralLoadSource()!=null)
       entity.setViralLoadSource(model.getViralLoadSource());
       return entity;    
   }


   public static Disabilities entityToModel (com.servinglynk.hmis.warehouse.model.v2015.Disabilities entity) {
       Disabilities model = new Disabilities();
       model.setDisabilitiesId(entity.getId());
       if(entity.getInformationDate()!=null)
       model.setInformationDate(entity.getInformationDate());
       if(entity.getDataCollectionStage() !=null)
    	   model.setDataCollectionStage(Integer.parseInt(entity.getDataCollectionStage().getValue()));
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
if(entity.getTcellcountavailable()!=null)
       model.setTcellcountavailable(entity.getTcellcountavailable());
if(entity.getTcellcount()!=null)
       model.setTcellcount(entity.getTcellcount());
if(entity.getTcellcountsource()!=null)
       model.setTcellcountsource(entity.getTcellcountsource());
if(entity.getViralLoadAvailable()!=null)
       model.setViralLoadAvailable(entity.getViralLoadAvailable());
if(entity.getViralLoad()!=null)
       model.setViralLoad(entity.getViralLoad());
if(entity.getViralLoadSource()!=null)
       model.setViralLoadSource(entity.getViralLoadSource());

if(entity.getParentId() ==null) {
	   model.addLink(new ActionLink("history","/clients/"+entity.getEnrollmentid().getClient().getId()+"/enrollments/"+entity.getEnrollmentid().getId()+"/disabilities/"+entity.getId()+"/history"));
}
       return model;
   }


}
