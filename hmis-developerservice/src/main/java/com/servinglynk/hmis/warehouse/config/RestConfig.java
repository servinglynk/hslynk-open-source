package com.servinglynk.hmis.warehouse.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
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
import com.servinglynk.hmis.warehouse.rest.DeveloperCompaniesController;
import com.servinglynk.hmis.warehouse.rest.DeveloperServicesController;
import com.servinglynk.hmis.warehouse.rest.PropertyController;
import com.servinglynk.hmis.warehouse.rest.TrustedAppsController;
import com.servinglynk.hmis.warehouse.service.core.PropertyReaderServiceImpl;


@Configuration 
@Import({ com.servinglynk.hmis.warehouse.config.DatabaseConfig.class,com.servinglynk.hmis.warehouse.service.config.AppConfig.class })
@EnableWebMvc   
@EnableTransactionManagement
@EnableScheduling
public class RestConfig extends WebMvcConfigurerAdapter {
	
	
public void configureMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
		
		
    	MappingJackson2HttpMessageConverter jmc = new MappingJackson2HttpMessageConverter();
    	jmc.setObjectMapper(new JSONObjectMapper());
        messageConverters.add(jmc);
        messageConverters.add(createXmlHttpMessageConverter());
        super.configureMessageConverters(messageConverters);
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
    public RestTemplate restTemplate(){
    	RestTemplate restTemplate=new RestTemplate();
    	
    	List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
    	MappingJackson2HttpMessageConverter jmc = new MappingJackson2HttpMessageConverter();
    	jmc.setObjectMapper(new JSONObjectMapper());
        messageConverters.add(jmc);
        messageConverters.add(createXmlHttpMessageConverter());
        
    	restTemplate.setMessageConverters(messageConverters);
    	return restTemplate;
    }
	
	
	
	@Bean
	public TrustedAppsController trustedAppsController(){
		return new TrustedAppsController();
		
	}
	

	@Bean
	public DeveloperCompaniesController developerCompaniesController(){
		return new DeveloperCompaniesController();
	}
	
	@Bean
	public DeveloperServicesController developerServicesController(){
		return new DeveloperServicesController();
	}
	
	@Autowired
	Environment env;
	
	@Bean
	PropertyReaderServiceImpl propertyReaderService(){
		return new PropertyReaderServiceImpl();
	}
	
	@Bean
	PropertyController propertyController(){
		return new PropertyController();
	}
	
	 @PostConstruct
	 public void initializeDatabasePropertySourceUsage() {
		 propertyReaderService().loadProperties("HMIS_DEVELOPER_SERVICE");
	 }
}
