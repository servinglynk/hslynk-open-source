package com.servinglynk.hmis.warehouse.model;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Affiliation {
	@Column(name="id")		
	private UUID id;
	@Column(name="projectid")
	private UUID projectid;
	@Column(name="resprojectid")
	private UUID resprojectid;
	@Column(name="date_created")
	private Date date_created;
	@Column(name="date_updated")
	private Date date_updated;
	@Column(name="user_id")			
	private UUID user_id;
	@Column(name="export_id")
	private UUID export_id;
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
	 * @return the projectid
	 */
	public UUID getProjectid() {
		return projectid;
	}
	/**
	 * @param projectid the projectid to set
	 */
	public void setProjectid(UUID projectid) {
		this.projectid = projectid;
	}
	/**
	 * @return the resprojectid
	 */
	public UUID getResprojectid() {
		return resprojectid;
	}
	/**
	 * @param resprojectid the resprojectid to set
	 */
	public void setResprojectid(UUID resprojectid) {
		this.resprojectid = resprojectid;
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
