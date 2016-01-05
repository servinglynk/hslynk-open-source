package com.servinglynk.hmis.warehouse.service;

import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.ApiGroup;
import com.servinglynk.hmis.warehouse.core.model.ApiMethods;
import com.servinglynk.hmis.warehouse.core.model.DeveloperCompanies;
import com.servinglynk.hmis.warehouse.core.model.DeveloperCompany;
import com.servinglynk.hmis.warehouse.core.model.DeveloperCompanyAccounts;
import com.servinglynk.hmis.warehouse.core.model.DeveloperService;
import com.servinglynk.hmis.warehouse.core.model.DeveloperServices;
import com.servinglynk.hmis.warehouse.core.model.ServiceStatus;
import com.servinglynk.hmis.warehouse.core.model.DeveloperCompanyStatus;

public interface DeveloperCompanyService {

	public DeveloperCompany createDeveloperCompany(DeveloperCompany developerCompany, String requestingService);
	public void updateDeveloperCompany(String externalDeveloperCompanyId, DeveloperCompany developerCompany, Account requestingAccount, String requestingService);
	
	public com.servinglynk.hmis.warehouse.core.model.DeveloperCompanyAccount associateAccountAndDeveloperCompany(String externalDeveloperCompanyId, 
			com.servinglynk.hmis.warehouse.core.model.DeveloperCompanyAccount developerAccount, 
			  Account requestingAccount, 
			  String requestingService);
	
	public com.servinglynk.hmis.warehouse.core.model.DeveloperCompanyAccount dissociateAccountAndDeveloperCompany(String externalDeveloperCompanyId, 
			   String username, 
			   Account requestingAccount, 
			   String requestingService);
	
	public DeveloperCompany deleteDeveloperCompany(String externalDeveloperCompanyId, Account requestingAccount, String requestingService);
	
	public DeveloperCompany getDeveloperCompany(String externalDeveloperCompanyId, Account requestingAccount, String requestingService);
	
	
	public DeveloperService addNewService(String externalDeveloperCompanyId,
			DeveloperService service,
							  Account requestingAccount, 
							  String requestingService) ;
	
	public DeveloperService updateService(String externalServiceId,
			  DeveloperService service,
			  Account requestingAccount, 
			  String requestingService);
	
	public DeveloperService deleteService(String externalServiceId, 
			 Account requestingAccount,
			 String requestingService);
	
	public void createApiBundleForService(String externalServiceId, ApiMethods apiBundle, Account requestingAccount, String requestingService);
	
	public ServiceStatus processApprovalDecision(String externalServiceId,ServiceStatus serviceStatus,  Account requestingAccount, String requestingService);
	
	public ServiceStatus processApprovalSubmission(String externalServiceId,ServiceStatus serviceStatus, Account requestingAccount, String requestingService);
	
	public DeveloperCompanyAccounts getDeveloperCompanyAccounts(String externalDeveloperCompanyId, Account requestingAccount, String requestingService);
	public DeveloperServices getServices(String externalDeveloperCompanyId, Account requestingAccount, int startIndex, int maxItems, String requestingService);
	public DeveloperCompanies getAllDeveloperCompanies(String username, String serviceStatus, String trustedAppStatus,Integer startIndex, Integer maxItems, String requestingService);
	public DeveloperService getService(String externalServiceId,Account requestingAccount, String requestingService);

	
	public DeveloperCompanyStatus processDCApprovalDecision(String developerCompanyId,DeveloperCompanyStatus developerCompanyStatus,  Account requestingAccount, String requestingService);
	
	
	public DeveloperCompanies getOwnedDeveloperCompanies(String username,Account requestingAccount,String requestingService);
	
	public List<ApiGroup> getApiGroupsForService(String externalServiceId, Account requestingAccount, String requestingService);
}
