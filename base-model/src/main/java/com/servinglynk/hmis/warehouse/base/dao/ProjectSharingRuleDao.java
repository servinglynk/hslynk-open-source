package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.ProjectSharingRuleEntity;

public interface ProjectSharingRuleDao {

	ProjectSharingRuleEntity createSharingRule(ProjectSharingRuleEntity entity);

	List<UUID> getSharedClients(UUID accountId, String projectGroupCode);
	List<UUID> getSharedEnrollemnts(UUID accountId, String projectGroupCode);

	void deleteSharingRule(ProjectSharingRuleEntity entity);

	List<ProjectSharingRuleEntity> getSharingRules(Integer startIndex, Integer maxItems);
	
	
	ProjectSharingRuleEntity getBySharingRuleId(UUID sharingRuleId);

}
