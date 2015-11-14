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
public interface HealthStatusDao extends ParentDao {

	
	   com.servinglynk.hmis.warehouse.model.live.HealthStatus createHealthStatus(com.servinglynk.hmis.warehouse.model.live.HealthStatus HealthStatus);
	   com.servinglynk.hmis.warehouse.model.live.HealthStatus updateHealthStatus(com.servinglynk.hmis.warehouse.model.live.HealthStatus HealthStatus);
	   void deleteHealthStatus(com.servinglynk.hmis.warehouse.model.live.HealthStatus HealthStatus);
	   com.servinglynk.hmis.warehouse.model.live.HealthStatus getHealthStatusById(UUID HealthStatusId);
	   List<com.servinglynk.hmis.warehouse.model.live.HealthStatus> getAllEnrollmentHealthStatuses(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentHealthStatusesCount(UUID enrollmentId);
}
