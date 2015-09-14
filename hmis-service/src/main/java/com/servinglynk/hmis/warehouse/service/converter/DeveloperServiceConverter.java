package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.common.ValidationUtil;
import com.servinglynk.hmis.warehouse.core.model.DeveloperService;
import com.servinglynk.hmis.warehouse.model.live.ServiceStatus;

public class DeveloperServiceConverter {
	/**
	 * Convert to {@link com.servinglynk.hmis.warehouse.model.live.DeveloperServiceEntity.hn.cs.core.model.Service}.
	 * @param pDeveloperCompany {@link com.servinglynk.hmis.warehouse.model.live.DeveloperServiceEntity.hn.cs.persistence.model.Service} to convert from
	 * @return converted {@link com.servinglynk.hmis.warehouse.model.live.DeveloperServiceEntity.hn.cs.core.model.Service}
	 */
	public static DeveloperService convertToService(com.servinglynk.hmis.warehouse.model.live.DeveloperServiceEntity pService) {
		DeveloperService service = new DeveloperService();

		service.setDescription(pService.getDescription());
		service.setFriendlyName(pService.getFriendlyName());
		service.setLicenseType(pService.getLicenseType());
		service.setServiceId(pService.getExternalId());
		service.setStatus(pService.getStatus());				return service;
	}
	
	/**
	 * Convert to {@link com.servinglynk.hmis.warehouse.model.live.DeveloperServiceEntity.hn.cs.persistence.model.Service}.
	 * 
	 * @param service {@link com.servinglynk.hmis.warehouse.model.live.DeveloperServiceEntity.hn.cs.core.model.Service} to convert from
	 * @param pService {@link com.servinglynk.hmis.warehouse.model.live.DeveloperServiceEntity.hn.cs.persistence.model.Service} to convert to
	 * @return converted {@link com.servinglynk.hmis.warehouse.model.live.DeveloperServiceEntity.hn.cs.persistence.model.Service}
	 */
	public static com.servinglynk.hmis.warehouse.model.live.DeveloperServiceEntity convertToPersistentService(DeveloperService service, com.servinglynk.hmis.warehouse.model.live.DeveloperServiceEntity pService) {		
		if (pService == null) {
			pService = new com.servinglynk.hmis.warehouse.model.live.DeveloperServiceEntity();
		}
		if (!ValidationUtil.isEmpty(service.getDescription())) {
			pService.setDescription(service.getDescription());
		}
		if (!ValidationUtil.isEmpty(service.getFriendlyName())) {
			pService.setFriendlyName(service.getFriendlyName());
		}
		if (!ValidationUtil.isEmpty(service.getLicenseType())) {
			pService.setLicenseType(service.getLicenseType());
		}
		//if (ValidationUtil.isNotNull(service.getStatus())) {
		//	pService.setStatus(service.getStatus());
		//}				return pService;
	}
	
	
	public static com.servinglynk.hmis.warehouse.core.model.ServiceStatus convertToService(ServiceStatus serviceStatus){
		com.servinglynk.hmis.warehouse.core.model.ServiceStatus status = new com.servinglynk.hmis.warehouse.core.model.ServiceStatus();
		status.setComment(serviceStatus.getComments());
		status.setService(convertToService(serviceStatus.getService()));
		status.setStatus(serviceStatus.getStatus());
		return status;
	}
}