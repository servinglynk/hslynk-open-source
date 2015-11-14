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
public interface ServicesDao extends ParentDao {

	
	   com.servinglynk.hmis.warehouse.model.live.Services createServices(com.servinglynk.hmis.warehouse.model.live.Services services);
	   com.servinglynk.hmis.warehouse.model.live.Services updateServices(com.servinglynk.hmis.warehouse.model.live.Services services);
	   void deleteServices(com.servinglynk.hmis.warehouse.model.live.Services services);
	   com.servinglynk.hmis.warehouse.model.live.Services getServicesById(UUID servicesId);
	   List<com.servinglynk.hmis.warehouse.model.live.Services> getAllEnrollmentServicess(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentServicessCount(UUID enrollmentId);
}
