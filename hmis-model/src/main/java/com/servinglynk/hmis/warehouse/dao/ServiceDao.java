package com.servinglynk.hmis.warehouse.dao;

import com.servinglynk.hmis.warehouse.model.live.ServiceEntity;

public interface ServiceDao {

	ServiceEntity findByExternalId(String externalId);

}
