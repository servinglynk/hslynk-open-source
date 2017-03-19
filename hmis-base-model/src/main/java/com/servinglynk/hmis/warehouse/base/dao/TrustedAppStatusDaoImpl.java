package com.servinglynk.hmis.warehouse.base.dao;

import com.servinglynk.hmis.warehouse.model.base.TrustedAppStatusEntity;

public class TrustedAppStatusDaoImpl extends QueryExecutorImpl
		implements TrustedAppStatusDao {

	@Override
	public TrustedAppStatusEntity create(TrustedAppStatusEntity trustedAppStatusEntity) {
		insert(trustedAppStatusEntity);
		return trustedAppStatusEntity;
	}

	@Override
	public TrustedAppStatusEntity updateTrustedAppStatus(TrustedAppStatusEntity trustedAppStatusEntity) {
		update(trustedAppStatusEntity);
		return trustedAppStatusEntity;
	}

}
