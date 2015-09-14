package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.PermissionSet;
import com.servinglynk.hmis.warehouse.model.live.PermissionSetEntity;

public class PermissionSetConverter {
	
	
	public static PermissionSet entityToModel(PermissionSetEntity permissionSetEntity){
		PermissionSet permissionSet = new PermissionSet();
		permissionSet.setPermissionSetName(permissionSetEntity.getPermissionSetName());
		permissionSet.setId(permissionSetEntity.getId());
		permissionSet.setPermissionSetDescription(permissionSetEntity.getPermissionSetDescription());
		return permissionSet;
	}
	
	public static PermissionSet entityToModelFull(PermissionSetEntity permissionSetEntity){
		PermissionSet permissionSet = new PermissionSet();
		permissionSet.setPermissionSetName(permissionSetEntity.getPermissionSetName());
		permissionSet.setId(permissionSetEntity.getId());
		
		return permissionSet;
	}

	
	public static PermissionSetEntity modelToEntity(PermissionSetEntity permissionSetEntity,PermissionSet permissionSet){
		if(permissionSetEntity==null){
			permissionSetEntity = new PermissionSetEntity();
		}
		permissionSetEntity.setPermissionSetName(permissionSet.getPermissionSetName());
		permissionSetEntity.setPermissionSetDescription(permissionSet.getPermissionSetDescription());
		return permissionSetEntity;
	}

}
