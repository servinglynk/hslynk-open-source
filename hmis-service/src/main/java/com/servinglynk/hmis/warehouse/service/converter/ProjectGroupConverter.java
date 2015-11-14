package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.ProjectGroup;
import com.servinglynk.hmis.warehouse.model.live.ProjectGroupEntity;

public class ProjectGroupConverter {

	
	public static ProjectGroup entityToModel(ProjectGroupEntity projectGroupEntity){
		return null;
	}
	
	
	public static ProjectGroupEntity modelToEntity(ProjectGroup projectGroup, ProjectGroupEntity projectGroupEntity){
		if(projectGroupEntity == null) projectGroupEntity = new ProjectGroupEntity();
		
		projectGroupEntity.setProjectGroupDesc(projectGroup.getProjectGroupDesc());
		projectGroupEntity.setProjectGroupName(projectGroup.getProjectGroupName());
		
		return projectGroupEntity;
	}
	
}
