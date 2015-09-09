package com.servinglynk.hmis.warehouse.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.core.model.Roles;

public interface RoleService {

	public Role createRole(Role role,String caller);
	public Role updateRole(Role role,String caller);
	public Role deleteRole(UUID roleId);
	public Roles getAllRoles(Integer startIndex, Integer maxItems);
}

