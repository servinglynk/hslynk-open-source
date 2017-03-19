package com.servinglynk.hmis.warehouse.base.service.converter;

import com.servinglynk.hmis.warehouse.common.ValidationUtil;
import com.servinglynk.hmis.warehouse.core.model.DeveloperService;
import com.servinglynk.hmis.warehouse.model.base.ServiceStatus;

public class DeveloperServiceConverter {

	public static DeveloperService convertToService(com.servinglynk.hmis.warehouse.model.base.DeveloperServiceEntity pService) {
		DeveloperService service = new DeveloperService();

		service.setDescription(pService.getDescription());
		service.setFriendlyName(pService.getFriendlyName());
		service.setLicenseType(pService.getLicenseType());
		service.setServiceId(pService.getExternalId());
		service.setStatus(pService.getStatus());				return service;
	}
	
	
	public static com.servinglynk.hmis.warehouse.model.base.DeveloperServiceEntity convertToPersistentService(DeveloperService service, com.servinglynk.hmis.warehouse.model.base.DeveloperServiceEntity pService) {		
		if (pService == null) {
			pService = new com.servinglynk.hmis.warehouse.model.base.DeveloperServiceEntity();
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