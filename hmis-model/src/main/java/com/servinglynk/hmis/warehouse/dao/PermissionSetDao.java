package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.entity.ApiMethodEntity;
import com.servinglynk.hmis.warehouse.entity.PermissionSetAclEntity;
import com.servinglynk.hmis.warehouse.entity.PermissionSetEntity;
import com.servinglynk.hmis.warehouse.entity.UserPermissionSetAclEntity;

public interface PermissionSetDao {
	
	PermissionSetEntity createPermissionSet(PermissionSetEntity permissionSetEntity);
	PermissionSetEntity updatePermissionSet(PermissionSetEntity permissionSetEntity);
	void deletePermissionSet(PermissionSetEntity permissionSetEntity);
	PermissionSetEntity getPermissionSetById(UUID permissionSetId);
	
	
	PermissionSetAclEntity createACL(PermissionSetAclEntity entity);
	List<PermissionSetAclEntity> getACLByPermissionSetId(UUID permissionSetId);
	void deleteACL(PermissionSetAclEntity entity);
	UserPermissionSetAclEntity assignPermissionSetToUser(UserPermissionSetAclEntity userPermissionSetAclEntity);
	boolean checkAssignedPermissonSet(List<PermissionSetEntity> permissionSetEntities,ApiMethodEntity apiMethodEntity);
	List<PermissionSetEntity> getAssignedPermissionSets(UUID userId);
}
