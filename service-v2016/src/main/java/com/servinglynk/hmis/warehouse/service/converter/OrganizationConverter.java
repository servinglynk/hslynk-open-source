package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.Organization;
public class OrganizationConverter {

   public static com.servinglynk.hmis.warehouse.model.v2016.Organization modelToEntity (Organization model ,com.servinglynk.hmis.warehouse.model.v2016.Organization entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2016.Organization();

       entity.setOrganizationcommonname(model.getOrganizationCommonName());
       entity.setOrganizationname(model.getOrganizationName());
       return entity;
   }


   public static Organization entityToModel (com.servinglynk.hmis.warehouse.model.v2016.Organization entity) {
       Organization organization= new Organization();
       organization.setOrganizationCommonName(entity.getOrganizationcommonname());
       organization.setOrganizationId(entity.getId());
       organization.setOrganizationName(organization.getOrganizationName());
       return organization;
   }


}
