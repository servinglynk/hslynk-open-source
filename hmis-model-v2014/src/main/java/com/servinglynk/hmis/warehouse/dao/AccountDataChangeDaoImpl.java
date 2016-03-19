package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.v2014.AccountDataChangeEntity;

public class AccountDataChangeDaoImpl extends QueryExecutorImpl
		implements AccountDataChangeDao {

	public AccountDataChangeEntity create(AccountDataChangeEntity accountDataChange) {
			insert(accountDataChange);
		return accountDataChange;
	}

	@SuppressWarnings("unchecked")
	public AccountDataChangeEntity getAccountDataChangeByVerificationId(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(AccountDataChangeEntity.class);
		criteria.createAlias("verification", "verification");
		criteria.add(Restrictions.eq("verification.id",id));
		List<AccountDataChangeEntity> accounts = (List<AccountDataChangeEntity>) findByCriteria(criteria);
	if(accounts.size()>0) return accounts.get(0);
		return null;
	}



}
