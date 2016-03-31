package com.servinglynk.hmis.warehouse.base.service.core;

import com.servinglynk.hmis.warehouse.base.service.AccountService;
import com.servinglynk.hmis.warehouse.base.service.ApiMethodService;
import com.servinglynk.hmis.warehouse.base.service.AuthorizationService;
import com.servinglynk.hmis.warehouse.base.service.ClientService;
import com.servinglynk.hmis.warehouse.base.service.DeveloperCompanyService;
import com.servinglynk.hmis.warehouse.base.service.PasswordResetService;
import com.servinglynk.hmis.warehouse.base.service.PermissionSetService;
import com.servinglynk.hmis.warehouse.base.service.ProfileService;
import com.servinglynk.hmis.warehouse.base.service.ProjectGroupService;
import com.servinglynk.hmis.warehouse.base.service.RoleService;
import com.servinglynk.hmis.warehouse.base.service.SessionService;
import com.servinglynk.hmis.warehouse.base.service.TrustedAppService;
import com.servinglynk.hmis.warehouse.base.service.UsernameChangeService;
import com.servinglynk.hmis.warehouse.base.service.VerificationService;



public interface BaseServiceFactory {
	
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
	ProjectGroupService getProjectGroupService();
	ClientService getClientService();
}
