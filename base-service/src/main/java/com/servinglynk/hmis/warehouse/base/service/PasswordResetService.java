package com.servinglynk.hmis.warehouse.base.service;

public interface PasswordResetService {

	void createPasswordReset(String username, String userService,
			String redirectURL);

}
