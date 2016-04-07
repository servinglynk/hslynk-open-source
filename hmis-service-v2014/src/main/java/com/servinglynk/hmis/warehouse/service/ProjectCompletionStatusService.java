package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.ProjectCompletionStatus;
import com.servinglynk.hmis.warehouse.core.model.ProjectCompletionStatuses;
public interface ProjectCompletionStatusService {

   ProjectCompletionStatus createProjectCompletionStatus(ProjectCompletionStatus projectCompletionStatus,UUID exitId,String caller);
   ProjectCompletionStatus updateProjectCompletionStatus(ProjectCompletionStatus projectCompletionStatus,UUID exitId,String caller);
   ProjectCompletionStatus deleteProjectCompletionStatus(UUID projectCompletionStatusId,String caller);
   ProjectCompletionStatus getProjectCompletionStatusById(UUID projectCompletionStatusId);
   ProjectCompletionStatuses getAllExitProjectCompletionStatuss(UUID exitId,Integer startIndex, Integer maxItems);
}
