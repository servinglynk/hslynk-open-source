package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.LastPermanentAddress;
import com.servinglynk.hmis.warehouse.core.model.LastPermanentAddresses;
public interface LastPermanentAddressService {

   LastPermanentAddress createLastPermanentAddress(LastPermanentAddress lastPermanentAddress,UUID enrollmentId,String caller);
   LastPermanentAddress updateLastPermanentAddress(LastPermanentAddress lastPermanentAddress,UUID enrollmentId,String caller);
   LastPermanentAddress deleteLastPermanentAddress(UUID lastPermanentAddressId,String caller);
   LastPermanentAddress getLastPermanentAddressById(UUID lastPermanentAddressId);
   LastPermanentAddresses getAllEnrollmentLastPermanentAddresss(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
