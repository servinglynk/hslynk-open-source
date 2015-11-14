package com.servinglynk.hmis.warehouse.model.live;

import static com.servinglynk.hmis.warehouse.common.GeneralUtil.getUniqueToken;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * Model class representing a session.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "hmis_session")
public class SessionEntity extends BaseModel {

    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	private UUID id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
	private HmisUser account;

	@Column(name = "session_token")
	private String sessionToken;

	@Column(name = "expires_at")
	private Date expiresAt;

	@ManyToOne(optional = false,fetch=FetchType.LAZY)
	@JoinColumn(name = "trustedApp_id", nullable = false, referencedColumnName = "id")
	private TrustedAppEntity trustedApp;

	@Column(name = "auth_code")
	private String authCode;

	@Column(name = "auth_code_expires_at")
	private Date authCodeExpiresAt;

	@Column(name = "redirect_uri")
	private String redirectUri;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "refresh_token_id", referencedColumnName="id")
	private RefreshToken refreshToken;
	

	public UUID getId() {
		return this.id;
	}

	protected void setId(UUID id) {
		this.id = id;
	}

	public HmisUser getAccount() {
		return this.account;
	}

	public void setAccount(HmisUser account) {
		this.account = account;
	}

	public String getSessionToken() {
		return sessionToken;
	}

	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}

	public Date getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}

	public TrustedAppEntity getTrustedApp() {
		return this.trustedApp;
	}

	public void setTrustedApp(TrustedAppEntity trustedApp) {
		this.trustedApp = trustedApp;
	}

	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	
	public Date getAuthCodeExpiresAt() {
		return authCodeExpiresAt;
	}
	public void setAuthCodeExpiresAt(Date authCodeExpiresAt) {
		this.authCodeExpiresAt = authCodeExpiresAt;
	}
	
	public String getRedirectUri() {
		return redirectUri;
	}
	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}
	
	public RefreshToken getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(RefreshToken refreshToken) {
		this.refreshToken = refreshToken;
	}
	
	public static String generateSessionToken() {
		return getUniqueToken(64);
	}
}
