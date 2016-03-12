package com.servinglynk.hmis.warehouse.service.impl;

import static com.servinglynk.hmis.warehouse.common.Constants.ACCOUNT_STATUS_DISABLED;
import static com.servinglynk.hmis.warehouse.common.Constants.ACCOUNT_STATUS_PENDING;
import static com.servinglynk.hmis.warehouse.common.Constants.PASSWORD_RESET_STATUS_CREATED;
import static com.servinglynk.hmis.warehouse.common.Constants.VERIFICATION_TYPE_PASSWORD_RESET;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.common.GeneralUtil;
import com.servinglynk.hmis.warehouse.common.ValidationUtil;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidParameterException;
import com.servinglynk.hmis.warehouse.model.v2014.HmisUser;
import com.servinglynk.hmis.warehouse.model.v2014.PasswordResetEntity;
import com.servinglynk.hmis.warehouse.model.v2014.VerificationEntity;
import com.servinglynk.hmis.warehouse.service.PasswordResetService;
import com.servinglynk.hmis.warehouse.service.exception.AccountDisabledException;
import com.servinglynk.hmis.warehouse.service.exception.AccountPendingException;

public class PasswordResetServiceImpl extends ServiceBase implements PasswordResetService {

	
	@Transactional
	public void createPasswordReset(String username, String auditUser,
			String redirectURL) {
		if (!ValidationUtil.isValidEmail(username)) {
			throw new InvalidParameterException("invalid username: " + username);
		}
		
		// get user account
		HmisUser pAccount = daoFactory.getAccountDao().findByUsername(username);

		if (pAccount.getStatus().equalsIgnoreCase(ACCOUNT_STATUS_PENDING)) {
			throw new AccountPendingException();
		}

		if (pAccount.getStatus().equalsIgnoreCase(ACCOUNT_STATUS_DISABLED)) {
			throw new AccountDisabledException();
		}

		// Make new verification object
		VerificationEntity pVerification = new VerificationEntity();
		pVerification.setToken(GeneralUtil.getUniqueToken(64));
		pVerification.setType(VERIFICATION_TYPE_PASSWORD_RESET);
        pVerification.setCreatedBy(auditUser);
        pVerification.setCreatedAt(new Date());

        pVerification = daoFactory.getVerificationDao().create(pVerification);


		// create password-reset object
		PasswordResetEntity pPasswordReset = new PasswordResetEntity();
		pPasswordReset.setAccount(pAccount);
		pPasswordReset.setVerification(pVerification);
		pPasswordReset.setStatus(PASSWORD_RESET_STATUS_CREATED);
		pPasswordReset.setCreatedBy(auditUser);
		pPasswordReset.setCreatedAt(new Date());

		// persist the password-reset object....
		daoFactory.getPasswordResetDao().create(pPasswordReset);
		
	}


}
