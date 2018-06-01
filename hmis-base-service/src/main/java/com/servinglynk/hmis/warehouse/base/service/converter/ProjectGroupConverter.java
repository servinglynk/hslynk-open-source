package com.servinglynk.hmis.warehouse.base.service.converter;


import com.servinglynk.hmis.warehouse.core.model.ProjectGroup;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;

public class ProjectGroupConverter {

	
	public static ProjectGroup entityToModel(ProjectGroupEntity projectGroupEntity){
		ProjectGroup projectGroup = new ProjectGroup();
		projectGroup.setProjectGroupDesc(projectGroupEntity.getProjectGroupDesc());
		projectGroup.setProjectGroupName(projectGroupEntity.getProjectGroupName());
		projectGroup.setProjectGroupId(projectGroupEntity.getId());
		projectGroup.setBucketName(projectGroupEntity.getBucketName());
		projectGroup.setProjectGroupCode(projectGroupEntity.getProjectGroupCode());
		projectGroup.setSenderEmail(projectGroupEntity.getSenderEmail());		
		return projectGroup;
	}
	
	
	public static ProjectGroupEntity modelToEntity(ProjectGroup projectGroup, ProjectGroupEntity projectGroupEntity){
		if(projectGroupEntity == null) projectGroupEntity = new ProjectGroupEntity();
		
		projectGroupEntity.setProjectGroupDesc(projectGroup.getProjectGroupDesc());
		projectGroupEntity.setProjectGroupName(projectGroup.getProjectGroupName());
		
		return projectGroupEntity;
	}
	
}
