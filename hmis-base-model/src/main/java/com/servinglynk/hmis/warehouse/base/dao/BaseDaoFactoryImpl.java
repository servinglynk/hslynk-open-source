package com.servinglynk.hmis.warehouse.base.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseDaoFactoryImpl implements BaseDaoFactory {
	@Autowired
	private HmisUserDao hmisUserDao;
	@Autowired
	private HmisOrganizationDao hmisOrganizationDao;
	@Autowired
	private ProjectGroupDao projectGroupDao;
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private VerificationDao verificationDao;
	@Autowired
	private PasswordResetDao passwordResetDao;
	@Autowired
	private AccountDataChangeDao accountDataChangeDao;
	@Autowired
	private ApiMethodDao apiMethodDao;
	@Autowired
	private DeveloperServiceDao developerServiceDao;
	@Autowired
	private TrustedAppDao trustedAppDao;
	@Autowired
	private AccountConsentDao accountConsentDao;
	@Autowired
	private SessionDao sessionDao;
	@Autowired
	private RefreshTokenDao refreshTokenDao;
	@Autowired
	private RedirectUriDao redirectUriDao;
	@Autowired
	private DeveloperCompanyAccountDao developerCompanyAccountDao;
	@Autowired
	private ServiceDao serviceDao;
	@Autowired
	private TrustedAppStatusDao trustedAppStatusDao;
	@Autowired
	private ServiceApiMethodDao serviceApiMethodDao;
	@Autowired
	private DeveloperCompanyDao developerCompanyDao;
	@Autowired
	private ServiceStatusDao serviceStatusDao;
	@Autowired
	private DeveloperCompanyStatusDao developerCompanyStatusDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private ProfileDao profileDao;
	@Autowired
	private ProfileAclDao profileAclDao;	
	@Autowired
	private PermissionSetDao permissionSetDao;
	@Autowired
	private ClientDao hmisClientDao;
	@Autowired
	private HmisBulkUploadDao hmisBulkUploadDao;
	@Autowired
	private BulkUploaderWorkerDao bulkUploaderWorkerDao;
	
	@Autowired
	private ProjectDao baseProjectDao;
	
	@Autowired private SearchDao searchDao;
	
	@Autowired private HealthDao healthDao;
	
	@Autowired private ClientConsentDao clientConsentDao;
	
	@Autowired  private ClientDataElementDao clientDataElementDao;
	
	@Autowired private APIAccessDao apiAccessDao;
	
	public HmisUserDao getHmisUserDao() {
		return hmisUserDao;
	}
	public void setHmisUserDao(HmisUserDao hmisUserDao) {
		this.hmisUserDao = hmisUserDao;
	}
	public HmisOrganizationDao getHmisOrganizationDao() {
		return hmisOrganizationDao;
	}
	public void setOrganizationDao(HmisOrganizationDao organizationDao) {
		this.hmisOrganizationDao = organizationDao;
	}
	public ProjectGroupDao getProjectGroupDao() {
		return projectGroupDao;
	}
	public void setProjectGroupDao(ProjectGroupDao projectGroupDao) {
		this.projectGroupDao = projectGroupDao;
	}
	public AccountDao getAccountDao() {
		return accountDao;
	}
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	public VerificationDao getVerificationDao() {
		return verificationDao;
	}
	public void setVerificationDao(VerificationDao verificationDao) {
		this.verificationDao = verificationDao;
	}
	public PasswordResetDao getPasswordResetDao() {
		return passwordResetDao;
	}
	public void setPasswordResetDao(PasswordResetDao passwordResetDao) {
		this.passwordResetDao = passwordResetDao;
	}
	public AccountDataChangeDao getAccountDataChangeDao() {
		return accountDataChangeDao;
	}
	public void setAccountDataChangeDao(AccountDataChangeDao accountDataChangeDao) {
		this.accountDataChangeDao = accountDataChangeDao;
	}
	public ApiMethodDao getApiMethodDao() {
		return apiMethodDao;
	}
	public void setApiMethodDao(ApiMethodDao apiMethodDao) {
		this.apiMethodDao = apiMethodDao;
	}
	public DeveloperServiceDao getDeveloperServiceDao() {
		return developerServiceDao;
	}
	public void setDeveloperServiceDao(DeveloperServiceDao developerServiceDao) {
		this.developerServiceDao = developerServiceDao;
	}
	public TrustedAppDao getTrustedAppDao() {
		return trustedAppDao;
	}
	public void setTrustedAppDao(TrustedAppDao trustedAppDao) {
		this.trustedAppDao = trustedAppDao;
	}
	public AccountConsentDao getAccountConsentDao() {
		return accountConsentDao;
	}
	public void setAccountConsentDao(AccountConsentDao accountConsentDao) {
		this.accountConsentDao = accountConsentDao;
	}
	public SessionDao getSessionDao() {
		return sessionDao;
	}
	public void setSessionDao(SessionDao sessionDao) {
		this.sessionDao = sessionDao;
	}
	public RefreshTokenDao getRefreshTokenDao() {
		return refreshTokenDao;
	}
	public void setRefreshTokenDao(RefreshTokenDao refreshTokenDao) {
		this.refreshTokenDao = refreshTokenDao;
	}
	public RedirectUriDao getRedirectUriDao() {
		return redirectUriDao;
	}
	public void setRedirectUriDao(RedirectUriDao redirectUriDao) {
		this.redirectUriDao = redirectUriDao;
	}
	public DeveloperCompanyAccountDao getDeveloperCompanyAccountDao() {
		return developerCompanyAccountDao;
	}
	public void setDeveloperCompanyAccountDao(DeveloperCompanyAccountDao developerCompanyAccountDao) {
		this.developerCompanyAccountDao = developerCompanyAccountDao;
	}
	public ServiceDao getServiceDao() {
		return serviceDao;
	}
	public void setServiceDao(ServiceDao serviceDao) {
		this.serviceDao = serviceDao;
	}
	public TrustedAppStatusDao getTrustedAppStatusDao() {
		return trustedAppStatusDao;
	}
	public void setTrustedAppStatusDao(TrustedAppStatusDao trustedAppStatusDao) {
		this.trustedAppStatusDao = trustedAppStatusDao;
	}
	public ServiceApiMethodDao getServiceApiMethodDao() {
		return serviceApiMethodDao;
	}
	public void setServiceApiMethodDao(ServiceApiMethodDao serviceApiMethodDao) {
		this.serviceApiMethodDao = serviceApiMethodDao;
	}
	public DeveloperCompanyDao getDeveloperCompanyDao() {
		return developerCompanyDao;
	}
	public void setDeveloperCompanyDao(DeveloperCompanyDao developerCompanyDao) {
		this.developerCompanyDao = developerCompanyDao;
	}
	public ServiceStatusDao getServiceStatusDao() {
		return serviceStatusDao;
	}
	public void setServiceStatusDao(ServiceStatusDao serviceStatusDao) {
		this.serviceStatusDao = serviceStatusDao;
	}
	public DeveloperCompanyStatusDao getDeveloperCompanyStatusDao() {
		return developerCompanyStatusDao;
	}
	public void setDeveloperCompanyStatusDao(DeveloperCompanyStatusDao developerCompanyStatusDao) {
		this.developerCompanyStatusDao = developerCompanyStatusDao;
	}
	public RoleDao getRoleDao() {
		return roleDao;
	}
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	public ProfileDao getProfileDao() {
		return profileDao;
	}
	public void setProfileDao(ProfileDao profileDao) {
		this.profileDao = profileDao;
	}
	public ProfileAclDao getProfileAclDao() {
		return profileAclDao;
	}
	public void setProfileAclDao(ProfileAclDao profileAclDao) {
		this.profileAclDao = profileAclDao;
	}
	public PermissionSetDao getPermissionSetDao() {
		return permissionSetDao;
	}
	public void setPermissionSetDao(PermissionSetDao permissionSetDao) {
		this.permissionSetDao = permissionSetDao;
	}
	public ClientDao getHmisClientDao() {
		return hmisClientDao;
	}
	public void setHmisClientDao(ClientDao hmisClientDao) {
		this.hmisClientDao = hmisClientDao;
	}
	public HmisBulkUploadDao getHmisBulkUploadDao() {
		return hmisBulkUploadDao;
	}
	public void setHmisBulkUploadDao(HmisBulkUploadDao hmisBulkUploadDao) {
		this.hmisBulkUploadDao = hmisBulkUploadDao;
	}
	public BulkUploaderWorkerDao getBulkUploaderWorkerDao() {
		return bulkUploaderWorkerDao;
	}
	public void setBulkUploaderWorkerDao(BulkUploaderWorkerDao bulkUploaderWorkerDao) {
		this.bulkUploaderWorkerDao = bulkUploaderWorkerDao;
	}
	public SearchDao getSearchDao() {
		return searchDao;
	}
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	public ProjectDao getBaseProjectDao() {
		return baseProjectDao;
	}
	public void setBaseProjectDao(ProjectDao projectDao) {
		this.baseProjectDao = projectDao;
	}
	public HealthDao getHealthDao() {
		return healthDao;
	}
	public void setHealthDao(HealthDao healthDao) {
		this.healthDao = healthDao;
	}
	public ClientConsentDao getClientConsentDao() {
		return clientConsentDao;
	}
	public void setClientConsentDao(ClientConsentDao clientConsentDao) {
		this.clientConsentDao = clientConsentDao;
	}
	public ClientDataElementDao getClientDataElementDao() {
		return clientDataElementDao;
	}
	public void setClientDataElementDao(ClientDataElementDao clientDataElementDao) {
		this.clientDataElementDao = clientDataElementDao;
	}
	public APIAccessDao getApiAccessDao() {
		return apiAccessDao;
	}
	public void setApiAccessDao(APIAccessDao apiAccessDao) {
		this.apiAccessDao = apiAccessDao;
	}
}