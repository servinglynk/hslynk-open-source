package com.servinglynk.hmis.warehouse.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.core.model.Enrollment;
import com.servinglynk.hmis.warehouse.core.model.Project;
import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.core.model.SharingRule;
import com.servinglynk.hmis.warehouse.core.model.SharingRules;
import com.servinglynk.hmis.warehouse.entity.RoleEntity;
import com.servinglynk.hmis.warehouse.entity.SharingRuleEntity;
import com.servinglynk.hmis.warehouse.service.SharingRuleService;
import com.servinglynk.hmis.warehouse.service.converter.SharingRuleConverter;
import com.servinglynk.hmis.warehouse.service.exception.OrganizationNotFound;
import com.servinglynk.hmis.warehouse.service.exception.ProfileNotFoundException;

public class SharingRuleServiceImpl extends ServiceBase implements SharingRuleService {

	@Transactional
	public SharingRules createSharingRule(SharingRule sharingRule,String caller) {
		SharingRules sharingRules= new SharingRules();
		
		
		if(sharingRule.getEnrollments().size()>1){
			throw new RuntimeException("Only one Enrollment will allowed");
		}
		
		if(sharingRule.getProjects().size()==0){
			throw new RuntimeException("Atleast one project required");
		}
		
		if(sharingRule.getRoles().size()==0){
			throw new RuntimeException("Atlease one Role required");
		}
		
		com.servinglynk.hmis.warehouse.model.live.Organization fromOrganization = daoFactory.getOrganizationDao().getOrganizationByYd(sharingRule.getFromOrganization());
		
		if(fromOrganization==null) throw new OrganizationNotFound("From Organization not found");
		
		com.servinglynk.hmis.warehouse.model.live.Organization toOrganization = daoFactory.getOrganizationDao().getOrganizationByYd(sharingRule.getToOrganization());
		
		if(toOrganization==null) throw new OrganizationNotFound("To Organization not found");
		
		for(Enrollment enrollment : sharingRule.getEnrollments()){
			com.servinglynk.hmis.warehouse.model.live.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollment.getEnrollmentId());
			
			for(Project project : sharingRule.getProjects()){
				com.servinglynk.hmis.warehouse.model.live.Project pProject = daoFactory.getProjectDao().getProjectById(project.getProjectId());
				
				if(pProject==null) throw new ProfileNotFoundException();
				
					for(Role role :  sharingRule.getRoles()){
						RoleEntity roleEntity = daoFactory.getRoleDao().getRoleByid(role.getId());
						if(roleEntity!=null) {	
							SharingRuleEntity entity = new SharingRuleEntity();
							entity.setEnrollment(pEnrollment);
							entity.setFromOrganization(fromOrganization);
							entity.setToOrganization(toOrganization);
							entity.setRole(roleEntity);
							entity.setProject(pProject);
							entity.setActiveFrom(sharingRule.getActiveFrom());
							entity.setActiveTo(sharingRule.getActiveTo());
							entity.setCreatedAt(new Date());
							entity.setCreatedBy(caller);
							daoFactory.getSharingRuleDao().insertSharingRule(entity);
							sharingRules.addSharingRule(SharingRuleConverter.entityToModel(entity));
							createSharingRuleForParentRole(entity, roleEntity,sharingRules);
						}
					}
			}
		
		}
		

		return sharingRules;
	}
	
	
	public void createSharingRuleForParentRole(SharingRuleEntity sharingRuleEntity,RoleEntity roleEntity,SharingRules rules){
		if(roleEntity!=null){
			if(roleEntity.getParentRoleEntity()!=null){
				SharingRuleEntity entity = new SharingRuleEntity();
				entity.setRole(roleEntity.getParentRoleEntity());
				entity.setEnrollment(sharingRuleEntity.getEnrollment());
				entity.setFromOrganization(sharingRuleEntity.getFromOrganization());
				entity.setToOrganization(sharingRuleEntity.getToOrganization());
				entity.setProject(sharingRuleEntity.getProject());
				entity.setActiveFrom(sharingRuleEntity.getActiveFrom());
				entity.setActiveTo(sharingRuleEntity.getActiveTo());
				entity.setCreatedAt(sharingRuleEntity.getCreatedAt());
				entity.setCreatedBy(sharingRuleEntity.getCreatedBy());
				daoFactory.getSharingRuleDao().insertSharingRule(entity);
				rules.addSharingRule(SharingRuleConverter.entityToModel(entity));
				if(roleEntity.getParentRoleEntity()!=null){
					createSharingRuleForParentRole(entity,roleEntity.getParentRoleEntity(),rules);
				}
			}
		}
	}

	@Override
	public SharingRule updateSharingRule(SharingRule sharingRule,String caller) {
		
		return null;
	}

	
	public SharingRule deleteSharingRule(UUID sharingRuleId,String caller) {
		SharingRuleEntity entity=daoFactory.getSharingRuleDao().getSharingRuleId(sharingRuleId);
		if(entity==null) throw new RuntimeException();
		
		daoFactory.getSharingRuleDao().deleteSharingRule(entity);
		
		return new SharingRule();
	}
	

}
