package com.servinglynk.hmis.warehouse.notification.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.velocity.app.VelocityEngine;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;

import com.servinglynk.hmis.warehouse.notification.business.service.CarrierService;
import com.servinglynk.hmis.warehouse.notification.business.service.ITemplateService;
import com.servinglynk.hmis.warehouse.notification.business.service.NotificationService;
import com.servinglynk.hmis.warehouse.notification.business.service.NotificationWorker;
import com.servinglynk.hmis.warehouse.notification.business.service.TemplateService;
import com.servinglynk.hmis.warehouse.notification.business.service.WorkerService;
import com.servinglynk.hmis.warehouse.notification.business.service.core.ParentService;
import com.servinglynk.hmis.warehouse.notification.business.service.core.ParentServiceFactory;
import com.servinglynk.hmis.warehouse.notification.business.util.NotificationParams;
import com.servinglynk.hmis.warehouse.notification.business.util.ReportCreationNotificationUtil;
import com.servinglynk.hmis.warehouse.notification.carrier.CarrierFactory;
import com.servinglynk.hmis.warehouse.notification.carrier.EMailCarrier;
import com.servinglynk.hmis.warehouse.notification.carrier.SMSCarrier;
import com.servinglynk.hmis.warehouse.notification.framework.NotificationEngine;
import com.servinglynk.hmis.warehouse.notification.framework.NotificationEngineContext;
import com.servinglynk.hmis.warehouse.notification.persistence.dao.NotificationHeaderDao;
import com.servinglynk.hmis.warehouse.notification.persistence.dao.NotificationLineDao;
import com.servinglynk.hmis.warehouse.notification.persistence.dao.TemplateLineDao;
import com.servinglynk.hmis.warehouse.notification.persistence.dao.core.ParentDaoFactory;
import com.servinglynk.hmis.warehouse.notification.persistence.dao.core.QueryExecutor;
import com.servinglynk.hmis.warehouse.notification.scheduler.dao.WorkerHeaderDao;
import com.servinglynk.hmis.warehouse.notification.scheduler.dao.WorkerLineDao;


@Configuration
@ComponentScan(value={"com.servinglynk.hmis.warehouse.notification.business.service","com.servinglynk.hmis.warehouse.notification.framework","com.servinglynk.hmis.warehouse.notification.rest.endpoint"})
@EnableScheduling
@EnableTransactionManagement
@ImportResource("classpath:com/servinglynk/hmis/warehouse/notification/common/property-config.xml")
@PropertySource("classpath:com/servinglynk/hmis/warehouse/notification/common/notification.properties")
public class SpringConfig  {
	
	@Autowired
	Environment env;

	@Bean
    public static PropertyPlaceholderConfigurer properties(){
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ClassPathResource[] resources = new ClassPathResource[ ]
                { new ClassPathResource( "com/servinglynk/hmis/warehouse/notification/common/notification.properties" ) };
        ppc.setLocations( resources );
        ppc.setIgnoreUnresolvablePlaceholders( true );
        return ppc;
    }

	
	@Bean
	public ParentService parentService(){
		return new ParentService();
	}

	
	 @Bean
	 public NotificationConfig notificationConfig(){
		 return new NotificationConfig();
	 }
	
	
	@Bean
	public CarrierFactory carrierFactory(){
		CarrierFactory  carrierFactory = new CarrierFactory();
		carrierFactory.setEmailCarrier(emailCarrier());
		carrierFactory.setSmsCarrier(smsCarrier());
		return carrierFactory;
	}
	
		@Bean
	    public CarrierService carrierService(){
			CarrierService carrierService = new CarrierService(); 
			carrierService.setCarrierFactory(carrierFactory());
	        return carrierService;
	    }
	 
	 @Bean
	 @Autowired
	    public ITemplateService templateService(VelocityEngine velocityEngine){
		 TemplateService templateService = new TemplateService();
		 templateService.setVelocityEngine(velocityEngine);
	        return new TemplateService();
	    }
	 
	 
	 @Bean
	    public WorkerService workerService(){
		 return new WorkerService();
	 }
	 
	 	@Bean
	    public EMailCarrier emailCarrier(){
		 EMailCarrier emailCarrier = new EMailCarrier();
		 emailCarrier.setHost(notificationConfig().getMailHost());
		 emailCarrier.setUsername(notificationConfig().getMailUsername());
		 emailCarrier.setPassword(notificationConfig().getMailPassword());
		 emailCarrier.setPort(Integer.parseInt(notificationConfig().getMailPort()));
		 emailCarrier.setJavaMailProperties(getJavaMailProperties());
		 return emailCarrier;
	 }
	 
	 @Bean
	    public SMSCarrier smsCarrier(){
		 return new SMSCarrier();
	 }
	 
	
	 @Bean
	 public ParentServiceFactory serviceFactory(){
		 return new ParentServiceFactory();
	 }
	 

	  
	 @Bean
	 public WorkerHeaderDao workerHeaderDao(){
		 return new WorkerHeaderDao();
	 }
	 
	 @Bean
	 public WorkerLineDao workerLineDao(){
		 return new WorkerLineDao();
	 }
	 

	 
	 @Bean
	 public NotificationLineDao notificationLineDao(){
		 return new NotificationLineDao();
	 }
	 
	 @Bean
	 public NotificationHeaderDao notificationHeaderDao(){
		 return new NotificationHeaderDao();
	 }
	 
	 @Bean
	 public TemplateLineDao templateLineDao(){
		 return new TemplateLineDao();
	 }
	 
	 @Bean
	 public ParentDaoFactory daoFactory(){
		 return new ParentDaoFactory();
	 }

	 @Bean
	 public QueryExecutor queryExecutor(){
		 return new QueryExecutor();
	 }
	 
	 @Bean
	 @Autowired
	 public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
		 return new HibernateTransactionManager(sessionFactory);
	 }


	 
	 @Bean
	 public JavaMailSenderImpl mailSender(){
		 JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		 mailSender.setHost(notificationConfig().getMailHost());
		 mailSender.setUsername(notificationConfig().getMailUsername());
		 mailSender.setPassword(notificationConfig().getMailPassword());
		 mailSender.setPort(Integer.parseInt(notificationConfig().getMailPort()));
		 mailSender.setJavaMailProperties(getJavaMailProperties());
		 return mailSender;
	 }
	 
	 
	 public Properties getJavaMailProperties(){
		 Properties properties=new Properties();
		 
		 properties.put("mail.smtp.auth","true");
		 properties.put("mail.smtp.starttls.enable","true");
		 properties.put("mail.transport.protocol","smtp");
		 properties.put("mail.debug","true");
		 properties.put("mail.smtp.EnableSSL.enable","true");

		 	
		 return properties;
	 }
	 
	 @Bean
	 public SimpleMailMessage templateMessage(){
		 SimpleMailMessage templateMessage = new SimpleMailMessage();
		 templateMessage.setFrom("surya.yadavalli@broadcom.com");
		 return templateMessage;
	 }
	 
	 
	 @Bean
	 public VelocityEngineFactoryBean velocityEngine(){
		 VelocityEngineFactoryBean velocityEngine= new VelocityEngineFactoryBean();
		 velocityEngine.setResourceLoaderPath("classpath:/com/servinglynk/hmis/warehouse/notification/velocity");
		 return velocityEngine;
	 }
	 
	 
    @Bean
    
    public NotificationWorker notificationWorker(){
    	NotificationWorker notificationWorker = new NotificationWorker();
    	return notificationWorker;
    }
    
    @Bean
    @Autowired
    public NotificationEngine notificationEngine(VelocityEngine velocityEngine){
    	NotificationEngine notificationEngine=new NotificationEngine();
    	notificationEngine.setNotificationEngineContext(notificationEngineContext(velocityEngine));
    	return new NotificationEngine(); 
    }
    
    @Bean
    @Autowired
    public NotificationEngineContext notificationEngineContext(VelocityEngine velocityEngine){
    	NotificationEngineContext notificationEngineContext = new NotificationEngineContext();
    	notificationEngineContext.setCarrierService(carrierService());
    	notificationEngineContext.setTemplateService(templateService(velocityEngine));
    	return notificationEngineContext;
    }
    
    @Bean
    public NotificationParams reportCreationNotificationParams(){
    	NotificationParams  notificationParams = new NotificationParams();
    	notificationParams.setSenderEmailAddress(notificationConfig().getMailSender());
    	notificationParams.setSenderFriendlyName("BC");
    	notificationParams.setTemplateId(notificationConfig().getMailTemplateId());
    	notificationParams.setUrl(notificationConfig().getMailTemplateUrl());
    	return notificationParams;
    }
    
    @Bean
    public ReportCreationNotificationUtil reportCreationNotificationUtil(){
    	ReportCreationNotificationUtil reportCreationNotificationUtil = new ReportCreationNotificationUtil();
    	return reportCreationNotificationUtil;
    }
    
    @Bean
	public HashMap notificationParams(){
		Map map=new HashMap();
		map.put("REPORT_NOTIFICATION",reportCreationNotificationParams());
		
		return new HashMap(map);
	}
    /*
	@Bean(destroyMethod="")
	public DataSource relationalDataSource()  {
	
		JndiObjectFactoryBean jndi=new JndiObjectFactoryBean();
		jndi.setResourceRef(true);
		jndi.setJndiName(env.getProperty("app.jndi.name"));
		jndi.setProxyInterface(DataSource.class);
		jndi.setLookupOnStartup(true);
		try {
			jndi.afterPropertiesSet();
		}catch (NamingException e) {
			throw new RuntimeException(e);
		}
		return (DataSource)jndi.getObject();
	}
*/

    @Bean
    public BasicDataSource relationalDataSource(){
    	BasicDataSource datasource = new BasicDataSource();
    	datasource.setDriverClassName(notificationConfig().getDbDriverClassName());
    	datasource.setUrl(notificationConfig().getDbUrl());
    	datasource.setUsername(notificationConfig().getDbUserName());
    	datasource.setPassword(notificationConfig().getDbPassword());
    	return datasource;
    }

    @Bean
    public LocalSessionFactoryBean notificationSessionFactory(){
    	LocalSessionFactoryBean notificationSessionFactory = new LocalSessionFactoryBean();
    	notificationSessionFactory.setPackagesToScan("com.servinglynk.hmis.warehouse.notification.persistence.entity");
    	notificationSessionFactory.setDataSource(relationalDataSource());
    	notificationSessionFactory.setHibernateProperties(getHibernateProperties());
    	return notificationSessionFactory;
    }
    

    
    public Properties getHibernateProperties(){
    	Properties properties=new Properties();
    	properties.put("hibernate.show_sql", "false");
    	properties.put("hibernate.format_sql", "false");
    	properties.put("hibernate.dialect", notificationConfig().getHibernateDialect());
    	properties.put("hibernate.cache.provider_class", "org.hibernate.cache.EhCacheProvider");
    	properties.put("hibernate.cache.use_query_cache", "false");
    	properties.put("hibernate.cache.use_second_level_cache", "true");
    	properties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
    	return properties;
    }
    
    @Bean
    public NotificationService notificationService(){
    	return new NotificationService();
    }
}
