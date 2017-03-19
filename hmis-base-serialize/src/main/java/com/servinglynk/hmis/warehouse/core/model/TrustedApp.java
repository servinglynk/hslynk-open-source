package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("trustedApp")
public class TrustedApp  extends ClientModel {

	private String trustedAppId;
	private String friendlyName;
	private String description;
	private String status;
	private String logoUrl;
	private DeveloperService service;
	private AccountConsent accountConsent;
	private Integer expirationTime;
	private String trustedAppSecret;

	private String trustedAppFamilyType;
	private String trustedAppProfileType;

	private Boolean refreshTokenSupported;
	private Boolean implicitGrantSupported;
	private Boolean authCodeGrantSupported;

	private Boolean internal;
	private Boolean apiMethodCheckRequired;
	private String accountConsentType;


	// additional fields to track the status of the Trusted App
	private String publishStatus;
	private Date lastReleasedAt;
	private String downloadUrl;
	private String version;
	

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public DeveloperService getService() {
		return service;
	}

	public void setService(DeveloperService service) {
		this.service = service;
	}

	public AccountConsent getAccountConsent() {
		return accountConsent;
	}

	public void setAccountConsent(AccountConsent accountConsent) {
		this.accountConsent = accountConsent;
	}

	public Integer getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Integer expirationTime) {
		this.expirationTime = expirationTime;
	}

	public String getTrustedAppSecret() {
		return trustedAppSecret;
	}

	public void setTrustedAppSecret(String trustedAppSecret) {
		this.trustedAppSecret = trustedAppSecret;
	}

	public String getTrustedAppId() {
		return trustedAppId;
	}

	public void setTrustedAppId(String trustedAppId) {
		this.trustedAppId = trustedAppId;
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

	public Boolean getRefreshTokenSupported() {
		return refreshTokenSupported;
	}

	public void setRefreshTokenSupported(Boolean refreshTokenSupported) {
		this.refreshTokenSupported = refreshTokenSupported;
	}

	public Boolean getImplicitGrantSupported() {
		return implicitGrantSupported;
	}

	public void setImplicitGrantSupported(Boolean implicitGrantSupported) {
		this.implicitGrantSupported = implicitGrantSupported;
	}

	public Boolean getAuthCodeGrantSupported() {
		return authCodeGrantSupported;
	}

	public void setAuthCodeGrantSupported(Boolean authCodeGrantSupported) {
		this.authCodeGrantSupported = authCodeGrantSupported;
	}

	public Boolean getInternal() {
		return internal;
	}

	public void setInternal(Boolean internal) {
		this.internal = internal;
	}

	public Boolean getApiMethodCheckRequired() {
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

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	
	public String getPublishStatus() {
		return publishStatus;
	}

	public void setPublishStatus(String publishStatus) {
		this.publishStatus = publishStatus;
	}

	public Date getLastReleasedAt() {
		return lastReleasedAt;
	}

	public void setLastReleasedAt(Date lastReleasedAt) {
		this.lastReleasedAt = lastReleasedAt;
	}

	private String notificationCallbackUrl;
	
	public String getNotificationCallbackUrl() {
		return notificationCallbackUrl;
	}

	public void setNotificationCallbackUrl(String notificationCallbackUrl) {
		this.notificationCallbackUrl = notificationCallbackUrl;
	}
	
	
	private ArrayList<RefreshToken> refreshTokens;
	
	public ArrayList<RefreshToken> getRefreshTokens() {
		return refreshTokens;
	}

	public void setRefreshTokens(ArrayList<RefreshToken> refreshTokens) {
		this.refreshTokens = refreshTokens;
	}

	private List<Session> accessTokens;
	
	public List<Session> getAccessTokens() {
		return accessTokens;
	}

	public void setAccessTokens(List<Session> accessTokens) {
		this.accessTokens = accessTokens;
	}	
	
}

