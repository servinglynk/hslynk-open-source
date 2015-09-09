package com.servinglynk.hmis.warehouse.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name="hmis_user_permission_set_acl")
public class UserPermissionSetAclEntity extends BaseModel{

    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")	
	private UUID id;
    
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
	private AccountEntity account;

	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="profile_id")
	private ProfileEntity profile;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="role_id")
	private RoleEntity role;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="permission_set_id")
	private PermissionSetEntity permissionSet;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public AccountEntity getAccount() {
		return account;
	}
	public void setAccount(AccountEntity account) {
		this.account = account;
	}
	public PermissionSetEntity getPermissionSet() {
		return permissionSet;
	}
	public void setPermissionSet(PermissionSetEntity permissionSet) {
		this.permissionSet = permissionSet;
	}
	public ProfileEntity getProfile() {
		return profile;
	}
	public void setProfile(ProfileEntity profile) {
		this.profile = profile;
	}
	public RoleEntity getRole() {
		return role;
	}
	public void setRole(RoleEntity role) {
		this.role = role;
	}		
}