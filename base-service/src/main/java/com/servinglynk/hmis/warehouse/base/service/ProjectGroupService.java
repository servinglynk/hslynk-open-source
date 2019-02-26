package com.servinglynk.hmis.warehouse.base.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.ProjectGroup;
import com.servinglynk.hmis.warehouse.core.model.ProjectGroups;

public interface ProjectGroupService {

	
	ProjectGroup createProjectGroup(ProjectGroup projectGroup, String caller);
	ProjectGroup updateProjectGroup(UUID projectgroupid ,ProjectGroup projectGroup, String caller);
	ProjectGroup deleteProjectGroup(UUID projectGroupId);
	public ProjectGroup getProjectGroupById(UUID projectgroupid);
	ProjectGroups getAllProjectGroups(Integer startIndex, Integer maxItems);
}
