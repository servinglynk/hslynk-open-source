package com.servinglynk.hmis.warehouse.model.base;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * Model class representing an Session.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "hmis_trusted_app",schema="base")
public class TrustedAppEntity extends BaseModel {

    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	private UUID id;

	@Column(name = "friendly_name")
	private String friendlyname;

	@Column(name = "external_id")
	private String externalId;

	@Column(name = "description")
	private String description;
	
	 
	@Column(name = "publish_status")
	private String publishStatus;
	
	@Column(name = "version")
	private String version;
	
	@Column(name = "download_url")
	private String downloadUrl;
	
	@Column(name = "last_released_at")
	private Date lastReleasedAt;

	@Column(name = "expiration_time")
	private Integer expirationTime;
	
	@Column(name = "trustedapp_secret")
	private String trustedAppSecret;

	@Column(name = "trustedapp_family_type")
	private String trustedAppFamilyType;

	@Column(name = "trustedapp_profile_type")
	private String trustedAppProfileType;

	@Column(name = "refresh_token_supported")
	private Boolean refreshTokenSupported;

	@Column(name = "implicit_grant_supported")
	private Boolean implicitGrantSupported;

	@Column(name = "auth_code_grant_supported")
	private Boolean authCodeGrantSupported;

	@Column(name = "is_internal")
	private Boolean internal;
	
	@Column(name = "api_method_check_required")
	private Boolean apiMethodCheckRequired;

	@Column(name = "account_consent_type")
	private String accountConsentType;

	@ManyToOne
	@JoinColumn(name = "container_trustedApp_id", referencedColumnName="id")
	private TrustedAppEntity containerTrustedApp;

	@Column(name = "container_access_token_allowed")
	private Boolean containerAccessTokenAllowed;

	@Column(name = "logo_url")
	private String logoUrl;

    @Column(name = "notification_callback_url")
	private String notificationCallbackUrl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_id", referencedColumnName="id")
	private DeveloperServiceEntity service;



	@OneToMany(mappedBy = "containerTrustedApp")
	private List<TrustedAppEntity> subTrustedApps;

	@OneToMany(mappedBy = "trustedApp")
	private List<RedirectUriEntity> redirectUris;

	@OneToMany(mappedBy = "trustedApp")
	private List<RefreshToken> refreshTokens;
	
	
	@Column(name="status")
	private String status;
	

	
	
	public void setId(UUID id) {
		this.id = id;
	}


	public UUID getId() {
		return this.id;
	}

	public String getFriendlyname() {
		return friendlyname;
	}

	public void setFriendlyname(String friendlyname) {
		this.friendlyname = friendlyname;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Integer time) {
		expirationTime = time;
	}
	
	public String getTrustedAppSecret() {
		return trustedAppSecret;
	}
	public void setTrustedAppSecret(String trustedAppSecret) {
		this.trustedAppSecret = trustedAppSecret;
	}
	
	public String getTrustedAppFamilyType() {
		return trustedAppFamilyType;
	}
	public void setTrustedAppFamilyType(String trustedAppFamilyType) {
		this.trustedAppFamilyType = trustedAppFamilyType;
	}
	
	public String getTrustedAppProfileType() {
		return trustedAppProfileType;
	}
	public void setTrustedAppProfileType(String trustedAppProfileType) {
		this.trustedAppProfileType = trustedAppProfileType;
	}
	
	public Boolean isRefreshTokenSupported() {
		return refreshTokenSupported;
	}
	public void setRefreshTokenSupported(Boolean refreshTokenSupported) {
		this.refreshTokenSupported = refreshTokenSupported;
	}
	
	public Boolean isImplicitGrantSupported() {
		return implicitGrantSupported;
	}
	public void setImplicitGrantSupported(Boolean implicitGrantSupported) {
		this.implicitGrantSupported = implicitGrantSupported;
	}
	
	public Boolean isAuthCodeGrantSupported() {
		return authCodeGrantSupported;
	}
	public void setAuthCodeGrantSupported(Boolean authCodeGrantSupported) {
		this.authCodeGrantSupported = authCodeGrantSupported;
	}
	
	public Boolean isInternal() {
		return internal;
	}
	public void setInternal(Boolean internal) {
		this.internal = internal;
	}

	public Boolean isApiMethodCheckRequired() {
		return apiMethodCheckRequired;
	}
	public void setApiMethodCheckRequired(Boolean apiMethodCheckRequired) {
		this.apiMethodCheckRequired = apiMethodCheckRequired;
	}
	
	public String getAccountConsentType() {
		return accountConsentType;
	}
	public void setAccountConsentType(String accountConsentType) {
		this.accountConsentType = accountConsentType;
	}
	
	public TrustedAppEntity getContainerTrustedApp() {
		return containerTrustedApp;
	}
	public void setContainerTrustedApp(TrustedAppEntity containerTrustedApp) {
		this.containerTrustedApp = containerTrustedApp;
	}
	
	public Boolean isContainerAccessTokenAllowed() {
		return containerAccessTokenAllowed;
	}
	public void setContainerAccessTokenAllowed(Boolean containerAccessTokenAllowed) {
		this.containerAccessTokenAllowed = containerAccessTokenAllowed;
	}
	
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	
	public DeveloperServiceEntity getService() {
		return service;
	}
	public void setService(DeveloperServiceEntity service) {
		this.service = service;
	}
	
	
	
	public List<TrustedAppEntity> getSubTrustedApps() {
		return subTrustedApps;
	}
	public void setSubTrustedApps(List<TrustedAppEntity> subTrustedApps) {
		this.subTrustedApps = subTrustedApps;
	}
	
	
	
    public String getNotificationCallbackUrl() {
        return notificationCallbackUrl;
    }
	public String getPublishStatus() {
		return publishStatus;
	}

	public void setPublishStatus(String publishStatus) {
		this.publishStatus = publishStatus;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public Date getLastReleasedAt() {
		return lastReleasedAt;
	}

	public void setLastReleasedAt(Date lastReleasedAt) {
		this.lastReleasedAt = lastReleasedAt;
	}

    public void setNotificationCallbackUrl(String notificationCallbackUrl) {
        this.notificationCallbackUrl = notificationCallbackUrl;
    }

	public List<RedirectUriEntity> getRedirectUris() {
		return redirectUris;
	}

	public void setRedirectUris(List<RedirectUriEntity> redirectUris) {
		this.redirectUris = redirectUris;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    
    
    
    
}
