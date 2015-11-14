package com.servinglynk.hmis.warehouse.dao;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.live.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.model.live.ProjectProjectGroupMapEntity;

public class ProjectGroupDaoImpl extends QueryExecutorImpl implements ProjectGroupDao {

	@Override
	public ProjectGroupEntity createProjectGroup(ProjectGroupEntity projectGroupEntity) {
			insert(projectGroupEntity);
		return projectGroupEntity;
	}

	@Override
	public ProjectGroupEntity updateProjectGroup(ProjectGroupEntity projectGroupEntity) {
		update(projectGroupEntity);
		return projectGroupEntity;
	}
	
	@Override
	public void deleteProjectGroup(ProjectGroupEntity projectGroupEntity) {
		delete(projectGroupEntity);
	}
	
	
	public ProjectGroupEntity getProjectGroupById(UUID projectGroupId){
		 return  (ProjectGroupEntity) get(ProjectGroupEntity.class, projectGroupId);
	}
	
	

	@Override
	public ProjectProjectGroupMapEntity addProjectToProjectGroup(ProjectProjectGroupMapEntity projectGroupMapEntity) {
				insert(projectGroupMapEntity);
		return projectGroupMapEntity;
	}

	@Override
	public ProjectProjectGroupMapEntity deleteProjectToProjectGroup(
			ProjectProjectGroupMapEntity projectGroupMapEntity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void deleteProjectGroupMap(ProjectProjectGroupMapEntity entity){
		delete(entity);
	}

}
