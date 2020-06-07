package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("profile")
public class Profile  extends ClientModel {

	private UUID profileId;
	private String profileName;
	private String profileDescription;
	private Integer profileLevel;
	private List<ApiMethod> apiMethods=new ArrayList<ApiMethod>();	
	public UUID getId() {
		return profileId;
	}
	public void setId(UUID id) {
		this.profileId = id;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getProfileDescription() {
		return profileDescription;
	}
	public void setProfileDescription(String profileDescription) {
		this.profileDescription = profileDescription;
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
	public Integer getProfileLevel() {
		return profileLevel;
	}
	public void setProfileLevel(Integer profileLevel) {
		this.profileLevel = profileLevel;
	}
	
}