package com.servinglynk.hmis.warehouse.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.servinglynk.hmis.warehouse.base.dao.ReportConfigDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.config.BaseDatabaseConfig;
import com.servinglynk.hmis.warehouse.dao.AffiliationDao;
import com.servinglynk.hmis.warehouse.dao.AffiliationDaoImpl;
import com.servinglynk.hmis.warehouse.dao.BulkUploadActivityDaoImpl;
import com.servinglynk.hmis.warehouse.dao.BulkUploadErrorDaoImpl;
import com.servinglynk.hmis.warehouse.dao.BulkUploaderDao;
import com.servinglynk.hmis.warehouse.dao.BulkUploaderDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ClientDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ClientVeteranInfoDao;
import com.servinglynk.hmis.warehouse.dao.ClientVeteranInfoDaoImpl;
import com.servinglynk.hmis.warehouse.dao.CocDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ConnectionWithSoarDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ContactDaoImpl;
import com.servinglynk.hmis.warehouse.dao.DateofengagementDao;
import com.servinglynk.hmis.warehouse.dao.DateofengagementDaoImpl;
import com.servinglynk.hmis.warehouse.dao.DisabilitiesDao;
import com.servinglynk.hmis.warehouse.dao.DisabilitiesDaoImpl;
import com.servinglynk.hmis.warehouse.dao.DomesticviolenceDao;
import com.servinglynk.hmis.warehouse.dao.DomesticviolenceDaoImpl;
import com.servinglynk.hmis.warehouse.dao.EducationDaoImpl;
import com.servinglynk.hmis.warehouse.dao.EmploymentDao;
import com.servinglynk.hmis.warehouse.dao.EmploymentDaoImpl;
import com.servinglynk.hmis.warehouse.dao.EnrollmentCocDao;
import com.servinglynk.hmis.warehouse.dao.EnrollmentCocDaoImpl;
import com.servinglynk.hmis.warehouse.dao.EnrollmentDao;
import com.servinglynk.hmis.warehouse.dao.EnrollmentDaoImpl;
import com.servinglynk.hmis.warehouse.dao.EntryrhspDaoImpl;
import com.servinglynk.hmis.warehouse.dao.EntryrhyDaoImpl;
import com.servinglynk.hmis.warehouse.dao.EntryssvfDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ExitDao;
import com.servinglynk.hmis.warehouse.dao.ExitDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ExithousingassessmentDao;
import com.servinglynk.hmis.warehouse.dao.ExithousingassessmentDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ExitrhyDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ExportDaoImpl;
import com.servinglynk.hmis.warehouse.dao.FunderDao;
import com.servinglynk.hmis.warehouse.dao.FunderDaoImpl;
import com.servinglynk.hmis.warehouse.dao.GeographyDaoImpl;
import com.servinglynk.hmis.warehouse.dao.HMISTypeDaoImpl;
import com.servinglynk.hmis.warehouse.dao.HealthStatusDao;
import com.servinglynk.hmis.warehouse.dao.HealthStatusDaoImpl;
import com.servinglynk.hmis.warehouse.dao.HealthinsuranceDao;
import com.servinglynk.hmis.warehouse.dao.HealthinsuranceDaoImpl;
import com.servinglynk.hmis.warehouse.dao.HousingassessmentdispositionDao;
import com.servinglynk.hmis.warehouse.dao.HousingassessmentdispositionDaoImpl;
import com.servinglynk.hmis.warehouse.dao.IncomeandsourcesDao;
import com.servinglynk.hmis.warehouse.dao.IncomeandsourcesDaoImpl;
import com.servinglynk.hmis.warehouse.dao.InventoryDao;
import com.servinglynk.hmis.warehouse.dao.InventoryDaoImpl;
import com.servinglynk.hmis.warehouse.dao.MedicalassistanceDao;
import com.servinglynk.hmis.warehouse.dao.MedicalassistanceDaoImpl;
import com.servinglynk.hmis.warehouse.dao.MoveindateDao;
import com.servinglynk.hmis.warehouse.dao.MoveindateDaoImpl;
import com.servinglynk.hmis.warehouse.dao.NoncashbenefitsDao;
import com.servinglynk.hmis.warehouse.dao.NoncashbenefitsDaoImpl;
import com.servinglynk.hmis.warehouse.dao.OrganizationDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ParentDaoFactoryImpl;
import com.servinglynk.hmis.warehouse.dao.PathstatusDao;
import com.servinglynk.hmis.warehouse.dao.PathstatusDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ProjectDao;
import com.servinglynk.hmis.warehouse.dao.ProjectDaoImpl;
import com.servinglynk.hmis.warehouse.dao.QuestionDaoImpl;
import com.servinglynk.hmis.warehouse.dao.RHYAfterCareDaoImpl;
import com.servinglynk.hmis.warehouse.dao.RhybcpstatusDao;
import com.servinglynk.hmis.warehouse.dao.RhybcpstatusDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ServiceFaReferralDaoImpl;
import com.servinglynk.hmis.warehouse.dao.SourceDao;
import com.servinglynk.hmis.warehouse.dao.SourceDaoImpl;
import com.servinglynk.hmis.warehouse.dao.VASHExitReasonDaoImpl;
import com.servinglynk.hmis.warehouse.dao.helper.BulkUploadHelper2017;
import com.servinglynk.hmis.warehouse.dao.helper.ChronicHomelessCalcHelper;

@Configuration
@EnableTransactionManagement
//@ComponentScan("com.servinglynk.hmis.warehouse.dao.helper")
@PropertySource("classpath:database.properties")
public class DatabaseConfig extends BaseDatabaseConfig{

    private static final String PROPERTY_NAME_DATABASE_DRIVER   = "db.driver";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
    private static final String PROPERTY_NAME_DATABASE_URL      = "db.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
	
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    @SuppressWarnings("unused")
	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
    private static final String PROPERTY_NAME_HIBERNATE_DEFAULT_SCHEMA = "hibernate.default.schema";
    private static final String SOLR_SEARCH_INDEXING_LOCATION = "solr.search.indexing.location";
    
	@Resource
	private Environment env;
	
	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
		
		return dataSource;
	}
	
	private Properties hibProperties() {
		Properties properties = new Properties();
		properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
		properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
		properties.put("hibernate.default_catalog.null", "");
		properties.put("databasePlatform", "PostgreSQLDialectUuid");
		properties.put("hibernate.default_schema",env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DEFAULT_SCHEMA));
		properties.setProperty("hibernate.temp.use_jdbc_metadata_defaults","false");
		properties.setProperty("hibernate.ejb.interceptor", "com.servinglynk.hmis.warehouse.dao.helper.EntityInterceptor");
	//    properties.put("hibernate.search.default.directory_provider", "filesystem");
     //   properties.put("hibernate.search.default.indexBase", this.env.getRequiredProperty(SOLR_SEARCH_INDEXING_LOCATION));
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
		return sessionFactoryBean;
	}
	
	@Bean
	public ClientVeteranInfoDao veteranInfoDao() {
		return new ClientVeteranInfoDaoImpl();
	}
//	
//	@Bean
//	public HmisUserDaoImpl hmisUserDao() {
//		return new HmisUserDaoImpl();
//	}
//	
//	@Bean
//	public HmisOrganizationDaoImpl hmisOrganizationDao() {
//		return new HmisOrganizationDaoImpl();
//	}
//	
//	@Bean
//	public ProjectGroupDaoImpl projectGroupDao() {
//		return new ProjectGroupDaoImpl();
//	}
	
	@Bean
	public BulkUploaderDao bulkUploaderDao()
	{
		return new BulkUploaderDaoImpl();
	}
	@Bean
	public DateofengagementDao dateofengagementDao() { 
		return new DateofengagementDaoImpl();
	}
	@Bean
	public AffiliationDao affiliationDao() { 
		return new AffiliationDaoImpl();
	}
	@Bean
	public DisabilitiesDao disabilitiesDao() { 
		return new DisabilitiesDaoImpl(); 
	}
	@Bean
	public DomesticviolenceDao domesticviolenceDao() { 
		return new DomesticviolenceDaoImpl();
	}
	@Bean
	public RhybcpstatusDao rhybcpstatusDao() { 
		return new RhybcpstatusDaoImpl();
	}
	@Bean
	public EmploymentDao employmentDao() { 
		return new EmploymentDaoImpl();
	}
	@Bean
	public EnrollmentDao enrollmentDao() { 
		return new EnrollmentDaoImpl();
	}
	@Bean
	public EnrollmentCocDao enrollmentCocDao() { 
		return new EnrollmentCocDaoImpl();
	}
	@Bean
	public ExitDao exitDao() { 
		return new ExitDaoImpl();
	}
	@Bean
	public ExithousingassessmentDao exithousingassessmentDao() { 
		return  new ExithousingassessmentDaoImpl();
	}
	@Bean
	public FunderDao funderDao() { 
		return new FunderDaoImpl();
	}
	@Bean
	public HealthinsuranceDao healthinsuranceDao() { 
		return new HealthinsuranceDaoImpl();
	}
	@Bean
	public HealthStatusDao healthStatusDao() { 
		return new HealthStatusDaoImpl();
	}
	@Bean
	public HousingassessmentdispositionDao housingassessmentdispositionDao() { 
		return new HousingassessmentdispositionDaoImpl();
	}
	@Bean
	public IncomeandsourcesDao incomeandsourcesDao() { 
		return new IncomeandsourcesDaoImpl();
	}
	@Bean
	public InventoryDao inventoryDao() { 
		return new InventoryDaoImpl();
	}
	@Bean
	public MedicalassistanceDao medicalassistanceDao() { 
		return new MedicalassistanceDaoImpl();
	}
	@Bean
	public NoncashbenefitsDao noncashbenefitsDao() { 
		return new NoncashbenefitsDaoImpl();
	}
	@Bean
	public PathstatusDao pathstatusDao() { 
		return new PathstatusDaoImpl();
	}
	@Bean
	public ProjectDao projectDao() { 
		return new ProjectDaoImpl();
	}
	@Bean
	public MoveindateDao residentialmoveindateDao() { 
		return new MoveindateDaoImpl();
	}
	@Bean
	public SourceDao sourceDao() { 
		return new SourceDaoImpl();
	}
	@Bean
	public String loginUri(){
		return new String("/hmis-authorization-service/login.html");
	}
	
	@Bean
	public String consentUri(){
		return new String("/hmis-authorization-service/consent.html");
	}
	
	@Bean
	public ExportDaoImpl exportDao(){
		return new ExportDaoImpl();
	}
	
	@Bean
	public BulkUploadHelper2017 bulkUploadHelper() {
		return new BulkUploadHelper2017();
	}
	
	@Bean
	public CocDaoImpl cocDao(){
		return new CocDaoImpl();
	}
	@Bean
	public ContactDaoImpl contactDao(){
		return new ContactDaoImpl();
	}
	@Bean
	public EntryrhspDaoImpl entryrhspDao(){
		return new EntryrhspDaoImpl();
	}
	@Bean
	public EntryrhyDaoImpl entryrhyDao() {
		return new EntryrhyDaoImpl();
	}
	@Bean
	public EntryssvfDaoImpl entryssvfDao() {
		return new EntryssvfDaoImpl();
	}
	@Bean
	public ExitrhyDaoImpl exitrhyDao() {
		return new ExitrhyDaoImpl();
	}
	@Bean
	public ServiceFaReferralDaoImpl serviceFaReferralDao() {
		return new ServiceFaReferralDaoImpl();
	}
	
	@Bean
	public ParentDaoFactoryImpl parentDaoFactory(){
		return new ParentDaoFactoryImpl();
	}
	
	@Bean
	public OrganizationDaoImpl organizationDao(){
		return new OrganizationDaoImpl();
	}
	@Bean
	public EducationDaoImpl educationDao() {
		return new EducationDaoImpl();
	}
	
	@Bean
	public ClientDaoImpl clientDao(){
		return new ClientDaoImpl();
	}
	
	@Bean
	public BulkUploadActivityDaoImpl bulkUploadActivityDao() {
		return new BulkUploadActivityDaoImpl();
	}
	
	@Bean
	public BulkUploadErrorDaoImpl bulkUploadErrorDao() {
		return new BulkUploadErrorDaoImpl();
	}
	@Bean
	public GeographyDaoImpl geographyDao() {
		return new GeographyDaoImpl();
	}
	@Bean
	public VASHExitReasonDaoImpl vashExitReasonDao() {
		return new VASHExitReasonDaoImpl();
	}
	@Bean
	public RHYAfterCareDaoImpl rhyAfterCareDao() {
		return new RHYAfterCareDaoImpl();
	}
	@Bean
	public ConnectionWithSoarDaoImpl connectionWithSoarDao() {
		return new ConnectionWithSoarDaoImpl();
	}

	@Bean
	public QuestionDaoImpl questionDao() {
		return new QuestionDaoImpl();
	}
	
	@Bean
	public HMISTypeDaoImpl hmisTypeDao() {
		return new HMISTypeDaoImpl();
	}
	
	@Bean
	public ChronicHomelessCalcHelper chronicHomelessCalcHelper() {
		return new ChronicHomelessCalcHelper();
	}
}