package com.servinglynk.hmis.warehouse.service.publish.handler;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.servinglynk.hmis.entity.SubscriptionEntity;
import com.servinglynk.hmis.warehouse.service.BaseService;

@Service("restPushHandler")
public class RestPushHandler extends BaseService implements EventPublisher {
	
	
	/* {
	"resourceType¨: "enrollment"
	"endpoint":
	"channel": {
	"endpoint": "https://hslynk.com/rest/v2020/clients​/{clientid}​/enrollments​/{enrollmentid}",
	}
	}
	*/

	@Autowired private RestTemplate restTemplate;
	
	@Override
	public void publish(SubscriptionEntity entity) {
		System.out.println("inside rest push handelr");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json; charset=UTF-8");
		headers.add("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		if(entity.getChannelHeader()!=null) {
			String[] header = entity.getChannelHeader().split(":");
			if(header.length == 2)
				headers.add(header[0],header[1]);			
		}

		
		
		JSONObject channel = new JSONObject();
		channel.put("endpoint", entity.getCriteriaUrl());
		
		
		JSONObject body = new JSONObject();
		body.put("resourceType", "enrollment");
		body.put("endpoint", "");
		body.put("channel", channel);
		
		
		HttpEntity httpEntity = new HttpEntity(body.toJSONString(),headers);
		restTemplate.postForObject(entity.getChannelEndpoint(),httpEntity ,Object.class);
		
		
	}
	
	
	
	
	public static void main(String args[]) {
		RestPushHandler handler = new RestPushHandler();
		SubscriptionEntity entity = new SubscriptionEntity();
		entity.setCriteriaUrl("test");
		handler.publish(entity);
	}
	

}
