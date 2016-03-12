package com.servinglynk.hmis.warehouse.model.v2014;

import java.util.Date;
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
@Table(name = "hmis_account_consent")
public class AccountConsentEntity extends BaseModel {

    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable=false, referencedColumnName="id")
	private HmisUser account;

	@ManyToOne
	@JoinColumn(name = "trustedApp_id", nullable=false, referencedColumnName="id")
	private TrustedAppEntity trustedApp;

	@Column(name = "consent_token")
	private String consentToken;

	@Column(name = "consented")
	private Boolean consented;

	@Column(name = "consented_at")
	protected Date consentedAt;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
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
	public String getConsentToken() {
		return consentToken;
	}
	public void setConsentToken(String consentToken) {
		this.consentToken = consentToken;
	}
	public Boolean isConsented() {
		return consented;
	}
	public void setConsented(Boolean consented) {
		this.consented = consented;
	}
	public Date getConsentedAt() {
		return consentedAt;
	}
	public void setConsentedAt(Date consentedAt) {
		this.consentedAt = consentedAt;
	}
}
