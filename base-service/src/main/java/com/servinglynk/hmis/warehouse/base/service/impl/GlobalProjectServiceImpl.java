package com.servinglynk.hmis.warehouse.base.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.base.service.GlobalProjectService;
import com.servinglynk.hmis.warehouse.base.service.converter.GlobalProjectConveter;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.BaseProject;
import com.servinglynk.hmis.warehouse.core.model.GlobalProject;
import com.servinglynk.hmis.warehouse.core.model.GlobalProjectMap;
import com.servinglynk.hmis.warehouse.core.model.GlobalProjectUser;
import com.servinglynk.hmis.warehouse.core.model.GlobalProjectUsers;
import com.servinglynk.hmis.warehouse.core.model.GlobalProjects;
import com.servinglynk.hmis.warehouse.core.model.GlobalProjectsMap;
import com.servinglynk.hmis.warehouse.model.base.GlobalProjectEntity;
import com.servinglynk.hmis.warehouse.model.base.GlobalProjectMapEntity;
import com.servinglynk.hmis.warehouse.model.base.GlobalProjectUserEnity;
import com.servinglynk.hmis.warehouse.model.base.HmisUser;
import com.servinglynk.hmis.warehouse.service.exception.ResourceNotFoundException;

public class GlobalProjectServiceImpl extends ServiceBase implements GlobalProjectService {

	@Transactional
	public GlobalProject create(GlobalProject model,Account account) {
		GlobalProjectEntity entity = GlobalProjectConveter.modelToEntity(model, null);
		entity.setDateCreated(LocalDateTime.now());
		entity.setDateUpdated(LocalDateTime.now());
		entity.setUser(account.getAccountId());
		entity.setProjectGroupCode(account.getProjectGroup().getProjectGroupCode());
		daoFactory.getGlobalProjectDao().create(entity);
		if(model.getProjects()!=null)
				this.addProjectsToGlobalProject(entity.getId(), model.getProjects(), account);
		model.setId(entity.getId());
		return model;
	}

	@Transactional
	public void update(GlobalProject model,Account account) {
		GlobalProjectEntity entity = daoFactory.getGlobalProjectDao().getById(model.getId());
		if(entity==null) throw new ResourceNotFoundException("Global project not found");
		GlobalProjectConveter.modelToEntity(model, entity);
		entity.setDateUpdated(LocalDateTime.now());
		entity.setUser(account.getAccountId());
		daoFactory.getGlobalProjectDao().updateGlobalProject(entity);
	}

	@Transactional
	public GlobalProject getById(UUID id) {
		GlobalProjectEntity entity = daoFactory.getGlobalProjectDao().getById(id);
		if(entity==null) throw new ResourceNotFoundException("Global project not found");
		GlobalProject model = GlobalProjectConveter.entityToModel(entity);
		List<GlobalProjectMapEntity> mappings = daoFactory.getGlobalProjectDao().getGlobalProjectMappings(entity.getId());
		for(GlobalProjectMapEntity map :mappings) {
			model.addProject(GlobalProjectConveter.enityToModel(map));
		}
		return model;
	}

	@Transactional
	public GlobalProjects getAllGlobalProjects(Integer start, Integer maxItems) {
		GlobalProjects projects = new GlobalProjects();
		
		List<GlobalProjectEntity> entities = daoFactory.getGlobalProjectDao().getAllGlobalProjects(start, maxItems);
		for(GlobalProjectEntity entity : entities) {
			GlobalProject model = GlobalProjectConveter.entityToModel(entity);
			List<GlobalProjectMapEntity> mappings = daoFactory.getGlobalProjectDao().getGlobalProjectMappings(entity.getId());
			for(GlobalProjectMapEntity map :mappings) {
				model.addProject(GlobalProjectConveter.enityToModel(map));
			}
			projects.addGlobalProject(model);
		}
		
		Long count = daoFactory.getGlobalProjectDao().getAllGlobalProjectsCount();
		SortedPagination pagination = new SortedPagination();
		pagination.setFrom(start);
		pagination.setReturned(entities.size());
		pagination.setTotal(count.intValue());
		projects.setPagination(pagination);	

		return projects;
	}

	@Transactional
	public void addProjectsToGlobalProject(UUID globalProjectId, GlobalProjectsMap globalProjectsMap, Account account) {
		GlobalProjectEntity entity = daoFactory.getGlobalProjectDao().getById(globalProjectId);
		if(entity==null) throw new ResourceNotFoundException("Global project not found");
		daoFactory.getGlobalProjectDao().removeAllProjects(globalProjectId);
		List<UUID> projectIds = new ArrayList<UUID>();
		for(GlobalProjectMap project : globalProjectsMap.getGlobalProjectMaps()) {
			if(!projectIds.contains(project.getProjectId())) {
				projectIds.add(project.getProjectId());
				GlobalProjectMapEntity mapEntity = GlobalProjectConveter.modelToEntity(project, null);
				mapEntity.setDateCreated(LocalDateTime.now());
				mapEntity.setDateUpdated(LocalDateTime.now());
				mapEntity.setProjectGroupCode(account.getProjectGroup().getProjectGroupCode());
				mapEntity.setUser(account.getAccountId());
				mapEntity.setGlobalProject(entity);
				daoFactory.getGlobalProjectDao().addProjectToGlobalProject(mapEntity);
			}
		}
		
	}

	@Transactional
	public void removeProjectsFromGlobalProject(UUID globalProjectId, UUID projectId) {
		GlobalProjectMapEntity project = daoFactory.getGlobalProjectDao().getGlobalProjectMapEntity(globalProjectId, projectId);
		if(project==null) throw new ResourceNotFoundException("Project not assiciated with global project");
		daoFactory.getGlobalProjectDao().removeProjectToGlobalProject(project);
	}	
	
	@Transactional
	public void addUsersToGlobalProject(UUID globalProjectId,GlobalProjectUsers users,Account account) {
		GlobalProjectEntity entity = daoFactory.getGlobalProjectDao().getById(globalProjectId);
		if(entity==null) throw new ResourceNotFoundException("Global project not found");
		List<GlobalProjectUserEnity> projUsers = new ArrayList<>();
		List<UUID> userIds = new ArrayList<UUID>();
		for(GlobalProjectUser user : users.getGlobalProjectUsers()) {
			GlobalProjectUserEnity userEnity = new GlobalProjectUserEnity();
			if(!userIds.contains(user.getUserId())) {
				userIds.add(user.getUserId());
				HmisUser hmisUser = daoFactory.getAccountDao().findByUserId(user.getUserId());
				if(hmisUser==null) throw new ResourceNotFoundException("User not found");
				userEnity.setGlobalProject(entity);
				userEnity.setHmisUser(hmisUser);
				userEnity.setUser(account.getAccountId());
				userEnity.setProjectGroupCode(account.getProjectGroup().getProjectGroupCode());
				userEnity.setDateCreated(LocalDateTime.now());
				userEnity.setDateUpdated(LocalDateTime.now());
				projUsers.add(userEnity);
			}
		}
		daoFactory.getGlobalProjectDao().removeAllProjectUsers(globalProjectId);
		for(GlobalProjectUserEnity user : projUsers) {
			daoFactory.getGlobalProjectDao().addUserToGlobalProject(user);
		}
	}
	
	@Transactional
	public void removeUserToGlobalProject(UUID globalProjectId,UUID userId) {
		GlobalProjectUserEnity projectUserEntity = daoFactory.getGlobalProjectDao().getGlobalProjectUserMap(globalProjectId, userId);
		if(projectUserEntity==null) throw new ResourceNotFoundException("User not assiciated with global project");
		daoFactory.getGlobalProjectDao().removeUserToGlobalProject(projectUserEntity);
	}
	
	@Transactional
	public GlobalProjectUsers getGlobalProjectUsers(UUID globalProjectId) {
		GlobalProjectUsers users = new GlobalProjectUsers();
		GlobalProjectEntity entity = daoFactory.getGlobalProjectDao().getById(globalProjectId);
		if(entity==null) throw new ResourceNotFoundException("Global project not found");
		List<GlobalProjectUserEnity> enities =	daoFactory.getGlobalProjectDao().getGlobalProjecUsertMappings(globalProjectId);
		for(GlobalProjectUserEnity userEnity : enities) {
			/*GlobalProjectUser user = new GlobalProjectUser();
			user.setUserId(userEnity.getHmisUser().getId());*/
			users.addGlobalProjectUser(GlobalProjectConveter.entityToModel(userEnity.getHmisUser()));
		}
		
		return users;
	}

	@Transactional
	public Boolean checkGlobalProjectUser(List<UUID> projectids, UUID accountId) {
		return	daoFactory.getGlobalProjectDao().checkGlobalProjectUser(projectids,accountId);
		
	}
	
	
	@Transactional
	public void manageGlobalProjects(GlobalProject baseProject,String schemaYear,Account account) {
		GlobalProjectEntity entity = daoFactory.getGlobalProjectDao().getGlobalProject(baseProject.getProjectName(),baseProject.getSourceSystemId());
		if(entity==null) {
			GlobalProjectMap map = new GlobalProjectMap();
			map.setProjectId(baseProject.getId());
			map.setSource(schemaYear);
			baseProject.addProject(map);
			baseProject = this.create(baseProject, account);
		} else {
			GlobalProjectEntity globalProjectEntity = daoFactory.getGlobalProjectDao().getGlobalProject(baseProject.getProjectName(),baseProject.getSourceSystemId());

		  GlobalProjectMapEntity entity2 = daoFactory.getGlobalProjectDao().getProjectMap(globalProjectEntity.getId(),schemaYear);
		  if(entity2==null) {
			  GlobalProjectMapEntity mapEntity = new GlobalProjectMapEntity();
			  
			  mapEntity.setDateCreated(LocalDateTime.now());
			  mapEntity.setDateUpdated(LocalDateTime.now());
			  mapEntity.setProjectGroupCode(account.getProjectGroup().getProjectGroupCode());
			  mapEntity.setProjectId(baseProject.getId());
			  mapEntity.setSource(schemaYear);
			  mapEntity.setGlobalProject(entity);
			  mapEntity.setUser(account.getAccountId());
			  daoFactory.getGlobalProjectDao().addProjectToGlobalProject(mapEntity);
		  }
		  
		}
	}

}