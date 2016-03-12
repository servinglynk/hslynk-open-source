package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.SharingRuleEntity;

public interface SharingRuleDao {

	SharingRuleEntity insertSharingRule(SharingRuleEntity sharingRuleEntity);
	SharingRuleEntity updateSharingRule(SharingRuleEntity sharingRuleEntity);
	SharingRuleEntity getSharingRuleId(UUID sharingRuleId);
	void deleteSharingRule(SharingRuleEntity sharingRuleEntity);
	List<Enrollment> getSharedEnrollments(UUID userId,UUID organizationId);
}
