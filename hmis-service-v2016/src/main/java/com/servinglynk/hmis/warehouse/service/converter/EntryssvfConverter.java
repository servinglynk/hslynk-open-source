package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.Entryssvf;
import com.servinglynk.hmis.warehouse.enums.AnnualpercentamiEnum;
import com.servinglynk.hmis.warehouse.enums.CrisisServicesUseEnum;
import com.servinglynk.hmis.warehouse.enums.EntrySSVFPercentAMIEnum;
import com.servinglynk.hmis.warehouse.enums.EvictionhistoryEnum;
import com.servinglynk.hmis.warehouse.enums.LiteralHomelessHistoryEnum;
import com.servinglynk.hmis.warehouse.enums.NoYesEnum;
import com.servinglynk.hmis.warehouse.enums.TimeToHousingLossEnum;
public class EntryssvfConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2016.Entryssvf modelToEntity (Entryssvf model ,com.servinglynk.hmis.warehouse.model.v2016.Entryssvf entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2016.Entryssvf();
       if(model.getEntryssvfId()!=null)
       entity.setId(model.getEntryssvfId());
       if(model.getPercentami()!=null)
       entity.setPercentami(EntrySSVFPercentAMIEnum.lookupEnum(model.getPercentami()+""));
       if(model.getLastPermanentStreet()!=null)
       entity.setLastPermanentStreet(model.getLastPermanentStreet());
       if(model.getLastPermanentCity()!=null)
       entity.setLastPermanentCity(model.getLastPermanentCity());
       if(model.getLastPermanentState()!=null)
       entity.setLastPermanentState(model.getLastPermanentState());
       if(model.getLastPermanentZip()!=null)
       entity.setLastPermanentZip(model.getLastPermanentZip());
       if(model.getAddressDataQuality()!=null)
       entity.setAddressDataQuality(model.getAddressDataQuality());
       if(model.getHpScreenScore()!=null)
       entity.setHpScreeningScore(model.getHpScreenScore());
       if(model.getVamcStaction()!=null)
       entity.setVamcStation(model.getVamcStaction());
       if(model.getTimeToHousingLoss()!=null)
       entity.setTimeToHousingLoss(TimeToHousingLossEnum.lookupEnum(model.getTimeToHousingLoss()+""));
       if(model.getZeroincome()!=null)
       entity.setZeroincome(NoYesEnum.lookupEnum(model.getZeroincome()+""));
       if(model.getAnnualpercentami()!=null)
       entity.setAnnualpercentami(AnnualpercentamiEnum.lookupEnum(model.getAnnualpercentami()+""));
       if(model.getFinancialchange()!=null)
    	   entity.setFinancialchange(NoYesEnum.lookupEnum(model.getFinancialchange()+""));
       if(model.getHouseholdchange()!=null)
    	   entity.setHouseholdchange(NoYesEnum.lookupEnum(model.getHouseholdchange()+""));
       if(model.getEvictionhistory()!=null)
    	   entity.setEvictionhistory(EvictionhistoryEnum.lookupEnum(model.getEvictionhistory()+""));
       if(model.getSubsidyatrisk()!=null)
    	   entity.setSubsidyatrisk(NoYesEnum.lookupEnum(model.getSubsidyatrisk()+""));
       if(model.getLiteralhomelesshistory()!=null)
    	   entity.setLiteralhomelesshistory(LiteralHomelessHistoryEnum.lookupEnum(model.getLiteralhomelesshistory()+""));
       if(model.getDisablehoh()!=null)
    	   entity.setDisablehoh(NoYesEnum.lookupEnum(model.getDisablehoh()+""));
       if(model.getCriminalrecord()!=null)
    	   entity.setCriminalrecord(NoYesEnum.lookupEnum(model.getCriminalrecord()+""));
       if(model.getSexoffender()!=null)
    	   entity.setSexoffender(NoYesEnum.lookupEnum(model.getSexoffender()+""));
       if(model.getDependendunder6()!=null)
    	   entity.setDependendunder6(NoYesEnum.lookupEnum(model.getDependendunder6()+""));
       if(model.getSingleparent()!=null)
    	   entity.setSingleparent(NoYesEnum.lookupEnum(model.getSingleparent()+""));
       if(model.getHh5plus()!=null)
    	   entity.setHh5plus(NoYesEnum.lookupEnum(model.getHh5plus()+""));
       if(model.getIraqafghanistan()!=null)
    	   entity.setIraqafghanistan(NoYesEnum.lookupEnum(model.getIraqafghanistan()+""));
       if(model.getFemvet()!=null)
    	   entity.setFemvet(NoYesEnum.lookupEnum(model.getFemvet()+""));
       if(model.getThresholdscore()!=null)
    	   entity.setThresholdscore(model.getThresholdscore());
       if(model.getErvisits()!=null)
    	   entity.setErvisits(CrisisServicesUseEnum.lookupEnum(model.getErvisits()+""));
       if(model.getJailnights()!=null)
    	   entity.setJailnights(CrisisServicesUseEnum.lookupEnum(model.getJailnights()+""));
       if(model.getHospitalnights()!=null)
    	   entity.setHospitalnights(CrisisServicesUseEnum.lookupEnum(model.getHospitalnights()+""));
       
       return entity;
   }


   public static Entryssvf entityToModel (com.servinglynk.hmis.warehouse.model.v2016.Entryssvf entity) {
       Entryssvf model = new Entryssvf();
       if(entity.getId()!=null)
       model.setEntryssvfId(entity.getId());
       if(entity.getPercentami()!=null)
       model.setPercentami(Integer.parseInt(entity.getPercentami().getValue()));
       if(entity.getLastPermanentStreet()!=null)
       model.setLastPermanentStreet(entity.getLastPermanentStreet());
       if(entity.getLastPermanentCity()!=null)
       model.setLastPermanentCity(entity.getLastPermanentCity());
       if(entity.getLastPermanentState()!=null)
       model.setLastPermanentState(entity.getLastPermanentState());
       if(entity.getLastPermanentZip()!=null)
       model.setLastPermanentZip(entity.getLastPermanentZip());
       if(entity.getAddressDataQuality()!=null)
       model.setAddressDataQuality(entity.getAddressDataQuality());
       if(entity.getHpScreeningScore()!=null)
       model.setHpScreenScore(entity.getHpScreeningScore());
       if(entity.getVamcStation()!=null)
       model.setVamcStaction(entity.getVamcStation());
       if(entity.getTimeToHousingLoss()!=null)
    	   model.setTimeToHousingLoss(Integer.parseInt(entity.getTimeToHousingLoss().getValue()));
           if(entity.getZeroincome()!=null)
        	   model.setZeroincome(Integer.parseInt(entity.getZeroincome().getValue()));
           if(entity.getAnnualpercentami()!=null)
        	   model.setAnnualpercentami(Integer.parseInt(entity.getAnnualpercentami().getValue()));
           if(entity.getFinancialchange()!=null)
        	   model.setFinancialchange(Integer.parseInt(entity.getFinancialchange().getValue()));
           if(entity.getHouseholdchange()!=null)
        	   model.setHouseholdchange(Integer.parseInt(entity.getHouseholdchange().getValue()));
           if(entity.getEvictionhistory()!=null)
        	   model.setEvictionhistory(Integer.parseInt(entity.getEvictionhistory().getValue()));
           if(entity.getSubsidyatrisk()!=null)
        	   model.setSubsidyatrisk(Integer.parseInt(entity.getSubsidyatrisk().getValue()));
           if(entity.getLiteralhomelesshistory()!=null)
        	   model.setLiteralhomelesshistory(Integer.parseInt(entity.getLiteralhomelesshistory().getValue()));
           if(entity.getDisablehoh()!=null)
        	   model.setDisablehoh(Integer.parseInt(entity.getDisablehoh().getValue()));
           if(entity.getCriminalrecord()!=null)
        	   model.setCriminalrecord(Integer.parseInt(entity.getCriminalrecord().getValue()));
           if(entity.getSexoffender()!=null)
        	   model.setSexoffender(Integer.parseInt(entity.getSexoffender().getValue()));
           if(entity.getDependendunder6()!=null)
        	   model.setDependendunder6(Integer.parseInt(entity.getDependendunder6().getValue()));
           if(entity.getSingleparent()!=null)
        	   model.setSingleparent(Integer.parseInt(entity.getSingleparent().getValue()));
           if(entity.getHh5plus()!=null)
        	   model.setHh5plus(Integer.parseInt(entity.getHh5plus().getValue()));
           if(entity.getIraqafghanistan()!=null)
        	   model.setIraqafghanistan(Integer.parseInt(entity.getIraqafghanistan().getValue()));
           if(entity.getFemvet()!=null)
        	   model.setFemvet(Integer.parseInt(entity.getFemvet().getValue()));
           if(entity.getThresholdscore()!=null)
        	   model.setThresholdscore(entity.getThresholdscore());
           if(entity.getErvisits()!=null)
        	   model.setErvisits(Integer.parseInt(entity.getErvisits().getValue()));
           if(entity.getJailnights()!=null)
        	   model.setJailnights(Integer.parseInt(entity.getJailnights().getValue()));
           if(entity.getHospitalnights()!=null)
        	   model.setHospitalnights(Integer.parseInt(entity.getHospitalnights().getValue()));
           if(entity.getParentId() ==null && entity.getEnrollmentid()!=null && entity.getEnrollmentid().getClient()!=null) {
          	   model.addLink(new ActionLink("history","/clients/"+entity.getEnrollmentid().getClient().getId()+"/enrollments/"+entity.getEnrollmentid().getId()+"/entryssvfs/"+entity.getId()+"/history"));
             }
       return model;
   }


}
