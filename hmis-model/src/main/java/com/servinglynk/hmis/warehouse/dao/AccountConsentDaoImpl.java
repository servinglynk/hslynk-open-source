package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.entity.AccountConsentEntity;

public class AccountConsentDaoImpl extends QueryExecutorImpl implements AccountConsentDao {


	public AccountConsentEntity create(AccountConsentEntity consent) {
			insert(consent);
		return consent;
	}

	@SuppressWarnings("unchecked")
	public AccountConsentEntity findByAccountIdAndTrustedAppId(UUID accountId, UUID trustedAppId) {
		DetachedCriteria criteria= DetachedCriteria.forClass(AccountConsentEntity.class);
		criteria.createAlias("trustedApp","trustedApp");
		criteria.createAlias("account", "account");
		
		criteria.add(Restrictions.eq("trustedApp.id", trustedAppId));
		criteria.add(Restrictions.eq("account.id", accountId));
		
		List<AccountConsentEntity> accountConsents = (List<AccountConsentEntity>) findByCriteria(criteria);
		if(accountConsents.size()>0) return accountConsents.get(0);

		return null;
	}


	public AccountConsentEntity updateAccountConsent(AccountConsentEntity consent) {
			update(consent);
	 	return consent;
	}

	
	public void deleteAccountConsent(AccountConsentEntity consent) {
		delete(consent);

	}

	@SuppressWarnings("unchecked")
	public AccountConsentEntity findByToken(String consentToken) {
		DetachedCriteria criteria= DetachedCriteria.forClass(AccountConsentEntity.class);
		criteria.add(Restrictions.eq("consentToken", consentToken));
		
		List<AccountConsentEntity> accountConsents = (List<AccountConsentEntity>) findByCriteria(criteria);
		if(accountConsents.size()>0) return accountConsents.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<AccountConsentEntity> findByAccountIdAndConsented(UUID id, boolean consented) {
		DetachedCriteria criteria= DetachedCriteria.forClass(AccountConsentEntity.class);
		criteria.createAlias("account","account");
		criteria.add(Restrictions.eq("consented", consented));
		criteria.add(Restrictions.eq("account.id",id));
		
		return (List<AccountConsentEntity>) findByCriteria(criteria);

	}

	

}
