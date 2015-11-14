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

	   com.servinglynk.hmis.warehouse.model.live.Projectcompletionstatus createProjectCompletionStatus(com.servinglynk.hmis.warehouse.model.live.Projectcompletionstatus projectCompletionStatus);
	   com.servinglynk.hmis.warehouse.model.live.Projectcompletionstatus updateProjectCompletionStatus(com.servinglynk.hmis.warehouse.model.live.Projectcompletionstatus projectCompletionStatus);
	   void deleteProjectCompletionStatus(com.servinglynk.hmis.warehouse.model.live.Projectcompletionstatus projectCompletionStatus);
	   com.servinglynk.hmis.warehouse.model.live.Projectcompletionstatus getProjectCompletionStatusById(UUID projectCompletionStatusId);
	   List<com.servinglynk.hmis.warehouse.model.live.Projectcompletionstatus> getAllExitProjectCompletionStatuses(UUID exitId,Integer startIndex, Integer maxItems);
	   long getExitProjectCompletionStatusesCount(UUID exitId);
}
