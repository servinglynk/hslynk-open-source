package com.servinglynk.hmis.warehouse.model.base;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@SuppressWarnings("serial")
@Entity
@Table(name = "hmis_api_group",schema="base")
public class ApiGroupEntity extends BaseModel {

    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	private UUID id;

	@Column(name = "external_id", nullable=false)
	private String externalId;

	@Column(name = "friendly_name")
	private String friendlyName;

	@Column(name = "description")
	private String description;

	@Column(name = "authorization_msg")
	private String authorizationMsg;

	@Column(name = "group_sequence")
	private Long groupSequence;

	@ManyToOne
	@JoinColumn(name = "consent_message_id", referencedColumnName="id")
	private ConsentMessage consentMessage;

	@ManyToOne
	@JoinColumn(name = "detailed_consent_message_id", referencedColumnName="id")
	private ConsentMessage detailConsentMessage;
	
	@OneToMany(mappedBy = "apiGroup")
	private List<ApiMethodEntity> apiMethods;

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getExternalId() {
		return externalId;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	public String getFriendlyName() {
		return friendlyName;
	}
	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthorizationMsg() {
		return authorizationMsg;
	}
	public void setAuthorizationMsg(String authorizationMsg) {
		this.authorizationMsg = authorizationMsg;
	}
	public Long getGroupSequence() {
		return groupSequence;
	}
	public void setGroupSequence(Long groupSequence) {
		this.groupSequence = groupSequence;
	}
	public List<ApiMethodEntity> getApiMethods() {
		return apiMethods;
	}
	public void setApiMethods(List<ApiMethodEntity> apiMethods) {
		this.apiMethods = apiMethods;
	}
	public ConsentMessage getConsentMessage() {
		return consentMessage;
	}
	public void setConsentMessage(ConsentMessage consentMessage) {
		this.consentMessage = consentMessage;
	}
	public ConsentMessage getDetailConsentMessage() {
		return detailConsentMessage;
	}
	public void setDetailConsentMessage(ConsentMessage detailConsentMessage) {
		this.detailConsentMessage = detailConsentMessage;
	}
}
