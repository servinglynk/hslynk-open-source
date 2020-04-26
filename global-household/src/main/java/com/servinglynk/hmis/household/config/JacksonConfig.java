package com.servinglynk.hmis.household.config;


import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.servinglynk.hmis.household.interceptor.ApiAuthCheckInterceptor;
import com.servinglynk.hmis.warehouse.core.web.interceptor.SessionHelper;
import com.servinglynk.hmis.warehouse.core.web.interceptor.TrustedAppHelper;
import com.servinglynk.hmis.warehouse.service.impl.PropertyReader;


@Configuration
public class JacksonConfig extends WebMvcConfigurerAdapter {
	
	@Autowired Environment env;

	@Bean
	public Jackson2ObjectMapperBuilder jacksonBuilder() {
	    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
	    builder.indentOutput(true).dateFormat(new SimpleDateFormat("MM/dd/yyyy"));
	    return builder;
	}
	
	@Bean
	public MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.constructType(DefaultPrettyPrinter.class);
		objectMapper.writerWithDefaultPrettyPrinter();
		jsonConverter.setObjectMapper(objectMapper);
		return jsonConverter;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(customJackson2HttpMessageConverter());
		super.configureMessageConverters(converters);
	}

	
	@Bean
	public ApiAuthCheckInterceptor authCheckInterceptor(){
		return new ApiAuthCheckInterceptor();
	}
	
	@Bean
	public SessionHelper sessionHelper(){
		return new SessionHelper();
	}
	
	@Bean
	public TrustedAppHelper trustedAppHelper(){
		return new TrustedAppHelper();
	}
	
	 @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(authCheckInterceptor());
	 }
	 
	 @Bean
	 public PropertyReader propertyReader() {
		 return new PropertyReader();
	 }
	 
	 @PostConstruct
		public void initializeDatabasePropertySourceUsage() {
			System.out.println("initializing properties");
			MutablePropertySources propertySources = ((ConfigurableEnvironment) env).getPropertySources();
			Properties properties = propertyReader().getProperties("global-household-api");
			PropertiesPropertySource dbPropertySource = new PropertiesPropertySource("dbPropertySource", properties);
			propertySources.addFirst(dbPropertySource);
		}
}

