package com.servinglynk.hmis.warehouse.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.servinglynk.hmis.warehouse.base.service.converter.ReportConfigConverter;
import com.servinglynk.hmis.warehouse.base.service.core.PropertyReaderServiceImpl;
import com.servinglynk.hmis.warehouse.client.MessageSender;
import com.servinglynk.hmis.warehouse.core.model.JSONObjectMapper;
import com.servinglynk.hmis.warehouse.service.AWSService;



@Configuration
@Import({ com.servinglynk.hmis.warehouse.base.dao.config.BaseDatabaseConfig.class,
		com.servinglynk.hmis.warehouse.base.service.config.BaseServiceConfig.class,
		com.servinglynk.hmis.warehouse.base.dao.config.HibernateConfig.class})
@EnableWebMvc
@EnableTransactionManagement
@EnableScheduling
public class RestConfig extends WebMvcConfigurerAdapter {

	

	public void configureMessageConverters(
			List<HttpMessageConverter<?>> messageConverters) {

		MappingJackson2HttpMessageConverter jmc = new MappingJackson2HttpMessageConverter();
		jmc.setObjectMapper(new JSONObjectMapper());
		messageConverters.add(jmc);
		messageConverters.add(createXmlHttpMessageConverter());
		super.configureMessageConverters(messageConverters);
	}

	private HttpMessageConverter<Object> createXmlHttpMessageConverter() {
		MarshallingHttpMessageConverter xmlConverter = new MarshallingHttpMessageConverter();

		XStreamMarshaller xstreamMarshaller = new XStreamMarshaller();
		xmlConverter.setMarshaller(xstreamMarshaller);
		xmlConverter.setUnmarshaller(xstreamMarshaller);

		return xmlConverter;
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter jmc = new MappingJackson2HttpMessageConverter();
		jmc.setObjectMapper(new JSONObjectMapper());
		messageConverters.add(jmc);
		messageConverters.add(createXmlHttpMessageConverter());

		restTemplate.setMessageConverters(messageConverters);
		return restTemplate;
	}

	@Bean
	PropertyReaderServiceImpl propertyReaderService(){
		return new PropertyReaderServiceImpl();
	}
	
	
	 @Bean(name="multipartResolver")
	 public CommonsMultipartResolver commonsMultipartResolver(){
	     CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
	     commonsMultipartResolver.setDefaultEncoding("utf-8");
	     commonsMultipartResolver.setMaxUploadSize(-1);
	     return commonsMultipartResolver;
	 }
	 
	@Bean
	public ReportConfigConverter reportConfigConverter() {
		return new ReportConfigConverter();
	}
	
	@Bean
	public AWSService aWSService() {
		return new AWSService();
	}
	
	 @PostConstruct
	 public void initializeDatabasePropertySourceUsage() {
		 propertyReaderService().loadProperties("UPLOAD_SERVICE");
	 }


}
