package com.servinglynk.hmis.warehouse.base.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.ProjectSharingRule;
import com.servinglynk.hmis.warehouse.core.model.ProjectSharingRules;

public interface ProjectSharingRuleService {
	
	ProjectSharingRule createSharingRule(ProjectSharingRule projectSharingRule,Account caller);

	Boolean isSharedClient(UUID clientId, UUID accountId, String projectGroupCode);

	Boolean isSharedEnrollment(UUID enrollmentId, UUID accountId, String projectGroupCode);

	void deleteSharingRule(UUID sharingruleid, Account caller);

	ProjectSharingRule getSharingRule(UUID sharingruleid);

	ProjectSharingRules getSharingRules(Integer startIndex, Integer maxItems);

}
