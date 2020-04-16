package com.servinglynk.hmis.warehouse.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.Enrollment;
import com.servinglynk.hmis.warehouse.core.model.Enrollments;

public interface EnrollmentService {

	Enrollment createEnrollment(Enrollment enrollment,UUID clientId,Account account);
	Enrollment updateEnrollment(Enrollment enrollment,UUID clientId,String caller);
	Enrollment deleteEnrollment(UUID enrollmentId,UUID clientId,String caller);
	Enrollment getEnrollmentByClientIdAndEnrollmentId(UUID enrollmentId,UUID clientId);
	Enrollment getEnrollmentByEnrollmentId(UUID enrollmentId);
	Enrollments getEnrollmentsByClientId(UUID clientId,String loginUser,Integer startIndex, Integer maxItems);
}
