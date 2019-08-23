package com.servinglynk.hmis.warehouse.model.base;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="client_metadata",schema="base")
public class ClientMetaDataEntity {

	private UUID id;
	private UUID clientId;
	private UUID clientDedupId;
	private UUID metaDataIdentifier;
	private String additionalInfo;
	private LocalDateTime date;
	private String type;
	protected String projectGroupCode;
	private boolean deleted;
	protected LocalDateTime dateCreated = LocalDateTime.now();
	protected LocalDateTime dateUpdated = LocalDateTime.now();
	private UUID userId;

	@Id
	@Column(name="id")
	 @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	@Column(name="client_id")
	 @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public UUID getClientId() {
		return clientId;
	}

	public void setClientId(UUID clientId) {
		this.clientId = clientId;
	}

	@Column(name="client_dedup_id")
	 @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public UUID getClientDedupId() {
		return clientDedupId;
	}

	public void setClientDedupId(UUID clientDedupId) {
		this.clientDedupId = clientDedupId;
	}

	@Column(name="metadata_identitifer")
	 @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public UUID getMetaDataIdentifier() {
		return metaDataIdentifier;
	}

	public void setMetaDataIdentifier(UUID metaDataIdentifier) {
		this.metaDataIdentifier = metaDataIdentifier;
	}

	@Column(name="additional_info")
	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	@Column(name="date")
	@Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Column(name="type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

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