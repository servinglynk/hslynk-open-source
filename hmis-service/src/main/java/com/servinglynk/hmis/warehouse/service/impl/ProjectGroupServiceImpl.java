package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.core.model.Project;
import com.servinglynk.hmis.warehouse.core.model.ProjectGroup;
import com.servinglynk.hmis.warehouse.model.live.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.model.live.ProjectProjectGroupMapEntity;
import com.servinglynk.hmis.warehouse.service.ProjectGroupService;
import com.servinglynk.hmis.warehouse.service.converter.ProjectGroupConverter;
import com.servinglynk.hmis.warehouse.service.exception.ProjectGroupNotFound;
import com.servinglynk.hmis.warehouse.service.exception.ProjectNotFoundException;

public class ProjectGroupServiceImpl extends ServiceBase implements ProjectGroupService {

	@Transactional
	public ProjectGroup createProjectGroup(ProjectGroup projectGroup, String caller){
		ProjectGroupEntity projectGroupEntity = ProjectGroupConverter.modelToEntity(projectGroup,null);
	//	projectGroupEntity.setInsertAt(new Date());
	//	projectGroupEntity.setInsertBy(caller);
		daoFactory.getProjectGroupDao().createProjectGroup(projectGroupEntity);
		
		
		for(Project project : projectGroup.getProjects()){
			ProjectProjectGroupMapEntity entity = new ProjectProjectGroupMapEntity();
			entity.setProjectGroupEntity(projectGroupEntity);
			com.servinglynk.hmis.warehouse.model.live.Project pProject = daoFactory.getProjectDao().getProjectById(project.getProjectId());
			if(pProject == null) throw new ProjectNotFoundException();
			entity.setProject(pProject);
			entity.setInsertAt(LocalDateTime.now());
			entity.setInsertBy(caller);
			daoFactory.getProjectGroupDao().addProjectToProjectGroup(entity);
		}
		
		projectGroup.setProjectGroupId(projectGroupEntity.getId());
		return projectGroup;
	}
	
	
	public ProjectGroup updateProjectGroup(UUID projectgroupid ,ProjectGroup projectGroup, String caller){
		
		ProjectGroupEntity projectGroupEntity = daoFactory.getProjectGroupDao().getProjectGroupById(projectgroupid);
		if(projectGroupEntity == null) throw new ProjectGroupNotFound();		
		ProjectGroupConverter.modelToEntity(projectGroup,projectGroupEntity);
		//projectGroupEntity.setInsertAt(new Date());
		//projectGroupEntity.setInsertBy(caller);
		daoFactory.getProjectGroupDao().updateProjectGroup(projectGroupEntity);
		
		for(ProjectProjectGroupMapEntity entity :  projectGroupEntity.getProjectGroupMapEntities()){
			daoFactory.getProjectGroupDao().deleteProjectGroupMap(entity);
		}
		
		
		for(Project project : projectGroup.getProjects()){
			ProjectProjectGroupMapEntity entity = new ProjectProjectGroupMapEntity();
			entity.setProjectGroupEntity(projectGroupEntity);
			com.servinglynk.hmis.warehouse.model.live.Project pProject = daoFactory.getProjectDao().getProjectById(project.getProjectId());
			if(pProject == null) throw new ProjectNotFoundException();
			entity.setProject(pProject);
			entity.setInsertAt(LocalDateTime.now());
			entity.setInsertBy(caller);
			daoFactory.getProjectGroupDao().addProjectToProjectGroup(entity);
		}
		
		projectGroup.setProjectGroupId(projectGroupEntity.getId());
		return projectGroup;
	}
	
	
	
	public ProjectGroup deleteProjectGroup(UUID projectGroupId){
		
		ProjectGroupEntity projectGroupEntity = daoFactory.getProjectGroupDao().getProjectGroupById(projectGroupId);
		if(projectGroupEntity == null) throw new ProjectGroupNotFound();	
		
		for(ProjectProjectGroupMapEntity entity :  projectGroupEntity.getProjectGroupMapEntities()){
			daoFactory.getProjectGroupDao().deleteProjectGroupMap(entity);
		}
		
		daoFactory.getProjectGroupDao().deleteProjectGroup(projectGroupEntity);
		
		return new ProjectGroup();
	}
	
	
	public ProjectGroup getProjectGroupById(UUID projectgroupid){
		ProjectGroup projectGroup = new ProjectGroup();
		ProjectGroupEntity projectGroupEntity = daoFactory.getProjectGroupDao().getProjectGroupById(projectgroupid);
		if(projectGroupEntity == null) throw new ProjectGroupNotFound();	
		projectGroup = ProjectGroupConverter.entityToModel(projectGroupEntity);
		
		return projectGroup;
	}
}
