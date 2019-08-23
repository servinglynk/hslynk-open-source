package com.servinglynk.hmis.warehouse.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.model.AMQEvent;

@RequestMapping("/events")
@RestController
public class MessagePublishController extends ControllerBase {

	@Autowired
	private JmsTemplate jmsMessagingTemplate;
	
	@RequestMapping(method=RequestMethod.POST)
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
	public void sendMessageToQueue(@RequestBody AMQEvent event,HttpServletRequest request,HttpServletResponse response) throws Exception {
		ActiveMQQueue queue =  new ActiveMQQueue(event.getEventType());
		try {
			jmsMessagingTemplate.convertAndSend(queue, event.toJSONString());
		}catch (Exception e) {
			response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}
}
