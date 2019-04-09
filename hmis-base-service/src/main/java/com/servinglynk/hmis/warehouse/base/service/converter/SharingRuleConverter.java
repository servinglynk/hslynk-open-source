package com.servinglynk.hmis.warehouse.base.service.converter;

import com.servinglynk.hmis.warehouse.core.model.GlobalProject;
import com.servinglynk.hmis.warehouse.core.model.ProjectGroup;
import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.core.model.SharingRule;
import com.servinglynk.hmis.warehouse.model.base.SharingRuleEntity;

public class SharingRuleConverter {

	
	public static SharingRule entityToModel(SharingRuleEntity entity){
		SharingRule sharingRule=new SharingRule();
		sharingRule.setSharingRuleId(entity.getId());
		sharingRule.setActiveFrom(entity.getActiveFrom());
		sharingRule.setActiveTo(entity.getActiveTo());

		if(entity.getGlobalProjectEntity()!=null) {
			GlobalProject project = new GlobalProject();
			project.setProjectName(entity.getGlobalProjectEntity().getProjectName());
			project.setProjects(null);
			sharingRule.setProject(project);
		}
		
		if(entity.getRole()!=null) {
			Role role = new Role();
			role.setId(entity.getRole().getId());
			role.setRoleName(entity.getRole().getRoleName());
			sharingRule.setRole(role);
		}
		if(entity.getProjectGroupCode()!=null) {
			ProjectGroup projectGroup = new ProjectGroup();
			projectGroup.setProjectGroupCode(entity.getProjectGroupCode());
			sharingRule.setToProjectGroup(projectGroup);
		}
		return sharingRule;
	}
	
	
}
