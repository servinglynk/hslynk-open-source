package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Entryssvf;
import com.servinglynk.hmis.warehouse.enums.EntrySSVFPercentAMIEnum;
public class EntryssvfConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2015.Entryssvf modelToEntity (Entryssvf model ,com.servinglynk.hmis.warehouse.model.v2015.Entryssvf entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2015.Entryssvf();
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
       return entity;    
   }


   public static Entryssvf entityToModel (com.servinglynk.hmis.warehouse.model.v2015.Entryssvf entity) {
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
