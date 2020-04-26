package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	@JsonIgnore
	private String clientTypeId;
	
	@JsonIgnore
	List<UUID> sharedClients = new ArrayList<UUID>();
	@JsonIgnore
	List<UUID> sharedEnrollments = new ArrayList<UUID>();
	
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

	public List<UUID> getSharedClients() {
		return sharedClients;
	}

	public void setSharedClients(List<UUID> sharedClients) {
		this.sharedClients = sharedClients;
	}

	public List<UUID> getSharedEnrollments() {
		return sharedEnrollments;
	}

	public void setSharedEnrollments(List<UUID> sharedEnrollments) {
		this.sharedEnrollments = sharedEnrollments;
	}

	public String getClientTypeId() {
		return clientTypeId;
	}

	public void setClientTypeId(String clientTypeId) {
		this.clientTypeId = clientTypeId;
	}
}
