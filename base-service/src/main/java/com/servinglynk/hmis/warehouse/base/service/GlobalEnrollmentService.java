package com.servinglynk.hmis.warehouse.base.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.GlobalEnrollment;
import com.servinglynk.hmis.warehouse.core.model.GlobalEnrollments;
import com.servinglynk.hmis.warehouse.core.model.GlobalEnrollmentsMap;

public interface GlobalEnrollmentService {

	GlobalEnrollment create(GlobalEnrollment model,Account account);
	void update(GlobalEnrollment model,Account account);
	GlobalEnrollment getById(UUID id);
	GlobalEnrollments getAllGlobalEnrollments(UUID dedupClientId,Integer start,Integer maxItems);
	
    void mapEnrollmentsToGlobalEnrollment(UUID globalEnrollmentId, GlobalEnrollmentsMap enrollments,Account account);
    void removeEnrollmentsFromGlobalEnrollment(UUID globalEnrollmentId, UUID enrollmentMapId);
}
