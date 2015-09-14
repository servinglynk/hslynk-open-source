package com.servinglynk.hmis.warehouse.dao;

import com.servinglynk.hmis.warehouse.model.live.TrustedAppStatusEntity;

public interface TrustedAppStatusDao {

	TrustedAppStatusEntity create(TrustedAppStatusEntity trustedAppStatusEntity);
	TrustedAppStatusEntity updateTrustedAppStatus(TrustedAppStatusEntity trustedAppStatusEntity);
}
