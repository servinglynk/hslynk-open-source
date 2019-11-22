package com.servinglynk.hmis.warehouse.base.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.ProjectSubGroup;
import com.servinglynk.hmis.warehouse.core.model.ProjectSubGroups;

public interface ProjectSubGroupService {

	ProjectSubGroup createProjectSubGroup(ProjectSubGroup projectSubGroup, Account account);

	void updateProjectSubGroup(ProjectSubGroup projectSubGroup, Account account);

	void deleteProjectSubGroup(UUID projectSubGroupId, Account account);

	ProjectSubGroup getProjectSubGroupById(UUID projectSubGroupId);

	ProjectSubGroups getProjectSubGroups(Integer startIndex, Integer maxItems);

	void addProjectToProjectSubGroup(UUID projectSubGroupId, UUID projectId, Account account);

	void deltetProjectToProjectSubGroup(UUID projectSubGroupId, UUID projectId, Account account);

}
