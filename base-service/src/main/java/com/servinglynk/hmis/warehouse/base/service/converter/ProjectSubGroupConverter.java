package com.servinglynk.hmis.warehouse.base.service.converter;

import com.servinglynk.hmis.warehouse.base.service.impl.BaseProjectServiceImpl;
import com.servinglynk.hmis.warehouse.core.model.ProjectSubGroup;
import com.servinglynk.hmis.warehouse.model.base.ProjectSubGroupEntity;
import com.servinglynk.hmis.warehouse.model.base.ProjectSubGroupProjectMapEntity;

public class ProjectSubGroupConverter {

	public static ProjectSubGroup entityToModel(ProjectSubGroupEntity entity) {
		ProjectSubGroup projectSubGroup = new ProjectSubGroup();
		projectSubGroup.setProjectSubGroupId(entity.getId());
		projectSubGroup.setProjectSubGroupName(entity.getProjectSubGroupName());
		for(ProjectSubGroupProjectMapEntity mapEntity :   entity.getProjectMaps()) {
			projectSubGroup.addProject(BaseProjectConveter.entityToModel(mapEntity.getProjectId()));
		}
		
		return projectSubGroup;
	}

}
