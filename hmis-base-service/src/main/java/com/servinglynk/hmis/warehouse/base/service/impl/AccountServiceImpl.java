package com.servinglynk.hmis.warehouse.base.service.impl;

import static com.servinglynk.hmis.warehouse.common.Constants.ACCOUNT_STATUS_ACTIVE;
import static com.servinglynk.hmis.warehouse.common.Constants.VERIFICATION_TYPE_ACCOUNT_CREATION;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.service.AccountService;
import com.servinglynk.hmis.warehouse.base.service.converter.AccountConverter;
import com.servinglynk.hmis.warehouse.base.service.converter.ProfileConverter;
import com.servinglynk.hmis.warehouse.base.service.converter.RoleConverter;
import com.servinglynk.hmis.warehouse.base.service.core.security.GoogleAuthenticator;
import com.servinglynk.hmis.warehouse.base.service.core.security.GoogleAuthenticatorKey;
import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.common.GeneralUtil;
import com.servinglynk.hmis.warehouse.common.ValidationUtil;
import com.servinglynk.hmis.warehouse.common.security.HMISCryptographer;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.Accounts;
import com.servinglynk.hmis.warehouse.core.model.PasswordChange;
import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.core.model.Roles;
import com.servinglynk.hmis.warehouse.core.model.exception.AccessDeniedException;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidParameterException;
import com.servinglynk.hmis.warehouse.model.base.AccountLockoutEntity;
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

	@Transactional
	public Account findAccountByUsername(String username) {
		com.servinglynk.hmis.warehouse.model.base.HmisUser pAccount = daoFactory.getAccountDao()
				.findByUsername(username);

		Account account = null;
		if (pAccount != null) {
			account = AccountConverter.convertToAccount(pAccount);
			account.setProfile(ProfileConverter.entityToModel(pAccount.getProfileEntity()));
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

		/* Create AccountEntity Preference for the AccountEntity */

		pAccount.setPassword(HMISCryptographer.Encrypt(account.getPassword()));
		pAccount.setVerification(pVerification);
		pAccount.setCreatedBy(auditUser);
		pAccount.setCreatedAt(new Date());

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
		if (purpose.equalsIgnoreCase("DEV_COMPANY_SETUP")) {
			pAccount.setStatus(ACCOUNT_STATUS_ACTIVE);
		} else {
			pAccount.setStatus(ACCOUNT_STATUS_ACTIVE);

		}

		pAccount.setTwoFactorAuthentication(account.isTwoFactorAuthentication());

		pAccount.setProfileEntity(profileEntity);

		UserRoleMapEntity userRoleMapEntity = new UserRoleMapEntity();
		userRoleMapEntity.setAccountEntity(pAccount);
		userRoleMapEntity.setRoleEntity(pRole);

		if (account.getProjectGroup() != null) {

			ProjectGroupEntity pProjectGroup = daoFactory.getProjectGroupDao()
					.getProjectGroupById(account.getProjectGroup().getProjectGroupId());
			if (pProjectGroup == null)
				throw new ProjectGroupNotFoundException();

			pAccount.setProjectGroupEntity(pProjectGroup);
		} else {
			HmisUser loginUser = daoFactory.getAccountDao().findByUsername(auditUser);
			if (loginUser.getProjectGroupEntity() != null) {
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

		return account;
	}

	@Transactional
	public Account updateAccount(Account account, String auditUser) {
		ProfileEntity profileEntity = null;
		if (account.getProfile() != null && account.getProfile().getId() != null) {
			profileEntity = daoFactory.getProfileDao().getProfileById(account.getProfile().getId());
			if (profileEntity == null)
				throw new ProfileNotFoundException();
		}

		HmisUser pAccount = daoFactory.getAccountDao().findByUserId(account.getAccountId());
		pAccount.setFirstName(account.getFirstName());
		pAccount.setLastName(account.getLastName());
		pAccount.setMiddleName(account.getMiddleName());
		pAccount.setModifiedBy(auditUser);
		pAccount.setModifiedAt(new Date());
		if (profileEntity != null)
			pAccount.setProfileEntity(profileEntity);
		pAccount.setTwoFactorAuthentication(account.isTwoFactorAuthentication());
		HmisUser upAccount = daoFactory.getAccountDao().updateAccount(pAccount);
		return (Account) AccountConverter.convertToAccount(upAccount);
	}
	
	@Transactional
	public Account activateAccount(Account account,String auditUser) {
		HmisUser pAccount = daoFactory.getAccountDao().findByUserId(account.getAccountId());
		if(pAccount==null) throw new AccountNotFoundException();
		pAccount.setStatus(ACCOUNT_STATUS_ACTIVE);
		daoFactory.getAccountDao().updateAccount(pAccount);
		return account;
	}

	@Transactional
	public Account updatePassword(Account account, PasswordChange passwordChange, String userService) {

		HmisUser pAccount = daoFactory.getAccountDao().findByUserId(account.getAccountId());

		// validate current password
		if (!pAccount.getPassword().equalsIgnoreCase(HMISCryptographer.Encrypt(passwordChange.getCurrentPassword()))) {
			throw new InvalidCurrentPasswordException();
		}

		pAccount.setPassword(HMISCryptographer.Encrypt(passwordChange.getNewPassword()));
		daoFactory.getAccountDao().updateAccount(pAccount);
		return AccountConverter.convertToAccount(pAccount);

	}

	@Transactional
	public Accounts getUsersByProjectGroup(String projectGroupCode) {
		Accounts accounts = new Accounts();
		List<HmisUser> accountEntities = daoFactory.getAccountDao().findUsersByProjectGroup(projectGroupCode);

		for (HmisUser accountEntity : accountEntities) {
			Account account =  AccountConverter.convertToAccount(accountEntity);
			List<UserRoleMapEntity> userroles = daoFactory.getAccountDao().getUserMapByUserId(accountEntity.getId());
			Roles roles = new Roles();
			for(UserRoleMapEntity entity : userroles){
				  roles.addRole(RoleConverter.entityToModel(entity.getRoleEntity()));
			}
			account.setRoles(roles);
			accounts.addAccount(account);

		}

		return accounts;
	}

	@Transactional
	public Account getAccount(Account account, boolean onlyBasicInfo) {
		HmisUser pAccount = daoFactory.getAccountDao().findByUserId(account.getAccountId());
		if (pAccount == null)
			throw new AccountNotFoundException();
		account = AccountConverter.convertToAccount(pAccount);
		List<UserRoleMapEntity> userroles = daoFactory.getAccountDao().getUserMapByUserId(pAccount.getId());
		Roles roles = new Roles();
		for(UserRoleMapEntity entity : userroles){
			  roles.addRole(RoleConverter.entityToModel(entity.getRoleEntity()));
		}
		account.setRoles(roles);
		return account;
	}
	
	
	@Transactional
	public void addRoleToUser(UUID userid, Role role) {
		HmisUser accountEntity= daoFactory.getAccountDao().findByUserId(userid);
		if(accountEntity==null) throw new AccountNotFoundException();
		
		RoleEntity roleEntity = daoFactory.getRoleDao().getRoleByid(role.getId());
		if(roleEntity==null) throw new RoleNotFoundException();

		UserRoleMapEntity entity = new UserRoleMapEntity();
		entity.setAccountEntity(accountEntity);
		entity.setRoleEntity(roleEntity);
		
		daoFactory.getAccountDao().createUserRole(entity);
	}
	
	@Transactional
	public void removeRoleFromUser(UUID userid, UUID roleid) {
		HmisUser accountEntity= daoFactory.getAccountDao().findByUserId(userid);
		if(accountEntity==null) throw new AccountNotFoundException();
		

		UserRoleMapEntity entity = daoFactory.getAccountDao().getUserRoleByUserIdAndRoleId(userid, roleid);
		if(entity==null) throw new RoleNotFoundException("Role is not assiciated with user");
		daoFactory.getAccountDao().daeleteUserRole(entity);
	}
	
	

	@Transactional
	public void deleteAccount(Account account, Account auditAccount) {
		HmisUser pAccount = daoFactory.getAccountDao().findByUserId(account.getAccountId());
		if (pAccount == null)
			throw new AccountNotFoundException();
		pAccount.setStatus(Constants.ACCOUNT_STATUS_DISABLED);
		pAccount.setModifiedAt(new Date());
		pAccount.setModifiedBy(account.getUsername());
		daoFactory.getAccountDao().updateAccount(pAccount);
	}

	@Transactional
	public void addUserRole(Account account, Role role) {

		HmisUser accountEntity = daoFactory.getAccountDao().findByUserId(account.getAccountId());
		if (accountEntity == null)
			throw new AccountNotFoundException("Account not found");

		RoleEntity roleEntity = daoFactory.getRoleDao().getRoleByid(role.getId());
		if (roleEntity == null)
			throw new RoleNotFoundException();

		UserRoleMapEntity userRoleMapEntity = new UserRoleMapEntity();
		userRoleMapEntity.setAccountEntity(accountEntity);
		userRoleMapEntity.setRoleEntity(roleEntity);

		userRoleMapEntity = daoFactory.getAccountDao().createUserRole(userRoleMapEntity);
	}

	@Transactional
	public void removeUserRole(Account account, Role role) {

		/*
		 * HmisUser accountEntity=
		 * daoFactory.getAccountDao().findByUserId(account.getAccountId());
		 * if(accountEntity==null) throw new
		 * AccountNotFoundException("Account not found");
		 * 
		 * RoleEntity roleEntity =
		 * daoFactory.getRoleDao().getRoleByid(role.getId());
		 * if(roleEntity==null) throw new RoleNotFoundException();
		 * 
		 * UserRoleMapEntity userRoleMapEntity = new UserRoleMapEntity();
		 * userRoleMapEntity.setAccountEntity(accountEntity);
		 * userRoleMapEntity.setRoleEntity(roleEntity);
		 * 
		 * userRoleMapEntity =
		 * daoFactory.getAccountDao().createUserRole(userRoleMapEntity);
		 */
	}

	@Transactional
	public boolean checkApiAuthorizationForUser(String accessToken, String apiMethodId) {

		ApiMethodEntity apiMethodEntity = daoFactory.getApiMethodDao().findByExternalId(apiMethodId);

		if (apiMethodEntity == null)
			throw new ApiMethodNotFoundException();

		if (!apiMethodEntity.getRequiresAccessToken())
			return true;

		SessionEntity sessionEntity = null;

		if (ValidationUtil.isEmpty(accessToken) == false) {
			sessionEntity = daoFactory.getSessionDao().findBySessionTokenForInterceptor(accessToken);
			if (sessionEntity == null) {
				sessionEntity = daoFactory.getSessionDao().findBySessionToken(accessToken);
			}
		}

		if (sessionEntity == null)
			throw new AccessDeniedException();

		ProfileEntity profileEntity = sessionEntity.getAccount().getProfileEntity();

		if (!daoFactory.getAccountDao().checkApiMethodAccess(profileEntity.getId(), apiMethodEntity.getId())) {

			List<PermissionSetEntity> permissionSets = daoFactory.getPermissionSetDao()
					.getAssignedPermissionSets(sessionEntity.getAccount().getId());
			if (permissionSets.size() == 0)
				throw new AccessDeniedException(
						"User doesn't have permission for the method " + apiMethodEntity.getFriendlyName());
			if (!daoFactory.getPermissionSetDao().checkAssignedPermissonSet(permissionSets, apiMethodEntity))
				throw new AccessDeniedException(
						"User doesn't have permission for the method " + apiMethodEntity.getFriendlyName());
		}

		logger.debug("user having permission to access API method {} ", apiMethodEntity.getFriendlyName());

		return true;
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