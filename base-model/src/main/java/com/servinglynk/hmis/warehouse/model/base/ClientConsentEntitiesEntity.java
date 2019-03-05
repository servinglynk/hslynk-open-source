package com.servinglynk.hmis.warehouse.model.base;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name="CLIENT_CONSENT_ENTITIES",schema="base",catalog="hmis")
public class ClientConsentEntitiesEntity extends BaseModel {
	
	@Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "ID")
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name = "client_consent_id")
    @org.hibernate.annotations.Type(type="pg-uuid")
	private ClientConsentEntity clientConsentEntity;
	
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "consent_type_id")
	private UUID consentTypeId;
	
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "consent_entity_id")
	private UUID consentEntityId;
	
	@Column(name="deleted")
	private boolean deleted;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}	
	public ClientConsentEntity getClientConsentEntity() {
		return clientConsentEntity;
	}
	public void setClientConsentEntity(ClientConsentEntity clientConsentEntity) {
		this.clientConsentEntity = clientConsentEntity;
	}
	public UUID getConsentTypeId() {
		return consentTypeId;
	}
	public void setConsentTypeId(UUID consentTypeId) {
		this.consentTypeId = consentTypeId;
	}
	public UUID getConsentEntityId() {
		return consentEntityId;
	}
	public void setConsentEntityId(UUID consentEntityId) {
		this.consentEntityId = consentEntityId;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}