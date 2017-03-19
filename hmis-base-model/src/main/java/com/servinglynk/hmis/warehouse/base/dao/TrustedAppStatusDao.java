package com.servinglynk.hmis.warehouse.base.dao;

import com.servinglynk.hmis.warehouse.model.base.TrustedAppStatusEntity;

public interface TrustedAppStatusDao {

	TrustedAppStatusEntity create(TrustedAppStatusEntity trustedAppStatusEntity);
	TrustedAppStatusEntity updateTrustedAppStatus(TrustedAppStatusEntity trustedAppStatusEntity);
}
