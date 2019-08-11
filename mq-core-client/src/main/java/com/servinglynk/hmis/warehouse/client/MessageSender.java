package com.servinglynk.hmis.warehouse.client;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.model.AMQEvent;

//@Component
public class MessageSender  {

	@Autowired
	private JmsTemplate jmsMessagingTemplate;
	
	@Async
	public void sendAmqMessage(AMQEvent event) {
		
		ActiveMQQueue queue =  new ActiveMQQueue(event.getEventType());
		try {
			jmsMessagingTemplate.convertAndSend(queue, event.toJSONString());
		} catch (JmsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void run(String... args) throws Exception {
		AMQEvent event = new AMQEvent();
		event.setCreatedAt(new Date());
		event.setEventType("surver.response");
		Map<String, Object> data = new HashMap<>();
		data.put("hai","hai");
		event.setPayload(data);
		this.sendAmqMessage(event);
	}
	
}