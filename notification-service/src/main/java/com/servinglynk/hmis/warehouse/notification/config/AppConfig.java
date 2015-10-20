package com.servinglynk.hmis.warehouse.notification.config;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.servinglynk.hmis.warehouse.core.model.JSONObjectMapper;
import com.servinglynk.hmis.warehouse.notification.config.SpringConfig;
import com.servinglynk.hmis.warehouse.notification.endpoint.NotificationWebservice;


@Configuration 
@ComponentScan("com.servinglynk.hmis.warehouse.notification") 
@Import({SpringConfig.class})
@EnableWebMvc   
@EnableTransactionManagement
@EnableScheduling
public class AppConfig extends WebMvcConfigurerAdapter{  
	

	    @Override
	    public void configureMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
	    	MappingJackson2HttpMessageConverter jmc = new MappingJackson2HttpMessageConverter();
	    	jmc.setObjectMapper(new JSONObjectMapper());
	    	
	    	   messageConverters.add(createXmlHttpMessageConverter());
	    	 
	        messageConverters.add(jmc);
	     
	 
	        super.configureMessageConverters(messageConverters);
	    }
	    
	    @Bean
	    public NotificationWebservice notificationWebservice(){
	    	return new NotificationWebservice();
	    }
	    
	    private HttpMessageConverter<Object> createXmlHttpMessageConverter() {
	        MarshallingHttpMessageConverter xmlConverter = 
	          new MarshallingHttpMessageConverter();
	 
	        
	        XStreamMarshaller xstreamMarshaller = new XStreamMarshaller();
	        xmlConverter.setMarshaller(xstreamMarshaller);
	        xmlConverter.setUnmarshaller(xstreamMarshaller);
	 
	        return xmlConverter;
	    }
	    
	    
	    @Bean
	 //   @Autowired
	    public RestTemplate restTemplate(){
	    	RestTemplate restTemplate=new RestTemplate();
	  //  	restTemplate.setMessageConverters(messageConverters);
	    	return restTemplate;
	    }

	}
