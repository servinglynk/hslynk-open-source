package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface LastPermAddressDao extends ParentDao {
	   public com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress createLastPermanentAddress(com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress lastPermanentAddress);
	   public com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress updateLastPermanentAddress(com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress lastPermanentAddress);
	   public void deleteLastPermanentAddress(com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress lastPermanentAddress);
	   public com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress getLastPermanentAddressById(UUID lastPermanentAddressId);
	   public List<com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress> getAllEnrollmentLastPermanentAddresss(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   public long getEnrollmentLastPermanentAddresssCount(UUID enrollmentId);
	
}
