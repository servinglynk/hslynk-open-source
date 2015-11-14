package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Site;
import com.servinglynk.hmis.warehouse.enums.SitePrincipalSiteEnum;
import com.servinglynk.hmis.warehouse.enums.StateEnum;
public class SiteConverter {

   public static com.servinglynk.hmis.warehouse.model.live.Site modelToEntity (Site model ,com.servinglynk.hmis.warehouse.model.live.Site entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.live.Site();
       entity.setId(model.getSiteId());
       entity.setAddress(model.getAddress());
       entity.setCity(model.getCity());
       entity.setGeocode(model.getGeocode());
       entity.setPrincipalSite(SitePrincipalSiteEnum.valueOf(model.getPrincipalsite()));
       entity.setState(StateEnum.valueOf(model.getState()));
       entity.setZip(model.getZip());
       return entity;    
   }


   public static Site entityToModel (com.servinglynk.hmis.warehouse.model.live.Site entity) {
       Site model = new Site();
       model.setSiteId(entity.getId());
       model.setAddress(entity.getAddress());
       model.setCity(entity.getCity());
       model.setGeocode(entity.getGeocode());
       model.setPrincipalsite(entity.getPrincipalSite().name());
       model.setState(entity.getState().name());
       model.setZip(entity.getZip());
       return model;
   }


}
