package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.live.ProfileACLEntity;

public interface ProfileAclDao {
	
	ProfileACLEntity createProfileAcl(ProfileACLEntity profileACLEntity);
	void deleteProfileAcl(ProfileACLEntity profileACLEntity);
	void deleteProfileAcls(List<ProfileACLEntity> profileACLEntities);
	List<ProfileACLEntity> getProfileAclByProfiile(UUID profileId);

}
