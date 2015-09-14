package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.Enrollment;
import com.servinglynk.hmis.warehouse.core.model.Project;
import com.servinglynk.hmis.warehouse.core.model.SharingRule;
import com.servinglynk.hmis.warehouse.model.live.SharingRuleEntity;

public class SharingRuleConverter {

	
	public static SharingRule entityToModel(SharingRuleEntity entity){
		SharingRule sharingRule=new SharingRule();
		
		sharingRule.setSharingRuleId(entity.getId());
		sharingRule.setFromOrganization(entity.getFromOrganization().getId());
		sharingRule.setToOrganization(entity.getToOrganization().getId());
		if(entity.getEnrollment()!=null){
			sharingRule.addEnrollment(entityToModel(entity.getEnrollment()));
		}
		if(entity.getProject()!=null){
			sharingRule.addProject(entityToModel(entity.getProject()));
		}
		if(entity.getRole()!=null){
			sharingRule.addRole(RoleConverter.entityToModel(entity.getRole()));
		}	
		return sharingRule;
	}
	
	
	public static Enrollment entityToModel(com.servinglynk.hmis.warehouse.model.live.Enrollment entity){
		Enrollment enrollment = new Enrollment();
		enrollment.setEnrollmentId(entity.getId());
		return enrollment;
	}
	
	
	public static Project entityToModel(com.servinglynk.hmis.warehouse.model.live.Project entity){
		Project project=new Project();
		project.setProjectId(entity.getId());
		return project;
	}
	
}
