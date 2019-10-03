package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.Geography;
import com.servinglynk.hmis.warehouse.enums.GeographyTypeEnum;

public class GeographyConverter extends BaseConverter {
	public static com.servinglynk.hmis.warehouse.model.v2020.Geography modelToEntity (Geography model ,com.servinglynk.hmis.warehouse.model.v2020.Geography entity) {
	       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2020.Geography();
	       if(model.getAddress1()!=null)
	       entity.setAddress1(model.getAddress1());
	       if(model.getAddress2() !=null)
	    	   entity.setAddress2(model.getAddress2());
	       if(model.getCity()!=null)
	    	   entity.setCity(model.getCity());
	       if(model.getGeoCode() !=null)
	    	   entity.setGeoCode(model.getGeoCode());
	       if(model.getGeographyType() !=null)
	    	   entity.setGeographyType(GeographyTypeEnum.lookupEnum(model.getGeographyType()));
	       if(model.getId() !=null)
	    	   entity.setId(model.getId());
	       if(model.getInformationDate() !=null)
	    	   entity.setInformationDate(model.getInformationDate());
	       if(model.getState() !=null)
	    	   entity.setState(model.getState());
	       if(model.getZip() !=null)
	    	   entity.setZip(model.getZip());
	       if(model.getCocCode() != null)
	    	    entity.setCoccode(model.getCocCode());
	       return entity;
	   }


	   public static Geography entityToModel (com.servinglynk.hmis.warehouse.model.v2020.Geography entity) {
	       Geography model = new Geography();
	       if(entity.getId()!=null)
	       model.setId(entity.getId());
	       if(entity.getAddress1() !=null)
	    	   model.setAddress1(entity.getAddress1());
	       if(entity.getAddress2() !=null)
	    	   model.setAddress2(entity.getAddress2());
	       if(entity.getCity() !=null)
	    	   model.setCity(entity.getCity());
	       if(entity.getDateCreatedFromSource() !=null)
	    	   model.setDateCreated(entity.getDateCreatedFromSource());
	       if(entity.getGeoCode() !=null)
	    	   model.setGeoCode(entity.getGeoCode());
	       if(entity.getGeographyType() !=null)
	    	   model.setGeographyType(entity.getGeographyType().getValue());
	       if(entity.getId() !=null)
	    	   model.setId(entity.getId());
	       if(entity.getInformationDate() !=null)
	    	   model.setInformationDate(entity.getInformationDate());
	       if(entity.getZip() !=null)
	    	   model.setZip(entity.getZip());
	       if(entity.getState() !=null)
	    	   model.setState(entity.getState());
	       if(entity.getCoccode() != null)
	    	    model.setCocCode(entity.getCoccode());
	       copyBeanProperties(entity, model);
	       return model;
	   }

}
