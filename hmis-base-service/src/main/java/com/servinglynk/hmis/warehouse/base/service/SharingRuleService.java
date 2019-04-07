package com.servinglynk.hmis.warehouse.base.service;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.SharingRule;
import com.servinglynk.hmis.warehouse.core.model.SharingRules;

public interface SharingRuleService {

	List<UUID> getSharedEnrollments(List<UUID> projects,String schemaYear);
	List<UUID> getSharedProjects();
	List<UUID> getSharedClients(List<UUID> enrollments,String schemaYear);
	SharingRule createSharingRule(SharingRule sharingRule);
	void updateSharingRule(SharingRule sharingRule);
	void deleteSharingRule(UUID sharingRuleId);
	SharingRule getSharingRuleById(UUID sharingRuleId);
	SharingRules getAllSharingRules(Integer start, Integer maxItems);
	
}