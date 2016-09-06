package com.servinglynk.hmis.warehouse.core.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("passwordChange")
public class PasswordChange  extends ClientModel {

	@NotBlank
	private String currentPassword;
	
	@NotBlank
	@Length(min=8,message="new password length required to be at least 8 characters")
	private String newPassword;
	
	@NotBlank
	@Length(min=8,message="confirm new password length required to be at least 8 characters")
	private String confirmNewPassword;

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}

	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}
}