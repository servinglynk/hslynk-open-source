package com.servinglynk.hmis.warehouse.sync.config;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.servinglynk.hmis.warehouse.config.DatabaseConfig;
import com.servinglynk.hmis.warehouse.dao.BulkUploaderWorkerDaoImpl;
import com.servinglynk.hmis.warehouse.dao.HmisUserDao;
import com.servinglynk.hmis.warehouse.dao.HmisUserDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ParentDaoFactory;
import com.servinglynk.hmis.warehouse.dao.ParentDaoFactoryImpl;
import com.servinglynk.hmis.warehouse.sync.business.service.core.SyncParentService;
import com.servinglynk.hmis.warehouse.sync.business.service.core.SyncParentServiceFactory;
import com.servinglynk.hmis.warehouse.sync.service.SyncService;
import com.servinglynk.hmis.warehouse.sync.service.SyncWorker;

@Configuration
@EnableScheduling
@EnableTransactionManagement
@Import({DatabaseConfig.class})
@ImportResource("classpath:com/servinglynk/hmis/warehouse/sync/property-config.xml")
@ComponentScan(value={"com.servinglynk.hmis.warehouse.sync.service,com.servinglynk.hmis.warehouse.sync.dao,com.servinglynk.hmis.warehouse.dao"})
@PropertySource("classpath:com/servinglynk/hmis/warehouse/sync/sync.properties")

public class SpringConfig {

	@Autowired
	Environment env;
	
	@Bean
    public static PropertyPlaceholderConfigurer properties(){
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ClassPathResource[] resources = new ClassPathResource[ ]
                { new ClassPathResource( "com/servinglynk/hmis/warehouse/sync/sync.properties" ) };
        ppc.setLocations( resources );
        ppc.setIgnoreUnresolvablePlaceholders( true );
        return ppc;
    }
	
	@Bean(destroyMethod="close")
	public BasicDataSource relationalDataSource(){
		BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName(syncConfig().getDbDriverClassName());
    	dataSource.setUrl(syncConfig().getDbUrl());
    	dataSource.setUsername(syncConfig().getDbUserName());
    	dataSource.setPassword(syncConfig().getDbPassword());
		return dataSource;
	}
	

	
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactory= new LocalSessionFactoryBean();
		
		sessionFactory.setDataSource(relationalDataSource());
		sessionFactory.setPackagesToScan("com.servinglynk.hmis.warehouse");
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		
		return sessionFactory;
	}
	
	
	private Properties getHibernateProperties(){
		Properties properties = new Properties();
		 properties.put("hibernate.show_sql", "true");
		 properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		 properties.put("hibernate.format_sql", "false");
		 properties.put("hibernate.cache.use_query_cache", "false");
		 properties.put("hibernate.cache.use_second_level_cache", "true");

		 return properties;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
	

	
	@Bean
	public SyncService syncService(){
		return new SyncService();
	}
	
	@Bean
	public SyncParentService parentService(){
		SyncParentService service =new SyncParentService();
		service.setServiceFactory(parentServiceFactory());
		service.setDaoFactory(parentDaoFactory());
		return new SyncParentService();
	}
	
	@Bean
	public SyncParentServiceFactory parentServiceFactory(){
		SyncParentServiceFactory serviceFactory=new SyncParentServiceFactory();
		return serviceFactory;
	}
	
	@Bean
	public ParentDaoFactory parentDaoFactory(){
		ParentDaoFactory parentDaoFactory= new ParentDaoFactoryImpl();
		return parentDaoFactory;
	}
	
	@Bean
	public SyncWorker syncWorker(){
		return new SyncWorker();
	}
	
	@Bean
	public SyncConfig syncConfig(){
		return new SyncConfig();
	}
	
	@Bean
	public HmisUserDaoImpl getHmisUserDao(){
		return new HmisUserDaoImpl();
	}
}
