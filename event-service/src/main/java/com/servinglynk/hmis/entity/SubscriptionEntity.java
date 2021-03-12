package com.servinglynk.hmis.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "subscription" , schema = "base")
public class SubscriptionEntity extends BaseEntity {

	@Id
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	  @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	private UUID id;
	
	@Column(name = "resource_type")
	private String resourceType;
	
	@Column(name = "criteria_url")	
	private String criteriaUrl;
	
	@Column(name = "criteria")
	private String criteria;
	
	@Column(name = "reason")
	private String reason;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "channel_type")
	private String channelType;
	
	@Column(name = "channel_endpoint")
	private String channelEndpoint;
	
	@Column(name = "channel_payload")
	private String channelPayload;
	
	@Column(name = "channel_header")
	private String channelHeader;
	
    @OneToMany(mappedBy = "subscription", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<SubscriptionContactEntity> contactEntities = new ArrayList<SubscriptionContactEntity>();
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public String getCriteria() {
		return criteria;
	}
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getChannelType() {
		return channelType;
	}
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	public String getChannelEndpoint() {
		return channelEndpoint;
	}
	public void setChannelEndpoint(String channelEndpoint) {
		this.channelEndpoint = channelEndpoint;
	}
	public String getChannelPayload() {
		return channelPayload;
	}
	public void setChannelPayload(String channelPayload) {
		this.channelPayload = channelPayload;
	}
	public String getChannelHeader() {
		return channelHeader;
	}
	public void setChannelHeader(String channelHeader) {
		this.channelHeader = channelHeader;
	}
	public List<SubscriptionContactEntity> getContactEntities() {
		if(this.contactEntities == null) this.contactEntities = new ArrayList<SubscriptionContactEntity>();
		return contactEntities;
	}
	public void setContactEntities(List<SubscriptionContactEntity> contactEntities) {
		this.contactEntities = contactEntities;
	}
	public String getCriteriaUrl() {
		return criteriaUrl;
	}
	public void setCriteriaUrl(String criteriaUrl) {
		this.criteriaUrl = criteriaUrl;
	}
}