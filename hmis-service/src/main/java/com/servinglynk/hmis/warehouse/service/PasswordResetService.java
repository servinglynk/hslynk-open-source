package com.servinglynk.hmis.warehouse.service;

public interface PasswordResetService {

	void createPasswordReset(String username, String userService,
			String redirectURL);

}
