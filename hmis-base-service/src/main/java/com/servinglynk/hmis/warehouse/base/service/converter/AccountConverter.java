package com.servinglynk.hmis.warehouse.base.service.converter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.Profile;
import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.model.base.HmisUser;


public class AccountConverter {

	
	public static com.servinglynk.hmis.warehouse.core.model.Account convertToAccount(com.servinglynk.hmis.warehouse.model.base.HmisUser pAccount) {
		
		Account account = new Account();
		account.setAccountId(pAccount.getId());
		account.setFirstName(pAccount.getFirstName());
		account.setMiddleName(pAccount.getMiddleName());
		account.setLastName(pAccount.getLastName());
		account.setUsername(pAccount.getUsername());
		account.setEmailAddress(pAccount.getUsername());
		account.setStatus(pAccount.getStatus());
		account.setProjectGroup(ProjectGroupConverter.entityToModel(pAccount.getProjectGroupEntity()));
		account.setProfile(ProfileConverter.entityToModel(pAccount.getProfileEntity()));		return account;
	}
	

	public static com.servinglynk.hmis.warehouse.core.model.Account convertToBasicAccount(com.servinglynk.hmis.warehouse.model.base.HmisUser pAccount) {
		com.servinglynk.hmis.warehouse.core.model.Account account = new com.servinglynk.hmis.warehouse.core.model.Account();
		account.setAccountId(pAccount.getId());
		account.setFirstName(pAccount.getFirstName());
		account.setMiddleName(pAccount.getMiddleName());
		account.setLastName(pAccount.getLastName());
		account.setEmailAddress(pAccount.getUsername());
		account.setStatus(pAccount.getStatus());
		return account;
	}
	

	public static HmisUser convertToPersistentAccount(Account account, HmisUser pAccount) {		
		if (pAccount == null) {
			pAccount = new HmisUser();
		}
		
		pAccount.setFirstName(account.getFirstName());
		pAccount.setLastName(account.getLastName());
		pAccount.setMiddleName(account.getMiddleName());
		pAccount.setUsername(account.getUsername());
		pAccount.setEmailAddress(account.getEmailAddress());
		pAccount.setPassword(account.getPassword());
		
		// If profile not avilable in request assigning standard profile
		if(account.getProfile()==null || account.getProfile().getId()==null){
			Profile profile = new Profile();
			profile.setId(UUID.fromString("004aed07-b4d4-4696-b8f6-1607f6f49bac"));
			account.setProfile(profile);
		}
		
		// If profile not avilable in request assigning default role based profile
		
		Map<UUID,UUID> defaultRoles = new HashMap<UUID,UUID>();
		defaultRoles.put(UUID.fromString("d78c38a1-2762-4393-b69b-41a0a11e6efc"), UUID.fromString("b67c38a1-2762-4393-b69b-41a0a11e6efd"));  // Customer ADMIN Profile Customer ADMIN role
		defaultRoles.put(UUID.fromString("b67c38a1-2762-4393-b69b-41a0a11e6efc"), UUID.fromString("6b5857d9-bc16-4706-acde-17be5d530631"));  // Super ADMIN Profile Super ADMIN role
		defaultRoles.put(UUID.fromString("004aed07-b4d4-4696-b8f6-1607f6f49bac"), UUID.fromString("6b5857d9-bc16-4706-acde-17be5d530631"));  // Standard Profile Standard role
		if(account.getRole()==null || account.getRole().getId()==null){
			Role role = new Role();
			if(defaultRoles.containsKey(account.getProfile().getId())){
				role.setId(defaultRoles.get(account.getProfile().getId()));
			}else{
				role.setId(UUID.fromString("6b5857d9-bc16-4706-acde-17be5d530631"));
			}
			account.setRole(role);
		}
		return pAccount;
	}
}