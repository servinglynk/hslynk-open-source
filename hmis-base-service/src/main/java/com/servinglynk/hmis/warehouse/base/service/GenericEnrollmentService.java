package com.servinglynk.hmis.warehouse.base.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.GenericEnrollment;
import com.servinglynk.hmis.warehouse.core.model.GenericEnrollments;

public interface GenericEnrollmentService {

	GenericEnrollment create(GenericEnrollment model,Account account);
	void update(GenericEnrollment model,Account account);
	GenericEnrollment getById(UUID id);
	GenericEnrollments getAllGlobalEnrollments(Integer start,Integer maxItems);
	void delete(UUID id);	
}