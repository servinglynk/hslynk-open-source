package com.servinglynk.hmis.warehouse.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.SharingRule;
import com.servinglynk.hmis.warehouse.core.model.SharingRules;

public interface SharingRuleService {

	
	SharingRules createSharingRule(SharingRule sharingRule,String caller);
		SharingRule updateSharingRule(SharingRule sharingRule,String caller);
		SharingRule deleteSharingRule(UUID sharingRuleId,String caller);

}
