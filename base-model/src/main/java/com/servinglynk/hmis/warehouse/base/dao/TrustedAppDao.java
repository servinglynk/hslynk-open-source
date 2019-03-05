package com.servinglynk.hmis.warehouse.base.dao;

import com.servinglynk.hmis.warehouse.model.base.TrustedAppEntity;

public interface TrustedAppDao {
	
	public TrustedAppEntity updateTrustedApp(TrustedAppEntity trustedAppEntity);
	
	public TrustedAppEntity findByExternalId(String externalId);
	
	public void deleteTrustedApp(TrustedAppEntity trustedAppEntity);

	public void create(TrustedAppEntity trustedAppEntity);

}
