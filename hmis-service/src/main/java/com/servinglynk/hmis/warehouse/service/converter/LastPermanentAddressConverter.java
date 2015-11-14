package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.LastPermanentAddress;
import com.servinglynk.hmis.warehouse.enums.StateEnum;
public class LastPermanentAddressConverter {

   public static com.servinglynk.hmis.warehouse.model.live.Lastpermanentaddress modelToEntity (LastPermanentAddress model ,com.servinglynk.hmis.warehouse.model.live.Lastpermanentaddress entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.live.Lastpermanentaddress();
       entity.setId(model.getLastPermanentAddressId());
       entity.setAddressdataquality(model.getAddressdataquality());
       entity.setLastpermanentcity(model.getLastpermanentcity());
       entity.setLastpermanentstate(StateEnum.valueOf(model.getLastpermanentstate()));
       entity.setLastpermanentstreet(model.getLastpermanentstreet());
       entity.setLastpermanentzip(model.getLastpermanentzip());
       return entity;    
   }


   public static LastPermanentAddress entityToModel (com.servinglynk.hmis.warehouse.model.live.Lastpermanentaddress entity) {
       LastPermanentAddress model = new LastPermanentAddress();
       model.setLastPermanentAddressId(entity.getId());
       model.setAddressdataquality(entity.getAddressdataquality());
       model.setLastpermanentcity(entity.getLastpermanentcity());
       model.setLastpermanentstate(entity.getLastpermanentstate().name());
       model.setLastpermanentstreet(entity.getLastpermanentstreet());
       model.setLastpermanentzip(entity.getLastpermanentzip());
       return model;
   }


}
