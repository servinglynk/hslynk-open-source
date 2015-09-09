package com.servinglynk.hmis.warehouse.dao;


public interface ParentDaoFactory {
	
	HmisUserDao getHmisUserDao();
	SyncListDao getSyncListDao();
	BulkUploaderDao getBulkUploaderDao();
	CommercialsexualexploitationDao getCommercialsexualexploitationDao();
	DateofengagementDao getDateofengagementDao();
	ProjectDao getProjectDao();
	ProjectcocDao getProjectcocDao();
	AffiliationDao getAffiliationDao();
	BedinventoryDao getBedinventoryDao();
	ClientDao getClientDao();
	ConnectionwithsoarDao getConnectionwithsoarDao();
	DisabilitiesDao getDisabilitiesDao();
	DomesticviolenceDao getDomesticviolenceDao();
	EmploymentDao getEmploymentDao();
	EnrollmentDao getEnrollmentDao();
	EnrollmentCocDao getEnrollmentCocDao();
	ExitDao getExitDao();
	ExithousingassessmentDao getExithousingassessmentDao();
	ExitplansactionsDao getExitplansactionsDao();
	FamilyreunificationDao getFamilyreunificationDao();
	FormerwardchildwelfareDao getFormerwardchildwelfareDao();
	FormerwardjuvenilejusticeDao getFormerwardjuvenilejusticeDao();
	FunderDao getFunderDao();
	HealthinsuranceDao getHealthinsuranceDao();
	HealthStatusDao getHealthStatusDao();
	//HmisTypeDa getHmisTypeDao();
	HousingassessmentdispositionDao getHousingassessmentdispositionDao();
	IncomeandsourcesDao getIncomeandsourcesDao();
	InventoryDao getInventoryDao();
	LastgradecompletedDao getLastgradecompletedDao();
	LastPermAddressDao getLastPermAddressDao();
	LastpermanentaddressDao getLastpermanentaddressDao();
	MedicalassistanceDao getMedicalassistanceDao();
	NoncashbenefitsDao getNoncashbenefitsDao();
	OrganizationDao getOrganizationDao();
	PathstatusDao getPathstatusDao();
	PercentamiDao getPercentamiDao();
	ProjectcompletionstatusDao getProjectcompletionstatusDao();
	ReferralsourceDao getReferralsourceDao();
	ResidentialmoveindateDao getResidentialmoveindateDao();
	RhybcpstatusDao getRhybcpstatusDao();
	SchoolstatusDao getSchoolstatusDao();
	ServicesDao getServicesDao();
	SexualorientationDao getSexualorientationDao();
	SiteDao getSiteDao();
	SourceDao getSourceDao();
	//SyncDao getSyncDao();
	VeteranInfoDao getVeteranInfoDao();
	WorsthousingsituationDao getWorsthousingsituationDao();
	YouthcriticalissuesDao getYouthcriticalissuesDao();
	BulkUploaderWorkerDao getBulkUploaderWorkerDao();
	
	public AccountDao getAccountDao();
	public DeveloperCompanyDao getDeveloperCompanyDao() ;
	public DeveloperServiceDao getDeveloperServiceDao() ;
	public DeveloperCompanyAccountDao getDeveloperCompanyAccountDao();
	public ServiceLicenseDao getServiceLicenseDao() ;
	public ServiceApiMethodDao getServiceApiMethodDao();
	public ServiceDao getServiceDao();
	VerificationDao getVerificationDao();
	AccountDataChangeDao getAccountDataChangeDao();
	PasswordResetDao getPasswordResetDao();
	DeveloperCompanyStatusDao getDeveloperCompanyStatusDao();
	RoleDao getRoleDao();
	ProfileDao getProfileDao();
	ProfileAclDao getProfileAclDao();
	PermissionSetDao getPermissionSetDao();
	SharingRuleDao getSharingRuleDao();

}