package com.servinglynk.hmis.warehouse.base.dao;


public interface BaseDaoFactory {
	
	HmisUserDao getHmisUserDao();
<<<<<<< HEAD
//	OrganizationDao getOrganizationDao();
=======
	HmisOrganizationDao getHmisOrganizationDao();
>>>>>>> 3bf05a6b14d0b51d692f3bd28ca2bd3e2b149099
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
	ClientDao getClientDao();

}