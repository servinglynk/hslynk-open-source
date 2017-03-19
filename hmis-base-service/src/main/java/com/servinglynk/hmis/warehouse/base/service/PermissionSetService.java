package com.servinglynk.hmis.warehouse.base.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.PermissionSet;

public interface PermissionSetService {

	 PermissionSet createPermissionSet(PermissionSet permissionSet,String caller);
	 PermissionSet updatePermissionSet(PermissionSet permissionSet,String caller);
	 PermissionSet deletePermissionSet(UUID permissionSetId,String caller);
	 PermissionSet getPermissionSetById(UUID permissionSetId);
	 void assignPermissionSetTOUser(String userName,PermissionSet permissionSet,String caller);
	  
	
}
