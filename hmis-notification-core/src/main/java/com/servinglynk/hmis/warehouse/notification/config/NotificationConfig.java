package com.servinglynk.hmis.warehouse.notification.config;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.velocity.app.VelocityEngine;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
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
@PropertySource("classpath:com/servinglynk/hmis/warehouse/notification/notification.properties")
public class NotificationConfig  {
	
	@Autowired
	Environment env;

    private static final String PROPERTY_NAME_DATABASE_DRIVER   = "db.driver";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
    private static final String PROPERTY_NAME_DATABASE_URL      = "db.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
	
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    @SuppressWarnings("unused")
	private static final String PROPERTY_NAME_APP_JNDI_NAME ="app.jndi.name";

    
/*	@Bean(destroyMethod="")
	public DataSource relationalDataSource()  {
	
		JndiObjectFactoryBean jndi=new JndiObjectFactoryBean();
		jndi.setResourceRef(true);
		jndi.setJndiName(env.getProperty(PROPERTY_NAME_APP_JNDI_NAME));
		jndi.setProxyInterface(DataSource.class);
		jndi.setLookupOnStartup(true);
		try {
			jndi.afterPropertiesSet();
		}catch (NamingException e) {
			throw new RuntimeException(e);
		}
		return (DataSource)jndi.getObject();
	}*/

    @Bean
    public BasicDataSource relationalDataSource(){
    	BasicDataSource datasource = new BasicDataSource();
    	datasource.setDriverClassName(env.getProperty(PROPERTY_NAME_DATABASE_DRIVER));
    	datasource.setUrl(env.getProperty(PROPERTY_NAME_DATABASE_URL));
    	datasource.setUsername(env.getProperty(PROPERTY_NAME_DATABASE_USERNAME));
    	datasource.setPassword(env.getProperty(PROPERTY_NAME_DATABASE_PASSWORD));
    	return datasource;
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
		 emailCarrier.setHost(env.getProperty("notification.mail.host"));
		 emailCarrier.setUsername(env.getProperty("notification.mail.username"));
		 emailCarrier.setPassword(env.getProperty("notification.mail.password"));
		 emailCarrier.setPort(Integer.parseInt(env.getProperty("notification.mail.port")));
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
		 mailSender.setHost(env.getProperty("notification.mail.host"));
		 mailSender.setUsername(env.getProperty("notification.mail.username"));
		 mailSender.setPassword(env.getProperty("notification.mail.password"));
		 mailSender.setPort(Integer.parseInt(env.getProperty("notification.mail.port")));
		 mailSender.setJavaMailProperties(getJavaMailProperties());
		 return mailSender;
	 }
	 
	 
	 public Properties getJavaMailProperties(){
		 Properties properties=new Properties();
		 
		 properties.put("mail.smtp.auth","true");
		 properties.put("mail.smtp.starttls.enable","true");
		 properties.put("mail.transport.protocol","smtp");
		 properties.put("mail.debug","true");
		 
		 properties.put("mail.smtp.ssl.enable","true");
		 	
		 return properties;
	 }
	 
	 
	 @Bean
	 public VelocityEngineFactoryBean velocityEngine(){
		 VelocityEngineFactoryBean velocityEngine= new VelocityEngineFactoryBean();
		 velocityEngine.setPreferFileSystemAccess(true);
		 velocityEngine.setResourceLoaderPath( env.getProperty("notification.template.location"));
		
		 Properties properties = new Properties();
		 properties.put("resource.loader","file");            
		 properties.put("file.resource.loader.class","org.apache.velocity.runtime.resource.loader.FileResourceLoader");
		 properties.put("file.resource.loader.path", env.getProperty("notification.template.location"));
		 velocityEngine.setVelocityProperties(properties);
		 
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
    public LocalSessionFactoryBean notificationSessionFactory(){
    	LocalSessionFactoryBean notificationSessionFactory = new LocalSessionFactoryBean();
    	notificationSessionFactory.setPackagesToScan("com.servinglynk.hmis.warehouse.notification.persistence.entity");
    	notificationSessionFactory.setDataSource(relationalDataSource());
    	notificationSessionFactory.setHibernateProperties(getHibernateProperties());
    	return notificationSessionFactory;
    }
    

    
    public Properties getHibernateProperties(){
    	Properties properties=new Properties();
    	properties.put("hibernate.show_sql",env.getProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
    	properties.put("hibernate.format_sql", "false");
    	properties.put("hibernate.dialect", env.getProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
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
    
    
    @Bean
    public PropertyReader propertyReader(){
    	return new PropertyReader();
    }
    
	 @PostConstruct
	 public void initializeDatabasePropertySourceUsage() {
		  MutablePropertySources propertySources = ((ConfigurableEnvironment) env).getPropertySources();
		  Properties properties = propertyReader().getProperties();
		  PropertiesPropertySource dbPropertySource = new PropertiesPropertySource("dbPropertySource", properties);
		  propertySources.addFirst(dbPropertySource);
	 }
}
