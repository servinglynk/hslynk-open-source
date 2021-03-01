package com.servinglynk.hmis.warehouse.service;

import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.servinglynk.hmis.entity.ClientEntity;

@Service
public class SubscriptionServiceImpl extends BaseService implements SubscriptionService {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	 @Autowired
	    private SimpMessagingTemplate template;

	@Override
	public void processSubscriptionEvent(Map<String, Object> requestData) {
	    		String clientId = 	(String) requestData.get("clientid");
	    		if(clientId!=null) {
	    			ClientEntity clientEntity =	daoFactory.getClientRepository().findByIdAndDeleted(UUID.fromString(clientId), new Boolean(false));
	    			if(clientEntity!=null) {
	    				String message = clientEntity.getFirstName()+" "+clientEntity.getLastName()+" data updated";
		    			template.convertAndSend("/clients/"+clientId, requestData);
		    			template.convertAndSend("/clients/"+clientEntity.getDedupClientId(), requestData);
		    			template.convertAndSend("/clients", requestData);
		    			logger.info("client subscription update sent");
	    			}
	    		}


	}

}
