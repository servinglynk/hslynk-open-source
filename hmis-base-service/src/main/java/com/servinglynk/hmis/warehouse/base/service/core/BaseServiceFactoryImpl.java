package com.servinglynk.hmis.warehouse.base.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.base.service.AccountService;
import com.servinglynk.hmis.warehouse.base.service.ApiMethodService;
import com.servinglynk.hmis.warehouse.base.service.AuthorizationService;
import com.servinglynk.hmis.warehouse.base.service.BulkUploadService;
import com.servinglynk.hmis.warehouse.base.service.DeveloperCompanyService;
import com.servinglynk.hmis.warehouse.base.service.HealthService;
import com.servinglynk.hmis.warehouse.base.service.PasswordResetService;
import com.servinglynk.hmis.warehouse.base.service.PermissionSetService;
import com.servinglynk.hmis.warehouse.base.service.ProfileService;
import com.servinglynk.hmis.warehouse.base.service.ProjectGroupService;
import com.servinglynk.hmis.warehouse.base.service.ProjectService;
import com.servinglynk.hmis.warehouse.base.service.RoleService;
import com.servinglynk.hmis.warehouse.base.service.SearchService;
import com.servinglynk.hmis.warehouse.base.service.SessionService;
import com.servinglynk.hmis.warehouse.base.service.TrustedAppService;
import com.servinglynk.hmis.warehouse.base.service.UsernameChangeService;
import com.servinglynk.hmis.warehouse.base.service.VerificationService;

@Component
public class BaseServiceFactoryImpl  implements BaseServiceFactory {

	@Autowired
	private DeveloperCompanyService developerCompanyService;
	
	@Autowired
	private TrustedAppService trustedAppService;

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AuthorizationService authorizationService;
	
	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private VerificationService verificationService;
	
	@Autowired
	private PasswordResetService passwordResetService;
	
	@Autowired
	private UsernameChangeService usernameChangeService;
	
	
	@Autowired
	private ApiMethodService apiMethodService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private PermissionSetService permissionSetService;
	
	@Autowired
	private BulkUploadService bulkUploadService;
	
	@Autowired
	private SearchService baseSearchService;
	
	@Autowired
	private ProjectService baseProjectService;
	
	@Autowired private HealthService healthService;
	

	public DeveloperCompanyService getDeveloperCompanyService() {
		return developerCompanyService;
	}

	public void setDeveloperCompanyService(
			DeveloperCompanyService developerCompanyService) {
		this.developerCompanyService = developerCompanyService;
	}

	public TrustedAppService getTrustedAppService() {
		return trustedAppService;
	}

	public void setTrustedAppService(TrustedAppService trustedAppService) {
		this.trustedAppService = trustedAppService;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public AuthorizationService getAuthorizationService() {
		return authorizationService;
	}

	public void setAuthorizationService(AuthorizationService authorizationService) {
		this.authorizationService = authorizationService;
	}

	public SessionService getSessionService() {
		return sessionService;
	}

	public void setSessionService(SessionService sessionService) {
		this.sessionService = sessionService;
	}

	public VerificationService getVerificationService() {
		return verificationService;
	}

	public void setVerificationService(VerificationService verificationService) {
		this.verificationService = verificationService;
	}

	public PasswordResetService getPasswordResetService() {
		return passwordResetService;
	}

	public void setPasswordResetService(PasswordResetService passwordResetService) {
		this.passwordResetService = passwordResetService;
	}

	public UsernameChangeService getUsernameChangeService() {
		return usernameChangeService;
	}

	public void setUsernameChangeService(UsernameChangeService usernameChangeService) {
		this.usernameChangeService = usernameChangeService;
	}

	public ApiMethodService getApiMethodService() {
		return apiMethodService;
	}

	public void setApiMethodService(ApiMethodService apiMethodService) {
		this.apiMethodService = apiMethodService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public PermissionSetService getPermissionSetService() {
		return permissionSetService;
	}

	public void setPermissionSetService(PermissionSetService permissionSetService) {
		this.permissionSetService = permissionSetService;
	}
	
	@Autowired ProjectGroupService projectGroupService;


	public ProjectGroupService getProjectGroupService() {
		return projectGroupService;
	}

	public void setProjectGroupService(ProjectGroupService projectGroupService) {
		this.projectGroupService = projectGroupService;
	}
	public BulkUploadService getBulkUploadService() {
		return bulkUploadService;
	}

	public void setBulkUploadService(BulkUploadService bulkUploadService) {
		this.bulkUploadService = bulkUploadService;
	}

	public SearchService getBaseSearchService() {
		return baseSearchService;
	}

	public void setBaseSearchService(SearchService baseSearchService) {
		this.baseSearchService = baseSearchService;
	}

	public ProjectService getBaseProjectService() {
		return baseProjectService;
	}

	public void setBaseProjectService(ProjectService baseProjectService) {
		this.baseProjectService = baseProjectService;
	}

	public HealthService getHealthService() {
		return healthService;
	}

	public void setHealthService(HealthService healthService) {
		this.healthService = healthService;
	}
}