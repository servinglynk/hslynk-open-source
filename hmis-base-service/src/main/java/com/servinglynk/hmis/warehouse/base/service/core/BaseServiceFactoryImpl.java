package com.servinglynk.hmis.warehouse.base.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.base.service.APIAccessService;
import com.servinglynk.hmis.warehouse.base.service.AccountService;
import com.servinglynk.hmis.warehouse.base.service.ApiMethodService;
import com.servinglynk.hmis.warehouse.base.service.AuthorizationService;
import com.servinglynk.hmis.warehouse.base.service.BulkUploadService;
import com.servinglynk.hmis.warehouse.base.service.ClientConsentService;
import com.servinglynk.hmis.warehouse.base.service.ClientDataElementsService;
import com.servinglynk.hmis.warehouse.base.service.DeveloperCompanyService;
import com.servinglynk.hmis.warehouse.base.service.GenericEnrollmentService;
import com.servinglynk.hmis.warehouse.base.service.GlobalEnrollmentService;
import com.servinglynk.hmis.warehouse.base.service.GlobalHouseHoldService;
import com.servinglynk.hmis.warehouse.base.service.GlobalProjectService;
import com.servinglynk.hmis.warehouse.base.service.HealthService;
import com.servinglynk.hmis.warehouse.base.service.PasswordResetService;
import com.servinglynk.hmis.warehouse.base.service.PermissionSetService;
import com.servinglynk.hmis.warehouse.base.service.ProfileService;
import com.servinglynk.hmis.warehouse.base.service.ProjectGroupService;
import com.servinglynk.hmis.warehouse.base.service.RoleService;
import com.servinglynk.hmis.warehouse.base.service.SearchService;
import com.servinglynk.hmis.warehouse.base.service.SessionService;
import com.servinglynk.hmis.warehouse.base.service.TrustedAppService;
import com.servinglynk.hmis.warehouse.base.service.UsernameChangeService;
import com.servinglynk.hmis.warehouse.base.service.VerificationService;
import com.servinglynk.hmis.warehouse.base.service.impl.HMISNotificationsService;

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

	
	@Autowired private HealthService healthService;
	
	@Autowired private ClientConsentService clientConsentService;
	@Autowired private ClientDataElementsService clientDataElementsService;
	@Autowired private APIAccessService apiAccessService;
	@Autowired private HMISNotificationsService hmisNotificationsService;
	
	@Autowired private GlobalEnrollmentService globalEnrollmentService;
	
	@Autowired private GlobalProjectService globalProjectService;
	
	@Autowired private GenericEnrollmentService genericEnrollmentService;
	
	@Autowired private GlobalHouseHoldService globalHouseHoldService;
	
	
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

	public HealthService getHealthService() {
		return healthService;
	}

	public void setHealthService(HealthService healthService) {
		this.healthService = healthService;
	}

	public ClientConsentService getClientConsentService() {
		return clientConsentService;
	}

	public void setClientConsentService(ClientConsentService clientConsentService) {
		this.clientConsentService = clientConsentService;
	}

	public ClientDataElementsService getClientDataElementsService() {
		return clientDataElementsService;
	}

	public void setClientDataElementsService(ClientDataElementsService clientDataElementsService) {
		this.clientDataElementsService = clientDataElementsService;
	}

	public APIAccessService getApiAccessService() {
		return apiAccessService;
	}

	public void setApiAccessService(APIAccessService apiAccessService) {
		this.apiAccessService = apiAccessService;
	}

	public HMISNotificationsService getHmisNotificationsService() {
		return hmisNotificationsService;
	}

	public void setHmisNotificationsService(HMISNotificationsService hmisNotificationsService) {
		this.hmisNotificationsService = hmisNotificationsService;
	}

	public GlobalEnrollmentService getGlobalEnrollmentService() {
		return globalEnrollmentService;
	}

	public void setGlobalEnrollmentService(GlobalEnrollmentService globalEnrollmentService) {
		this.globalEnrollmentService = globalEnrollmentService;
	}

	public GlobalProjectService getGlobalProjectService() {
		return globalProjectService;
	}

	public void setGlobalProjectService(GlobalProjectService globalProjectService) {
		this.globalProjectService = globalProjectService;
	}

	public GenericEnrollmentService getGenericEnrollmentService() {
		return genericEnrollmentService;
	}

	public void setGenericEnrollmentService(GenericEnrollmentService genericEnrollmentService) {
		this.genericEnrollmentService = genericEnrollmentService;
	}

	public GlobalHouseHoldService getGlobalHouseHoldService() {
		return globalHouseHoldService;
	}

	public void setGlobalHouseHoldService(GlobalHouseHoldService globalHouseHoldService) {
		this.globalHouseHoldService = globalHouseHoldService;
	}	
}