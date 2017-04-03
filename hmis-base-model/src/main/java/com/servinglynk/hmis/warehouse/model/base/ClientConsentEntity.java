package com.servinglynk.hmis.warehouse.model.base;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@SuppressWarnings("serial")
@Entity
@Table(name="CLIENT_CONSENT",catalog="hmis",schema="base")
public class ClientConsentEntity extends BaseModel {

	@Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "ID")
	private UUID id;
	
	@Column(name="CLIENT_ID")
    @org.hibernate.annotations.Type(type="pg-uuid")
	private UUID clientId;
	
	@Column(name="START_TIME")
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	private LocalDateTime startTime;
	
	@Column(name="END_TIME")
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	private LocalDateTime endTime;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="CONSENT_DOCUMENT")
	private String consentDocument;
	
	@Column(name="deleted")
	private boolean deleted;
	
	@Column(name="consent_project_group")
	private String consentProjectGroup;
		
	@Column(name="consent_user_id")
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	private UUID consentUserId;
		
	@Column(name="entity_group")
	private String entityGroup;
	
	@Column(name="project_group_code")
	private String projectGroupCode;
	
	@Column(name="user_id")
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
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
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getConsentDocument() {
		return consentDocument;
	}
	public void setConsentDocument(String consentDocument) {
		this.consentDocument = consentDocument;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
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
	public String getEntityGroup() {
		return entityGroup;
	}
	public void setEntityGroup(String entityGroup) {
		this.entityGroup = entityGroup;
	}
	public String getConsentProjectGroup() {
		return consentProjectGroup;
	}
	public void setConsentProjectGroup(String consentProjectGroup) {
		this.consentProjectGroup = consentProjectGroup;
	}
	public UUID getConsentUserId() {
		return consentUserId;
	}
	public void setConsentUserId(UUID consentUserId) {
		this.consentUserId = consentUserId;
	}	
}