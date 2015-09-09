package com.servinglynk.hmis.warehouse.core.model;

import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("usernameChange")
public class UsernameChange extends ClientModel{

	private String currentPassword;

	private String newUsername;

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewUsername() {
		return newUsername;
	}

	public void setNewUsername(String newUsername) {
		this.newUsername = newUsername;
	}
	
	

}
