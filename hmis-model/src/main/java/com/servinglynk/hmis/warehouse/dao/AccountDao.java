package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.entity.AccountEntity;
import com.servinglynk.hmis.warehouse.entity.UserRoleMapEntity;

public interface AccountDao {

	public AccountEntity findByUsername(String userName);
	public List<AccountEntity> findByExternalIds(List<String> externalIds, int startIndex, int maxItems);
	public AccountEntity createAccount(AccountEntity account);
	public AccountEntity updateAccount(AccountEntity account);
	public void deleteAccount(AccountEntity account);
	public AccountEntity findByVerificationId(UUID id);
	AccountEntity findByUserId(UUID userId);
	
	public boolean checkApiMethodAccess(UUID profileId,UUID methodId);
	public UserRoleMapEntity createUserRole(UserRoleMapEntity userRoleMapEntity);
	public void daeleteUserRole(UserRoleMapEntity userRoleMapEntity);
	public List<UserRoleMapEntity> getUserMapByUserId(UUID userId);
	List<AccountEntity> getAllUsersByOranization(UUID organizationId);
}
