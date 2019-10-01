package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.VashExitReason;
import com.servinglynk.hmis.warehouse.enums.CMExitReasonEnum;

public class VashExitReasonConverter extends BaseConverter{

	  public static com.servinglynk.hmis.warehouse.model.v2020.VashExitReason modelToEntity (VashExitReason model ,com.servinglynk.hmis.warehouse.model.v2020.VashExitReason entity) {
	       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2020.VashExitReason();
	       if(model.getCmExitReason()!=null)
	    	   entity.setCmExitReason(CMExitReasonEnum.lookupEnum(model.getCmExitReason()+""));
	       if(model.getVashExitReasonId() !=null)
	    	   entity.setId(model.getVashExitReasonId());
	 
	       return entity;
	   }


	   public static VashExitReason entityToModel (com.servinglynk.hmis.warehouse.model.v2020.VashExitReason entity) {
		   VashExitReason model = new VashExitReason();
	       if(entity.getId()!=null)
	    	   model.setVashExitReasonId(entity.getId());
	       if(entity.getCmExitReason() !=null)
	    	   model.setCmExitReason(Integer.parseInt(entity.getCmExitReason().getValue()));
	       copyBeanProperties(entity, model);
	       return model;
	   }

}
