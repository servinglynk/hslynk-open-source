package com.servinglynk.hmis.warehouse.base.dao;


public interface BaseDaoFactory {
	
	HmisUserDao getHmisUserDao();
//	OrganizationDao getOrganizationDao();
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

}