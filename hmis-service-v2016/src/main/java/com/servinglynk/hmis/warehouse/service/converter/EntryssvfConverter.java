package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.Entryssvf;
import com.servinglynk.hmis.warehouse.enums.AnnualpercentamiEnum;
import com.servinglynk.hmis.warehouse.enums.CrisisServicesUseEnum;
import com.servinglynk.hmis.warehouse.enums.EntrySSVFPercentAMIEnum;
import com.servinglynk.hmis.warehouse.enums.EvictionhistoryEnum;
import com.servinglynk.hmis.warehouse.enums.LiteralHomelessHistoryEnum;
import com.servinglynk.hmis.warehouse.enums.NoYesENum;
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
       entity.setZeroincome(NoYesENum.lookupEnum(model.getZeroincome()+""));
       if(model.getAnnualpercentami()!=null)
       entity.setAnnualpercentami(AnnualpercentamiEnum.lookupEnum(model.getAnnualpercentami()+""));
       /*private TimeToHousingLossEnum timeToHousingLoss;
	private NoYesENum zeroincome;
	private AnnualpercentamiEnum annualpercentami;
	private NoYesENum financialchange;
	private NoYesENum householdchange;
	private EvictionhistoryEnum evictionhistory;
	private NoYesENum subsidyatrisk;
	private LiteralHomelessHistoryEnum literalhomelesshistory;
	private NoYesENum disablehoh;
	private NoYesENum criminalrecord;
	private NoYesENum sexoffender;
	private NoYesENum dependendunder6;
	private NoYesENum singleparent;
	private NoYesENum hh5plus;
	private NoYesENum iraqafghanistan;
	private NoYesENum femvet;
	private Integer thresholdscore;
	private CrisisServicesUseEnum ervisits;
	private CrisisServicesUseEnum jailnights;
	private CrisisServicesUseEnum hospitalnights;
	*/
       
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
       return model;
   }


}
