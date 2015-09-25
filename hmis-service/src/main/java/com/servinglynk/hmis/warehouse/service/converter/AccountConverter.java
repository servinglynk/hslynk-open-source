package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.common.ValidationUtil;
import com.servinglynk.hmis.warehouse.core.model.Account;


public class AccountConverter {

	
	public static com.servinglynk.hmis.warehouse.core.model.Account convertToAccount(com.servinglynk.hmis.warehouse.model.live.AccountEntity pAccount) {
		com.servinglynk.hmis.warehouse.core.model.Account account = convertToBasicAccount(pAccount);
		
		account.setUsername(pAccount.getUsername());
		account.setStatus(pAccount.getStatus());
//		account.setGender(pAccount.getGender());
		account.setPassword(pAccount.getPassword());
		account.setOrganizationId(pAccount.getOrganization().getId());				return account;
	}
	

	public static com.servinglynk.hmis.warehouse.core.model.Account convertToBasicAccount(com.servinglynk.hmis.warehouse.model.live.AccountEntity pAccount) {
		com.servinglynk.hmis.warehouse.core.model.Account account = new com.servinglynk.hmis.warehouse.core.model.Account();
		account.setAccountId(pAccount.getId());
		account.setFirstName(pAccount.getFirstName());
		account.setMiddleName(pAccount.getMiddleName());
		account.setLastName(pAccount.getLastName());
		account.setEmailAddress(pAccount.getUsername());
		
		return account;
	}
	

	public static com.servinglynk.hmis.warehouse.model.live.AccountEntity convertToPersistentAccount(Account account, com.servinglynk.hmis.warehouse.model.live.AccountEntity pAccount) {		
		if (pAccount == null) {
			pAccount = new com.servinglynk.hmis.warehouse.model.live.AccountEntity();
		}
		if (ValidationUtil.isNotNull(account.getUsername())) {
			pAccount.setUsername(account.getUsername());
		}
		if (ValidationUtil.isNotNull(account.getPassword())) {
			pAccount.setPassword(account.getPassword());
		}
		if (ValidationUtil.isNotNull(account.getFirstName())) {
			pAccount.setFirstName(account.getFirstName());
		}
		if (ValidationUtil.isNotNull(account.getMiddleName())) {
			pAccount.setMiddleName(account.getMiddleName());
		}		
		if (ValidationUtil.isNotNull(account.getLastName())) {
			pAccount.setLastName(account.getLastName());
		}
		if(ValidationUtil.isNotNull(account.getGender())){
//			pAccount.setGender(account.getGender());
		}				return pAccount;
	}
}