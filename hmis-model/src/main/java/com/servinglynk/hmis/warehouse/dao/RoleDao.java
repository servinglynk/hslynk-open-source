package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.live.RoleEntity;

public interface RoleDao {
	

	public RoleEntity createRole(RoleEntity roleEntity);
	public RoleEntity updateRole(RoleEntity roleEntity);
	public void deleteRole(RoleEntity roleEntity);
	public RoleEntity getRoleByid(UUID roleId);
	public List<RoleEntity> getRoles();
	public List<RoleEntity> getRoles(Integer startIndex, Integer maxItems);
	public long geRoleCount();

}
