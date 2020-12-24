package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.Event;
import com.servinglynk.hmis.warehouse.enums.EventTypeEnum;
import com.servinglynk.hmis.warehouse.enums.NoYesEnum;

public class EventConverter  extends BaseConverter {

	   public static com.servinglynk.hmis.warehouse.model.v2020.Event modelToEntity (Event model ,com.servinglynk.hmis.warehouse.model.v2020.Event entity) {
	       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2020.Event();
	       entity.setId(model.getEventId());
	       if(model.getEvent() !=null)
	    	   entity.setEvent(EventTypeEnum.lookupEnum(model.getEvent()));
	       entity.setEventDate(model.getEventDate());
	       entity.setLocationcrisisorphhousing(model.getLocationcrisisorphhousing());
	       if(model.getLocationcrisisorphhousing() !=null)
	    	   entity.setReferralCaseManageAfter(NoYesEnum.lookupEnum(model.getLocationcrisisorphhousing()));
	       entity.setReferralResult(model.getReferralResult());
	       entity.setResultDate(model.getResultDate());
	       if(model.getProbsoldivrrresult() !=null)
	    	   entity.setProbsoldivrrresult(NoYesEnum.lookupEnum(model.getProbsoldivrrresult()));
	       return entity;
	   }


	   public static Event entityToModel (com.servinglynk.hmis.warehouse.model.v2020.Event entity) {
	       Event model = new Event();
	       model.setEventId(entity.getId());
	       if(entity.getEvent() !=null)
	    	   model.setEvent(entity.getEvent().getValue());
	       model.setEventDate(model.getEventDate());
	       model.setLocationcrisisorphhousing(entity.getLocationcrisisorphhousing());
	       if(entity.getReferralCaseManageAfter() != null)
	       model.setReferralCaseManageAfter(entity.getReferralCaseManageAfter().getValue());
	       model.setReferralResult(entity.getReferralResult());
	       model.setResultDate(entity.getResultDate());
	       if(entity.getProbsoldivrrresult() != null)
	       model.setProbsoldivrrresult(entity.getProbsoldivrrresult().getValue());
	       if(entity.getEnrollmentid() != null)
	    	   model.setEnrollmentid(entity.getEnrollmentid().getId());
	       
	       return model;
	   }


	}
