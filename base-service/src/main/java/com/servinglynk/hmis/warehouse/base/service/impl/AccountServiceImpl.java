package com.servinglynk.hmis.warehouse.base.service.impl;

import static com.servinglynk.hmis.warehouse.common.Constants.ACCOUNT_STATUS_ACTIVE;
import static com.servinglynk.hmis.warehouse.common.Constants.VERIFICATION_TYPE_ACCOUNT_CREATION;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.service.AccountService;
import com.servinglynk.hmis.warehouse.base.service.converter.AccountConverter;
import com.servinglynk.hmis.warehouse.base.service.converter.ProfileConverter;
import com.servinglynk.hmis.warehouse.base.service.converter.RoleConverter;
import com.servinglynk.hmis.warehouse.base.service.core.security.GoogleAuthenticator;
import com.servinglynk.hmis.warehouse.base.service.core.security.GoogleAuthenticatorKey;
import com.servinglynk.hmis.warehouse.client.notificationservice.NotificationServiceClient;
import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.common.GeneralUtil;
import com.servinglynk.hmis.warehouse.common.ValidationUtil;
import com.servinglynk.hmis.warehouse.common.security.HMISCryptographer;
import com.servinglynk.hmis.warehouse.common.util.DateUtil;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.Accounts;
import com.servinglynk.hmis.warehouse.core.model.ClientConsent;
import com.servinglynk.hmis.warehouse.core.model.ClientConsents;
import com.servinglynk.hmis.warehouse.core.model.GlobalProject;
import com.servinglynk.hmis.warehouse.core.model.Notification;
import com.servinglynk.hmis.warehouse.core.model.Parameter;
import com.servinglynk.hmis.warehouse.core.model.PasswordChange;
import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.core.model.Roles;
import com.servinglynk.hmis.warehouse.core.model.exception.AccessDeniedException;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidParameterException;
import com.servinglynk.hmis.warehouse.model.base.ApiMethodEntity;
import com.servinglynk.hmis.warehouse.model.base.HmisUser;
import com.servinglynk.hmis.warehouse.model.base.PermissionSetEntity;
import com.servinglynk.hmis.warehouse.model.base.ProfileEntity;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.model.base.RoleEntity;
import com.servinglynk.hmis.warehouse.model.base.SessionEntity;
import com.servinglynk.hmis.warehouse.model.base.UserRoleMapEntity;
import com.servinglynk.hmis.warehouse.model.base.VerificationEntity;
import com.servinglynk.hmis.warehouse.service.exception.AccountNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ApiMethodNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.InvalidCurrentPasswordException;
import com.servinglynk.hmis.warehouse.service.exception.ProfileNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ProjectGroupNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.RoleNotFoundException;

public class AccountServiceImpl extends ServiceBase implements AccountService {
	private static String SUPER_ADMIN = "SUPERADMIN";
	@Autowired
	NotificationServiceClient notificationServiceClient;

	@Transactional
	public Account findAccountByUsername(String username) {
		HmisUser pAccount = daoFactory.getAccountDao()
				.findByUsername(username);

		Account account = null;
		if (pAccount != null) {
			account = AccountConverter.convertToAccount(pAccount);
		}
		return account;
	}

	@Transactional
	public Account createAccount(Account account, String auditUser, String purpose) {

		HmisUser pAuditUser = daoFactory.getAccountDao().findByUsername(auditUser);

		HmisUser pAccount = AccountConverter.convertToPersistentAccount(account, null);

		if (!account.getConfirmPassword().equals(account.getPassword())) {
			throw new InvalidParameterException("Password & Confirm Passwords are different");
		}

		ProfileEntity profileEntity = daoFactory.getProfileDao().getProfileById(account.getProfile().getId());
		if (profileEntity == null) {
			throw new ProfileNotFoundException();
		}

		if (profileEntity.getProfileName().equalsIgnoreCase("Super Admin Profile")) {
			if (!pAuditUser.getProfileEntity().getProfileName().equalsIgnoreCase("Super Admin Profile")) {
				throw new AccessDeniedException("Only Super admin can create a user with super admin profile");
			}
		}


		RoleEntity pRole = daoFactory.getRoleDao().getRoleByid(account.getRole().getId());
		if (pRole == null) {
			throw new RoleNotFoundException();
		}

		// Make new verification object
		VerificationEntity pVerification = new VerificationEntity();
		pVerification.setToken(GeneralUtil.getUniqueToken(64));
		pVerification.setType(VERIFICATION_TYPE_ACCOUNT_CREATION);
		pVerification.setCreatedBy(auditUser);
		pVerification.setCreatedAt(new Date());
		daoFactory.getVerificationDao().create(pVerification);

		pAccount.setPassword(HMISCryptographer.Encrypt(account.getPassword()));
		pAccount.setVerification(pVerification);
		pAccount.setCreatedBy(auditUser);
		pAccount.setCreatedAt(new Date());

		GoogleAuthenticator authenticator = new GoogleAuthenticator();
		GoogleAuthenticatorKey key = authenticator.createCredentials();
		pAccount.setAuthenticatorSecret(key.getKey());
		pAccount.setStatus(Constants.ACCOUNT_STATUS_PENDING);

		pAccount.setTwoFactorAuthentication(account.isTwoFactorAuthentication());

		pAccount.setProfileEntity(profileEntity);

		UserRoleMapEntity userRoleMapEntity = new UserRoleMapEntity();
		userRoleMapEntity.setAccountEntity(pAccount);
		userRoleMapEntity.setRoleEntity(pRole);
		
		boolean isSuperAdmin = isSuperAdmin(pAuditUser.getId());
		if (account.getProjectGroup() != null && isSuperAdmin) {
			ProjectGroupEntity pProjectGroup = daoFactory.getProjectGroupDao()
					.getProjectGroupById(account.getProjectGroup().getProjectGroupId());
			if (pProjectGroup == null)
				throw new ProjectGroupNotFoundException("Project group selected does not exist.");

			pAccount.setProjectGroupEntity(pProjectGroup);
		} else {
			if (pAuditUser.getProjectGroupEntity() != null) {
				pAccount.setProjectGroupEntity(pAuditUser.getProjectGroupEntity());
			}else{
				throw new AccessDeniedException("Login user does not have project group.");
			}
		}
		if(environment.getProperty("password.age.in.days")!=null) {
			Integer age = Integer.parseInt(environment.getProperty("password.age.in.days"));
			pAccount.setPasswordExpiresAt(DateUtil.addDays(new Date(),age));
		}
		pAccount.setProjectGroupCode(pAccount.getProjectGroupEntity().getProjectGroupCode());
		daoFactory.getAccountDao().createAccount(pAccount);
		daoFactory.getAccountDao().createUserRole(userRoleMapEntity);

		account.setAccountId(pAccount.getId());
		account.setStatus(pAccount.getStatus());
		account.setVerificationToken(pVerification.getToken());
		account.setProfile(ProfileConverter.entityToModel(profileEntity));
		// send the account creation notification

		Notification notification = new Notification();
		notification.setMethod("EMAIL");
		notification.setType("HMIS_USER_CREATION");
		if(pAuditUser.getProjectGroupEntity()!=null)
			notification.setSender(pAuditUser.getProjectGroupEntity().getSenderEmail());
		notification.getParameters().addParameter(new Parameter("username", account.getUsername()));
		notification.getParameters().addParameter(new Parameter("password", account.getPassword()));
		notification.getParameters().addParameter(new Parameter("name",account.getFirstName()+" "+account.getLastName()));
		notification.getParameters().addParameter(new Parameter("verificationtoken", pVerification.getToken()));
		if (purpose.equalsIgnoreCase("DEV_COMPANY_SETUP")) {
			notification.getParameters().addParameter(new Parameter("tokenType", "DEV_COMPANY_SETUP"));
		}else {
			notification.getParameters().addParameter(new Parameter("tokenType", "USER_SETUP"));
		}
		notification.getRecipients().addToRecipient(account.getEmailAddress());
		notificationServiceClient.createNotification(notification);		
		
		return AccountConverter.convertToAccount(pAccount);
	}
	/***
	 * Determines if the logged in user is a super admin
	 * @param userid
	 * @return
	 */
	private boolean isSuperAdmin(UUID userid) {
		List<UserRoleMapEntity> userMapByUserId = daoFactory.getAccountDao().getUserMapByUserId(userid);
		if(CollectionUtils.isNotEmpty(userMapByUserId)) {
			for(UserRoleMapEntity userRoleMap : userMapByUserId) {
				if(userRoleMap != null) {
					RoleEntity roleEntity = userRoleMap.getRoleEntity();
					if(roleEntity !=null) {
						if(StringUtils.equals(SUPER_ADMIN,roleEntity.getRoleCode())) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	@Transactional
	public Account updateAccount(Account account, String auditUser) {

		HmisUser pAccount = daoFactory.getAccountDao().findByUserId(account.getAccountId());
		
		ProfileEntity profileEntity = null;
		if (account.getProfile() != null && account.getProfile().getId() != null) {
			profileEntity = daoFactory.getProfileDao().getProfileById(account.getProfile().getId());
			if (profileEntity == null)
				throw new ProfileNotFoundException();
		}

/*		ProfileEntity pProfile = pAccount.getProfileEntity();
		if(pProfile.getProfileName().equalsIgnoreCase("Customer Admin Profile")){
			if(pProfile.getId()!=profileEntity.getId()){
			  List<HmisUser> customerAdmins = daoFactory.getAccountDao().getCustomerAdmins(pAccount.getProjectGroupEntity().getProjectGroupCode());
			  if(customerAdmins.size()==1) throw new AccessDeniedException("Profile cannot be updated as this is the only user associated with Customer admin profile");
			}
		}*/
	
		if(account.getStatus()!=null && account.getStatus().equalsIgnoreCase(Constants.ACCOUNT_STATUS_INACTIVE)){
			pAccount.setStatus(Constants.ACCOUNT_STATUS_INACTIVE);
		}

		pAccount.setFirstName(account.getFirstName());
		pAccount.setLastName(account.getLastName());
		pAccount.setMiddleName(account.getMiddleName());
		pAccount.setModifiedBy(auditUser);
		pAccount.setModifiedAt(new Date());
		if (profileEntity != null)
			pAccount.setProfileEntity(profileEntity);
		pAccount.setTwoFactorAuthentication(account.isTwoFactorAuthentication());
		daoFactory.getAccountDao().updateAccount(pAccount);
		return account;
	}
		
	@Transactional
	public Account activateAccount(Account account,String auditUser) {
		HmisUser pAccount = daoFactory.getAccountDao().findByUserId(account.getAccountId());
		if(pAccount==null) throw new AccountNotFoundException();
		if(!pAccount.getStatus().equalsIgnoreCase(Constants.ACCOUNT_STATUS_INACTIVE)) 
			throw new AccessDeniedException("Account cannot be activated from "+pAccount.getStatus()+" status");
		pAccount.setStatus(ACCOUNT_STATUS_ACTIVE);
		daoFactory.getAccountDao().updateAccount(pAccount);
		return account;
	}

	@Transactional
	public Account updatePassword(Account account, PasswordChange passwordChange, String userService) {

		HmisUser pAccount = daoFactory.getAccountDao().findByUserId(account.getAccountId());

		if(pAccount==null) throw new AccountNotFoundException();
		
		// validate current password
		if (!pAccount.getPassword().equalsIgnoreCase(HMISCryptographer.Encrypt(passwordChange.getCurrentPassword()))) {
			throw new InvalidCurrentPasswordException();
		}

		pAccount.setPassword(HMISCryptographer.Encrypt(passwordChange.getNewPassword()));
		pAccount.setForcePasswordChange(false);
		daoFactory.getAccountDao().updateAccount(pAccount);
		Notification notification = new Notification();
		notification.setMethod("EMAIL");
		if(pAccount.getProjectGroupEntity()!=null)
			notification.setSender(pAccount.getProjectGroupEntity().getSenderEmail());
		notification.setType("HMIS_ACCOUNT_PASSWORD_CHANGE");
		notification.getRecipients().addToRecipient(pAccount.getEmailAddress());
		notification.getParameters().addParameter(new Parameter("username", pAccount.getFirstName()+" "+pAccount.getLastName()));
		notificationServiceClient.createNotification(notification);
		
		return AccountConverter.convertToAccount(pAccount);

	}

	@Transactional
	public Accounts getUsersByProjectGroup(String projectGroupCode) {
		Accounts accounts = new Accounts();
		List<HmisUser> accountEntities = daoFactory.getAccountDao().findUsersByProjectGroup(projectGroupCode);

		for (HmisUser accountEntity : accountEntities) {
			Account account =  AccountConverter.convertToAccount(accountEntity);
			List<UserRoleMapEntity> userroles = daoFactory.getAccountDao().getUserMapByUserId(accountEntity.getId());
			for(UserRoleMapEntity entity : userroles){
				  account.addRole(RoleConverter.entityToModel(entity.getRoleEntity()));
			}
			accounts.addAccount(account);

		}

		return accounts;
	}

	@Transactional
	public Account getAccount(Account account, boolean onlyBasicInfo) {
		HmisUser pAccount = daoFactory.getAccountDao().findByUserId(account.getAccountId());
		if (pAccount == null)
			throw new AccountNotFoundException();
		account = AccountConverter.convertToAccountLite(pAccount);
		List<UserRoleMapEntity> userroles = daoFactory.getAccountDao().getUserMapByUserId(pAccount.getId());

/*		for(UserRoleMapEntity entity : userroles){
			account.addRole(RoleConverter.entityToModel(entity.getRoleEntity()));
		}*/
		return account;
	}
	
	
	@Transactional
	public void addRoleToUser(UUID userid, Roles roles) {
		HmisUser accountEntity = daoFactory.getAccountDao().findByUserId(userid);
		if (accountEntity == null)
			throw new AccountNotFoundException();

		for (Role role : roles.getRoles()) {

			RoleEntity roleEntity = daoFactory.getRoleDao().getRoleByid(role.getId());
			if (roleEntity != null) {

				UserRoleMapEntity userRoleMapEntity = daoFactory.getAccountDao().getUserRoleByUserIdAndRoleId(userid,
						roleEntity.getId());
				if (userRoleMapEntity == null) {
					UserRoleMapEntity entity = new UserRoleMapEntity();
					entity.setAccountEntity(accountEntity);
					entity.setRoleEntity(roleEntity);
					daoFactory.getAccountDao().createUserRole(entity);
				}
			}

		}
	}
	
	@Transactional
	public void removeRoleFromUser(UUID userid, UUID roleid) {
		HmisUser accountEntity= daoFactory.getAccountDao().findByUserId(userid);
		if(accountEntity==null) throw new AccountNotFoundException();
		
		UserRoleMapEntity entity = daoFactory.getAccountDao().getUserRoleByUserIdAndRoleId(userid, roleid);
		if(entity==null) throw new RoleNotFoundException("Role is not assiciated to this user");
		
		List<UserRoleMapEntity> userroles = daoFactory.getAccountDao().getUserMapByUserId(accountEntity.getId());
		if(userroles.size()==1){
			throw new AccessDeniedException("User should be associated with atleast one role");
		}
		
		daoFactory.getAccountDao().daeleteUserRole(entity);
	}
	
	

	@Transactional
	public void deleteAccount(Account account, Account auditAccount) {
		HmisUser pAccount = daoFactory.getAccountDao().findByUserId(account.getAccountId());
		if (pAccount == null)
			throw new AccountNotFoundException();
		pAccount.setStatus(Constants.ACCOUNT_STATUS_DELETED);
		pAccount.setModifiedAt(new Date());
		pAccount.setModifiedBy(account.getUsername());
		daoFactory.getAccountDao().updateAccount(pAccount);
	}

	@Transactional
	public boolean checkApiAuthorizationForUser(Account account, String apiMethodId) {

		ApiMethodEntity apiMethodEntity = daoFactory.getApiMethodDao().findByExternalId(apiMethodId);

		if (apiMethodEntity == null)
			throw new ApiMethodNotFoundException();

		if (!apiMethodEntity.getRequiresAccessToken())
			return true;

		if (!daoFactory.getAccountDao().checkApiMethodAccess(account.getProfile().getId(), apiMethodEntity.getId())) {

/*			List<PermissionSetEntity> permissionSets = daoFactory.getPermissionSetDao()
					.getAssignedPermissionSets(account.getAccountId());
			if (permissionSets.size() == 0)
				throw new AccessDeniedException(
						"User doesn't have permission for the method " + apiMethodEntity.getFriendlyName());
			if (!daoFactory.getPermissionSetDao().checkAssignedPermissonSet(permissionSets, apiMethodEntity))
				throw new AccessDeniedException(
						"User doesn't have permission for the method " + apiMethodEntity.getFriendlyName());*/
		}

		logger.debug("user having permission to access API method {} ", apiMethodEntity.getFriendlyName());

		return true;
	}
	
	@Transactional
	public boolean checkClientConsentAuthorizationForUser(Account account, UUID clientid) {

		ClientConsents consents = serviceFactory.getClientConsentService().getClientConsents(clientid, null, null);
		if(consents.getClientConsents().isEmpty()) throw new AccessDeniedException("Client does not have any consents");
		
		List<UUID> projectids = new ArrayList<>();
		for(ClientConsent clientConsent : consents.getClientConsents()) {
			for(GlobalProject globalProject : clientConsent.getGlobalProjects()) {
				projectids.add(globalProject.getId());
			}
		}
		System.out.println(projectids.isEmpty());
		System.out.println(projectids.size());
		if(projectids.size() == 0) throw new AccessDeniedException("Client does not given consent to any global project");
		
		return serviceFactory.getGlobalProjectService().checkGlobalProjectUser(projectids,account.getAccountId());
	}
	
	@Transactional
	public void extendUserSession(String accessToken) {
		SessionEntity sessionEntity = null;
		if (ValidationUtil.isEmpty(accessToken) == false) {
			sessionEntity = daoFactory.getSessionDao().findBySessionTokenForInterceptor(accessToken);
			if (sessionEntity == null) {
				sessionEntity = daoFactory.getSessionDao().findBySessionToken(accessToken);
			}
		}
		
		long diff = sessionEntity.getExpiresAt().getTime()  - System.currentTimeMillis();
		
		if(diff < (60 * 1000)) {
			sessionEntity.setExpiresAt(new Date(System.currentTimeMillis() +  (sessionEntity.getTrustedApp().getExpirationTime() * 1000) ));
			daoFactory.getSessionDao().updateSessionEntity(sessionEntity);
		}
	}
}