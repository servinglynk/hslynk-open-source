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
public interface SchoolstatusDao extends ParentDao {

	   com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus createSchoolstatus(com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus schoolstatus);
	   com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus updateSchoolstatus(com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus schoolstatus);
	   void deleteSchoolstatus(com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus schoolstatus);
	   com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus getSchoolstatusById(UUID schoolstatusId);
	   List<com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus> getAllEnrollmentSchoolstatuss(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentSchoolstatussCount(UUID enrollmentId);
}
