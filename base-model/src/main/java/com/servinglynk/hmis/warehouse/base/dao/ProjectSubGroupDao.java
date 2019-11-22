package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.ProjectSubGroupEntity;
import com.servinglynk.hmis.warehouse.model.base.ProjectSubGroupProjectMapEntity;

public interface ProjectSubGroupDao {

	ProjectSubGroupEntity getProjectsDefaultGroup(UUID projectId);
	ProjectSubGroupEntity getProjectSubGroupById(UUID projectSubGroupId);
	
	ProjectSubGroupEntity getToProjectsDefaultGroup(UUID projectId);
	ProjectSubGroupEntity getToProjectSubGroupById(UUID projectSubGroupId);
	
	void deleteProjectSubGroup(ProjectSubGroupEntity entity);
	ProjectSubGroupEntity createProjectSubGroup(ProjectSubGroupEntity entity);
	void updateProjectSubGroup(ProjectSubGroupEntity entity);
	List<ProjectSubGroupEntity> getUserProjectSubGroups(Integer startIndex, Integer maxItems);
	void addProjectToProjectSubGroup(ProjectSubGroupProjectMapEntity mapEntity);
	ProjectSubGroupProjectMapEntity getToProjectSubGroupBy(UUID projectSubGroupId, UUID projectId);
	void deleteProjectSubGroupMap(ProjectSubGroupProjectMapEntity mapEntity);
}
