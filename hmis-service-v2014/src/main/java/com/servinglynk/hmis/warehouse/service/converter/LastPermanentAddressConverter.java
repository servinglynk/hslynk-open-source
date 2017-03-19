package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.LastPermanentAddress;
import com.servinglynk.hmis.warehouse.enums.LastPermAddressAddressDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.StateEnum;
public class LastPermanentAddressConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress modelToEntity (LastPermanentAddress model ,com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress();
       if(model.getLastPermanentAddressId()!=null)
       entity.setId(model.getLastPermanentAddressId());
       if(model.getAddressdataquality()!=null)
       entity.setAddressDataQuality(LastPermAddressAddressDataQualityEnum.lookupEnum(String.valueOf(model.getAddressdataquality().toString())));
       if(model.getLastpermanentcity()!=null)
       entity.setCity(model.getLastpermanentcity());
       if(model.getLastpermanentstate()!=null)
       entity.setState(StateEnum.lookupEnum(model.getLastpermanentstate().toString()));
       if(model.getLastpermanentstreet()!=null)
       entity.setStreet(model.getLastpermanentstreet());
       if(model.getLastpermanentzip()!=null)
       entity.setZip(model.getLastpermanentzip());
       return entity;    
   }


   public static LastPermanentAddress entityToModel (com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress entity) {
       LastPermanentAddress model = new LastPermanentAddress();
       if(entity.getId()!=null)
       model.setLastPermanentAddressId(entity.getId());
       if(entity.getAddressDataQuality()!=null)
       model.setAddressdataquality(Integer.parseInt(entity.getAddressDataQuality().getValue()));
       if(entity.getCity()!=null)
       model.setLastpermanentcity(entity.getCity());
       if(entity.getState()!=null)
       model.setLastpermanentstate(Integer.parseInt(entity.getState().getValue()));
       if(entity.getStreet()!=null)
       model.setLastpermanentstreet(entity.getStreet());
       if(entity.getZip()!=null)
       model.setLastpermanentzip(entity.getZip());
       copyBeanProperties(entity, model);
       return model;
   }
}
