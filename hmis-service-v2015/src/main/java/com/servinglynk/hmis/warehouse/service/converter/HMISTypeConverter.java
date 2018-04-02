package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.HMISType;
import com.servinglynk.hmis.warehouse.model.v2015.HMISTypeModel;

public class HMISTypeConverter {

	public static HMISType entityToModel(HMISTypeModel entity) {
		HMISType hmisType = new HMISType();
		if(entity.getName()!=null) hmisType.setName(entity.getName());
		if(entity.getValue()!=null) hmisType.setValue(entity.getValue());
		if(entity.getDescription()!=null) hmisType.setDescription(entity.getDescription());
		return hmisType;
	}
	
}