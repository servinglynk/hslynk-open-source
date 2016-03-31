package com.servinglynk.hmis.warehouse.model.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.proxy.HibernateProxy;


@Entity
@Table(name = "hmis_user",schema="base")
public class HmisUser  {


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
	

    private VerificationEntity verification;
	
	
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
	
	private AccountPreferenceEntity accountPreference;

	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL,optional=true)
	@JoinColumn(name="id")
	public AccountPreferenceEntity getAccountPreference() {
		return this.accountPreference;
	}
	
	public void setAccountPreference(AccountPreferenceEntity accountPreference) {
		this.accountPreference = accountPreference;
	}
	

	private AccountLockoutEntity accountLockout;

	@OneToOne( mappedBy = "account", cascade = CascadeType.ALL,optional=true)
	@JoinColumn(name="id")
	public AccountLockoutEntity getAccountLockout() {
		return this.accountLockout;
	}
	
	public void setAccountLockout(AccountLockoutEntity accountLockout) {
		this.accountLockout = accountLockout;
	}

	@ManyToOne(optional = true,fetch = FetchType.LAZY)
	@JoinColumn(name = "verification_id", nullable = true, referencedColumnName = "id")
	public VerificationEntity getVerification() {
		return verification;
	}

	public void setVerification(VerificationEntity verification) {
		this.verification = verification;
	}

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
	

    private ProfileEntity profileEntity;

	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="profile_id")
    public ProfileEntity getProfileEntity() {
		return profileEntity;
	}

	public void setProfileEntity(ProfileEntity profileEntity) {
		this.profileEntity = profileEntity;
	}
	

	private List<UserPermissionSetAclEntity> userPermissionSetAcls=new ArrayList<UserPermissionSetAclEntity>();

	@OneToMany(fetch=FetchType.LAZY, mappedBy="account")
	public List<UserPermissionSetAclEntity> getUserPermissionSetAcls() {
		return userPermissionSetAcls;
	}

	public void setUserPermissionSetAcls(List<UserPermissionSetAclEntity> userPermissionSetAcls) {
		this.userPermissionSetAcls = userPermissionSetAcls;
	}
	

	private OrganizationEntity organization;

	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="organization_id")
	public OrganizationEntity getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationEntity organization) {
		this.organization = organization;
	}

	@Column(name="email_address")
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	

	private ProjectGroupEntity projectGroupEntity;

	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="project_group_id")
	public ProjectGroupEntity getProjectGroupEntity() {
		return projectGroupEntity;
	}

	public void setProjectGroupEntity(ProjectGroupEntity projectGroupEntity) {
		this.projectGroupEntity = projectGroupEntity;
	}
	
	
	
		
	
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return HmisUser.class;
	}
	
	   /**
	    * Deep copy.
		* @return cloned object
		* @throws CloneNotSupportedException on error
	    */
	    @Override
	    public HmisUser clone() throws CloneNotSupportedException {
			
	        final HmisUser copy = (HmisUser)super.clone();

			copy.setCreatedAt(this.getCreatedAt());
			copy.setModifiedAt(this.getModifiedAt());
//			copy.setGender(this.getGender());
			copy.setId(this.getId());
			copy.setLastName(this.getLastName());
			copy.setMiddleName(this.getMiddleName());
			copy.setNameSuffix(this.getNameSuffix());
			return copy;
		}
		


		/** Provides toString implementation.
		 * @see java.lang.Object#toString()
		 * @return String representation of this class.
		 */
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			
			sb.append("dateCreated: " + this.getCreatedAt() + ", ");
			sb.append("dateUpdated: " + this.getModifiedAt() + ", ");
			sb.append("dob: " + this.getDob() + ", ");
			sb.append("firstName: " + this.getFirstName() + ", ");
			//sb.append("gender: " + this.getGender() + ", ");
			sb.append("id: " + this.getId() + ", ");
			sb.append("lastName: " + this.getLastName() + ", ");
			sb.append("middleName: " + this.getMiddleName() + ", ");
			sb.append("nameSuffix: " + this.getNameSuffix() + ", ");
			return sb.toString();		
		}


		/** Equals implementation. 
		 * @see java.lang.Object#equals(java.lang.Object)
		 * @param aThat Object to compare with
		 * @return true/false
		 */
		@Override
		public boolean equals(final Object aThat) {
			Object proxyThat = aThat;
			
			if ( this == aThat ) {
				 return true;
			}

			
			if (aThat instanceof HibernateProxy) {
	 			// narrow down the proxy to the class we are dealing with.
	 			try {
					proxyThat = ((HibernateProxy) aThat).getHibernateLazyInitializer().getImplementation(); 
				} catch (org.hibernate.ObjectNotFoundException e) {
					return false;
			   	}
			}
			if (aThat == null)  {
				 return false;
			}
			
			final HmisUser that; 
			try {
				that = (HmisUser) proxyThat;
				if ( !(that.getClassType().equals(this.getClassType()))){
					return false;
				}
			} catch (org.hibernate.ObjectNotFoundException e) {
					return false;
			} catch (ClassCastException e) {
					return false;
			}
			
			
			boolean result = true;
			result = result && (((this.getId() == null) && ( that.getId() == null)) || (this.getId() != null  && this.getId().equals(that.getId())));
			result = result && (((getCreatedAt() == null) && (that.getCreatedAt() == null)) || (getCreatedAt() != null && getCreatedAt().equals(that.getCreatedAt())));
			result = result && (((getModifiedAt() == null) && (that.getModifiedAt() == null)) || (getModifiedAt() != null && getModifiedAt().equals(that.getModifiedAt())));
			result = result && (((getDob() == null) && (that.getDob() == null)) || (getDob() != null && getDob().equals(that.getDob())));
			result = result && (((getFirstName() == null) && (that.getFirstName() == null)) || (getFirstName() != null && getFirstName().equals(that.getFirstName())));
//			result = result && (((getGender() == null) && (that.getGender() == null)) || (getGender() != null && getGender().equals(that.getGender())));
			result = result && (((getLastName() == null) && (that.getLastName() == null)) || (getLastName() != null && getLastName().equals(that.getLastName())));
			result = result && (((getMiddleName() == null) && (that.getMiddleName() == null)) || (getMiddleName() != null && getMiddleName().equals(that.getMiddleName())));
			result = result && (((getNameSuffix() == null) && (that.getNameSuffix() == null)) || (getNameSuffix() != null && getNameSuffix().equals(that.getNameSuffix())));
			return result;
		}		
}