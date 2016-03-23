package com.servinglynk.hmis.warehouse.base.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Organization;
import com.servinglynk.hmis.warehouse.core.model.Organizations;
public interface OrganizationService {

   Organization createOrganization(Organization organization,String caller);
   Organization updateOrganization(Organization organization,String caller);
   Organization deleteOrganization(UUID organizationId,String caller);
   Organization getOrganizationById(UUID organizationId);
   Organizations getAllOrganizations(Integer startIndex, Integer maxItems);
}
