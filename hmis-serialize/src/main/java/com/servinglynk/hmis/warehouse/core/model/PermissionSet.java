package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("permissionSet")
public class PermissionSet extends ClientModel {
	
	private UUID id;
	private String permissionSetName;
	private String permissionSetDescription;
	
	@JsonProperty("apiMethods")
	private List<ApiMethod> apiMethods =new ArrayList<ApiMethod>();
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
	public List<ApiMethod> getApiMethods() {
		return apiMethods;
	}
	public void setApiMethods(List<ApiMethod> apiMethods) {
		this.apiMethods = apiMethods;
	}

	public void addApiMethod(ApiMethod apiMethod){
		this.apiMethods.add(apiMethod);
	}
	public String getPermissionSetDescription() {
		return permissionSetDescription;
	}
	public void setPermissionSetDescription(String permissionSetDescription) {
		this.permissionSetDescription = permissionSetDescription;
	}
	
	
	
	public static void main(String args[]){
		PermissionSet permissionSet=new PermissionSet();
		
		System.out.println("UUID Value "+permissionSet.getId());
		
		if(permissionSet.getId()==null){
			System.out.println("UUID value null");
		}
	}
	
	
}