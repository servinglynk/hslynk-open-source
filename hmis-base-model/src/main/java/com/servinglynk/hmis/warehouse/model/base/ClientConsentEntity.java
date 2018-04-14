package com.servinglynk.hmis.warehouse.model.base;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="CLIENT_CONSENT",catalog="hmis",schema="base")
public class ClientConsentEntity extends HMISModel {


	private UUID id;
	

	private UUID clientId;
	

	private LocalDateTime startTime;
	

	private LocalDateTime endTime;
	

	private String status;
	

	private UUID consentDocument;
	

	private List<ClientConsentProjectMapEntity> consentProjects;
	
	@Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "ID")
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	@Column(name="CLIENT_ID")
    @org.hibernate.annotations.Type(type="pg-uuid")
	public UUID getClientId() {
		return clientId;
	}
	public void setClientId(UUID clientId) {
		this.clientId = clientId;
	}
	
	@Column(name="START_TIME")
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	
	@Column(name="END_TIME")
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name="CLIENT_CONSENT_DOCUMENT")
    @org.hibernate.annotations.Type(type="pg-uuid")
	public UUID getConsentDocument() {
		return consentDocument;
	}
	public void setConsentDocument(UUID consentDocument) {
		this.consentDocument = consentDocument;
	}
		
	@OneToMany(mappedBy="clientConsent")
	public List<ClientConsentProjectMapEntity> getConsentProjects() {
		return consentProjects;
	}
	public void setConsentProjects(List<ClientConsentProjectMapEntity> consentProjects) {
		this.consentProjects = consentProjects;
	}	
}