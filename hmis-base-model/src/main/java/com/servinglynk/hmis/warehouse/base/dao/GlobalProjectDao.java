package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.GlobalProjectEntity;
import com.servinglynk.hmis.warehouse.model.base.GlobalProjectMapEntity;
import com.servinglynk.hmis.warehouse.model.base.GlobalProjectUserEnity;

public interface GlobalProjectDao {
	
	GlobalProjectEntity create(GlobalProjectEntity entity);
	void updateGlobalProject(GlobalProjectEntity entity);
	GlobalProjectEntity getById(UUID id);
	List<GlobalProjectEntity> getAllGlobalProjects(Integer start,Integer maxItems);
	Long getAllGlobalProjectsCount();
	GlobalProjectMapEntity getGlobalProjectMapEntity(UUID globalProjectId,UUID projectId);
	void addProjectToGlobalProject(GlobalProjectMapEntity entity);
	void removeProjectToGlobalProject(GlobalProjectMapEntity entity);
	List<GlobalProjectMapEntity> getGlobalProjectMappings(UUID globalProjectId);
	
	GlobalProjectUserEnity addUserToGlobalProject(GlobalProjectUserEnity enity);
	void removeUserToGlobalProject(GlobalProjectUserEnity enity);
	GlobalProjectUserEnity getGlobalProjectUserMap(UUID globalProjectId,UUID userId);
	List<GlobalProjectUserEnity> getGlobalProjecUsertMappings(UUID globalProjectId);
	Boolean checkGlobalProjectUser(List<UUID> projectids, UUID accountId);
}