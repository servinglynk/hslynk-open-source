package com.servinglynk.hmis.warehouse.report.config;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.servinglynk.hmis.warehouse.core.model.JSONObjectMapper;


@Configuration 
@ComponentScan("com.servinglynk.hmis.warehouse.report") 
@Import({ com.servinglynk.hmis.warehouse.report.config.SpringConfig.class, com.servinglynk.hmis.warehouse.client.config.SpringConfig.class })
@EnableWebMvc   
@EnableTransactionManagement
@EnableScheduling
public class AppConfig extends WebMvcConfigurerAdapter {
	
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

}
