package com.servinglynk.hmis.warehouse.client.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("session")
public class Session extends ClientModel {

	private Account account;
	private Long requestedTimeToLive;
	private String token;
	private String authCode;
	private Date createdAt;
	private Date modifiedAt;
	private Date expiresAt;
	private int nextAction;
	
	private String passwordEncrypted;
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Long getRequestedTimeToLive() {
		return requestedTimeToLive;
	}

	public void setRequestedTimeToLive(Long requestedTimeToLive) {
		this.requestedTimeToLive = requestedTimeToLive;
	}
	
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

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public Date getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}
	public String getPasswordEncrypted() {
		return passwordEncrypted;
	}

	public void setPasswordEncrypted(String isEncrypted) {
		this.passwordEncrypted = isEncrypted;
	}

	public int getNextAction() {
		return nextAction;
	}

	public void setNextAction(int nextAction) {
		this.nextAction = nextAction;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
}
