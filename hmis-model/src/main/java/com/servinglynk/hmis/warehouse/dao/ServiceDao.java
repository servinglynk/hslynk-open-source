package com.servinglynk.hmis.warehouse.dao;

import com.servinglynk.hmis.warehouse.model.v2014.ServiceEntity;

public interface ServiceDao {

	ServiceEntity findByExternalId(String externalId);

}
