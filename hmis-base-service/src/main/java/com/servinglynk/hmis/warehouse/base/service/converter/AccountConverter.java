package com.servinglynk.hmis.warehouse.base.service.converter;

import com.servinglynk.hmis.warehouse.common.ValidationUtil;
import com.servinglynk.hmis.warehouse.core.model.Account;


public class AccountConverter {

	
	public static com.servinglynk.hmis.warehouse.core.model.Account convertToAccount(com.servinglynk.hmis.warehouse.model.base.HmisUser pAccount) {
		com.servinglynk.hmis.warehouse.core.model.Account account = convertToBasicAccount(pAccount);
		
		account.setAccountId(pAccount.getId());
		account.setFirstName(pAccount.getFirstName());
		account.setMiddleName(pAccount.getMiddleName());
		account.setLastName(pAccount.getLastName());
		account.setUsername(pAccount.getUsername());
		account.setEmailAddress(pAccount.getUsername());
		account.setStatus(pAccount.getStatus());
		account.setOrganizationId(pAccount.getOrganization().getId());
		account.setProjectGroup(ProjectGroupConverter.entityToModel(pAccount.getProjectGroupEntity()));				return account;
	}
	

	public static com.servinglynk.hmis.warehouse.core.model.Account convertToBasicAccount(com.servinglynk.hmis.warehouse.model.base.HmisUser pAccount) {
		com.servinglynk.hmis.warehouse.core.model.Account account = new com.servinglynk.hmis.warehouse.core.model.Account();
		account.setAccountId(pAccount.getId());
		account.setFirstName(pAccount.getFirstName());
		account.setMiddleName(pAccount.getMiddleName());
		account.setLastName(pAccount.getLastName());
		account.setEmailAddress(pAccount.getUsername());
		account.setStatus(pAccount.getStatus());
		account.setOrganizationId(pAccount.getOrganization().getId());
		return account;
	}
	

	public static com.servinglynk.hmis.warehouse.model.base.HmisUser convertToPersistentAccount(Account account, com.servinglynk.hmis.warehouse.model.base.HmisUser pAccount) {		
		if (pAccount == null) {
			pAccount = new com.servinglynk.hmis.warehouse.model.base.HmisUser();
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
		}				if(ValidationUtil.isNotNull(account.getEmailAddress())){
			pAccount.setEmailAddress(account.getEmailAddress());
		}
		
		return pAccount;
	}
}