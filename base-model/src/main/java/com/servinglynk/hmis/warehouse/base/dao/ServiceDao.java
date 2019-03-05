package com.servinglynk.hmis.warehouse.base.dao;

import com.servinglynk.hmis.warehouse.model.base.ServiceEntity;

public interface ServiceDao {

	ServiceEntity findByExternalId(String externalId);

}
