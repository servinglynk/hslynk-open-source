package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("users")
public class GlobalProjectUsers extends ClientModel {

	@JsonProperty("users")
	private List<GlobalProjectUser> globalProjectUsers = new ArrayList<GlobalProjectUser>();

	public List<GlobalProjectUser> getGlobalProjectUsers() {
		return globalProjectUsers;
	}

	public void setGlobalProjectUsers(List<GlobalProjectUser> globalProjectUsers) {
		this.globalProjectUsers = globalProjectUsers;
	}
	
	public void addGlobalProjectUser(GlobalProjectUser user) {
		this.globalProjectUsers.add(user);
	}
}
