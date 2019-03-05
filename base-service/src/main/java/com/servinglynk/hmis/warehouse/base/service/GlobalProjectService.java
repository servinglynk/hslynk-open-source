package com.servinglynk.hmis.warehouse.base.service;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.GlobalProject;
import com.servinglynk.hmis.warehouse.core.model.GlobalProjectUsers;
import com.servinglynk.hmis.warehouse.core.model.GlobalProjects;
import com.servinglynk.hmis.warehouse.core.model.GlobalProjectsMap;

public interface GlobalProjectService {
	
	GlobalProject create(GlobalProject model,Account account);
	void update(GlobalProject model,Account account);
	GlobalProject getById(UUID id);
	GlobalProjects getAllGlobalProjects(Integer start,Integer maxItems);
	void addProjectsToGlobalProject(UUID globalProjectId, GlobalProjectsMap globalProjectsMap, Account account);
	void removeProjectsFromGlobalProject(UUID globalProjectId, UUID projectId);
	
	void addUsersToGlobalProject(UUID globalProjectId,GlobalProjectUsers users,Account account);
	void removeUserToGlobalProject(UUID globalProjectId,UUID userId);
	GlobalProjectUsers getGlobalProjectUsers(UUID globalProjectId);
	Boolean checkGlobalProjectUser(List<UUID> projectids, UUID accountId);
	
	void manageGlobalProjects(GlobalProject baseProject,String schemaYear,Account account);
}
