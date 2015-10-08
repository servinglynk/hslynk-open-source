package com.servinglynk.hmis.warehouse.model;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
public class BaseModel {
	@Column(name="id")			
	public UUID id;
	@Column(name="date_created")
	public Date date_created;
	@Column(name="date_updated")
	public Date date_updated;
	@Column(name="user_id")			
	public UUID user_id;
	@Column(name="export_id")
	public UUID export_id;
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
	/**
	 * @return the date_created
	 */
	public Date getDate_created() {
		return date_created;
	}
	/**
	 * @param date_created the date_created to set
	 */
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	/**
	 * @return the date_updated
	 */
	public Date getDate_updated() {
		return date_updated;
	}
	/**
	 * @param date_updated the date_updated to set
	 */
	public void setDate_updated(Date date_updated) {
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
	
}
