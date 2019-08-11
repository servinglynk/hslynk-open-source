package com.servinglynk.hmis.warehouse.base.dao;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.servinglynk.hmis.warehouse.common.security.LoggedInUser;
import com.servinglynk.hmis.warehouse.model.base.ClientTracker;
import com.servinglynk.hmis.warehouse.model.base.SessionEntity;

public class ClientTrackerDaoImpl extends QueryExecutorImpl implements ClientTrackerDao {
	
	@Autowired
	ApplicationContext applicationContext;

	public ClientTracker insertClientTracker(ClientTracker clientTracker) {
		clientTracker.setId(UUID.randomUUID());
		insert(clientTracker);
		return clientTracker;
	}
	
	public void createTracker(UUID clientId, String projectGroup, boolean deletedFlag,String operation,String serviceName, String userName) {
		ClientTracker tracker = new ClientTracker();
		tracker.setId(UUID.randomUUID());
		tracker.setClientId(clientId);
		tracker.setDeletedFlag(deletedFlag);
		tracker.setProjectGroup(projectGroup);
		tracker.setServiceName(serviceName !=null ? serviceName : applicationContext.getApplicationName());
		tracker.setOperationAt(LocalDateTime.now());
		tracker.setOperation(operation);
		SecurityContext context =  SecurityContextHolder.getContext();
		if(context!=null) {
			Authentication authentication =  context.getAuthentication();
			if(authentication!= null &&  authentication.getPrincipal()!=null){
				LoggedInUser entity = (LoggedInUser) authentication.getPrincipal();
				if(entity!=null) tracker.setUserName(entity.getUsername());
			}
		}else {
			tracker.setUserName(userName);
		}
		insert(tracker);	
	}
}