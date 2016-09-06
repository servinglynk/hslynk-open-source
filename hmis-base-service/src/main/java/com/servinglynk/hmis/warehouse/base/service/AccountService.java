package com.servinglynk.hmis.warehouse.base.service;

import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.Accounts;
import com.servinglynk.hmis.warehouse.core.model.PasswordChange;
import com.servinglynk.hmis.warehouse.core.model.Role;

public interface AccountService {
	
	Account findAccountByUsername(String username);

	Account createAccount(Account account, String userService,
			String purpose);

	Account updateAccount(Account account, String userService);

	Account updatePassword(Account account, PasswordChange passwordChange,
			String userService);
	
	void deleteAccount(Account account,Account auditAccount);
	Account activateAccount(Account account,String auditUser);
	
	void addUserRole(Account account, Role role);
	void removeUserRole(Account account, Role role);
	
	boolean checkApiAuthorizationForUser(String accessToken,String apiMethodId);

	void extendUserSession(String accessToken);

	Accounts getUsersByProjectGroup(String projectGroupCode);

	Account getAccount(Account account,boolean onlyBasicInfo);

}
