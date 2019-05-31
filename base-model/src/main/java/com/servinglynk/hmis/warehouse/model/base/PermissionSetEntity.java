package com.servinglynk.hmis.warehouse.model.base;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@SuppressWarnings("serial")
@Entity
@Table(name="hmis_permission_set",schema="base")
public class PermissionSetEntity extends BaseModel {
	
    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	private UUID id;
    
    @Column(name="permission_set_name")    
    private String permissionSetName;
    
    @Column(name="permission_set_description")    
    private String permissionSetDescription;
    
	@OneToMany(fetch=FetchType.LAZY, mappedBy="permissionSet")
    private List<UserPermissionSetAclEntity> userPermissionSetAcls = new ArrayList<UserPermissionSetAclEntity>();
	

	@OneToMany(fetch=FetchType.LAZY, mappedBy="permissionSet")
    private List<PermissionSetAclEntity> permissionSetAcls = new ArrayList<PermissionSetAclEntity>();
     
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	

	public String getPermissionSetName() {
		return permissionSetName;
	}
	public void setPermissionSetName(String permissionSetName) {
		this.permissionSetName = permissionSetName;
	}
	
	
	
	public String getPermissionSetDescription() {
		return permissionSetDescription;
	}
	public void setPermissionSetDescription(String permissionSetDescription) {
		this.permissionSetDescription = permissionSetDescription;
	}
	public List<UserPermissionSetAclEntity> getUserPermissionSetAcls() {
		return userPermissionSetAcls;
	}
	public void setUserPermissionSetAcls(List<UserPermissionSetAclEntity> userPermissionSetAcls) {
		this.userPermissionSetAcls = userPermissionSetAcls;
	}
	


	public List<PermissionSetAclEntity> getPermissionSetAcls() {
		return permissionSetAcls;
	}
	public void setPermissionSetAcls(List<PermissionSetAclEntity> permissionSetAcls) {
		this.permissionSetAcls = permissionSetAcls;
	}
	
	     
}
