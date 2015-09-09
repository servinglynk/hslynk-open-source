package com.servinglynk.hmis.warehouse.core.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("role")
public class Role extends ClientModel {

	private UUID id;
    private String roleName;
	private String roleDescription;
	
	@JsonProperty("parentRole")
	private Role parentRole;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	public Role getParentRole() {
		return parentRole;
	}
	public void setParentRole(Role parentRole) {
		this.parentRole = parentRole;
	}

}