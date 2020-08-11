package com.servinglynk.hmis.warehouse.base.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.service.ProjectSharingRuleService;
import com.servinglynk.hmis.warehouse.base.service.converter.ProjectSharingRuleConverter;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.ProjectSharingRule;
import com.servinglynk.hmis.warehouse.core.model.ProjectSharingRules;
import com.servinglynk.hmis.warehouse.model.base.Project;
import com.servinglynk.hmis.warehouse.model.base.ProjectSharingRuleEntity;
import com.servinglynk.hmis.warehouse.model.base.ProjectSubGroupEntity;
import com.servinglynk.hmis.warehouse.service.exception.ResourceNotFoundException;

public class ProjectSharingRuleServiceImpl extends ServiceBase implements ProjectSharingRuleService {

	@Transactional
	public ProjectSharingRule createSharingRule(ProjectSharingRule projectSharingRule,Account caller) {
		ProjectSharingRuleEntity entity = new ProjectSharingRuleEntity();
		entity.setDateCreated(LocalDateTime.now());
		entity.setDateUpdated(LocalDateTime.now());
		entity.setProjectGroupCode(caller.getProjectGroup().getProjectGroupCode());
		if(projectSharingRule.getProject()!=null && projectSharingRule.getProject().getProjectId()!=null) {
			Project project =	daoFactory.getBaseProjectDao().getProjectById(projectSharingRule.getProject().getProjectId());
			if(project == null) throw new ResourceNotFoundException("project not found "+projectSharingRule.getProject().getProjectId());
			ProjectSubGroupEntity subGroupEntity = daoFactory.projectSubGroupDao.getProjectsDefaultGroup(projectSharingRule.getProject().getProjectId());
			if(subGroupEntity ==null) {
				subGroupEntity =	daoFactory.getBaseProjectDao().createDefaultProjectSubGroup(project);
			}
			entity.setProjectSubGroup(subGroupEntity);
		}
		if(projectSharingRule.getProjectSubGroup()!=null && projectSharingRule.getProjectSubGroup().getProjectSubGroupId()!=null) {
			ProjectSubGroupEntity subGroupEntity = daoFactory.getProjectSubGroupDao().getProjectSubGroupById(projectSharingRule.getProjectSubGroup().getProjectSubGroupId());
				if(subGroupEntity == null) throw new ResourceNotFoundException("Project sub group not found "+projectSharingRule.getProjectSubGroup().getProjectSubGroupId());
			entity.setProjectSubGroup(subGroupEntity);
		}
		
		
		if(projectSharingRule.getToProject()!=null && projectSharingRule.getToProject().getProjectId()!=null) {
			ProjectSubGroupEntity subGroupEntity = daoFactory.projectSubGroupDao.getToProjectsDefaultGroup(projectSharingRule.getToProject().getProjectId());
		/*	if(subGroupEntity ==null) {
				subGroupEntity =	daoFactory.getBaseProjectDao().createDefaultProjectSubGroup(project);
			}*/
			entity.setToProjectSubGroup(subGroupEntity);
			entity.setToProjectGroupCode(subGroupEntity.getProjectGroupCode());
		}
		if(projectSharingRule.getToProjectSubGroup()!=null && projectSharingRule.getToProjectSubGroup().getProjectSubGroupId()!=null) {
			ProjectSubGroupEntity subGroupEntity = daoFactory.getProjectSubGroupDao().getToProjectSubGroupById(projectSharingRule.getToProjectSubGroup().getProjectSubGroupId());
				if(subGroupEntity == null) throw new ResourceNotFoundException("Project sub group not found "+projectSharingRule.getToProjectSubGroup().getProjectSubGroupId());
			entity.setToProjectSubGroup(subGroupEntity);
			entity.setToProjectGroupCode(subGroupEntity.getProjectGroupCode());
		}
		
		daoFactory.getProjectSharingRuleDao().createSharingRule(entity);
		
		return projectSharingRule;
	}

	@Transactional
	public Boolean isSharedClient(UUID clientId, UUID accountId, String projectGroupCode) {
		List<UUID> sharedClients =	daoFactory.getProjectSharingRuleDao().getSharedClients(accountId,projectGroupCode);
		if(sharedClients.contains(clientId)) return true;
		return false;
	}

	@Transactional
	public Boolean isSharedEnrollment(UUID enrollmentId, UUID accountId, String projectGroupCode) {
		List<UUID> sharedEnrollmets  = daoFactory.getProjectSharingRuleDao().getSharedEnrollemnts(accountId, projectGroupCode);
		if(sharedEnrollmets.contains(enrollmentId)) return true;
		throw new ResourceNotFoundException("client not found "+enrollmentId);
	}

	@Transactional
	public void deleteSharingRule(UUID sharingruleid, Account caller) {
		ProjectSharingRuleEntity entity = daoFactory.getProjectSharingRuleDao().getBySharingRuleId(sharingruleid);
		if(entity == null) throw new ResourceNotFoundException("Sharing rule not found "+sharingruleid);
		daoFactory.getProjectSharingRuleDao().deleteSharingRule(entity);
	}

	@Transactional
	public ProjectSharingRule getSharingRule(UUID sharingruleid) {
		ProjectSharingRuleEntity entity = daoFactory.getProjectSharingRuleDao().getBySharingRuleId(sharingruleid);
		if(entity == null) throw new ResourceNotFoundException("Sharing rule not found "+sharingruleid);
		return ProjectSharingRuleConverter.entityToModel(entity);
	}

	@Transactional
	public ProjectSharingRules getSharingRules(Integer startIndex, Integer maxItems) {
		ProjectSharingRules rules = new ProjectSharingRules();
		List<ProjectSharingRuleEntity> entities = daoFactory.getProjectSharingRuleDao().getSharingRules(startIndex,maxItems);
		for(ProjectSharingRuleEntity entity : entities) {
			rules.addProjectSharingRule(ProjectSharingRuleConverter.entityToModel(entity));
		}
		return rules;
	}
}
