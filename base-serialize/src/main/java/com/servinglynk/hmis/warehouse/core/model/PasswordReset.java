package com.servinglynk.hmis.warehouse.core.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("passwordReset")
public class PasswordReset extends ClientModel {

	private String password;
    
    private Date createdAt;
    

    private Date modifiedAt;
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

