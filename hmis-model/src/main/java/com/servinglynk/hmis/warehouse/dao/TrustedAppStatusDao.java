package com.servinglynk.hmis.warehouse.dao;

import com.servinglynk.hmis.warehouse.model.v2014.TrustedAppStatusEntity;

public interface TrustedAppStatusDao {

	TrustedAppStatusEntity create(TrustedAppStatusEntity trustedAppStatusEntity);
	TrustedAppStatusEntity updateTrustedAppStatus(TrustedAppStatusEntity trustedAppStatusEntity);
}
