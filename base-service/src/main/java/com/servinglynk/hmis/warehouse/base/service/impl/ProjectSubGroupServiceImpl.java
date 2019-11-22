package com.servinglynk.hmis.warehouse.base.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.service.ProjectSubGroupService;
import com.servinglynk.hmis.warehouse.base.service.converter.ProjectSubGroupConverter;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.ProjectSubGroup;
import com.servinglynk.hmis.warehouse.core.model.ProjectSubGroups;
import com.servinglynk.hmis.warehouse.model.base.Project;
import com.servinglynk.hmis.warehouse.model.base.ProjectSubGroupEntity;
import com.servinglynk.hmis.warehouse.model.base.ProjectSubGroupProjectMapEntity;
import com.servinglynk.hmis.warehouse.service.exception.ResourceNotFoundException;

public class ProjectSubGroupServiceImpl extends ServiceBase implements ProjectSubGroupService {

	@Transactional
	public ProjectSubGroup createProjectSubGroup(ProjectSubGroup projectSubGroup, Account account) {
		ProjectSubGroupEntity entity = new ProjectSubGroupEntity();
		entity.setProjectSubGroupName(projectSubGroup.getProjectSubGroupName());
		entity.setDateCreated(LocalDateTime.now());
		entity.setDateUpdated(LocalDateTime.now());
		entity.setDeleted(false);
		entity.setUserDefined(true);
		entity.setProjectGroupCode(account.getProjectGroup().getProjectGroupCode());
		entity.setUser(account.getAccountId());
			daoFactory.getProjectSubGroupDao().createProjectSubGroup(entity);
		projectSubGroup.setProjectSubGroupId(entity.getId());
		return projectSubGroup;
	}

	@Transactional
	public void updateProjectSubGroup(ProjectSubGroup projectSubGroup, Account account) {
		ProjectSubGroupEntity entity = daoFactory.getProjectSubGroupDao().getProjectSubGroupById(projectSubGroup.getProjectSubGroupId());
		if(entity == null) throw new ResourceNotFoundException("Project sub group not found "+projectSubGroup.getProjectSubGroupId());
		entity.setProjectSubGroupName(projectSubGroup.getProjectSubGroupName());
		entity.setDateUpdated(LocalDateTime.now());
		entity.setDeleted(false);
		entity.setProjectGroupCode(account.getProjectGroup().getProjectGroupCode());
		entity.setUser(account.getAccountId());
			daoFactory.getProjectSubGroupDao().updateProjectSubGroup(entity);

	}

	@Transactional
	public void deleteProjectSubGroup(UUID projectSubGroupId, Account account) {
		ProjectSubGroupEntity entity = daoFactory.getProjectSubGroupDao().getProjectSubGroupById(projectSubGroupId);
		if(entity == null) throw new ResourceNotFoundException("Project sub group not found "+projectSubGroupId);
			daoFactory.getProjectSubGroupDao().deleteProjectSubGroup(entity);
	}

	@Transactional
	public ProjectSubGroup getProjectSubGroupById(UUID projectSubGroupId) {
		ProjectSubGroupEntity entity = daoFactory.getProjectSubGroupDao().getProjectSubGroupById(projectSubGroupId);
		if(entity == null) throw new ResourceNotFoundException("Project sub group not found "+projectSubGroupId);
		return ProjectSubGroupConverter.entityToModel(entity);
	}

	@Transactional
	public ProjectSubGroups getProjectSubGroups(Integer startIndex, Integer maxItems) {
		ProjectSubGroups projectSubGroups = new ProjectSubGroups();
		List<ProjectSubGroupEntity> projectSubGroupEntities = daoFactory.getProjectSubGroupDao().getUserProjectSubGroups(startIndex,maxItems);
		for(ProjectSubGroupEntity entity : projectSubGroupEntities) {
				projectSubGroups.addProjectSubGroup(ProjectSubGroupConverter.entityToModel(entity));
		}
		return projectSubGroups;
	}

	@Transactional
	public void addProjectToProjectSubGroup(UUID projectSubGroupId, UUID projectId, Account account) {
		ProjectSubGroupEntity entity = daoFactory.getProjectSubGroupDao().getProjectSubGroupById(projectSubGroupId);
		if(entity == null) throw new ResourceNotFoundException("Project sub group not found "+projectSubGroupId);
		
		Project project = daoFactory.getBaseProjectDao().getProjectById(projectId);
		if(project == null) throw new ResourceNotFoundException("Project not found "+projectId);
		
		ProjectSubGroupProjectMapEntity mapEntity = new ProjectSubGroupProjectMapEntity();
		mapEntity.setDateCreated(LocalDateTime.now());
		mapEntity.setDateUpdated(LocalDateTime.now());
		mapEntity.setDeleted(false);
		mapEntity.setProjectGroupCode(account.getProjectGroup().getProjectGroupCode());
		mapEntity.setProjectSubGroup(entity);
		mapEntity.setProjectId(project);
		mapEntity.setUser(account.getAccountId());
		daoFactory.getProjectSubGroupDao().addProjectToProjectSubGroup(mapEntity);
	}

	@Transactional
	public void deltetProjectToProjectSubGroup(UUID projectSubGroupId, UUID projectId, Account account) {
		ProjectSubGroupEntity entity = daoFactory.getProjectSubGroupDao().getProjectSubGroupById(projectSubGroupId);
		if(entity == null) throw new ResourceNotFoundException("Project sub group not found "+projectSubGroupId);
		
		Project project = daoFactory.getBaseProjectDao().getProjectById(projectId);
		if(project == null) throw new ResourceNotFoundException("Project not found "+projectId);
		
		ProjectSubGroupProjectMapEntity mapEntity = daoFactory.getProjectSubGroupDao().getToProjectSubGroupBy(projectSubGroupId,projectId);
		if(mapEntity !=null) {
			daoFactory.getProjectSubGroupDao().deleteProjectSubGroupMap(mapEntity);
		}
		

	}

}
