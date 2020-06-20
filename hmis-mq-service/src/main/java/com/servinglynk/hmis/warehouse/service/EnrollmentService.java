package com.servinglynk.hmis.warehouse.service;

import com.servinglynk.hmis.warehouse.model.EnrollmentModel;
import com.servinglynk.hmis.warehouse.model.SessionModel;

public interface EnrollmentService {

	void updateEnrollment(EnrollmentModel enrollment,SessionModel sessionModel,String schemaYear);
	void calCulateChronicHomelessness(SessionModel sessionModel,String schemaYear);

}
