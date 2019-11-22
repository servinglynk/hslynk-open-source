package com.servinglynk.hmis.warehouse.base.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Accounts;
import com.servinglynk.hmis.warehouse.core.model.Session;

public interface BaseProjectService {

	void addUserToProject(UUID projectId,String userName,Session session);
	
	void removeUserFromProject(UUID projectId,UUID userId);
	
	Accounts getProjectUsers(UUID projectId);
}