package com.servinglynk.hmis.warehouse.model.live;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name = "hmis_account_preference")
public class AccountPreferenceEntity extends BaseModel{

	

    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	private UUID id;
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	@OneToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name = "user_id", nullable=false, referencedColumnName="id")
	private HmisUser account;
	public HmisUser getAccount() {
		return this.account;
	}
 
	public void setAccount(HmisUser account) {
		this.account = account;
	}

	@Column(name = "iso_language_code")
	private String isoLanguageCode;
	
	@Column(name = "iso_country_code")
	private String isoCountryCode;

	@Column(name = "newsletter_opt_in")
	private Integer newsletterOptIn;

	public String getIsoLanguageCode() {
		return isoLanguageCode;
	}

	public void setIsoLanguageCode(String isoLanguageCode) {
		this.isoLanguageCode = isoLanguageCode;
	}

	public String getIsoCountryCode() {
		return isoCountryCode;
	}

	public void setIsoCountryCode(String isoCountryCode) {
		this.isoCountryCode = isoCountryCode;
	}
	
	public Integer getNewsletterOptIn() {
		return newsletterOptIn;
	}

	public void setNewsletterOptInCode(Integer newsletterOptIn) {
		this.newsletterOptIn = newsletterOptIn;
	}
	
}
