package com.servinglynk.hmis.warehouse.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;

@MappedSuperclass
public class HMISModel {
	protected String projectGroupCode;
	private boolean deleted;
	protected LocalDateTime dateCreated = LocalDateTime.now();
	protected LocalDateTime dateUpdated = LocalDateTime.now();
	private UUID userId;
	
	

	@Column(name = "project_group_code")
	public String getProjectGroupCode() {
		return projectGroupCode;
	}

	public void setProjectGroupCode(String projectGroupCode) {
		this.projectGroupCode = projectGroupCode;
	}

	@Column(name = "deleted")
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic(optional = true)
	@Column(name = "date_created")
	public LocalDateTime getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(final LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic(optional = true)
	@Column(name = "date_updated")
	public LocalDateTime getDateUpdated() {
		return this.dateUpdated;
	}

	public void setDateUpdated(final LocalDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	@Column(name="user_id")
	 @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}
}
