package com.servinglynk.hmis.warehouse.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.servinglynk.hmis.warehouse.dao.AffiliationDao;
import com.servinglynk.hmis.warehouse.dao.AffiliationDaoImpl;
import com.servinglynk.hmis.warehouse.dao.BedinventoryDao;
import com.servinglynk.hmis.warehouse.dao.BedinventoryDaoImpl;
import com.servinglynk.hmis.warehouse.dao.BulkUploaderDao;
import com.servinglynk.hmis.warehouse.dao.BulkUploaderDaoImpl;
import com.servinglynk.hmis.warehouse.dao.BulkUploaderWorkerDao;
import com.servinglynk.hmis.warehouse.dao.BulkUploaderWorkerDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ClientDao;
import com.servinglynk.hmis.warehouse.dao.ClientDaoImpl;
import com.servinglynk.hmis.warehouse.dao.CommercialsexualexploitationDao;
import com.servinglynk.hmis.warehouse.dao.CommercialsexualexploitationDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ConnectionwithsoarDao;
import com.servinglynk.hmis.warehouse.dao.ConnectionwithsoarDaoImpl;
import com.servinglynk.hmis.warehouse.dao.DateofengagementDao;
import com.servinglynk.hmis.warehouse.dao.DateofengagementDaoImpl;
import com.servinglynk.hmis.warehouse.dao.DisabilitiesDao;
import com.servinglynk.hmis.warehouse.dao.DisabilitiesDaoImpl;
import com.servinglynk.hmis.warehouse.dao.DomesticviolenceDao;
import com.servinglynk.hmis.warehouse.dao.DomesticviolenceDaoImpl;
import com.servinglynk.hmis.warehouse.dao.EmploymentDao;
import com.servinglynk.hmis.warehouse.dao.EmploymentDaoImpl;
import com.servinglynk.hmis.warehouse.dao.EnrollmentCocDao;
import com.servinglynk.hmis.warehouse.dao.EnrollmentCocDaoImpl;
import com.servinglynk.hmis.warehouse.dao.EnrollmentDao;
import com.servinglynk.hmis.warehouse.dao.EnrollmentDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ExitDao;
import com.servinglynk.hmis.warehouse.dao.ExitDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ExithousingassessmentDao;
import com.servinglynk.hmis.warehouse.dao.ExithousingassessmentDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ExitplansactionsDao;
import com.servinglynk.hmis.warehouse.dao.ExitplansactionsDaoImpl;
import com.servinglynk.hmis.warehouse.dao.FamilyreunificationDao;
import com.servinglynk.hmis.warehouse.dao.FamilyreunificationDaoImpl;
import com.servinglynk.hmis.warehouse.dao.FormerwardchildwelfareDao;
import com.servinglynk.hmis.warehouse.dao.FormerwardchildwelfareDaoImpl;
import com.servinglynk.hmis.warehouse.dao.FormerwardjuvenilejusticeDao;
import com.servinglynk.hmis.warehouse.dao.FormerwardjuvenilejusticeDaoImpl;
import com.servinglynk.hmis.warehouse.dao.FunderDao;
import com.servinglynk.hmis.warehouse.dao.FunderDaoImpl;
import com.servinglynk.hmis.warehouse.dao.HealthStatusDao;
import com.servinglynk.hmis.warehouse.dao.HealthStatusDaoImpl;
import com.servinglynk.hmis.warehouse.dao.HealthinsuranceDao;
import com.servinglynk.hmis.warehouse.dao.HealthinsuranceDaoImpl;
import com.servinglynk.hmis.warehouse.dao.HmisUserDao;
import com.servinglynk.hmis.warehouse.dao.HmisUserDaoImpl;
import com.servinglynk.hmis.warehouse.dao.HousingassessmentdispositionDao;
import com.servinglynk.hmis.warehouse.dao.HousingassessmentdispositionDaoImpl;
import com.servinglynk.hmis.warehouse.dao.IncomeandsourcesDao;
import com.servinglynk.hmis.warehouse.dao.IncomeandsourcesDaoImpl;
import com.servinglynk.hmis.warehouse.dao.InventoryDao;
import com.servinglynk.hmis.warehouse.dao.InventoryDaoImpl;
import com.servinglynk.hmis.warehouse.dao.LastPermAddressDao;
import com.servinglynk.hmis.warehouse.dao.LastPermAddressDaoImpl;
import com.servinglynk.hmis.warehouse.dao.LastgradecompletedDao;
import com.servinglynk.hmis.warehouse.dao.LastgradecompletedDaoImpl;
import com.servinglynk.hmis.warehouse.dao.LastpermanentaddressDao;
import com.servinglynk.hmis.warehouse.dao.LastpermanentaddressDaoImpl;
import com.servinglynk.hmis.warehouse.dao.MedicalassistanceDao;
import com.servinglynk.hmis.warehouse.dao.MedicalassistanceDaoImpl;
import com.servinglynk.hmis.warehouse.dao.NoncashbenefitsDao;
import com.servinglynk.hmis.warehouse.dao.NoncashbenefitsDaoImpl;
import com.servinglynk.hmis.warehouse.dao.OrganizationDao;
import com.servinglynk.hmis.warehouse.dao.OrganizationDaoImpl;
import com.servinglynk.hmis.warehouse.dao.PathstatusDao;
import com.servinglynk.hmis.warehouse.dao.PathstatusDaoImpl;
import com.servinglynk.hmis.warehouse.dao.PercentamiDao;
import com.servinglynk.hmis.warehouse.dao.PercentamiDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ProjectDao;
import com.servinglynk.hmis.warehouse.dao.ProjectDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ProjectcocDao;
import com.servinglynk.hmis.warehouse.dao.ProjectcocDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ProjectcompletionstatusDao;
import com.servinglynk.hmis.warehouse.dao.ProjectcompletionstatusDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ReferralsourceDao;
import com.servinglynk.hmis.warehouse.dao.ReferralsourceDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ResidentialmoveindateDao;
import com.servinglynk.hmis.warehouse.dao.ResidentialmoveindateDaoImpl;
import com.servinglynk.hmis.warehouse.dao.RhybcpstatusDao;
import com.servinglynk.hmis.warehouse.dao.RhybcpstatusDaoImpl;
import com.servinglynk.hmis.warehouse.dao.SchoolstatusDao;
import com.servinglynk.hmis.warehouse.dao.SchoolstatusDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ServicesDao;
import com.servinglynk.hmis.warehouse.dao.ServicesDaoImpl;
import com.servinglynk.hmis.warehouse.dao.SexualorientationDao;
import com.servinglynk.hmis.warehouse.dao.SexualorientationDaoImpl;
import com.servinglynk.hmis.warehouse.dao.SiteDao;
import com.servinglynk.hmis.warehouse.dao.SiteDaoImpl;
import com.servinglynk.hmis.warehouse.dao.SourceDao;
import com.servinglynk.hmis.warehouse.dao.SourceDaoImpl;
import com.servinglynk.hmis.warehouse.dao.SyncListDao;
import com.servinglynk.hmis.warehouse.dao.SyncListDaoImpl;
import com.servinglynk.hmis.warehouse.dao.VeteranInfoDao;
import com.servinglynk.hmis.warehouse.dao.VeteranInfoDaoImpl;
import com.servinglynk.hmis.warehouse.dao.WorsthousingsituationDao;
import com.servinglynk.hmis.warehouse.dao.WorsthousingsituationDaoImpl;
import com.servinglynk.hmis.warehouse.dao.YouthcriticalissuesDao;
import com.servinglynk.hmis.warehouse.dao.YouthcriticalissuesDaoImpl;
import com.servinglynk.hmis.warehouse.dao.AccountConsentDaoImpl;
import com.servinglynk.hmis.warehouse.dao.AccountDaoImpl;
import com.servinglynk.hmis.warehouse.dao.AccountDataChangeDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ApiMethodDaoImpl;
import com.servinglynk.hmis.warehouse.dao.DeveloperCompanyAccountDaoImpl;
import com.servinglynk.hmis.warehouse.dao.DeveloperCompanyDaoImpl;
import com.servinglynk.hmis.warehouse.dao.DeveloperServiceDaoImpl;
import com.servinglynk.hmis.warehouse.dao.PasswordResetDaoImpl;
import com.servinglynk.hmis.warehouse.dao.RedirectUriDaoImpl;
import com.servinglynk.hmis.warehouse.dao.RefreshTokenDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ServiceApiMethodDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ServiceDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ServiceLicenseDaoImpl;
import com.servinglynk.hmis.warehouse.dao.ServiceStatusDaoImpl;
import com.servinglynk.hmis.warehouse.dao.SessionDaoImpl;
import com.servinglynk.hmis.warehouse.dao.TrustedAppDaoImpl;
import com.servinglynk.hmis.warehouse.dao.TrustedAppStatusDaoImpl;
import com.servinglynk.hmis.warehouse.dao.VerificationDaoImpl;

import com.servinglynk.hmis.warehouse.dao.*;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.servinglynk.hmis.warehouse")
@PropertySource("classpath:database.properties")
public class DatabaseConfig {

    private static final String PROPERTY_NAME_DATABASE_DRIVER   = "db.driver";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
    private static final String PROPERTY_NAME_DATABASE_URL      = "db.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
	
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    @SuppressWarnings("unused")
	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
    private static final String PROPERTY_NAME_HIBERNATE_DEFAULT_SCHEMA = "hibernate.default.schema";
    
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
		sessionFactoryBean.setPackagesToScan("com.servinglynk.hmis.warehouse.entity","com.servinglynk.hmis.warehouse.model.live");
		sessionFactoryBean.setHibernateProperties(hibProperties());
		return sessionFactoryBean;
	}
	
	@Bean
	public HmisUserDao hmisUserDao()
	{
		return new HmisUserDaoImpl();
	}
	
	@Bean
	public SyncListDao syncListDao()
	{
		return new SyncListDaoImpl();
	}
	@Bean
	public VeteranInfoDao veteranInfoDao() {
		return new VeteranInfoDaoImpl();
	}
	@Bean
	public BulkUploaderDao bulkUploaderDao()
	{
		return new BulkUploaderDaoImpl();
	}
	@Bean
	public BulkUploaderWorkerDao bulkUploaderWorkerDao()
	{
		return new BulkUploaderWorkerDaoImpl();
	}
	@Bean
	public CommercialsexualexploitationDao commercialsexualexploitationDao() { 
		return new CommercialsexualexploitationDaoImpl();
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
	public BedinventoryDao bedinventoryDao() {
		return new BedinventoryDaoImpl();
		
	}
	@Bean
	public ClientDao clientDao() { 
		return new ClientDaoImpl();
	}
	@Bean
	public ConnectionwithsoarDao connectionwithsoarDao() {
		return new ConnectionwithsoarDaoImpl();
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
	public ExitplansactionsDao exitplansactionsDao() { 
		return new ExitplansactionsDaoImpl();
	}
	@Bean
	public FamilyreunificationDao familyreunificationDao() {
		return new FamilyreunificationDaoImpl();
	}
	@Bean
	public FormerwardchildwelfareDao formerwardchildwelfareDao() { 
		return  new FormerwardchildwelfareDaoImpl();
	}
	@Bean
	public FormerwardjuvenilejusticeDao formerwardjuvenilejusticeDao() {
		return  new FormerwardjuvenilejusticeDaoImpl();
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
	public LastgradecompletedDao lastgradecompletedDao() { 
		return new LastgradecompletedDaoImpl();
	}
	@Bean
	public LastPermAddressDao lastPermAddressDao() {
		return new LastPermAddressDaoImpl();
	}
	@Bean
	public LastpermanentaddressDao lastpermanentaddressDao() { 
		return new LastpermanentaddressDaoImpl();
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
	public OrganizationDao organizationDao() { 
		return new OrganizationDaoImpl();
	}
	@Bean
	public PathstatusDao pathstatusDao() { 
		return new PathstatusDaoImpl();
	}
	@Bean
	public PercentamiDao percentamiDao() { 
		return new PercentamiDaoImpl();
	}
	@Bean
	public ProjectDao projectDao() { 
		return new ProjectDaoImpl();
	}
	@Bean
	public ProjectcocDao projectcocDao() { 
		return new ProjectcocDaoImpl();
	}
	@Bean
	public ProjectcompletionstatusDao projectcompletionstatusDao() { 
		return new ProjectcompletionstatusDaoImpl();
	}
	@Bean
	public ReferralsourceDao referralsourceDao() { 
		return new ReferralsourceDaoImpl();
	}
	@Bean
	public ResidentialmoveindateDao residentialmoveindateDao() { 
		return new ResidentialmoveindateDaoImpl();
	}
	@Bean
	public RhybcpstatusDao rhybcpstatusDao() { 
		return new RhybcpstatusDaoImpl();
	}
	@Bean
	public SchoolstatusDao schoolstatusDao() { 
		return new SchoolstatusDaoImpl();
	}
	@Bean
	public ServicesDao servicesDao() { 
		return new ServicesDaoImpl();
	}
	@Bean
	public SexualorientationDao sexualorientationDao() { 
		return new SexualorientationDaoImpl();
	}
	@Bean
	public SiteDao siteDao() { 
		return new SiteDaoImpl();
	}
	@Bean
	public SourceDao sourceDao() { 
		return new SourceDaoImpl();
	}
	// public SyncDao
	@Bean
	public WorsthousingsituationDao worsthousingsituationDao() { 
		return new WorsthousingsituationDaoImpl();
	}
	@Bean
	public YouthcriticalissuesDao youthcriticalissuesDao() { 
		return  new YouthcriticalissuesDaoImpl();
	}

	
	@Bean
	public DeveloperCompanyDaoImpl developerCompanyDao(){
		return new DeveloperCompanyDaoImpl();
	}
	
	@Bean
	public AccountDaoImpl accountDao(){

		return new AccountDaoImpl();
	}
	
	
	@Bean
	public DeveloperCompanyAccountDaoImpl developerCompanyAccountDao(){
		return new DeveloperCompanyAccountDaoImpl();
	}
	
	@Bean
	public DeveloperServiceDaoImpl developerServiceDao(){
		return new DeveloperServiceDaoImpl();
	}
	
	
	@Bean
	public ServiceApiMethodDaoImpl serviceApiMethodDao(){
		return new ServiceApiMethodDaoImpl();
	}

	@Bean	
	public ServiceStatusDaoImpl serviceStatusDao(){
		return new ServiceStatusDaoImpl();
	}
	
	@Bean
	public ApiMethodDaoImpl apiMethodDao(){
		return new ApiMethodDaoImpl();
	}

	@Bean
	public ServiceLicenseDaoImpl serviceLicenseDao(){
		return new ServiceLicenseDaoImpl();
	}
	
	@Bean
	public TrustedAppDaoImpl trustedAppDao(){
		return new TrustedAppDaoImpl();
	}
	
	@Bean
	public TrustedAppStatusDaoImpl trustedAppStatusDao(){
		return new TrustedAppStatusDaoImpl();
	}
	
	@Bean
	public RedirectUriDaoImpl redirectUriDao(){
		return new RedirectUriDaoImpl();
	}
	
	
	@Bean
	public AccountConsentDaoImpl accountConsentDao(){
		return new AccountConsentDaoImpl();
	}
	
	@Bean
	public RefreshTokenDaoImpl refreshTokenDao(){
		return new RefreshTokenDaoImpl();
	}
	
	@Bean
	public SessionDaoImpl sessionDao(){
		return new SessionDaoImpl();
	}
	
	@Bean
	public String loginUri(){
		return new String("/hmis-authorizationservice/login.html");
	}
	
	@Bean
	public String consentUri(){
		return new String("/hmis-authorizationservice/consent.html");
	}
	
	
	@Bean
	public ServiceDaoImpl serviceDao(){
		return new ServiceDaoImpl();
	}
	
	@Bean
	public VerificationDaoImpl verificationDao(){
		return new VerificationDaoImpl();
	}
	
	@Bean
	public PasswordResetDaoImpl passwordResetDao(){
		return new PasswordResetDaoImpl();
	}
	
	@Bean
	public AccountDataChangeDaoImpl accountDataChangeDao(){
		return new AccountDataChangeDaoImpl();
	}
	@Bean
	public DeveloperCompanyStatusDaoImpl developerCompanyStatusDao(){
		return new DeveloperCompanyStatusDaoImpl();
	}
	
	@Bean
	public ProfileDaoImpl profileDao(){
		return new ProfileDaoImpl();
	}
	
	@Bean
	public ProfileAclDaoImpl profileAclDao(){
		return new ProfileAclDaoImpl();
	}
	
	@Bean
	public RoleDaoImpl roleDao(){
		return new RoleDaoImpl();
	}
	
	@Bean
	public PermissionSetDaoImpl permissionSetDao(){
		return new PermissionSetDaoImpl();
	}
	
	@Bean
	public SharingRuleDaoImpl sharingRuleDao(){
		return new SharingRuleDaoImpl();
	}
	
}