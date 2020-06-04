package com.servinglynk.hmis.warehouse.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableAsync;

import com.servinglynk.hmis.warehouse.client.MessageSender;

@Configuration
@EnableJms
@EnableAsync
public class AMQConfiguration {

	@Autowired Environment env;
	
	 @Bean
	  public ActiveMQConnectionFactory senderActiveMQConnectionFactory() {
	    ActiveMQConnectionFactory activeMQConnectionFactory =
	        new ActiveMQConnectionFactory();
	    activeMQConnectionFactory.setBrokerURL(env.getProperty("spring.activemq.broker-url"));
	    activeMQConnectionFactory.setUserName(env.getProperty("spring.activemq.user"));
	    activeMQConnectionFactory.setPassword(env.getProperty("spring.activemq.password"));
	    activeMQConnectionFactory.setTrustAllPackages(true);
/*	    activeMQConnectionFactory.setBrokerURL("ssl://b-2de21e05-9a0f-4835-b552-2362ef819794-1.mq.us-west-2.amazonaws.com:61617");
	    activeMQConnectionFactory.setUserName("admin");
	    activeMQConnectionFactory.setPassword("u$S$63KTdsgO");*/
	    return activeMQConnectionFactory;
	  }

/*	  @Bean
	  public CachingConnectionFactory cachingConnectionFactory() {
	    return new CachingConnectionFactory(
	        senderActiveMQConnectionFactory());
	  }*/

	  
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
	  
	  @Bean
	  public MessageSender messageSender() {
		  return new MessageSender();
	  }
}