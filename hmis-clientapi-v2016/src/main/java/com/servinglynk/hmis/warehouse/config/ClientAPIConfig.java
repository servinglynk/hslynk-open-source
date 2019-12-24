package com.servinglynk.hmis.warehouse.config;

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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.servinglynk.hmis.warehouse.base.service.core.PropertyReaderServiceImpl;
import com.servinglynk.hmis.warehouse.core.model.JSONObjectMapper;
import com.servinglynk.hmis.warehouse.rest.BulkUploadErrorActivityController;
import com.servinglynk.hmis.warehouse.rest.ClientsController;
import com.servinglynk.hmis.warehouse.rest.ClientsControllerV2;
import com.servinglynk.hmis.warehouse.rest.HMISTypeController;
import com.servinglynk.hmis.warehouse.rest.HealthController;
import com.servinglynk.hmis.warehouse.rest.HistoryController;
import com.servinglynk.hmis.warehouse.rest.HmisHouseHoldController;
import com.servinglynk.hmis.warehouse.rest.OrganizationsController;
import com.servinglynk.hmis.warehouse.rest.ProjectsController;
import com.servinglynk.hmis.warehouse.rest.ProjectsControllerV2;
import com.servinglynk.hmis.warehouse.rest.QuestionsController;

@Configuration
@Import({ com.servinglynk.hmis.warehouse.base.dao.config.BaseDatabaseConfig.class,
		com.servinglynk.hmis.warehouse.config.DatabaseConfig.class,
		com.servinglynk.hmis.warehouse.service.config.ServiceConfig.class,
		com.servinglynk.hmis.warehouse.base.service.config.BaseServiceConfig.class,
		com.servinglynk.hmis.warehouse.client.config.SpringConfig.class,
		com.servinglynk.hmis.warehouse.config.WebDBPoolConfig.class})
@EnableWebMvc
@EnableTransactionManagement
@EnableScheduling
public class ClientAPIConfig extends WebMvcConfigurerAdapter {

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
	public ClientsController clientsController(){
		return new ClientsController();
	}
	
	@Autowired
	Environment env;
	
	@Bean
	public PropertyReaderServiceImpl propertyReaderService(){
		return new PropertyReaderServiceImpl();
	}
	
	@Bean
	public OrganizationsController organizationsController(){
		return new OrganizationsController();
	}
	
//	@Bean
//	PropertyController propertyController(){
//		return new PropertyController();
//	}
//	
	 @PostConstruct
	 public void initializeDatabasePropertySourceUsage() {
		 propertyReaderService().loadProperties("HMIS_CLIENTAPI");
	 }
	 
	 @Bean
	 public ProjectsController projectsController(){
		 return new ProjectsController();
	 }

	 
	 @Bean
	 public BulkUploadErrorActivityController bulkUploadErrorActivityController() {
		 return new BulkUploadErrorActivityController();
	 }
	 
	 @Bean
	 public HealthController healthController(){
		 return new HealthController();
	 }

	 @Bean
	 public HMISTypeController hmisTypeController() {
		 return new HMISTypeController();
	 }
	 
	 @Bean
	 public QuestionsController questionsController() {
		 return new QuestionsController();
	 }
	 
	 @Bean
	 public ClientsControllerV2 clientsControllerV2() {
		 return new ClientsControllerV2();
	 }
	 @Bean
	 public ProjectsControllerV2 projectsControllerV2() {
		 return new ProjectsControllerV2();
	 }
	 
	 @Bean
	 public HistoryController historyController() {
		 return new HistoryController();
	 }
	 
	 @Bean
	 public HmisHouseHoldController hmisHouseHoldController() {
		 return new HmisHouseHoldController();
	 }
}
