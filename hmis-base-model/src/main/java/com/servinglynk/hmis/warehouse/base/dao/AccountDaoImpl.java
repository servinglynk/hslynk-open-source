package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.model.base.HmisUser;
import com.servinglynk.hmis.warehouse.model.base.ProfileACLEntity;
import com.servinglynk.hmis.warehouse.model.base.SessionEntity;
import com.servinglynk.hmis.warehouse.model.base.UserRoleMapEntity;

public class AccountDaoImpl extends QueryExecutorImpl implements AccountDao {
	
	

	
	@SuppressWarnings("unchecked")
	public HmisUser findByUsername(String userName){
		DetachedCriteria criteria= DetachedCriteria.forClass(HmisUser.class);
		criteria.add(Restrictions.eq("username",userName.toLowerCase()));
		criteria.add(Restrictions.ne("status", Constants.ACCOUNT_STATUS_DELETED));
		List<HmisUser> accounts = (List<HmisUser>) findByCriteria(criteria);
		if(accounts.size()>0) return accounts.get(0);
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<HmisUser> findByExternalIds(List<String> externalIds, int startIndex, int maxItems) {
		DetachedCriteria criteria= DetachedCriteria.forClass(HmisUser.class);
		criteria.add(Restrictions.eq("externalIds",externalIds));
		
		return (List<HmisUser>)findByCriteria(criteria,startIndex,maxItems);
	}
	
	public HmisUser findByUserId(UUID userId){
		DetachedCriteria criteria = DetachedCriteria.forClass(HmisUser.class);
		criteria.add(Restrictions.eq("id", userId));
		List<HmisUser> hmisUsers = (List<HmisUser>) findByCriteria(criteria);
		if(!hmisUsers.isEmpty()) return hmisUsers.get(0);
		return null;

	}
	
	@SuppressWarnings("unchecked")
	public List<HmisUser> getCustomerAdmins(String projectGroup) {
		DetachedCriteria criteria = DetachedCriteria.forClass(HmisUser.class);
		criteria.add(Restrictions.eq("profileEntity.profileName", "Customer Admin Profile"));
		criteria.add(Restrictions.eq("projectGroupEntity.projectGroupCode",projectGroup));
		return (List<HmisUser>) findByCriteria(criteria); 
	}
	
	public HmisUser createAccount(HmisUser account){
		String hiveUserName = account.getUsername().replaceAll("[^a-zA-Z0-9]+","3");
		account.setHiveUsername(hiveUserName);
		account.setHivePassword("Passw0rd!");
		insert(account);
		return account;
	}
	
	
	public HmisUser updateAccount(HmisUser account){
		update(account);
		return account;
	}


	public void deleteAccount(HmisUser account){
		delete(account);
	}


	@SuppressWarnings("unchecked")
	public HmisUser findByVerificationId(UUID id) {
	DetachedCriteria criteria = DetachedCriteria.forClass(HmisUser.class);
	criteria.createAlias("verification", "verification");
	criteria.add(Restrictions.eq("verification.id",id));
	List<HmisUser> accounts = (List<HmisUser>) findByCriteria(criteria);
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
	
	@SuppressWarnings("unchecked")
	public UserRoleMapEntity getUserRoleByUserIdAndRoleId(UUID userid,UUID roleid) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UserRoleMapEntity.class);
		criteria.createAlias("roleEntity", "roleEntity");
		criteria.createAlias("accountEntity", "accountEntity");
		criteria.add(Restrictions.eq("roleEntity.id",roleid));
		criteria.add(Restrictions.eq("accountEntity.id", userid));
		
		List<UserRoleMapEntity> entities = (List<UserRoleMapEntity>) findByCriteria(criteria);
		if(!entities.isEmpty()) return entities.get(0);
		return null;
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
	public List<HmisUser> getAllUsersByOranization(UUID organizationId){
		DetachedCriteria criteria = DetachedCriteria.forClass(HmisUser.class);
		criteria.createAlias("organization","organization");
		
		criteria.add(Restrictions.eq("organization.id", organizationId));
		
		return (List<HmisUser>) findByCriteria(criteria);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<HmisUser> findUsersByProjectGroup(String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(HmisUser.class);
		criteria.createAlias("projectGroupEntity","projectGroupEntity");
		
		criteria.add(Restrictions.eq("projectGroupEntity.projectGroupCode", projectGroupCode));
		
		return (List<HmisUser>) findByCriteria(criteria);

		
	}

}
