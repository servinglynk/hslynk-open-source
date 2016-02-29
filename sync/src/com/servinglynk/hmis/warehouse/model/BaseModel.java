package com.servinglynk.hmis.warehouse.model;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
public class BaseModel {
	@Column(name="id")			
	public UUID id;
	@Column(name="date_created")
	public Timestamp date_created;
	@Column(name="date_updated")
	public Timestamp date_updated;
	@Column(name="date_created_from_source")
	public Timestamp date_created_from_source;
	@Column(name="date_updated_from_source")
	public Timestamp date_updated_from_source;
	@Column(name="user_id")			
	public UUID user_id;
	@Column(name="export_id")
	public UUID export_id;
	@Column(name="deleted")
	public boolean deleted;
	@Column(name="project_group_code")
	public String project_group_code;
	
	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}
	
	public Timestamp getDate_created() {
		return date_created;
	}
	public void setDate_created(Timestamp date_created) {
		this.date_created = date_created;
	}
	public Timestamp getDate_updated() {
		return date_updated;
	}
	public void setDate_updated(Timestamp date_updated) {
		this.date_updated = date_updated;
	}
	/**
	 * @return the user_id
	 */
	public UUID getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(UUID user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the export_id
	 */
	public UUID getExport_id() {
		return export_id;
	}
	/**
	 * @param export_id the export_id to set
	 */
	public void setExport_id(UUID export_id) {
		this.export_id = export_id;
	}
	public String getProject_group_code() {
		return project_group_code;
	}
	public void setProject_group_code(String project_group_code) {
		this.project_group_code = project_group_code;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public Timestamp getDate_created_from_source() {
		return date_created_from_source;
	}
	public void setDate_created_from_source(Timestamp date_created_from_source) {
		this.date_created_from_source = date_created_from_source;
	}
	public Timestamp getDate_updated_from_source() {
		return date_updated_from_source;
	}
	public void setDate_updated_from_source(Timestamp date_updated_from_source) {
		this.date_updated_from_source = date_updated_from_source;
	}
	
}
