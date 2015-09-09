package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.entity.AccountEntity;
import com.servinglynk.hmis.warehouse.entity.ProfileACLEntity;
import com.servinglynk.hmis.warehouse.entity.UserRoleMapEntity;

public class AccountDaoImpl extends QueryExecutorImpl implements AccountDao {
	
	

	
	@SuppressWarnings("unchecked")
	public AccountEntity findByUsername(String userName){
		DetachedCriteria criteria= DetachedCriteria.forClass(AccountEntity.class);
		criteria.add(Restrictions.eq("username",userName));
		List<AccountEntity> accounts = (List<AccountEntity>) findByCriteria(criteria);
		if(accounts.size()>0) return accounts.get(0);
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<AccountEntity> findByExternalIds(List<String> externalIds, int startIndex, int maxItems) {
		DetachedCriteria criteria= DetachedCriteria.forClass(AccountEntity.class);
		criteria.add(Restrictions.eq("externalIds",externalIds));
		
		return (List<AccountEntity>)findByCriteria(criteria,startIndex,maxItems);
	}
	
	public AccountEntity findByUserId(UUID userId){
		return (AccountEntity) get(AccountEntity.class,userId);
	}
	
	
	
	public AccountEntity createAccount(AccountEntity account){
		insert(account);
		return account;
	}
	
	
	public AccountEntity updateAccount(AccountEntity account){
		update(account);
		return account;
	}


	public void deleteAccount(AccountEntity account){
		delete(account);
	}


	@SuppressWarnings("unchecked")
	public AccountEntity findByVerificationId(UUID id) {
	DetachedCriteria criteria = DetachedCriteria.forClass(AccountEntity.class);
	criteria.createAlias("verification", "verification");
	criteria.add(Restrictions.eq("verification.id",id));
	List<AccountEntity> accounts = (List<AccountEntity>) findByCriteria(criteria);
	if(accounts.size()>0) return accounts.get(0);
	return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public boolean checkApiMethodAccess(UUID profileId,UUID methodId){
		
		DetachedCriteria criteria = DetachedCriteria.forClass(ProfileACLEntity.class);
		criteria.createAlias("profileEntity", "profileEntity");
		criteria.createAlias("apiMethodEntity", "apiMethodEntity");
		
		criteria.add(Restrictions.eq("profileEntity.id", profileId));
		criteria.add(Restrictions.eq("apiMethodEntity.id", methodId));
		
		List<ProfileACLEntity> profileACLEntities = (List<ProfileACLEntity>) findByCriteria(criteria);
		
		if(profileACLEntities.size()>0) return true;
		
		return false;
	}


	@Override
	public UserRoleMapEntity createUserRole(UserRoleMapEntity userRoleMapEntity) {
		insert(userRoleMapEntity);
		return userRoleMapEntity;
	}


	@Override
	public void daeleteUserRole(UserRoleMapEntity userRoleMapEntity) {
		delete(userRoleMapEntity);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<UserRoleMapEntity> getUserMapByUserId(UUID userId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UserRoleMapEntity.class);
		criteria.createAlias("accountEntity", "accountEntity");
		criteria.add(Restrictions.eq("accountEntity.id", userId));
		return (List<UserRoleMapEntity>) findByCriteria(criteria);
	}
	
	@SuppressWarnings("unchecked")
	public List<AccountEntity> getAllUsersByOranization(UUID organizationId){
		DetachedCriteria criteria = DetachedCriteria.forClass(AccountEntity.class);
		criteria.createAlias("organization","organization");
		
		criteria.add(Restrictions.eq("organization.id", organizationId));
		
		return (List<AccountEntity>) findByCriteria(criteria);
	}

}
