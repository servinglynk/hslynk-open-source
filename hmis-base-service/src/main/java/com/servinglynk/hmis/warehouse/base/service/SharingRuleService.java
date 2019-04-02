package com.servinglynk.hmis.warehouse.base.service;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.SharingRule;
import com.servinglynk.hmis.warehouse.core.model.SharingRules;

public interface SharingRuleService {

	List<UUID> getSharedEnrollments(String schemaYear);
	List<UUID> getSharedClients(List<UUID> enrollments,String schemaYear);
	SharingRules createSharingRule(SharingRule sharingRule, String caller);
	
}