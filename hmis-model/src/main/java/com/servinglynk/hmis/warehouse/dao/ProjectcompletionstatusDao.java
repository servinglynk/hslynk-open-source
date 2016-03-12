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
public interface ProjectcompletionstatusDao extends ParentDao {

	   com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus createProjectCompletionStatus(com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus projectCompletionStatus);
	   com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus updateProjectCompletionStatus(com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus projectCompletionStatus);
	   void deleteProjectCompletionStatus(com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus projectCompletionStatus);
	   com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus getProjectCompletionStatusById(UUID projectCompletionStatusId);
	   List<com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus> getAllExitProjectCompletionStatuses(UUID exitId,Integer startIndex, Integer maxItems);
	   long getExitProjectCompletionStatusesCount(UUID exitId);
}
