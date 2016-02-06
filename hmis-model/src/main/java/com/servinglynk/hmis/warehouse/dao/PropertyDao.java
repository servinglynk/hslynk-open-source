package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.model.live.PropertyEntity;

public interface PropertyDao {

	public List<PropertyEntity> readProperties(String serviceName);
	public List<PropertyEntity> readCommonProperties();
}
