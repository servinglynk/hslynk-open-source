package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Site;
import com.servinglynk.hmis.warehouse.enums.SitePrincipalSiteEnum;
import com.servinglynk.hmis.warehouse.enums.StateEnum;
public class SiteConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Site modelToEntity (Site model ,com.servinglynk.hmis.warehouse.model.v2014.Site entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Site();
       if(model.getSiteId()!=null)
       entity.setId(model.getSiteId());
       if(model.getAddress()!=null)
       entity.setAddress(model.getAddress());
       if(model.getCity()!=null)
       entity.setCity(model.getCity());
       if(model.getGeocode()!=null)
       entity.setGeocode(model.getGeocode());
       if(model.getPrincipalsite()!=null)
       entity.setPrincipalSite(SitePrincipalSiteEnum.lookupEnum(model.getPrincipalsite().toString()));
       if(model.getState()!=null)
       entity.setState(StateEnum.valueOf(model.getState()));
       if(model.getZip()!=null)
       entity.setZip(model.getZip());
       return entity;    
   }


   public static Site entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Site entity) {
       Site model = new Site();
       if(entity.getId()!=null)
       model.setSiteId(entity.getId());
       if(entity.getAddress()!=null)
       model.setAddress(entity.getAddress());
       if(entity.getCity()!=null)
       model.setCity(entity.getCity());
       if(entity.getGeocode()!=null)
       model.setGeocode(entity.getGeocode());
       if(entity.getPrincipalSite()!=null)
       model.setPrincipalsite(Integer.parseInt(entity.getPrincipalSite().getValue()));
       if(entity.getState()!=null)
       model.setState(entity.getState().name());
       if(entity.getZip()!=null)
       model.setZip(entity.getZip());
       copyBeanProperties(entity, model);
       return model;
   }


}
