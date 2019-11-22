package com.servinglynk.hmis.warehouse.base.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.service.BaseProjectService;
import com.servinglynk.hmis.warehouse.base.service.converter.AccountConverter;
import com.servinglynk.hmis.warehouse.core.model.Accounts;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.model.base.HmisUser;
import  com.servinglynk.hmis.warehouse.model.base.Project;
import com.servinglynk.hmis.warehouse.model.base.ProjectUserEntity;
import com.servinglynk.hmis.warehouse.service.exception.ResourceNotFoundException;

public class BaseProjectServiceImpl extends ServiceBase implements BaseProjectService {

	@Transactional
	public void addUserToProject(UUID projectId,String userName,Session session) {
	
		Project project =	daoFactory.getBaseProjectDao().getProjectById(projectId);
		if(project == null) throw new ResourceNotFoundException("Project not found "+projectId);
		HmisUser hmisUser = daoFactory.getAccountDao().findByUsername(userName);
		if(hmisUser == null) throw new ResourceNotFoundException("User not found "+userName);
			ProjectUserEntity projectUserEntity = new ProjectUserEntity();
			projectUserEntity.setProject(project);
			projectUserEntity.setProjectUser(hmisUser);
			projectUserEntity.setDateCreated(LocalDateTime.now());
			projectUserEntity.setDateUpdated(LocalDateTime.now());
			projectUserEntity.setUser(session.getAccount().getAccountId());
			projectUserEntity.setProjectGroupCode(session.getAccount().getProjectGroup().getProjectGroupCode());
			daoFactory.getBaseProjectDao().createProjectUser(projectUserEntity);
	}
	
	@Transactional
	public void removeUserFromProject(UUID projectId,UUID userId) {
		Project project = daoFactory.getBaseProjectDao().getProjectById(projectId);
		if(project == null) throw new ResourceNotFoundException("Project not found "+projectId);
		List<ProjectUserEntity> projectUserEntities =	daoFactory.getBaseProjectDao().getProjectUserMap(projectId,userId);
		for(ProjectUserEntity projectUserEntity : projectUserEntities) {
			daoFactory.getBaseProjectDao().deleteProjectUser(projectUserEntity);
		}
		
	}

	@Transactional
	public Accounts getProjectUsers(UUID projectId) {
		Accounts accounts = new Accounts();
		Project project = daoFactory.getBaseProjectDao().getProjectById(projectId);
		if(project == null) throw new ResourceNotFoundException("Project not found "+projectId);
		List<ProjectUserEntity> projectUserEntities =	daoFactory.getBaseProjectDao().getProjectUserByProjectId(projectId);
			for(ProjectUserEntity projectUserEntity : projectUserEntities) {
					if(projectUserEntity.getProjectUser()!=null)	
						accounts.addAccount(AccountConverter.convertToAccountLite(projectUserEntity.getProjectUser()));
			}
		return accounts;
	}
}
