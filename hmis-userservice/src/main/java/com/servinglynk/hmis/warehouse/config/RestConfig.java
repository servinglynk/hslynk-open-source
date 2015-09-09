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
import com.servinglynk.hmis.warehouse.rest.AccountsRestEndpoint;
import com.servinglynk.hmis.warehouse.rest.ApiMethodAuthorizationChecksRestEndpoint;
import com.servinglynk.hmis.warehouse.rest.ApiMethodRestEndpoint;
import com.servinglynk.hmis.warehouse.rest.ClientsRestEndpoint;
import com.servinglynk.hmis.warehouse.rest.PermissionSetRestEndpoint;
import com.servinglynk.hmis.warehouse.rest.ProfileRestEndpoint;
import com.servinglynk.hmis.warehouse.rest.RolesRestEndpoint;
import com.servinglynk.hmis.warehouse.rest.SessionsRestEndpoint;
import com.servinglynk.hmis.warehouse.rest.SharingRuleRestEndpoint;
import com.servinglynk.hmis.warehouse.rest.VerificationsRestEndpoint;

@Configuration
@Import({ com.servinglynk.hmis.warehouse.config.DatabaseConfig.class,
		com.servinglynk.hmis.warehouse.service.config.AppConfig.class})
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
	public AccountsRestEndpoint accountsRestEndpoint(){
		return new AccountsRestEndpoint();
	}
	
	@Bean
	public ApiMethodAuthorizationChecksRestEndpoint apiMethodAuthorizationChecksRestEndpoint(){
		return new ApiMethodAuthorizationChecksRestEndpoint();
	}

	@Bean
	public SessionsRestEndpoint sessionsRestEndpoint(){
		return new SessionsRestEndpoint();
	}
	
	@Bean
	public VerificationsRestEndpoint verificationsRestEndpoint(){
		return new VerificationsRestEndpoint();
	}

	
	@Bean
	public ApiMethodRestEndpoint apiMethodRestEndpoint(){
		return new ApiMethodRestEndpoint();
	}

	
	@Bean
	public ClientsRestEndpoint clientsRestEndpoint(){
		return new ClientsRestEndpoint();
	}
	
	@Bean
	public RolesRestEndpoint rolesRestEndpoint(){
		return new RolesRestEndpoint();
	}
	
	@Bean
	public ProfileRestEndpoint profileRestEndpoint(){
		return new ProfileRestEndpoint();
	}
	
	@Bean
	public PermissionSetRestEndpoint permissionSetRestEndpoint(){
		return new PermissionSetRestEndpoint();
	}
	
	@Bean
	public SharingRuleRestEndpoint sharingRuleRestEndpoint(){
		return new SharingRuleRestEndpoint();
	}
	
}
