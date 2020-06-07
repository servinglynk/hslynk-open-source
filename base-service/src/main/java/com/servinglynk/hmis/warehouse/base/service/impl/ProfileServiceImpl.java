package com.servinglynk.hmis.warehouse.base.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.base.service.ProfileService;
import com.servinglynk.hmis.warehouse.base.service.converter.ApiMethodConverter;
import com.servinglynk.hmis.warehouse.base.service.converter.ProfileConverter;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.ApiMethod;
import com.servinglynk.hmis.warehouse.core.model.Profile;
import com.servinglynk.hmis.warehouse.core.model.Profiles;
import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.core.model.Roles;
import com.servinglynk.hmis.warehouse.model.base.ApiMethodEntity;
import com.servinglynk.hmis.warehouse.model.base.HmisUser;
import com.servinglynk.hmis.warehouse.model.base.ProfileACLEntity;
import com.servinglynk.hmis.warehouse.model.base.ProfileEntity;
import com.servinglynk.hmis.warehouse.model.base.RoleEntity;
import com.servinglynk.hmis.warehouse.service.exception.ApiMethodNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ProfileNotFoundException;

public class ProfileServiceImpl extends ServiceBase implements ProfileService {

	@Transactional
	public Profile createProfile(Profile profile,String caller) {
		if(profile.getApiMethods().size()==0){
			throw new ApiMethodNotFoundException("Every profile should contains atleast one Api method");
		}
				
		ProfileEntity profileEntity=new ProfileEntity();
		ProfileConverter.modelToEntity(profileEntity, profile);
		profileEntity.setCreatedAt(new Date());
		profileEntity.setCreatedBy(caller);
		daoFactory.getProfileDao().createProfile(profileEntity);
		
		for(ApiMethod apiMethod : profile.getApiMethods()){
			ApiMethodEntity apiMethodEntity = daoFactory.getApiMethodDao().findByExternalId(apiMethod.getExternalId());
			if(apiMethodEntity!=null){
				ProfileACLEntity profileACLEntity=new ProfileACLEntity();
				profileACLEntity.setApiMethodEntity(apiMethodEntity);
				profileACLEntity.setProfileEntity(profileEntity);
				profileACLEntity.setCreatedAt(new Date());
				profileACLEntity.setCreatedBy(caller);
				daoFactory.getProfileAclDao().createProfileAcl(profileACLEntity);
			}
		}
		profile.setId(profileEntity.getId());
		return profile;
	}

	@Transactional
	public Profile updateProfile(Profile profile,String caller) {
		
		if(profile.getApiMethods().size()==0){
			throw new ApiMethodNotFoundException("Every profile should contains atleast one Api method");
		}
		ProfileEntity profileEntity=daoFactory.getProfileDao().getProfileById(profile.getId());
		
		if(profileEntity==null){
			throw new ProfileNotFoundException();
		}
		
		List<ProfileACLEntity> profileACLEntities = daoFactory.getProfileAclDao().getProfileAclByProfiile(profileEntity.getId());
		
		daoFactory.getProfileAclDao().deleteProfileAcls(profileACLEntities);
		
		ProfileConverter.modelToEntity(profileEntity, profile);
		profileEntity.setModifiedAt(new Date());
		profileEntity.setModifiedBy(caller);
		daoFactory.getProfileDao().updateProfile(profileEntity);
		
		for(ApiMethod apiMethod : profile.getApiMethods()){
			ApiMethodEntity apiMethodEntity = daoFactory.getApiMethodDao().findByExternalId(apiMethod.getExternalId());
			if(apiMethodEntity!=null){
				ProfileACLEntity profileACLEntity=new ProfileACLEntity();
				profileACLEntity.setApiMethodEntity(apiMethodEntity);
				profileACLEntity.setProfileEntity(profileEntity);
				profileACLEntity.setCreatedAt(new Date());
				profileACLEntity.setCreatedBy(caller);
				daoFactory.getProfileAclDao().createProfileAcl(profileACLEntity);
			}
		}
		
		return profile;
	}

	@Transactional
	public Profile deleteProfile(UUID profileId,String caller) {
		ProfileEntity profileEntity=daoFactory.getProfileDao().getProfileById(profileId);
		if(profileEntity==null){
			throw new ProfileNotFoundException();
		}
		
		List<ProfileACLEntity> profileACLEntities = daoFactory.getProfileAclDao().getProfileAclByProfiile(profileEntity.getId());
		daoFactory.getProfileAclDao().deleteProfileAcls(profileACLEntities);
		daoFactory.getProfileDao().deleteProfile(profileEntity);
		return new Profile();
	}
	
	
	@Transactional
	public Profile getProfile(UUID profileId){
		ProfileEntity profileEntity= daoFactory.getProfileDao().getProfileById(profileId);
		Profile profile = ProfileConverter.entityToModel(profileEntity);
		for(ProfileACLEntity entity : profileEntity.getProfileACLEntities()){
			profile.addApiMethod(ApiMethodConverter.entityToModel(entity.getApiMethodEntity()));
		}
		return profile;
	}

	@Transactional
	public Profiles getAllProfiles(UUID userId,Integer startIndex, Integer maxItems) {
		
		Profiles profiles = new Profiles();
		HmisUser user = daoFactory.getAccountDao().findByUserId(userId);
		Integer profileLevel = null;
		ProfileEntity userProfile = user.getProfileEntity();
		if(userProfile !=null) {
			profileLevel = userProfile.getProfileLevel();
		}
		
		List<ProfileEntity> profileEntities = daoFactory.getProfileDao().getProfiles(profileLevel,startIndex,maxItems);
		for(ProfileEntity profileEntity : profileEntities){
			profiles.addProfile(ProfileConverter.entityToModel(profileEntity));
		}
		
		long count = daoFactory.getProfileDao().getProfileCount();
		

		SortedPagination pagination = new SortedPagination();

		pagination.setReturned(profiles.getProfiles().size());
		pagination.setFrom(startIndex);
		profiles.setPagination(pagination);
		pagination.setTotal((int)count);
		
		return profiles;
	}

}
