package com.servinglynk.hmis.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.dao.DaoFactory;
import com.servinglynk.hmis.warehouse.client.MessageSender;
import com.servinglynk.hmis.warehouse.model.AMQEvent;

public class BaseService {
	
	@Autowired 
	protected DaoFactory daoFactory;
	
	@Autowired
	protected ValidationService validationService;
	
	@Autowired MessageSender messageSender;
	
	
	public void sendClientMetaInfo(UUID clientId,UUID clientDedupId,Boolean isDelete,String type) {
		AMQEvent amqEvent = new AMQEvent();

		amqEvent.setEventType("client.metadata");
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("clientId", clientId);
		data.put("dedupClientId", clientDedupId);
		data.put("deleted", false);
		data.put("projectGroupCode", SecurityContextUtil.getUserProjectGroup());
		data.put("userId", SecurityContextUtil.getUserAccount().getAccountId());
		data.put("deleted",isDelete);
		amqEvent.setPayload(data);
		amqEvent.setModule("hmis");
		amqEvent.setType(type);
		amqEvent.setSubsystem("bedInventory");
		messageSender.sendAmqMessage(amqEvent);
	}

}
