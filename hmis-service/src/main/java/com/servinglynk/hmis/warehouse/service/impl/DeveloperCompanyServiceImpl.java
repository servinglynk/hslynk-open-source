package com.servinglynk.hmis.warehouse.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.client.notificationservice.NotificationServiceClient;
import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.common.GeneralUtil;
import com.servinglynk.hmis.warehouse.common.ValidationBean;
import com.servinglynk.hmis.warehouse.common.ValidationUtil;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.ApiGroup;
import com.servinglynk.hmis.warehouse.core.model.ApiMethod;
import com.servinglynk.hmis.warehouse.core.model.ApiMethods;
import com.servinglynk.hmis.warehouse.core.model.DeveloperCompanies;
import com.servinglynk.hmis.warehouse.core.model.DeveloperCompany;
import com.servinglynk.hmis.warehouse.core.model.DeveloperCompanyAccounts;
import com.servinglynk.hmis.warehouse.core.model.DeveloperCompanyStatus;
import com.servinglynk.hmis.warehouse.core.model.DeveloperService;
import com.servinglynk.hmis.warehouse.core.model.DeveloperServices;
import com.servinglynk.hmis.warehouse.core.model.Notification;
import com.servinglynk.hmis.warehouse.core.model.Parameter;
import com.servinglynk.hmis.warehouse.core.model.Parameters;
import com.servinglynk.hmis.warehouse.core.model.Recipients;
import com.servinglynk.hmis.warehouse.core.model.ServiceStatus;
import com.servinglynk.hmis.warehouse.core.model.exception.AccessDeniedException;
import com.servinglynk.hmis.warehouse.core.model.exception.IllegalBusinessStateException;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidParameterException;
import com.servinglynk.hmis.warehouse.core.model.exception.MissingParameterException;
import com.servinglynk.hmis.warehouse.model.live.ApiGroupEntity;
import com.servinglynk.hmis.warehouse.model.live.ApiMethodEntity;
import com.servinglynk.hmis.warehouse.model.live.DeveloperCompanyAccountEntity;
import com.servinglynk.hmis.warehouse.model.live.DeveloperCompanyEntity;
import com.servinglynk.hmis.warehouse.model.live.DeveloperServiceEntity;
import com.servinglynk.hmis.warehouse.model.live.HmisUser;
import com.servinglynk.hmis.warehouse.model.live.ServiceApiMethodEntity;
import com.servinglynk.hmis.warehouse.model.live.ServiceEntity;
import com.servinglynk.hmis.warehouse.service.DeveloperCompanyService;
import com.servinglynk.hmis.warehouse.service.converter.AccountConverter;
import com.servinglynk.hmis.warehouse.service.converter.ApiGroupConverter;
import com.servinglynk.hmis.warehouse.service.converter.ApiMethodConverter;
import com.servinglynk.hmis.warehouse.service.converter.DeveloperCompanyConverter;
import com.servinglynk.hmis.warehouse.service.converter.DeveloperServiceConverter;
import com.servinglynk.hmis.warehouse.service.exception.AccountNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ApiMethodNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.DeveloperCompanyAccountAlreadyExistsException;
import com.servinglynk.hmis.warehouse.service.exception.DeveloperCompanyAccountNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.DeveloperCompanyNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.DeveloperCompanyOwnerDissociationNotAllowedException;
import com.servinglynk.hmis.warehouse.service.exception.DuplicateDataException;
import com.servinglynk.hmis.warehouse.service.exception.InvalidApiMethodException;
import com.servinglynk.hmis.warehouse.service.exception.ServiceAlreadyExistsException;
import com.servinglynk.hmis.warehouse.service.exception.ServiceNotFoundException;

public class DeveloperCompanyServiceImpl extends ServiceBase implements DeveloperCompanyService {

	protected String dcPassword;

	public String getDcPassword() {
		return dcPassword;
	}

	public void setDcPassword(String dcPassword) {
		this.dcPassword = dcPassword;
	}
	
	@Autowired
	NotificationServiceClient notificationServiceClient;

	@Autowired
	protected ValidationBean validationBean;

	@Transactional
	public DeveloperCompany createDeveloperCompany(DeveloperCompany developerCompany, String requestingService) {

		com.servinglynk.hmis.warehouse.model.live.HmisUser account = daoFactory.getAccountDao()
				.findByUsername(developerCompany.getOwner().getUsername());

		if (account == null) {
			/*account = AccountConverter.convertToPersistentAccount(developerCompany.getOwner(), null);
			account.setStatus(ACCOUNT_STATUS_ACTIVE);
			account.setPassword(HMISCryptographer.Encrypt(developerCompany.getOwner().getPassword()));
			account.setCreatedBy(requestingService);

			daoFactory.getAccountDao().createAccount(account);*/
			
			throw new AccountNotFoundException();
		}

		com.servinglynk.hmis.warehouse.model.live.DeveloperCompanyEntity pDeveloperCompany = DeveloperCompanyConverter
				.convertToPersistentDeveloperCompany(developerCompany, null);

		pDeveloperCompany.setCreatedBy(requestingService);
		pDeveloperCompany.setExternalId(GeneralUtil.getNewGuid());
		pDeveloperCompany.setAccount(account);
		pDeveloperCompany.setStatus(Constants.DC_STATUS_SUBMITTED);

		daoFactory.getDeveloperCompanyDao().createDeveloperCompany(pDeveloperCompany);

		com.servinglynk.hmis.warehouse.model.live.DeveloperCompanyStatus pDeveloperCompanyStatus = new com.servinglynk.hmis.warehouse.model.live.DeveloperCompanyStatus();
		pDeveloperCompanyStatus.setStatus(Constants.DC_STATUS_SUBMITTED);

		pDeveloperCompanyStatus.setDeveloperCompany(pDeveloperCompany);
		pDeveloperCompanyStatus.setCreatedBy(requestingService);
	//	daoFactory.getDeveloperCompanyDao().createDeveloperCompanyStatus(pDeveloperCompanyStatus);

		DeveloperCompanyAccountEntity pDevAccount = new DeveloperCompanyAccountEntity();
		pDevAccount.setAccount(account);
		pDevAccount.setCreatedBy(requestingService);
		pDevAccount.setDeveloperCompany(pDeveloperCompany);
		if(developerCompany.getOwner()==null){
			pDevAccount.setRole(Constants.DEVELOPER_ACCOUNT_ROLE_BASIC);
		}else{
			pDevAccount.setRole(Constants.DEVELOPER_ACCOUNT_ROLE_ADMIN);
		}
		
		daoFactory.getDeveloperCompanyAccountDao().create(pDevAccount);

		developerCompany.setDeveloperCompanyId(pDeveloperCompany.getExternalId());
		developerCompany.setStatus(pDeveloperCompany.getStatus());
		
		HmisUser superAdminUser = daoFactory.getAccountDao().findByUsername("superadmin@hmis.com");
		
		Notification notification = new Notification();
		notification.setMethod("EMAIL");
		notification.setType("HMIS_DEVELOPER_COMPANY_CREATION");
		Recipients recipients = new Recipients();
		recipients.addToRecipient(superAdminUser.getEmailAddress());
		notification.setRecipients(recipients);
		
		Parameters parameters = new Parameters();
		parameters.addParameter(new Parameter("developerCompany",developerCompany.getName() ));
		notification.setParameters(parameters);
		
		notificationServiceClient.createNotification(notification);
		
		return developerCompany;
	}

	@Transactional
	public void updateDeveloperCompany(String externalDeveloperCompanyId, DeveloperCompany developerCompany,
			Account requestingAccount, String requestingService) {
		com.servinglynk.hmis.warehouse.model.live.DeveloperCompanyEntity pDeveloperCompany = daoFactory
				.getDeveloperCompanyDao().findByExternalId(externalDeveloperCompanyId);

		if (pDeveloperCompany == null) {
			throw new DeveloperCompanyNotFoundException(
					"DeveloperCompany " + externalDeveloperCompanyId + " not found");
		}

		pDeveloperCompany = DeveloperCompanyConverter.convertSimpleToPersistentDeveloperCompany(developerCompany,
				pDeveloperCompany);
		pDeveloperCompany.setModifiedBy(requestingService);

		if (pDeveloperCompany.getStatus().equals(Constants.DC_STATUS_REJECTED))
			pDeveloperCompany.setStatus(Constants.DC_STATUS_SUBMITTED);

		daoFactory.getDeveloperCompanyDao().updateDeveloperCompany(pDeveloperCompany);

	}

	@Transactional
	public com.servinglynk.hmis.warehouse.core.model.DeveloperCompanyAccount associateAccountAndDeveloperCompany(
			String externalDeveloperCompanyId,
			com.servinglynk.hmis.warehouse.core.model.DeveloperCompanyAccount developerAccount,
			Account requestingAccount, String requestingService) {

		logger.debug("associateAccountAndDeveloperCompany called");

		if ((developerAccount.getAccount() == null)
				|| StringUtils.isBlank(developerAccount.getAccount().getUsername())) {
			throw new MissingParameterException("account info missing");
		}

		DeveloperCompanyEntity pDeveloperCompany = daoFactory.getDeveloperCompanyDao()
				.findByExternalId(externalDeveloperCompanyId);

		if (pDeveloperCompany == null) {
			throw new DeveloperCompanyNotFoundException(
					"DeveloperCompany " + externalDeveloperCompanyId + " not found");
		}

		com.servinglynk.hmis.warehouse.model.live.HmisUser pAccount = daoFactory.getAccountDao()
				.findByUsername(developerAccount.getAccount().getUsername());

		if (pAccount == null) {
			throw new AccountNotFoundException(developerAccount.getAccount().getUsername() + " not found");
		}

		DeveloperCompanyAccountEntity dca = daoFactory.getDeveloperCompanyAccountDao()
				.findByDeveloperCompanyIdAndAccountUsername(pDeveloperCompany.getId(),
						developerAccount.getAccount().getUsername());

		if (dca != null) {
			throw new DeveloperCompanyAccountAlreadyExistsException(
					"username " + developerAccount.getAccount().getUsername() + " already associated to "
							+ pDeveloperCompany.getName());
		}

		DeveloperCompanyAccountEntity pDeveloperAccount = new DeveloperCompanyAccountEntity();
		pDeveloperAccount.setCreatedBy(requestingService);
		pDeveloperAccount.setAccount(pAccount);
		pDeveloperAccount.setDeveloperCompany(pDeveloperCompany);
		
		if( !developerAccount.isOwner()) {
			pDeveloperAccount.setRole(Constants.DEVELOPER_ACCOUNT_ROLE_BASIC);
		}else{
			pDeveloperAccount.setRole(Constants.DEVELOPER_ACCOUNT_ROLE_ADMIN);
		}
		
		daoFactory.getDeveloperCompanyAccountDao().create(pDeveloperAccount);

		return new com.servinglynk.hmis.warehouse.core.model.DeveloperCompanyAccount();
	}

	@Transactional
	public com.servinglynk.hmis.warehouse.core.model.DeveloperCompanyAccount dissociateAccountAndDeveloperCompany(
			String externalDeveloperCompanyId, String username, Account requestingAccount, String requestingService) {

		logger.debug("dissociateAccountAndDeveloperCompany called");

		DeveloperCompanyEntity pDeveloperCompany = daoFactory.getDeveloperCompanyDao()
				.findByExternalId(externalDeveloperCompanyId);

		if (pDeveloperCompany == null) {
			throw new DeveloperCompanyNotFoundException(
					"DeveloperCompany " + externalDeveloperCompanyId + " not found");
		}

		com.servinglynk.hmis.warehouse.model.live.HmisUser pAccount = daoFactory.getAccountDao()
				.findByUsername(username);

		if (pAccount == null) {
			throw new AccountNotFoundException(username + " not found");
		}

		DeveloperCompanyAccountEntity dca = daoFactory.getDeveloperCompanyAccountDao()
				.findByDeveloperCompanyIdAndAccountUsername(pDeveloperCompany.getId(), requestingAccount.getUsername());

		// Need to implement, check role validation 

		if (dca == null) {
			throw new DeveloperCompanyAccountNotFoundException(
					"username " + username + " is not associated to " + pDeveloperCompany.getName());
		}

		if (pDeveloperCompany.getAccount().getId() == pAccount.getId()) {
			throw new DeveloperCompanyOwnerDissociationNotAllowedException(
					"username " + username + " is the owner of " + pDeveloperCompany.getName());
		}

		daoFactory.getDeveloperCompanyAccountDao().deleteCompanyAccount(dca);

		return new com.servinglynk.hmis.warehouse.core.model.DeveloperCompanyAccount();
	}

	@Transactional
	public DeveloperCompany deleteDeveloperCompany(String externalDeveloperCompanyId, Account requestingAccount,
			String requestingService) {
		DeveloperCompanyEntity pDeveloperCompany = daoFactory.getDeveloperCompanyDao()
				.findByExternalId(externalDeveloperCompanyId);
		DeveloperCompany developerCompany = null;
		if (pDeveloperCompany != null) {

			developerCompany = new DeveloperCompany();
			developerCompany.setDeveloperCompanyId(externalDeveloperCompanyId);

			daoFactory.getDeveloperCompanyDao().deleteDeveloperCompany(pDeveloperCompany);
			logger.debug("developerCompany {} deleted", externalDeveloperCompanyId);
		} else {
			logger.debug("developerCompany {} is not found for deletion", externalDeveloperCompanyId);
			throw new DeveloperCompanyNotFoundException(
					"DeveloperCompany " + externalDeveloperCompanyId + " not found");
		}
		return developerCompany;
	}

	@Transactional
	public DeveloperCompany getDeveloperCompany(String externalDeveloperCompanyId, Account requestingAccount,
			String requestingService) {
		logger.debug("getDeveloperCompany called");

		com.servinglynk.hmis.warehouse.model.live.DeveloperCompanyEntity pDeveloperCompany = daoFactory
				.getDeveloperCompanyDao().findByExternalId(externalDeveloperCompanyId);

		if (pDeveloperCompany == null) {
			throw new DeveloperCompanyNotFoundException(
					"DeveloperCompany " + externalDeveloperCompanyId + " not found");
		}

		DeveloperCompany developerCompany = DeveloperCompanyConverter.convertToDeveloperCompany(pDeveloperCompany);

		return developerCompany;
	}

	@Transactional
	public DeveloperService addNewService(String externalDeveloperCompanyId, DeveloperService service,
			Account requestingAccount, String requestingService) {

		logger.debug("createService called");

		DeveloperCompanyEntity pDeveloperCompany = daoFactory.getDeveloperCompanyDao()
				.findByExternalId(externalDeveloperCompanyId);

		if (pDeveloperCompany == null) {
			throw new DeveloperCompanyNotFoundException(
					"DeveloperCompany " + externalDeveloperCompanyId + " not found");
		}

		if (StringUtils.isBlank(service.getFriendlyName())) {
			throw new MissingParameterException("Friendly name is missing");
		}

		if (StringUtils.isBlank(service.getLicenseType())) {
			throw new MissingParameterException("License type is missing");
		}

		
		  if(!ValidationUtil.isValidMaxLen(service.getFriendlyName() ,
		  validationBean.getMaxLength())){ throw new InvalidParameterException(
		  "Friendly Name can not be greater than 256 characters."); }
		 
		if (!ValidationUtil.isValidMaxLen(service.getDescription(), 512)) {
			throw new InvalidParameterException("Description can not be greater than 512 characters.");
		}

	
		DeveloperServiceEntity dbService = daoFactory.getDeveloperServiceDao()
				.findByFriendlyName(service.getFriendlyName());
		if (dbService != null)
			throw new ServiceAlreadyExistsException("serivce already exists");

		DeveloperServiceEntity pService = DeveloperServiceConverter.convertToPersistentService(service, null);
		pService.setExternalId(GeneralUtil.getNewGuid());
		pService.setCreatedBy(requestingService);
		pService.setDeveloperCompany(pDeveloperCompany);
		pService.setStatus(Constants.SERVICE_STATUS_IN_DEVELOPMENT);

		daoFactory.getDeveloperServiceDao().create(pService);

		service.setServiceId(pService.getExternalId());
		return service;
	}

	@Transactional
	public DeveloperService updateService(String externalServiceId, DeveloperService service, Account requestingAccount,
			String requestingService) {

		logger.debug("updateService called");

		com.servinglynk.hmis.warehouse.model.live.DeveloperServiceEntity pService = daoFactory.getDeveloperServiceDao()
				.findByExternalId(externalServiceId);
		if (pService == null) {
			throw new ServiceNotFoundException("Service " + externalServiceId + " not found");
		}

		// Need to implement, check role access permissions

		if (!Constants.SERVICE_STATUS_IN_DEVELOPMENT.equals(pService.getStatus())) {
			throw new AccessDeniedException(
					"Service status is " + pService.getStatus() + ", only IN_DEVELOPMENT services can be updated");
		}

		
		  if(!ValidationUtil.isValidMaxLen(service.getFriendlyName() ,
		  validationBean.getMaxLength())){ throw new InvalidParameterException(
		  "Friendly Name can not be greater than 256 characters."); }
		 
		if (!ValidationUtil.isValidMaxLen(service.getDescription(), 512)) {
			throw new InvalidParameterException("Description can not be greater than 512 characters.");
		}

		if (!ValidationUtil.isEmpty(service.getFriendlyName())) {
			if (!pService.getFriendlyName().equalsIgnoreCase(service.getFriendlyName())) {
				com.servinglynk.hmis.warehouse.model.live.DeveloperServiceEntity dbService = daoFactory
						.getDeveloperServiceDao().findByFriendlyName(service.getFriendlyName());
				if (dbService != null)
					throw new ServiceAlreadyExistsException("serivce already exists");
			}
		}

		pService = DeveloperServiceConverter.convertToPersistentService(service, pService);
		pService.setModifiedBy(requestingService);

		daoFactory.getDeveloperServiceDao().updateService(pService);

		service.setServiceId(pService.getExternalId());

		return DeveloperServiceConverter.convertToService(pService);
	}

	@Transactional
	public DeveloperService deleteService(String externalServiceId, Account requestingAccount,
			String requestingService) {
		logger.debug("deleteService called");

		DeveloperServiceEntity pService = daoFactory.getDeveloperServiceDao()
				.findByExternalId(externalServiceId);
		if (pService == null) {
			throw new ServiceNotFoundException("Service " + externalServiceId + " not found");
		}

		// Need to implement, check role access permissions
		
		if (!Constants.SERVICE_STATUS_IN_DEVELOPMENT.equals(pService.getStatus())) {
			throw new AccessDeniedException(
					"Service status is " + pService.getStatus() + ", only IN_DEVELOPMENT services can be deleted");
		}

		if (pService.getTrustedApps().size() > 0) {
			throw new AccessDeniedException(
					"Service " + externalServiceId + " is assigned to trustedApps. Cannot remove");
		}

		// delete api mappings
		 daoFactory.getServiceApiMethodDao().deleteByServiceId(pService.getId());
		 
			int deletedCount = daoFactory.getServiceApiMethodDao().deleteApiMethodsByServiceId(pService.getId());
			logger.debug("{} service api methods wiped out from service {}", deletedCount, externalServiceId);

		// finally delete the service itself
		daoFactory.getDeveloperServiceDao().deleteService(pService);

		DeveloperService result = new DeveloperService();
		result.setServiceId(externalServiceId);

		return result;
	}

	@Transactional
	public ServiceStatus processApprovalSubmission(String externalServiceId, ServiceStatus serviceStatus,
			Account requestingAccount, String requestingService) {

		com.servinglynk.hmis.warehouse.model.live.DeveloperServiceEntity pService = daoFactory.getDeveloperServiceDao()
				.findByExternalId(externalServiceId);
		if (pService == null) {
			throw new ServiceNotFoundException("Service " + externalServiceId + " not found");
		}
		
		// Need to implement, check role permissions

		if (!Constants.SERVICE_STATUS_IN_DEVELOPMENT.equals(pService.getStatus())) {
			throw new IllegalBusinessStateException("Service status is " + pService.getStatus()
					+ ", only IN_DEVELOPMENT services can be submitted for approval");
		}

		// validateCommentLength(serviceStatus.getComment());
		com.servinglynk.hmis.warehouse.model.live.ServiceStatus pServiceStatus = new com.servinglynk.hmis.warehouse.model.live.ServiceStatus();
		pServiceStatus.setStatus(Constants.SERVICE_STATUS_SUBMITTED);
		serviceStatus.setStatus(Constants.SERVICE_STATUS_SUBMITTED);
		pServiceStatus.setComments(serviceStatus.getComment());
		pServiceStatus.setService(pService);
		pServiceStatus.setCreatedBy(requestingService);
		daoFactory.getServiceStatusDao().create(pServiceStatus);

		pService.setStatus(Constants.SERVICE_STATUS_SUBMITTED);
		pService.setModifiedBy(requestingService);
		pService.setModifiedAt(new Date());
		daoFactory.getDeveloperServiceDao().updateService(pService);

		HmisUser superAdminUser = daoFactory.getAccountDao().findByUsername("superadmin@hmis.com");
		
		Notification notification = new Notification();
		notification.setMethod("EMAIL");
		notification.setType("HMIS_DEVELOPER_SERVICE_CREATION");
		Recipients recipients = new Recipients();
		recipients.addToRecipient(superAdminUser.getEmailAddress());
		notification.setRecipients(recipients);
		
		Parameters parameters = new Parameters();
		parameters.addParameter(new Parameter("developerService",pService.getFriendlyName() ));
		notification.setParameters(parameters);
		
		notificationServiceClient.createNotification(notification);


		return DeveloperServiceConverter.convertToService(pServiceStatus);
	}

	@Transactional
	public ServiceStatus processApprovalDecision(String externalServiceId, ServiceStatus serviceStatus,
			Account requestingAccount, String requestingService) {

		// Check permission

		if (ValidationUtil.isEmpty(serviceStatus.getStatus()))
			throw new MissingParameterException("Status is missing");

		
		  if(!(serviceStatus.getStatus().equals(Constants.
		  SERVICE_STATUS_IN_DEVELOPMENT) ||
		  serviceStatus.getStatus().equals(Constants.SERVICE_STATUS_ACTIVE)))
		  throw new InvalidParameterException("Not a valid status");
		 
		com.servinglynk.hmis.warehouse.model.live.DeveloperServiceEntity pService = daoFactory.getDeveloperServiceDao()
				.findByExternalId(externalServiceId);
		if (pService == null) {
			throw new ServiceNotFoundException("Service " + externalServiceId + " not found");
		}

		if (!Constants.SERVICE_STATUS_SUBMITTED.equals(pService.getStatus())) {
			throw new IllegalBusinessStateException(
					"Service status is " + pService.getStatus() + ", only SUBMITTED services can be approved");
		}


		com.servinglynk.hmis.warehouse.model.live.ServiceStatus pServiceStatus = new com.servinglynk.hmis.warehouse.model.live.ServiceStatus();
		pServiceStatus.setStatus(serviceStatus.getStatus());
		pServiceStatus.setComments(serviceStatus.getComment());
		pServiceStatus.setService(pService);
		pServiceStatus.setCreatedBy(requestingService);
		daoFactory.getServiceStatusDao().create(pServiceStatus);

		pService.setStatus(serviceStatus.getStatus());
		pService.setModifiedBy(requestingService);
		pService.setModifiedAt(new Date());
		daoFactory.getDeveloperServiceDao().updateService(pService);

		// notify owner of the developer company

		serviceStatus.setStatus(pServiceStatus.getStatus());

		return DeveloperServiceConverter.convertToService(pServiceStatus);
	}

	@Transactional
	public void createApiBundleForService(String externalServiceId, ApiMethods apiBundle, Account requestingAccount,
			String requestingService) {
		logger.debug("createApiBundleForService called");

		com.servinglynk.hmis.warehouse.model.live.DeveloperServiceEntity pService = daoFactory.getDeveloperServiceDao()
				.findByExternalId(externalServiceId);
		if (pService == null) {
			throw new ServiceNotFoundException("Service " + externalServiceId + " not found");
		}

		com.servinglynk.hmis.warehouse.model.live.DeveloperCompanyEntity pDeveloperCompany = pService.getDeveloperCompany();

		DeveloperCompanyAccountEntity dca = daoFactory.getDeveloperCompanyAccountDao()
				.findByDeveloperCompanyIdAndAccountUsername(pDeveloperCompany.getId(), requestingAccount.getUsername());

		if ((dca == null) || !Constants.DEVELOPER_ACCOUNT_ROLE_ADMIN.equals(dca.getRole())) {
			throw new AccessDeniedException("Only admins can create/edit service/api mappings");
		}

		if (!Constants.SERVICE_STATUS_IN_DEVELOPMENT.equals(pService.getStatus())) {
			throw new AccessDeniedException(
					"Service status is " + pService.getStatus() + ", only IN_DEVELOPMENT services can be updated");
		}

		// delete all service api methods first
		int deletedCount = daoFactory.getServiceApiMethodDao().deleteByServiceId(pService.getId());
		logger.debug("{} service api methods wiped out from service {}", deletedCount, externalServiceId);

		// Check for apimethods duplicates
		List<String> apiMethodList = new ArrayList<String>();
		for (com.servinglynk.hmis.warehouse.core.model.ApiMethod apiMethod : apiBundle.getApiMethods()) {
			if (!ValidationUtil.isEmpty(apiMethod.getApiMethodId())) {
				if (!apiMethodList.contains(apiMethod.getApiMethodId())) {
					apiMethodList.add(apiMethod.getApiMethodId());
				} else {
					throw new DuplicateDataException("duplicate apimethod submitted");
				}
			} else {
				throw new InvalidApiMethodException("apimethod Id can not be null");
			}

		}

		Iterator<String> itApiMethodList = apiMethodList.iterator();
		String apiId = null;
		while (itApiMethodList.hasNext()) {
			apiId = itApiMethodList.next();
			ApiMethodEntity pApiMethod = daoFactory.getApiMethodDao().findByExternalId(apiId);

			if (pApiMethod == null) {
				throw new ApiMethodNotFoundException("api " + apiId + " not found");
			}

			ServiceApiMethodEntity pServiceApiMethod = new ServiceApiMethodEntity();
			pServiceApiMethod.setApiMethod(pApiMethod);
			pServiceApiMethod.setCreatedBy(requestingService);
			pServiceApiMethod.setService(pService);

			daoFactory.getServiceApiMethodDao().create(pServiceApiMethod);
		}

		logger.debug("{} service api methods added to service {}", apiBundle.getApiMethods().size(), externalServiceId);
	}
	
	
	@Transactional
	public List<ApiGroup> getApiGroupsForService(String externalServiceId, Account requestingAccount, String requestingService)	{

		ServiceEntity pService = daoFactory.getServiceDao().findByExternalId(externalServiceId);
		if (pService == null)	{
			throw new ServiceNotFoundException("Service " + externalServiceId + " not found");
		}
			 		
		if ((pService.getServiceApiMethods() == null) || pService.getServiceApiMethods().isEmpty())	{
			logger.debug("service {} has no api methods assigned, return empty api groups", externalServiceId);
			return new ArrayList<ApiGroup>();
		}
		
		return groupServiceApiMethods(pService.getServiceApiMethods(), requestingAccount, requestingService);
	}

	private List<ApiGroup> groupServiceApiMethods(List<?> apiMethods, Account requestingAccount, String requestingService)	{
		
		if ((apiMethods == null) || apiMethods.isEmpty())	{
			logger.debug("no api methods provided, return empty api groups");
			return new ArrayList<ApiGroup>();
		}
		
		Map<UUID, ApiGroup> apiGroupsMap = new HashMap<UUID, ApiGroup>();
		Map<UUID, Map<UUID, ApiMethod>> apiMethodsGroupMap = 
				new HashMap<UUID, Map<UUID,ApiMethod>>();
		
		// go over the list of api methods and group them under their own apiGroups in maps
		for(Object apiMethodObj : apiMethods)	{ 
			ApiMethodEntity pApiMethod = null;
			
			// The list of methods passed might be of type ApiMethods directly or ServiceApiMethods
			if (apiMethodObj instanceof ServiceApiMethodEntity)	{
				pApiMethod = ((ServiceApiMethodEntity) apiMethodObj).getApiMethod();
			}
			else if (apiMethodObj instanceof ApiMethodEntity)	{
				pApiMethod = (ApiMethodEntity) apiMethodObj; 
			}
			
			ApiGroupEntity pApiGroup = pApiMethod.getApiGroup();
			if (pApiGroup == null)	{
				logger.warn("api-method {}'s api-group is null, shouldn't be", pApiMethod.getId());
			}
			else	{
				if (!apiGroupsMap.containsKey(pApiGroup.getId()))	{
					ApiGroup apiGroup = ApiGroupConverter.convertToApiGroup(pApiGroup);
					apiGroupsMap.put(pApiGroup.getId(), apiGroup);
				}
				
				Map<UUID,ApiMethod> apiMethodsMap = apiMethodsGroupMap.get(pApiGroup.getId());
				if (apiMethodsMap == null)	{
					apiMethodsMap = new HashMap<UUID,ApiMethod>();
					apiMethodsGroupMap.put(pApiGroup.getId(), apiMethodsMap);
				}
				
				if (!apiMethodsMap.containsKey(pApiMethod.getId()))	{
					ApiMethod apiMethod = ApiMethodConverter.convertToApiMethod(pApiMethod);
					apiMethodsMap.put(pApiMethod.getId(), apiMethod);
				}
			}
		}
		
		List<ApiGroup> apiGroups = new ArrayList<ApiGroup>();
		
		// build List<ApiGroup> from the maps
		for(Map.Entry<UUID, ApiGroup> entry : apiGroupsMap.entrySet())	{
			ApiGroup apiGroup = entry.getValue();
			apiGroup.setApiMethods(new ArrayList<ApiMethod>());
			
			Map<UUID, ApiMethod> apiMethodsMap = apiMethodsGroupMap.get(entry.getKey());

			apiGroup.setApiMethods(new ArrayList<ApiMethod>(apiMethodsMap.values()));
			
			apiGroups.add(apiGroup);
		}
		
		return apiGroups; 
	}
	

	@Transactional
	public DeveloperCompanyAccounts getDeveloperCompanyAccounts(String externalDeveloperCompanyId,
			Account requestingAccount, String requestingService) {
		logger.debug("getDeveloperCompanyAccounts called");

		com.servinglynk.hmis.warehouse.model.live.DeveloperCompanyEntity pDeveloperCompany = daoFactory
				.getDeveloperCompanyDao().findByExternalId(externalDeveloperCompanyId);

		if (pDeveloperCompany == null) {
			throw new DeveloperCompanyNotFoundException(
					"DeveloperCompany " + externalDeveloperCompanyId + " not found");
		}
		
		// Check permisssions

		List<DeveloperCompanyAccountEntity> pDeveloperAccounts = daoFactory.getDeveloperCompanyAccountDao()
				.findByDeveloperCompanyId(pDeveloperCompany.getId());
		List<com.servinglynk.hmis.warehouse.core.model.DeveloperCompanyAccount> developerAccounts = new ArrayList<com.servinglynk.hmis.warehouse.core.model.DeveloperCompanyAccount>();

		for (DeveloperCompanyAccountEntity pDeveloperCompanyAccount : pDeveloperAccounts) {
			com.servinglynk.hmis.warehouse.core.model.DeveloperCompanyAccount developerAccount = new com.servinglynk.hmis.warehouse.core.model.DeveloperCompanyAccount();
			developerAccount.setAccount(AccountConverter.convertToBasicAccount(pDeveloperCompanyAccount.getAccount()));
			developerAccount.getAccount().setUsername(pDeveloperCompanyAccount.getAccount().getUsername());
			developerAccount.setRole(pDeveloperCompanyAccount.getRole());

			if (pDeveloperCompany.getAccount().getId() == pDeveloperCompanyAccount.getAccount().getId()) {
				// this is the owner set the flag false
				developerAccount.setOwner(true);
			} else {
				developerAccount.setOwner(false);
			}

			developerAccounts.add(developerAccount);
		}

		DeveloperCompanyAccounts developers = new DeveloperCompanyAccounts();
		developers.setDeveloperCompanyAccounts(developerAccounts);

		return developers;
	}

	@Transactional
	public DeveloperServices getServices(String externalDeveloperCompanyId, Account requestingAccount, int startIndex,
			int maxItems, String requestingService) {

		logger.debug("getServices called");

		com.servinglynk.hmis.warehouse.model.live.DeveloperCompanyEntity pDeveloperCompany = daoFactory
				.getDeveloperCompanyDao().findByExternalId(externalDeveloperCompanyId);

		if (pDeveloperCompany == null) {
			throw new DeveloperCompanyNotFoundException(
					"DeveloperCompany " + externalDeveloperCompanyId + " not found");
		}

		// Check Permissions
		
		List<DeveloperServiceEntity> pServices = daoFactory.getDeveloperServiceDao()
				.findByDeveloperCompanyId(pDeveloperCompany.getId(), startIndex, maxItems);

		int count = (int) daoFactory.getDeveloperServiceDao().findCountByDeveloperCompanyId(pDeveloperCompany.getId());

		List<DeveloperService> services = new ArrayList<DeveloperService>();

		for (DeveloperServiceEntity pService : pServices) {
			DeveloperService service = DeveloperServiceConverter.convertToService(pService);
			services.add(service);
		}

		DeveloperServices serviceList = new DeveloperServices();
		serviceList.setServices(services);

		SortedPagination pagination = new SortedPagination();

		pagination.setReturned(serviceList.getServices().size());
		pagination.setFrom(startIndex);
		serviceList.setPagination(pagination);
		pagination.setTotal(count);
		return serviceList;
	}

	@Transactional
	public DeveloperCompanies getAllDeveloperCompanies(String username, String serviceStatus, String trustedAppStatus,
			Integer startIndex, Integer maxItems, String requestingService) {
		logger.debug("getAllDeveloperCompanies called");
		// Check permission
		

		List<DeveloperCompany> developerCompanies = new ArrayList<DeveloperCompany>();

		List<com.servinglynk.hmis.warehouse.model.live.DeveloperCompanyEntity> pDeveloperCompanies = daoFactory
				.getDeveloperCompanyDao().findAllDeveloperCompanies(serviceStatus, trustedAppStatus, startIndex, maxItems);

		if (pDeveloperCompanies != null) {
			for (com.servinglynk.hmis.warehouse.model.live.DeveloperCompanyEntity pDeveloperCompany : pDeveloperCompanies) {
				developerCompanies.add(DeveloperCompanyConverter.convertToDeveloperCompany(pDeveloperCompany));
			}
		}

		int developerCompaniesCount = (int) daoFactory.getDeveloperCompanyDao()
				.findAllDeveloperCompaniesCount(serviceStatus, trustedAppStatus);

		DeveloperCompanies developerCompanyList = new DeveloperCompanies();
		developerCompanyList.setDeveloperCompanys(developerCompanies);

		SortedPagination pagination = new SortedPagination();

		pagination.setReturned(developerCompanyList.getDeveloperCompanies().size());
		pagination.setFrom(startIndex);
		developerCompanyList.setPagination(pagination);
		pagination.setTotal(developerCompaniesCount);

		logger.debug("{} developerCompanies returned", developerCompanies.size());
		return developerCompanyList;
	}

	@Transactional
	public DeveloperService getService(String externalServiceId, Account requestingAccount, String requestingService) {
		logger.debug("getService called");

		com.servinglynk.hmis.warehouse.model.live.DeveloperServiceEntity pService = daoFactory.getDeveloperServiceDao()
				.findByExternalId(externalServiceId);
		if (pService == null) {
			throw new ServiceNotFoundException("Service " + externalServiceId + " not found");
		}

		
		//Check permissions

		DeveloperService service = DeveloperServiceConverter.convertToService(pService);
		return service;
	}

	@Transactional
	public DeveloperCompanyStatus processDCApprovalDecision(String developerCompanyId,
			DeveloperCompanyStatus developerCompanyStatus, Account requestingAccount, String requestingService) {
		if(ValidationUtil.isEmpty(developerCompanyStatus.getStatus()))  throw new MissingParameterException("Status is missing");
		
		if(!(developerCompanyStatus.getStatus().equals(Constants.DC_STATUS_ACTIVE) || developerCompanyStatus.getStatus().equals(Constants.DC_STATUS_REJECTED)))
			throw new InvalidParameterException("Not a valid status");
		
		DeveloperCompanyEntity pDeveloperCompany = daoFactory.getDeveloperCompanyDao().findByExternalId(developerCompanyId);
		if (pDeveloperCompany == null)	{
			throw new ServiceNotFoundException("Developer Company " + developerCompanyId + " not found");
		}
		
		if (!Constants.DC_STATUS_SUBMITTED.equals(pDeveloperCompany.getStatus()))	{
			throw new IllegalBusinessStateException("Developer Company is " + pDeveloperCompany.getStatus() + ", only SUBMITTED developoer companies can be approved");
		}
		
		if(!ValidationUtil.isValidMaxLen(developerCompanyStatus.getComment(), 512)){
			throw new InvalidParameterException("Comments can not be greater than 512 characters.");
		}
		
		com.servinglynk.hmis.warehouse.model.live.DeveloperCompanyStatus pDeveloperCompanyStatus = new com.servinglynk.hmis.warehouse.model.live.DeveloperCompanyStatus();
		pDeveloperCompanyStatus.setStatus(developerCompanyStatus.getStatus());
		pDeveloperCompanyStatus.setComments(developerCompanyStatus.getComment());
		pDeveloperCompanyStatus.setDeveloperCompany(pDeveloperCompany);
		pDeveloperCompanyStatus.setCreatedBy(requestingService);
		daoFactory.getDeveloperCompanyStatusDao().create(pDeveloperCompanyStatus);
		
		pDeveloperCompany.setStatus(developerCompanyStatus.getStatus());
		pDeveloperCompany.setModifiedBy(requestingService);
		pDeveloperCompany.setModifiedAt(new Date());
		daoFactory.getDeveloperCompanyDao().updateDeveloperCompany(pDeveloperCompany);
		return null;
	}

	@Transactional
	public DeveloperCompanies getOwnedDeveloperCompanies(String username, Account requestingAccount, String requestingService) {
		
		HmisUser hmisUser = daoFactory.getHmisUserDao().findByUsername(username);
		
		if(hmisUser ==null) throw new AccountNotFoundException(username + " not found");
		
		
		List<DeveloperCompanyEntity> developerCompanyEntities= 	daoFactory.getDeveloperCompanyDao().findByOwnerId(hmisUser.getId());
		
		DeveloperCompanies developerCompanies = new DeveloperCompanies();
		
		for(DeveloperCompanyEntity entity : developerCompanyEntities){
			developerCompanies.addDeveloperCompany(DeveloperCompanyConverter.convertToDeveloperCompany(entity));
		}
		
		return developerCompanies;
	}

}
