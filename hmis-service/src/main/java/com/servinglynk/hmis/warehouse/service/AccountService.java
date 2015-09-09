package com.servinglynk.hmis.warehouse.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.Accounts;
import com.servinglynk.hmis.warehouse.core.model.PasswordChange;
import com.servinglynk.hmis.warehouse.core.model.Preferences;
import com.servinglynk.hmis.warehouse.core.model.Role;

public interface AccountService {
	
	Account createAccount(Account account) throws Exception;

	Account findAccountByUsername(String username);

	public Account loadAccountBasicInfoByUsername(String username);

	public String getAccountStatus(String username);

	public Account createAccount(Account account, String userService,
			String purpose);

	public Account updateAccount(Account account, String userService);

	public Preferences updatePreferences(Account account, String userService);

	public Account updatePassword(String username, PasswordChange passwordChange,
			String userService);

	public void createUserRole(String username, Role role);

	public void updateUserRole(String username, Role role);
	
	Accounts getUsersByOrganization(UUID organizationId);
	
	boolean checkApiAuthorizationForUser(String accessToken,String apiMethodId);

}
