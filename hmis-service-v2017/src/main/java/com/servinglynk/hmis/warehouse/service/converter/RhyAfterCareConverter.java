package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.RhyAfterCare;
import com.servinglynk.hmis.warehouse.core.model.VashExitReason;
import com.servinglynk.hmis.warehouse.enums.NoYesEnum;

public class RhyAfterCareConverter extends BaseConverter {

	  public static com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare modelToEntity (RhyAfterCare model ,com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare entity) {
	       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare();
	       if(model.getAfterCareDate()!=null)
	    	   entity.setAfterCareDate(model.getAfterCareDate());
	       if(model.getAfterProvided() !=null)
	    	   entity.setAfterProvided(NoYesEnum.lookupEnum(String.valueOf(model.getAfterProvided())));
	       if(model.getEmailSocialMedia() !=null)
	    	   entity.setEmailSocialMedia(NoYesEnum.lookupEnum(String.valueOf(model.getEmailSocialMedia())));
	       if(model.getInPersonGroup() !=null)
	    	   entity.setInPersonGroup(NoYesEnum.lookupEnum(String.valueOf(model.getInPersonGroup())));
	       if(model.getInPersonIndividual() !=null)
	    	   entity.setInPersonGroup(NoYesEnum.lookupEnum(String.valueOf(model.getInPersonIndividual())));
	       if(model.getRhyAfterCareId() !=null)
	    	   entity.setId(model.getRhyAfterCareId());
	       if(model.getTelephone() !=null)
	    	   entity.setTelephone(NoYesEnum.lookupEnum(String.valueOf(model.getTelephone())));
	       return entity;
	   }


	   public static VashExitReason entityToModel (com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason entity) {
		   VashExitReason model = new VashExitReason();
	       if(entity.getId()!=null)
	    	   model.setVashExitReasonId(entity.getId());
	       if(entity.getCmExitReason() !=null)
	    	   model.setCmExitReason(Integer.parseInt(entity.getCmExitReason().getValue()));
	       copyBeanProperties(entity, model);
	       return model;
	   }
}
