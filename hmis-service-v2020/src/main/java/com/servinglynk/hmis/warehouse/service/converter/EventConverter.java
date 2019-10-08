package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.Event;
import com.servinglynk.hmis.warehouse.enums.EventTypeEnum;
import com.servinglynk.hmis.warehouse.enums.NoYesEnum;

public class EventConverter  extends BaseConverter {

	   public static com.servinglynk.hmis.warehouse.model.v2020.Event modelToEntity (Event model ,com.servinglynk.hmis.warehouse.model.v2020.Event entity) {
	       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2020.Event();
	       entity.setId(model.getEventId());
	       entity.setEvent(EventTypeEnum.lookupEnum(model.getEvent()));
	       entity.setEventDate(model.getEventDate());
	       entity.setLocationcrisisorphhousing(model.getLocationcrisisorphhousing());
	       entity.setReferralCaseManageAfter(NoYesEnum.lookupEnum(model.getLocationcrisisorphhousing()));
	       entity.setReferralResult(model.getReferralResult());
	       entity.setResultDate(model.getResultDate());
	    
	       return entity;
	   }


	   public static Event entityToModel (com.servinglynk.hmis.warehouse.model.v2020.Event entity) {
	       Event model = new Event();
	       model.setEventId(entity.getId());
	       model.setEvent(entity.getEvent().getValue());
	       model.setEventDate(model.getEventDate());
	       model.setLocationcrisisorphhousing(entity.getLocationcrisisorphhousing());
	       model.setReferralCaseManageAfter(entity.getLocationcrisisorphhousing());
	       model.setReferralResult(entity.getReferralResult());
	       model.setResultDate(entity.getResultDate());
	       if(entity.getEnrollmentid() != null)
	    	   model.setEnrollmentid(entity.getEnrollmentid().getId());
	       
	       return model;
	   }


	}
