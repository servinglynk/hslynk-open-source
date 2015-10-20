package com.servinglynk.hmis.warehouse.report.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
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
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.servinglynk.hmis.warehouse.report.business.service.core.ParentService;
import com.servinglynk.hmis.warehouse.report.business.service.core.ParentServiceFactory;
import com.servinglynk.hmis.warehouse.report.core.ExcelReportGenerator;
import com.servinglynk.hmis.warehouse.report.core.PdfReportGenerator;
import com.servinglynk.hmis.warehouse.report.core.ReportGeneratorFactory;
import com.servinglynk.hmis.warehouse.report.dao.ReportLineDao;
import com.servinglynk.hmis.warehouse.report.dao.ReportRecipientDao;
import com.servinglynk.hmis.warehouse.report.persistence.dao.core.ParentDaoFactory;
import com.servinglynk.hmis.warehouse.report.persistence.dao.core.QueryExecutor;
import com.servinglynk.hmis.warehouse.report.request.handler.AHARReportHandler;
import com.servinglynk.hmis.warehouse.report.request.handler.ReportRequestHandlerFactory;
import com.servinglynk.hmis.warehouse.report.scheduler.dao.WorkerHeaderDao;
import com.servinglynk.hmis.warehouse.report.scheduler.dao.WorkerLineDao;
import com.servinglynk.hmis.warehouse.report.service.ReportService;
import com.servinglynk.hmis.warehouse.report.service.ReportWorker;
import com.servinglynk.hmis.warehouse.report.service.WorkerService;

@Configuration
@EnableScheduling
@EnableTransactionManagement
@ImportResource("classpath:com/servinglynk/hmis/warehouse/report/property-config.xml")
@ComponentScan(value={"com.servinglynk.hmis.warehouse.report.service"})
@PropertySource("classpath:com/servinglynk/hmis/warehouse/report/report.properties")

public class SpringConfig {

	@Autowired
	Environment env;
	
	@Bean
    public static PropertyPlaceholderConfigurer properties(){
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ClassPathResource[] resources = new ClassPathResource[ ]
                { new ClassPathResource( "com/servinglynk/hmis/warehouse/report/report.properties" ) };
        ppc.setLocations( resources );
        ppc.setIgnoreUnresolvablePlaceholders( true );
        return ppc;
    }
	


	
	@Bean
	public ReportService reportService(){
		return new ReportService();
	}
	
	@Bean
	public ParentService parentService(){
		ParentService service =new ParentService();
		service.setServiceFactory(parentServiceFactory());
		service.setDaoFactory(getParentDaoFactory());
		return new ParentService();
	}
	
	
	
	
	@Bean
	public ReportGeneratorFactory reportGeneratorFactory(){
		return new ReportGeneratorFactory();
	}
	
	@Bean
	public ExcelReportGenerator excelReportGenerator(){
		return new ExcelReportGenerator();
	}
	
	@Bean
	public PdfReportGenerator pdfIReportGenerator(){
		return new PdfReportGenerator();
	}
	
	@Bean
	public ParentServiceFactory parentServiceFactory(){
		ParentServiceFactory serviceFactory=new ParentServiceFactory();
		return serviceFactory;
	}
	
	@Bean
	public ReportRequestHandlerFactory reportRequestHandlerFactory(){
		
		return new ReportRequestHandlerFactory();
	}
	
	@Bean
	public AHARReportHandler aharReportHandler(){
		return new AHARReportHandler();
	}
	
	
	@Bean
	public WorkerService workerService(){
		return new WorkerService();
	}
	
	@Bean
	public ReportWorker reportWorker(){
		return new ReportWorker();
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

	
	@Bean(destroyMethod="close")
	public BasicDataSource relationalDataSource(){
		BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName(reportConfig().getDbDriverClassName());
    	dataSource.setUrl(reportConfig().getDbUrl());
    	dataSource.setUsername(reportConfig().getDbUserName());
    	dataSource.setPassword(reportConfig().getDbPassword());
		return dataSource;
	}
	

	
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactory= new LocalSessionFactoryBean();
		
		sessionFactory.setDataSource(relationalDataSource());
		sessionFactory.setPackagesToScan("com.servinglynk.hmis.warehouse.report.persistence.entity");
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
	public QueryExecutor getQueryExecutor(){
		return new QueryExecutor();
	}

	
	
	@Bean
	public ReportLineDao getReportLineDao(){
		return new ReportLineDao();
	}
	
	@Bean
	public ReportRecipientDao getReportRecipientDao(){
		return new ReportRecipientDao();
	}
	
	
	@Bean
	public WorkerLineDao getWorkerLineDao(){
		return new WorkerLineDao();
	}
	
	@Bean	
	public WorkerHeaderDao getWorkerHeaderDao(){
		return new WorkerHeaderDao();
	}
	
	
	@Bean
	public ParentDaoFactory getParentDaoFactory(){
		return new ParentDaoFactory();
	}
	
	@Bean
	public ReportConfig reportConfig(){
		return new ReportConfig();
	}
	
}
