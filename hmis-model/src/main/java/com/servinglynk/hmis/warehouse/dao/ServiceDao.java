package com.servinglynk.hmis.warehouse.dao;

import com.servinglynk.hmis.warehouse.entity.ServiceEntity;

public interface ServiceDao {

	ServiceEntity findByExternalId(String externalId);

}
