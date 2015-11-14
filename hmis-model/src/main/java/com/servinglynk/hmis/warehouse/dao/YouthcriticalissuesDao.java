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
public interface YouthcriticalissuesDao extends ParentDao {
	
	
	   com.servinglynk.hmis.warehouse.model.live.Youthcriticalissues createYouthCriticalIssues(com.servinglynk.hmis.warehouse.model.live.Youthcriticalissues youthCriticalIssues);
	   com.servinglynk.hmis.warehouse.model.live.Youthcriticalissues updateYouthCriticalIssues(com.servinglynk.hmis.warehouse.model.live.Youthcriticalissues youthCriticalIssues);
	   void deleteYouthCriticalIssues(com.servinglynk.hmis.warehouse.model.live.Youthcriticalissues youthCriticalIssues);
	   com.servinglynk.hmis.warehouse.model.live.Youthcriticalissues getYouthCriticalIssuesById(UUID youthCriticalIssuesId);
	   List<com.servinglynk.hmis.warehouse.model.live.Youthcriticalissues> getAllEnrollmentYouthCriticalIssuess(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentYouthCriticalIssuessCount(UUID enrollmentId);

}
