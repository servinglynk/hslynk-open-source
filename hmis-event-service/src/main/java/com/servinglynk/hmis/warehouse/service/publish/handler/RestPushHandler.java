package com.servinglynk.hmis.warehouse.service.publish.handler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.params.CoreConnectionPNames;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.servinglynk.hmis.entity.SubscriptionEntity;
import com.servinglynk.hmis.warehouse.service.BaseService;

//@Service("restPushHandler")
@Async
public class RestPushHandler extends BaseService implements EventPublisher {
	
	
	/* {
	"resourceType¨: "enrollment"
	"endpoint":
	"channel": {
	"endpoint": "https://hslynk.com/rest/v2020/clients​/{clientid}​/enrollments​/{enrollmentid}",
	}
	}
	*/

	 private RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public void publish(SubscriptionEntity entity)  {
		System.out.println("inside rest push handelr");
		HttpPost request = new HttpPost(entity.getChannelEndpoint());
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Accept", "application/json");
		headers.add("Content-Type",MediaType.APPLICATION_JSON_VALUE);
	//	request.addHeader("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		if(entity.getChannelHeader()!=null) {
			String[] header = entity.getChannelHeader().split(":");
			if(header.length == 2) {
		//		request.addHeader("Authorization", "HMISUserAuth session_token=TT0013SESSION");			
			}}

		
		
		JSONObject channel = new JSONObject();
		channel.put("endpoint", entity.getCriteriaUrl());
		
		
		JSONObject body = new JSONObject();
		body.put("resourceType", "enrollment");
		body.put("reason", entity.getReason());
		body.put("endpoint", "");
		body.put("channel", channel);
		
		
	//	String jbody = "{\"endpoint\":\"\",\"channel\":{\"endpoint\":"+entity.getCriteriaUrl().replaceAll("\\", "\\\\")+"},\"resourceType\":\"enrollment\"}";
		
		HttpEntity httpEntity = new HttpEntity(body,headers);
		System.out.println(httpEntity.hasBody());

		//restTemplate.postForObject(entity.getChannelEndpoint(),httpEntity ,String.class);
	//	restTemplate.postForEntity("http://localhost:8080/subscription-service/rest/subscription/receiver",jbody,String.class);
	
		
		CloseableHttpClient httpClient = HttpClientBuilder.create().build(); // Use
		// this
		// instead
		
		CloseableHttpResponse response = null;
		try {
			StringEntity params = null;
			params = new StringEntity(body.toJSONString());
			params.setContentType("application/json");
		
			request.setEntity(params);
			System.out.println("Before calling rest hook "+entity.getChannelEndpoint()+" with request body "+body.toJSONString());
			System.out.println("\n \n");
			response = httpClient.execute(request);
			System.out.println("Rest hook published successfully "+response.getStatusLine());
			System.out.println("After calling rest hook "+entity.getChannelEndpoint()+" with request body "+body.toJSONString());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		
	
	
	
	
	public static void main(String args[]) {
		RestPushHandler handler = new RestPushHandler();
		SubscriptionEntity entity = new SubscriptionEntity();
		entity.setCriteriaUrl("test");
	//	handler.publish(entity);
	}
	

}
