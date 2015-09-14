package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.Profile;
import com.servinglynk.hmis.warehouse.model.live.ProfileEntity;

public class ProfileConverter {
	
	
	public static Profile entityToModel(ProfileEntity profileEntity){
		Profile profile = new Profile();
		profile.setId(profileEntity.getId());
		profile.setProfileDescription(profileEntity.getProfileDescription());
		profile.setProfileName(profileEntity.getProfileName());		
		return profile;
	}

	
	public static ProfileEntity modelToEntity(ProfileEntity profileEntity,Profile profile){
		if(profileEntity==null){
			profileEntity = new ProfileEntity();
		}
		profileEntity.setProfileDescription(profile.getProfileDescription());
		profileEntity.setProfileName(profile.getProfileName());		
		return profileEntity;
	}
}
