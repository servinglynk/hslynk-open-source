package com.servinglynk.hmis.warehouse.service.impl;


import static com.servinglynk.hmis.warehouse.common.Constants.ACCOUNT_STATUS_ACTIVE;
import static com.servinglynk.hmis.warehouse.common.Constants.ACCOUNT_STATUS_DISABLED;
import static com.servinglynk.hmis.warehouse.common.Constants.TRUSTEDAPP_STATUS_ACTIVE;
import static com.servinglynk.hmis.warehouse.common.Constants.TRUSTEDAPP_STATUS_DISABLED;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.common.GeneralUtil;
import com.servinglynk.hmis.warehouse.common.ValidationUtil;
import com.servinglynk.hmis.warehouse.core.model.OAuthAuthorization;
import com.servinglynk.hmis.warehouse.core.model.OAuthMessageGroup;
import com.servinglynk.hmis.warehouse.core.model.OAuthMessageItem;
import com.servinglynk.hmis.warehouse.core.model.OAuthMessageItems;
import com.servinglynk.hmis.warehouse.core.model.exception.AccessDeniedException;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidParameterException;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidSessionTokenException;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidTrustedAppException;
import com.servinglynk.hmis.warehouse.core.model.exception.MissingParameterException;
import com.servinglynk.hmis.warehouse.core.model.exception.TrustedAppNotFoundException;
import com.servinglynk.hmis.warehouse.model.live.AccountConsentEntity;
import com.servinglynk.hmis.warehouse.model.live.AccountEntity;
import com.servinglynk.hmis.warehouse.model.live.ApiGroupEntity;
import com.servinglynk.hmis.warehouse.model.live.ApiMethodEntity;
import com.servinglynk.hmis.warehouse.model.live.DeveloperCompanyAccountEntity;
import com.servinglynk.hmis.warehouse.model.live.RedirectUriEntity;
import com.servinglynk.hmis.warehouse.model.live.RefreshToken;
import com.servinglynk.hmis.warehouse.model.live.ServiceApiMethodEntity;
import com.servinglynk.hmis.warehouse.model.live.ServiceEntity;
import com.servinglynk.hmis.warehouse.model.live.SessionEntity;
import com.servinglynk.hmis.warehouse.model.live.TrustedAppEntity;
import com.servinglynk.hmis.warehouse.service.AuthorizationService;
import com.servinglynk.hmis.warehouse.service.exception.AccountConsentNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.AccountDisabledException;
import com.servinglynk.hmis.warehouse.service.exception.AccountNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.AuthCodeAlreadyUsedException;
import com.servinglynk.hmis.warehouse.service.exception.AuthCodeExpiredException;
import com.servinglynk.hmis.warehouse.service.exception.AuthCodeNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.GrantTypeNotSupportedException;
import com.servinglynk.hmis.warehouse.service.exception.InvalidRedirectUriException;
import com.servinglynk.hmis.warehouse.service.exception.RefreshTokenNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ServiceNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.SessionNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.UserAuthenticationFailedException;

public class AuthorizationServiceImpl extends ServiceBase implements AuthorizationService {
	
	
	private Set<String> supportedGrantTypes;
	private Integer authCodeExpirationTime;

	
	
	public void setSupportedGrantTypes(Set<String> supportedGrantTypes)	{
		this.supportedGrantTypes = supportedGrantTypes;
	}
	
	public void setAuthCodeExpirationTime(Integer authCodeExpirationTime)	{
		this.authCodeExpirationTime = authCodeExpirationTime;
	}

	@Transactional	
	public OAuthAuthorization requestAuthorization(String trustedAppId,
			String redirectUri, String responseType, String accessType,
			String approvalPrompt, String state, String consentToken,
			boolean isConsented, String authenticationToken, String caller) {
		
		
		
		
	
		// validate trustedApp id
		if (ValidationUtil.isEmpty(trustedAppId))	{
			throw new InvalidTrustedAppException("trustedApp id is missing");
		}
		logger.debug("trustedApp {} is provided", trustedAppId);

		TrustedAppEntity trustedAppEntity = daoFactory.getTrustedAppDao().findByExternalId(trustedAppId);
		if (trustedAppEntity == null)	{
			throw new TrustedAppNotFoundException("TrustedApp " + trustedAppId + " not found");
		}
		logger.debug("trustedApp {} is located", trustedAppId);

		if (trustedAppEntity.getStatus().equalsIgnoreCase(TRUSTEDAPP_STATUS_DISABLED)) {
			throw new InvalidTrustedAppException("invalid TrustedApp. trustedAppId: " + trustedAppId);
		}
		logger.debug("trustedApp {} is not DISABLED", trustedAppId);
		
		validateAuthorizationRequest(trustedAppEntity, redirectUri, responseType, accessType, approvalPrompt);
				
		String grantType = Constants.OAUTH_IMPLICIT;
		if (responseType.equals(Constants.OAUTH_RESPONSE_TYPE_CODE))	{
			grantType = Constants.OAUTH_AUTHORIZATION_CODE;
		}
		logger.debug("effective grant type is {}", grantType);
		
		// check if this grant type is supported by the service
		//checkGrantTypeSupported(grantType);
		
		if (ValidationUtil.isEmpty(accessType))	{
			accessType = Constants.OAUTH_ACCESS_TYPE_ONLINE;
			logger.debug("access type is not provided, default to ONLINE");
		}
		// if offline access, it means we need to create refresh token
		boolean createRefreshToken = Constants.OAUTH_ACCESS_TYPE_OFFLINE.equals(accessType);
		logger.debug("createRefreshToken={}, accessType={}", createRefreshToken, accessType);
		
		if (ValidationUtil.isEmpty(approvalPrompt))	{
			approvalPrompt = Constants.OAUTH_APPROVAL_PROMPT_AUTO;
			logger.debug("approval prompt is not provided, default to AUTO");
		}
		// if approval prompt is forced, it means we need to create new consent token
		boolean requireNewConsent = Constants.OAUTH_APPROVAL_PROMPT_FORCE.equals(approvalPrompt);	
		logger.debug("requireNewConsent={}, approvalPrompt={}", requireNewConsent, approvalPrompt);
		
		//validateGrantType(trustedAppEntity, grantType, accessType);
		
		AccountEntity pAccount = authenticateUser(authenticationToken);
		
		if (!trustedAppEntity.getStatus().equalsIgnoreCase(TRUSTEDAPP_STATUS_ACTIVE)) {
			logger.debug("trustedApp {} is not DISABLED, nor ACTIVE so in between. It should be accessible only by developers", trustedAppId);
			
			if (!developerCalling(pAccount, trustedAppEntity))	{
				throw new InvalidTrustedAppException("invalid trustedApp. trustedAppId: " + trustedAppId);
			}

			logger.debug("TrustedApp {} is not ACTIVE, but account {} is a developer in app's company, so she can keep on", 
					trustedAppEntity.getId(), pAccount.getId());
		}
		else	{
			logger.debug("trustedApp {} is ACTIVE", trustedAppId);
		}
		
		// From this point on we need to create an OAuthAuthorization. Newly created information needs to be reported back i.e. consent token, auth code or refresh token
		OAuthAuthorization authorization = new OAuthAuthorization();
		authorization.setGrantType(grantType);
		
		boolean askForConsent = false;
		AccountConsentEntity consent = null;
		
		if (Constants.OAUTH_ACCOUNT_CONSENT_NEVER.equalsIgnoreCase(trustedAppEntity.getAccountConsentType()))	{
			logger.debug("trustedApp {}, account {}, requires no consent, so skip consent process", trustedAppEntity.getId(), pAccount.getId());
		}
		else	{
			consent = daoFactory.getAccountConsentDao().findByAccountIdAndTrustedAppId(pAccount.getId(), trustedAppEntity.getId());
			
			if (consent == null)	{
				// no consent record, create a new one
				consent = createConsent(pAccount, trustedAppEntity, caller);
				askForConsent = true;
				logger.debug("no consent for trustedApp {}, account {} existed, created one", trustedAppEntity.getId(), pAccount.getId());
			}
			else if (!consent.isConsented())	{
				if ((consent.getConsentToken() != null) && consent.getConsentToken().equals(consentToken))	{
					if (isConsented)	{
						logger.debug("a consent token with isConsented=false exists for trustedApp {} and account {}, isConsented uri param is TRUE, consent token {} matchesa, so update it and you can proceed", 
								     new Object[] {trustedAppEntity.getId(), pAccount.getUsername(), consentToken});
						
						// update the consented flag to TRUE
						consent.setConsented(true);
						consent.setModifiedBy(caller);
						consent.setConsentedAt(new Date());
						daoFactory.getAccountConsentDao().updateAccountConsent(consent);
					}
					else	{
						logger.debug("a consent token with isConsented=false exists for trustedApp {} and account {}, isConsented is FALSE, consent token {} matches, so respond accordingly", 
							         new Object[] {trustedAppEntity.getId(), pAccount.getUsername(), consentToken});
						
						throw new AccessDeniedException();
					}
				}
				else	{
					// there is consent record but the consent flag is not set to true, 
					// so redirect only
					logger.debug("a consent token with isConsented=false exists for trustedApp {} and account {}, using it", trustedAppEntity.getId(), pAccount.getUsername());
					askForConsent = true;
				}
			}
			else if (consent.isConsented() && requireNewConsent)	{
				// there is consented consent but, fresh new consent is required, 
				// the old one (that is consented) should be removed and create a new one
				daoFactory.getAccountConsentDao().deleteAccountConsent(consent);
				consent = createConsent(pAccount, trustedAppEntity, caller);
				askForConsent = true;
				logger.debug("a consent token with isConsented=true exists for trustedApp {} and account {}, requireNewConsent=true so delete the old one, create a new one", 
						trustedAppEntity.getId(), pAccount.getUsername());
			}
		}

		if (askForConsent)	{
			authorization.setConsentToken(consent.getConsentToken());
			authorization.setNextAction(Constants.OAUTH_FLOW_REQUEST_CONSENT);
			logger.debug("need to ask for consent, next action is OAUTH_FLOW_REQUEST_CONSENT, consent token is {}", consent.getConsentToken());
		}
		else	{
			if (consent != null)	{
				// no create nor redirect, keep going
				logger.debug("consent {} exists, for account {} and trustedApp {}, approval prompt is not FORCE or consented, keep going", 
							  new Object[] {consent.getConsentToken(), pAccount.getUsername(), trustedAppEntity.getId()});
			}
			
			if (Constants.OAUTH_AUTHORIZATION_CODE.equals(grantType)) 	{
				logger.debug("authorization code grant flow requested");
				// create auth code
				SessionEntity authCode = new SessionEntity();
				authCode.setAccount(pAccount);
				authCode.setTrustedApp(trustedAppEntity);
				authCode.setAuthCode(GeneralUtil.getUniqueToken(32));
				authCode.setCreatedAt(new Date());
				authCode.setCreatedBy(caller);
				authCode.setRedirectUri(redirectUri);
				authCode.setAuthCodeExpiresAt(new Date(System.currentTimeMillis() + (2000 * 1000)));
				daoFactory.getSessionDao().create(authCode);
				logger.debug("auth code {} is created", authCode.getAuthCode());
				
				authorization.setAuthCode(authCode.getAuthCode());
				authorization.setNextAction(Constants.OAUTH_FLOW_REDIRECT_AUTH_CODE_TO_TRUSTEDAPP);
				
				if (createRefreshToken)	{
					logger.debug("refresh token is requested");
					RefreshToken refreshToken = new RefreshToken();
					refreshToken.setAccount(pAccount);
					refreshToken.setAuthCode(authCode.getAuthCode());
					refreshToken.setTrustedApp(trustedAppEntity);
					refreshToken.setCreatedBy(caller);
					// refreshToken.token will be generated during token request based on this auth code
					// creating this record serves as an indication to TokenEndpoint to generate a refreshToken.token
					// and return it as well along with an access token
					daoFactory.getRefreshTokenDao().create(refreshToken);
					logger.debug("refresh token id:{} is created", refreshToken.getId());
					
					authorization.setRefreshToken(refreshToken.getToken());
				}
			}
			else if (Constants.OAUTH_IMPLICIT.equals(grantType)) 	{
				logger.debug("implicit grant is requested");
				SessionEntity accessToken = new SessionEntity();
				accessToken.setAccount(pAccount);
				accessToken.setTrustedApp(trustedAppEntity);
				accessToken.setSessionToken(SessionEntity.generateSessionToken());
				accessToken.setRedirectUri(redirectUri);
				accessToken.setCreatedBy(caller);
				accessToken.setExpiresAt(new Date(System.currentTimeMillis() + (trustedAppEntity.getExpirationTime() * 1000)));
				daoFactory.getSessionDao().create(accessToken);
				logger.debug("access token {} is created", accessToken.getSessionToken());
				
				authorization.setAccessToken(accessToken.getSessionToken());
				authorization.setExpiresIn(trustedAppEntity.getExpirationTime());
				authorization.setNextAction(Constants.OAUTH_FLOW_REDIRECT_ACCESS_TOKEN_TO_TRUSTEDAPP);
			}
		}
		
		authorization.setRedirectUri(redirectUri);
		authorization.setTokenType("Bearer");
		authorization.setState(state);
		
		logger.debug("authorization is ready : {}", authorization);
		
		return authorization;
	}
	
	private void validateAuthorizationRequest(TrustedAppEntity trustedAppEntity, String redirectUri, String responseType, String accessType, String approvalPrompt)	{
		// validate redirect uri
		if (ValidationUtil.isEmpty(redirectUri))	{
			throw new InvalidRedirectUriException("redirect uri is missing");   
																				
		}
		logger.debug("redirect uri {} provided", redirectUri);
		
		// is redirect uri not malformed
		//if (!ValidationUtil.isUriValid(redirectUri))	{
		//	throw new InvalidRedirectUriException("redirect uri is invalid");
		//}
		logger.debug("redirect uri {} is valid", redirectUri);

		// redirect uri is registered to this trustedApp?
		RedirectUriEntity redirectUriObj = daoFactory.getRedirectUriDao().findByUriAndTrustedAppId(redirectUri, trustedAppEntity.getId());
		if (redirectUriObj == null)	{
			logger.warn("trustedApp " + trustedAppEntity.getExternalId() + " calling with redirect uri " + redirectUri + " that is not one of its registered redirect uris");
			throw new InvalidRedirectUriException("Redirect uri " + redirectUri + " is not registered");
		}
		logger.debug("redirect uri {} is registered with trustedApp {}", redirectUri, trustedAppEntity.getExternalId());

		// validate response type
		if (ValidationUtil.isEmpty(responseType))	{
			throw new MissingParameterException("response type is missing");
		}
		logger.debug("responseType {} is provided", responseType);
		
		if (!responseType.equals(Constants.OAUTH_RESPONSE_TYPE_CODE) && !responseType.equals(Constants.OAUTH_RESPONSE_TYPE_TOKEN))	{
			throw new InvalidParameterException("invalid response type: " + responseType);
		}
		logger.debug("responseType {} is valid", responseType);

		// validate access type
		if (!ValidationUtil.isEmpty(accessType))	{
			if (!accessType.equals(Constants.OAUTH_ACCESS_TYPE_ONLINE) && !accessType.equals(Constants.OAUTH_ACCESS_TYPE_OFFLINE))	{
				throw new InvalidParameterException("invalid access type: " + accessType);
			}
		}
		logger.debug("accessType {} is ok", accessType);
		
		// validate approval prompt
		if (!ValidationUtil.isEmpty(approvalPrompt))	{
			if (!approvalPrompt.equals(Constants.OAUTH_APPROVAL_PROMPT_AUTO) && !approvalPrompt.equals(Constants.OAUTH_APPROVAL_PROMPT_FORCE))	{
				throw new InvalidParameterException("invalid approval prompt: " + approvalPrompt);
			}
		}
		logger.debug("approvalPrompt {} is ok", approvalPrompt);
		
		logger.debug("authorization request for trustedApp={}, redirectUri={}, responseType={}, accessType={}, approvalPrompt={}", 
				new Object[] {trustedAppEntity.getExternalId(),
							  redirectUri,
							  responseType,
							  accessType,
							  approvalPrompt});
	}
	
	
	private AccountConsentEntity createConsent(AccountEntity pAccount, TrustedAppEntity trustedAppEntity, String caller)	{
		AccountConsentEntity consent = new AccountConsentEntity();
		consent.setAccount(pAccount);
		consent.setTrustedApp(trustedAppEntity);
		consent.setConsented(false);
		consent.setConsentToken(GeneralUtil.getUniqueToken(64));
		consent.setCreatedBy(caller);
		daoFactory.getAccountConsentDao().create(consent);
		logger.debug("consent token {} created", consent.getConsentToken());
		
		return consent;
	}
	
	
	public void checkGrantTypeSupported(String grantType)	{
		if (!supportedGrantTypes.contains(grantType))	{
			throw new GrantTypeNotSupportedException("Grant type " + grantType + " is not supported");
		}
		logger.debug("authorization service supports grant type {}", grantType);
	}
	
	

	private void validateGrantType(TrustedAppEntity trustedAppEntity, String grantType, String accessType)	{

		// if grant flow is authorization code, check if the trustedApp is authorized for that flow
		if (Constants.OAUTH_AUTHORIZATION_CODE.equals(grantType) && !trustedAppEntity.isAuthCodeGrantSupported()) 	{
			throw new GrantTypeNotSupportedException("TrustedApp " + trustedAppEntity.getExternalId() + " is not authorized for auth code");
		}
		
		// if grant flow is implicit, check if the trustedApp is authorized for that flow
		if (Constants.OAUTH_IMPLICIT.equals(grantType) && !trustedAppEntity.isImplicitGrantSupported()) 	{
			throw new GrantTypeNotSupportedException("TrustedApp " + trustedAppEntity.getExternalId()  + " is not authorized for implicit grants");
		}
	
		// if grant flow is refresh token (offline access type), check if the trustedApp is authorized for that flow
		if (accessType.equals(Constants.OAUTH_ACCESS_TYPE_OFFLINE) && !trustedAppEntity.isRefreshTokenSupported())	{
			throw new GrantTypeNotSupportedException("TrustedApp " + trustedAppEntity.getExternalId()  + " is not authorized for refresh tokens");
		}
		
		// make sure we don't have both IMPLICIT grant flow and OFFLINE access (refresh token flow)
		if (Constants.OAUTH_IMPLICIT.equals(grantType) && accessType.equals(Constants.OAUTH_ACCESS_TYPE_OFFLINE))	{
			throw new InvalidParameterException("implicit flow does not support offline access");
		}
		
		logger.debug("grant type {}, access type {} is supported by trustedApp {}", new Object[] {grantType, accessType, trustedAppEntity.getExternalId()});
	}
	
	

	private AccountEntity authenticateUser(String authenticationToken)	{
		
		if (authenticationToken == null)	{
			throw new UserAuthenticationFailedException();
		}
		logger.debug("authentication token {} is provided", authenticationToken);
		
		com.servinglynk.hmis.warehouse.core.model.Session session = null;
		
		try	{
			session = serviceFactory.getSessionService().validateSessionToken(authenticationToken);
		}
		catch(InvalidSessionTokenException e)	{
			logger.error("authentication token {} is not recognized", authenticationToken);
			throw new UserAuthenticationFailedException(e);
		}
		logger.debug("authentication token {} is valid", session.getToken());
		
		if ((session.getAccount() == null) || !Constants.ACCOUNT_STATUS_ACTIVE.equals(session.getAccount().getStatus()))	{
			throw new AccountDisabledException("account not active");
		}
		logger.debug("user associated to token {} is valid also", authenticationToken);
		
		AccountEntity pAccount = daoFactory.getAccountDao().findByUsername(session.getAccount().getUsername());
		if (pAccount == null)	{
			logger.error("account {} not found", session.getAccount().getUsername());
			throw new AccountNotFoundException("AccountEntity not found");
		}
		
		return pAccount;
	}
	
	
	private boolean developerCalling(AccountEntity accountCalling, TrustedAppEntity trustedAppEntity)	{
		
		if (trustedAppEntity.getService() == null)	{
			logger.debug("trustedApp {} has no service attached", trustedAppEntity.getId());
			return false;
		}
		
		if (trustedAppEntity.getService().getDeveloperCompany() == null)	{
			logger.debug("trustedApp {} has no developer company", trustedAppEntity.getId());
			return false;
		}
		
		DeveloperCompanyAccountEntity devAccount = null;
		devAccount=	daoFactory.getDeveloperCompanyAccountDao()
					.findByDeveloperCompanyIdAndAccountId(trustedAppEntity.getService().getDeveloperCompany().getId(), 
														  accountCalling.getId());
		
		if (devAccount == null)	{
			logger.debug("account {} is not a developer in company id:{}", accountCalling.getUsername(), trustedAppEntity.getService().getDeveloperCompany().getId());
			return false;
		}
		
		logger.debug("account {} is a developer in company id:{}", accountCalling.getUsername(), trustedAppEntity.getService().getDeveloperCompany().getId());
		return true;
	}

	
	@Transactional
	public List<OAuthMessageGroup> getConsentMessageForTrustedApp(String trustedAppId,
			String username, String authorizationService, boolean isDetailed)	{
		
		if (trustedAppId == null)	{
			logger.debug("no trustedApp is passed, return empty api groups", trustedAppId);
			return new ArrayList<OAuthMessageGroup>();
		}
		
		TrustedAppEntity trustedAppEntity = daoFactory.getTrustedAppDao().findByExternalId(trustedAppId);		
		
		if (trustedAppEntity == null)	{
			throw new TrustedAppNotFoundException("TrustedApp " + trustedAppId + " not found");
		}
		
		if (trustedAppEntity.getService() == null)	{
			logger.debug("trustedApp {} has no service attached, return empty api groups", trustedAppId);
			return new ArrayList<OAuthMessageGroup>();
		}
		
		ServiceEntity pService = daoFactory.getServiceDao().findByExternalId(trustedAppEntity.getService().getExternalId());
		if (pService == null)	{
			throw new ServiceNotFoundException("ServiceEntity " + trustedAppEntity.getService().getExternalId() + " not found");
		}
		
		if ((pService.getServiceApiMethods() == null) || pService.getServiceApiMethods().isEmpty())	{
			logger.debug("trustedApp {} has no api methods assigned, return empty api groups", trustedAppId);
			return new ArrayList<OAuthMessageGroup>();
		}
		
		List<ServiceApiMethodEntity> pApiMethods = pService.getServiceApiMethods();
		
		Map<UUID, OAuthMessageGroup> oAuthMessageGroupsMap = new HashMap<UUID, OAuthMessageGroup>();
		Map<UUID, Map<UUID,OAuthMessageItem>> oAuthMessageItemsGroupMap = new HashMap<UUID, Map<UUID,OAuthMessageItem>>();

		// go over the list of api methods and group them under their own apiGroups in maps
		for(Object apiMethodObj : pApiMethods)	{ 
			ApiMethodEntity pApiMethod = null;
			
			// The list of methods passed might be of type ApiMethods directly or ServiceApiMethods
			if (apiMethodObj instanceof ServiceApiMethodEntity)	{
				pApiMethod = ((ServiceApiMethodEntity) apiMethodObj).getApiMethod();
			}
			else if (apiMethodObj instanceof ApiMethodEntity)	{
				pApiMethod = (ApiMethodEntity) apiMethodObj; 
			}
			
			ApiGroupEntity pApiGroup = pApiMethod.getApiGroup();
			if (pApiGroup == null)	{
				logger.warn("api-method {}'s api-group is null, shouldn't be", pApiMethod.getId());
			}
			else	{
				if (!oAuthMessageGroupsMap.containsKey(pApiGroup.getId())){
					OAuthMessageGroup oAuthMessageGroup = new OAuthMessageGroup();
					if(pApiGroup.getConsentMessage() != null){
						oAuthMessageGroup.setConsentMessage(pApiGroup.getConsentMessage().getMessage());
					}
					if(isDetailed){
						if(pApiGroup.getDetailConsentMessage() != null){
							oAuthMessageGroup.setDetailedConsentMessage(pApiGroup.getDetailConsentMessage().getMessage());
						}
					}else{
						if(pApiGroup.getDetailConsentMessage() == null){
							oAuthMessageGroup.setDetailedConsentMessageExists(false);
						}else{
							oAuthMessageGroup.setDetailedConsentMessageExists(true);
						}
					}
					oAuthMessageGroupsMap.put(pApiGroup.getId(), oAuthMessageGroup);
				}
				
				Map<UUID, OAuthMessageItem> oAuthMessageItemsMap = oAuthMessageItemsGroupMap.get(pApiGroup.getId());
				if (oAuthMessageItemsMap == null)	{
					oAuthMessageItemsMap = new HashMap<UUID, OAuthMessageItem>();
					oAuthMessageItemsGroupMap.put(pApiGroup.getId(), oAuthMessageItemsMap);
				}
				
				if ((!oAuthMessageItemsMap.containsKey(pApiMethod.getId())) && pApiMethod.getConsentMessage() !=null){
					OAuthMessageItem oAuthMessageItem = new OAuthMessageItem();
					if(pApiMethod.getConsentMessage() != null){
						oAuthMessageItem.setConsentMessage(pApiMethod.getConsentMessage().getMessage());						
					}

					if(isDetailed){
						if(pApiMethod.getDetailConsentMessage() != null){
							oAuthMessageItem.setDetailedConsentMessage(pApiMethod.getDetailConsentMessage().getMessage());
							oAuthMessageItemsMap.put(pApiMethod.getId(), oAuthMessageItem);
						}
					}else{
						if(pApiMethod.getDetailConsentMessage() == null){
							oAuthMessageItem.setDetailedConsentMessageExists(false);
						}else{
							oAuthMessageItem.setDetailedConsentMessageExists(true);
						}
						
						oAuthMessageItemsMap.put(pApiMethod.getId(), oAuthMessageItem);
					}
				}
			}
		}
		
		List<OAuthMessageGroup> oAuthMessageGroupList = new ArrayList<OAuthMessageGroup>();
		
		// build List<OAuthMessageGroup> from the maps
		for(Map.Entry<UUID, OAuthMessageGroup> entry : oAuthMessageGroupsMap.entrySet())	{
			OAuthMessageGroup oAuthMessageGroup = entry.getValue();
			oAuthMessageGroup.setoAuthMessageItems(new ArrayList<OAuthMessageItem>());

			Map<UUID, OAuthMessageItem> oAuthMessageItemMap = oAuthMessageItemsGroupMap.get(entry.getKey());
			if(!oAuthMessageItemMap.isEmpty()){

				List<OAuthMessageItem> oAuthMessageItemList = new ArrayList<OAuthMessageItem>();				
				OAuthMessageItems msgTestList = new OAuthMessageItems();
				Boolean isDuplicate = false;
				for(OAuthMessageItem omi :  oAuthMessageItemMap.values()){
					if(msgTestList.getOAuthMessageItems().size() == 0){
						oAuthMessageItemList.add(omi);
						msgTestList.setOAuthMessageItems(oAuthMessageItemList);					
					}else{
						for(OAuthMessageItem msgDubTestList : msgTestList.getOAuthMessageItems()){
							if(msgDubTestList.getConsentMessage().equals(omi.getConsentMessage())){
								isDuplicate = true;
								
							}else{
								isDuplicate = false;
							}
						}
						if(!isDuplicate){
							oAuthMessageItemList.add(omi);	
						}	
						msgTestList.setOAuthMessageItems(oAuthMessageItemList);
					}
				}				
				
				oAuthMessageGroup.setoAuthMessageItems(oAuthMessageItemList);
				oAuthMessageGroupList.add(oAuthMessageGroup);
			}
		}
		
		return oAuthMessageGroupList;
	}

	
	@Transactional
	public OAuthAuthorization authorizeWithRefreshToken(String refreshToken,
			String trustedAppId, String caller) {
		TrustedAppEntity trustedAppEntity = daoFactory.getTrustedAppDao().findByExternalId(trustedAppId);
		
		if (trustedAppEntity == null)	{
			throw new TrustedAppNotFoundException("TrustedApp " + trustedAppId + " not found");
		}
		
		logger.debug("TrustedApp {} found", trustedAppEntity.getId());
		
		// check if this trustedApp supports auth code grant type
		if (!trustedAppEntity.isRefreshTokenSupported())	{
			throw new GrantTypeNotSupportedException("TrustedApp " + trustedAppId + " is not authorized for refresh token");
		}
		
		logger.debug("trustedApp {} supports refresh token grant type");
		
		// load the refresh token
		RefreshToken pRefreshToken = daoFactory.getRefreshTokenDao().findByToken(refreshToken);
		
		if (pRefreshToken == null)	{
			throw new RefreshTokenNotFoundException("refresh token " + refreshToken + " not found");
		}
		
		logger.debug("refresh token {} located", refreshToken);
		
		// check if the refresh token belongs to this trustedApp
		if (!pRefreshToken.getTrustedApp().getExternalId().equalsIgnoreCase(trustedAppEntity.getExternalId()))	{
			logger.warn("TrustedApp " + trustedAppId + " calling with refresh token " + refreshToken + " that belongs to another trustedApp");
			throw new RefreshTokenNotFoundException("refresh token " + refreshToken + " not found");
		}
		
		logger.debug("refresh token {} belongs to trustedApp {}", refreshToken, trustedAppEntity.getId());
		
		// check if the account associated with this refresh token is disabled or not
		if (pRefreshToken.getAccount().getStatus().equals(ACCOUNT_STATUS_DISABLED))	{
			throw new AccountDisabledException("account disabled");
		}
		
		// create a new access token based on the refresh token
		SessionEntity pToken = new SessionEntity();
		pToken.setAccount(pRefreshToken.getAccount());
		pToken.setTrustedApp(trustedAppEntity);
		pToken.setRefreshToken(pRefreshToken);
		pToken.setSessionToken(SessionEntity.generateSessionToken());
		pToken.setCreatedBy(caller);
		pToken.setExpiresAt(new Date(System.currentTimeMillis() + (trustedAppEntity.getExpirationTime() * 1000)));
		daoFactory.getSessionDao().create(pToken);
		
		logger.debug("access token {} created based on refresh token {}", pToken.getSessionToken(), refreshToken);
		
		OAuthAuthorization authorization = new OAuthAuthorization();
		authorization.setAccessToken(pToken.getSessionToken());
		authorization.setTokenType("Bearer");
		authorization.setExpiresIn(trustedAppEntity.getExpirationTime());	
		
		return authorization;
	}

	
	@Transactional
	public void cleanAuthCode(String authCode, String trustedAppId,
			String caller) {
		SessionEntity pToken = daoFactory.getSessionDao().findByAuthCode(authCode);

		// delete the access token if there is any
		if (pToken != null)	{
			pToken.setModifiedBy(caller);
			daoFactory.getSessionDao().deleteSession(pToken);
		}		
		
		// load the refresh token
		RefreshToken pRefreshToken = daoFactory.getRefreshTokenDao().findByAuthCode(authCode);
		
		// delete the refresh token if any
		if (pRefreshToken != null)	{
			// delete all the access tokens associated with this refresh token
			int deletedCount = daoFactory.getSessionDao().deleteByRefreshTokenId(pRefreshToken.getId());
			
			// delete the refresh token itself
			pRefreshToken.setModifiedBy(caller);
			daoFactory.getRefreshTokenDao().deleteRefreshToken(pRefreshToken);
			
			logger.debug("refresh token {} and its associated {} access tokens are wiped out", pRefreshToken.getId(), deletedCount);
		}
		
	}

	
	@Transactional
	public OAuthAuthorization authorizeWithAuthCode(String authCode, String redirectUri, 
			String trustedAppId, String caller) {
		
		TrustedAppEntity trustedAppEntity = daoFactory.getTrustedAppDao().findByExternalId(trustedAppId);
		
		if (trustedAppEntity == null)	{
			throw new TrustedAppNotFoundException("TrustedApp " + trustedAppId + " not found");
		}
		
		logger.debug("TrustedApp {} found", trustedAppEntity.getId());
		
		// check if this trustedApp supports auth code grant type
		if (!trustedAppEntity.isAuthCodeGrantSupported())	{
			throw new GrantTypeNotSupportedException("TrustedApp " + trustedAppId + " is not authorized for auth code");
		}
		
		logger.debug("trustedApp {} supports authentication code grant type");
		
		// load the auth code
		SessionEntity pToken = daoFactory.getSessionDao().findByAuthCode(authCode);
		
		if (pToken == null)	{
			throw new AuthCodeNotFoundException("auth code " + authCode + " not found");
		}
		
		logger.debug("auth code {} located", authCode);
		
		// check if the auth code belongs to this trustedApp
		if (!pToken.getTrustedApp().getExternalId().equalsIgnoreCase(trustedAppEntity.getExternalId()))	{
			logger.warn("TrustedApp " + trustedAppId + " calling with auth code " + authCode + " that belongs to another trustedApp");
			throw new AuthCodeNotFoundException("auth code " + authCode + " not found");
		}
		
		logger.debug("auth code {} belongs to trustedApp {}", authCode, trustedAppEntity.getId());
		
		// check if the account associated with this auth code is disabled or not
		if (!pToken.getAccount().getStatus().equals(ACCOUNT_STATUS_ACTIVE))	{
			throw new AccountDisabledException("account not active");
		}	
		
		// check if the auth code has not expired yet
		if ((new Date()).after(pToken.getAuthCodeExpiresAt()))	{
			throw new AuthCodeExpiredException("auth code " + authCode + " has expired");
		}
		
		logger.debug("auth code {} has not expired yet", authCode);
		
		// check if redirect uri is the same as the one used when auth code was created
		if (!redirectUri.equalsIgnoreCase(pToken.getRedirectUri()))	{
			logger.warn("TrustedApp " + trustedAppId + " calling with redirect uri " + redirectUri + " that is not the one use to get auth code " + authCode);
			throw new InvalidRedirectUriException("Redirect uri " + redirectUri + " does not match for auth code " + authCode);
		}
		
		logger.debug("redirect uri {} of auth code {} matches", redirectUri, authCode);
		
		// check if the auth code was previously used
		if (!StringUtils.isBlank(pToken.getSessionToken()))	{
			// the record for the auth code has the access token set which means it was used previously, 
			// (so remove the access token and refresh token created based on this auth code, this removal will be initiated by end point layer via a separate transaction)
			throw new AuthCodeAlreadyUsedException("auth code " + authCode + " being used 2nd time by trustedApp " + trustedAppId);
		}
		
		logger.debug("auth code {} has never been used before", authCode);
		
		// create the access token and attach it to the auth code
		pToken.setModifiedBy(caller);
		pToken.setSessionToken(SessionEntity.generateSessionToken());
		pToken.setExpiresAt(new Date(System.currentTimeMillis() + (trustedAppEntity.getExpirationTime() * 1000)));
		daoFactory.getSessionDao().create(pToken);
		
		logger.debug("access token {} created based on auth code {}", pToken.getSessionToken(), authCode);
		
		OAuthAuthorization authorization = new OAuthAuthorization();
		authorization.setAccessToken(pToken.getSessionToken());
		authorization.setTokenType("Bearer");
		authorization.setExpiresIn(trustedAppEntity.getExpirationTime());	
		
		// check if there is any refresh token attached to the auth code, if there is return it too.
		RefreshToken pRefreshToken = daoFactory.getRefreshTokenDao().findByAuthCode(authCode);
		
		if (pRefreshToken != null)	{
			if (pRefreshToken.getToken() == null)	{
				pRefreshToken.setToken(GeneralUtil.getUniqueToken(64));
				pRefreshToken.setModifiedBy(caller);
				daoFactory.getRefreshTokenDao().updateRefreshToken(pRefreshToken);
			}
			
			logger.debug("a refresh token {} located for auth code {}", pRefreshToken.getToken(), authCode);
			authorization.setRefreshToken(pRefreshToken.getToken());
		}
		else	{
			logger.debug("no refresh token located for auth code {}", authCode);
		}
		
		return authorization;

	}

	
	@Transactional
	public void revokeAccessToken(String accessToken,
			String caller) {
SessionEntity pToken = daoFactory.getSessionDao().findBySessionToken(accessToken);
		
		if (pToken == null)	{
			throw new SessionNotFoundException("access token " + accessToken + " not found");
		}
		
		logger.debug("revoking access token " + accessToken);
		pToken.setModifiedBy(caller);
		pToken.setExpiresAt(new Date());
		daoFactory.getSessionDao().deleteSession(pToken);
	}

	
	@Transactional
	public void revokeRefreshToken(String refreshToken,
			String caller) {
RefreshToken pRefreshToken = daoFactory.getRefreshTokenDao().findByToken(refreshToken);
		
		if (pRefreshToken == null)	{
			RefreshTokenNotFoundException e = new RefreshTokenNotFoundException("refresh token " + refreshToken + " not found");
			e.setContext(RefreshTokenNotFoundException.REVOCATION);
			throw e;
		}
		
		logger.debug("revoking refresh token " + refreshToken);
		
		int count = daoFactory.getSessionDao().deleteByRefreshTokenId(pRefreshToken.getId());
		logger.debug("{} access tokens of refresh token {} is deleted", count, refreshToken);
		
		pRefreshToken.setModifiedBy(caller);
		daoFactory.getRefreshTokenDao().deleteRefreshToken(pRefreshToken);		
		
	}

	
	public void revokeConsentToken(String consentToken,
			String caller) {
		AccountConsentEntity pAccountConsent = daoFactory.getAccountConsentDao().findByToken(consentToken);
		
		if (pAccountConsent == null)	{
			throw new AccountConsentNotFoundException("consent token " + consentToken + " not found");
		}
		
		UUID trustedAppId = pAccountConsent.getTrustedApp().getId();
		
		UUID accountId= pAccountConsent.getAccount().getId();

		// revoke auth codes and access tokens
		int count = daoFactory.getSessionDao().deleteByTrustedAppIdAndAccountId(trustedAppId, accountId);
		logger.debug("{} access tokens related to consent token {} deleted", count, consentToken);
		
		// revoke refresh tokens
		count = daoFactory.getRefreshTokenDao().deleteByTrustedAppIdAndAccountId(trustedAppId, accountId);
		logger.debug("{} refresh tokens related to consent token {} deleted", count, consentToken);
		
		// revoke the consent
		pAccountConsent.setModifiedBy(caller);
		daoFactory.getAccountConsentDao().deleteAccountConsent(pAccountConsent);
		logger.debug("account consent token {} revoked", consentToken);
		
	}
	
}
