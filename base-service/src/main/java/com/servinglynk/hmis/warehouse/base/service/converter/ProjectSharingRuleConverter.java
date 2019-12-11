package com.servinglynk.hmis.warehouse.base.service.converter;

import com.servinglynk.hmis.warehouse.core.model.ProjectSharingRule;
import com.servinglynk.hmis.warehouse.model.base.ProjectSharingRuleEntity;

public class ProjectSharingRuleConverter {

	public static ProjectSharingRule entityToModel(ProjectSharingRuleEntity entity) {
		ProjectSharingRule rule = new ProjectSharingRule();
		rule.setProjectSharingRuleId(entity.getId());
		
		if(entity.getProjectSubGroup()!=null) {
			if(entity.getProjectSubGroup().getUserDefined()) {
					rule.setProjectSubGroup(ProjectSubGroupConverter.entityToModel(entity.getProjectSubGroup()));
			}else {
				if(entity.getProjectSubGroup().getProjectMaps()!=null && !entity.getProjectSubGroup().getProjectMaps().isEmpty())
				rule.setProject(BaseProjectConveter.entityToModel(entity.getProjectSubGroup().getProjectMaps().get(0).getProjectId()));
			}
		}
		
		
		
		if(entity.getToProjectSubGroup()!=null) {
			if(entity.getToProjectSubGroup().getUserDefined()) {
					rule.setToProjectSubGroup(ProjectSubGroupConverter.entityToModel(entity.getToProjectSubGroup()));
			}else {
				if(entity.getToProjectSubGroup().getProjectMaps()!=null && !entity.getToProjectSubGroup().getProjectMaps().isEmpty())
				rule.setToProject(BaseProjectConveter.entityToModel(entity.getToProjectSubGroup().getProjectMaps().get(0).getProjectId()));
			}
		}
		
		return rule;
	}

}
