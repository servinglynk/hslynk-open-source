package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.ProfileEntity;

public interface ProfileDao {
	
	ProfileEntity createProfile(ProfileEntity profileEntity);
	ProfileEntity updateProfile(ProfileEntity profileEntity);
	void deleteProfile(ProfileEntity profileEntity);
	ProfileEntity getProfileById(UUID profileId);
	List<ProfileEntity> getProfiles(ProfileEntity profile,Integer startIndex, Integer maxItems);
	long getProfileCount();
}
