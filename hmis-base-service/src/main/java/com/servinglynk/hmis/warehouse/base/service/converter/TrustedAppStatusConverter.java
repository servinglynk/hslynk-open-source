package com.servinglynk.hmis.warehouse.base.service.converter;

import com.servinglynk.hmis.warehouse.common.ValidationUtil;
import com.servinglynk.hmis.warehouse.core.model.TrustedAppStatus;
import com.servinglynk.hmis.warehouse.model.base.TrustedAppStatusEntity;


public class TrustedAppStatusConverter {
	
	public static TrustedAppStatus convertToTrustedAppStatus(TrustedAppStatusEntity trustedAppStatusEntity) {
		TrustedAppStatus trustedAppStatus = new TrustedAppStatus();
		trustedAppStatus.setTrustedAppId(trustedAppStatusEntity.getTrustedApp().getExternalId());
		trustedAppStatus.setStatus(trustedAppStatusEntity.getStatus());
		trustedAppStatus.setComment(trustedAppStatusEntity.getComments());

		return trustedAppStatus;
	}


	public static TrustedAppStatusEntity convertToPersistentTrustedAppStatus(TrustedAppStatus trustedAppStatus,
			TrustedAppStatusEntity trustedAppStatusEntity) {
		if (trustedAppStatusEntity == null) {
			trustedAppStatusEntity = new TrustedAppStatusEntity();
		}
		if (ValidationUtil.isNotNull(trustedAppStatus.getTrustedAppId())) {
			trustedAppStatusEntity.getTrustedApp().setExternalId(trustedAppStatus.getTrustedAppId());
		}
		if (ValidationUtil.isNotNull(trustedAppStatus.getComment())) {
			trustedAppStatusEntity.setComments(trustedAppStatus.getComment());
		}
		if (ValidationUtil.isNotNull(trustedAppStatus.getStatus())) {
			trustedAppStatusEntity.setStatus(trustedAppStatus.getStatus());
		}

		return trustedAppStatusEntity;
	}
}