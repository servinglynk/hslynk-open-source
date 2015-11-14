/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

/**
 * @author Sandeep
 *
 */
public interface LastpermanentaddressDao extends ParentDao {

	
	   com.servinglynk.hmis.warehouse.model.live.Lastpermanentaddress createLastPermanentAddress(com.servinglynk.hmis.warehouse.model.live.Lastpermanentaddress lastPermanentAddress);
	   com.servinglynk.hmis.warehouse.model.live.Lastpermanentaddress updateLastPermanentAddress(com.servinglynk.hmis.warehouse.model.live.Lastpermanentaddress lastPermanentAddress);
	   void deleteLastPermanentAddress(com.servinglynk.hmis.warehouse.model.live.Lastpermanentaddress lastPermanentAddress);
	   com.servinglynk.hmis.warehouse.model.live.Lastpermanentaddress getLastPermanentAddressById(UUID lastPermanentAddressId);
	   List<com.servinglynk.hmis.warehouse.model.live.Lastpermanentaddress> getAllEnrollmentLastPermanentAddresss(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentLastPermanentAddresssCount(UUID enrollmentId);
	
}
