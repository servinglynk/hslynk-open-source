package com.servinglynk.hmis.warehouse.base.service.converter;

import com.servinglynk.hmis.warehouse.core.model.BaseProject;
import com.servinglynk.hmis.warehouse.model.base.Project;

public class BaseProjectConveter {

	public static BaseProject entityToModel(Project entity) {
		BaseProject project = new BaseProject();
		project.setProjectId(entity.getId());
		project.setProjectCommonName(entity.getProjectcommonname());
		project.setProjectName(entity.getProjectname());
		if(entity.getProjecttype()!=null) project.setProjectType(Integer.parseInt(entity.getProjecttype().getValue()));
		project.setSchemaYear(entity.getSchemaYear());
		return project;
	}

}
