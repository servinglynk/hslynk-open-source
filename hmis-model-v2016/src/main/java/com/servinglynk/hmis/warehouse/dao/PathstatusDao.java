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
public interface PathstatusDao extends ParentDao {

	   com.servinglynk.hmis.warehouse.model.v2016.Pathstatus createPathstatus(com.servinglynk.hmis.warehouse.model.v2016.Pathstatus pathstatus);
	   com.servinglynk.hmis.warehouse.model.v2016.Pathstatus updatePathstatus(com.servinglynk.hmis.warehouse.model.v2016.Pathstatus pathstatus);
	   void deletePathstatus(com.servinglynk.hmis.warehouse.model.v2016.Pathstatus pathstatus);
	   com.servinglynk.hmis.warehouse.model.v2016.Pathstatus getPathstatusById(UUID pathstatusId);
	   List<com.servinglynk.hmis.warehouse.model.v2016.Pathstatus> getAllEnrollmentPathstatuss(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentPathstatussCount(UUID enrollmentId);
}
