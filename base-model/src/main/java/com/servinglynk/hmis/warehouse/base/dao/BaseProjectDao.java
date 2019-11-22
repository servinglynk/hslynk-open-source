package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.Project;
import com.servinglynk.hmis.warehouse.model.base.ProjectSubGroupEntity;
import com.servinglynk.hmis.warehouse.model.base.ProjectUserEntity;

public interface BaseProjectDao {

	Project createProject(Project project);

	Project updateProject(Project project);

	void deleteProject(Project project);

	Project getProjectById(UUID projectId);

	List<Project> getAllProjects(String projectGroupCode, Integer startIndex, Integer maxItems);

	long getProjectCount(String projectGroupCode);
	
	void createProjectUser(ProjectUserEntity projectUserEntity);
	
	List<ProjectUserEntity> getProjectUserByProjectId(UUID projectId);
	
	void deleteProjectUser(ProjectUserEntity projectUserEntity);
	
	List<ProjectUserEntity> getProjectUserMap(UUID projectId, UUID userId);
	
	
	ProjectSubGroupEntity createDefaultProjectSubGroup(Project project);
}