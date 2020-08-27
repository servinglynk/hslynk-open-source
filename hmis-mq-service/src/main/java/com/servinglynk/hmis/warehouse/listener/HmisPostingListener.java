package com.servinglynk.hmis.warehouse.listener;

import java.util.List;
import java.util.Map;

import org.springframework.jms.annotation.JmsListener;

import com.servinglynk.hmis.warehouse.model.AMQEvent;
import com.servinglynk.hmis.warehouse.model.EnrollmentModel;
import com.servinglynk.hmis.warehouse.model.HmisHouseHoldModel;
import com.servinglynk.hmis.warehouse.model.HmisPostingModel;
import com.servinglynk.hmis.warehouse.model.JSONObjectMapper;
import com.servinglynk.hmis.warehouse.model.MQJsonObjectMapper;
import com.servinglynk.hmis.warehouse.model.QuestionResponseModel;
import com.servinglynk.hmis.warehouse.model.SessionModel;

public class HmisPostingListener extends BaseListener {
	
	@JmsListener(destination="hmis.posting")
	public void listeneQueue(String eventString) {
		System.out.println("inside hmis.posting listener");
		JSONObjectMapper mapper = new JSONObjectMapper();
		MQJsonObjectMapper objectMapper = new MQJsonObjectMapper();
		try {
			AMQEvent event = mapper.readValue(eventString, AMQEvent.class);
			
			String enrollmentData = event.getPayload().get("hmisPosting").toString();
			System.out.println("enrollment data "+enrollmentData);
            Map<String, String> map = mapper.readValue(enrollmentData, Map.class);

            HmisPostingModel hmisPostingModel = objectMapper.readValue(enrollmentData, HmisPostingModel.class);
			SessionModel sessionModel = new SessionModel();
			sessionModel.setClientId(event.getPayload().get("clientId").toString());
			sessionModel.setProjectGroupCode(event.getPayload().get("projectGroupCode").toString());
			sessionModel.setSessionToken(event.getPayload().get("sessionToken").toString());
			String schemaYear = event.getPayload().get("schemaYear").toString();
			//Login for Hmis posting goes here
			List<QuestionResponseModel> questionResponses = hmisPostingModel.getQuestionResponses();
			for(QuestionResponseModel questionResponseModel : questionResponses) {
				//questionResponseModel.get
			}
		//	serviceFactory.getHmisPostingService().updateEnrollment(enrollment,sessionModel,schemaYear);
			
		}catch (Exception e) {
		e.printStackTrace();	
		}
	}
}
