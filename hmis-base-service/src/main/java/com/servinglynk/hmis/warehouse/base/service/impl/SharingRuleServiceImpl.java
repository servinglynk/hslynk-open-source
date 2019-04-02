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

import com.servinglynk.hmis.warehouse.base.service.SharingRuleService;
import com.servinglynk.hmis.warehouse.common.security.AuditUtil;
import com.servinglynk.hmis.warehouse.common.security.LoggedInUser;
import com.servinglynk.hmis.warehouse.core.model.SharingRule;
import com.servinglynk.hmis.warehouse.core.model.SharingRules;
import com.servinglynk.hmis.warehouse.fileupload.common.SecurityUril;
import com.servinglynk.hmis.warehouse.model.base.GlobalProjectEntity;
import com.servinglynk.hmis.warehouse.model.base.GlobalProjectMapEntity;
import com.servinglynk.hmis.warehouse.model.base.RoleEntity;
import com.servinglynk.hmis.warehouse.model.base.SharingRuleEntity;
import com.servinglynk.hmis.warehouse.model.base.UserRoleMapEntity;
import com.servinglynk.hmis.warehouse.service.exception.ResourceNotFound;
import com.servinglynk.hmis.warehouse.service.exception.ResourceNotFoundException;

public class SharingRuleServiceImpl extends ServiceBase implements SharingRuleService {
	
	
	@Transactional
	public List<UUID> getSharedEnrollments(String schemaYear) {
		List<UUID> returnEnrollments = new ArrayList<UUID>();
		SecurityContext context =  SecurityContextHolder.getContext();
		Authentication authentication =  context.getAuthentication();

		if(authentication.getPrincipal()!=null){
			LoggedInUser entity = (LoggedInUser) authentication.getPrincipal();
			List<UserRoleMapEntity> userroles = daoFactory.getAccountDao().getUserMapByUserName(entity.getUsername());
			
			List<UUID> roles = new ArrayList<>();
			for(UserRoleMapEntity roleMapEntity : userroles) {
				roles.add(roleMapEntity.getRoleEntity().getId());
			}
			
			List<SharingRuleEntity> sharingRules = daoFactory.getSharingRuleDao().getSharingRules(roles.get(0), entity.getProjectGroup());
			
			Set<UUID> projects = new HashSet<>();
			
			for(SharingRuleEntity sharingRuleEntity : sharingRules ) {
				List<GlobalProjectMapEntity> projectMaps =	sharingRuleEntity.getGlobalProjectEntity().getProjects();
				for(GlobalProjectMapEntity projectMapEntity : projectMaps) {
					projects.add(projectMapEntity.getProjectId());
				}
			}
			
			if(!projects.isEmpty()) {
				List<UUID> projs = new ArrayList<UUID>(projects);
				returnEnrollments = daoFactory.getSharingRuleDao().getSharedEnrollments(projs, "v2014");
			}
		}
		return returnEnrollments;
	}
	
	@Transactional
	public List<UUID> getSharedClients(List<UUID> enrollments,String schemaYear){
		return daoFactory.getSharingRuleDao().getSharedClients(enrollments, schemaYear);
	}

	@Transactional
	public SharingRules createSharingRule(SharingRule sharingRule, String caller) {
		
		SharingRules sharingRules = new SharingRules();

		RoleEntity roleEntity = null;

		if (sharingRule.getRole() != null) {
			roleEntity = daoFactory.getRoleDao().getRoleByid(sharingRule.getRole().getId());
			if (roleEntity == null)
				throw new ResourceNotFound("Role not found");
		}

		GlobalProjectEntity globalProjectEntity = daoFactory.getGlobalProjectDao()
				.getById(sharingRule.getProject().getId());
		if (globalProjectEntity == null)
			throw new ResourceNotFoundException("Global project not found");
		SharingRuleEntity entity = new SharingRuleEntity();

		entity.setRole(roleEntity);
		entity.setToProjectGroup(sharingRule.getToProjectGroup().getProjectGroupCode());
		entity.setProjectGroupCode(AuditUtil.getLoginUserProjectGroup());
		entity.setGlobalProjectEntity(globalProjectEntity);
		entity.setActiveFrom(sharingRule.getActiveFrom());
		entity.setActiveTo(sharingRule.getActiveTo());
		entity.setDateCreated(LocalDateTime.now());
			daoFactory.getSharingRuleDao().create(entity);
		return sharingRules;
	}
	
	
	public SharingRule deleteSharingRule(UUID sharingRuleId,String caller) {
//		SharingRuleEntity entity=daoFactory.getSharingRuleDao().getSharingRuleId(sharingRuleId);
//		if(entity==null) throw new RuntimeException();
		
//		daoFactory.getSharingRuleDao().deleteSharingRule(entity);
		
		return new SharingRule();
	}
	

}
