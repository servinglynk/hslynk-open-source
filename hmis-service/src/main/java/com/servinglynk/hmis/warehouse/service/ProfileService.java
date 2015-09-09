package com.servinglynk.hmis.warehouse.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Profile;
import com.servinglynk.hmis.warehouse.core.model.Profiles;

public interface ProfileService {

	Profile createProfile(Profile profile,String caller);
	Profile updateProfile(Profile profile,String caller);
	Profile deleteProfile(UUID profileId,String caller);
	Profile getProfile(UUID profileId);
	Profiles getAllProfiles(Integer startIndex, Integer maxItems);
}
