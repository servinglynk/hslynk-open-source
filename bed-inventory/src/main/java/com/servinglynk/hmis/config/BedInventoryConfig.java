package com.servinglynk.hmis.config;


import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.servinglynk.hmis.interceptor.ApiAuthCheckInterceptor;
import com.servinglynk.hmis.service.PropertyReader;
import com.servinglynk.hmis.warehouse.core.web.interceptor.HslynkTraceFilter;
import com.servinglynk.hmis.warehouse.core.web.interceptor.SessionHelper;
import com.servinglynk.hmis.warehouse.core.web.interceptor.TrustedAppHelper;


@Configuration
@EnableWebMvc
@EnableJpaRepositories(basePackages = "com.servinglynk.hmis.repository")
@EntityScan(basePackages = "com.servinglynk.hmis.entity")
@ComponentScan(basePackages = "com.servinglynk.hmis")
public class BedInventoryConfig  extends WebMvcConfigurerAdapter {
	
	@Autowired Environment env;
/*
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

	*/

	@Bean
	public  TrustedAppHelper trustedAppHelper() {
		return new TrustedAppHelper();
	}
	
	@Bean
	public SessionHelper sessionHelper() {
		return new SessionHelper();
	}
	
	@Bean
	public ApiAuthCheckInterceptor authCheckInterceptor(){
		return new ApiAuthCheckInterceptor();
	}
	 @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(authCheckInterceptor());
	 }
	 
	 @Bean
	 PropertyReader propertyReader() {
		 return new PropertyReader();
	 }
	 
	 @PostConstruct
		public void initializeDatabasePropertySourceUsage() {
			System.out.println("initializing properties");
			MutablePropertySources propertySources = ((ConfigurableEnvironment) env).getPropertySources();
			Properties properties = propertyReader().getProperties("bed-management-api");
			PropertiesPropertySource dbPropertySource = new PropertiesPropertySource("dbPropertySource", properties);
			propertySources.addFirst(dbPropertySource);
		}
	 
		
		  @Bean
		  
		  @Order(Ordered.HIGHEST_PRECEDENCE) public HslynkTraceFilter traceLogger() {
		  return new HslynkTraceFilter(); }
		 
	 /*
	
	 @Bean
	 public FilterRegistrationBean loggingFilter(){
	     FilterRegistrationBean registrationBean 
	       = new FilterRegistrationBean();
	         
	     registrationBean.setFilter(new HslynkTraceLogger());
	     registrationBean.addUrlPatterns("/*");
	         
	     return registrationBean;    
	 }
	 */

}

