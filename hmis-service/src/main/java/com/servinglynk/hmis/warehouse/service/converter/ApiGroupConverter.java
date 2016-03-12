package com.servinglynk.hmis.warehouse.service.converter;
import com.servinglynk.hmis.warehouse.common.ValidationUtil;
import com.servinglynk.hmis.warehouse.core.model.ApiGroup;
import com.servinglynk.hmis.warehouse.model.v2014.ApiGroupEntity;

public class ApiGroupConverter {

	public static ApiGroup convertToApiGroup(ApiGroupEntity pApiGroup) {
		
		ApiGroup apiGroup = new ApiGroup();
		apiGroup.setAuthorizationMsg(pApiGroup.getAuthorizationMsg());
		apiGroup.setDescription(pApiGroup.getDescription());
		apiGroup.setExternalId(pApiGroup.getExternalId());
		apiGroup.setFriendlyName(pApiGroup.getFriendlyName());
		apiGroup.setGroupSequence(pApiGroup.getGroupSequence());
		
		return apiGroup;
	}
	
	public static ApiGroupEntity convertToPersistentApiGroup(ApiGroup apiGroup, ApiGroupEntity pApiGroup) {		
		if (pApiGroup == null) {
			pApiGroup = new ApiGroupEntity();
		}
		if (ValidationUtil.isNotNull(apiGroup.getAuthorizationMsg())) {
			pApiGroup.setAuthorizationMsg(apiGroup.getAuthorizationMsg());
		}
		if (ValidationUtil.isNotNull(apiGroup.getDescription())) {
			pApiGroup.setDescription(apiGroup.getDescription());
		}
		if (ValidationUtil.isNotNull(apiGroup.getExternalId())) {
			pApiGroup.setExternalId(apiGroup.getExternalId());
		}
		if (ValidationUtil.isNotNull(apiGroup.getFriendlyName())) {
			pApiGroup.setFriendlyName(apiGroup.getFriendlyName());
		}
		if (ValidationUtil.isNotNull(apiGroup.getGroupSequence())) {
			pApiGroup.setGroupSequence(apiGroup.getGroupSequence());
		}
				return pApiGroup;
	}
}