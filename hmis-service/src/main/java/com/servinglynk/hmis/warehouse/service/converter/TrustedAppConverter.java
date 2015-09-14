package com.servinglynk.hmis.warehouse.service.converter;


import com.servinglynk.hmis.warehouse.common.ValidationUtil;
import com.servinglynk.hmis.warehouse.core.model.DeveloperCompany;
import com.servinglynk.hmis.warehouse.core.model.DeveloperService;
import com.servinglynk.hmis.warehouse.core.model.TrustedApp;
import com.servinglynk.hmis.warehouse.model.live.TrustedAppEntity;


public class TrustedAppConverter {
	
	public static TrustedApp convertToTrustedAppComplete(TrustedAppEntity trustedAppEntity, String logoPath) {
		
		TrustedApp trustedApp = convertToTrustedApp(trustedAppEntity, logoPath);
		

		if (!ValidationUtil.isEmpty(trustedApp.getVersion())) {
			trustedAppEntity.setVersion(trustedApp.getVersion());
		}

		if (!ValidationUtil.isEmpty(trustedApp.getPublishStatus())) {
			trustedAppEntity.setPublishStatus(trustedApp.getPublishStatus());
		}

		if (trustedApp.getLastReleasedAt() !=null) {
			trustedAppEntity.setLastReleasedAt(trustedApp.getLastReleasedAt());
		}
		
		
		
	
		return trustedApp;
	
	}
	
	public static TrustedApp convertToTrustedAppPlain(TrustedAppEntity trustedAppEntity, String logoPath) {
		TrustedApp trustedApp = new TrustedApp();
		trustedApp.setTrustedAppId(trustedAppEntity.getExternalId());
		trustedApp.setFriendlyName(trustedAppEntity.getFriendlyname());
		trustedApp.setDescription(trustedAppEntity.getDescription());
		
		trustedApp.setNotificationCallbackUrl(trustedAppEntity.getNotificationCallbackUrl());
		trustedApp.setStatus(trustedAppEntity.getStatus());

		trustedApp.setTrustedAppProfileType(trustedAppEntity.getTrustedAppProfileType());
		trustedApp.setTrustedAppFamilyType(trustedAppEntity.getTrustedAppFamilyType());

		trustedApp.setPublishStatus(trustedAppEntity.getPublishStatus());
		if (null != trustedAppEntity.getLastReleasedAt()) trustedApp.setLastReleasedAt(trustedAppEntity.getLastReleasedAt());
		
		trustedApp.setDownloadUrl(trustedAppEntity.getDownloadUrl());
	
		if (!ValidationUtil.isEmpty(trustedApp.getVersion())) {
			trustedAppEntity.setVersion(trustedApp.getVersion());
		}

		if (!ValidationUtil.isEmpty(trustedApp.getPublishStatus())) {
			trustedAppEntity.setPublishStatus(trustedApp.getPublishStatus());
		}

		if (trustedApp.getLastReleasedAt() !=null) {
			trustedAppEntity.setLastReleasedAt(trustedApp.getLastReleasedAt());
		}
		
		trustedApp.setLogoUrl(trustedAppEntity.getLogoUrl());
		String cLogo = trustedApp.getLogoUrl();
		if (cLogo != null && cLogo.length() == 36) {
			trustedApp.setLogoUrl(logoPath + cLogo); 
		}
		
		return trustedApp;
	}
	

	public static TrustedApp convertToTrustedApp(TrustedAppEntity trustedAppEntity, String logoPath) {
		TrustedApp trustedApp = convertToTrustedAppPlain(trustedAppEntity, logoPath);
		
		if (trustedAppEntity.getService() != null)	{
			DeveloperService service = new DeveloperService();
			service.setServiceId(trustedAppEntity.getService().getExternalId());
			
			if (trustedAppEntity.getService().getDeveloperCompany() != null)	{
				DeveloperCompany developerCompany = DeveloperCompanyConverter.convertToDeveloperCompany(trustedAppEntity.getService().getDeveloperCompany());
				service.setDeveloperCompany(developerCompany);
			}
			
			trustedApp.setService(service);
		}
		
		return trustedApp;
	}
	

	public static TrustedApp convertToTrustedAppFull(TrustedAppEntity trustedAppEntity, String logoPath, String trustedAppScreenShotPath) {
		TrustedApp trustedApp = convertToTrustedAppPlain(trustedAppEntity, logoPath);
		
		trustedApp.setTrustedAppSecret(trustedAppEntity.getTrustedAppSecret());
		trustedApp.setTrustedAppProfileType(trustedAppEntity.getTrustedAppProfileType());
		trustedApp.setTrustedAppFamilyType(trustedAppEntity.getTrustedAppFamilyType());
		trustedApp.setRefreshTokenSupported(trustedAppEntity.isRefreshTokenSupported());
		trustedApp.setImplicitGrantSupported(trustedAppEntity.isImplicitGrantSupported());
		trustedApp.setAuthCodeGrantSupported(trustedAppEntity.isAuthCodeGrantSupported());
		trustedApp.setStatus(trustedAppEntity.getStatus());
		trustedApp.setDescription(trustedAppEntity.getDescription());
		trustedApp.setFriendlyName(trustedAppEntity.getFriendlyname());
		trustedApp.setVersion(trustedAppEntity.getVersion());
		
		trustedApp.setPublishStatus(trustedAppEntity.getPublishStatus());
		if (null != trustedAppEntity.getLastReleasedAt()) trustedApp.setLastReleasedAt(trustedAppEntity.getLastReleasedAt());
		
		trustedApp.setDownloadUrl(trustedAppEntity.getDownloadUrl());
	
		trustedApp.setNotificationCallbackUrl(trustedAppEntity.getNotificationCallbackUrl());

		if (!ValidationUtil.isEmpty(trustedApp.getVersion())) {
			trustedAppEntity.setVersion(trustedApp.getVersion());
		}

		if (!ValidationUtil.isEmpty(trustedApp.getPublishStatus())) {
			trustedAppEntity.setPublishStatus(trustedApp.getPublishStatus());
		}

		if (trustedApp.getLastReleasedAt() !=null) {
			trustedAppEntity.setLastReleasedAt(trustedApp.getLastReleasedAt());
		}
		
		if(trustedAppEntity.getLogoUrl() != null){
			trustedApp.setLogoUrl(logoPath + trustedAppEntity.getLogoUrl());
		}
		
	
		
		return trustedApp;
	}
	

	public static com.servinglynk.hmis.warehouse.model.live.TrustedAppEntity convertToPersistentTrustedApp(TrustedApp trustedApp,TrustedAppEntity trustedAppEntity) {
		
		if (trustedAppEntity == null) {
			trustedAppEntity = new com.servinglynk.hmis.warehouse.model.live.TrustedAppEntity();
		}
		if (!ValidationUtil.isEmpty(trustedApp.getTrustedAppId())) {
			trustedAppEntity.setExternalId(trustedApp.getTrustedAppId());
		}
		if (!ValidationUtil.isEmpty(trustedApp.getDescription())) {
			trustedAppEntity.setDescription(trustedApp.getDescription());
		}
		if (!ValidationUtil.isEmpty(trustedApp.getFriendlyName())) {
			trustedAppEntity.setFriendlyname(trustedApp.getFriendlyName());
		}
		if (!ValidationUtil.isEmpty(trustedApp.getLogoUrl())) {
			trustedAppEntity.setLogoUrl(trustedApp.getLogoUrl().substring(trustedAppEntity.getLogoUrl().length()-36)); 
		}
		if (!ValidationUtil.isEmpty(trustedApp.getStatus())) {
			trustedAppEntity.setStatus(trustedApp.getStatus());
		}
		
		return trustedAppEntity;
	}
}
