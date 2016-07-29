package com.servinglynk.hmis.warehouse.core.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName("bulkUploadError")
public class BulkUploadError {
    public UUID model_id;
    public Long bulk_upload_ui;
    public String project_group_code;
    public String table_name;
    public String source_system_id;
    public String type;
    public String error_description;
    public LocalDateTime date_created;
	public UUID getModel_id() {
		return model_id;
	}
	public void setModel_id(UUID model_id) {
		this.model_id = model_id;
	}
	public Long getBulk_upload_ui() {
		return bulk_upload_ui;
	}
	public void setBulk_upload_ui(Long bulk_upload_ui) {
		this.bulk_upload_ui = bulk_upload_ui;
	}
	public String getProject_group_code() {
		return project_group_code;
	}
	public void setProject_group_code(String project_group_code) {
		this.project_group_code = project_group_code;
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public String getSource_system_id() {
		return source_system_id;
	}
	public void setSource_system_id(String source_system_id) {
		this.source_system_id = source_system_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getError_description() {
		return error_description;
	}
	public void setError_description(String error_description) {
		this.error_description = error_description;
	}
	public LocalDateTime getDate_created() {
		return date_created;
	}
	public void setDate_created(LocalDateTime date_created) {
		this.date_created = date_created;
	}
    
    
}
