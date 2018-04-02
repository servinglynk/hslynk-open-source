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


	   public static RhyAfterCare entityToModel (com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare entity) {
		   RhyAfterCare model = new RhyAfterCare();
		   model.setDateCreated(entity.getDateCreated());
		   model.setDateUpdated(entity.getDateUpdated());
	       if(entity.getId()!=null)
	    	   model.setRhyAfterCareId(entity.getId());
	       if(entity.getAfterCareDate() !=null)
	    	   model.setAfterCareDate(entity.getAfterCareDate());
	       if(entity.getAfterProvided() !=null)
	    	   model.setAfterProvided(Integer.parseInt(entity.getAfterProvided().getValue()));
	       if(entity.getEmailSocialMedia() !=null)
	    	   model.setEmailSocialMedia(Integer.parseInt(entity.getEmailSocialMedia().getValue()));
	       if(entity.getInPersonGroup() !=null)
	    	   model.setInPersonGroup(Integer.parseInt(entity.getInPersonGroup().getValue()));
	       if(entity.getInPersonIndividual()!=null)
	    	   model.setInPersonIndividual(Integer.parseInt(entity.getInPersonIndividual().getValue()));
	       if(entity.getTelephone() !=null)
	    	   model.setTelephone(Integer.parseInt(entity.getTelephone().getValue()));
	       copyBeanProperties(entity, model);
	       return model;
	   }
}
