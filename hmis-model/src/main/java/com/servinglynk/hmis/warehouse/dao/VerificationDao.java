package com.servinglynk.hmis.warehouse.dao;

import com.servinglynk.hmis.warehouse.model.v2014.VerificationEntity;

public interface VerificationDao {

	VerificationEntity create(VerificationEntity verification);

	VerificationEntity findByToken(String token);

	VerificationEntity updateVerification(VerificationEntity pVerification);

}
