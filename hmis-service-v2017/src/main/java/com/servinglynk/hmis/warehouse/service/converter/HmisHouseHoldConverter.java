package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.HmisHousehold;
import com.servinglynk.hmis.warehouse.core.model.HouseHoldMember;
import com.servinglynk.hmis.warehouse.model.v2017.HmisHouseHoldMember;


public class HmisHouseHoldConverter {

	public static HmisHousehold entityToModel(com.servinglynk.hmis.warehouse.model.v2017.HmisHousehold entity) {
		HmisHousehold model = new HmisHousehold();
		model.setHeadOfHouseHold(ClientConverter.entityToModel(entity.getHeadOfHousehold()));
		model.setHouseHoldId(entity.getId());
		model.addLink(new ActionLink("enrollments", "/hmis-clientapi/rest/v2017/clients/"+entity.getHeadOfHousehold().getId()+"/enrollments"));
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
		model.setMember(ClientConverter.entityToModel(entity.getMember()));
		model.setRelationWithHouseHold(entity.getRelationWithHouseHold());
		model.addLink(new ActionLink("enrollments", "/hmis-clientapi/rest/v2017/clients/"+entity.getMember().getId()+"/enrollments"));
		return model;
	}
}
