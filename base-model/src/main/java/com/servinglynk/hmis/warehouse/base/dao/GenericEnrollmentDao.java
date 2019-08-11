package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.GenericEnrollmentEntity;

public interface GenericEnrollmentDao {
	GenericEnrollmentEntity create(GenericEnrollmentEntity entity);
	void updateGenericEnrollment(GenericEnrollmentEntity entity);
	GenericEnrollmentEntity getById(UUID id);
	List<GenericEnrollmentEntity> getAllGlobalEnrollments(Integer start,Integer maxItems);
	Long getAllGlobalEnrollmentsCount();
	void deleteGenericEnrollment(GenericEnrollmentEntity entity);

}
