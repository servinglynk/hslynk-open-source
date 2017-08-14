package com.servinglynk.hmis.warehouse.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.servinglynk.hmis.warehouse.util.EntityInterceptor;

@Configuration
@EnableTransactionManagement
public class WebDBPoolConfig {
	

    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    @SuppressWarnings("unused")
	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
    private static final String PROPERTY_NAME_HIBERNATE_DEFAULT_SCHEMA = "hibernate.default.schema";
    
	@Resource
	private Environment env;
	
	@Bean
	public DataSource dataSource() {
	
		JndiObjectFactoryBean jndi=new JndiObjectFactoryBean();
		jndi.setResourceRef(true);
		jndi.setJndiName("jdbc/hmisdb");
		jndi.setProxyInterface(DataSource.class);
		jndi.setLookupOnStartup(true);
		try {
			jndi.afterPropertiesSet();
		}catch (NamingException e) {
			throw new RuntimeException(e);
		}
		return (DataSource)jndi.getObject();
	}
	
	private Properties hibProperties() {
		Properties properties = new Properties();
		properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
		properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
		properties.put("hibernate.default_catalog.null", "");
		properties.put("databasePlatform", "PostgreSQLDialectUuid");
		properties.put("hibernate.jdbc.batch_size", 
			    String.valueOf(100));
		properties.put("hibernate.order_inserts", "true");
		properties.put("hibernate.order_updates", "true");
		properties.put("hibernate.jdbc.batch_versioned_data", "true");
		
		properties.put("hibernate.default_schema",env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DEFAULT_SCHEMA));
		properties.setProperty("hibernate.temp.use_jdbc_metadata_defaults","false");
		properties.setProperty("hibernate.ejb.interceptor", "com.servinglynk.hmis.warehouse.dao.helper.EntityInterceptor");
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
		sessionFactoryBean.setPackagesToScan("com.servinglynk.hmis.warehouse.model.base","com.servinglynk.hmis.warehouse.model.v2016");
		sessionFactoryBean.setHibernateProperties(hibProperties());
		sessionFactoryBean.setEntityInterceptor(entityInterceptor());
		try {
			sessionFactoryBean.afterPropertiesSet();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sessionFactoryBean;
	}
	
	@Bean
	public EntityInterceptor entityInterceptor() {
		return new EntityInterceptor();
	}
}