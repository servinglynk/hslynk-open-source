package com.servinglynk.hmis.warehouse.model.v2014;

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
@Table(name="hmis_permission_set_acl")
public class PermissionSetAclEntity extends BaseModel{
	
    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	private UUID id;

	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="api_method_id")
	private ApiMethodEntity apiMethod;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="permission_set_id")
	private PermissionSetEntity permissionSet;
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	

	public ApiMethodEntity getApiMethod() {
		return apiMethod;
	}
	public void setApiMethod(ApiMethodEntity apiMethod) {
		this.apiMethod = apiMethod;
	}
	

	public PermissionSetEntity getPermissionSet() {
		return permissionSet;
	}
	public void setPermissionSet(PermissionSetEntity permissionSet) {
		this.permissionSet = permissionSet;
	}
	
	
	

}
