package com.servinglynk.hmis.warehouse.config;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class StandAloneDBPoolConfig {



	 	private static final String PROPERTY_NAME_DATABASE_DRIVER   = "db.driver";
	    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
	    private static final String PROPERTY_NAME_DATABASE_URL      = "db.url";
	    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
		
	    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	    private static final String PROPERTY_NAME_INITIAL_SIZE = "db.initsize";
	    private static final String PROPERTY_NAME_MAX_ACTIVE = "db.maxactive";	   
	    private static final String PROPERTY_NAME_MIN_IDLE = "db.minidle";
	    private static final String PROPERTY_NAME_MAX_IDLE = "db.maxidle";
	    private static final String PROPERTY_NAME_MAX_WAIT = "db.maxwait";
	    
	    
	    @SuppressWarnings("unused")
		private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
	    private static final String PROPERTY_NAME_HIBERNATE_DEFAULT_SCHEMA = "hibernate.default.schema";
	    private static final String SOLR_SEARCH_INDEXING_LOCATION = "solr.search.indexing.location";
    
	@Resource
	private Environment env;
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
		dataSource.setInitialSize(Integer.parseInt(env.getRequiredProperty(PROPERTY_NAME_INITIAL_SIZE)));
		dataSource.setMaxActive(Integer.parseInt(env.getRequiredProperty(PROPERTY_NAME_MAX_ACTIVE)));
		dataSource.setMaxIdle(Integer.parseInt(env.getRequiredProperty(PROPERTY_NAME_MAX_IDLE)));
		dataSource.setMinIdle(Integer.parseInt(env.getRequiredProperty(PROPERTY_NAME_MIN_IDLE)));
		dataSource.setMaxWait(Long.parseLong(env.getProperty(PROPERTY_NAME_MAX_WAIT)));		
		return dataSource;
	}
	
	private Properties hibProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.default_catalog.null", "");
		properties.put("databasePlatform", "PostgreSQLDialectUuid");
		properties.put("hibernate.jdbc.batch_size", 
			    String.valueOf(100));
		properties.put("hibernate.order_inserts", "true");
		properties.put("hibernate.order_updates", "true");
		properties.put("hibernate.jdbc.batch_versioned_data", "true");
		
		properties.put("hibernate.default_schema","base");
		properties.setProperty("hibernate.temp.use_jdbc_metadata_defaults","false");
		return properties;	
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan("com.servinglynk.hmis.warehouse.model.base","com.servinglynk.hmis.warehouse.model.v2017");
		sessionFactoryBean.setHibernateProperties(hibProperties());
		try {
			sessionFactoryBean.afterPropertiesSet();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sessionFactoryBean;
	}
}