package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.GlobalEnrollmentEntity;
import com.servinglynk.hmis.warehouse.model.base.GlobalEnrollmentsMapEntity;

public interface GlobalEnrollmentDao {
	GlobalEnrollmentEntity create(GlobalEnrollmentEntity entity);
	void update(GlobalEnrollmentEntity entity);
	GlobalEnrollmentEntity getById(UUID id);
	List<GlobalEnrollmentEntity> getAllGlobalEnrollments(UUID dedupClientId, Integer start,Integer maxItems);
	Long getAllGlobalEnrollmentsCount(UUID dedupClientId);
	void createEnrollmentMap(GlobalEnrollmentsMapEntity entity);
	void deleteEnrollmentMap(GlobalEnrollmentsMapEntity entity);
	List<GlobalEnrollmentsMapEntity> getGlobalEnrollmentMappings(UUID globalEnrollmentId);
	 GlobalEnrollmentsMapEntity getByEnrollmetnMapId(UUID globalEnrollmentId, UUID enrollmentMapId);
	void removeAllEnrollments(UUID globalEnrollmentId);
}
