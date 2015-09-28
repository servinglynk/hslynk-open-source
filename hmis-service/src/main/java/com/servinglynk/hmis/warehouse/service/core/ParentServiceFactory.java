package com.servinglynk.hmis.warehouse.service.core;

import com.servinglynk.hmis.warehouse.service.AccountService;
import com.servinglynk.hmis.warehouse.service.ApiMethodService;
import com.servinglynk.hmis.warehouse.service.AuthorizationService;
import com.servinglynk.hmis.warehouse.service.ClientService;
import com.servinglynk.hmis.warehouse.service.DeveloperCompanyService;
import com.servinglynk.hmis.warehouse.service.EmploymentService;
import com.servinglynk.hmis.warehouse.service.EnrollmentService;
import com.servinglynk.hmis.warehouse.service.ExitService;
import com.servinglynk.hmis.warehouse.service.InformationReleasesService;
import com.servinglynk.hmis.warehouse.service.OrganizationService;
import com.servinglynk.hmis.warehouse.service.PasswordResetService;
import com.servinglynk.hmis.warehouse.service.PermissionSetService;
import com.servinglynk.hmis.warehouse.service.ProfileService;
import com.servinglynk.hmis.warehouse.service.ProjectService;
import com.servinglynk.hmis.warehouse.service.RoleService;
import com.servinglynk.hmis.warehouse.service.SessionService;
import com.servinglynk.hmis.warehouse.service.SharingRuleService;
import com.servinglynk.hmis.warehouse.service.TrustedAppService;
import com.servinglynk.hmis.warehouse.service.UsernameChangeService;
import com.servinglynk.hmis.warehouse.service.VerificationService;



public interface ParentServiceFactory {
	
	HmisUserService getHmisUserService();
	SyncListService getSyncListService();
	DeveloperCompanyService getDeveloperCompanyService();
	TrustedAppService getTrustedAppService();
	AccountService getAccountService();
	AuthorizationService getAuthorizationService();
	SessionService getSessionService();
	VerificationService getVerificationService();
	PasswordResetService getPasswordResetService();
	
	UsernameChangeService getUsernameChangeService();
	ApiMethodService getApiMethodService();
	RoleService getRoleService();
	ProfileService getProfileService();
	PermissionSetService getPermissionSetService();
	SharingRuleService getSharingRuleService();
	EnrollmentService getEnrollmentService();
	InformationReleasesService getInformationReleasesService();
	ClientService getClientService();
	OrganizationService getOrganizationService();
	ProjectService getProjectService();
	ExitService getExitService();
	EmploymentService getEmploymentService();
}
