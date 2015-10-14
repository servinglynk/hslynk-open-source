package com.servinglynk.hmis.warehouse.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.servinglynk.hmis.warehouse.JSONObjectMapper;
import com.servinglynk.hmis.warehouse.service.DedupService;
import com.servinglynk.hmis.warehouse.service.DedupServiceImpl;


@Configuration 
@ComponentScan("com.servinglynk.hmis.warehouse") 
@EnableWebMvc   
@EnableTransactionManagement
@EnableScheduling
public class AppConfig extends WebMvcConfigurerAdapter {
	
	public void configureMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
		
		
    	MappingJackson2HttpMessageConverter jmc = new MappingJackson2HttpMessageConverter();
    	JSONObjectMapper mapper = new JSONObjectMapper();
    	mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
    	jmc.setObjectMapper(mapper);
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
    public DedupService dedupService() {
    	return new DedupServiceImpl();
    }

}
