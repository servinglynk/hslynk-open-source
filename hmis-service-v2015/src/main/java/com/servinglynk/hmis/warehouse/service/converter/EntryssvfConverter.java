package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Entryssvf;
public class EntryssvfConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2015.Entryssvf modelToEntity (Entryssvf model ,com.servinglynk.hmis.warehouse.model.v2015.Entryssvf entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2015.Entryssvf();
       entity.setId(model.getEntryssvfId());
       entity.setPercentami(model.getPercentami());
       entity.setLastPermanentStreet(model.getLastPermanentStreet());
       entity.setLastPermanentCity(model.getLastPermanentCity());
       entity.setLastPermanentState(model.getLastPermanentState());
       entity.setLastPermanentZip(model.getLastPermanentZip());
       entity.setAddressDataQuality(model.getAddressDataQuality());
       entity.setHpScreeningScore(model.getHpScreenScore());
       entity.setVamcStation(model.getVamcStaction());
       return entity;    
   }


   public static Entryssvf entityToModel (com.servinglynk.hmis.warehouse.model.v2015.Entryssvf entity) {
       Entryssvf model = new Entryssvf();
       model.setEntryssvfId(entity.getId());
       model.setPercentami(entity.getPercentami());
       model.setLastPermanentStreet(entity.getLastPermanentStreet());
       model.setLastPermanentCity(entity.getLastPermanentCity());
       model.setLastPermanentState(entity.getLastPermanentState());
       model.setLastPermanentZip(entity.getLastPermanentZip());
       model.setAddressDataQuality(entity.getAddressDataQuality());
       model.setHpScreenScore(entity.getHpScreeningScore());
       model.setVamcStaction(entity.getVamcStation());
       return model;
   }


}
