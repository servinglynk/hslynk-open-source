package com.servinglynk.hmis.warehouse.listener;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.model.AMQEvent;
import com.servinglynk.hmis.warehouse.model.ClientMetaDataModel;
import com.servinglynk.hmis.warehouse.model.JSONObjectMapper;
import com.servinglynk.hmis.warehouse.service.ClientManagementService;

@Component
public class ClientMergeListener  {
	
	@Autowired ClientManagementService clientManagementService;

	@JmsListener(destination="client.merge")
	public void listeneQueue(String eventString) {
		

		
		System.out.println("inside client.merge listener");
		JSONObjectMapper mapper = new JSONObjectMapper();
		try {
			AMQEvent event = mapper.readValue(eventString, AMQEvent.class);
			
			ClientMetaDataModel model = new ClientMetaDataModel();
			model.setAdditionalInfo(mapper.writeValueAsString(event.getPayload()));
			if(event.getPayload().get("currentDedupId")!=null) model.setClientDedupId(UUID.fromString(event.getPayload().get("currentDedupId").toString()));
			if(event.getPayload().get("targetDedupId")!=null) model.setNewDedulClientId(UUID.fromString(event.getPayload().get("targetDedupId").toString()));
			if(event.getPayload().get("clientId")!=null) model.setClientId(UUID.fromString(event.getPayload().get("clientId").toString()));
			if(event.getPayload().get("projectGroupCode")!=null) model.setProjectGroupCode(event.getPayload().get("projectGroupCode").toString());
			model.setType(event.getEventType());

			clientManagementService.mergeClientIdentities(model);
			
		}catch (Exception e) {
		e.printStackTrace();	
		}
	}
}