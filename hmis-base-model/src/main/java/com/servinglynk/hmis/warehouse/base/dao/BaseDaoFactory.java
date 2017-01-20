package com.servinglynk.hmis.warehouse.base.dao;


public interface BaseDaoFactory {
	
	HmisUserDao getHmisUserDao();
	HmisOrganizationDao getHmisOrganizationDao();
	AccountDao getAccountDao();
	DeveloperCompanyDao getDeveloperCompanyDao() ;
	DeveloperServiceDao getDeveloperServiceDao() ;
	DeveloperCompanyAccountDao getDeveloperCompanyAccountDao();
	ServiceApiMethodDao getServiceApiMethodDao();
	ServiceDao getServiceDao();
	VerificationDao getVerificationDao();
	AccountDataChangeDao getAccountDataChangeDao();
	PasswordResetDao getPasswordResetDao();
	DeveloperCompanyStatusDao getDeveloperCompanyStatusDao();
	RoleDao getRoleDao();
	ProfileDao getProfileDao();
	ProfileAclDao getProfileAclDao();
	PermissionSetDao getPermissionSetDao();
	ProjectGroupDao getProjectGroupDao();
	ClientDao getHmisClientDao();
	BulkUploaderWorkerDao getBulkUploaderWorkerDao();
	SearchDao getSearchDao();
	ProjectDao getBaseProjectDao();
	HealthDao getHealthDao();	
	ClientConsentDao getClientConsentDao();
	ClientDataElementDao getClientDataElementDao();
}