package com.servinglynk.hmis.warehouse.base.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.base.service.SharingRuleService;
import com.servinglynk.hmis.warehouse.base.service.converter.SharingRuleConverter;
import com.servinglynk.hmis.warehouse.common.security.AuditUtil;
import com.servinglynk.hmis.warehouse.common.security.LoggedInUser;
import com.servinglynk.hmis.warehouse.core.model.GlobalProject;
import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.core.model.SharingRule;
import com.servinglynk.hmis.warehouse.core.model.SharingRules;
import com.servinglynk.hmis.warehouse.core.model.exception.MissingParameterException;
import com.servinglynk.hmis.warehouse.model.base.GlobalProjectEntity;
import com.servinglynk.hmis.warehouse.model.base.ProfileEntity;
import com.servinglynk.hmis.warehouse.model.base.RoleEntity;
import com.servinglynk.hmis.warehouse.model.base.SharingRuleEntity;
import com.servinglynk.hmis.warehouse.model.base.UserRoleMapEntity;
import com.servinglynk.hmis.warehouse.service.exception.ResourceNotFound;
import com.servinglynk.hmis.warehouse.service.exception.ResourceNotFoundException;

import java_cup.shift_action;

public class SharingRuleServiceImpl extends ServiceBase implements SharingRuleService {
	
	
	@Transactional
	public List<UUID> getSharedEnrollments(List<UUID> projects,String schemaYear) {
		List<UUID> returnEnrollments = new ArrayList<UUID>();			
			if(!projects.isEmpty()) {
				returnEnrollments = daoFactory.getSharingRuleDao().getSharedEnrollments(projects, schemaYear);
			}
		return returnEnrollments;
	}
	
	@Transactional
	public List<UUID> getSharedProjects() {
		Set<UUID> projects = new HashSet<>();
		List<UUID> sharedProjects = new ArrayList<UUID>();
		SecurityContext context =  SecurityContextHolder.getContext();
		Authentication authentication =  context.getAuthentication();

		if(authentication.getPrincipal()!=null){
			LoggedInUser entity = (LoggedInUser) authentication.getPrincipal();
			List<UserRoleMapEntity> roles = daoFactory.getAccountDao().getUserMapByUserId(entity.getUserId());
			UUID roleId = null;
			if(!roles.isEmpty()) roleId = roles.get(0).getRoleEntity().getId();
		//	List<SharingRuleEntity> sharingRules = daoFactory.getSharingRuleDao().getSharingRules(entity.getProfileId(), entity.getUserId());
			List<UUID> sharedGlobalProjects = daoFactory.getSharingRuleDao().getSharedProjects(roleId);
			
			if(!sharedGlobalProjects.isEmpty())
				sharedProjects = daoFactory.getGlobalProjectDao().getGlobalProjectProjects(sharedGlobalProjects);
/*			for(SharingRuleEntity sharingRuleEntity : sharingRules ) {
				List<GlobalProjectMapEntity> projectMaps =	sharingRuleEntity.getGlobalProjectEntity().getProjects();
				for(GlobalProjectMapEntity projectMapEntity : projectMaps) {
					projects.add(projectMapEntity.getProjectId());
				}
			}*/
			
		}
		//return new ArrayList<>(projects);
		return sharedProjects;
	}

	
	@Transactional
	public List<UUID> getSharedClients(List<UUID> enrollments,String schemaYear){
		return daoFactory.getSharingRuleDao().getSharedClients(enrollments, schemaYear);
	}

	@Transactional
	public SharingRule createSharingRule(SharingRule sharingRule) {
		if(sharingRule.getToProjectGroup()==null) throw new MissingParameterException("ToprojectGroup is required");
		
		if(sharingRule.getProjects().isEmpty()) throw new MissingParameterException("Atleast one project is required");
 			
		for (GlobalProject project : sharingRule.getProjects()) {
			GlobalProjectEntity globalProject = daoFactory.getGlobalProjectDao()
					.getById(project.getId());
			if (globalProject != null) {
				if (sharingRule.getRoles()==null || sharingRule.getRoles().isEmpty()) {
					SharingRuleEntity entity = new SharingRuleEntity();
					entity.setToProjectGroup(sharingRule.getToProjectGroup().getProjectGroupCode());
					entity.setProjectGroupCode(AuditUtil.getLoginUserProjectGroup());
					entity.setGlobalProjectEntity(globalProject);
					entity.setActiveFrom(sharingRule.getActiveFrom());
					entity.setActiveTo(sharingRule.getActiveTo());
					entity.setDateCreated(LocalDateTime.now());
					daoFactory.getSharingRuleDao().create(entity);
				} else {
					for (Role role : sharingRule.getRoles()) {
						RoleEntity roleEntity = daoFactory.getRoleDao().getRoleByid(role.getId());
						if (roleEntity != null) {
							SharingRuleEntity entity = new SharingRuleEntity();
							entity.setToProjectGroup(sharingRule.getToProjectGroup().getProjectGroupCode());
							entity.setProjectGroupCode(AuditUtil.getLoginUserProjectGroup());
							entity.setGlobalProjectEntity(globalProject);
							entity.setUser(AuditUtil.getLoginUserId());
							entity.setRole(roleEntity);
							entity.setActiveFrom(sharingRule.getActiveFrom());
							entity.setActiveTo(sharingRule.getActiveTo());
							entity.setDateCreated(LocalDateTime.now());
							daoFactory.getSharingRuleDao().create(entity);
						}
					}
				}
			}
		}
		return sharingRule;
	}

	@Transactional
	public void updateSharingRule(SharingRule sharingRule) {
		if(sharingRule.getToProjectGroup()==null) throw new MissingParameterException("ToprojectGroup is required");
		SharingRuleEntity sharingRuleEntity = daoFactory.getSharingRuleDao().getSharingRuleById(sharingRule.getSharingRuleId());
		if(sharingRuleEntity==null) throw new ResourceNotFoundException("Sharing Rule not found "+sharingRule.getSharingRuleId());

		ProfileEntity profileEntity= null;

		if (sharingRule.getRole()!= null) {
			profileEntity = daoFactory.getProfileDao().getProfileById(sharingRule.getRole().getId());
			if (profileEntity == null)
				throw new ResourceNotFound("Profile not found");
		}


		GlobalProjectEntity globalProjectEntity = daoFactory.getGlobalProjectDao()
				.getById(sharingRule.getProject().getId());
		if (globalProjectEntity == null)
			throw new ResourceNotFoundException("Global project not found");

//		sharingRuleEntity.setRole(role);(profileEntity);
		sharingRuleEntity.setToProjectGroup(sharingRule.getToProjectGroup().getProjectGroupCode());
		sharingRuleEntity.setProjectGroupCode(AuditUtil.getLoginUserProjectGroup());
		sharingRuleEntity.setGlobalProjectEntity(globalProjectEntity);
		sharingRuleEntity.setActiveFrom(sharingRule.getActiveFrom());
		sharingRuleEntity.setActiveTo(sharingRule.getActiveTo());
		sharingRuleEntity.setDateUpdated(LocalDateTime.now());
		daoFactory.getSharingRuleDao().updateSharingRule(sharingRuleEntity);

	}

	@Transactional
	public void deleteSharingRule(UUID sharingRuleId) {
		SharingRuleEntity sharingRuleEntity = daoFactory.getSharingRuleDao().getSharingRuleById(sharingRuleId);
		if(sharingRuleEntity==null) throw new ResourceNotFoundException("Sharing Rule not found "+sharingRuleId);
		daoFactory.getSharingRuleDao().deleteSharingRule(sharingRuleEntity);
		
	}

	@Transactional
	public SharingRule getSharingRuleById(UUID sharingRuleId) {
		SharingRuleEntity sharingRuleEntity = daoFactory.getSharingRuleDao().getSharingRuleById(sharingRuleId);
		if(sharingRuleEntity==null) throw new ResourceNotFoundException("Sharing Rule not found "+sharingRuleId);
		return SharingRuleConverter.entityToModel(sharingRuleEntity);
	}

	@Transactional
	public SharingRules getAllSharingRules(Integer start, Integer maxItems) {
		SharingRules sharingRules = new SharingRules();
		List<SharingRuleEntity> sharingRuleEntities =	daoFactory.getSharingRuleDao().getAllSharingRules(start,maxItems);
		for(SharingRuleEntity sharingRuleEntity: sharingRuleEntities) {
				sharingRules.addSharingRule(SharingRuleConverter.entityToModel(sharingRuleEntity));
		}
		Long count = daoFactory.getSharingRuleDao().getAllSharingRulesCount();
		SortedPagination pagination = new SortedPagination();
		pagination.setFrom(start);
		pagination.setReturned(sharingRuleEntities.size());
		pagination.setTotal(count.intValue());
		sharingRules.setPagination(pagination);		
		return sharingRules;
	}	
}