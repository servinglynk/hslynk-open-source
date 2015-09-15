package com.servinglynk.hmis.warehouse.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.service.AccountService;
import com.servinglynk.hmis.warehouse.service.ApiMethodService;
import com.servinglynk.hmis.warehouse.service.AuthorizationService;
import com.servinglynk.hmis.warehouse.service.DeveloperCompanyService;
import com.servinglynk.hmis.warehouse.service.EnrollmentService;
import com.servinglynk.hmis.warehouse.service.InformationReleasesService;
import com.servinglynk.hmis.warehouse.service.PasswordResetService;
import com.servinglynk.hmis.warehouse.service.PermissionSetService;
import com.servinglynk.hmis.warehouse.service.ProfileService;
import com.servinglynk.hmis.warehouse.service.RoleService;
import com.servinglynk.hmis.warehouse.service.SessionService;
import com.servinglynk.hmis.warehouse.service.SharingRuleService;
import com.servinglynk.hmis.warehouse.service.TrustedAppService;
import com.servinglynk.hmis.warehouse.service.UsernameChangeService;
import com.servinglynk.hmis.warehouse.service.VerificationService;

@Component
public class ParentServiceFactoryImpl  implements ParentServiceFactory {
	
	@Autowired
	private HmisUserService hmisUserService;
	
	@Autowired
	private SyncListService syncListService;

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
	private SharingRuleService sharingRuleService;
	
	@Autowired				  
	private EnrollmentService enrollmentService;
	
	
	public HmisUserService getHmisUserService() {
		return hmisUserService;
	}

	public void setHmisUserService(HmisUserService hmisUserService) {
		this.hmisUserService = hmisUserService;
	}

	public SyncListService getSyncListService() {
		return syncListService;
	}

	public void setSyncListService(SyncListService syncListService) {
		this.syncListService = syncListService;
	}

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

	public SharingRuleService getSharingRuleService() {
		return sharingRuleService;
	}

	public void setSharingRuleService(SharingRuleService sharingRuleService) {
		this.sharingRuleService = sharingRuleService;
	}

	public EnrollmentService getEnrollmentService() {
		return enrollmentService;
	}

	public void setEnrollmentService(EnrollmentService enrollmentService) {
		this.enrollmentService = enrollmentService;
	}
	
	
	@Autowired
	private InformationReleasesService informationReleasesService;


	public InformationReleasesService getInformationReleasesService() {
		return informationReleasesService;
	}

	public void setInformationReleasesService(InformationReleasesService informationReleasesService) {
		this.informationReleasesService = informationReleasesService;
	}	
}