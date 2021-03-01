package com.servinglynk.hmis.warehouse.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.servinglynk.hmis.warehouse.common.JsonUtil;
import com.servinglynk.hmis.warehouse.model.AMQEvent;
import com.servinglynk.hmis.warehouse.model.JSONObjectMapper;

@Component
public class EventListener extends BaseListener {

	//@JmsListener(destination="subscription.event")
	public void processEvent(String eventString) {
		logger.debug("inside enrollment.chronichomeless listener"+eventString);
		JSONObjectMapper mapper = new JSONObjectMapper();
		try {
			AMQEvent event = mapper.readValue(eventString, AMQEvent.class);
			serviceFactory.getEventService().processEvent(event);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
