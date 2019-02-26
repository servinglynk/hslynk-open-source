package com.servinglynk.hmis.warehouse.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.core.model.HMISTypes;
import com.servinglynk.hmis.warehouse.model.v2017.HMISTypeModel;
import com.servinglynk.hmis.warehouse.service.HMISTypeService;
import com.servinglynk.hmis.warehouse.service.converter.HMISTypeConverter;

public class HMISTypeServiceImpl extends ServiceBase implements HMISTypeService {

	@Transactional
	public HMISTypes getDataElementNames() {
		HMISTypes hmisTypes = new HMISTypes();
		
		List<HMISTypeModel> hmisTypeModels = daoFactory.getHmisTypeDao().getDataElementTypes();
		for(HMISTypeModel hmisTypeModel : hmisTypeModels) {
			hmisTypes.addHmisType(HMISTypeConverter.entityToModel(hmisTypeModel));
		}	
		return hmisTypes;
	}
	
	
	@Transactional
	public HMISTypes getDataElements(String name){
		HMISTypes hmisTypes = new HMISTypes();
		
		List<HMISTypeModel> hmisTypeModels = daoFactory.getHmisTypeDao().getDataElements(name);
		for(HMISTypeModel hmisTypeModel : hmisTypeModels) {
			hmisTypes.addHmisType(HMISTypeConverter.entityToModel(hmisTypeModel));
		}	
		return hmisTypes;
	}
}