package com.servinglynk.hmis.warehouse.base.service;

import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.Verification;

public interface VerificationService {

	Account getAccountByVerfication(Verification verification);

	Verification updateVerificationStatus(Verification verification,
			String userService);

	void createVerification(Verification verification);

}
