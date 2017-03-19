package com.servinglynk.hmis.warehouse.base.dao;


import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.PasswordResetEntity;

public interface PasswordResetDao {

	PasswordResetEntity create(PasswordResetEntity pPasswordReset);

	PasswordResetEntity findByVerificationId(UUID id);

	List<PasswordResetEntity> findByAccountIdAndStatus(UUID id,
			String passwordResetStatusCreated);

	PasswordResetEntity updatePasswordReset(PasswordResetEntity pPasswordReset);

}
