package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.LastPermanentAddress;
import com.servinglynk.hmis.warehouse.enums.LastPermAddressAddressDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.StateEnum;
public class LastPermanentAddressConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress modelToEntity (LastPermanentAddress model ,com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress();
       entity.setId(model.getLastPermanentAddressId());
       entity.setAddressDataQuality(LastPermAddressAddressDataQualityEnum.valueOf(String.valueOf(model.getAddressdataquality())));
       entity.setCity(model.getLastpermanentcity());
       entity.setState(StateEnum.valueOf(model.getLastpermanentstate()));
       entity.setStreet(model.getLastpermanentstreet());
       entity.setZip(model.getLastpermanentzip());
       return entity;    
   }


   public static LastPermanentAddress entityToModel (com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress entity) {
       LastPermanentAddress model = new LastPermanentAddress();
       model.setLastPermanentAddressId(entity.getId());
       String addressDataQuality = entity.getAddressDataQuality().getValue();
       if(addressDataQuality != null) {
    	   try {
    		   Integer addressDataQul = Integer.parseInt(addressDataQuality);
    		   model.setAddressdataquality(addressDataQul);
    	   } catch(NumberFormatException e) {
    		   // Eat this exception as of now.
    	   } catch (NullPointerException ex) {
    		   // Eat this exception too as we don't want to blow things up if 
    		   // the address data quality is null.
    	   }
       }
       model.setLastpermanentcity(entity.getCity());
       model.setLastpermanentstate(entity.getState().name());
       model.setLastpermanentstreet(entity.getStreet());
       model.setLastpermanentzip(entity.getZip());
       return model;
   }
}
