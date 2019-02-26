package com.servinglynk.hmis.warehouse.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Enrollment;
import com.servinglynk.hmis.warehouse.core.model.Enrollments;

public interface EnrollmentServiceV2 {


	Enrollment getEnrollmentByClientIdAndEnrollmentId(UUID enrollmentId,UUID clientId);
	Enrollments getEnrollmentsByClientId(UUID clientId,String loginUser,Integer startIndex, Integer maxItems);
}
