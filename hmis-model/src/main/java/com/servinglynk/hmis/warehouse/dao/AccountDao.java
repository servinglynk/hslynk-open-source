package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.live.HmisUser;
import com.servinglynk.hmis.warehouse.model.live.UserRoleMapEntity;

public interface AccountDao {

	public HmisUser findByUsername(String userName);
	public List<HmisUser> findByExternalIds(List<String> externalIds, int startIndex, int maxItems);
	public HmisUser createAccount(HmisUser account);
	public HmisUser updateAccount(HmisUser account);
	public void deleteAccount(HmisUser account);
	public HmisUser findByVerificationId(UUID id);
	HmisUser findByUserId(UUID userId);
	
	public boolean checkApiMethodAccess(UUID profileId,UUID methodId);
	public UserRoleMapEntity createUserRole(UserRoleMapEntity userRoleMapEntity);
	public void daeleteUserRole(UserRoleMapEntity userRoleMapEntity);
	public List<UserRoleMapEntity> getUserMapByUserId(UUID userId);
	List<HmisUser> getAllUsersByOranization(UUID organizationId);
}
