package com.servinglynk.hmis.warehouse.base.dao;

import com.servinglynk.hmis.warehouse.model.base.VerificationEntity;

public interface VerificationDao {

	VerificationEntity create(VerificationEntity verification);

	VerificationEntity findByToken(String token);

	VerificationEntity updateVerification(VerificationEntity pVerification);

}
