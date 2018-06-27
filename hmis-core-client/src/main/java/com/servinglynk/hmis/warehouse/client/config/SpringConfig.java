package com.servinglynk.hmis.warehouse.client.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.servinglynk.hmis.warehouse.client.authorizationservice.AuthorizationServiceClient;
import com.servinglynk.hmis.warehouse.client.authorizationservice.IAuthorizationClient;
import com.servinglynk.hmis.warehouse.client.baseclients.BaseClientServiceImpl;
import com.servinglynk.hmis.warehouse.client.notificationservice.INotificationServiceClient;
import com.servinglynk.hmis.warehouse.client.notificationservice.NotificationServiceClient;
import com.servinglynk.hmis.warehouse.client.projects.ProjectSearchClient;
import com.servinglynk.hmis.warehouse.client.projects.ProjectSearchClientImpl;
import com.servinglynk.hmis.warehouse.client.reportservice.IReportServiceClient;
import com.servinglynk.hmis.warehouse.client.reportservice.ReportServiceClient;
import com.servinglynk.hmis.warehouse.client.search.ISearchServiceClient;
import com.servinglynk.hmis.warehouse.client.search.SearchServiceClient;

@Configuration
@EnableScheduling
@ImportResource({ "classpath:com/notification-service-client-config.xml" })
@ComponentScan(value = { "com.servinglynk.hmis.warehouse.client.notificationservice",
		"com.servinglynk.hmis.warehouse.client.reportservice" })
//@PropertySource("classpath:com/core-client.properties")
public class SpringConfig {

/*	@Bean
	public static PropertyPlaceholderConfigurer properties() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ClassPathResource[] resources = new ClassPathResource[] { new ClassPathResource("com/core-client.properties") };
		ppc.setLocations(resources);
		ppc.setIgnoreUnresolvablePlaceholders(true);
		return ppc;
	}*/

	@Autowired
	Environment env;

	@Bean
	public INotificationServiceClient notificationServiceClient() {
		return new NotificationServiceClient();
	}

	@Bean
	public IReportServiceClient reportServiceClient() {
		return new ReportServiceClient();
	}

	@Bean
	public IAuthorizationClient authorizationClient() {
		return new AuthorizationServiceClient();
	}

	@Bean
	public CoreClientConfig coreClientConfig() {
		return new CoreClientConfig();
	}

	@Bean
	public BaseClientServiceImpl baseClientService() {
		return new BaseClientServiceImpl();
	}

	@Bean
	public ISearchServiceClient searchServiceClient() {
		return new SearchServiceClient();
	}
	
	@Bean
	public ProjectSearchClient projectSearchClient() {
		return new ProjectSearchClientImpl();
	}
}