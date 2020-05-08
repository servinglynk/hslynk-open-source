package com.servinglynk.hmis.warehouse.base.service.converter;

import com.servinglynk.hmis.warehouse.core.model.GlobalEnrollment;
import com.servinglynk.hmis.warehouse.core.model.GlobalEnrollmentMap;
import com.servinglynk.hmis.warehouse.model.base.GlobalEnrollmentEntity;
import com.servinglynk.hmis.warehouse.model.base.GlobalEnrollmentsMapEntity;

public class GlobalEnrollmentConveter {
	
	public static GlobalEnrollmentEntity modelToEntity(GlobalEnrollmentEntity entity,GlobalEnrollment model) {
		if(entity==null) entity = new GlobalEnrollmentEntity();
		
		entity.setDedupClientId(model.getDedupClientId());
		return entity;
	}
	
	
	public static GlobalEnrollment entityToModel(GlobalEnrollmentEntity entity) {
		GlobalEnrollment model = new GlobalEnrollment();
		
	//	model.setDateCreated(entity.getDateCreated());
	//	model.setDateUpdated(entity.getDateUpdated());
		model.setId(entity.getId());
		model.setDedupClientId(entity.getDedupClientId());
	
		return model;
	}
	
	public static GlobalEnrollmentsMapEntity modelToEntity(GlobalEnrollmentsMapEntity entity,GlobalEnrollmentMap model) {
		if(entity==null) entity = new GlobalEnrollmentsMapEntity();
		entity.setClientId(model.getClientId());
		entity.setEnrollmentId(model.getEnrollmentId());
		entity.setSource(model.getSource());
		return entity;
	}
	
	public static GlobalEnrollmentMap entityToModel(GlobalEnrollmentsMapEntity entity) {
		GlobalEnrollmentMap model = new GlobalEnrollmentMap();
		
		model.setClientId(entity.getClientId());
		model.setEnrollmentId(entity.getEnrollmentId());
		//model.setId(entity.getId());
		model.setSource(entity.getSource());
	//	model.setDateCreated(entity.getDateCreated());
	//	model.setDateUpdated(entity.getDateUpdated());
		if(entity.getGenericEnrollmentEntity()!=null)model.setGenericEnrollmentId(entity.getGenericEnrollmentEntity().getId());
		model.setLink("hmis-clientapi/v"+entity.getSource()+"/rest/clients/"+entity.getClientId()+"/enrollments/"+entity.getEnrollmentId());
		return model;
	}

}