package com.servinglynk.hmis.warehouse.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
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

import com.servinglynk.hmis.warehouse.base.service.core.PropertyReaderServiceImpl;
import com.servinglynk.hmis.warehouse.core.model.JSONObjectMapper;
import com.servinglynk.hmis.warehouse.rest.BulkUploadController;
import com.servinglynk.hmis.warehouse.rest.FileUploadController;
import com.servinglynk.hmis.warehouse.service.AWSService;
import com.servinglynk.hmis.warehouse.service.LocalFileUploadService;


@Configuration
@Import({ com.servinglynk.hmis.warehouse.base.dao.config.BaseDatabaseConfig.class,
		com.servinglynk.hmis.warehouse.base.service.config.BaseServiceConfig.class,
		com.servinglynk.hmis.warehouse.base.dao.config.HibernateConfig.class})
@EnableWebMvc
@EnableTransactionManagement
@EnableScheduling
@PropertySource("classpath:application.properties")
public class RestConfig extends WebMvcConfigurerAdapter {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
		ClassPathResource locations[] = {
				new ClassPathResource("/application.properties")};
		ppc.setLocations(locations);
		return ppc;
	}
	
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

	@Autowired
	Environment env;
	
	@Bean
	PropertyReaderServiceImpl propertyReaderService(){
		return new PropertyReaderServiceImpl();
	}
	
	 @Bean(name="multipartResolver")
	 public CommonsMultipartResolver commonsMultipartResolver(){
	     CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
	     commonsMultipartResolver.setDefaultEncoding("utf-8");
	     commonsMultipartResolver.setMaxUploadSize(605783057);
	     return commonsMultipartResolver;
	 }
	 
	@Bean
	public FileUploadController fileUploadController() {
		return new FileUploadController();
	}
	@Bean
	public BulkUploadController bulkUploadController() {
		return new BulkUploadController();
	}

	@Bean
	public AWSService aWSService() {
		return new AWSService();
	}
	@Bean
	public LocalFileUploadService localFileUploadService() {
		return new LocalFileUploadService();
	}
	
	@PostConstruct
	 public void initializeDatabasePropertySourceUsage() {
		 propertyReaderService().loadProperties("HMIS_AUTHORIZATION_SERVICE");
	 }

}
