package com.servinglynk.hmis.warehouse.model.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "hmis_user",schema="base")
public class HmisUser {

	private java.util.UUID id;


	private String username;


	private String password;


	private String firstName;


	private String middleName;


	private String lastName;
	

	private String nameSuffix;
	

	private String ssn;
	
	private boolean twoFactorAuthentication;
	private String authenticatorSecret;
	private boolean isUserInHive;
	private String hiveUsername;
	private String hivePassword;
	
	@Column(name="authenticator_secret")
	public String getAuthenticatorSecret() {
		return authenticatorSecret;
	}

	public void setAuthenticatorSecret(String authenticatorSecret) {
		this.authenticatorSecret = authenticatorSecret;
	}

	@Column(name="two_factor_authentication")
	public boolean isTwoFactorAuthentication() {
		return twoFactorAuthentication;
	}

	public void setTwoFactorAuthentication(boolean twoFactorAuthentication) {
		this.twoFactorAuthentication = twoFactorAuthentication;
	}
	
	@Column(name="is_user_in_hive")
	public boolean isUserInHive() {
		return isUserInHive;
	}

	public void setUserInHive(boolean isUserInHive) {
		this.isUserInHive = isUserInHive;
	}
	
	private String emailAddress;

	@Column(name="status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

/*	@Column(name="gender")
	private String gender;
*/	

	private Date dob;
	

	private String status;
	
	
    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")    
	public java.util.UUID getId() {
		return id;
	}

	protected void setId(java.util.UUID id) {
		this.id = id;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username.toLowerCase();
	}
	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "middle_name")
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "hive_password")
	public String getHivePassword() {
		return hivePassword;
	}

	public void setHivePassword(String hivePassword) {
		this.hivePassword = hivePassword;
	}

	@Column(name = "hive_username")
	public String getHiveUsername() {
		return hiveUsername;
	}

	public void setHiveUsername(String hiveUsername) {
		this.hiveUsername = hiveUsername;
	}
	
/*	private AccountPreferenceEntity accountPreference;

	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL,optional=true,fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	public AccountPreferenceEntity getAccountPreference() {
		return this.accountPreference;
	}
	
	public void setAccountPreference(AccountPreferenceEntity accountPreference) {
		this.accountPreference = accountPreference;
	}
	

	private AccountLockoutEntity accountLockout;

	@OneToOne( mappedBy = "account", cascade = CascadeType.ALL,optional=true,fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	public AccountLockoutEntity getAccountLockout() {
		return this.accountLockout;
	}
	
	public void setAccountLockout(AccountLockoutEntity accountLockout) {
		this.accountLockout = accountLockout;
	}
*/

/*	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
*/	

	protected Date createdAt = new java.util.Date();
	
	

	protected Date modifiedAt;
	
	@Column(name = "date_created")
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@Column(name = "date_updated")
	public Date getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
		
	/*public  String getNewGuid() {
		return UUID.randomUUID().toString().toUpperCase();
	}*/

	@Column(name="name_suffix")
	public String getNameSuffix() {
		return nameSuffix;
	}

	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	@Column(name="dob")
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	

	protected String createdBy;
	

	protected String modifiedBy;

	@Column(name = "created_by")
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name = "modified_by")
	public String getModifiedBy() {
		return modifiedBy;
	}
	
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Column(name="ssn")
	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Column(name="email_address")
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	protected String projectGroupCode;

	@Column(name="project_group_code")
	public String getProjectGroupCode() {
		return projectGroupCode;
	}

	public void setProjectGroupCode(String projectGroupCode) {
		this.projectGroupCode = projectGroupCode;
	}


	private Date passwordExpiresAt;
	
	@Column(name="password_expires_at")	
	public Date getPasswordExpiresAt() {
		return passwordExpiresAt;
	}


	public void setPasswordExpiresAt(Date passwordExpiresAt) {
		this.passwordExpiresAt = passwordExpiresAt;
	}

	private boolean forcePasswordChange;
	
	@Column(name="force_password_change")	
	public boolean getForcePasswordChange() {
		return forcePasswordChange;
	}

	public void setForcePasswordChange(boolean forcePasswordChange) {
		this.forcePasswordChange = forcePasswordChange;
	}

}
