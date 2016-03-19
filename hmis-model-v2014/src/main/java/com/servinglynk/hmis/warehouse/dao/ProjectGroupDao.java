package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2014.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.model.v2014.ProjectProjectGroupMapEntity;

public interface ProjectGroupDao extends ParentDao {

	com.servinglynk.hmis.warehouse.model.v2014.ProjectGroupEntity createProjectGroup(com.servinglynk.hmis.warehouse.model.v2014.ProjectGroupEntity projectGroupEntity);
	com.servinglynk.hmis.warehouse.model.v2014.ProjectGroupEntity updateProjectGroup(com.servinglynk.hmis.warehouse.model.v2014.ProjectGroupEntity projectGroupEntity);	
	void deleteProjectGroup(com.servinglynk.hmis.warehouse.model.v2014.ProjectGroupEntity projectGroupEntity);
	ProjectGroupEntity getProjectGroupById(UUID projectGroupId);
	ProjectGroupEntity getProjectGroupByGroupCode(String projectGroupCode);
	com.servinglynk.hmis.warehouse.model.v2014.ProjectProjectGroupMapEntity addProjectToProjectGroup( com.servinglynk.hmis.warehouse.model.v2014.ProjectProjectGroupMapEntity projectGroupMapEntity);
	com.servinglynk.hmis.warehouse.model.v2014.ProjectProjectGroupMapEntity deleteProjectToProjectGroup( com.servinglynk.hmis.warehouse.model.v2014.ProjectProjectGroupMapEntity projectGroupMapEntity);
	void deleteProjectGroupMap(ProjectProjectGroupMapEntity entity);
	List<com.servinglynk.hmis.warehouse.model.v2014.ProjectGroupEntity> getAllProjectGroups(Integer startIndex, Integer maxItems);
	long getProjectGroupCount();;
}