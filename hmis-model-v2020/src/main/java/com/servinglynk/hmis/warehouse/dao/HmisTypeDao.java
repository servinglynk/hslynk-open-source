package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.model.v2020.HMISTypeModel;

public interface HmisTypeDao {

	List<HMISTypeModel> getDataElementTypes();
	List<HMISTypeModel> getDataElements(String name);
}