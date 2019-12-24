package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.HmisHousehold;
import com.servinglynk.hmis.warehouse.core.model.HouseHoldMember;
import com.servinglynk.hmis.warehouse.model.v2017.HmisHouseHoldMember;


public class HmisHouseHoldConverter {

	public static HmisHousehold entityToModel(com.servinglynk.hmis.warehouse.model.v2017.HmisHousehold entity) {
		HmisHousehold model = new HmisHousehold();
		model.setHeadOfHouseHoldId(entity.getHeadOfHouseholdId());
		model.setHouseHoldId(entity.getId());
		model.setLink("/hmis-clientapi/rest/v2017/clients/"+entity.getHeadOfHouseholdId());
		for(HmisHouseHoldMember member : entity.getMembers()) {
			if(!member.isDeleted())
				model.addHouseHoldMember(HmisHouseHoldConverter.entityToModel(member));
		}
		return model;
	}
	
	public static HouseHoldMember entityToModel(HmisHouseHoldMember entity) {
		HouseHoldMember model = new HouseHoldMember();
		model.setHouseHoldId(entity.getHmisHousehold().getId());
		model.setHouseHoldMemberId(entity.getId());
		model.setMemberId(entity.getMemberId());
		model.setRelationWithHouseHold(entity.getRelationWithHouseHold());
		model.setLink("/hmis-clientapi/rest/v2017/clients/"+entity.getMemberId());		
		return model;
	}
}
