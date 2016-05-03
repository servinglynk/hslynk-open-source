package com.servinglynk.hmis.warehouse.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.servinglynk.hmis.warehouse.client.authorizationservice.AuthorizationServiceClient;
import com.servinglynk.hmis.warehouse.client.authorizationservice.IAuthorizationClient;
import com.servinglynk.hmis.warehouse.client.notificationservice.INotificationServiceClient;
import com.servinglynk.hmis.warehouse.client.notificationservice.NotificationServiceClient;
import com.servinglynk.hmis.warehouse.client.reportservice.IReportServiceClient;
import com.servinglynk.hmis.warehouse.client.reportservice.ReportServiceClient;


@Configuration
@EnableScheduling
@ImportResource({"classpath:com/notification-service-client-config.xml"})
@ComponentScan(value={"com.servinglynk.hmis.warehouse.client.notificationservice","com.servinglynk.hmis.warehouse.client.reportservice"})
@PropertySource("classpath:com/core-client.properties")
public class SpringConfig {
	
	
	@Bean
    public static PropertyPlaceholderConfigurer properties(){
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ClassPathResource[] resources = new ClassPathResource[ ]
                { new ClassPathResource( "com/core-client.properties" ) };
        ppc.setLocations( resources );
        ppc.setIgnoreUnresolvablePlaceholders( true );
        return ppc;
    }

	@Autowired
	Environment env;
	
	@Bean
	public INotificationServiceClient notificationServiceClient(){
		return new NotificationServiceClient();
	}
	
	@Bean
	public IReportServiceClient reportServiceClient(){
		return new ReportServiceClient();
	}
	@Bean
	public IAuthorizationClient authorizationClient(){
		return new AuthorizationServiceClient();
	}
	
	
	 @Bean
	 public CoreClientConfig coreClientConfig(){
		 return new CoreClientConfig();
	 }
	
	
	
	
}
