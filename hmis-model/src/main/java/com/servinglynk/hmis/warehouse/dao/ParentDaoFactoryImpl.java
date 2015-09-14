package com.servinglynk.hmis.warehouse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParentDaoFactoryImpl implements ParentDaoFactory {
	@Autowired
	private HmisUserDao hmisUserDao;
	@Autowired
	private SyncListDao syncListDao;
	@Autowired
	private BulkUploaderDao bulkUploaderDao;
	@Autowired
	private CommercialsexualexploitationDao commercialsexualexploitationDao;
	@Autowired
	private DateofengagementDao dateofengagementDao;
	@Autowired
	private AffiliationDao affiliationDao;
	@Autowired
	private BedinventoryDao bedinventoryDao;
	@Autowired
	private ClientDao clientDao;
	@Autowired
	private ConnectionwithsoarDao connectionwithsoarDao;
	@Autowired
	private DisabilitiesDao disabilitiesDao;
	@Autowired
	private DomesticviolenceDao domesticviolenceDao;
	@Autowired
	private EmploymentDao employmentDao;
	@Autowired
	private EnrollmentDao enrollmentDao;
	@Autowired
	private EnrollmentCocDao enrollmentCocDao;
	@Autowired
	private ExitDao exitDao;
	@Autowired
	private ExithousingassessmentDao exithousingassessmentDao;
	@Autowired
	private ExitplansactionsDao exitplansactionsDao;
	@Autowired
	private FamilyreunificationDao familyreunificationDao;
	@Autowired
	private FormerwardchildwelfareDao formerwardchildwelfareDao;
	@Autowired
	private FormerwardjuvenilejusticeDao formerwardjuvenilejusticeDao;
	@Autowired
	private FunderDao funderDao;
	@Autowired
	private HealthinsuranceDao healthinsuranceDao;
	@Autowired
	private HealthStatusDao healthStatusDao;
	// private HmisTypeDao
	// private HmisUserDao
	@Autowired
	private HousingassessmentdispositionDao housingassessmentdispositionDao;
	@Autowired
	private IncomeandsourcesDao incomeandsourcesDao;
	@Autowired
	private InventoryDao inventoryDao;
	@Autowired
	private LastgradecompletedDao lastgradecompletedDao;
	@Autowired
	private LastPermAddressDao lastPermAddressDao;
	@Autowired
	private LastpermanentaddressDao lastpermanentaddressDao;
	@Autowired
	private MedicalassistanceDao medicalassistanceDao;
	@Autowired
	private NoncashbenefitsDao noncashbenefitsDao;
	@Autowired
	private OrganizationDao organizationDao;
	@Autowired
	private PathstatusDao pathstatusDao;
	@Autowired
	private PercentamiDao percentamiDao;
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private ProjectcocDao projectcocDao;
	@Autowired
	private ProjectcompletionstatusDao projectcompletionstatusDao;
	@Autowired
	private ReferralsourceDao referralsourceDao;
	@Autowired
	private ResidentialmoveindateDao residentialmoveindateDao;
	@Autowired
	private RhybcpstatusDao rhybcpstatusDao;
	@Autowired
	private SchoolstatusDao schoolstatusDao;
	@Autowired
	private ServicesDao servicesDao;
	@Autowired
	private SexualorientationDao sexualorientationDao;
	@Autowired
	private SiteDao siteDao;
	@Autowired
	private SourceDao sourceDao;
	// private SyncDao
	@Autowired
	private VeteranInfoDao veteranInfoDao;
	@Autowired
	private WorsthousingsituationDao worsthousingsituationDao;
	@Autowired
	private YouthcriticalissuesDao youthcriticalissuesDao;
	@Autowired
	private BulkUploaderWorkerDao bulkUploaderWorkerDao;

	/**
	 * @return the hmisUserDao
	 */
	public HmisUserDao getHmisUserDao() {
		return hmisUserDao;
	}

	/**
	 * @param hmisUserDao
	 *            the hmisUserDao to set
	 */
	public void setHmisUserDao(HmisUserDao hmisUserDao) {
		this.hmisUserDao = hmisUserDao;
	}

	/**
	 * @return the syncListDao
	 */
	public SyncListDao getSyncListDao() {
		return syncListDao;
	}

	/**
	 * @param syncListDao
	 *            the syncListDao to set
	 */
	public void setSyncListDao(SyncListDao syncListDao) {
		this.syncListDao = syncListDao;
	}

	/**
	 * @return the bulkUploaderDao
	 */
	public BulkUploaderDao getBulkUploaderDao() {
		return bulkUploaderDao;
	}

	/**
	 * @param bulkUploaderDao
	 *            the bulkUploaderDao to set
	 */
	public void setBulkUploaderDao(BulkUploaderDao bulkUploaderDao) {
		this.bulkUploaderDao = bulkUploaderDao;
	}

	/**
	 * @return the commercialsexualexploitationDao
	 */
	public CommercialsexualexploitationDao getCommercialsexualexploitationDao() {
		return commercialsexualexploitationDao;
	}

	/**
	 * @param commercialsexualexploitationDao
	 *            the commercialsexualexploitationDao to set
	 */
	public void setCommercialsexualexploitationDao(
			CommercialsexualexploitationDao commercialsexualexploitationDao) {
		this.commercialsexualexploitationDao = commercialsexualexploitationDao;
	}

	/**
	 * @return the dateofengagementDao
	 */
	public DateofengagementDao getDateofengagementDao() {
		return dateofengagementDao;
	}

	/**
	 * @param dateofengagementDao
	 *            the dateofengagementDao to set
	 */
	public void setDateofengagementDao(DateofengagementDao dateofengagementDao) {
		this.dateofengagementDao = dateofengagementDao;
	}

	/**
	 * @return the affiliationDao
	 */
	public AffiliationDao getAffiliationDao() {
		return affiliationDao;
	}

	/**
	 * @param affiliationDao
	 *            the affiliationDao to set
	 */
	public void setAffiliationDao(AffiliationDao affiliationDao) {
		this.affiliationDao = affiliationDao;
	}

	/**
	 * @return the bedinventoryDao
	 */
	public BedinventoryDao getBedinventoryDao() {
		return bedinventoryDao;
	}

	/**
	 * @param bedinventoryDao
	 *            the bedinventoryDao to set
	 */
	public void setBedinventoryDao(BedinventoryDao bedinventoryDao) {
		this.bedinventoryDao = bedinventoryDao;
	}

	/**
	 * @return the clientDao
	 */
	public ClientDao getClientDao() {
		return clientDao;
	}

	/**
	 * @param clientDao
	 *            the clientDao to set
	 */
	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	/**
	 * @return the connectionwithsoarDao
	 */
	public ConnectionwithsoarDao getConnectionwithsoarDao() {
		return connectionwithsoarDao;
	}

	/**
	 * @param connectionwithsoarDao
	 *            the connectionwithsoarDao to set
	 */
	public void setConnectionwithsoarDao(
			ConnectionwithsoarDao connectionwithsoarDao) {
		this.connectionwithsoarDao = connectionwithsoarDao;
	}

	/**
	 * @return the disabilitiesDao
	 */
	public DisabilitiesDao getDisabilitiesDao() {
		return disabilitiesDao;
	}

	/**
	 * @param disabilitiesDao
	 *            the disabilitiesDao to set
	 */
	public void setDisabilitiesDao(DisabilitiesDao disabilitiesDao) {
		this.disabilitiesDao = disabilitiesDao;
	}

	/**
	 * @return the domesticviolenceDao
	 */
	public DomesticviolenceDao getDomesticviolenceDao() {
		return domesticviolenceDao;
	}

	/**
	 * @param domesticviolenceDao
	 *            the domesticviolenceDao to set
	 */
	public void setDomesticviolenceDao(DomesticviolenceDao domesticviolenceDao) {
		this.domesticviolenceDao = domesticviolenceDao;
	}

	/**
	 * @return the employmentDao
	 */
	public EmploymentDao getEmploymentDao() {
		return employmentDao;
	}

	/**
	 * @param employmentDao
	 *            the employmentDao to set
	 */
	public void setEmploymentDao(EmploymentDao employmentDao) {
		this.employmentDao = employmentDao;
	}

	/**
	 * @return the enrollmentDao
	 */
	public EnrollmentDao getEnrollmentDao() {
		return enrollmentDao;
	}

	/**
	 * @param enrollmentDao
	 *            the enrollmentDao to set
	 */
	public void setEnrollmentDao(EnrollmentDao enrollmentDao) {
		this.enrollmentDao = enrollmentDao;
	}

	/**
	 * @return the enrollmentCocDao
	 */
	public EnrollmentCocDao getEnrollmentCocDao() {
		return enrollmentCocDao;
	}

	/**
	 * @param enrollmentCocDao
	 *            the enrollmentCocDao to set
	 */
	public void setEnrollmentCocDao(EnrollmentCocDao enrollmentCocDao) {
		this.enrollmentCocDao = enrollmentCocDao;
	}

	/**
	 * @return the exitDao
	 */
	public ExitDao getExitDao() {
		return exitDao;
	}

	/**
	 * @param exitDao
	 *            the exitDao to set
	 */
	public void setExitDao(ExitDao exitDao) {
		this.exitDao = exitDao;
	}

	/**
	 * @return the exithousingassessmentDao
	 */
	public ExithousingassessmentDao getExithousingassessmentDao() {
		return exithousingassessmentDao;
	}

	/**
	 * @param exithousingassessmentDao
	 *            the exithousingassessmentDao to set
	 */
	public void setExithousingassessmentDao(
			ExithousingassessmentDao exithousingassessmentDao) {
		this.exithousingassessmentDao = exithousingassessmentDao;
	}

	/**
	 * @return the exitplansactionsDao
	 */
	public ExitplansactionsDao getExitplansactionsDao() {
		return exitplansactionsDao;
	}

	/**
	 * @param exitplansactionsDao
	 *            the exitplansactionsDao to set
	 */
	public void setExitplansactionsDao(ExitplansactionsDao exitplansactionsDao) {
		this.exitplansactionsDao = exitplansactionsDao;
	}

	/**
	 * @return the familyreunificationDao
	 */
	public FamilyreunificationDao getFamilyreunificationDao() {
		return familyreunificationDao;
	}

	/**
	 * @param familyreunificationDao
	 *            the familyreunificationDao to set
	 */
	public void setFamilyreunificationDao(
			FamilyreunificationDao familyreunificationDao) {
		this.familyreunificationDao = familyreunificationDao;
	}

	/**
	 * @return the formerwardchildwelfareDao
	 */
	public FormerwardchildwelfareDao getFormerwardchildwelfareDao() {
		return formerwardchildwelfareDao;
	}

	/**
	 * @param formerwardchildwelfareDao
	 *            the formerwardchildwelfareDao to set
	 */
	public void setFormerwardchildwelfareDao(
			FormerwardchildwelfareDao formerwardchildwelfareDao) {
		this.formerwardchildwelfareDao = formerwardchildwelfareDao;
	}

	/**
	 * @return the formerwardjuvenilejusticeDao
	 */
	public FormerwardjuvenilejusticeDao getFormerwardjuvenilejusticeDao() {
		return formerwardjuvenilejusticeDao;
	}

	/**
	 * @param formerwardjuvenilejusticeDao
	 *            the formerwardjuvenilejusticeDao to set
	 */
	public void setFormerwardjuvenilejusticeDao(
			FormerwardjuvenilejusticeDao formerwardjuvenilejusticeDao) {
		this.formerwardjuvenilejusticeDao = formerwardjuvenilejusticeDao;
	}

	/**
	 * @return the funderDao
	 */
	public FunderDao getFunderDao() {
		return funderDao;
	}

	/**
	 * @param funderDao
	 *            the funderDao to set
	 */
	public void setFunderDao(FunderDao funderDao) {
		this.funderDao = funderDao;
	}

	/**
	 * @return the healthinsuranceDao
	 */
	public HealthinsuranceDao getHealthinsuranceDao() {
		return healthinsuranceDao;
	}

	/**
	 * @param healthinsuranceDao
	 *            the healthinsuranceDao to set
	 */
	public void setHealthinsuranceDao(HealthinsuranceDao healthinsuranceDao) {
		this.healthinsuranceDao = healthinsuranceDao;
	}

	/**
	 * @return the healthStatusDao
	 */
	public HealthStatusDao getHealthStatusDao() {
		return healthStatusDao;
	}

	/**
	 * @param healthStatusDao
	 *            the healthStatusDao to set
	 */
	public void setHealthStatusDao(HealthStatusDao healthStatusDao) {
		this.healthStatusDao = healthStatusDao;
	}

	/**
	 * @return the housingassessmentdispositionDao
	 */
	public HousingassessmentdispositionDao getHousingassessmentdispositionDao() {
		return housingassessmentdispositionDao;
	}

	/**
	 * @param housingassessmentdispositionDao
	 *            the housingassessmentdispositionDao to set
	 */
	public void setHousingassessmentdispositionDao(
			HousingassessmentdispositionDao housingassessmentdispositionDao) {
		this.housingassessmentdispositionDao = housingassessmentdispositionDao;
	}

	/**
	 * @return the incomeandsourcesDao
	 */
	public IncomeandsourcesDao getIncomeandsourcesDao() {
		return incomeandsourcesDao;
	}

	/**
	 * @param incomeandsourcesDao
	 *            the incomeandsourcesDao to set
	 */
	public void setIncomeandsourcesDao(IncomeandsourcesDao incomeandsourcesDao) {
		this.incomeandsourcesDao = incomeandsourcesDao;
	}

	/**
	 * @return the inventoryDao
	 */
	public InventoryDao getInventoryDao() {
		return inventoryDao;
	}

	/**
	 * @param inventoryDao
	 *            the inventoryDao to set
	 */
	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}

	/**
	 * @return the lastgradecompletedDao
	 */
	public LastgradecompletedDao getLastgradecompletedDao() {
		return lastgradecompletedDao;
	}

	/**
	 * @param lastgradecompletedDao
	 *            the lastgradecompletedDao to set
	 */
	public void setLastgradecompletedDao(
			LastgradecompletedDao lastgradecompletedDao) {
		this.lastgradecompletedDao = lastgradecompletedDao;
	}

	/**
	 * @return the lastPermAddressDao
	 */
	public LastPermAddressDao getLastPermAddressDao() {
		return lastPermAddressDao;
	}

	/**
	 * @param lastPermAddressDao
	 *            the lastPermAddressDao to set
	 */
	public void setLastPermAddressDao(LastPermAddressDao lastPermAddressDao) {
		this.lastPermAddressDao = lastPermAddressDao;
	}

	/**
	 * @return the lastpermanentaddressDao
	 */
	public LastpermanentaddressDao getLastpermanentaddressDao() {
		return lastpermanentaddressDao;
	}

	/**
	 * @param lastpermanentaddressDao
	 *            the lastpermanentaddressDao to set
	 */
	public void setLastpermanentaddressDao(
			LastpermanentaddressDao lastpermanentaddressDao) {
		this.lastpermanentaddressDao = lastpermanentaddressDao;
	}

	/**
	 * @return the medicalassistanceDao
	 */
	public MedicalassistanceDao getMedicalassistanceDao() {
		return medicalassistanceDao;
	}

	/**
	 * @param medicalassistanceDao
	 *            the medicalassistanceDao to set
	 */
	public void setMedicalassistanceDao(
			MedicalassistanceDao medicalassistanceDao) {
		this.medicalassistanceDao = medicalassistanceDao;
	}

	/**
	 * @return the noncashbenefitsDao
	 */
	public NoncashbenefitsDao getNoncashbenefitsDao() {
		return noncashbenefitsDao;
	}

	/**
	 * @param noncashbenefitsDao
	 *            the noncashbenefitsDao to set
	 */
	public void setNoncashbenefitsDao(NoncashbenefitsDao noncashbenefitsDao) {
		this.noncashbenefitsDao = noncashbenefitsDao;
	}

	/**
	 * @return the organizationDao
	 */
	public OrganizationDao getOrganizationDao() {
		return organizationDao;
	}

	/**
	 * @param organizationDao
	 *            the organizationDao to set
	 */
	public void setOrganizationDao(OrganizationDao organizationDao) {
		this.organizationDao = organizationDao;
	}

	/**
	 * @return the pathstatusDao
	 */
	public PathstatusDao getPathstatusDao() {
		return pathstatusDao;
	}

	/**
	 * @param pathstatusDao
	 *            the pathstatusDao to set
	 */
	public void setPathstatusDao(PathstatusDao pathstatusDao) {
		this.pathstatusDao = pathstatusDao;
	}

	/**
	 * @return the percentamiDao
	 */
	public PercentamiDao getPercentamiDao() {
		return percentamiDao;
	}

	/**
	 * @param percentamiDao
	 *            the percentamiDao to set
	 */
	public void setPercentamiDao(PercentamiDao percentamiDao) {
		this.percentamiDao = percentamiDao;
	}

	/**
	 * @return the projectDao
	 */
	public ProjectDao getProjectDao() {
		return projectDao;
	}

	/**
	 * @param projectDao
	 *            the projectDao to set
	 */
	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	/**
	 * @return the projectcocDao
	 */
	public ProjectcocDao getProjectcocDao() {
		return projectcocDao;
	}

	/**
	 * @param projectcocDao
	 *            the projectcocDao to set
	 */
	public void setProjectcocDao(ProjectcocDao projectcocDao) {
		this.projectcocDao = projectcocDao;
	}

	/**
	 * @return the projectcompletionstatusDao
	 */
	public ProjectcompletionstatusDao getProjectcompletionstatusDao() {
		return projectcompletionstatusDao;
	}

	/**
	 * @param projectcompletionstatusDao
	 *            the projectcompletionstatusDao to set
	 */
	public void setProjectcompletionstatusDao(
			ProjectcompletionstatusDao projectcompletionstatusDao) {
		this.projectcompletionstatusDao = projectcompletionstatusDao;
	}

	/**
	 * @return the referralsourceDao
	 */
	public ReferralsourceDao getReferralsourceDao() {
		return referralsourceDao;
	}

	/**
	 * @param referralsourceDao
	 *            the referralsourceDao to set
	 */
	public void setReferralsourceDao(ReferralsourceDao referralsourceDao) {
		this.referralsourceDao = referralsourceDao;
	}

	/**
	 * @return the residentialmoveindateDao
	 */
	public ResidentialmoveindateDao getResidentialmoveindateDao() {
		return residentialmoveindateDao;
	}

	/**
	 * @param residentialmoveindateDao
	 *            the residentialmoveindateDao to set
	 */
	public void setResidentialmoveindateDao(
			ResidentialmoveindateDao residentialmoveindateDao) {
		this.residentialmoveindateDao = residentialmoveindateDao;
	}

	/**
	 * @return the rhybcpstatusDao
	 */
	public RhybcpstatusDao getRhybcpstatusDao() {
		return rhybcpstatusDao;
	}

	/**
	 * @param rhybcpstatusDao
	 *            the rhybcpstatusDao to set
	 */
	public void setRhybcpstatusDao(RhybcpstatusDao rhybcpstatusDao) {
		this.rhybcpstatusDao = rhybcpstatusDao;
	}

	/**
	 * @return the schoolstatusDao
	 */
	public SchoolstatusDao getSchoolstatusDao() {
		return schoolstatusDao;
	}

	/**
	 * @param schoolstatusDao
	 *            the schoolstatusDao to set
	 */
	public void setSchoolstatusDao(SchoolstatusDao schoolstatusDao) {
		this.schoolstatusDao = schoolstatusDao;
	}

	/**
	 * @return the servicesDao
	 */
	public ServicesDao getServicesDao() {
		return servicesDao;
	}

	/**
	 * @param servicesDao
	 *            the servicesDao to set
	 */
	public void setServicesDao(ServicesDao servicesDao) {
		this.servicesDao = servicesDao;
	}

	/**
	 * @return the sexualorientationDao
	 */
	public SexualorientationDao getSexualorientationDao() {
		return sexualorientationDao;
	}

	/**
	 * @param sexualorientationDao
	 *            the sexualorientationDao to set
	 */
	public void setSexualorientationDao(
			SexualorientationDao sexualorientationDao) {
		this.sexualorientationDao = sexualorientationDao;
	}

	/**
	 * @return the siteDao
	 */
	public SiteDao getSiteDao() {
		return siteDao;
	}

	/**
	 * @param siteDao
	 *            the siteDao to set
	 */
	public void setSiteDao(SiteDao siteDao) {
		this.siteDao = siteDao;
	}

	/**
	 * @return the sourceDao
	 */
	public SourceDao getSourceDao() {
		return sourceDao;
	}

	/**
	 * @param sourceDao
	 *            the sourceDao to set
	 */
	public void setSourceDao(SourceDao sourceDao) {
		this.sourceDao = sourceDao;
	}

	/**
	 * @return the veteranInfoDao
	 */
	public VeteranInfoDao getVeteranInfoDao() {
		return veteranInfoDao;
	}

	/**
	 * @param veteranInfoDao
	 *            the veteranInfoDao to set
	 */
	public void setVeteranInfoDao(VeteranInfoDao veteranInfoDao) {
		this.veteranInfoDao = veteranInfoDao;
	}

	/**
	 * @return the worsthousingsituationDao
	 */
	public WorsthousingsituationDao getWorsthousingsituationDao() {
		return worsthousingsituationDao;
	}

	/**
	 * @param worsthousingsituationDao
	 *            the worsthousingsituationDao to set
	 */
	public void setWorsthousingsituationDao(
			WorsthousingsituationDao worsthousingsituationDao) {
		this.worsthousingsituationDao = worsthousingsituationDao;
	}

	/**
	 * @return the youthcriticalissuesDao
	 */
	public YouthcriticalissuesDao getYouthcriticalissuesDao() {
		return youthcriticalissuesDao;
	}

	/**
	 * @param youthcriticalissuesDao
	 *            the youthcriticalissuesDao to set
	 */
	public void setYouthcriticalissuesDao(
			YouthcriticalissuesDao youthcriticalissuesDao) {
		this.youthcriticalissuesDao = youthcriticalissuesDao;
	}

	public BulkUploaderWorkerDao getBulkUploaderWorkerDao() {
		return bulkUploaderWorkerDao;
	}

	public void setBulkUploaderWorkerDao(
			BulkUploaderWorkerDao bulkUploaderWorkerDao) {
		this.bulkUploaderWorkerDao = bulkUploaderWorkerDao;
	}
	
	
		@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private VerificationDao verificationDao;
	
	@Autowired
	private PasswordResetDao passwordResetDao;
	
	@Autowired
	private AccountDataChangeDao accountDataChangeDao;
	
	@Autowired
	private ApiMethodDao apiMethodDao;
	
	@Autowired
	private DeveloperServiceDao developerServiceDao;
	
	@Autowired
	private TrustedAppDao trustedAppDao;
	
	
	@Autowired
	private AccountConsentDao accountConsentDao;
	
	
	@Autowired
	private SessionDao sessionDao;
	
	
	@Autowired
	private RefreshTokenDao refreshTokenDao;
	
	
	@Autowired
	private RedirectUriDao redirectUriDao;
	
	
	@Autowired
	private DeveloperCompanyAccountDao developerCompanyAccountDao;
	
	
	@Autowired
	private ServiceDao serviceDao;
	
	@Autowired
	private TrustedAppStatusDao trustedAppStatusDao;
	
	
	@Autowired
	private ServiceApiMethodDao serviceApiMethodDao;
	
	@Autowired
	private DeveloperCompanyDao developerCompanyDao;
	
	@Autowired
	private ServiceStatusDao serviceStatusDao;
	
	
	@Autowired
	private DeveloperCompanyStatusDao developerCompanyStatusDao;
	
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private ProfileDao profileDao;
	
	@Autowired
	private ProfileAclDao profileAclDao;
	
	@Autowired
	private PermissionSetDao permissionSetDao;
	
	@Autowired
	private SharingRuleDao sharingRuleDao;
	
	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	public VerificationDao getVerificationDao() {
		return verificationDao;
	}

	public void setVerificationDao(VerificationDao verificationDao) {
		this.verificationDao = verificationDao;
	}
	
	public PasswordResetDao getPasswordResetDao() {
		return passwordResetDao;
	}

	public void setPasswordResetDao(PasswordResetDao passwordResetDao) {
		this.passwordResetDao = passwordResetDao;
	}
	
	public AccountDataChangeDao getAccountDataChangeDao() {
		return accountDataChangeDao;
	}

	public void setAccountDataChangeDao(AccountDataChangeDao accountDataChangeDao) {
		this.accountDataChangeDao = accountDataChangeDao;
	}
	
	public ApiMethodDao getApiMethodDao() {
		return apiMethodDao;
	}

	public void setApiMethodDao(ApiMethodDao apiMethodDao) {
		this.apiMethodDao = apiMethodDao;
	}
	
	public DeveloperServiceDao getDeveloperServiceDao() {
		return developerServiceDao;
	}

	public void setDeveloperServiceDao(DeveloperServiceDao developerServiceDao) {
		this.developerServiceDao = developerServiceDao;
	}
	
	
	public TrustedAppDao getTrustedAppDao() {
		return trustedAppDao;
	}

	public void setTrustedAppDao(TrustedAppDao trustedAppDao) {
		this.trustedAppDao = trustedAppDao;
	}
	
	public AccountConsentDao getAccountConsentDao() {
		return accountConsentDao;
	}

	public void setAccountConsentDao(AccountConsentDao accountConsentDao) {
		this.accountConsentDao = accountConsentDao;
	}
	
	public SessionDao getSessionDao() {
		return sessionDao;
	}

	public void setSessionDao(SessionDao sessionDao) {
		this.sessionDao = sessionDao;
	}
	
	
	public RefreshTokenDao getRefreshTokenDao() {
		return refreshTokenDao;
	}

	public void setRefreshTokenDao(RefreshTokenDao refreshTokenDao) {
		this.refreshTokenDao = refreshTokenDao;
	}
	
	
	public RedirectUriDao getRedirectUriDao() {
		return redirectUriDao;
	}

	public void setRedirectUriDao(RedirectUriDao redirectUriDao) {
		this.redirectUriDao = redirectUriDao;
	}
	
	public DeveloperCompanyAccountDao getDeveloperCompanyAccountDao() {
		return developerCompanyAccountDao;
	}

	public void setDeveloperCompanyAccountDao(
			DeveloperCompanyAccountDao developerCompanyAccountDao) {
		this.developerCompanyAccountDao = developerCompanyAccountDao;
	}
	
	public ServiceDao getServiceDao() {
		return serviceDao;
	}

	public void setServiceDao(ServiceDao serviceDao) {
		this.serviceDao = serviceDao;
	}
	
	public TrustedAppStatusDao getTrustedAppStatusDao() {
		return trustedAppStatusDao;
	}

	public void setTrustedAppStatusDao(TrustedAppStatusDao trustedAppStatusDao) {
		this.trustedAppStatusDao = trustedAppStatusDao;
	}

	
	public ServiceApiMethodDao getServiceApiMethodDao() {
		return serviceApiMethodDao;
	}

	public void setServiceApiMethodDao(ServiceApiMethodDao serviceApiMethodDao) {
		this.serviceApiMethodDao = serviceApiMethodDao;
	}
	
	public DeveloperCompanyDao getDeveloperCompanyDao() {
		return developerCompanyDao;
	}

	public void setDeveloperCompanyDao(DeveloperCompanyDao developerCompanyDao) {
		this.developerCompanyDao = developerCompanyDao;
	}
	
	public ServiceStatusDao getServiceStatusDao() {
		return serviceStatusDao;
	}

	public void setServiceStatusDao(ServiceStatusDao serviceStatusDao) {
		this.serviceStatusDao = serviceStatusDao;
	}
	
	public DeveloperCompanyStatusDao getDeveloperCompanyStatusDao() {
		return developerCompanyStatusDao;
	}

	public void setDeveloperCompanyStatusDao(DeveloperCompanyStatusDao developerCompanyStatusDao) {
		this.developerCompanyStatusDao = developerCompanyStatusDao;
	}

	@Override
	public ServiceLicenseDao getServiceLicenseDao() {
		// TODO Auto-generated method stub
		return null;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public ProfileDao getProfileDao() {
		return profileDao;
	}

	public void setProfileDao(ProfileDao profileDao) {
		this.profileDao = profileDao;
	}

	public ProfileAclDao getProfileAclDao() {
		return profileAclDao;
	}

	public void setProfileAclDao(ProfileAclDao profileAclDao) {
		this.profileAclDao = profileAclDao;
	}

	public PermissionSetDao getPermissionSetDao() {
		return permissionSetDao;
	}

	public void setPermissionSetDao(PermissionSetDao permissionSetDao) {
		this.permissionSetDao = permissionSetDao;
	}

	public SharingRuleDao getSharingRuleDao() {
		return sharingRuleDao;
	}

	public void setSharingRuleDao(SharingRuleDao sharingRuleDao) {
		this.sharingRuleDao = sharingRuleDao;
	}
	
	@Autowired
	public InformationReleasesDao informationReleasesDao;

	public InformationReleasesDao getInformationReleasesDao() {
		return informationReleasesDao;
	}

	public void setInformationReleasesDao(InformationReleasesDao informationReleasesDao) {
		this.informationReleasesDao = informationReleasesDao;
	}
	
	
	
}
