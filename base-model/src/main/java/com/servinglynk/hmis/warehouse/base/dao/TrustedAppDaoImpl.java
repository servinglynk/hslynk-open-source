package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.TrustedAppEntity;

public class TrustedAppDaoImpl extends QueryExecutorImpl implements TrustedAppDao {

	@Override
	public TrustedAppEntity updateTrustedApp(TrustedAppEntity trustedAppEntity) {
			update(trustedAppEntity);
		return trustedAppEntity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TrustedAppEntity findByExternalId(String externalId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(TrustedAppEntity.class);
		criteria.add(Restrictions.eq("externalId",externalId));
		List<TrustedAppEntity> trustedAppEntities = (List<TrustedAppEntity>) findByCriteria(criteria);
		if(trustedAppEntities.size()>0) return trustedAppEntities.get(0);
		return null;
	}

	@Override
	public void deleteTrustedApp(TrustedAppEntity trustedAppEntity) {
		delete(trustedAppEntity);
		
	}

	@Override
	public void create(TrustedAppEntity trustedAppEntity) {
		insert(trustedAppEntity);
		
	}

}
