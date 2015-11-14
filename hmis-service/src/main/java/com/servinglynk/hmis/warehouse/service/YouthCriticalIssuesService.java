package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.YouthCriticalIssue;
import com.servinglynk.hmis.warehouse.core.model.YouthCriticalIssues;

public interface YouthCriticalIssuesService {

	   YouthCriticalIssue createYouthCriticalIssues(YouthCriticalIssue youthCriticalIssues,UUID enrollmentId,String caller);
	   YouthCriticalIssue updateYouthCriticalIssues(YouthCriticalIssue youthCriticalIssues,UUID enrollmentId,String caller);
	   YouthCriticalIssue deleteYouthCriticalIssues(UUID youthCriticalIssuesId,String caller);
	   YouthCriticalIssue getYouthCriticalIssuesById(UUID youthCriticalIssuesId);
	   YouthCriticalIssues getAllEnrollmentYouthCriticalIssuess(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
