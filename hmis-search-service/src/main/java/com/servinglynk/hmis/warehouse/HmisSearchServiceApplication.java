package com.servinglynk.hmis.warehouse;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.servinglynk.hmis.warehouse.core.web.interceptor.SessionHelper;
import com.servinglynk.hmis.warehouse.core.web.interceptor.TrustedAppHelper;
import com.servinglynk.hmis.warehouse.rest.interceptor.ApiMehtodAuthCheckInterceptor;

@SpringBootApplication
@EnableJms
@EnableAsync
@EnableJpaRepositories(basePackages =  { "com.servinglynk.hmis.warehouse.repository"})
@EnableTransactionManagement
@EnableElasticsearchRepositories(basePackages ="com.servinglynk.hmis.warehouse.repository" )
@ComponentScan(basePackages =  { "com.servinglynk.hmis.warehouse"})
@EntityScan("com.servinglynk.hmis.warehouse.model")
@Import({com.servinglynk.hmis.warehouse.config.AMQConfiguration.class})
public class HmisSearchServiceApplication extends WebMvcConfigurerAdapter  {

	
	
	/*
	@PostConstruct
	public void initializeDatabasePropertySourceUsage() {
		System.out.println("initializing properties");
		MutablePropertySources propertySources = ((ConfigurableEnvironment) env).getPropertySources();
		Properties properties = propertyReader().getProperties("mq-service");
		PropertiesPropertySource dbPropertySource = new PropertiesPropertySource("dbPropertySource", properties);
		propertySources.addFirst(dbPropertySource);
	}
	 */
	
	@Autowired Environment env;
	
/*
	
	 @Bean
	  public ActiveMQConnectionFactory senderActiveMQConnectionFactory() {
	    ActiveMQConnectionFactory activeMQConnectionFactory =
	        new ActiveMQConnectionFactory();
	    activeMQConnectionFactory.setBrokerURL(env.getProperty("spring.activemq.broker-url"));
	    activeMQConnectionFactory.setUserName(env.getProperty("spring.activemq.user"));
	    activeMQConnectionFactory.setPassword(env.getProperty("spring.activemq.password"));
	    activeMQConnectionFactory.setTrustAllPackages(true);
	    return activeMQConnectionFactory;
	  }
	  
	  @Bean
	    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
	            DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	            factory.setConnectionFactory(senderActiveMQConnectionFactory());
	            factory.setConcurrency("1-1");
	            return factory;
	    }
	  @Bean
	  public JmsTemplate jmsTemplate() {
	    return new JmsTemplate(senderActiveMQConnectionFactory());
	  }	
		
	*/
	
	@Bean 
	public RestHighLevelClient restClient() {
			  ClientConfiguration clientConfiguration = ClientConfiguration.builder() 
				      .connectedTo(env.getProperty("es.service.url"))
				      .usingSsl()
				    //  .withConnectTimeout(millis)
				      .build();

				    return RestClients.create(clientConfiguration).rest(); 

		  
		  }
		  
		  
		  @Bean
			public TrustedAppHelper trustedAppHelper(){
				return new TrustedAppHelper();
			}
			
			
			@Bean
			public SessionHelper sessionHelper(){
				return new SessionHelper();
			}

			@Bean
			ApiMehtodAuthCheckInterceptor apiMehtodAuthCheckInterceptor() {
				return new ApiMehtodAuthCheckInterceptor();
			}
			 
				 @Override
			    public void addInterceptors(InterceptorRegistry registry) {
			        registry.addInterceptor(apiMehtodAuthCheckInterceptor());
				 }
}
