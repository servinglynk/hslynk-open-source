package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.DeveloperCompanyAccountEntity;
public class DeveloperCompanyAccountDaoImpl extends QueryExecutorImpl
		implements DeveloperCompanyAccountDao {

	

	
	@SuppressWarnings("unchecked")
	public List<DeveloperCompanyAccountEntity> findByDeveloperCompanyId(UUID developerCompanyId)	{
		
		DetachedCriteria criteria = DetachedCriteria.forClass(DeveloperCompanyAccountEntity.class);
		criteria.createAlias("developerCompany","developerCompany");
		criteria.add(Restrictions.eq("developerCompany.id",developerCompanyId));
		return (List<DeveloperCompanyAccountEntity>) findByCriteria(criteria);
	}
	
	
	
	public DeveloperCompanyAccountEntity create(DeveloperCompanyAccountEntity developerCompanyAccount){
		insert(developerCompanyAccount);
		return developerCompanyAccount;
	}
	
	
	
	public DeveloperCompanyAccountEntity update(
			DeveloperCompanyAccountEntity developerCompanyAccount) {
		update(developerCompanyAccount);
		return developerCompanyAccount;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public DeveloperCompanyAccountEntity findByDeveloperCompanyIdAndAccountUsername(UUID companyId,String userName){
		DetachedCriteria criteria=DetachedCriteria.forClass(DeveloperCompanyAccountEntity.class);
		criteria.createAlias("developerCompany","developerCompany");
		criteria.createAlias("account","account");
		criteria.add(Restrictions.eq("developerCompany.id",companyId));
		criteria.add(Restrictions.eq("account.username",userName));
	
		List<DeveloperCompanyAccountEntity> developerCompanyAccounts= (List<DeveloperCompanyAccountEntity>) findByCriteria(criteria);
		if(developerCompanyAccounts.size()>0) return  developerCompanyAccounts.get(0);
		return null;
	}



	@Override
	public void deleteCompanyAccount(
			DeveloperCompanyAccountEntity developerCompanyAccount) {
				delete(developerCompanyAccount);
		
	}



	@Override
	@SuppressWarnings("unchecked")
	public DeveloperCompanyAccountEntity findByDeveloperCompanyIdAndAccountId(
			UUID developerCompanyId, UUID accountId) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(DeveloperCompanyAccountEntity.class);
		criteria.createAlias("account","account");
		criteria.createAlias("developerCompany","developerCompany");
		
		criteria.add(Restrictions.eq("developerCompany.id",developerCompanyId));
		criteria.add(Restrictions.eq("account.id",accountId));
		List<DeveloperCompanyAccountEntity> accountEntities = (List<DeveloperCompanyAccountEntity>) findByCriteria(criteria);
		
		if(accountEntities.size() >0 ) return accountEntities.get(0);
		return null;
	}
	
	
	
	
	
}
