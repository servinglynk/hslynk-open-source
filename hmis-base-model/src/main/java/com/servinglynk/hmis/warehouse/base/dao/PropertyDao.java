package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.model.base.PropertyEntity;

public interface PropertyDao {

	public List<PropertyEntity> readProperties(String serviceName);
	public List<PropertyEntity> readCommonProperties();
}
