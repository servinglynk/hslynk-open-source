package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.RoleEntity;

public interface RoleDao {
	

	public RoleEntity createRole(RoleEntity roleEntity);
	public RoleEntity updateRole(RoleEntity roleEntity);
	public void deleteRole(RoleEntity roleEntity);
	public RoleEntity getRoleByid(UUID roleId);
	public List<RoleEntity> getRoles(List<UUID> roles, Integer startIndex, Integer maxItems);
//	public List<RoleEntity> getRoles(Integer startIndex, Integer maxItems);
	public long geRoleCount(List<UUID> roles);

}
