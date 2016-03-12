package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.model.v2014.RoleEntity;

public class RoleConverter {
	
	public static Role entityToModel(RoleEntity roleEntity){
		Role role = new Role();
		role.setId(roleEntity.getId());
		role.setRoleDescription(roleEntity.getRoleDescription());
		role.setRoleName(roleEntity.getRoleName());
		return role;
	}
	
	public static Role entityToModelFull(RoleEntity roleEntity){
		Role role = new Role();
		role.setId(roleEntity.getId());
		role.setRoleDescription(roleEntity.getRoleDescription());
		role.setRoleName(roleEntity.getRoleName());
			
			if(roleEntity.getParentRoleEntity()!= null){
				Role parentRole = entityToModel(roleEntity.getParentRoleEntity());
				role.setParentRole(parentRole);
			}
			
		return role;
	}
	
	
	public static RoleEntity modelToEntity(RoleEntity roleEntity,Role role){
		roleEntity.setRoleDescription(role.getRoleDescription());
		roleEntity.setRoleName(role.getRoleName());
		return roleEntity;
	}

}
