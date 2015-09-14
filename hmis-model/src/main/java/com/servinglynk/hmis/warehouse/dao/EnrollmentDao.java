package com.servinglynk.hmis.warehouse.dao;

import java.util.UUID;

public interface EnrollmentDao extends ParentDao {

	
	com.servinglynk.hmis.warehouse.model.live.Enrollment getEnrollmentById(UUID enrollmentId);
	
	
}
