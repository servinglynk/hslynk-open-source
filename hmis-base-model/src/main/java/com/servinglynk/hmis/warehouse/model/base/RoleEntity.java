package com.servinglynk.hmis.warehouse.model.base;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name = "hmis_role",schema="base")
public class RoleEntity  extends BaseModel {
	
    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	protected UUID id;
    
	@Column(name="role_name")
	protected String roleName;
	
	@Column(name="role_description")
	protected String roleDescription;
	
	@Column(name="role_code")
	protected String roleCode;
	
	@ManyToOne
	@JoinColumn(name = "parent_role_id", referencedColumnName="id")
	private RoleEntity parentRoleEntity;
	
	@Column(name="role_level")
	private Integer roleLevel;
	
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

	public RoleEntity getParentRoleEntity() {
		return parentRoleEntity;
	}

	public void setParentRoleEntity(RoleEntity parentRoleEntity) {
		this.parentRoleEntity = parentRoleEntity;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public Integer getRoleLevel() {
		return roleLevel;
	}

	public void setRoleLevel(Integer roleLevel) {
		this.roleLevel = roleLevel;
	}
}