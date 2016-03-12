package com.servinglynk.hmis.warehouse.service.converter;


import com.servinglynk.hmis.warehouse.core.model.Verification;
import com.servinglynk.hmis.warehouse.model.v2014.VerificationEntity;

public class VerificationConverter {
	
	public static Verification convertToVerification(VerificationEntity pVerification) {
		Verification verification = new Verification();
		verification.setStatus(pVerification.getStatus());
		verification.setToken(pVerification.getToken());
		verification.setType(pVerification.getType());
		return verification;
	}

}
