package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.Disabilities;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesDisabilitytypeEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesDocumentationonfileEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesIndefiniteandimpairsEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathhowconfirmedEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathsmiinformationEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesReceivingservicesEnum;
import com.servinglynk.hmis.warehouse.enums.NoYesEnum;
import com.servinglynk.hmis.warehouse.enums.TCellOrViralLoadSourceEnum;
import com.servinglynk.hmis.warehouse.enums.ViralLoadAvailableEnum;
public class DisabilitiesConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2017.Disabilities modelToEntity (Disabilities model ,com.servinglynk.hmis.warehouse.model.v2017.Disabilities entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2017.Disabilities();
       entity.setId(model.getDisabilitiesId());
       if(model.getInformationDate()!=null)
       entity.setInformationDate(model.getInformationDate());
 if(model.getDisabilitytype()!=null)
       entity.setDisabilitytype(DisabilitiesDisabilitytypeEnum.lookupEnum(model.getDisabilitytype().toString()));
       entity.setDisabilityresponse(model.getDisabilityresponse());
 if(model.getIndefiniteandimpairs()!=null)
       entity.setIndefiniteandimpairs(DisabilitiesIndefiniteandimpairsEnum.lookupEnum(model.getIndefiniteandimpairs().toString()));
 if(model.getTcellcountavailable()!=null)
 	   entity.setTcellcountavailable(NoYesEnum.lookupEnum(model.getTcellcountavailable().toString()));
 if(model.getTcellcount()!=null)
 	   entity.setTcellcount(model.getTcellcount());
 if(model.getTcellcountsource()!=null)
       entity.setTcellcountsource(TCellOrViralLoadSourceEnum.lookupEnum(model.getTcellcountsource().toString()));
 if(model.getViralLoadAvailable()!=null)
       entity.setViralLoadAvailable(ViralLoadAvailableEnum.lookupEnum(model.getViralLoadAvailable().toString()));
 if(model.getViralLoad()!=null)
       entity.setViralLoad(model.getViralLoad());
 if(model.getInformationDate() !=null)
	  entity.setInformationDate(model.getInformationDate());
 if(model.getDataCollectionStage() !=null)
	  entity.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(model.getDataCollectionStage().toString()));
 if(model.getViralLoadSource()!=null)
       entity.setViralLoadSource(TCellOrViralLoadSourceEnum.lookupEnum(model.getViralLoadSource().toString()));
 
	if(model.getSubmissionDate()!=null) entity.setSubmissionDate(model.getSubmissionDate());
       return entity;
   }


   public static Disabilities entityToModel (com.servinglynk.hmis.warehouse.model.v2017.Disabilities entity) {
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
if(entity.getTcellcountavailable()!=null)
       model.setTcellcountavailable(Integer.parseInt(entity.getTcellcountavailable().getValue()));
if(entity.getTcellcount()!=null)
       model.setTcellcount(entity.getTcellcount());
if(entity.getTcellcountsource()!=null)
       model.setTcellcountsource(entity.getTcellcountsource().getValue());
if(entity.getViralLoadAvailable()!=null)
       model.setViralLoadAvailable(Integer.parseInt(entity.getViralLoadAvailable().getValue()));
if(entity.getViralLoad()!=null)
       model.setViralLoad(entity.getViralLoad());
if(entity.getViralLoadSource()!=null)
       model.setViralLoadSource(entity.getViralLoadSource().getValue());

if(entity.getSubmissionDate()!=null) model.setSubmissionDate(entity.getSubmissionDate());
       return model;
   }


}
