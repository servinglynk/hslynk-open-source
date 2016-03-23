package com.servinglynk.hmis.warehouse.core.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("passwordChange")
public class PasswordChange  extends ClientModel {

	private String currentPassword;
	
	private String newPassword;


	private Date createdAt;


	private Date modifiedAt;
	
	public String getcurrentPassword() {
		return currentPassword;
	}

	public void setcurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	
	public String getnewPassword() {
		return newPassword;
	}

	public void setnewPasswordd(String newPassword) {
		this.newPassword = newPassword;
	}
	
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
