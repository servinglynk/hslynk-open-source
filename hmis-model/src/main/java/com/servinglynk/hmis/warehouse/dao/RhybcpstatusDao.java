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
	
	   com.servinglynk.hmis.warehouse.model.live.Rhybcpstatus createRhybcpstatus(com.servinglynk.hmis.warehouse.model.live.Rhybcpstatus rhybcpstatus);
	   com.servinglynk.hmis.warehouse.model.live.Rhybcpstatus updateRhybcpstatus(com.servinglynk.hmis.warehouse.model.live.Rhybcpstatus rhybcpstatus);
	   void deleteRhybcpstatus(com.servinglynk.hmis.warehouse.model.live.Rhybcpstatus rhybcpstatus);
	   com.servinglynk.hmis.warehouse.model.live.Rhybcpstatus getRhybcpstatusById(UUID rhybcpstatusId);
	   List<com.servinglynk.hmis.warehouse.model.live.Rhybcpstatus> getAllEnrollmentRhybcpstatuss(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentRhybcpstatussCount(UUID enrollmentId);
	
}
