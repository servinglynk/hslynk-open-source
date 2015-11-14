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
public interface NoncashbenefitsDao extends ParentDao {

	   com.servinglynk.hmis.warehouse.model.live.Noncashbenefits createNoncashbenefits(com.servinglynk.hmis.warehouse.model.live.Noncashbenefits noncashbenefits);
	   com.servinglynk.hmis.warehouse.model.live.Noncashbenefits updateNoncashbenefits(com.servinglynk.hmis.warehouse.model.live.Noncashbenefits noncashbenefits);
	   void deleteNoncashbenefits(com.servinglynk.hmis.warehouse.model.live.Noncashbenefits noncashbenefits);
	   com.servinglynk.hmis.warehouse.model.live.Noncashbenefits getNoncashbenefitsById(UUID noncashbenefitsId);
	   List<com.servinglynk.hmis.warehouse.model.live.Noncashbenefits> getAllEnrollmentNoncashbenefits(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentNoncashbenefitsCount(UUID enrollmentId);
}
