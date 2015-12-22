package com.servinglynk.hmis.warehouse.config;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.servinglynk.hmis.warehouse.core.model.JSONObjectMapper;
import com.servinglynk.hmis.warehouse.rest.AccountsController;
import com.servinglynk.hmis.warehouse.rest.ApiMethodAuthorizationChecksController;
import com.servinglynk.hmis.warehouse.rest.ApiMethodController;
import com.servinglynk.hmis.warehouse.rest.ClientsController;
import com.servinglynk.hmis.warehouse.rest.PermissionSetsController;
import com.servinglynk.hmis.warehouse.rest.ProfilesController;
import com.servinglynk.hmis.warehouse.rest.ProjectGroupController;
import com.servinglynk.hmis.warehouse.rest.RolesController;
import com.servinglynk.hmis.warehouse.rest.SessionsController;
import com.servinglynk.hmis.warehouse.rest.SharingRulesController;
import com.servinglynk.hmis.warehouse.rest.VerificationsController;

@Configuration
@Import({ com.servinglynk.hmis.warehouse.config.DatabaseConfig.class,
		com.servinglynk.hmis.warehouse.service.config.AppConfig.class,
		com.servinglynk.hmis.warehouse.client.config.SpringConfig.class})
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
	public AccountsController accountsController(){
		return new AccountsController();
	}
	
	@Bean
	public ApiMethodAuthorizationChecksController apiMethodAuthorizationChecksController(){
		return new ApiMethodAuthorizationChecksController();
	}

	@Bean
	public SessionsController sessionsController(){
		return new SessionsController();
	}
	
	@Bean
	public VerificationsController verificationsController(){
		return new VerificationsController();
	}

	
	@Bean
	public ApiMethodController apiMethodController(){
		return new ApiMethodController();
	}

	
	@Bean
	public ClientsController clientsController(){
		return new ClientsController();
	}
	
	@Bean
	public RolesController rolesController(){
		return new RolesController();
	}
	
	@Bean
	public ProfilesController profilesController(){
		return new ProfilesController();
	}
	
	@Bean
	public PermissionSetsController permissionSetsController(){
		return new PermissionSetsController();
	}
	
	@Bean
	public SharingRulesController sharingRulesController(){
		return new SharingRulesController();
	}
	
	@Bean
	public ProjectGroupController projectGroupController(){
		return new ProjectGroupController();
	}
}
