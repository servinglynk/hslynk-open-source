package com.servinglynk.hmis.warehouse.core.model;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.common.Constants;

@JsonRootName("passwordChange")
public class PasswordChange  extends ClientModel {

	@NotBlank
	private String currentPassword;
	
	@NotBlank
	@Pattern(regexp=Constants.PASSWORD_REG_EXP,message="The password must contain 8 to 16 characters long, It must contain at least one lowercase character, one uppercase character, one number, and one of the following special characters !@#$*")
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