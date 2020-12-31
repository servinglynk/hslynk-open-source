package com.servinglynk.hmis.warehouse.listener;

import org.springframework.jms.annotation.JmsListener;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.servinglynk.hmis.warehouse.model.AMQEvent;
import com.servinglynk.hmis.warehouse.model.HmisPostingModel;
import com.servinglynk.hmis.warehouse.model.HmisPostingsModel;
import com.servinglynk.hmis.warehouse.model.JSONObjectMapper;
import com.servinglynk.hmis.warehouse.model.SessionModel;

public class HmisPostingListener extends BaseListener {
	
	@JmsListener(destination="hmis.posting")
	public void listeneQueue(String eventString) {
		System.out.println("inside hmis.posting listener");
		JSONObjectMapper mapper = new JSONObjectMapper();
		try {
			AMQEvent event = mapper.readValue(eventString, AMQEvent.class);
			String hmisPosting = event.getPayload().get("hmisPosting").toString();
			System.out.println("hmisPosting data "+hmisPosting);
			JSONObjectMapper objectMapper = new JSONObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			HmisPostingsModel hmisPostingsModel = objectMapper.readValue(hmisPosting, HmisPostingsModel.class);
			if(hmisPostingsModel != null) {
				HmisPostingModel hmisPostingModel = hmisPostingsModel.getHmisPosting();
				SessionModel sessionModel = new SessionModel();
				sessionModel.setTrustedAppId(event.getPayload().get("trustedAppId").toString());
				sessionModel.setProjectGroupCode(event.getPayload().get("projectGroupCode").toString());
				sessionModel.setSessionToken(event.getPayload().get("sessionToken").toString());
				
				serviceFactory.getHmisPostingService().postHmis(hmisPostingModel, sessionModel);
			}
		}catch (Exception e) {
		e.printStackTrace();	
		}
	}
}
