package com.servinglynk.hmis.warehouse.listener;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.annotation.JmsListener;

import com.servinglynk.hmis.warehouse.model.AMQEvent;
import com.servinglynk.hmis.warehouse.model.Client;
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
            SessionModel sessionModel = new SessionModel();
			sessionModel.setClientId(event.getPayload().get("clientId").toString());
			sessionModel.setProjectGroupCode(event.getPayload().get("projectGroupCode").toString());
			sessionModel.setSessionToken(event.getPayload().get("sessionToken").toString());
			
            HmisPostingModel hmisPostingModel = objectMapper.readValue(enrollmentData, HmisPostingModel.class);
	
			serviceFactory.getHmisPostingService().postHmis(hmisPostingModel, sessionModel);
			
		}catch (Exception e) {
		e.printStackTrace();	
		}
	}
}
