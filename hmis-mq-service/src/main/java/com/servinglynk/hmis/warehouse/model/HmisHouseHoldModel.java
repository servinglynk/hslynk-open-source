package com.servinglynk.hmis.warehouse.model;

import java.util.UUID;

public class HmisHouseHoldModel {
	
	private UUID hmisHouseHoldId;
	private UUID clientId;
	private UUID dedupClientId;
	private Boolean deleted;
	private String projectGroupCode;
	private UUID userId;
	private String sourceSystemId;
	private String sourceSystemHouseHoldId;
	private String schema;
	private UUID genericHouseHoldId;
	
	public UUID getClientId() {
		return clientId;
	}
	public void setClientId(UUID clientId) {
		this.clientId = clientId;
	}
	public UUID getDedupClientId() {
		return dedupClientId;
	}
	public void setDedupClientId(UUID dedupClientId) {
		this.dedupClientId = dedupClientId;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	public String getProjectGroupCode() {
		return projectGroupCode;
	}
	public void setProjectGroupCode(String projectGroupCode) {
		this.projectGroupCode = projectGroupCode;
	}
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public String getSourceSystemId() {
		return sourceSystemId;
	}
	public void setSourceSystemId(String sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
	}
	public String getSourceSystemHouseHoldId() {
		return sourceSystemHouseHoldId;
	}
	public void setSourceSystemHouseHoldId(String sourceSystemHouseHoldId) {
		this.sourceSystemHouseHoldId = sourceSystemHouseHoldId;
	}
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}
	public UUID getHmisHouseHoldId() {
		return hmisHouseHoldId;
	}
	public void setHmisHouseHoldId(UUID hmisHouseHoldId) {
		this.hmisHouseHoldId = hmisHouseHoldId;
	}
	public UUID getGenericHouseHoldId() {
		return genericHouseHoldId;
	}
	public void setGenericHouseHoldId(UUID genericHouseHoldId) {
		this.genericHouseHoldId = genericHouseHoldId;
	}
}