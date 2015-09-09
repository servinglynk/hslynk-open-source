package com.servinglynk.hmis.warehouse.core.model;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("refreshToken")
public class RefreshToken {

	private String token;

	private Date createdAt;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
