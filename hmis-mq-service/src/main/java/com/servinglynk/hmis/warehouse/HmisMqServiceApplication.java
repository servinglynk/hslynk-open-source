package com.servinglynk.hmis.warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import com.servinglynk.hmis.warehouse.service.PropertyReader;


@SpringBootApplication
//@Import(com.servinglynk.hmis.warehouse.config.AMQConfiguration.class)
@ComponentScan("com.servinglynk.hmis.warehouse")
//@PropertySource("classpath:application.properties")

@EnableJpaAuditing
@EnableJpaRepositories
@EnableTransactionManagement
@EnableSpringDataWebSupport
@EnableAsync
public class HmisMqServiceApplication {

/*	public static void main(String[] args) {
		SpringApplication.run(HmisMqServiceApplication.class, args);
	}*/


	@Autowired  Environment env;
	
	
	@Bean
	public PropertyReader propertyReader() {
		return new PropertyReader();
	}

	@PostConstruct
	public void initializeDatabasePropertySourceUsage() {
		System.out.println("initializing properties");
		MutablePropertySources propertySources = ((ConfigurableEnvironment) env).getPropertySources();
		Properties properties = propertyReader().getProperties("mq-service");
		PropertiesPropertySource dbPropertySource = new PropertiesPropertySource("dbPropertySource", properties);
		propertySources.addFirst(dbPropertySource);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

		converter.setObjectMapper(new com.servinglynk.hmis.warehouse.model.MQJsonObjectMapper());

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(createXmlHttpMessageConverter());
		messageConverters.add(converter);
		restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(messageConverters);

		return restTemplate;
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
