package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.LastPermanentAddress;
import com.servinglynk.hmis.warehouse.enums.LastPermAddressAddressDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.StateEnum;
public class LastPermanentAddressConverter extends BaseConveter {

   public static com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress modelToEntity (LastPermanentAddress model ,com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress();
       entity.setId(model.getLastPermanentAddressId());
       entity.setAddressDataQuality(LastPermAddressAddressDataQualityEnum.lookupEnum(String.valueOf(model.getAddressdataquality().toString())));
       entity.setCity(model.getLastpermanentcity());
       entity.setState(StateEnum.lookupEnum(model.getLastpermanentstate().toString()));
       entity.setStreet(model.getLastpermanentstreet());
       entity.setZip(model.getLastpermanentzip());
       return entity;    
   }


   public static LastPermanentAddress entityToModel (com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress entity) {
       LastPermanentAddress model = new LastPermanentAddress();
       model.setLastPermanentAddressId(entity.getId());
       model.setAddressdataquality(Integer.parseInt(entity.getAddressDataQuality().getValue()));
       model.setLastpermanentcity(entity.getCity());
       model.setLastpermanentstate(Integer.parseInt(entity.getState().getValue()));
       model.setLastpermanentstreet(entity.getStreet());
       model.setLastpermanentzip(entity.getZip());
       copyBeanProperties(entity, model);
       return model;
   }
}
