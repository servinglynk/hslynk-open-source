package com.servinglynk.hmis.warehouse.base.service.converter;

import com.servinglynk.hmis.warehouse.core.model.SharingRule;
import com.servinglynk.hmis.warehouse.model.base.SharingRuleEntity;

public class SharingRuleConverter {

	
	public static SharingRule entityToModel(SharingRuleEntity entity){
		SharingRule sharingRule=new SharingRule();
		sharingRule.setSharingRuleId(entity.getId());
		sharingRule.setActiveFrom(entity.getActiveFrom());
		sharingRule.setActiveTo(entity.getActiveTo());
		if(entity.getProfile()!=null)	sharingRule.setProfile(ProfileConverter.entityToModel(entity.getProfile()));
		if(entity.getGlobalProjectEntity()!=null) sharingRule.setProject(GlobalProjectConveter.entityToModel(entity.getGlobalProjectEntity()));
		if(entity.getToUser()!=null) sharingRule.setUser(AccountConverter.convertToAccount(entity.getToUser()));
		return sharingRule;
	}
	
	
}
