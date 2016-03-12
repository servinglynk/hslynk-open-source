package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.v2014.ProfileACLEntity;

public class ProfileAclDaoImpl extends QueryExecutorImpl implements ProfileAclDao {

	@Override
	public ProfileACLEntity createProfileAcl(ProfileACLEntity profileACLEntity) {
			insert(profileACLEntity);
		return profileACLEntity;
	}

	@Override
	public void deleteProfileAcl(ProfileACLEntity profileACLEntity) {
		delete(profileACLEntity);
	}

	@Override
	public void deleteProfileAcls(List<ProfileACLEntity> profileACLEntities) {
		for(ProfileACLEntity profileACLEntity : profileACLEntities){
			delete(profileACLEntity);
		}

	}


	@SuppressWarnings("unchecked")
	public List<ProfileACLEntity> getProfileAclByProfiile(UUID profileId) {
		DetachedCriteria criteria= DetachedCriteria.forClass(ProfileACLEntity.class);
		criteria.createAlias("profileEntity", "profileEntity");
		criteria.add(Restrictions.eq("profileEntity.id", profileId));
		
		return  (List<ProfileACLEntity>) findByCriteria(criteria);
	}

}
