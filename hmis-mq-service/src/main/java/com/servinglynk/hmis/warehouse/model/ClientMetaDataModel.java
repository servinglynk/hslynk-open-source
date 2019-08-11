package com.servinglynk.hmis.warehouse.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class ClientMetaDataModel {

	private UUID id;
	private UUID clientId;
	private UUID clientDedupId;
	private UUID metaDataIdentifier;
	private String additionalInfo;
	private LocalDateTime date;
	private String type;
	protected String projectGroupCode;
	private boolean deleted;
	private UUID userId;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getClientId() {
		return clientId;
	}
	public void setClientId(UUID clientId) {
		this.clientId = clientId;
	}
	public UUID getClientDedupId() {
		return clientDedupId;
	}
	public void setClientDedupId(UUID clientDedupId) {
		this.clientDedupId = clientDedupId;
	}
	public UUID getMetaDataIdentifier() {
		return metaDataIdentifier;
	}
	public void setMetaDataIdentifier(UUID metaDataIdentifier) {
		this.metaDataIdentifier = metaDataIdentifier;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProjectGroupCode() {
		return projectGroupCode;
	}
	public void setProjectGroupCode(String projectGroupCode) {
		this.projectGroupCode = projectGroupCode;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
}