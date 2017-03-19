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

	   com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus createRhybcpstatus(com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus rhybcpstatus);
	   com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus updateRhybcpstatus(com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus rhybcpstatus);
	   void deleteRhybcpstatus(com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus rhybcpstatus);
	   com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus getRhybcpstatusById(UUID rhybcpstatusId);
	   List<com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus> getAllEnrollmentRhybcpstatuss(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentRhybcpstatussCount(UUID enrollmentId);

}
