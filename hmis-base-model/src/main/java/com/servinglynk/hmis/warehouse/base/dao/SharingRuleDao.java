package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.SharingRuleEntity;

public interface SharingRuleDao {
	
	List<SharingRuleEntity> getSharingRules(UUID roleId,String toProjectGroup);
	
	List<UUID> getSharedEnrollments(List<UUID> projects,String schemaYear);
	
	List<UUID> getSharedClients(List<UUID> enrollments,String schemaYear);

	SharingRuleEntity create(SharingRuleEntity entity);

}