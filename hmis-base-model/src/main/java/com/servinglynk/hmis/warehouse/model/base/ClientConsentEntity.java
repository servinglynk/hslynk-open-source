package com.servinglynk.hmis.warehouse.model.base;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@Column(name="DELETED")
	private boolean deleted;
	
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "clientConsentEntity")
	private List<ClientConsentEntitiesEntity> consentEntities = new ArrayList<ClientConsentEntitiesEntity>();
	
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
	public List<ClientConsentEntitiesEntity> getConsentEntities() {
		return consentEntities;
	}
	public void setConsentEntities(List<ClientConsentEntitiesEntity> consentEntities) {
		this.consentEntities = consentEntities;
	}	
	public void addConsentEntities(ClientConsentEntitiesEntity consentEntitiesEntity){
		this.consentEntities.add(consentEntitiesEntity);
	}
}