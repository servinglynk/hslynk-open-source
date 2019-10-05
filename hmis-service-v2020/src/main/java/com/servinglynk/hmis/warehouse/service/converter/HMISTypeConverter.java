package com.servinglynk.hmis.warehouse.service.converter;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

import com.servinglynk.hmis.warehouse.core.model.HMISType;
import com.servinglynk.hmis.warehouse.model.v2020.HMISTypeModel;

public class HMISTypeConverter {

	public static HMISType entityToModel(HMISTypeModel entity) {
		HMISType hmisType = new HMISType();
		if(entity.getName()!=null) hmisType.setName(StringUtils.strip(entity.getName()));
		if(entity.getValue()!=null) hmisType.setValue(StringUtils.strip(entity.getValue()));
		if(entity.getDescription()!=null) hmisType.setDescription(entity.getDescription());
		return hmisType;
	}
	
}