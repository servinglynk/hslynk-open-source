package com.servinglynk.hmis.warehouse.listener;

import java.util.UUID;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.model.AMQEvent;
import com.servinglynk.hmis.warehouse.model.HmisHouseHoldModel;
import com.servinglynk.hmis.warehouse.model.JSONObjectMapper;

@Component
public class GlobalHouseHoldListener extends BaseListener {
	
	@JmsListener(destination="globalHouseHold")
	public void listeneQueue(String eventString) {
		System.out.println("inside client.delete listener");
		JSONObjectMapper mapper = new JSONObjectMapper();
		try {
			AMQEvent event = mapper.readValue(eventString, AMQEvent.class);
			HmisHouseHoldModel model = new HmisHouseHoldModel();
			if(event.getPayload().get("hmisHouseHoldId")!=null) model.setHmisHouseHoldId(UUID.fromString(event.getPayload().get("hmisHouseHoldId").toString()));
			if(event.getPayload().get("clientId")!=null)model.setClientId(UUID.fromString(event.getPayload().get("clientId").toString()));
			if(event.getPayload().get("dedupClientId")!=null)model.setDedupClientId(UUID.fromString(event.getPayload().get("dedupClientId").toString()));
			if(event.getPayload().get("deleted")!=null)model.setDeleted(Boolean.valueOf(event.getPayload().get("deleted").toString()));
			if(event.getPayload().get("projectGroupCode")!=null)model.setProjectGroupCode(event.getPayload().get("projectGroupCode").toString());
			if(event.getPayload().get("userId")!=null)model.setUserId(UUID.fromString(event.getPayload().get("userId").toString()));
			if(event.getPayload().get("sourceSystemId")!=null)model.setSourceSystemId(event.getPayload().get("sourceSystemId").toString());
			if(event.getPayload().get("sourceSystemHouseHoldId")!=null)model.setSourceSystemHouseHoldId(event.getPayload().get("sourceSystemHouseHoldId").toString());
			if(event.getPayload().get("schema")!=null)model.setSchema(event.getPayload().get("schema").toString());
			if(event.getPayload().get("genericHouseHoldId")!=null) model.setGenericHouseHoldId(UUID.fromString(event.getPayload().get("genericHouseHoldId").toString()));
			if(!model.getDeleted())
				serviceFactory.getGlobalHouseHoldService().createGlobalHouseHold(model);
			else
				serviceFactory.getGlobalHouseHoldService().deleteGlobalHouseHold(model);
			
		}catch (Exception e) {
		e.printStackTrace();	
		}
	}
}
