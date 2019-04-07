package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.SharingRuleEntity;

public interface SharingRuleDao {
	
	List<SharingRuleEntity> getSharingRules(UUID profileId,UUID userId);
	
	List<UUID> getSharedEnrollments(List<UUID> projects,String schemaYear);
	
	List<UUID> getSharedClients(List<UUID> enrollments,String schemaYear);

	SharingRuleEntity create(SharingRuleEntity entity);

	SharingRuleEntity getSharingRuleById(UUID sharingRuleId);

	void updateSharingRule(SharingRuleEntity sharingRuleEntity);

	void deleteSharingRule(SharingRuleEntity sharingRuleEntity);

	List<SharingRuleEntity> getAllSharingRules(Integer start, Integer maxItems);

	Long getAllSharingRulesCount();

}