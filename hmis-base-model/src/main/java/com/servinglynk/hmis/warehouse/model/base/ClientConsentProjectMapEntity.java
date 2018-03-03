package com.servinglynk.hmis.warehouse.model.base;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name="client_consent_project",catalog="hmis",schema="base")
public class ClientConsentProjectMapEntity extends HMISModel {
	

	private UUID id;
	
	private GlobalProjectEntity globalProject;
	

	private ClientConsentEntity clientConsent;
	
	@Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	

	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "global_project_id", referencedColumnName="id", nullable = false )
	public GlobalProjectEntity getGlobalProject() {
		return globalProject;
	}
	public void setGlobalProject(GlobalProjectEntity globalProject) {
		this.globalProject = globalProject;
	}
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "client_consent_id", referencedColumnName="id", nullable = false )
	public ClientConsentEntity getClientConsent() {
		return clientConsent;
	}
	public void setClientConsent(ClientConsentEntity clientConsent) {
		this.clientConsent = clientConsent;
	}
}