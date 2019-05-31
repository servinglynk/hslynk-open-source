package com.servinglynk.hmis.warehouse.base.service;

import com.servinglynk.hmis.warehouse.core.model.UsernameChange;

public interface UsernameChangeService {

	void createUsernameChange(String username, UsernameChange usernameChange,
			String userService);

}
