package com.servinglynk.hmis.warehouse.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.model.AMQEvent;
import com.servinglynk.hmis.warehouse.model.EnrollmentModel;
import com.servinglynk.hmis.warehouse.model.JSONObjectMapper;
import com.servinglynk.hmis.warehouse.model.MQJsonObjectMapper;
import com.servinglynk.hmis.warehouse.model.SessionModel;

@Component
public class EnrollmentGenericHouseHoldListener extends BaseListener {
	                          //enrollment.generichousehold
	@JmsListener(destination="enrollment.generichousehold")
	public void listeneQueue(String eventString) {
		JSONObjectMapper mapper = new JSONObjectMapper();
		MQJsonObjectMapper objectMapper = new MQJsonObjectMapper();
		try {
			System.out.println("payload "+eventString);
			AMQEvent event = mapper.readValue(eventString, AMQEvent.class);
			String enrollmentData = event.getPayload().get("enrollemnt").toString();
			System.out.println("enrollment data "+enrollmentData);
          //  Map<String, String> map = mapper.readValue(enrollmentData, Map.class);

		//	EnrollmentModel enrollment = mapper.readValue(mapper.writeValueAsString(map.get("enrollment")), EnrollmentModel.class);
			EnrollmentModel enrollment = objectMapper.readValue(enrollmentData, EnrollmentModel.class);
			SessionModel sessionModel = new SessionModel();
			sessionModel.setClientId(event.getPayload().get("clientId").toString());
			sessionModel.setProjectGroupCode(event.getPayload().get("projectGroupCode").toString());
			sessionModel.setSessionToken(event.getPayload().get("sessionToken").toString());
			String schemaYear = event.getPayload().get("schemaYear").toString();
			serviceFactory.getEnrollmentService().updateEnrollment(enrollment,sessionModel,schemaYear);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
