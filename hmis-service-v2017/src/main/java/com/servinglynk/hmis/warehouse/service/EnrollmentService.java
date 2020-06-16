package com.servinglynk.hmis.warehouse.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Enrollment;
import com.servinglynk.hmis.warehouse.core.model.Enrollments;
import com.servinglynk.hmis.warehouse.core.model.Session;

public interface EnrollmentService {

	Enrollment createEnrollment(Enrollment enrollment,UUID clientId,Boolean updateGenericHouseHold, Session session);
	Enrollment updateEnrollment(Enrollment enrollment,UUID clientId,String caller, Session session));
	Enrollment deleteEnrollment(UUID enrollmentId,UUID clientId,String caller);
	Enrollment getEnrollmentByClientIdAndEnrollmentId(UUID enrollmentId,UUID clientId,boolean includeChildLinks);
	Enrollment getEnrollmentByEnrollmentId(UUID enrollmentId,boolean includeChildLinks);
	Enrollments getEnrollmentsByClientId(UUID clientId,String loginUser,Integer startIndex, Integer maxItems);
	Enrollment getEnrollmentByClientIdAndEnrollmentId(UUID enrollmentId, UUID clientId);
	Enrollment calculateChronicHomelessness(Enrollment enrollment, UUID clientId, String caller, Session session);
}
