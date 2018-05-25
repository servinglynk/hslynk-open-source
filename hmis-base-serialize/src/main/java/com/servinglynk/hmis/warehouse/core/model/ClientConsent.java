package com.servinglynk.hmis.warehouse.core.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.servinglynk.hmis.warehouse.annotations.AllowedValues;

@JsonRootName("consent")
public class ClientConsent extends ClientModel {
	
	@JsonProperty("consentId")
	private UUID id;
	private UUID clientId;
	
	@AllowedValues(values={"APPROVED","REJECTED"},message="Allowed values for status value are APPROVED,REJECTED")
	private String status;

	private Date startTime;
	private Date endTime;
	
	private String consentDocumentLink;
	private String entityGroup;
	
	private String consentGroupId;
	
//	private GlobalProjects globalProjects=new GlobalProjects();
	
	private List<GlobalProject> globalProjects = new ArrayList<GlobalProject>();
	
	private UUID consentUserId;
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getConsentDocumentLink() {
		return consentDocumentLink;
	}
	public void setConsentDocumentLink(String consentDocumentLink) {
		this.consentDocumentLink = consentDocumentLink;
	}
	public String getEntityGroup() {
		return entityGroup;
	}
	public void setEntityGroup(String entityGroup) {
		this.entityGroup = entityGroup;
	}
	public UUID getConsentUserId() {
		return consentUserId;
	}
	public void setConsentUserId(UUID consentUserId) {
		this.consentUserId = consentUserId;
	}
	/*public GlobalProjects getGlobalProjects() {
		return globalProjects;
	}
	public void setGlobalProjects(GlobalProjects globalProjects) {
		this.globalProjects = globalProjects;
	}*/
	public List<GlobalProject> getGlobalProjects() {
		return globalProjects;
	}
	public void setGlobalProjects(List<GlobalProject> globalProjects) {
		this.globalProjects = globalProjects;
	}
	
	public void addGlobalProject(GlobalProject globalProject) {
		this.globalProjects.add(globalProject);
	}
	public String getConsentGroupId() {
		return consentGroupId;
	}
	public void setConsentGroupId(String consentGroupId) {
		this.consentGroupId = consentGroupId;
	}
}