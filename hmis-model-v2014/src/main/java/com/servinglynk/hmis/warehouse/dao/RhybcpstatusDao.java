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
public interface RhybcpstatusDao extends ParentDao {
	
	   com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus createRhybcpstatus(com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus rhybcpstatus);
	   com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus updateRhybcpstatus(com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus rhybcpstatus);
	   void deleteRhybcpstatus(com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus rhybcpstatus);
	   com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus getRhybcpstatusById(UUID rhybcpstatusId);
	   List<com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus> getAllEnrollmentRhybcpstatuss(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentRhybcpstatussCount(UUID enrollmentId);
	
}
