package com.servinglynk.hmis.warehouse.client.notificationservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.servinglynk.hmis.warehouse.client.base.CoreClientBase;
import com.servinglynk.hmis.warehouse.client.config.CoreClientConfig;
import com.servinglynk.hmis.warehouse.core.model.Notification;
import com.servinglynk.hmis.warehouse.core.model.JSONObjectMapper;



public class NotificationServiceClient extends CoreClientBase implements INotificationServiceClient {
	final static Logger logger = Logger.getLogger(NotificationServiceClient.class);
	
	@Autowired
	Environment env;

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
		
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(new JSONObjectMapper());

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(createXmlHttpMessageConverter());
		messageConverters.add(converter);

		restTemplate.setMessageConverters(messageConverters);
		
      	HttpEntity<Notification> requestEntity = new HttpEntity<Notification>(notification, headers);
      	String url = buildURL(getURL("notification.service.url"));
		Notification responseEntity = restTemplate.postForObject(url, notification, Notification.class);
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
