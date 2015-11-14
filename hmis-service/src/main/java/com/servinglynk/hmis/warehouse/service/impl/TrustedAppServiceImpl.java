package com.servinglynk.hmis.warehouse.service.impl;

import static com.servinglynk.hmis.warehouse.common.Constants.TRUSTEDAPP_STATUS_DISABLED;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.common.GeneralUtil;
import com.servinglynk.hmis.warehouse.common.ValidationBean;
import com.servinglynk.hmis.warehouse.common.ValidationUtil;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.ApiMethodAuthorizationCheck;
import com.servinglynk.hmis.warehouse.core.model.RedirectUri;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.TrustedApp;
import com.servinglynk.hmis.warehouse.core.model.TrustedAppStatus;
import com.servinglynk.hmis.warehouse.core.model.exception.AccessDeniedException;
import com.servinglynk.hmis.warehouse.core.model.exception.IllegalBusinessStateException;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidParameterException;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidSessionTokenException;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidTrustedAppException;
import com.servinglynk.hmis.warehouse.core.model.exception.MissingParameterException;
import com.servinglynk.hmis.warehouse.core.model.exception.TrustedAppNotFoundException;
import com.servinglynk.hmis.warehouse.model.live.AccountConsentEntity;
import com.servinglynk.hmis.warehouse.model.live.HmisUser;
import com.servinglynk.hmis.warehouse.model.live.ApiMethodEntity;
import com.servinglynk.hmis.warehouse.model.live.DeveloperServiceEntity;
import com.servinglynk.hmis.warehouse.model.live.RedirectUriEntity;
import com.servinglynk.hmis.warehouse.model.live.RefreshToken;
import com.servinglynk.hmis.warehouse.model.live.ServiceApiMethodEntity;
import com.servinglynk.hmis.warehouse.model.live.SessionEntity;
import com.servinglynk.hmis.warehouse.model.live.TrustedAppEntity;
import com.servinglynk.hmis.warehouse.model.live.TrustedAppStatusEntity;
import com.servinglynk.hmis.warehouse.service.TrustedAppService;
import com.servinglynk.hmis.warehouse.service.converter.AccountConverter;
import com.servinglynk.hmis.warehouse.service.converter.TrustedAppConverter;
import com.servinglynk.hmis.warehouse.service.converter.TrustedAppStatusConverter;
import com.servinglynk.hmis.warehouse.service.exception.AccountNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.DuplicateDataException;
import com.servinglynk.hmis.warehouse.service.exception.InvalidRedirectUriException;


public class TrustedAppServiceImpl extends ServiceBase implements TrustedAppService {
	
	@Autowired
	ValidationBean validationBean;
	
	private String awsS3LogoUploadPath;
	private String awsS3LogoDownloadDomain;
	private String awsS3UploadsPath;
	private String awsS3UploadsDownloadDomain;
	
	private void setFlags(TrustedApp trustedApp, TrustedAppEntity trustedAppEntity)	{
	
		trustedAppEntity.setApiMethodCheckRequired(true);
		
		if (Constants.TRUSTEDAPP_PROFILE_TYPE_NATIVE.equals(trustedApp.getTrustedAppProfileType()))	{
			trustedAppEntity.setAuthCodeGrantSupported(true);
			trustedAppEntity.setRefreshTokenSupported(true);
			trustedAppEntity.setImplicitGrantSupported(false);
		}
		else if (Constants.TRUSTEDAPP_PROFILE_TYPE_SERVER_SIDE_WEB_APP.equals(trustedApp.getTrustedAppProfileType()))	{
			trustedAppEntity.setAuthCodeGrantSupported(true);
			trustedAppEntity.setRefreshTokenSupported(true);
			trustedAppEntity.setImplicitGrantSupported(true);
		}
		else if (Constants.TRUSTEDAPP_PROFILE_TYPE_TRUSTEDAPP_SIDE_WEB_APP.equals(trustedApp.getTrustedAppProfileType()))	{
			trustedAppEntity.setAuthCodeGrantSupported(false);
			trustedAppEntity.setRefreshTokenSupported(false);
			trustedAppEntity.setImplicitGrantSupported(true);
		}
		else	{
			throw new InvalidParameterException("TrustedApp profile type not recognized");
		}
	}
	
	
	private String logoPath() {
		return awsS3LogoDownloadDomain + "/" + awsS3LogoUploadPath + "/";
	}
	
	
	private String trustedAppScreenShotPath(){
		return awsS3UploadsDownloadDomain + "/" + (null != awsS3UploadsPath && !awsS3UploadsPath.equals("") ? awsS3UploadsPath + "/" : "");
	}
	
	
	private TrustedAppEntity loadTrustedAppByExternalId(String trustedAppId)	{
	 TrustedAppEntity trustedAppEntity = daoFactory.getTrustedAppDao().findByExternalId(trustedAppId);
		if (trustedAppEntity == null)	{
			throw new TrustedAppNotFoundException("TrustedApp " + trustedAppId + " not found");
		}

		return trustedAppEntity;
	}
	
	
	@Transactional
	public TrustedApp updateTrustedAppInfoForDevelopers(TrustedApp trustedApp, String requestingUsername, String caller) {

		TrustedAppEntity trustedAppEntity = loadTrustedAppByExternalId(trustedApp.getTrustedAppId());

		// Check Permissions

		if (Constants.TRUSTEDAPP_STATUS_IN_DEVELOPMENT.equals(trustedAppEntity.getStatus()))	{
			if (!StringUtils.isBlank(trustedApp.getTrustedAppProfileType()))	{
				trustedAppEntity.setTrustedAppProfileType(trustedApp.getTrustedAppProfileType());
				setFlags(trustedApp, trustedAppEntity);
			}
			if (!StringUtils.isBlank(trustedApp.getFriendlyName()))	{
				trustedAppEntity.setFriendlyname(trustedApp.getFriendlyName());
			}
			if (!StringUtils.isBlank(trustedApp.getDescription()))	{
				trustedAppEntity.setDescription(trustedApp.getDescription());
			}

			if (!StringUtils.isBlank(trustedApp.getTrustedAppFamilyType()))	{
				if (!ValidationUtil.isTrustedAppFamilyTypeValid(trustedApp.getTrustedAppFamilyType()))	{
					throw new InvalidParameterException("TRustedApp family type " + trustedApp.getTrustedAppFamilyType() + " is not recognized");
				}
				trustedAppEntity.setTrustedAppFamilyType(trustedApp.getTrustedAppFamilyType());
			}
		}
		
		
		if (!StringUtils.isBlank(trustedApp.getDownloadUrl())){
			trustedAppEntity.setDownloadUrl(trustedApp.getDownloadUrl());
		}

		if (!StringUtils.isBlank(trustedApp.getPublishStatus())){
			trustedAppEntity.setPublishStatus(trustedApp.getPublishStatus());
		}
		
		if (trustedApp.getLastReleasedAt() != null){
			trustedAppEntity.setLastReleasedAt(trustedApp.getLastReleasedAt());
		}
		
		if (!StringUtils.isBlank(trustedApp.getVersion())){
			trustedAppEntity.setVersion(trustedApp.getVersion());
		}
		
		
		daoFactory.getTrustedAppDao().updateTrustedApp(trustedAppEntity);

		return TrustedAppConverter.convertToTrustedAppFull(trustedAppEntity, logoPath(), trustedAppScreenShotPath());
	}
	
	
	@Transactional
	public void deleteTrustedAppForDevelopers(String trustedAppId, String requestingUsername, String caller) {

	TrustedAppEntity trustedAppEntity = daoFactory.getTrustedAppDao().findByExternalId(trustedAppId);

	// Check Permissions

		// session tokens, refresh tokens, consents need to be deleted too
		daoFactory.getTrustedAppDao().deleteTrustedApp(trustedAppEntity);
	}
	
	
	@Transactional
	public String regenerateTrustedAppSecret(String externalTrustedAppId, String requestingUsername, String caller) {
	TrustedAppEntity trustedAppEntity = loadTrustedAppByExternalId(externalTrustedAppId);

	// Check Permissions

		trustedAppEntity.setTrustedAppSecret(GeneralUtil.getAlphaNumericGuid().toLowerCase());

		daoFactory.getTrustedAppDao().updateTrustedApp(trustedAppEntity);

		return trustedAppEntity.getTrustedAppSecret();
	}
	
	
	@Transactional
	public TrustedAppStatus processApprovalSubmission(String externalTrustedAppId,TrustedAppStatus trustedAppStatus, Account requestingAccount,String requestingService){
		TrustedAppEntity trustedAppEntity = daoFactory.getTrustedAppDao().findByExternalId(externalTrustedAppId);
		if (trustedAppEntity == null)	{
			throw new TrustedAppNotFoundException("TrustedApp " + externalTrustedAppId + " not found");
		}
		
		
		
		//check if service is submitted
		
		if(!trustedAppEntity.getService().getStatus().equalsIgnoreCase(Constants.SERVICE_STATUS_ACTIVE )){
			throw new AccessDeniedException("Can not submit app. "+trustedAppEntity.getService().getFriendlyName()+" service has not been approved");
		}
		
		
		// check Permissions

		
		//create a new trustedApp status entry also
		
		
		TrustedAppStatusEntity trustedAppStatusEntity = new com.servinglynk.hmis.warehouse.model.live.TrustedAppStatusEntity();
		trustedAppStatusEntity.setTrustedApp(trustedAppEntity);
		
		
		
		trustedAppStatusEntity = TrustedAppStatusConverter.convertToPersistentTrustedAppStatus(trustedAppStatus, trustedAppStatusEntity);
		trustedAppStatusEntity.setStatus(Constants.TRUSTEDAPP_STATUS_SUBMITTED);
		trustedAppStatusEntity.setComments(trustedAppStatus.getComment());
		trustedAppStatusEntity.setCreatedBy(requestingService);
		trustedAppStatusEntity.setCreatedAt(new Date());
		trustedAppStatusEntity.setTrustedApp(trustedAppEntity);
		daoFactory.getTrustedAppStatusDao().create(trustedAppStatusEntity);

		//update trustedApp status
		trustedAppEntity.setStatus(Constants.TRUSTEDAPP_STATUS_SUBMITTED);
		trustedAppEntity.setModifiedBy(requestingService);
		trustedAppEntity.setModifiedAt(new Date());
		daoFactory.getTrustedAppDao().updateTrustedApp(trustedAppEntity);
		
		//notify owner of the developer company
	
		TrustedAppStatusConverter.convertToPersistentTrustedAppStatus(trustedAppStatus, trustedAppStatusEntity);
		return trustedAppStatus;
	}

	@Transactional
	public TrustedAppStatus processApprovalDecision(String externalTrustedAppId,TrustedAppStatus trustedAppStatus, Account requestingAccount,String requestingService){

			// Check Permissions
		
		if(ValidationUtil.isEmpty(trustedAppStatus.getStatus()))  throw new MissingParameterException("Status is missing");

		if(!(trustedAppStatus.getStatus().equals(Constants.TRUSTEDAPP_STATUS_IN_DEVELOPMENT) || trustedAppStatus.getStatus().equals(Constants.TRUSTEDAPP_STATUS_ACTIVE)))
			throw new InvalidParameterException("Not a valid status");

		TrustedAppEntity trustedAppEntity = daoFactory.getTrustedAppDao().findByExternalId(externalTrustedAppId);
		if (trustedAppEntity == null)	{
			throw new TrustedAppNotFoundException("TrustedApp " + externalTrustedAppId + " not found");
		}

		if (!Constants.TRUSTEDAPP_STATUS_SUBMITTED.equals(trustedAppEntity.getStatus()))	{
			throw new IllegalBusinessStateException("TrustedApp status is " + trustedAppEntity.getStatus() + ", only SUBMITTED trustedApps  can be approved");
		}
		
		
		TrustedAppStatusEntity trustedAppStatusEntity = new TrustedAppStatusEntity();
		trustedAppStatusEntity.setStatus(trustedAppStatus.getStatus());
		trustedAppStatusEntity.setComments(trustedAppStatus.getComment());
		trustedAppStatusEntity.setTrustedApp(trustedAppEntity);
		trustedAppStatusEntity.setCreatedBy(requestingService);
		daoFactory.getTrustedAppStatusDao().create(trustedAppStatusEntity);

		trustedAppEntity.setStatus(trustedAppStatus.getStatus());
		trustedAppEntity.setModifiedBy(requestingService);
		trustedAppEntity.setModifiedAt(new Date());
		daoFactory.getTrustedAppDao().updateTrustedApp(trustedAppEntity);
		
		//notify owner of the developer company

		return new TrustedAppStatus();
	}
	
	
	@Transactional
	public TrustedApp createTrustedAppForDevelopers(TrustedApp trustedApp, String serviceExternalId, String requestingUsername, String caller) {

		if (StringUtils.isBlank(trustedApp.getFriendlyName()))	{
			throw new MissingParameterException("friendly name is missing");
		}

		if (StringUtils.isBlank(trustedApp.getTrustedAppProfileType()))	{
			throw new MissingParameterException("TrustedApp profile type is missing");
		}
		
		

		DeveloperServiceEntity developerServiceEntity = daoFactory.getDeveloperServiceDao().findByExternalId(serviceExternalId);
		
		// Check Permissions

		// create the Trusted App
		TrustedAppEntity trustedAppEntity = new TrustedAppEntity();

		trustedAppEntity.setStatus(Constants.TRUSTEDAPP_STATUS_IN_DEVELOPMENT);
		trustedAppEntity.setDescription(trustedApp.getDescription());
		trustedAppEntity.setFriendlyname(trustedApp.getFriendlyName());
		trustedAppEntity.setTrustedAppFamilyType(trustedApp.getTrustedAppFamilyType());
		trustedAppEntity.setTrustedAppProfileType(trustedApp.getTrustedAppProfileType());
		trustedAppEntity.setExternalId(GeneralUtil.getNewGuid());
		trustedAppEntity.setExpirationTime(3600);
		trustedAppEntity.setCreatedBy(caller);
		trustedAppEntity.setCreatedAt(new Date());
		trustedAppEntity.setTrustedAppSecret(GeneralUtil.getAlphaNumericGuid().toLowerCase());
	//	setFlags(trsutedApp, trustedAppEntity);

		// store the trustedApp
		trustedAppEntity.setService(developerServiceEntity);
		daoFactory.getTrustedAppDao().create(trustedAppEntity);

		trustedApp = TrustedAppConverter.convertToTrustedAppFull(trustedAppEntity, logoPath(), trustedAppScreenShotPath());
		
		trustedApp.setTrustedAppId(trustedAppEntity.getExternalId());

		return trustedApp;
	}
	
	@Transactional
	public List<TrustedApp> getTrustedAppsUsingService(String externalServiceId, String requestingUsername, String caller) {

		DeveloperServiceEntity pService = daoFactory.getDeveloperServiceDao().findByExternalId(externalServiceId);
		
		List<TrustedAppEntity> trustedApps = pService.getTrustedApps();
		List<TrustedApp> trustedApps2 = new ArrayList<TrustedApp>();

		for(TrustedAppEntity trustedAppEntity : trustedApps)	{
			TrustedApp trustedApp = TrustedAppConverter.convertToTrustedAppFull(trustedAppEntity, logoPath(), trustedAppScreenShotPath());
			trustedApps2.add(trustedApp);
		}

		logger.debug("returning {} trustedApps for service {}", trustedApps2.size(), externalServiceId);

		return trustedApps2;
	}
	
	@Transactional
	public TrustedApp getTrustedAppInfoForDevelopers(String trustedAppId, String requestingUsername, String caller) {

		TrustedAppEntity trustedAppEntity = loadTrustedAppByExternalId(trustedAppId);
		
		// Check Permissions

		return TrustedAppConverter.convertToTrustedAppFull(trustedAppEntity, logoPath(), trustedAppScreenShotPath());
	}

	@Transactional
	public void registerRedirectUris(String trustedAppId, List<RedirectUri> redirectUris, String requestingUsername, String caller) {
		logger.debug("{} redirectUris size is", redirectUris.size());
		TrustedAppEntity trustedAppEntity = daoFactory.getTrustedAppDao().findByExternalId(trustedAppId);

		// Check Permissions

		int count = daoFactory.getRedirectUriDao().deleteByTrustedApp(trustedAppEntity.getRedirectUris());
		logger.debug("{} redirect uris wiped out from trustedApp {}", count, trustedAppEntity.getExternalId());
		
		if(!redirectUris.isEmpty()){ 
			//Check for duplicates
			List<String> redirectURIlist = new ArrayList<String>();
			for(RedirectUri redirectUri : redirectUris)	{
				if(!ValidationUtil.isEmpty(redirectUri.getUri())){
					if(!redirectURIlist.contains(redirectUri.getUri())){
						redirectURIlist.add(redirectUri.getUri());							
					}else{
						throw new DuplicateDataException("duplicate redirect uri submitted");
					}
		
				}else{
					throw new InvalidRedirectUriException("redirect uri can not be null");
				}

			}			
			
			// iterate through the list and insert into DB.
			Iterator<String> itRedirectURIs  = redirectURIlist.iterator();
			String uri  = null;
			while(itRedirectURIs.hasNext()){
					uri = itRedirectURIs.next();
					RedirectUriEntity pRedirectUri = new RedirectUriEntity();
					pRedirectUri.setCreatedBy(caller);
					pRedirectUri.setTrustedApp(trustedAppEntity);
					pRedirectUri.setUri(uri);
					daoFactory.getRedirectUriDao().create(pRedirectUri);
			}
		}


		logger.debug("{} new redirect uris created for trustedApp {}", redirectUris.size(), trustedAppEntity.getExternalId());
	}
	
	@Transactional
	public List<RedirectUri> getRedirectUris(String trustedAppId, String requestingUsername, String caller) {

		TrustedAppEntity trustedAppEntity = loadTrustedAppByExternalId(trustedAppId);
		
		// Check Permissions

		List<RedirectUriEntity> pRedirectUris = trustedAppEntity.getRedirectUris();
		List<RedirectUri> redirectUris = new ArrayList<RedirectUri>();

		for(RedirectUriEntity pRedirectUri : pRedirectUris)	{
			RedirectUri redirectUri = new RedirectUri();
			redirectUri.setUri(pRedirectUri.getUri());
			redirectUris.add(redirectUri);
		}

		logger.debug("{} redirect uris for trustedApp {} returned", redirectUris.size(), trustedAppId);

		return redirectUris;
	}

	@Transactional
	public TrustedApp authenticateTrustedAppId(String trustedAppId,
			String trustedAppSecret) {
		TrustedAppEntity trustedAppEntity = daoFactory.getTrustedAppDao().findByExternalId(trustedAppId);
		if (trustedAppEntity == null || (trustedAppEntity.getStatus().equalsIgnoreCase(TRUSTEDAPP_STATUS_DISABLED))) {
			throw new InvalidTrustedAppException("invalid trustedApp. trustedAppId: " + trustedAppId);
		}

		if (!trustedAppSecret.equals(trustedAppEntity.getTrustedAppSecret()))	{
			throw new InvalidTrustedAppException("invalid trustedApp. trustedAppId: " + trustedAppId);
		}

		TrustedApp trustedApp = new TrustedApp();
		trustedApp.setTrustedAppId(trustedAppEntity.getExternalId());
		trustedApp.setStatus(trustedAppEntity.getStatus());
		trustedApp.setFriendlyName(trustedAppEntity.getFriendlyname());
		return trustedApp;
	}

	@Transactional
	public ApiMethodAuthorizationCheck checkApiAuthorization(
			ApiMethodAuthorizationCheck apiAuthCheck, String userService) {
		// capture check params to local variables
				String trustedAppId = apiAuthCheck.getTrustedAppId();
				String accessToken = apiAuthCheck.getAccessToken();
				String apiMethodId = apiAuthCheck.getApiMethodId();
				SessionEntity pSessionToken = null;
				logger.debug("api-method auth check for trustedApp:{}, access-token:{}, api-method:{}", new Object[] {trustedAppId, accessToken, apiMethodId});
				
				
				// check if trustedApp id is passed
				if (ValidationUtil.isEmpty(trustedAppId))	{
					throw new InvalidTrustedAppException("trustedAppId is missing");
				}


				TrustedAppEntity trustedAppEntity = null;
				
				if (ValidationUtil.isEmpty(accessToken) == false)	{
					pSessionToken = daoFactory.getSessionDao().findBySessionTokenForInterceptor(accessToken);
					if(pSessionToken == null){
						pSessionToken = daoFactory.getSessionDao().findBySessionToken(accessToken);
					}
				}
				// check if the trustedApp exists
				trustedAppEntity = daoFactory.getTrustedAppDao().findByExternalId(trustedAppId);
				
				if (trustedAppEntity == null)	{
					throw new InvalidTrustedAppException("TrustedApp " + trustedAppId + " not found");
				}

				if (trustedAppEntity.getStatus().equalsIgnoreCase(TRUSTEDAPP_STATUS_DISABLED)) {
					throw new InvalidTrustedAppException("invalid TrustedApp. trustedAppId: " + trustedAppId);
				}
				
				
				// check if api-method exists
				ApiMethodEntity pApiMethod = daoFactory.getApiMethodDao().findByExternalId(apiMethodId);
				
			
				// check if this trustedApp requires api-method checks
				if ((trustedAppEntity.isApiMethodCheckRequired()!=null) && trustedAppEntity.isApiMethodCheckRequired())	{
					
					logger.debug("trustedApp {} does require api-method checks", trustedAppId);

					if (pApiMethod == null)	{
						throw new AccessDeniedException("api " + apiMethodId + " not found");
					}

					if (trustedAppEntity.getService() == null)	{
						throw new AccessDeniedException("trustedApp " + trustedAppId + " has no service attached");
					}

					ServiceApiMethodEntity sam =
							daoFactory.getServiceApiMethodDao().findByServiceIdAndApiMethodId(trustedAppEntity.getService().getId(), pApiMethod.getId());
					if (sam == null)	{
						throw new AccessDeniedException("trustedApp " + trustedAppId + " has no access to method " + apiMethodId);
					}
					logger.debug("trustedApp {} has access to api-method {}", trustedAppId, apiMethodId);
				}
				else	{
					logger.debug("trustedApp {} does not require api-method checks", trustedAppId);
				}
				
				/** check if Annotation has been set to NOT to check Session Token **/
				if(apiAuthCheck.getCheckSessionToken()!=null && !apiAuthCheck.getCheckSessionToken()) return apiAuthCheck;
				
				
				
				// by default we will check access token, unless the m
				boolean checkAccessToken = true;
				// check if this api-method requires access token
				if (apiAuthCheck.getCheckSessionToken()==null && pApiMethod != null)	{
					checkAccessToken = (pApiMethod.getRequiresAccessToken()==null) ? false : pApiMethod.getRequiresAccessToken();
					logger.debug("api-method {} requires access token??? == {}", apiMethodId, checkAccessToken);
				}
			
				// validate access token if required
				if (checkAccessToken)	{
					if (ValidationUtil.isEmpty(accessToken))	{
						throw new InvalidSessionTokenException("access token missing");
					}

					// access token provided, check if it exists
					//pSessionToken = daoFactory.getSessionDao().findBySessionToken(accessToken);
					if (pSessionToken == null) {
						throw new InvalidSessionTokenException("invalid session token: " + accessToken);
					}

					// check if the token is not expired
					if (pSessionToken.getExpiresAt().before(new Date())){
			            throw new InvalidSessionTokenException("token has expired: " + accessToken);
					}
					logger.debug("access token {} has not expired yet", accessToken);

					if (pSessionToken.getTrustedApp() == null)	{
						throw new InvalidSessionTokenException("trustedApp " + trustedAppId + " and token " + accessToken + " doesn't match");
					}

					if (!pSessionToken.getTrustedApp().getExternalId().equalsIgnoreCase(trustedAppId))	{

						// waive accessToken.trustedApp.id == trustedAppId match if the trustedApp is internal trustedApp
						if	((trustedAppEntity.isInternal() != null) && trustedAppEntity.isInternal())	{
							logger.debug("access token {}, trustedApp id {} does not match, but trustedApp is internal trustedApp so waiving token/trustedApp match", accessToken, trustedAppId);
						}

					}
					else	{
						logger.debug("access token {}, trustedApp id {} matches", accessToken, trustedAppId);
					}
				}
				else	{
					logger.debug("api-method {} does not require access token", apiMethodId);
				}

				// if access token exists include the account in the response
				if (pSessionToken != null)	{

					apiAuthCheck.setAccount(AccountConverter.convertToAccount(pSessionToken.getAccount()));
				}
				apiAuthCheck.setTrustedApp(TrustedAppConverter.convertToTrustedAppPlain(trustedAppEntity, logoPath()));

				return apiAuthCheck;
	}

	@Transactional
	public List<TrustedApp> getAuthorizedTrustedApps(String username,
			String caller) {

		// check if account exists
		HmisUser pAccount = daoFactory.getAccountDao().findByUsername(username);
		if (pAccount == null)	{
			throw new AccountNotFoundException("account " + username + " not found");
		}

		// find consents for this account
		List<AccountConsentEntity> pConsents =null;
		pConsents		= daoFactory.getAccountConsentDao().findByAccountIdAndConsented(pAccount.getId(), true);
		logger.debug("{} consents for account {}", pConsents.size(), username);

		// find non-expired access tokens that are not offsprings of any refresh token for this account
		List<SessionEntity> pAccessTokens =null;
		pAccessTokens = daoFactory.getSessionDao().findDirectAccessTokensByAccountId(pAccount.getId());
		logger.debug("{} access tokens for account {}", pAccessTokens.size(), username);

		// find refresh tokens for this account
		List<RefreshToken> pRefreshTokens = null;
		pRefreshTokens = daoFactory.getRefreshTokenDao().findByAccountId(pAccount.getId());
		logger.debug("{} refresh tokens for account {}", pRefreshTokens.size(), username);

		// map will be used to regroup tokens by common trustedApps
		Map<String, TrustedApp> trustedApps = new HashMap<String, TrustedApp>();

		// process consents
		for(AccountConsentEntity pConsent : pConsents)	{
			TrustedApp trustedApp = trustedApps.get(pConsent.getTrustedApp().getExternalId());

			// put the trustedApp of this token in the map if not there already
			if (trustedApp == null)	{
				trustedApp = TrustedAppConverter.convertToTrustedApp(pConsent.getTrustedApp(), logoPath());
				trustedApps.put(trustedApp.getTrustedAppId(), trustedApp);
			}
			else	{
				// should not be, there cannot be more than once consent token per trustedApp,account pair
				logger.warn("For account {}, for trustedApp {}, found 2nd consent!!!!", pAccount.getId(), trustedApp.getTrustedAppId());
			}

			com.servinglynk.hmis.warehouse.core.model.AccountConsent consent = new com.servinglynk.hmis.warehouse.core.model.AccountConsent();
			consent.setConsentedAt(pConsent.getConsentedAt());
			consent.setToken(pConsent.getConsentToken());

			trustedApp.setAccountConsent(consent);
		}

		// process refresh tokens
		for(RefreshToken pRefreshToken : pRefreshTokens)	{
			TrustedApp trustedApp = trustedApps.get(pRefreshToken.getTrustedApp().getExternalId());

			// put the trustedApp of this token in the map if not there already
			if (trustedApp == null)	{
				trustedApp = TrustedAppConverter.convertToTrustedApp(pRefreshToken.getTrustedApp(), logoPath());
				trustedApps.put(trustedApp.getTrustedAppId(), trustedApp);
			}

			if (trustedApp.getRefreshTokens() == null)	{
				trustedApp.setRefreshTokens(new ArrayList<com.servinglynk.hmis.warehouse.core.model.RefreshToken>());
			}

			com.servinglynk.hmis.warehouse.core.model.RefreshToken refreshToken = new com.servinglynk.hmis.warehouse.core.model.RefreshToken();
			refreshToken.setCreatedAt(pRefreshToken.getCreatedAt());
			refreshToken.setToken(pRefreshToken.getToken());
			trustedApp.getRefreshTokens().add(refreshToken);
		}

		// process access tokens
		for(SessionEntity pAccessToken : pAccessTokens)	{
			TrustedApp trustedApp = trustedApps.get(pAccessToken.getTrustedApp().getExternalId());

			// put the trustedApp of this token in the map if not there already
			if (trustedApp == null)	{
				trustedApp = TrustedAppConverter.convertToTrustedApp(pAccessToken.getTrustedApp(), logoPath());
				trustedApps.put(trustedApp.getTrustedAppId(), trustedApp);
			}

			if (trustedApp.getAccessTokens() == null)	{
				trustedApp.setAccessTokens(new ArrayList<Session>());
			}

			Session accessToken = new Session();
			accessToken.setToken(pAccessToken.getSessionToken());
			accessToken.setCreatedAt(pAccessToken.getCreatedAt());
			accessToken.setExpiresAt(pAccessToken.getExpiresAt());
			trustedApp.getAccessTokens().add(accessToken);
		}

		return new ArrayList<TrustedApp>(trustedApps.values());
	}

	@Transactional
	public TrustedApp getBasicTrustedAppInfo(String trustedAppsId, String caller) {
		 TrustedAppEntity trustedAppEntity = daoFactory.getTrustedAppDao().findByExternalId(trustedAppsId);
		 if(trustedAppEntity==null){
			 throw new TrustedAppNotFoundException("TrustedApp " + trustedAppsId + " not found");
		 }
		 TrustedApp trustedApp = TrustedAppConverter.convertToTrustedApp(trustedAppEntity, logoPath());
		return trustedApp;
	}


}
