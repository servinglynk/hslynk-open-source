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

	   com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits createNoncashbenefits(com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits noncashbenefits);
	   com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits updateNoncashbenefits(com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits noncashbenefits);
	   void deleteNoncashbenefits(com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits noncashbenefits);
	   com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits getNoncashbenefitsById(UUID noncashbenefitsId);
	   List<com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits> getAllEnrollmentNoncashbenefits(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentNoncashbenefitsCount(UUID enrollmentId);
}
