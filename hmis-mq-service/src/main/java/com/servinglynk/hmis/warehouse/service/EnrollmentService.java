package com.servinglynk.hmis.warehouse.service;

import java.util.UUID;

import org.springframework.http.HttpHeaders;

import com.servinglynk.hmis.warehouse.model.EnrollmentModel;
import com.servinglynk.hmis.warehouse.model.SessionModel;

public interface EnrollmentService {
	UUID createEnrollment(String schemaYear,UUID clientId,EnrollmentModel enrollmentModel,HttpHeaders headers);
	void updateEnrollment(EnrollmentModel enrollment,SessionModel sessionModel,String schemaYear);
	void calCulateChronicHomelessness(SessionModel sessionModel,String schemaYear);

}
