package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.ProfileEntity;

public class ProfileDaoImpl extends QueryExecutorImpl implements ProfileDao {

	@Override
	public ProfileEntity createProfile(ProfileEntity profileEntity) {
			insert(profileEntity);
		return profileEntity;
	}

	@Override
	public ProfileEntity updateProfile(ProfileEntity profileEntity) {
			update(profileEntity);
		return profileEntity;
	}

	@Override
	public void deleteProfile(ProfileEntity profileEntity) {
			delete(profileEntity);
	}

	@Override
	public ProfileEntity getProfileById(UUID profileId) {
		return (ProfileEntity) get(ProfileEntity.class, profileId);
	}

	@Override
	public List<ProfileEntity> getProfiles(Integer profileLevel, Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ProfileEntity.class);
		if(profileLevel != null)  {
			criteria.add(Restrictions.ge("profileLevel", profileLevel));
		}else {
			criteria.add(Restrictions.gt("profileLevel", 1));
		}
		return (List<ProfileEntity>) findByCriteria(criteria,startIndex,maxItems);
	}

	@Override
	public long getProfileCount() {
		DetachedCriteria criteria = DetachedCriteria.forClass(ProfileEntity.class);
		return countRows(criteria);
	}

}
