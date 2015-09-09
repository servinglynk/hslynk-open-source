package com.servinglynk.hmis.warehouse.service.impl;

import static com.servinglynk.hmis.warehouse.common.Constants.ACCOUNT_STATUS_DISABLED;
import static com.servinglynk.hmis.warehouse.common.Constants.ACCOUNT_STATUS_PENDING;
import static com.servinglynk.hmis.warehouse.common.Constants.VERIFICATION_TYPE_USERNAME_CHANGE;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.common.GeneralUtil;
import com.servinglynk.hmis.warehouse.common.ValidationUtil;
import com.servinglynk.hmis.warehouse.common.security.HMISCryptographer;
import com.servinglynk.hmis.warehouse.core.model.UsernameChange;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidParameterException;
import com.servinglynk.hmis.warehouse.entity.AccountDataChangeEntity;
import com.servinglynk.hmis.warehouse.entity.AccountEntity;
import com.servinglynk.hmis.warehouse.entity.VerificationEntity;
import com.servinglynk.hmis.warehouse.service.UsernameChangeService;
import com.servinglynk.hmis.warehouse.service.exception.AccountAlreadyExistsException;
import com.servinglynk.hmis.warehouse.service.exception.AccountDisabledException;
import com.servinglynk.hmis.warehouse.service.exception.AccountPendingException;
import com.servinglynk.hmis.warehouse.service.exception.InvalidCurrentPasswordException;

public class UsernameChangeServiceImpl extends ServiceBase implements UsernameChangeService {

	
	@Transactional
	public void createUsernameChange(String username,
			UsernameChange usernameChange, String userService) {
		createUsernameChange(null, username, usernameChange, userService);
		
	}
	
	
	@Transactional
	public void createUsernameChange(final String loggedInUserName, final String accountUserName,
			final UsernameChange usernameChange, final String auditUser) {
		
		
		// check validity of current username
		if (!ValidationUtil.isValidEmail(accountUserName)) {
			throw new InvalidParameterException("Invalid accountUserName: " + accountUserName);
		}

		// check validity of new username
		if (!ValidationUtil.isValidEmail(usernameChange.getNewUsername())) {
			throw new InvalidParameterException("Invalid new username: " + usernameChange.getNewUsername());
		}

		AccountEntity pAccount = daoFactory.getAccountDao().findByUsername(accountUserName);
		if (pAccount == null) {
			throw new InvalidParameterException("There is no account for the username you want to change: " + accountUserName);
		}

		// validate current password - not if modified from admin console
		if (loggedInUserName == null
				&& !pAccount.getPassword().equalsIgnoreCase(
						HMISCryptographer.Encrypt(usernameChange.getCurrentPassword()))) {
			throw new InvalidCurrentPasswordException();
		}

		// is the future username already in use?
		AccountEntity existingAccount = daoFactory.getAccountDao().findByUsername(usernameChange.getNewUsername());
		if (existingAccount != null) {
			throw new AccountAlreadyExistsException("Username already in use: " + usernameChange.getNewUsername());
		}

		// validate account status
		if (pAccount.getStatus().equalsIgnoreCase(ACCOUNT_STATUS_PENDING)) {
			throw new AccountPendingException();
		}

		if (pAccount.getStatus().equalsIgnoreCase(ACCOUNT_STATUS_DISABLED)) {
			throw new AccountDisabledException();
		}

		// make new verification object
		VerificationEntity verification = new VerificationEntity();
		verification.setToken(GeneralUtil.getUniqueToken(64));
		verification.setType(VERIFICATION_TYPE_USERNAME_CHANGE);
		verification.setCreatedBy(auditUser);
		verification.setCreatedAt(new Date());

		daoFactory.getVerificationDao().create(verification);

		// make back-up of old and new username
		AccountDataChangeEntity accountDataChange = new AccountDataChangeEntity();
		accountDataChange.setAccount(pAccount);
		accountDataChange.setOldUsername(accountUserName);
		accountDataChange.setNewUsername(usernameChange.getNewUsername());
		accountDataChange.setVerification(verification);
		accountDataChange.setCreatedBy(auditUser);
		accountDataChange.setCreatedAt(new Date());

		daoFactory.getAccountDataChangeDao().create(accountDataChange);

		// change account status
		pAccount.setUsername(usernameChange.getNewUsername());
		pAccount.setStatus(ACCOUNT_STATUS_PENDING);
		pAccount.setModifiedAt(new Date());
		pAccount.setModifiedBy(auditUser);

		daoFactory.getAccountDao().updateAccount(pAccount);

	
		// send validation email
	//	sendUsernameChangeVerificationEmail(pAccount, verification, usernameChange.getNewUsername());
	}

}
