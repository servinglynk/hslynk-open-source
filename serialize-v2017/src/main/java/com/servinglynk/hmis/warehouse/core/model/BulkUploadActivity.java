package com.servinglynk.hmis.warehouse.core.model;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("bulkUploadActivity")
public class BulkUploadActivity extends ClientModel {

	private String tableName;
	private Long recordsProcessed;
	private Long inserted;
	private Long updated;
	private String description;
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public Long getRecordsProcessed() {
		return recordsProcessed;
	}
	public void setRecordsProcessed(Long recordsProcessed) {
		this.recordsProcessed = recordsProcessed;
	}
	public Long getInserted() {
		return inserted;
	}
	public void setInserted(Long inserted) {
		this.inserted = inserted;
	}
	public Long getUpdated() {
		return updated;
	}
	public void setUpdated(Long updated) {
		this.updated = updated;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
