package com.servinglynk.hmis.warehouse.dao;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.live.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.model.live.ProjectProjectGroupMapEntity;

public interface ProjectGroupDao {

	com.servinglynk.hmis.warehouse.model.live.ProjectGroupEntity createProjectGroup(com.servinglynk.hmis.warehouse.model.live.ProjectGroupEntity projectGroupEntity);
	com.servinglynk.hmis.warehouse.model.live.ProjectGroupEntity updateProjectGroup(com.servinglynk.hmis.warehouse.model.live.ProjectGroupEntity projectGroupEntity);	
	void deleteProjectGroup(com.servinglynk.hmis.warehouse.model.live.ProjectGroupEntity projectGroupEntity);
	ProjectGroupEntity getProjectGroupById(UUID projectGroupId);
	
	com.servinglynk.hmis.warehouse.model.live.ProjectProjectGroupMapEntity addProjectToProjectGroup( com.servinglynk.hmis.warehouse.model.live.ProjectProjectGroupMapEntity projectGroupMapEntity);
	com.servinglynk.hmis.warehouse.model.live.ProjectProjectGroupMapEntity deleteProjectToProjectGroup( com.servinglynk.hmis.warehouse.model.live.ProjectProjectGroupMapEntity projectGroupMapEntity);
	void deleteProjectGroupMap(ProjectProjectGroupMapEntity entity);
	long getProjectGroupCount();;
}