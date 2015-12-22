package com.servinglynk.hmis.warehouse.service.impl;


import static com.servinglynk.hmis.warehouse.common.Constants.ACCOUNT_STATUS_ACTIVE;
import static com.servinglynk.hmis.warehouse.common.Constants.ACCOUNT_STATUS_PENDING;
import static com.servinglynk.hmis.warehouse.common.Constants.VERIFICATION_TYPE_ACCOUNT_CREATION;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;


import com.servinglynk.hmis.warehouse.client.notificationservice.NotificationServiceClient;
import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.common.GeneralUtil;
import com.servinglynk.hmis.warehouse.common.ValidationBean;
import com.servinglynk.hmis.warehouse.common.ValidationUtil;
import com.servinglynk.hmis.warehouse.common.security.HMISCryptographer;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.Accounts;
import com.servinglynk.hmis.warehouse.core.model.Locale;
import com.servinglynk.hmis.warehouse.core.model.Notification;
import com.servinglynk.hmis.warehouse.core.model.Parameter;
import com.servinglynk.hmis.warehouse.core.model.Parameters;
import com.servinglynk.hmis.warehouse.core.model.PasswordChange;
import com.servinglynk.hmis.warehouse.core.model.Preferences;
import com.servinglynk.hmis.warehouse.core.model.Recipients;
import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.core.model.exception.AccessDeniedException;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidParameterException;
import com.servinglynk.hmis.warehouse.core.model.exception.MissingParameterException;
import com.servinglynk.hmis.warehouse.model.live.AccountLockoutEntity;
import com.servinglynk.hmis.warehouse.model.live.AccountPreferenceEntity;
import com.servinglynk.hmis.warehouse.model.live.ApiMethodEntity;
import com.servinglynk.hmis.warehouse.model.live.HmisUser;
import com.servinglynk.hmis.warehouse.model.live.Organization;
import com.servinglynk.hmis.warehouse.model.live.PermissionSetEntity;
import com.servinglynk.hmis.warehouse.model.live.ProfileEntity;
import com.servinglynk.hmis.warehouse.model.live.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.model.live.RoleEntity;
import com.servinglynk.hmis.warehouse.model.live.SessionEntity;
import com.servinglynk.hmis.warehouse.model.live.UserRoleMapEntity;
import com.servinglynk.hmis.warehouse.model.live.VerificationEntity;
import com.servinglynk.hmis.warehouse.service.AccountService;
import com.servinglynk.hmis.warehouse.service.converter.AccountConverter;
import com.servinglynk.hmis.warehouse.service.converter.ProfileConverter;
import com.servinglynk.hmis.warehouse.service.core.security.GoogleAuthenticator;
import com.servinglynk.hmis.warehouse.service.core.security.GoogleAuthenticatorKey;
import com.servinglynk.hmis.warehouse.service.exception.AccountAlreadyExistsException;
import com.servinglynk.hmis.warehouse.service.exception.AccountNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ApiMethodNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.InvalidCurrentPasswordException;
import com.servinglynk.hmis.warehouse.service.exception.OrganizationNotFound;
import com.servinglynk.hmis.warehouse.service.exception.ProfileNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ProjectGroupNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.RoleNotFoundException;


public class AccountServiceImpl extends ServiceBase implements AccountService {
	
	@Autowired
	protected ValidationBean validationBean;
	
	@Autowired
	@Qualifier("notificationurl")
	protected String notificationurl; 
	

	@Autowired
	NotificationServiceClient notificationServiceClient;

	
	
	@Transactional
	public Account createAccount(Account account) throws Exception {
		
		ProfileEntity profileEntity=null;
		
		if(account.getProfile()==null){
			
		}else{
		 profileEntity = daoFactory.getProfileDao().getProfileById(account.getProfile().getId());
		 if(profileEntity==null) {
			 ProfileConverter.modelToEntity(profileEntity, account.getProfile());
			 daoFactory.getProfileDao().createProfile(profileEntity);
		 }
		}
		
		
		com.servinglynk.hmis.warehouse.model.live.HmisUser pAccount = AccountConverter.convertToPersistentAccount(account, null);
	
		Organization pOrganization = daoFactory.getOrganizationDao().getOrganizationById(account.getOrganizationId());

		if(pOrganization==null) throw new OrganizationNotFound();

		pAccount.setOrganization(pOrganization);
		pAccount.setStatus(ACCOUNT_STATUS_ACTIVE);
		pAccount.setPassword(HMISCryptographer.Encrypt(account.getPassword()));
		pAccount.setCreatedBy(Constants.DEVELOPER_CONSOLE_SERVICE);
		pAccount.setProfileEntity(profileEntity);
		daoFactory.getAccountDao().createAccount(pAccount);
		return account;
	}

	@Transactional
	public Account findAccountByUsername(String username) {
		com.servinglynk.hmis.warehouse.model.live.HmisUser pAccount = daoFactory.getAccountDao().findByUsername(username);

		Account account = null;
		if (pAccount != null) {
			account = AccountConverter.convertToAccount(pAccount);
			account.setProfile(ProfileConverter.entityToModel(pAccount.getProfileEntity()));
		}
		
		return account;
	}

	@Transactional
	public Account loadAccountBasicInfoByUsername(String username) {
		com.servinglynk.hmis.warehouse.model.live.HmisUser pAccount = daoFactory.getAccountDao().findByUsername(username);
		if (pAccount == null) {
			throw new AccountNotFoundException();
		}

		return (Account) AccountConverter.convertToBasicAccount(pAccount);
	}

	@Transactional
	public String getAccountStatus(String username) {
		if (!ValidationUtil.isValidEmail(username)) {
			throw new InvalidParameterException("invalid username: " + username);
		}
		com.servinglynk.hmis.warehouse.model.live.HmisUser pAccount = daoFactory.getAccountDao().findByUsername(username);
		if (pAccount == null) {
			throw new AccountNotFoundException();
		}
		String status = pAccount.getStatus();
		return status;
	}
	

	@Transactional
	public Account createAccount(Account account, String auditUser,
			String purpose) {
		
				// validate the username
				String gender = account.getGender();
				String username = account.getUsername();
				
				if (ValidationUtil.isEmpty(gender)) {
					throw new MissingParameterException("Invalid account information.");
				}
				
				
				if (ValidationUtil.isEmpty(username)) {
					throw new MissingParameterException("username is required.");
				}
				
				

				if (!ValidationUtil.isValidEmail(username)) {
					throw new InvalidParameterException("invalid username: " + username);
				}
				
				if(!ValidationUtil.isValidEmail(account.getEmailAddress())){
					throw new InvalidParameterException("invalid emailaddress: " + account.getEmailAddress());
				}

				// validate the password
				String password = account.getPassword();
				if (ValidationUtil.isEmpty(password)) {
					throw new MissingParameterException("password is required.");
				}

				// validate the first name
				String firstName = account.getFirstName();
				if (ValidationUtil.isEmpty(firstName)) {
					throw new MissingParameterException("first name is required.");
				}

				// validate the last name
				String lastName = account.getLastName();
				if (ValidationUtil.isEmpty(lastName)) {
					throw new MissingParameterException("last name is required.");
				}
				
				if(ValidationUtil.isNull(account.getOrganizationId())){
					throw new MissingParameterException("Organization details is required.");
				}
				
				if(account.getRole() == null || ValidationUtil.isNull(account.getRole().getId())) {
					throw new MissingParameterException("Role details is required");
				}
				

				validateAccount(account);

				Account existingAccount = findAccountByUsername(username);
				if (existingAccount != null) {
					throw new AccountAlreadyExistsException("an account with the specified username already exists. username: " + username);
				}

				// Make new verification object
				VerificationEntity pVerification = new VerificationEntity();
				pVerification.setToken(GeneralUtil.getUniqueToken(64));
				String verificationType = VERIFICATION_TYPE_ACCOUNT_CREATION;
				
				pVerification.setType(verificationType);
				pVerification.setCreatedBy(auditUser);
				pVerification.setCreatedAt(new Date());
				daoFactory.getVerificationDao().create(pVerification);

				// update country code only if language is present - language cannot be NULL, but country can be NULL.
				AccountPreferenceEntity pAccountPreference = new AccountPreferenceEntity();
				pAccountPreference.setCreatedAt(new Date());
				pAccountPreference.setCreatedBy(auditUser);

				if (account.getPreferences() != null) {
					/* setting locale preference */
					Locale locale = account.getLocale();
					if (locale != null) {
						pAccountPreference.setIsoLanguageCode(locale.getLanguage());
						pAccountPreference.setIsoCountryCode(locale.getCountry());
					}
					/* setting newsOptIn Preference */
					String newsLetterOptIn = account.getPreferences().getNewsletterOptIn();
					if (newsLetterOptIn != null)
						pAccountPreference.setNewsletterOptInCode(Boolean.valueOf(newsLetterOptIn) ? 1 : 0);
				}

				/* Create AccountEntity Preference for the AccountEntity */
				com.servinglynk.hmis.warehouse.model.live.HmisUser pAccount = AccountConverter.convertToPersistentAccount(account, null);
				pAccount.setStatus(ACCOUNT_STATUS_PENDING);
				
				pAccount.setPassword(HMISCryptographer.Encrypt(account.getPassword()));
				pAccount.setVerification(pVerification);
				pAccount.setCreatedBy(auditUser);
				pAccount.setCreatedAt(new Date());
				pAccount.setAccountPreference(pAccountPreference);
				pAccountPreference.setAccount(pAccount);

				/* Create a default AccountEntity Lockout for the AccountEntity */
				AccountLockoutEntity pAccountLockout = new AccountLockoutEntity();
				pAccountLockout.setCreatedBy(auditUser);
				pAccountLockout.setCreatedAt(new Date());
				pAccountLockout.setFailureCount(0);
				pAccountLockout.setLastLoginStatus(1);
				pAccountLockout.setAccount(pAccount);
				pAccount.setAccountLockout(pAccountLockout);
				GoogleAuthenticator authenticator = new GoogleAuthenticator();
				GoogleAuthenticatorKey key = authenticator.createCredentials();
				pAccount.setAuthenticatorSecret(key.getKey());
				
				System.out.println("QRCode URL "+key.getQRBarcodeURL("", "", key.getKey()));

				
				ProfileEntity profileEntity=null;
				
				if(account.getProfile()==null){
						// Get Standard Profile and assign that profile the user
					
				}else{
				 profileEntity = daoFactory.getProfileDao().getProfileById(account.getProfile().getId());
				 if(profileEntity==null) {
					profileEntity = ProfileConverter.modelToEntity(null, account.getProfile());
					 daoFactory.getProfileDao().createProfile(profileEntity);
				 }
				}
				
				pAccount.setProfileEntity(profileEntity);
				
				Organization pOrganization = daoFactory.getOrganizationDao().getOrganizationById(account.getOrganizationId());

				if(pOrganization==null) throw new OrganizationNotFound();

				pAccount.setOrganization(pOrganization);
				
				
				RoleEntity pRole = daoFactory.getRoleDao().getRoleByid(account.getRole().getId());
				if(pRole ==  null) throw new RoleNotFoundException();
				
				UserRoleMapEntity userRoleMapEntity = new UserRoleMapEntity();
				userRoleMapEntity.setAccountEntity(pAccount);
				userRoleMapEntity.setRoleEntity(pRole);
				
				if(account.getProjectGroup() != null){
				
				ProjectGroupEntity pProjectGroup = daoFactory.getProjectGroupDao().getProjectGroupById(account.getProjectGroup().getProjectGroupId());
				if(pProjectGroup == null) throw new ProjectGroupNotFoundException();
				
				pAccount.setProjectGroupEntity(pProjectGroup);
				}else{
					HmisUser loginUser = daoFactory.getAccountDao().findByUsername(auditUser);
					if(loginUser.getProjectGroupEntity() != null){
						pAccount.setProjectGroupEntity(loginUser.getProjectGroupEntity());
					}
				}
				
				daoFactory.getAccountDao().createAccount(pAccount);
				daoFactory.getAccountDao().createUserRole(userRoleMapEntity);
				
				account.setAccountId(pAccount.getId());
				account.setStatus(pAccount.getStatus());
				account.setVerificationToken(pVerification.getToken());
				account.setProfile(ProfileConverter.entityToModel(profileEntity));
				// send the account creation notification
				
				
				Notification notification = new Notification();
				notification.setMethod("EMAIL");
				notification.setType("HMIS_RESOURCE_CREATION");
				Recipients recipients = new Recipients();
				List<String> emails = new ArrayList<String>();
				emails.add(pAccount.getEmailAddress());
				recipients.setToRecipients(emails);
				notification.setRecipients(recipients);
				
				Parameters parameters = new Parameters();
				Parameter usernameParameter = new Parameter();
				usernameParameter.setKey("username");
				usernameParameter.setValue(pAccount.getEmailAddress());
				
				Parameter passwordParameter = new Parameter();
				passwordParameter.setKey("password");
				passwordParameter.setValue(account.getPassword());
				
				Parameter googleKeyParameter = new Parameter();
				googleKeyParameter.setKey("authenticatorSecret");
				googleKeyParameter.setValue(pAccount.getAuthenticatorSecret());
				
				Parameter qrCodeParameter = new Parameter();
				qrCodeParameter.setKey("qrcode");
				qrCodeParameter.setValue(key.getQRBarcodeURL("", "", key.getKey()));

				parameters.addParameter(usernameParameter);
				parameters.addParameter(passwordParameter);
				parameters.addParameter(googleKeyParameter);
				parameters.addParameter(qrCodeParameter);
				
				notification.setParameters(parameters);
				
	//			notificationServiceClient.createNotification(notification);				
			
		return account;
	}

	@Transactional
	public Account updateAccount(Account account, String auditUser) {
		
		ProfileEntity profileEntity = daoFactory.getProfileDao().getProfileById(account.getProfile().getId());
		
		if(profileEntity==null) throw new ProfileNotFoundException();
		
		com.servinglynk.hmis.warehouse.model.live.HmisUser pAccount = daoFactory.getAccountDao().findByUsername(account.getUsername());

		if (!ValidationUtil.isValidMaxLen(account.getFirstName(), new Integer(validationBean.getFnMaxLength()))) {
			throw new InvalidParameterException("First Name cannot be greater than 128 characters");
		}

		if (!ValidationUtil.isValidMaxLen(account.getUsername(), new Integer(validationBean.getMaxLength()))) {
			throw new InvalidParameterException("User Name cannot be greater than 256 characters");
		}

		if (!ValidationUtil.isValidMaxLen(account.getLastName(), new Integer(validationBean.getLnMaxLength()))) {
			throw new InvalidParameterException("Last Name cannot be greater than 128 characters");
		}

		if (!ValidationUtil.isValidMaxLen(account.getMiddleName(), new Integer(validationBean.getMnMaxLength()))) {
			throw new InvalidParameterException("Middle Name cannot be greater than 128 characters");
		}

		if (ValidationUtil.isNotNull(account.getFirstName())) {
			if (account.getFirstName().length() == 0) {
				throw new MissingParameterException("first name is empty.");
			}
			pAccount.setFirstName(account.getFirstName());
		}

		if (ValidationUtil.isNotNull(account.getMiddleName())) {
			pAccount.setMiddleName(account.getMiddleName());
		}


		if (ValidationUtil.isNotNull(account.getLastName())) {
			if (account.getLastName().length() == 0) {
				throw new MissingParameterException("last name is empty.");
			}
			pAccount.setLastName(account.getLastName());
		}
		
		if(ValidationUtil.isNotNull(account.getGender())){
		//	pAccount.setGender(account.getGender());
		}

		pAccount.setModifiedBy(auditUser);
		pAccount.setModifiedAt(new Date());
		pAccount.setProfileEntity(profileEntity);
		com.servinglynk.hmis.warehouse.model.live.HmisUser upAccount= daoFactory.getAccountDao().updateAccount(pAccount);
		return (Account) AccountConverter.convertToAccount(upAccount);
	}

	@Transactional
	public Preferences updatePreferences(Account account, String auditUser) {
		com.servinglynk.hmis.warehouse.model.live.HmisUser pAccount = daoFactory.getAccountDao().findByUsername(account.getUsername());
		AccountPreferenceEntity pAccountPreference = pAccount.getAccountPreference();

		if (account.getPreferences() != null) {
			// validate & update Locale parameters
			
				if (pAccountPreference != null) {
					pAccountPreference.setIsoLanguageCode(account.getLocale().getLanguage());
					pAccountPreference.setIsoCountryCode(account.getLocale().getCountry());
				}
			

			// validate & update NewsOptIn parameter
			String newsLetterOptIn = account.getPreferences().getNewsletterOptIn();
			if (newsLetterOptIn != null) {
				if (ValidationUtil.isValidBoolean(newsLetterOptIn)) {
					if (pAccountPreference != null)
						pAccountPreference.setNewsletterOptInCode(Boolean.valueOf(newsLetterOptIn) ? 1 : 0);
				} else {
					throw new InvalidParameterException("Invalid NewsOptIn preference");
				}
			}

			// update common attributes for AccountPreference
			pAccountPreference.setModifiedAt(new Date());
			pAccountPreference.setModifiedBy(auditUser);
			pAccountPreference.setAccount(pAccount);
			pAccount.setAccountPreference(pAccountPreference);
			daoFactory.getAccountDao().updateAccount(pAccount);
			return account.getPreferences();
		}
		return new Preferences();
	}

	@Transactional
	public Account updatePassword(String username, PasswordChange passwordChange,
			String userService) {

		com.servinglynk.hmis.warehouse.model.live.HmisUser pAccount = daoFactory.getAccountDao().findByUsername(username);

		// validate current password
		if (!pAccount.getPassword().equalsIgnoreCase(HMISCryptographer.Encrypt(passwordChange.getcurrentPassword()))) {
			throw new InvalidCurrentPasswordException();
		}

		// validate the length of new password
		if (passwordChange.getnewPassword().length() < validationBean.getPwMinLength()) {
			throw new InvalidParameterException("password length required to be at least " + validationBean.getPwMinLength()
					+ " characters");
		}

		if (passwordChange.getnewPassword().length() > validationBean.getPwMaxLength()) {
			throw new InvalidParameterException("password length required to be less then " + validationBean.getPwMaxLength()
					+ " characters");
		}

		pAccount.setPassword(HMISCryptographer.Encrypt(passwordChange.getnewPassword()));
		daoFactory.getAccountDao().updateAccount(pAccount);
		return AccountConverter.convertToAccount(pAccount);
		
	}

	
	private void validateAccount(Account account) {

		if (account.getPassword() != null) {

			if (!ValidationUtil.isValidPassword(account.getPassword())) {
				throw new InvalidParameterException("Password should contain only alpha numeric characters");
			}

			if (!ValidationUtil.isValidMinLen(account.getPassword(), new Integer(validationBean.getPwMinLength()))) {
				throw new InvalidParameterException("Password cannot be less than 6 characters");
			}

			if (!ValidationUtil.isValidMaxLen(account.getPassword(), new Integer(validationBean.getPwMaxLength()))) {
				throw new InvalidParameterException("Password cannot be greater than 256 characters");
			}
		}

		if (!ValidationUtil.isValidMaxLen(account.getFirstName(), new Integer(validationBean.getFnMaxLength()))) {
			throw new InvalidParameterException("First Name cannot be greater than 128 characters");
		}

		if (!ValidationUtil.isValidMaxLen(account.getUsername(), new Integer(validationBean.getMaxLength()))) {
			throw new InvalidParameterException("User Name cannot be greater than 256 characters");
		}

		if (!ValidationUtil.isValidMaxLen(account.getLastName(), new Integer(validationBean.getLnMaxLength()))) {
			throw new InvalidParameterException("Last Name cannot be greater than 128 characters");
		}

		if (!ValidationUtil.isValidMaxLen(account.getMiddleName(), new Integer(validationBean.getMnMaxLength()))) {
			throw new InvalidParameterException("Middle Name cannot be greater than 128 characters");
		}

	}

	@Transactional
	public void createUserRole(String username, Role role) {
		
		HmisUser accountEntity= daoFactory.getAccountDao().findByUsername(username);
		if(accountEntity==null) throw new AccountNotFoundException("Account with "+username+" user name not found");
		
		RoleEntity roleEntity = daoFactory.getRoleDao().getRoleByid(role.getId());
		if(roleEntity==null) throw new RoleNotFoundException();
		
		UserRoleMapEntity userRoleMapEntity = new UserRoleMapEntity();
		userRoleMapEntity.setAccountEntity(accountEntity);
		userRoleMapEntity.setRoleEntity(roleEntity);
		
		userRoleMapEntity = daoFactory.getAccountDao().createUserRole(userRoleMapEntity);	
	}

	@Transactional
	public void updateUserRole(String username, Role role) {
		HmisUser accountEntity= daoFactory.getAccountDao().findByUsername(username);
		if(accountEntity==null) throw new AccountNotFoundException("Account with "+username+" user name not found");
		
		RoleEntity roleEntity = daoFactory.getRoleDao().getRoleByid(role.getId());
		if(roleEntity==null) throw new RoleNotFoundException();
		

		List<UserRoleMapEntity> userRoleMapEntities = daoFactory.getAccountDao().getUserMapByUserId(accountEntity.getId());
		
		for(UserRoleMapEntity userRoleMapEntity : userRoleMapEntities){
			daoFactory.getAccountDao().daeleteUserRole(userRoleMapEntity);
		}
		
		UserRoleMapEntity entity = new UserRoleMapEntity();
		entity.setAccountEntity(accountEntity);
		entity.setRoleEntity(roleEntity);
		
		daoFactory.getAccountDao().createUserRole(entity);
	}

	@Transactional
	public Accounts getUsersByOrganization(UUID organizationId){
		Accounts accounts = new Accounts(); 
		List<HmisUser> accountEntities = daoFactory.getAccountDao().getAllUsersByOranization(organizationId);
		
		for(HmisUser accountEntity : accountEntities){
			accounts.addAccount(AccountConverter.convertToAccount(accountEntity));
		}
		
		return accounts;
	}
	
	@Transactional
	public boolean checkApiAuthorizationForUser(String accessToken,String apiMethodId){
		
		ApiMethodEntity apiMethodEntity = daoFactory.getApiMethodDao().findByExternalId(apiMethodId);
		
		if(apiMethodEntity==null) throw new ApiMethodNotFoundException();
		
		if(!apiMethodEntity.getRequiresAccessToken()) return true;
		
		SessionEntity sessionEntity = null;
		
		if (ValidationUtil.isEmpty(accessToken) == false)	{
			sessionEntity = daoFactory.getSessionDao().findBySessionTokenForInterceptor(accessToken);
			if(sessionEntity == null){
				sessionEntity = daoFactory.getSessionDao().findBySessionToken(accessToken);
			}
		}
		
		if(sessionEntity==null) throw new AccessDeniedException();
		
			ProfileEntity profileEntity = sessionEntity.getAccount().getProfileEntity();
			
			if(!daoFactory.getAccountDao().checkApiMethodAccess(profileEntity.getId(), apiMethodEntity.getId())){
					
					List<PermissionSetEntity> permissionSets = daoFactory.getPermissionSetDao().getAssignedPermissionSets(sessionEntity.getAccount().getId());
					if(permissionSets.size()==0)	throw new AccessDeniedException("User doesn't have permission for the method "+apiMethodEntity.getFriendlyName());
					 if(!daoFactory.getPermissionSetDao().checkAssignedPermissonSet(permissionSets, apiMethodEntity))
						 throw new AccessDeniedException("User doesn't have permission for the method "+apiMethodEntity.getFriendlyName());
				}
				
			logger.debug("user having permission to access API method {} ", apiMethodEntity.getFriendlyName());

		return true;
	}
}
