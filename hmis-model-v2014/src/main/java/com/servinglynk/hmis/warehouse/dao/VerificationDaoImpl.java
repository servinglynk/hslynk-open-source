package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.v2014.VerificationEntity;

public class VerificationDaoImpl extends QueryExecutorImpl implements
		VerificationDao {


	public VerificationEntity create(VerificationEntity verification) {
		insert(verification);
		return verification;
	}

	@SuppressWarnings("unchecked")
	public VerificationEntity findByToken(String token) {
		DetachedCriteria criteria = DetachedCriteria.forClass(VerificationEntity.class);
		criteria.add(Restrictions.eq("token",token));
		List<VerificationEntity> verificationEntities = (List<VerificationEntity>) findByCriteria(criteria);
		if(verificationEntities.size()>0) return verificationEntities.get(0);
		return null;
	}

	public VerificationEntity updateVerification(
			VerificationEntity pVerification) {
		update(pVerification);
		return pVerification;
	}

}
