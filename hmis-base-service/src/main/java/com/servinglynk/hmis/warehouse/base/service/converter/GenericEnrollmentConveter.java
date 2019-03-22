package com.servinglynk.hmis.warehouse.base.service.converter;

import com.servinglynk.hmis.warehouse.core.model.GenericEnrollment;
import com.servinglynk.hmis.warehouse.model.base.GenericEnrollmentEntity;

public class GenericEnrollmentConveter {

	public static GenericEnrollmentEntity modelToEntity(GenericEnrollmentEntity entity, GenericEnrollment model) {
		if(entity==null) entity = new GenericEnrollmentEntity();
		
		if(model.getActive()!=null) entity.setActive(model.getActive());
		if(model.getEndTime()!=null) entity.setEndTime(model.getEndTime());
		if(model.getGlobalEnrollmentId()!=null) entity.setGlobalEnrollmentId(model.getGlobalEnrollmentId());
		if(model.getGlobalHouseHoldId()!=null) entity.setGlobalHouseHoldId(model.getGlobalHouseHoldId());
		if(model.getGlobalProjectId()!=null) entity.setGlobalProjectId(model.getGlobalProjectId());
		if(model.getStartTime()!=null) entity.setStartTime(model.getStartTime());
		
		return entity;
	}

	public static GenericEnrollment entityToModel(GenericEnrollmentEntity entity) {
		GenericEnrollment model = new GenericEnrollment();
		
		if(entity.getActive()!=null) model.setActive(entity.getActive());
		if(entity.getEndTime()!=null) model.setEndTime(entity.getEndTime());
		if(entity.getGlobalEnrollmentId()!=null) model.setGlobalEnrollmentId(entity.getGlobalEnrollmentId());
		if(entity.getGlobalHouseHoldId()!=null) model.setGlobalHouseHoldId(entity.getGlobalHouseHoldId());
		if(entity.getGlobalProjectId()!=null) model.setGlobalProjectId(entity.getGlobalProjectId());
		if(entity.getStartTime()!=null) model.setStartTime(entity.getStartTime());
		model.setId(entity.getId());
		
		return model;
	}

}
