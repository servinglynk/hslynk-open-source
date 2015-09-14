package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.live.PasswordResetEntity;

public class PasswordResetDaoImpl extends QueryExecutorImpl implements
		PasswordResetDao {


	public PasswordResetEntity create(PasswordResetEntity pPasswordReset) {
			insert(pPasswordReset);
		return pPasswordReset;
	}

	@SuppressWarnings("unchecked")
	public PasswordResetEntity findByVerificationId(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(PasswordResetEntity.class);
		criteria.createAlias("verification", "verification");
		criteria.add(Restrictions.eq("verification.id",id));
		List<PasswordResetEntity> passwordResetEntities = (List<PasswordResetEntity>) findByCriteria(criteria);
	if(passwordResetEntities.size()>0) return passwordResetEntities.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<PasswordResetEntity> findByAccountIdAndStatus(UUID id,
			String passwordResetStatus) {
		DetachedCriteria criteria = DetachedCriteria.forClass(PasswordResetEntity.class);
		criteria.createAlias("account", "account");
		criteria.add(Restrictions.eq("account.id",id));
		criteria.add(Restrictions.eq("status", passwordResetStatus));
		List<PasswordResetEntity> passwordResetEntities = (List<PasswordResetEntity>) findByCriteria(criteria);
	
		return passwordResetEntities;
	}


	public PasswordResetEntity updatePasswordReset(
			PasswordResetEntity pPasswordReset) {
			update(pPasswordReset);
		return pPasswordReset;
	}

}
