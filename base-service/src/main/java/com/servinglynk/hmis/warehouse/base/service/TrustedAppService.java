package com.servinglynk.hmis.warehouse.base.service;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.ApiMethodAuthorizationCheck;
import com.servinglynk.hmis.warehouse.core.model.ProjectGroup;
import com.servinglynk.hmis.warehouse.core.model.ProjectGroups;
import com.servinglynk.hmis.warehouse.core.model.RedirectUri;
import com.servinglynk.hmis.warehouse.core.model.TrustedApp;
import com.servinglynk.hmis.warehouse.core.model.TrustedAppStatus;
import com.servinglynk.hmis.warehouse.core.model.TrustedApps;

public interface TrustedAppService {

	
	public TrustedApp updateTrustedAppInfoForDevelopers(TrustedApp trustedApp, String requestingUsername, String caller);
	public void deleteTrustedAppForDevelopers(String trustedAppId, String requestingUsername, String caller);
	public String regenerateTrustedAppSecret(String externalTrustedAppId, String requestingUsername, String caller);
	public TrustedAppStatus processApprovalSubmission(String trustedAppId,TrustedAppStatus trustedAppStatus, Account requestingAccount,String requestingService);
	public TrustedAppStatus processApprovalDecision(String trustedAppId,TrustedAppStatus trustedAppStatus, Account requestingAccount,String requestingService);
	public TrustedApp createTrustedAppForDevelopers(TrustedApp trustedApp, String serviceExternalId, String requestingUsername, String caller);
	public List<TrustedApp> getTrustedAppsUsingService(String externalServiceId, String requestingUsername, String caller);
	public TrustedApp getTrustedAppInfoForDevelopers(String trustedAppId, String requestingUsername, String caller);
	public void registerRedirectUris(String trustedAppId, List<RedirectUri> redirectUris, String requestingUsername, String caller);
	public List<RedirectUri> getRedirectUris(String trustedAppId, String requestingUsername, String caller);
	public TrustedApp authenticateTrustedAppId(String trustedAppId,
			String trustedAppSecret);
	public ApiMethodAuthorizationCheck checkApiAuthorization(
			ApiMethodAuthorizationCheck apiAuthCheck, String userService);
	public List<TrustedApp> getAuthorizedTrustedApps(String username,
			String userService);
	
	public TrustedApp getBasicTrustedAppInfo(String trustedAppId,String caller);
	
	
	void addProjectGroupToTrustedApp(String trustedAppId, ProjectGroup projectGroup);
	
	void deleteProjectGroupToTrustedApp(String trustedAppId, UUID projectgroupid);
	public ProjectGroups getTrustedAppProjectGroups(String trustedAppId);
	public TrustedApps getTrustedApps();
}
