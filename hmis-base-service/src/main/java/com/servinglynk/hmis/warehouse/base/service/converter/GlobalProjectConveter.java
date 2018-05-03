package com.servinglynk.hmis.warehouse.base.service.converter;

import com.servinglynk.hmis.warehouse.core.model.GlobalProject;
import com.servinglynk.hmis.warehouse.core.model.GlobalProjectMap;
import com.servinglynk.hmis.warehouse.core.model.GlobalProjectUser;
import com.servinglynk.hmis.warehouse.model.base.GlobalProjectEntity;
import com.servinglynk.hmis.warehouse.model.base.GlobalProjectMapEntity;
import com.servinglynk.hmis.warehouse.model.base.HmisUser;

public class GlobalProjectConveter {
	
	public static GlobalProjectEntity modelToEntity(GlobalProject model,GlobalProjectEntity entity) {
		
		if(entity==null) entity = new GlobalProjectEntity();
		if(model.getDescription()!=null) entity.setDescription(model.getDescription());
		if(model.getProjectCommonName()!=null) entity.setProjectCommonName(model.getProjectCommonName());
		if(model.getProjectName()!=null) entity.setProjectName(model.getProjectName());
		if(model.getSourceSystemId()!=null) entity.setSourceSystemId(model.getSourceSystemId());
		
		return entity;
	}

	public static GlobalProject entityToModel(GlobalProjectEntity entity) {
		GlobalProject model = new GlobalProject();
		
		model.setId(entity.getId());
		if(entity.getDescription()!=null) model.setDescription(entity.getDescription());
		if(entity.getProjectCommonName()!=null) model.setProjectCommonName(entity.getProjectCommonName());
		if(entity.getProjectName()!=null) model.setProjectName(entity.getProjectName());		
		return model;
	}
	
	
	public static GlobalProjectMapEntity modelToEntity(GlobalProjectMap model, GlobalProjectMapEntity entity) {
		if(entity==null) entity = new GlobalProjectMapEntity();
		entity.setProjectId(model.getProjectId());
		entity.setSource(model.getSource());	
		return entity;
	}
	
	public static GlobalProjectMap enityToModel(GlobalProjectMapEntity entity) {
		GlobalProjectMap model = new GlobalProjectMap();
		model.setProjectId(entity.getProjectId());
		model.setSource(entity.getSource());
		if(entity.getSource()!=null) model.setLink("/hmis-clientapi/v"+entity.getSource()+"/rest/projects/"+entity.getProjectId());
		return model;
	}
	
	public static GlobalProjectUser entityToModel(HmisUser hmisUser) {
		GlobalProjectUser user = new GlobalProjectUser();
		user.setUserId(hmisUser.getId());
		user.setFirstName(hmisUser.getFirstName());
		user.setMiddleName(hmisUser.getMiddleName());
		user.setLastName(hmisUser.getLastName());
		user.setUsername(hmisUser.getUsername());
		user.setEmailAddress(hmisUser.getEmailAddress());
		user.setStatus(hmisUser.getStatus());
		user.setLink("/hmis-user-service/rest/accounts/"+hmisUser.getId());
		
		return user;
	}
	

}