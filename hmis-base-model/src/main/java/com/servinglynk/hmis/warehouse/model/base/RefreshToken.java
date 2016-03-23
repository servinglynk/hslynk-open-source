package com.servinglynk.hmis.warehouse.model.base;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@SuppressWarnings("serial")
@Entity
@Table(name = "hmis_refresh_token",schema="base")
public class RefreshToken extends BaseModel {

    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	private UUID id;

	@Column(name = "token")
	private String token;

	@Column(name = "auth_code")
	private String authCode;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable=false, referencedColumnName="id")
	private HmisUser account;

	@ManyToOne
	@JoinColumn(name = "trustedApp_id", nullable=false, referencedColumnName="id")
	private TrustedAppEntity trustedApp;



	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	public HmisUser getAccount() {
		return account;
	}
	public void setAccount(HmisUser account) {
		this.account = account;
	}
	public TrustedAppEntity getTrustedApp() {
		return trustedApp;
	}
	public void setTrustedApp(TrustedAppEntity trustedApp) {
		this.trustedApp = trustedApp;
	}
}
