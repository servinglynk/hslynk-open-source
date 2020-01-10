package com.servinglynk.hmis.warehouse.dao;

import com.servinglynk.hmis.warehouse.base.dao.BaseDaoFactory;
import com.servinglynk.hmis.warehouse.base.dao.BulkUploaderWorkerDao;

public interface ParentDaoFactory extends BaseDaoFactory {
	

	SyncListDao getSyncListDao();
	BulkUploaderDao getBulkUploaderDao();
	CommercialsexualexploitationDao getCommercialsexualexploitationDao();
	DateofengagementDao getDateofengagementDao();
	ProjectDao getProjectDao();
	ProjectcocDao getProjectcocDao();
	AffiliationDao getAffiliationDao();
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
	MedicalassistanceDao getMedicalassistanceDao();
	NoncashbenefitsDao getNoncashbenefitsDao();
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
	ExportDao getExportDao();
	OrganizationDao getOrganizationDao();
	ClientDao getClientDao();
	BulkUploadActivityDao getBulkUploadActivityDao();
	BulkUploadErrorDao getBulkUploadErrorDao();

	InformationReleasesDao getInformationReleasesDao();
	HmisTypeDao getHmisTypeDao();
	QuestionDao getQuestionDao();
	HistoryDao getHistoryDao();
	HmisHouseholdDao getHmisHouseholdDao();
}