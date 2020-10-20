package com.servinglynk.hmis.warehouse.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.model.AMQEvent;
import com.servinglynk.hmis.warehouse.model.JSONObjectMapper;
import com.servinglynk.hmis.warehouse.model.SessionModel;

@Component
public class ChronicHomelessListener extends BaseListener {

	@JmsListener(destination="enrollment.chronichomeless")
	public void listeneQueue(String eventString) {
		System.out.println("inside enrollment.chronichomeless listener");
		JSONObjectMapper mapper = new JSONObjectMapper();
		try {
			AMQEvent event = mapper.readValue(eventString, AMQEvent.class);
			
			SessionModel model = new SessionModel();
			if(event.getPayload().get("enrollmentId")!=null) model.setEnrollmentId(event.getPayload().get("enrollmentId").toString());
			if(event.getPayload().get("trustedAppId")!=null) model.setTrustedAppId(event.getPayload().get("trustedAppId").toString());
			if(event.getPayload().get("clientId")!=null) model.setClientId(event.getPayload().get("clientId").toString());
			if(event.getPayload().get("projectGroupCode")!=null) model.setProjectGroupCode(event.getPayload().get("projectGroupCode").toString());
			String schemaYear = event.getPayload().get("schemaYear").toString();
			serviceFactory.getEnrollmentService().calCulateChronicHomelessness(model, schemaYear);
			
		}catch (Exception e) {
		e.printStackTrace();	
		}
	}
}