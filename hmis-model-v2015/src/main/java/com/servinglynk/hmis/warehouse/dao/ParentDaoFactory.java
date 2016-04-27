package com.servinglynk.hmis.warehouse.dao;

import com.servinglynk.hmis.warehouse.base.dao.BaseDaoFactory;

public interface ParentDaoFactory extends BaseDaoFactory {
	
	BulkUploaderDao getBulkUploaderDao();
	DateofengagementDao getDateofengagementDao();
	ProjectDao getProjectDao();
	AffiliationDao getAffiliationDao();
	BedinventoryDao getBedinventoryDao();
	DisabilitiesDao getDisabilitiesDao();
	DomesticviolenceDao getDomesticviolenceDao();
	EmploymentDao getEmploymentDao();
	EnrollmentDao getEnrollmentDao();
	OrganizationDao getOrganizationDao();
	EnrollmentCocDao getEnrollmentCocDao();
	ExitDao getExitDao();
	ExithousingassessmentDao getExithousingassessmentDao();
	FunderDao getFunderDao();
	HealthinsuranceDao getHealthinsuranceDao();
	HealthStatusDao getHealthStatusDao();
	//HmisTypeDa getHmisTypeDao();
	HousingassessmentdispositionDao getHousingassessmentdispositionDao();
	IncomeandsourcesDao getIncomeandsourcesDao();
	InventoryDao getInventoryDao();
	MedicalassistanceDao getMedicalassistanceDao();
	NoncashbenefitsDao getNoncashbenefitsDao();
	PathstatusDao getPathstatusDao();
	ResidentialmoveindateDao getResidentialmoveindateDao();
	RhybcpstatusDao getRhybcpstatusDao();
	SiteDao getSiteDao();
	SourceDao getSourceDao();
	//SyncDao getSyncDao();
	ClientVeteranInfoDao getVeteranInfoDao();
	ExportDao getExportDao();
	ClientDao getClientDao();
	

	CocDao getCocDao();
	ContactDao getContactDao();
	EntryrhspDao getEntryrhspDao();
	EntryrhyDao getEntryrhyDao();
	EntryssvfDao getEntryssvfDao();
	ExitpathDao getExitpathDao();
	ExitrhyDao getExitrhyDao();
	ServiceFaReferralDao getServiceFaReferralDao();
}