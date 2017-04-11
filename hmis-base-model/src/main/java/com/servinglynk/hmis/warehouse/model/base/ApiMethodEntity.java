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
@Table(name = "hmis_api_method",schema="base")
public class ApiMethodEntity extends BaseModel {

    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	private UUID id;

	@Column(name = "external_id")
	private String externalId;

	@Column(name = "friendly_name")
	private String friendlyName;

	@Column(name = "description")
	private String description;

	@Column(name = "type", nullable=false)
	private String type;

	@Column(name = "account_consent_msg")
	private String accountConsentMsg;

	@Column(name = "account_consent_msg_order")
	private Long accountConsentMsgOrder;
	                
	@Column(name = "requires_access_token")
	private Boolean requiresAccessToken;

	@Column(name = "is_public")
	private Boolean publicMethod;
	
	@Column(name="requires_check_trustedApp")
	private Boolean requiresCheckTrustedApp;
	
	@OneToMany(mappedBy = "apiMethod")
	private List<ServiceApiMethodEntity> serviceApiMethodList;

	@ManyToOne
	@JoinColumn(name = "api_group_id", referencedColumnName="id")
	private ApiGroupEntity apiGroup;

	@ManyToOne
	@JoinColumn(name = "consent_message_id", referencedColumnName="id")
	private ConsentMessage consentMessage;

	@ManyToOne
	@JoinColumn(name = "detailed_consent_message_id", referencedColumnName="id")
	private ConsentMessage detailConsentMessage;
	
	@Column(name="client_consent_required")
	private boolean clientConsentRequired;
	
	@Column(name="client_consent_group")
	private String clientConsentGroup;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAccountConsentMsg() {
		return accountConsentMsg;
	}
	public void setAccountConsentMsg(String accountConsentMsg) {
		this.accountConsentMsg = accountConsentMsg;
	}
	public Long getAccountConsentMsgOrder() {
		return accountConsentMsgOrder;
	}
	public void setAccountConsentMsgOrder(Long accountConsentMsgOrder) {
		this.accountConsentMsgOrder = accountConsentMsgOrder;
	}
	public List<ServiceApiMethodEntity> getServiceApiMethodList() {
		return serviceApiMethodList;
	}
	public void setServiceApiMethodList(List<ServiceApiMethodEntity> serviceApiMethodList) {
		this.serviceApiMethodList = serviceApiMethodList;
	}
	public ApiGroupEntity getApiGroup() {
		return apiGroup;
	}
	public void setApiGroup(ApiGroupEntity apiGroup) {
		this.apiGroup = apiGroup;
	}
	public Boolean getRequiresAccessToken() {
		return requiresAccessToken;
	}
	public void setRequiresAccessToken(Boolean requiresAccessToken) {
		this.requiresAccessToken = requiresAccessToken;
	}
	public Boolean isPublicMethod()	{
		return this.publicMethod;
	}
	public void setPublicMethod(boolean publicMethod)	{
		this.publicMethod = publicMethod;
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
	
	public void initializeExternalId() {
		this.externalId = getNewGuid();
	}
	public Boolean getRequiresCheckTrustedApp() {
		return requiresCheckTrustedApp;
	}
	public void setRequiresCheckTrustedApp(Boolean requiresCheckTrustedApp) {
		this.requiresCheckTrustedApp = requiresCheckTrustedApp;
	}
	public boolean isClientConsentRequired() {
		return clientConsentRequired;
	}
	public void setClientConsentRequired(boolean clientConsentRequired) {
		this.clientConsentRequired = clientConsentRequired;
	}
	public String getClientConsentGroup() {
		return clientConsentGroup;
	}
	public void setClientConsentGroup(String clientConsentGroup) {
		this.clientConsentGroup = clientConsentGroup;
	}	
}
