package com.servinglynk.hmis.warehouse.client.notificationservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.servinglynk.hmis.warehouse.client.base.CoreClientBase;
import com.servinglynk.hmis.warehouse.client.config.CoreClientConfig;
import com.servinglynk.hmis.warehouse.core.model.JSONHttpMessageConverter;
import com.servinglynk.hmis.warehouse.core.model.JSONObjectMapper;
import com.servinglynk.hmis.warehouse.core.model.Notification;



public class NotificationServiceClient extends CoreClientBase implements INotificationServiceClient {
	final static Logger logger = Logger.getLogger(NotificationServiceClient.class);

	/** Surya 04/13/2015 
	 * serviceURL is the URL where the notification service is deployed (different host) */
	
	@Autowired
	CoreClientConfig coreClientConfig;

	@SuppressWarnings("unused")
	public Notification createNotification(Notification notification) {
		
		HttpHeaders headers = getHttpHeaders();
	
		logger.debug(notification.toString());
		
		try {
			System.out.println(notification.toJSONString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JSONHttpMessageConverter jhmc = new JSONHttpMessageConverter();
		jhmc.setObjectMapper(new JSONObjectMapper());

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(createXmlHttpMessageConverter());
		messageConverters.add(jhmc);

		restTemplate.setMessageConverters(messageConverters);
		
      	HttpEntity<Notification> requestEntity = new HttpEntity<Notification>(notification, headers);
		Notification responseEntity = restTemplate.postForObject(coreClientConfig.getNotificationServiceUrl() + "/notifications", notification, Notification.class);
		
		

		return responseEntity;
	}
	
	private HttpMessageConverter<Object> createXmlHttpMessageConverter() {
        MarshallingHttpMessageConverter xmlConverter = 
          new MarshallingHttpMessageConverter();
 
        
        XStreamMarshaller xstreamMarshaller = new XStreamMarshaller();
        xmlConverter.setMarshaller(xstreamMarshaller);
        xmlConverter.setUnmarshaller(xstreamMarshaller);
 
        return xmlConverter;
    }

	
	public static void main(String args[]){
		Notification n = new Notification();
	
		NotificationServiceClient nsc = new NotificationServiceClient();
		
		nsc.createNotification(n);
		
	}

	
}
